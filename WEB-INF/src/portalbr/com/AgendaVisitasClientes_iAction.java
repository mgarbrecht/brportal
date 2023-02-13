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
 * Creation Date 16/02/2006 11:20:18
 * Last Modify Date 21/08/2013 12:13:26
 */

public class AgendaVisitasClientes_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 16/02/2006
    // Objetivo          : Insere um novo registro na tabela agenda_visitas_clientes
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      insert_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AgendaVisitasClientes_iActionForm f = (AgendaVisitasClientes_iActionForm) form;
    portalbr.dbobj.table.Agenda_visitas_clientes table = new portalbr.dbobj.table.Agenda_visitas_clientes();
    //---------------------------------------------------------------------------------------------
    vendas.AgendaVisitaClienteAPI visita = new vendas.AgendaVisitaClienteAPI(j.getConn());
    vendas.AgendaVisitaAPI agenda = new vendas.AgendaVisitaAPI(j.getConn());
    agenda.select(Integer.parseInt(f.getAgvi_id()));
    visita.setAgendaVisita((vendas.AgendaVisitaAPI) agenda);
    if (!(f.getAgvc_cli_cdgo().equals(""))) {
      vendas.ClienteAPI cli = new vendas.ClienteAPI(j.getConn());
      cli.select(Integer.parseInt(f.getAgvc_cli_cdgo()));
      visita.setCliente((vendas.Cliente) cli);
    }
    if (f.getAgvc_tipo().equals("V")) {
      visita.setTipo(vendas.AgendaVisitaClienteAPI.MotivoVisita.VENDA);
    }
    if (f.getAgvc_tipo().equals("R")) {
      visita.setTipo(vendas.AgendaVisitaClienteAPI.MotivoVisita.REPOSICAO);
    }
    if (f.getAgvc_tipo().equals("A")) {
      visita.setTipo(vendas.AgendaVisitaClienteAPI.MotivoVisita.VENDA_REPOSICAO);
    }
    visita.insert();
    //---------------------------------------------------------------------------------------------

    Vector res_Agenda_visitas_clientes = (Vector) session.getAttribute("res_Agenda_visitas_clientes");
    if (res_Agenda_visitas_clientes != null && table != null) {
      res_Agenda_visitas_clientes.addElement(table);
      session.setAttribute("res_Agenda_visitas_clientes", res_Agenda_visitas_clientes);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AgendaVisitasClientes_iActionForm f = (AgendaVisitasClientes_iActionForm) form;
      session.removeAttribute("res_Agenda_visitas_clientes");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //----------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 16/02/2006
    // Objetivo          : Redireciona para a tela de consulta de visitas cadastradas, fazendo uma
    //                     nova consulta para mostrar os dados atualizados.
    //----------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AgendaVisitasClientes_iActionForm f = (AgendaVisitasClientes_iActionForm) form;
      actionForward = new ActionForward("/com/AgendaVisitasClientesForm.do?select_action="+ "&agvi_id="+f.getAgvc_agvi_id() + "&agvi_rep_cdgo="+f.getAgvi_rep_cdgo() + "&agvi_dt_inicial="+f.getAgvi_dt_inicial() + "&agvi_dt_final="+f.getAgvi_dt_final() + "&pos="+f.getPos(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 16/02/2006
    // Objetivo          : Executa uma consulta na tabela agenda_visitas
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AgendaVisitasClientes_iActionForm f = (AgendaVisitasClientes_iActionForm) form;
    portalbr.dbobj.table.Agenda_visitas table = new portalbr.dbobj.table.Agenda_visitas();
    String[][] select = null;
    Object[][] where = { {"Agvi_id","=", com.egen.util.text.FormatNumber.toInteger(f.getAgvi_id())} };
    Vector res_Agenda_visitas = j.select(table, select, where, null, null, null);
    session.setAttribute("res_Agenda_visitas",res_Agenda_visitas);
    if (res_Agenda_visitas != null && res_Agenda_visitas.size() > 0) {
      portalbr.dbobj.table.Agenda_visitas r = (portalbr.dbobj.table.Agenda_visitas) res_Agenda_visitas.elementAt(0);
      f.setAgvi_rep_cdgo((r.getAgvi_rep_cdgo() != null) ? r.getAgvi_rep_cdgo() + "":"");
      f.setAgvi_dt_inicial(com.egen.util.text.FormatDate.format(r.getAgvi_dt_inicial(), "dd/MM/yyyy"));
      f.setAgvi_dt_final(com.egen.util.text.FormatDate.format(r.getAgvi_dt_final(), "dd/MM/yyyy"));
      f.setAgvc_agvi_id((r.getAgvi_id() != null) ? r.getAgvi_id() + "":"");

    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas_clientes", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
