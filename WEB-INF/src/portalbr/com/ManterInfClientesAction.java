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
 * Creation Date 14/12/2011 09:30:10
 * Last Modify Date 21/08/2013 11:54:24
 */

public class ManterInfClientesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManterInfClientesActionForm f = (ManterInfClientesActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      if ((f.getCb_agrupar_grupo() + "").equals("S")) {
        actionForward = new ActionForward("/com/ManterInfClientes_rgForm.jsp",true);
      } else {
        actionForward = new ActionForward("/com/ManterInfClientes_rForm.jsp",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ManterInfClientesActionForm f = (ManterInfClientesActionForm) form;
    Cli_inf_adicionais_vw table = new Cli_inf_adicionais_vw();
    String[][] select = null;
    String[] order = null;
    String[] orderCliente = {"cli_cdgo","esc_seqn"};
    String[] orderGrupo = {"gre_grupo","cli_cdgo","esc_seqn"};
    String[] groupby = null;
    String[] having = null;

    if ((f.getCb_agrupar_grupo() + "").equals("S")) {
      order = orderGrupo;
    } else {
      order = orderCliente;
    }

    Object[][] where = { {"gre_grupo","=", com.egen.util.text.FormatNumber.toInteger(f.getGre_grupo())},{"cli_cdgo","=", com.egen.util.text.FormatNumber.toInteger(f.getCli_cdgo())}, {"cli_rzao","like", f.getCli_rzao()}, {"esc_seqn","=", com.egen.util.text.FormatNumber.toInteger(f.getEsc_seqn())}, {"somente_etiqueta","like", f.getSomente_etiqueta()} };
    session.setAttribute("where", where);
    Vector res_Cli_inf_adicionais_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Cli_inf_adicionais_vw",res_Cli_inf_adicionais_vw);
    if (!(res_Cli_inf_adicionais_vw != null && res_Cli_inf_adicionais_vw.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais_vw", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }



  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ManterInfClientesActionForm f = (ManterInfClientesActionForm) form;
      session.removeAttribute("res_Cli_inf_adicionais_vw");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_session_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ManterInfClientesActionForm f = (ManterInfClientesActionForm) form;
      try {
        select_session_action(j, mapping, form, request, response);
      }
      finally {
      }
      if ((f.getCb_agrupar_grupo() + "").equals("S")) {
        actionForward = new ActionForward("/com/ManterInfClientes_rgForm.jsp",true);
      } else {
        actionForward = new ActionForward("/com/ManterInfClientes_rForm.jsp",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select_session_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ManterInfClientesActionForm f = (ManterInfClientesActionForm) form;
    Cli_inf_adicionais_vw table = new Cli_inf_adicionais_vw();
    String[][] select = null;
    String[] order = null;
    String[] orderCliente = {"cli_cdgo","esc_seqn"};
    String[] orderGrupo = {"gre_grupo","cli_cdgo","esc_seqn"};
    String[] groupby = null;
    String[] having = null;

    if ((f.getCb_agrupar_grupo() + "").equals("S")) {
      order = orderGrupo;
    } else {
      order = orderCliente;
    }

    Object[][] where = (Object[][]) session.getAttribute("where");
    Vector res_Cli_inf_adicionais_vw = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Cli_inf_adicionais_vw",res_Cli_inf_adicionais_vw);
    if (!(res_Cli_inf_adicionais_vw != null && res_Cli_inf_adicionais_vw.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais_vw", new ActionMessage("warn.norowsselected",""));
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
      ManterInfClientesActionForm f = (ManterInfClientesActionForm) form;


      actionForward = new ActionForward("/com/ManterInfClientes_iForm.do?resetfull_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli_inf_adicionais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
