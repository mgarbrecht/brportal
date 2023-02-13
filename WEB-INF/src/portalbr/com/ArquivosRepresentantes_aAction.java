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
 * Creation Date 20/06/2006 14:36:26
 * Last Modify Date 27/08/2009 16:49:13
 */

public class ArquivosRepresentantes_aAction extends com.egen.util.struts.AbstractAction {

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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ArquivosRepresentantes_aActionForm f = (ArquivosRepresentantes_aActionForm) form;
    portalbr.dbobj.table.Links_dinamicos table = new portalbr.dbobj.table.Links_dinamicos();
    Vector sets = new Vector(10, 2);
    table.setLidi_marca(com.egen.util.text.FormatNumber.parseInt(f.getLidi_marca()));
    if (f.getLidi_marca() != null) {
      sets.addElement("lidi_marca");
    } else {
      sets.addElement("");
    };
    table.setLidi_id(com.egen.util.text.FormatNumber.parseInt(f.getLidi_id()));
    table.setLidi_titulo(f.getLidi_titulo());
    if (f.getLidi_titulo() != null) {
      sets.addElement("lidi_titulo");
    } else {
      sets.addElement("");
    };
    if ((!((f.getArquivo() + "").equals("")))) {
      table.setLidi_caminho("/com/norma_venda/tabelas/"+(f.getArquivo() + ""));
      if (f.getLidi_caminho() != null) {
        sets.addElement("lidi_caminho");
      } else {
        sets.addElement("");
      };
    }
    table.setLidi_descricao(f.getLidi_descricao());
    if (f.getLidi_descricao() != null) {
      sets.addElement("lidi_descricao");
    } else {
      sets.addElement("");
    };
    String[] set = new String[sets.size()];
    for (int i = 0; i < sets.size(); i++) {
      set[i] = (String) sets.elementAt(i);
    }
    int updated = j.update(table, set);
    String _pos_field_name = "pos";
    String _lines_name = "bl_form_Links_dinamicos_lines";
    String action = null;
    int _ge_pos = com.egen.util.struts.AbstractActionHelper.getDynamicPosition(action, _pos_field_name, _lines_name, f, request);
    if (updated == 0) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Links_dinamicos", new ActionMessage("warn.norowsupdated",": " + updated));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    } else {
      Vector res_Links_dinamicos = (Vector) session.getAttribute("res_Links_dinamicos");
      if (res_Links_dinamicos != null) {
        res_Links_dinamicos.setElementAt(table, _ge_pos);
        portalbr.dbobj.table.Links_dinamicos r = (portalbr.dbobj.table.Links_dinamicos) res_Links_dinamicos.elementAt(_ge_pos);
        f.setLidi_marca(r.getLidi_marca() + "");
        f.setLidi_id(r.getLidi_id() + "");
        f.setLidi_titulo((r.getLidi_titulo() != null) ? r.getLidi_titulo() + "":"");
        f.setLidi_caminho((r.getLidi_caminho() != null) ? r.getLidi_caminho() + "":"");
        f.setLidi_descricao((r.getLidi_descricao() != null) ? r.getLidi_descricao() + "":"");
      }
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/com/ArquivosRepresentantes_rForm.jsp",true);
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
  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("ArquivosRepresentantes_aActionForm", form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Links_dinamicos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


}
