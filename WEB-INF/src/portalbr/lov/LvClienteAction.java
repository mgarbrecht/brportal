package portalbr.lov;

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
 * Creation Date 16/02/2006 13:19:16
 * Last Modify Date 15/08/2019 11:46:38
 */

public class LvClienteAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      tg_select_action(mapping, form, request, response);
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvClienteActionForm f = (LvClienteActionForm) form;
    portalbr.dbobj.table.Cli table = new portalbr.dbobj.table.Cli();
    String[][] select = null;
    String[] order = {"cli_rzao"};
    Object[][] where = { {"cli_cdgo",">","0"}, {"cli_situ","=","A"}, {"Cli_cdgo","like", f.getCli_cdgo()}, {"upper(Cli_rzao)","like", f.getCli_rzao().toUpperCase()} };
    Vector res_Cli = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Cli",res_Cli);
    if (res_Cli == null || res_Cli.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      LvClienteActionForm f = (LvClienteActionForm) form;
      if ((f.getCli_cdgo().equals("")) && (f.getCli_rzao().equals(""))) {
        throw new Exception("O Código e/ou Razão Social devem ser informados!");
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvClienteActionForm f = (LvClienteActionForm) form;
      session.removeAttribute("res_Cli");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      tg_resetfull_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      LvClienteActionForm f = (LvClienteActionForm) form;
      session.removeAttribute("lista_de_valores_manter_sessao");
      session.removeAttribute("lista_clientes_selecionados");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_sessao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvClienteActionForm f = (LvClienteActionForm) form;
      session.removeAttribute("res_Cli");
      form.reset(mapping, request);
      session.setAttribute("lista_de_valores_manter_sessao", true);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_setar_sessao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvClienteActionForm f = (LvClienteActionForm) form;
      java.util.List < String > listaClientesSelecionados = new java.util.ArrayList();
      session.removeAttribute("lista_clientes_selecionados_codigos");
      if (session.getAttribute("lista_clientes_selecionados") != null) {
        listaClientesSelecionados = (List < String >) session.getAttribute("lista_clientes_selecionados");
      }
      String cliente = (f.getCli_cdgo_sessao() + " - " + f.getCli_rzao_sessao());
      if (!listaClientesSelecionados.contains(cliente)) {
        listaClientesSelecionados.add(cliente);
        session.setAttribute("lista_clientes_selecionados", listaClientesSelecionados);
      }

      StringBuilder sb = new StringBuilder();
      for (String cli :
          listaClientesSelecionados) {
        if (sb.length() > 0) {
          sb.append(",");
        }
        String c[] = cli.split(" - ");
        sb.append(c[0]);
      }
      session.setAttribute("lista_clientes_selecionados_codigos", sb.toString());

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
