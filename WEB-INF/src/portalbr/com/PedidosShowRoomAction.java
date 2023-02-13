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
 * Creation Date 06/06/2011 14:14:09
 * Last Modify Date 07/06/2011 09:13:41
 */

public class PedidosShowRoomAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PedidosShowRoomActionForm f = (PedidosShowRoomActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/PedidosShowRoom_mForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_showroom", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PedidosShowRoomActionForm f = (PedidosShowRoomActionForm) form;
    Jw_acao_mkt_showroom table = new Jw_acao_mkt_showroom();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_showroom","=", com.egen.util.text.FormatNumber.toInteger(f.getId_showroom())}, {"codigo_regional","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_regional())}, {"nome_regional","like", f.getNome_regional()}, {"dt_periodo_ini",">=", com.egen.util.text.FormatDate.parseDate(f.getDt_periodo_ini(), "")}, {"dt_periodo_fim","<=", com.egen.util.text.FormatDate.parseDate(f.getDt_periodo_fim(), "")} };
    Vector res_Jw_acao_mkt_showroom = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_acao_mkt_showroom",res_Jw_acao_mkt_showroom);
    if (!(res_Jw_acao_mkt_showroom != null && res_Jw_acao_mkt_showroom.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_showroom", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PedidosShowRoomActionForm f = (PedidosShowRoomActionForm) form;
      session.removeAttribute("res_Jw_acao_mkt_showroom");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acao_mkt_showroom", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
