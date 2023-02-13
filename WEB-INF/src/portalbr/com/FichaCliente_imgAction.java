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
 * Creation Date 22/03/2013 16:55:58
 * Last Modify Date 02/04/2013 15:17:37
 */

public class FichaCliente_imgAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FichaCliente_imgActionForm f = (FichaCliente_imgActionForm) form;
      select_action(null, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    util.consultas.Query query = new util.consultas.Query();
    FichaCliente_imgActionForm f = (FichaCliente_imgActionForm) form;
    String imagem = query.retorna("SELECT replace(fct_retorna_fit_imagem("+f.getLinha() + ", "+f.getReferencia() + "),'gif','jpg')  FROM dual");
    request.setAttribute("imagem", imagem);
    session.setAttribute(mapping.getName(), form);
  }
}
