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
 * Creation Date 10/12/2010 11:08:46
 * Last Modify Date 15/12/2014 08:59:29
 */

public class EntPedidosPDFAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EntPedidosPDFActionForm f = (EntPedidosPDFActionForm) form;
      //--------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("EntradaPedidos.jasper");
      g.setParametro("P_NUMERO_PEDIDO",Double.parseDouble((String) session.getAttribute("numero_pedido")));
      g.gerar();
      request.setAttribute("abre_automaticamente","N");
      //--------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Emula_faturas_proformas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
