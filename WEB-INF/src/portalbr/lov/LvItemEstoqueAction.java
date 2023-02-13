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
 * Creation Date 23/11/2010 12:13:20
 * Last Modify Date 23/11/2010 12:21:39
 */

public class LvItemEstoqueAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvItemEstoqueActionForm f = (LvItemEstoqueActionForm) form;
      try {
        tg_select_action(mapping, form, request, response);
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dom_item_estoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvItemEstoqueActionForm f = (LvItemEstoqueActionForm) form;
    Dom_item_estoque table = new Dom_item_estoque();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"codigo","=", com.egen.util.text.FormatNumber.toInt(f.getCodigo())}, {"upper(descricao)","like", f.getDescricao().toUpperCase()} };
    Vector res_Dom_item_estoque = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Dom_item_estoque",res_Dom_item_estoque);
    if (res_Dom_item_estoque == null || res_Dom_item_estoque.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dom_item_estoque", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      LvItemEstoqueActionForm f = (LvItemEstoqueActionForm) form;
      if (f.getCodigo().equals("") && f.getDescricao().equals("")) {
        throw new Exception("Um dos parâmetros deve ser informado!");
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
      LvItemEstoqueActionForm f = (LvItemEstoqueActionForm) form;
      session.removeAttribute("res_Dom_item_estoque");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dom_item_estoque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
