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
 * Creation Date 16/02/2009 10:00:24
 * Last Modify Date 16/02/2009 12:48:02
 */

public class LvCorFornecedorAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvCorFornecedorActionForm f = (LvCorFornecedorActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Corfornecedorview", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvCorFornecedorActionForm f = (LvCorFornecedorActionForm) form;
    if (f.getCodigo().equals("") && f.getDescricao().equals("")) {
      throw new Exception("Informe um dos parâmetros!");
    }
    Corfornecedorview table = new Corfornecedorview();
    StringBuilder parametros = new StringBuilder();
    if (f.getFornecedor() != "") {
      parametros.append("   and dif.for_codigo = ").append(f.getFornecedor());
    }
    if (f.getCodigo() != "") {
      parametros.append("   and dif.cor_cdgo = ").append(f.getCodigo());
    }
    if (f.getDescricao() != "") {
      parametros.append("   and upper(c.cor_desc) like upper('").append(f.getDescricao().toUpperCase()).append("')");
    }

    String[][] select = null;

    StringBuilder sb = new StringBuilder();
    sb.append("  select distinct(dif.cor_cdgo) codigo, ");
    sb.append("         c.cor_desc             descricao, ");
    sb.append("         ''                     fornecedor ");
    sb.append("    from cor                    c, ");
    sb.append("         dom_item_fornecedor    dif ");
    sb.append("   where dif.cor_cdgo   = c.cor_cdgo ");
    sb.append(parametros);
    sb.append("   order by descricao ");

    Vector res_Corfornecedorview = j.select(table, sb.toString(), null);

    session.setAttribute("res_Corfornecedorview",res_Corfornecedorview);
    if (res_Corfornecedorview == null || res_Corfornecedorview.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Corfornecedorview", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvCorFornecedorActionForm f = (LvCorFornecedorActionForm) form;
      session.removeAttribute("res_Corfornecedorview");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Corfornecedorview", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
