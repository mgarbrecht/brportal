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
 * Creation Date 30/11/2010 06:58:22
 * Last Modify Date 30/11/2010 07:24:43
 */

public class EntPedidosAvisoErroAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosAvisoErroActionForm f = (EntPedidosAvisoErroActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    EntPedidosAvisoErroActionForm f = (EntPedidosAvisoErroActionForm) form;
    Emula_itens_faturas_proformas table = new Emula_itens_faturas_proformas();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"numero_pedido","=", com.egen.util.text.FormatNumber.toInteger(f.getNumero_pedido())}, {"numero_item","=", com.egen.util.text.FormatNumber.toInteger(f.getNumero_item())}, };
    Vector res_Emula_itens_faturas_proformas = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Emula_itens_faturas_proformas",res_Emula_itens_faturas_proformas);
    if (res_Emula_itens_faturas_proformas != null && res_Emula_itens_faturas_proformas.size() > 0) {
      Emula_itens_faturas_proformas r = (Emula_itens_faturas_proformas) res_Emula_itens_faturas_proformas.elementAt(0);
      f.setNumero_pedido((r.getNumero_pedido() != null) ? r.getNumero_pedido() + "":"");
      f.setNumero_item((r.getNumero_item() != null) ? r.getNumero_item() + "":"");
      f.setDescricao_erro((r.getDescricao_erro() != null) ? r.getDescricao_erro() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_itens_faturas_proformas", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
