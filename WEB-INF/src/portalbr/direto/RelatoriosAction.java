package portalbr.direto;

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
 * Creation Date 08/06/2015 17:30:00
 * Last Modify Date 05/12/2019 15:00:39
 */

public class RelatoriosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      RelatoriosActionForm f = (RelatoriosActionForm) form;
      select_action(j, mapping, form, request, response);
      if (request.getAttribute("arquivo") == null) {
        actionForward = new ActionForward(((String) request.getAttribute("arquivo")), true);
      } else {
        actionForward = new ActionForward(((String) request.getAttribute("arquivo")), true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    RelatoriosActionForm f = (RelatoriosActionForm) form;
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("CodigoBarra.jasper");
    g.setParametro("P_CODIGO_BARRA", f.getP1());
    g.gerarDireto(util.rand.Palavra.geraPalavra());
    session.setAttribute(mapping.getName(), form);
  }
}
