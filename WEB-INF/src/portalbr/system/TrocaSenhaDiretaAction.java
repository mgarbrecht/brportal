package portalbr.system;

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
 * Creation Date 28/01/2011 07:43:49
 * Last Modify Date 02/04/2013 16:11:23
 */

public class TrocaSenhaDiretaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      TrocaSenhaDiretaActionForm f = (TrocaSenhaDiretaActionForm) form;
      String id = "";
      id = query.retorna(j, "SELECT usua_id FROM usuarios where md5(md5(usua_email)) = '"+f.getChave() + "'");
      acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
      usuario.select(Integer.parseInt(id));
      session.setAttribute("User", (acesso.Usuario) usuario);
      session.setAttribute("mapping.getName()", form);
      actionForward = new ActionForward("/acesso/TrocaSenhaForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
