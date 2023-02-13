package portalbr.acesso;

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
 * Creation Date 20/10/2010 13:38:31
 * Last Modify Date 01/11/2011 08:37:51
 */

public class TesteFiltroAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_blank_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      TesteFiltroActionForm f = (TesteFiltroActionForm) form;
      session.setAttribute("query", f.getQuery().replace("selecione","select").replace(" tudo "," * ").replace(" onde "," where ").replace(" e "," AND ").replace(" de "," FROM "));

      actionForward = new ActionForward("/system/RelatorioGenericoForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
