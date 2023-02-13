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
 * Creation Date 06/06/2011 17:07:05
 * Last Modify Date 07/06/2011 09:51:56
 */

public class PedidosShowRoom_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PedidosShowRoom_aActionForm f = (PedidosShowRoom_aActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_inf_adicionais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PedidosShowRoom_aActionForm f = (PedidosShowRoom_aActionForm) form;
    Ped_inf_adicionais table = new Ped_inf_adicionais();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_showroom","like", f.getId_showroom()}, {"dt_showroom","=", com.egen.util.text.FormatDate.parseDate(f.getDt_showroom(), "dd/MM/yyyy")}, {"ped_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())} };
    Vector res_Ped_inf_adicionais = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Ped_inf_adicionais",res_Ped_inf_adicionais);
    if (!(res_Ped_inf_adicionais != null && res_Ped_inf_adicionais.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_inf_adicionais", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PedidosShowRoom_aActionForm f = (PedidosShowRoom_aActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_inf_adicionais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    PedidosShowRoom_aActionForm f = (PedidosShowRoom_aActionForm) form;
    Ped_inf_adicionais table = new Ped_inf_adicionais();
    Object[][] name_value = { {"id_showroom",f.getId_showroom()}, {"dt_showroom",com.egen.util.text.FormatDate.parseDate(f.getDt_showroom(), "dd/MM/yyyy")}, {"ped_nmro",com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, };
    j.insert(table, name_value);
    Vector res_Ped_inf_adicionais = (Vector) session.getAttribute("res_Ped_inf_adicionais");
    if (res_Ped_inf_adicionais != null && table != null) {
      res_Ped_inf_adicionais.addElement(table);
      session.setAttribute("res_Ped_inf_adicionais", res_Ped_inf_adicionais);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PedidosShowRoom_aActionForm f = (PedidosShowRoom_aActionForm) form;
      try {
        delete_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/PedidosShowRoom_aForm.do?select_action=&id_showroom="+f.getId_showroom() + "&dt_showroom="+f.getDt_showroom(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_inf_adicionais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    PedidosShowRoom_aActionForm f = (PedidosShowRoom_aActionForm) form;
    Ped_inf_adicionais table = new Ped_inf_adicionais();
    table.setId_showroom(f.getId_showroom());
    table.setDt_showroom(com.egen.util.text.FormatDate.parseDate(f.getDt_showroom(), "dd/MM/yyyy"));
    table.setPed_nmro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPed_nmro()));
    j.delete(table);
    Vector res_Ped_inf_adicionais = (Vector) session.getAttribute("res_Ped_inf_adicionais");
    if (res_Ped_inf_adicionais != null && res_Ped_inf_adicionais.size() > 0) {
      res_Ped_inf_adicionais.removeElementAt(0);
      if (res_Ped_inf_adicionais.size() > 0) {
        Ped_inf_adicionais r = (Ped_inf_adicionais) res_Ped_inf_adicionais.elementAt(0);
        f.setId_showroom((r.getId_showroom() != null) ? r.getId_showroom() + "":"");
        f.setDt_showroom(com.egen.util.text.FormatDate.format(r.getDt_showroom(), "dd/MM/yyyy"));
        f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
      } else {
      }
    } else {
    }
    session.setAttribute(mapping.getName(), form);
  }

}
