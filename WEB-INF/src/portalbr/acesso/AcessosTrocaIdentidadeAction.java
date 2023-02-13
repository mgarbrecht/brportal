package portalbr.acesso;

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
 * Creation Date 12/12/2017 12:43:18
 * Last Modify Date 14/12/2017 11:42:41
 */

public class AcessosTrocaIdentidadeAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcessosTrocaIdentidadeActionForm f = (AcessosTrocaIdentidadeActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/acesso/AcessosTrocaIdentidade_rGrid.do?select_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AcessosTrocaIdentidadeActionForm f = (AcessosTrocaIdentidadeActionForm) form;
    Jw_acessos_troca_identidade table = new Jw_acessos_troca_identidade();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"atid_usua_id","=", com.egen.util.text.FormatNumber.toInt(f.getAtid_usua_id())}, {"usua_nome","like", f.getUsua_nome()}, {"atid_tien_id","=", com.egen.util.text.FormatNumber.toInt(f.getAtid_tien_id())}, {"tien_tipo","like", f.getTien_tipo()} };
    //session.setAttribute("where_acessos_troca_identidade", where);
    Vector res_Jw_acessos_troca_identidade = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acessos_troca_identidade",res_Jw_acessos_troca_identidade);
    if (!(res_Jw_acessos_troca_identidade != null && res_Jw_acessos_troca_identidade.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AcessosTrocaIdentidadeActionForm f = (AcessosTrocaIdentidadeActionForm) form;
      session.removeAttribute("res_Jw_acessos_troca_identidade");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcessosTrocaIdentidadeActionForm f = (AcessosTrocaIdentidadeActionForm) form;


      actionForward = new ActionForward("/acesso/AcessosTrocaIdentidade_iForm.do?resetfull_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
}
