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
 * Creation Date 15/02/2006 15:35:13
 * Last Modify Date 04/04/2013 09:44:27
 */

public class AgendaVisitasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_agenda_visitas.
    //---------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //---------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      tg_select_action(mapping, form, request, response);
      select_action(j, mapping, form, request, response);
      tg_select_action_1(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AgendaVisitasActionForm f = (AgendaVisitasActionForm) form;
    portalbr.dbobj.view.Jw_agenda_visitas table = new portalbr.dbobj.view.Jw_agenda_visitas();
    String[][] select = null;
    String[] order = {"rep_rzao"};
    Object[][] where = { {"Agvi_rep_cdgo","like", f.getAgvi_rep_cdgo()}, {"Agvi_rep_cdgo","like", f.getCodigo_representante()}, {"Codigo_regional","like",f.getRegional()}, {"Rep_rzao","like", f.getRep_rzao()}, {"Agvi_dt_inicial",">=", com.egen.util.text.FormatDate.parseTimestamp(f.getAgvi_dt_inicial(), "dd/MM/yyyy")}, {"Agvi_dt_final","<=", com.egen.util.text.FormatDate.parseTimestamp(f.getAgvi_dt_final(), "dd/MM/yyyy")}, {"Agvi_dt_exclusao","=", ":null"}, };
    Vector res_Jw_agenda_visitas = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Jw_agenda_visitas",res_Jw_agenda_visitas);
    if (!(res_Jw_agenda_visitas != null && res_Jw_agenda_visitas.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Verifica se o representante pertence à regional informada.
    //----------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      AgendaVisitasActionForm f = (AgendaVisitasActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      if (f.getRegional() != "") {
        portalbr.dbobj.table.Rep table = new portalbr.dbobj.table.Rep();
        String[][] select = null;
        String[] order = {"rep_rzao"};
        Object[][] where = { {"Codigo_regional","like", f.getRegional()}, {"Rep_cdgo","like", f.getAgvi_rep_cdgo()} };
        Vector res_Rep = j.select(table, select, where, null, null, order);
        if (res_Rep != null && res_Rep.size() == 0) {
          throw new Exception("O Representante não pertence à Regional!");
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
  }
  private void tg_select_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      AgendaVisitasActionForm f = (AgendaVisitasActionForm) form;
      f.setDt_inicial(f.getAgvi_dt_inicial());
      f.setDt_final(f.getAgvi_dt_final());
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Redireciona para a tela de inserção de uma nova Agenda de Visita, passando os
    //                     parâmetros que foram informados.
    //---------------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //---------------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AgendaVisitasActionForm f = (AgendaVisitasActionForm) form;
      actionForward = new ActionForward("/com/AgendaVisitas_iForm.do?pop_action=&agvi_rep_cdgo="+f.getAgvi_rep_cdgo() + "&rep_cdgo="+f.getAgvi_rep_cdgo() + "&rep_rzao="+f.getRep_rzao() + "&dt_inicial="+f.getDt_inicial() + "&dt_final="+f.getDt_final(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AgendaVisitasActionForm f = (AgendaVisitasActionForm) form;
      session.removeAttribute("res_Jw_agenda_visitas");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.setAttribute("pos","0");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 15/02/2006
    // Objetivo          : Exclui um registro da tabela agendas_visitas
    //----------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      delete_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AgendaVisitasActionForm f = (AgendaVisitasActionForm) form;
    portalbr.dbobj.view.Jw_agenda_visitas table = new portalbr.dbobj.view.Jw_agenda_visitas();
    //---------------------------------------------------------------------------------------------
    vendas.AgendaVisitaAPI agenda = new vendas.AgendaVisitaAPI(j.getConn(), Integer.parseInt(f.getAgvi_id()));
    agenda.delete();
    //---------------------------------------------------------------------------------------------
    Vector res_Jw_agenda_visitas = (Vector) session.getAttribute("res_Jw_agenda_visitas");
    if (res_Jw_agenda_visitas != null && table != null) {
      res_Jw_agenda_visitas.removeElementAt(Integer.parseInt(f.getPos()));
      session.setAttribute("res_Jw_agenda_visitas", res_Jw_agenda_visitas);
    }
  }

}
