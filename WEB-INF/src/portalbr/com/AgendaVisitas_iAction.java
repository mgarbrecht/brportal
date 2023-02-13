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
 * Creation Date 16/02/2006 08:34:20
 * Last Modify Date 04/04/2013 09:43:41
 */

public class AgendaVisitas_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 16/02/2006
    // Objetivo          : Insere um novo registro na tabela agenda_visitas
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      tg_insert_action(mapping, form, request, response);
      insert_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AgendaVisitas_iActionForm f = (AgendaVisitas_iActionForm) form;
    //---------------------------------------------------------------------------------------------
    vendas.AgendaVisitaAPI agenda = new vendas.AgendaVisitaAPI(j.getConn());
    vendas.RepresentanteAPI rep = new vendas.RepresentanteAPI(j.getConn());
    if (f.getCodigo_representante() != "") {
      rep.select(f.getCodigo_representante());
    } else {
      rep.select(f.getAgvi_rep_cdgo());
    }
    agenda.setRepresentante((vendas.Representante) rep);
    agenda.setDataInicial(com.egen.util.text.FormatDate.parseDate(f.getAgvi_dt_inicial()));
    agenda.setDataFinal(com.egen.util.text.FormatDate.parseDate(f.getAgvi_dt_final()));
    agenda.insert();
    //---------------------------------------------------------------------------------------------
    portalbr.dbobj.table.Agenda_visitas table = new portalbr.dbobj.table.Agenda_visitas();
    Vector res_Agenda_visitas = (Vector) session.getAttribute("res_Agenda_visitas");
    if (res_Agenda_visitas != null && table != null) {
      res_Agenda_visitas.addElement(table);
      session.setAttribute("res_Agenda_visitas", res_Agenda_visitas);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 16/02/2006
    // Objetivo          : Verifica se o representante informado pertence à regional.
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AgendaVisitas_iActionForm f = (AgendaVisitas_iActionForm) form;
      //---------------------------------------------------------------------------------------
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
      //---------------------------------------------------------------------------------------
      session.setAttribute(mapping.getName(), form);
    }
    catch (Exception e) {
      throw e;
    } finally {
      if (j != null) {
        j.close();
      }
    }
  }



  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AgendaVisitas_iActionForm f = (AgendaVisitas_iActionForm) form;
      session.removeAttribute("res_Agenda_visitas");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 16/02/2006
    // Objetivo          : Retorna para a tela de filtro:
    //                     /com/AgendaVisitasForm.jsp, executando um select para atualizar os
    //                     registros mostrados.
    //-------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AgendaVisitas_iActionForm f = (AgendaVisitas_iActionForm) form;
      if (f.getRep_cdgo().equals("") && f.getDt_inicial().equals("") && f.getDt_final().equals("")) {
        actionForward = new ActionForward("/com/AgendaVisitasForm.jsp",true);
      } else {
        actionForward = new ActionForward("/com/AgendaVisitasForm.do?select_action="+ "&agvi_rep_cdgo="+f.getRep_cdgo() + "&agvi_dt_inicial="+f.getDt_inicial() + "&agvi_dt_final="+f.getDt_final(), true);

      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


}
