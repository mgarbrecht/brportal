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
 * Creation Date 06/12/2010 12:15:24
 * Last Modify Date 04/04/2013 08:21:02
 */

public class SituacaoAcaoMarketingAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SituacaoAcaoMarketingActionForm f = (SituacaoAcaoMarketingActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/SituacaoAcaoMarketing_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacao_acao_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    SituacaoAcaoMarketingActionForm f = (SituacaoAcaoMarketingActionForm) form;
    Jw_situacao_acao_marketing table = new Jw_situacao_acao_marketing();
    util.consultas.Query query = new util.consultas.Query();
    int diferenca = Integer.parseInt(query.retorna(j, "SELECT to_date('"+f.getDt_final() + "','dd/mm/yyyy')-to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') FROM dual "));
    if (diferenca > 30) {
      throw new Exception("O intervalo de dias não pode ser maior do que 30 dias!");
    }




    StringBuilder parametros = new StringBuilder();
    if (f.getDt_inicial() != "") {
      parametros.append(" AND trunc(a.data_transacao) >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }

    if (f.getDt_final() != "") {
      parametros.append(" AND trunc(a.data_transacao) <= to_date('"+f.getDt_final() + "','dd/mm/yyyy') ");
    }

    if (f.getCodigo_marca() != "") {
      parametros.append(" AND a.codigo_marca = "+f.getCodigo_marca());
    }

    if (f.getRep_cdgo() != "") {
      parametros.append(" AND r.rep_cdgo = '"+f.getRep_cdgo() + "'");
    }


    acesso.Usuario us = new acesso.Usuario();
    us = (acesso.Usuario) session.getAttribute("User");
    acesso.Sessao ses = new acesso.Sessao(session);

    if (ses.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
      parametros.append(" AND a.codigo_marca <> 99 ");
      parametros.append(" AND ((a.codigo_marca <> 98 AND a.codigo_regional = "+f.getCodigo_regional() + ") OR "+f.getCodigo_regional() + " IN (SELECT DISTINCT rv.codigo_regional ");
      parametros.append("                                      FROM acao_marketing_marcas_reps r ");
      parametros.append("                                         , regionais_vendas rv ");
      parametros.append("                                         , rep ");
      parametros.append("                                     WHERE rv.codigo_regional = rep.codigo_regional ");
      parametros.append("                                       AND rep.rep_cdgo = r.rep_cdgo ");
      parametros.append("                                       AND r.seq_acao_mkt = a.seq_acao_mkt)) ");
    } else {
      if (f.getCodigo_regional() != "") {
        parametros.append(" AND a.codigo_regional = "+f.getCodigo_regional());
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" select a.codigo_regional ");
    sb.append("      , pck_regionais_vendas.get_nome(a.codigo_regional) nome_regional ");
    sb.append("      , pck_regionais_vendas.get_sigla(a.codigo_regional) sigla_uf ");
    sb.append("      , a.codigo_marca ");
    sb.append("      , decode(a.codigo_marca,98,'MULTIMARCA',99,'INSTITUCIONAL',pck_marcas_produtos.get_nome(a.codigo_marca)) descricao_marca ");
    sb.append("      , a.seq_acao_mkt acao ");
    sb.append("      , a.data_transacao ");
    sb.append("      , a.cdgo_tmidia ");
    sb.append("      , tm.desc_tmidia ");
    sb.append("      , s.codigo codigo_situacao ");
    sb.append("      , DECODE(a.situacao_acao_mkt, 1, '1 - COTADA' , DECODE(a.situacao_acao_mkt,9,'9 - CANCELADA','2 - APROVADA')) descricao_situacao     ");
    sb.append("      , (SELECT rowtocol('SELECT estagio_cdgo FROM brio.acao_marketing_estagios_status WHERE seq_acao_mkt = '||a.seq_acao_mkt) FROM dual) estagios_marcados ");
    sb.append("      , a.cli_cdgo ");
    sb.append("      , pck_cliente.get_nome(a.cli_cdgo) cli_rzao ");
    sb.append("      , r.rep_cdgo ");
    sb.append("      , r.rep_rzao ");
    sb.append("   FROM acao_marketing a ");
    sb.append("      , tipo_midia     tm ");
    sb.append("      , acao_marketing_situacoes s ");
    sb.append("      , rep r ");
    sb.append("  WHERE a.cdgo_tmidia   = tm.cdgo_tmidia ");
    sb.append("    AND s.codigo        = a.situacao_acao_mkt ");
    sb.append("    AND r.rep_cdgo  (+) = a.rep_cdgo ");
    sb.append(parametros);
    sb.append("  ORDER BY data_transacao DESC ");


    if (false) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_situacao_acao_marketing = j.select(table, sb.toString(), null);


    session.setAttribute("res_Jw_situacao_acao_marketing",res_Jw_situacao_acao_marketing);
    if (!(res_Jw_situacao_acao_marketing != null && res_Jw_situacao_acao_marketing.size() > 0)) {
      throw new Exception("Nenhum registro encontrado.");
    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SituacaoAcaoMarketingActionForm f = (SituacaoAcaoMarketingActionForm) form;
      session.removeAttribute("res_Jw_situacao_acao_marketing");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacao_acao_marketing", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
