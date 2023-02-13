package portalbr.lov;

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
 * Creation Date 20/03/2006 09:28:35
 * Last Modify Date 04/04/2013 08:13:38
 */

public class LvClienteSeqAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    LvClienteSeqActionForm f = (LvClienteSeqActionForm) form;
    StringBuilder cliente = new StringBuilder();
    if (f.getCli_cdgo() != "") {
      cliente.append(" and a.cli_cdgo = "+f.getCli_cdgo());
    }
    String tipo = "";
    StringBuilder parametros = new StringBuilder();
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        parametros.append(" and r.codigo_regional = "+ent.getChave());
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        parametros.append(" and r.rep_cdgo = '"+ent.getChave() + ""+"' ");
      }

    }


    portalbr.dbobj.view.Jw_lv_clientes table = new portalbr.dbobj.view.Jw_lv_clientes();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT distinct ");
    query.append("        b.reg_cdgo, ");
    query.append("        a.cli_cdgo||' - '||b.esc_seqn codigo, ");
    query.append("        a.cli_rzao,  ");
    query.append("        ecl_cdad||'-'||c.est_unifed cid_est,  ");
    query.append("        b.esc_seqn, ");
    query.append("        b.cli_cdgo ");
    query.append("   FROM cli a, ");
    query.append("        esc b, ");
    query.append("        ecl c, ");
    query.append("        cliente_representante cr, ");
    query.append("        rep r ");
    query.append("  WHERE b.esc_seqn = c.esc_seqn ");
    query.append("    AND a.cli_cdgo = b.cli_cdgo ");
    query.append("    AND b.cli_cdgo = c.cli_cdgo ");
    query.append("    AND (c.ned_cdgo = 'UNI' or c.ned_cdgo = 'ENT') ");
    query.append("    AND a.cli_rzao like upper('").append(f.getCli_rzao()).append("') ");
    query.append("    AND a.cli_cdgo > 0 ");
    query.append(cliente.toString());
    query.append("    AND cr.codigo_cliente (+) = a.cli_cdgo ");
    query.append("    AND cr.codigo_representante = r.rep_cdgo (+) ");
    query.append(parametros);

    Vector res_Jw_lv_clientes = j.select(table, query.toString(), null);


    session.setAttribute("res_Jw_lv_clientes",res_Jw_lv_clientes);
    if (res_Jw_lv_clientes == null || res_Jw_lv_clientes.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_clientes", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvClienteSeqActionForm f = (LvClienteSeqActionForm) form;
      session.removeAttribute("res_Jw_lv_clientes");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
