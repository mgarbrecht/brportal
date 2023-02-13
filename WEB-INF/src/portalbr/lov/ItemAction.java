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
 * Creation Date 05/10/2005 09:48:51
 * Last Modify Date 24/09/2009 09:39:11
 */

public class ItemAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_ItemFornecedorView", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ItemActionForm f = (ItemActionForm) form;
    StringBuilder parametros = new StringBuilder();
    portalbr.dbobj.view.Itemfornecedorview table = new portalbr.dbobj.view.Itemfornecedorview();
    if (f.getFornecedor() != "") {
      parametros.append("   and dif.for_codigo = ").append(f.getFornecedor());
    }
    if (f.getCodigo() != "") {
      parametros.append("   and die.codigo = ").append(f.getCodigo());
    }
    if (f.getDescricao() != "") {
      parametros.append("   and die.descricao like upper('").append(f.getDescricao().toUpperCase()).append("')");
    }

    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT(die.codigo) codigo, ");
    query.append("        die.descricao        descricao, ");
    query.append("        ''                   fornecedor ");
    query.append("   FROM dom_item_estoque     die, ");
    query.append("        dom_item_fornecedor  dif ");
    query.append("  WHERE die.codigo     = dif.ies_codigo ");
    query.append("    AND dif.for_codigo > 0 ");
    query.append(parametros.toString());
    query.append("  ORDER BY descricao ");


    Vector res_ItemFornecedorView = j.select(table, query.toString(), null);

    session.setAttribute("res_ItemFornecedorView",res_ItemFornecedorView);
    if (res_ItemFornecedorView == null || res_ItemFornecedorView.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_ItemFornecedorView", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ItemActionForm f = (ItemActionForm) form;
      session.removeAttribute("res_ItemFornecedorView");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_ItemFornecedorView", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
