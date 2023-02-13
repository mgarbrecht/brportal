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
 * Creation Date 10/08/2006 15:11:28
 * Last Modify Date 19/01/2015 09:44:39
 */

public class ClientesSemRepresentanteAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      ClientesSemRepresentanteActionForm f = (ClientesSemRepresentanteActionForm) form;
      if ((f.getEstado() + "").equals("1")) {
        actionForward = new ActionForward("/com/ClientesSemRepresentante_rForm.do?&estado=1",true);
      } else {
        actionForward = new ActionForward("/com/ClientesSemRepresentante_rForm.do?&estado=0",true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_sem_representante", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ClientesSemRepresentanteActionForm f = (ClientesSemRepresentanteActionForm) form;
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception("Query não disponível! Javaview utilizada: Jw_clientes_sem_representante");
    }

    portalbr.dbobj.view.Jw_clientes_sem_representante table = new portalbr.dbobj.view.Jw_clientes_sem_representante();
    String[][] select = null;
    Object[][] where = { {"Uf","like",f.getEst_descri()}, {"upper(cli_rzao)","like",f.getCli_rzao().toUpperCase()} };
    Vector res_Jw_clientes_sem_representante = j.select(table, select, where, null, null, null);
    session.setAttribute("res_Jw_clientes_sem_representante",res_Jw_clientes_sem_representante);
    if (!(res_Jw_clientes_sem_representante != null && res_Jw_clientes_sem_representante.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesSemRepresentanteActionForm f = (ClientesSemRepresentanteActionForm) form;
      session.removeAttribute("res_Jw_clientes_sem_representante");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_sem_representante", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ClientesSemRepresentanteActionForm f = (ClientesSemRepresentanteActionForm) form;
      select2_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_sem_representante", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select2_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ClientesSemRepresentanteActionForm f = (ClientesSemRepresentanteActionForm) form;
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");


    util.file.GeraPDF g = new util.file.GeraPDF(request);

    String file_jasper = "";
    if ((f.getEstado() + "").equals("1")) {
      file_jasper = "ClientesSemRepresentante.jasper";
    } else {
      file_jasper = "ClientesSemRepresentante_geral.jasper";
    }
    g.setRelatorio(file_jasper);

    g.setParametro("P_UF",f.getEst_descri());
    if (f.getCli_rzao() != "") {
      g.setParametro("P_CLI_RZAO",f.getCli_rzao());
    }
    if (usuario.mostraQuery()) {
      throw new Exception("Query não disponível! Relatório utilizado: " + file_jasper);
    }
    g.gerar();

    if ((f.getAbre_automaticamente() + "").equals("checked")) {
      request.setAttribute("abre_automaticamente","S");
    } else {
      request.setAttribute("abre_automaticamente","N");
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesSemRepresentanteActionForm f = (ClientesSemRepresentanteActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_sem_representante", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
