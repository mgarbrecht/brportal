package portalbr.adm;

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
 * Creation Date 08/06/2006 12:03:19
 * Last Modify Date 27/08/2009 16:36:01
 */

public class CircularesVendas_dAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      tg_select_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Circulares_vendas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    CircularesVendas_dActionForm f = (CircularesVendas_dActionForm) form;
    portalbr.dbobj.table.Circulares_vendas table = new portalbr.dbobj.table.Circulares_vendas();
    String[][] select = null;
    Object[][] where = { {"Numero","like", f.getNumero()}, {"Data","=", com.egen.util.text.FormatDate.parseTimestamp(f.getData(), "dd/MM/yyyy")}, {"Remetente","like", f.getRemetente()}, {"Destinatario","=", com.egen.util.text.FormatNumber.toInt(f.getDestinatario())}, {"Assunto","like", f.getAssunto()}, {"Texto","like", f.getTexto()} };
    Vector res_Circulares_vendas = j.select(table, select, where, null, null, null);
    session.setAttribute("res_Circulares_vendas",res_Circulares_vendas);
    if (res_Circulares_vendas != null && res_Circulares_vendas.size() > 0) {
      portalbr.dbobj.table.Circulares_vendas r = (portalbr.dbobj.table.Circulares_vendas) res_Circulares_vendas.elementAt(0);
      f.setNumero((r.getNumero() != null) ? r.getNumero() + "":"");
      f.setData(com.egen.util.text.FormatDate.format(r.getData(), "dd/MM/yyyy"));
      f.setRemetente((r.getRemetente() != null) ? r.getRemetente() + "":"");
      f.setDestinatario(r.getDestinatario() + "");
      f.setAssunto((r.getAssunto() != null) ? r.getAssunto() + "":"");
      f.setTexto((r.getTexto() != null) ? r.getTexto() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Circulares_vendas", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      CircularesVendas_dActionForm f = (CircularesVendas_dActionForm) form;
      if (f.getDestinatario().equals("1")) {
        f.setDestinatario("Todos");
      }
      if (f.getDestinatario().equals("2")) {
        f.setDestinatario("Representantes Riva Bianca");
      }
      if (f.getDestinatario().equals("3")) {
        f.setDestinatario("Representantes Vizzano");
      }
      if (f.getDestinatario().equals("4")) {
        f.setDestinatario("Gerentes e Repres. Riva Bianca");
      }
      if (f.getDestinatario().equals("5")) {
        f.setDestinatario("Todos Representantes");
      }
      if (f.getDestinatario().equals("6")) {
        f.setDestinatario("Gerentes Regionais de Vendas");
      }
      if (f.getDestinatario().equals("7")) {
        f.setDestinatario("Gerentes e Repres. Beira Rio");
      }
      if (f.getDestinatario().equals("8")) {
        f.setDestinatario("Gerentes e Repres. Vizzano");
      }

      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/adm/CircularesVendas_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Circulares_vendas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
