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
 * Creation Date 15/02/2006 16:15:24
 * Last Modify Date 27/08/2009 16:48:33
 */

public class AgendaVisitasClientesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Altera um registro da tabela agenda_visitas_clientes, redirecionando para a tela:
    //                     com/AgendaVisitasForm.jsp
    //-------------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      update_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/AgendaVisitasForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AgendaVisitasClientesActionForm f = (AgendaVisitasClientesActionForm) form;
    portalbr.dbobj.view.Jw_agenda_visitas table = new portalbr.dbobj.view.Jw_agenda_visitas();
    table.setAgvi_rep_cdgo(f.getAgvi_rep_cdgo());
    table.setRep_rzao(f.getRep_rzao());
    table.setAgvi_dt_inicial(com.egen.util.text.FormatDate.parseTimestamp(f.getAgvi_dt_inicial(), "dd/MM/yyyy"));
    table.setAgvi_dt_final(com.egen.util.text.FormatDate.parseTimestamp(f.getAgvi_dt_final(), "dd/MM/yyyy"));
    table.setAgvi_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getAgvi_id()));
    //------------------------------------------------------------------------------------------------
    vendas.AgendaVisitaAPI agenda = new vendas.AgendaVisitaAPI(j.getConn());
    agenda.select(Integer.parseInt(f.getAgvi_id()));
    agenda.setDataInicial(com.egen.util.text.FormatDate.parseDate(f.getAgvi_dt_inicial(), "dd/MM/yyyy"));
    agenda.setDataFinal(com.egen.util.text.FormatDate.parseDate(f.getAgvi_dt_final(), "dd/MM/yyyy"));
    agenda.update();
    //------------------------------------------------------------------------------------------------
    Vector res_Jw_agenda_visitas = (Vector) session.getAttribute("res_Jw_agenda_visitas");
    if (res_Jw_agenda_visitas != null) {
      res_Jw_agenda_visitas.setElementAt(table, Integer.parseInt(f.getPos()));
    }

    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Redireciona para a tela de inclusão de um novo registro
    //                     na tabela agenda_visitas_clientes:
    //                     /com/AgendaVisitasClientes_iForm.jsp
    //----------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AgendaVisitasClientesActionForm f = (AgendaVisitasClientesActionForm) form;
      actionForward = new ActionForward("/com/AgendaVisitasClientes_iForm.do?select_action=&agvi_id="+f.getAgvi_id() + "&pos="+f.getPos(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Redireciona para a tela de filtro de Agendas de Visitas:
    //                     /com/AgendaVisitasForm.jsp
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/com/AgendaVisitasForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //--------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_agenda_visitas_clientes,
    //                     para mostrar as visitas cadastradas para uma determinada Agenda de Visitas.
    //--------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //--------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AgendaVisitasClientesActionForm f = (AgendaVisitasClientesActionForm) form;
    portalbr.dbobj.view.Jw_agenda_visitas_clientes table = new portalbr.dbobj.view.Jw_agenda_visitas_clientes();
    String[][] select = null;
    String[] order = {"cli_rzao"};
    Object[][] where = { {"agvc_agvi_id","=",f.getAgvi_id()}, {"Agvc_dt_exclusao","=", ":null"} };
    Vector res_Jw_agenda_visitas_clientes = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Jw_agenda_visitas_clientes",res_Jw_agenda_visitas_clientes);
    if (!(res_Jw_agenda_visitas_clientes != null && res_Jw_agenda_visitas_clientes.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Deleta um registro da tabela agenda_visitas_clientes.
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      delete_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AgendaVisitasClientesActionForm f = (AgendaVisitasClientesActionForm) form;
    portalbr.dbobj.view.Jw_agenda_visitas_clientes table = new portalbr.dbobj.view.Jw_agenda_visitas_clientes();
    Vector res_Jw_agenda_visitas_clientes = (Vector) session.getAttribute("res_Jw_agenda_visitas_clientes");
    //---------------------------------------------------------------------------------------------
    vendas.AgendaVisitaClienteAPI visita = new vendas.AgendaVisitaClienteAPI(j.getConn(), Integer.parseInt(f.getAgvc_id()));
    visita.delete();
    //---------------------------------------------------------------------------------------------
    if (res_Jw_agenda_visitas_clientes != null && res_Jw_agenda_visitas_clientes.size() > 0) {
      res_Jw_agenda_visitas_clientes.removeElementAt(Integer.parseInt(f.getPos()));
      session.setAttribute("res_Jw_agenda_visitas_clientes",res_Jw_agenda_visitas_clientes);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
