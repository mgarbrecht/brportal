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
 * Creation Date 03/04/2006 15:15:12
 * Last Modify Date 02/07/2019 10:47:08
 */

public class CadastroClientesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 03/04/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_clientes_cad,
    //                     e redireciona para a tela de relatório com os registros selecionados:
    //                     /adm/CadastroClientes_rForm.jsp
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      portalbr.dbobj.view.Jw_clientes_cad t_jw_clientes_cad = new portalbr.dbobj.view.Jw_clientes_cad();
      java.util.Vector res_Jw_clientes_cad = (java.util.Vector) session.getAttribute("res_Jw_clientes_cad");
      if (res_Jw_clientes_cad != null && res_Jw_clientes_cad.size() == 1) {
        t_jw_clientes_cad = (portalbr.dbobj.view.Jw_clientes_cad) res_Jw_clientes_cad.elementAt(0);
        StringBuilder path = new StringBuilder();
        path.append("/adm/CadastroClientes_dForm.do?select_action=&cli_cdgo=").append(t_jw_clientes_cad.getCli_cdgo());
        path.append("&esc_seqn=").append(t_jw_clientes_cad.getEsc_seqn());
        actionForward = new ActionForward(path.toString(), true);

      } else {
        actionForward = new ActionForward("/adm/CadastroClientes_rForm.jsp",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_cad", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
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
    CadastroClientesActionForm f = (CadastroClientesActionForm) form;
    StringBuilder parametros = new StringBuilder();

    if ((f.getCli_cdgo().equals("")) && (f.getCli_rzao().equals("")) && (f.getEsc_email().equals("")) && (f.getEsc_cgc().equals("")) && (f.getCli_nome().equals(""))) {
      throw new Exception("Um dos parâmetros deve ser informado!");
    }
    if (!f.getCli_rzao().equals("")) {
      parametros.append(" and a.cli_rzao like upper('").append(f.getCli_rzao()).append("') ");
    }
    if (!f.getCli_nome().equals("")) {
      parametros.append(" and a.cli_nome like upper('").append(f.getCli_nome()).append("') ");
    }
    if (!f.getCli_cdgo().equals("")) {
      parametros.append(" and a.cli_cdgo = ").append(f.getCli_cdgo());
    }
    if (!f.getEsc_seqn().equals("")) {
      parametros.append(" and b.esc_seqn = ").append(f.getEsc_seqn());
    }
    if (!f.getEsc_cgc().equals("")) {
      try {
        Long.parseLong(f.getEsc_cgc());
        parametros.append(" and b.esc_cgc = ").append(Long.parseLong(f.getEsc_cgc()));
      } catch (java.lang.NumberFormatException e) {
        parametros.append(" and b.esc_cgc like '").append(f.getEsc_cgc()).append("'");
      }
    }
    if (!f.getRepresentante().equals("")) {
      parametros.append(" and r.rep_cdgo = ").append(f.getRepresentante());
    }
    if (!f.getRegional().equals("")) {
      parametros.append(" and rv.codigo_regional = ").append(f.getRegional());
    }
    if (!f.getEsc_email().equals("")) {
      parametros.append(" and lower(b.esc_email) like lower('").append(f.getEsc_email()).append("') ");
    }

    portalbr.dbobj.view.Jw_clientes_cad table = new portalbr.dbobj.view.Jw_clientes_cad();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT /*+ all_rows */ ");
    query.append("        DISTINCT ");
    query.append("        cli_rzao ");
    query.append("      , cli_nome ");
    query.append("      , c.est_unifed ");
    query.append("      , ecl_cdad ");
    query.append("      , b.esc_seqn ");
    query.append("      , a.cli_cdgo ");
    query.append("      , b.esc_cgc ");
    query.append("   FROM cli                     a ");
    query.append("      , esc                     b ");
    query.append("      , ecl                     c ");
    query.append("      , cliente_representante   cr");
    query.append("      , rep                     r ");
    query.append("      , regionais_vendas        rv ");
    query.append("  WHERE b.esc_seqn              = c.esc_seqn           ");
    query.append("    AND rv.codigo_regional      = r.codigo_regional    ");
    query.append("    AND a.cli_cdgo              = b.cli_cdgo           ");
    query.append("    AND b.cli_cdgo              = c.cli_cdgo           ");
    query.append("    AND b.cli_cdgo              = cr.codigo_cliente    ");
    query.append("    AND b.esc_seqn              = cr.codigo_sequencial ");
    query.append("    AND (c.ned_cdgo = 'UNI' or c.ned_cdgo = 'ENT')     ");
    query.append("    AND cr.codigo_representante = r.rep_cdgo           ");
    query.append(parametros.toString());
    query.append("  ORDER BY cli_rzao ");
    query.append("         , cli_cdgo ");
    query.append("         , b.esc_seqn ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(query.toString());
    }

    if (false) {
      throw new Exception(query.toString());
    }

    Vector res_Jw_clientes_cad = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_clientes_cad",res_Jw_clientes_cad);
    if (!(res_Jw_clientes_cad != null && res_Jw_clientes_cad.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CadastroClientesActionForm f = (CadastroClientesActionForm) form;
      session.removeAttribute("res_Jw_clientes_cad");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_cad", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
