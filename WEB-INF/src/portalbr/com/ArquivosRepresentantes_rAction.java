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
 * Creation Date 20/06/2006 14:19:15
 * Last Modify Date 27/08/2009 16:50:07
 */

public class ArquivosRepresentantes_rAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/com/ArquivosRepresentantes_mForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Links_dinamicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      delete_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Links_dinamicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ArquivosRepresentantes_rActionForm f = (ArquivosRepresentantes_rActionForm) form;
    portalbr.dbobj.table.Links_dinamicos table = new portalbr.dbobj.table.Links_dinamicos();
    table.setLidi_id(com.egen.util.text.FormatNumber.parseInt(f.getLidi_id()));
    java.io.File arq = new java.io.File(request.getRealPath("/") + "arquivos/representantes" + java.io.File.separator + f.getArquivo());
    arq.delete();
    j.delete(table);
    Vector res_Links_dinamicos = (Vector) session.getAttribute("res_Links_dinamicos");
    if (res_Links_dinamicos != null && res_Links_dinamicos.size() > 0) {
      res_Links_dinamicos.removeElementAt(Integer.parseInt(f.getPos()));
      if (res_Links_dinamicos.size() > 0) {
        portalbr.dbobj.table.Links_dinamicos r = (portalbr.dbobj.table.Links_dinamicos) res_Links_dinamicos.elementAt(0);

        f.setLidi_id(r.getLidi_id() + "");
      } else {
        f.reset(mapping, request);
      }

    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
