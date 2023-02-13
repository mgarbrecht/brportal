package portalbr.com;

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
 * Creation Date 17/04/2006 10:39:36
 * Last Modify Date 07/01/2015 11:10:44
 */

public class PlusProdutosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/PlusProdutos_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PlusProdutosActionForm f = (PlusProdutosActionForm) form;
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception("Query não disponível: javaview Jw_linha");
    }
    portalbr.dbobj.view.Jw_linha table = new portalbr.dbobj.view.Jw_linha();
    String[][] select = null;
    String[] order = {"lin_cdgo"};
    Object[][] where = { {"Lin_cdgo","like", f.getLin_cdgo()}, {"Lin_nome","like", f.getLin_nome()}, {"Status","like", f.getStatus()} };
    Vector res_Jw_linha = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Jw_linha",res_Jw_linha);
    if (!(res_Jw_linha != null && res_Jw_linha.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PlusProdutosActionForm f = (PlusProdutosActionForm) form;
      session.removeAttribute("res_Jw_linha");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      PlusProdutosActionForm f = (PlusProdutosActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      select2_action(j, mapping, form, request, response);
      if ((!(f.getLin_cdgo().equals(""))) && (!(f.getRef_cdgo().equals("")))) {
        actionForward = new ActionForward("/com/PlusProdutosDadosForm.do?select_action=&lin_cdgo="+f.getLin_cdgo() + "&ref_cdgo="+f.getRef_cdgo(), true);
      } else {
        actionForward = new ActionForward("/com/PlusProdutos_refForm.jsp",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_linha", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select2_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    PlusProdutosActionForm f = (PlusProdutosActionForm) form;
    portalbr.dbobj.view.Jw_linha_ref table = new portalbr.dbobj.view.Jw_linha_ref();
    String[][] select = null;
    String[] order = {"ref_cdgo"};
    Object[][] where = { {"Lin_cdgo","like", f.getLin_cdgo()}, {"Ref_cdgo","like", f.getRef_cdgo()}, {"Status","like", f.getStatus()} };
    Vector res_Jw_linha_ref = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Jw_linha_ref",res_Jw_linha_ref);
    if (!(res_Jw_linha_ref != null && res_Jw_linha_ref.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

}
