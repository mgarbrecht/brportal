package portalbr.adm;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/08/2006 15:35:54
 * Last Modify Date 24/08/2017 10:35:39
 */

public class AnaliseCreditoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      AnaliseCreditoActionForm f = (AnaliseCreditoActionForm) form;
      if (f.getGre_grupo().equals("") && f.getCli_cdgo().equals("")) {
        throw new Exception("O Cliente ou o Grupo devem ser informados!");
      }
      j = new com.egen.util.jdbc.JdbcUtil();
      //------- verifica o cliente ----------
      StringBuilder parametros = new StringBuilder();
      String codigo_regional = "";
      String codigo_representante = "";
      String tipo = "";

      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("REGIONAL DE VENDA")) {
          codigo_regional = ent.getChave() + "";
        }
        if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
          codigo_representante = ent.getChave() + "";
        }
      }

      if (!codigo_regional.equals("")) {
        parametros.append(" and r.codigo_regional = ").append(codigo_regional);
      }
      if (!codigo_representante.equals("")) {
        parametros.append(" and cr.codigo_representante = ").append(codigo_representante);
      }
      if (f.getCli_cdgo() != "") {
        parametros.append(" and c.cli_cdgo = ").append(f.getCli_cdgo());
      }
      if (f.getClientes() != "") {
        parametros.append(" and c.cli_cdgo in (").append(f.getClientes().replace("x","")).append(") ");
      }
      if (f.getGre_grupo() != "") {
        parametros.append("    AND c.cli_cdgo IN (SELECT gre.cli_cdgo ");
        parametros.append("                           FROM grupo_economico gre ");
        parametros.append("                          WHERE gre.gre_grupo = " + f.getGre_grupo());
        parametros.append("                            AND gre.status = 'A') ");
      }

      portalbr.dbobj.view.Jw_analise_clientes table_clientes = new portalbr.dbobj.view.Jw_analise_clientes();
      StringBuilder query = new StringBuilder();
      query.append(" SELECT r.codigo_regional ");
      query.append("      , cr.codigo_representante ");
      query.append("      , e.cli_cdgo ");
      query.append("      , e.esc_seqn ");
      query.append("   FROM cli c ");
      query.append("      , esc e ");
      query.append("      , cliente_representante cr ");
      query.append("      , rep r ");
      query.append("  WHERE c.cli_cdgo               = e.cli_cdgo ");
      query.append("    AND cr.codigo_representante  = r.rep_cdgo ");
      query.append("    AND cr.codigo_cliente (+)    = c.cli_cdgo ");
      query.append("    AND c.cli_cdgo               = e.cli_cdgo ");

      query.append(parametros.toString());

      Vector res_Jw_analise_clientes = j.select(table_clientes, query.toString(), null);

      if (res_Jw_analise_clientes != null && res_Jw_analise_clientes.size() == 0) {
        throw new Exception("Nenhum registro encontrado!");
      }

      //-------------------------------------

      if (f.getClientes() != "") {
        StringBuilder sb = new StringBuilder();
        sb.append("/adm/AnaliseCredito_dForm.do?execute_action=&p_clientes=").append(f.getClientes().replace("x","'"));
        sb.append("&p_meses_atras=").append(f.getMeses());
        sb.append("&p_emp=").append(f.getEmp_empresa());
        sb.append("&emp_empresa=").append(f.getEmp_empresa());
        sb.append("&gre_grupo=").append(f.getGre_grupo());
        actionForward = new ActionForward(sb.toString(), true);

      } else {
        if (f.getCli_cdgo() != "") {
          StringBuilder sb = new StringBuilder();
          sb.append("/adm/AnaliseCredito_dForm.do?execute_action=&p_cli_cdgo=").append(f.getCli_cdgo());
          sb.append("&p_meses_atras=").append(f.getMeses());
          sb.append("&p_emp=").append(f.getEmp_empresa());
          sb.append("&emp_empresa=").append(f.getEmp_empresa());
          sb.append("&cli_cdgo=").append(f.getCli_cdgo());
          actionForward = new ActionForward(sb.toString(), true);
        }
      }
      if (f.getGre_grupo() != "" && f.getClientes().equals("") && f.getCli_cdgo().equals("")) {
        StringBuilder clientes_grupo = new StringBuilder();
        portalbr.dbobj.view.Jw_clientes_grupos_economicos table = new portalbr.dbobj.view.Jw_clientes_grupos_economicos();
        String[][] select = null;
        Object[][] where = { {"Gre_grupo","like", f.getGre_grupo()}};
        Vector res_Jw_clientes_grupos_economicos = j.select(table, select, where, null, null, null);
        if (res_Jw_clientes_grupos_economicos != null && res_Jw_clientes_grupos_economicos.size() > 0) {
          for (int x = 0; x < res_Jw_clientes_grupos_economicos.size(); x++) {
            portalbr.dbobj.view.Jw_clientes_grupos_economicos r = (portalbr.dbobj.view.Jw_clientes_grupos_economicos) res_Jw_clientes_grupos_economicos.elementAt(x);
            if (clientes_grupo.length() == 0) {
              clientes_grupo.append("'").append(r.getCli_cdgo()).append("'");
            } else {
              clientes_grupo.append(",'").append(r.getCli_cdgo()).append("'");
            }
          }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/adm/AnaliseCredito_dForm.do?execute_action=&p_clientes=").append(clientes_grupo.toString());
        sb.append("&p_meses_atras=").append(f.getMeses());
        sb.append("&p_emp=").append(f.getEmp_empresa());
        sb.append("&emp_empresa=").append(f.getEmp_empresa());
        sb.append("&gre_grupo=").append(f.getGre_grupo());

        actionForward = new ActionForward(sb.toString(), true);

      }

    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }

    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      form.reset(mapping, request);
      session.removeAttribute("clientes_grupo");
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AnaliseCreditoActionForm f = (AnaliseCreditoActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("AnaliseCreditoActionForm", form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


}
