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
 * Creation Date 31/10/2011 10:58:16
 * Last Modify Date 31/10/2011 11:59:57
 */

public class DispositivosMoveisAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DispositivosMoveisActionForm f = (DispositivosMoveisActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/DispositivosMoveis_rGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    DispositivosMoveisActionForm f = (DispositivosMoveisActionForm) form;
    Usuarios_sistema_afv table = new Usuarios_sistema_afv();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"codigo_usuario","like", f.getCodigo_usuario()}, {"nome_usuario","like", f.getNome_usuario().toUpperCase()}, {"id_tablet","=", com.egen.util.text.FormatNumber.toInteger(f.getId_tablet())} };
    session.setAttribute("where", where);
    Vector res_Usuarios_sistema_afv = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Usuarios_sistema_afv",res_Usuarios_sistema_afv);
    if (res_Usuarios_sistema_afv != null && res_Usuarios_sistema_afv.size() > 0) {
      Usuarios_sistema_afv r = (Usuarios_sistema_afv) res_Usuarios_sistema_afv.elementAt(0);
    } else {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DispositivosMoveisActionForm f = (DispositivosMoveisActionForm) form;
      session.removeAttribute("res_Usuarios_sistema_afv");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios_sistema_afv", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
