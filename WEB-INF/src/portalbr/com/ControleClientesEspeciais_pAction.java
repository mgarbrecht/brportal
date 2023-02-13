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
 * Creation Date 20/02/2017 16:53:50
 * Last Modify Date 19/01/2022 16:25:24
 */

public class ControleClientesEspeciais_pAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ControleClientesEspeciais_pActionForm f = (ControleClientesEspeciais_pActionForm) form;
      session.removeAttribute("controle_clientes_especiais_lote_data_agendamento");
      session.removeAttribute("controle_clientes_especiais_lote_filial_faturamento");
      session.removeAttribute("controle_clientes_especiais_lote_etiqueta");
      session.removeAttribute("controle_clientes_especiais_lote_observacao");
      session.removeAttribute("controle_clientes_especiais_lote_semana_agendamento");
      session.removeAttribute("controle_clientes_especiais_lote_hora");
      session.removeAttribute("controle_clientes_especiais_lote_senha");
      session.removeAttribute("controle_clientes_especiais_lote_modelo_alarme");
      session.removeAttribute("controle_clientes_especiais_lote_certificado_origem");

      session.removeAttribute("informou");
      if (f.getDt_agendamento().equals("__/__/____")) {
        f.setDt_agendamento("");
      }
      if (f.getDt_agendamento() != "" && f.getTipo().equalsIgnoreCase("data_agendamento")) {
        session.setAttribute("controle_clientes_especiais_lote_data_agendamento", f.getDt_agendamento());
        session.setAttribute("informou", true);
      }
      if (f.getEtiqueta() != "" && f.getTipo().equalsIgnoreCase("etiqueta")) {
        session.setAttribute("controle_clientes_especiais_lote_etiqueta", f.getEtiqueta());
        session.setAttribute("informou", true);
      }
      if (f.getObservacao() != "" && f.getTipo().equalsIgnoreCase("observacao")) {
        session.setAttribute("controle_clientes_especiais_lote_observacao", f.getObservacao());
        session.setAttribute("informou", true);
      }
      if (f.getSemana_agendamento() != "" && f.getTipo().equalsIgnoreCase("semana_agendamento")) {
        session.setAttribute("controle_clientes_especiais_lote_semana_agendamento", f.getSemana_agendamento());
        session.setAttribute("informou", true);
      }

      if (f.getHora() != "" && f.getTipo().equalsIgnoreCase("hora")) {
        session.setAttribute("controle_clientes_especiais_lote_hora", f.getHora());
        session.setAttribute("informou", true);
      }

      if (f.getSenha() != "" && f.getTipo().equalsIgnoreCase("senha")) {
        session.setAttribute("controle_clientes_especiais_lote_senha", f.getSenha());
        session.setAttribute("informou", true);
      }

      if (f.getCertificado_origem() != "" && f.getTipo().equalsIgnoreCase("certificado_origem")) {
        session.setAttribute("controle_clientes_especiais_lote_certificado_origem", f.getCertificado_origem());
        session.setAttribute("informou", true);
      }

      if (f.getDt_inspecao() != "" && f.getTipo().equalsIgnoreCase("data_inspecao")) {
        session.setAttribute("controle_clientes_especiais_lote_data_inspecao", f.getDt_inspecao());
        session.setAttribute("informou", true);
      }

      if (f.getFilial_faturamento() != "" && f.getTipo().equalsIgnoreCase("filial_faturamento")) {
        session.setAttribute("controle_clientes_especiais_lote_filial_faturamento", f.getFilial_faturamento());
        session.setAttribute("informou", true);
      }

      if (f.getDt_solicitacao_alarme() != "" && f.getTipo().equalsIgnoreCase("data_solicitacao_alarme")) {
        session.setAttribute("controle_clientes_especiais_lote_data_solicitacao_alarme", f.getDt_solicitacao_alarme());
        session.setAttribute("informou", true);
      }

      if (f.getModelo_alarme() != "" && f.getTipo().equalsIgnoreCase("modelo_alarme")) {
        session.setAttribute("controle_clientes_especiais_lote_modelo_alarme", f.getModelo_alarme());
        session.setAttribute("informou", true);
      }

      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ControleClientesEspeciais_pActionForm f = (ControleClientesEspeciais_pActionForm) form;
      session.setAttribute(mapping.getName(), form);
      f.setEtiqueta("");
      f.setDt_agendamento("");
      f.setFilial_faturamento("");
      f.setObservacao("");
      f.setSemana_agendamento("");
      f.setHora("");
      f.setSenha("");
      f.setCertificado_origem("");
      session.removeAttribute("controle_clientes_especiais_lote_data_agendamento");
      session.removeAttribute("controle_clientes_especiais_lote_filial_faturamento");
      session.removeAttribute("controle_clientes_especiais_lote_etiqueta");
      session.removeAttribute("controle_clientes_especiais_lote_observacao");
      session.removeAttribute("controle_clientes_especiais_lote_semana_agendamento");
      session.removeAttribute("controle_clientes_especiais_lote_hora");
      session.removeAttribute("controle_clientes_especiais_lote_senha");
      session.removeAttribute("controle_clientes_especiais_lote_certificado_origem");
      session.removeAttribute("informou");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }




}
