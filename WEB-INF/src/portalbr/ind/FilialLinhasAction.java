package portalbr.ind;

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
 * Creation Date 08/09/2006 15:12:36
 * Last Modify Date 18/12/2014 08:45:33
 */

public class FilialLinhasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FilialLinhasActionForm f = (FilialLinhasActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
        tg_select_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/ind/FilialLinhas_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial_linhas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FilialLinhasActionForm f = (FilialLinhasActionForm) form;
    portalbr.dbobj.view.Jw_filial_linhas table = new portalbr.dbobj.view.Jw_filial_linhas();
    String[][] select = null;
    String[] order = {"lin_codigo","ref_codigo"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = {{"Lin_codigo","=", com.egen.util.text.FormatNumber.toInt(f.getLin_cdgo())}, {"Ref_codigo","=", com.egen.util.text.FormatNumber.toInt(f.getRef_cdgo())}, {"Cod_filial","=", f.getFil_filial()}, {"Mix","=", f.getStatus()}, {"Ativa","=", f.getAtiva()},};
    Vector res_Jw_filial_linhas = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_filial_linhas",res_Jw_filial_linhas);
    if (!(res_Jw_filial_linhas != null && res_Jw_filial_linhas.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial_linhas", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível: javaview Jw_filial_linhas");
      }
      java.util.Vector res_Jw_filial_linhas = (java.util.Vector) session.getAttribute("res_Jw_filial_linhas");
      if (res_Jw_filial_linhas != null && res_Jw_filial_linhas.size() == 0) {
        throw new Exception("Nenhum registro encontrado!");
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FilialLinhasActionForm f = (FilialLinhasActionForm) form;
      session.removeAttribute("res_Jw_filial_linhas");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Filial_linhas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
