package portalbr.ind;

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
 * Creation Date 27/03/2019 09:32:04
 * Last Modify Date 07/06/2019 15:00:50
 */

public class SolicitacaoColetasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoColetasActionForm f = (SolicitacaoColetasActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/ind/SolicitacaoColetas_rForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_coletas_solicitacoes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    SolicitacaoColetasActionForm f = (SolicitacaoColetasActionForm) form;
    Jw_coletas_solicitacoes table = new Jw_coletas_solicitacoes();
    StringBuilder sb = new StringBuilder();
    StringBuilder sbParametros = new StringBuilder();
    StringBuilder sbDataInicial = new StringBuilder();
    StringBuilder sbDataFinal = new StringBuilder();
    boolean informouHoraInicial = false;
    boolean informouHoraFinal = false;
    boolean informouDataInicial = false;
    boolean informouDataFinal = false;

    if (f.getData_solicitacao() != "") {
      if (!f.getData_solicitacao().equals("__/__/____")) {
        sbDataInicial.append(f.getData_solicitacao());
        informouDataInicial = true;
      }
    }

    if (f.getData_solicitacao_final() != "") {
      if (!f.getData_solicitacao_final().equals("__/__/____")) {
        sbDataFinal.append(f.getData_solicitacao_final());
        informouDataFinal = true;
      }
    }

    if (f.getHora_inicial() != "") {
      if (!f.getHora_inicial().equals("__:__")) {
        informouHoraInicial = true;
        sbDataInicial.append(" ");
        sbDataInicial.append(f.getHora_inicial());
      }
    }

    if (f.getHora_final() != "") {
      if (!f.getHora_final().equals("__:__")) {
        informouHoraFinal = true;
        sbDataFinal.append(" ");
        sbDataFinal.append(f.getHora_final());
      }
    }

    if (f.getId_solicitacao_coleta() != "") {
      sbParametros.append(" AND c.id_solicitacao_coleta = " + f.getId_solicitacao_coleta());
    }
    if (f.getTra_cdgo() != "") {
      sbParametros.append(" AND c.tra_cdgo = " + f.getTra_cdgo());
    }

    if (f.getFil_filial() != "") {
      sbParametros.append(" AND c.fil_filial = '" + f.getFil_filial() + "'");
    }

    if (informouDataInicial) {
      if (informouHoraInicial) {
        sbParametros.append(" AND c.data_solicitacao >= to_date('"+sbDataInicial.toString() + "','dd/mm/yyyy hh24:mi') ");
      } else {
        sbParametros.append(" AND c.data_solicitacao >= to_date('"+sbDataInicial.toString() + "','dd/mm/yyyy') ");
      }
    }

    if (informouDataFinal) {
      if (informouHoraFinal) {
        sbParametros.append(" AND c.data_solicitacao <= to_date('"+sbDataFinal.toString() + "','dd/mm/yyyy hh24:mi') ");
      } else {
        sbParametros.append(" AND c.data_solicitacao <= to_date('"+sbDataFinal.toString() + "','dd/mm/yyyy') + 1 ");
      }
    }

    sb.append(" SELECT c.id_solicitacao_coleta ");
    sb.append("      , c.data_solicitacao ");
    sb.append("      , c.solicitante ");
    sb.append("      , c.data_atendi_solicitacao ");
    sb.append("      , c.emp_empresa ");
    sb.append("      , e.emp_razsoc ");
    sb.append("      , c.fil_filial ");
    sb.append("      , pck_filial.get_nome(c.fil_filial) fil_filial_descricao ");
    sb.append("      , c.fil_filial_destino ");
    sb.append("      , pck_filial.get_nome(c.fil_filial_destino) fil_filial_destino_descricao ");
    sb.append("      , c.tra_cdgo ");
    sb.append("      , pck_transportadora.get_nome(c.tra_cdgo) tra_nome ");
    sb.append("      , c.quantidade_volumes ");
    sb.append("      , c.quantidade_cubica ");
    sb.append("      , c.especie ");
    sb.append("      , c.tipo_caminhao ");
    sb.append("      , c.observacoes ");
    sb.append("      , c.usuario_inclusao ");
    sb.append("      , c.dthr_inclusao ");
    sb.append("      , c.usuario_alteracao ");
    sb.append("      , c.dthr_alteracao ");
    sb.append("      , c.tipo_solicitacao ");
    sb.append("      , CASE ");
    sb.append("          WHEN c.tipo_solicitacao = 1 THEN ");
    sb.append("           'COLETA' ");
    sb.append("          WHEN c.tipo_solicitacao = 2 THEN ");
    sb.append("           'CARRO EXTRA' ");
    sb.append("          WHEN c.tipo_solicitacao = 3 THEN ");
    sb.append("           'TRANSFERÊNCIA' ");
    sb.append("        END descricao_tipo_solicitacao ");
    sb.append("      , c.status ");
    sb.append("      , CASE ");
    sb.append("          WHEN c.status = 'A' THEN ");
    sb.append("           'ATENDIDA' ");
    sb.append("          WHEN c.status = 'S' THEN ");
    sb.append("           'SOLICITADA' ");
    sb.append("          ELSE ");
    sb.append("           'CANCELADA' ");
    sb.append("        END status_descricao ");
    sb.append("      , c.email_enviado ");
    sb.append("      , CASE ");
    sb.append("          WHEN c.email_enviado = 'S' THEN ");
    sb.append("           'SIM' ");
    sb.append("          WHEN c.email_enviado = 'N' THEN ");
    sb.append("           'N&#258;O' ");
    sb.append("        END email_enviado_descricao ");
    sb.append("   FROM coletas_solicitacoes c ");
    sb.append("      , empresa              e ");
    sb.append("      , filial               f ");
    sb.append("  WHERE c.emp_empresa = e.emp_empresa ");
    sb.append("    AND f.emp_empresa = c.emp_empresa ");
    sb.append("    AND f.fil_filial = c.fil_filial ");
    sb.append(sbParametros.toString());
    sb.append("  ORDER BY c.data_solicitacao DESC ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_coletas_solicitacoes = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_coletas_solicitacoes",res_Jw_coletas_solicitacoes);
    if (res_Jw_coletas_solicitacoes != null && res_Jw_coletas_solicitacoes.size() > 0) {
    } else {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoColetasActionForm f = (SolicitacaoColetasActionForm) form;
      session.removeAttribute("res_Jw_coletas_solicitacoes");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_coletas_solicitacoes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
