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
 * Creation Date 24/05/2010 14:22:37
 * Last Modify Date 02/04/2013 15:33:10
 */

public class ManutencaoAcaoMarketingAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketingActionForm f = (ManutencaoAcaoMarketingActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/ManutencaoAcaoMarketing_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ManutencaoAcaoMarketingActionForm f = (ManutencaoAcaoMarketingActionForm) form;
    Jw_acao_marketing table = new Jw_acao_marketing();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"data_entrega","=", com.egen.util.text.FormatDate.parseDate(f.getData_entrega(), "")}, {"acao","=", com.egen.util.text.FormatNumber.toInt(f.getAcao())}, {"codigo_material","=", com.egen.util.text.FormatNumber.toInt(f.getCodigo_material())}, {"situacao","like", f.getSituacao()}, {"cracha_usuario","like",f.getCracha_usuario()}, {"codigo_marca","=",f.getMarca()} };
    session.setAttribute("ManutencaoAcaoMarketingWhere", where);
    Vector res_Jw_acao_marketing = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acao_marketing",res_Jw_acao_marketing);
    if (!(res_Jw_acao_marketing != null && res_Jw_acao_marketing.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ManutencaoAcaoMarketingActionForm f = (ManutencaoAcaoMarketingActionForm) form;
      session.removeAttribute("res_Jw_acao_marketing");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_session_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManutencaoAcaoMarketingActionForm f = (ManutencaoAcaoMarketingActionForm) form;
      try {
        select_session_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/ManutencaoAcaoMarketing_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select_session_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ManutencaoAcaoMarketingActionForm f = (ManutencaoAcaoMarketingActionForm) form;
    Jw_acao_marketing table = new Jw_acao_marketing();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;

    Object[][] where = (Object[][]) session.getAttribute("ManutencaoAcaoMarketingWhere");
    Vector res_Jw_acao_marketing = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acao_marketing",res_Jw_acao_marketing);
    if (!(res_Jw_acao_marketing != null && res_Jw_acao_marketing.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_marketing", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

}
