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
 * Creation Date 08/06/2006 11:18:26
 * Last Modify Date 27/08/2009 16:34:28
 */

public class CircularesVendas_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      update_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Circulares_vendas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    CircularesVendas_rActionForm f = (CircularesVendas_rActionForm) form;
    portalbr.dbobj.table.Circulares_vendas table = new portalbr.dbobj.table.Circulares_vendas();
    Vector sets = new Vector(10, 2);
    table.setNumero(f.getNumero());
    table.setStatus("I");
    String[] set = new String[sets.size()];
    for (int i = 0; i < sets.size(); i++) {
      set[i] = (String) sets.elementAt(i);
    }
    int updated = j.update(table, set);
    if (updated == 0) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Circulares_vendas", new ActionMessage("warn.norowsupdated",": " + updated));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    } else {
      Vector res_Circulares_vendas = (Vector) session.getAttribute("res_Circulares_vendas");
      if (res_Circulares_vendas != null) {
        res_Circulares_vendas.removeElementAt(Integer.parseInt(f.getPos()));
        session.setAttribute("res_Circulares_vendas",res_Circulares_vendas);
      }
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/adm/CircularesVendasForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Circulares_vendas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
