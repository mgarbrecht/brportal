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
 * Creation Date 04/10/2012 15:33:03
 * Last Modify Date 04/04/2013 09:12:35
 */

public class FichaCliente_nAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichaCliente_nActionForm f = (FichaCliente_nActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_cliente_notas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FichaCliente_nActionForm f = (FichaCliente_nActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    boolean temRestricao = false;
    StringBuilder parametros = new StringBuilder();

    if ((sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) || (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL"))) {
      temRestricao = true;
    }

    if (temRestricao) {
      parametros.append("  AND EXISTS (SELECT 1 ");
      parametros.append("                FROM rep r ");
      parametros.append("                   , cliente_representante cr ");
      parametros.append("                   , analistas_regionais a ");
      parametros.append("               WHERE rep_situ = 'A' ");
      parametros.append("                 AND cr.situacao = 'A' ");
      parametros.append("                 AND a.codigo_regional = r.codigo_regional ");
      parametros.append("                 AND r.rep_cdgo = cr.codigo_representante ");

      if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
        parametros.append("              AND r.codigo_regional = " + sessao.getChave());
      }
      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        parametros.append("              AND r.rep_cdgo = '"+sessao.getChave() + "' ");
      }
      if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
        parametros.append("              AND a.codigo_gerente = '"+sessao.getChave() + "' ");
      }
      parametros.append("                 AND cr.codigo_cliente = t.cli_codigo ");
      parametros.append("                 AND cr.codigo_sequencial = t.esc_seqn) ");
    }


    Jw_ficha_cliente_notas table = new Jw_ficha_cliente_notas();

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT qry.empresa ");
    sb.append("       ,(SELECT nfs.nfs_nmro ");
    sb.append("           FROM nf_saida nfs ");
    sb.append("               ,tit_nf tnf ");
    sb.append("          WHERE nfs.emp_empresa = NVL(tnf.emp_empresa, NULL) ");
    sb.append("            AND nfs.fil_filial = NVL(tnf.fil_filial, NULL) ");
    sb.append("            AND nfs.nfs_nmro = NVL(tnf.nsa_numero, NULL) ");
    sb.append("            AND nfs.nfs_serie = NVL(tnf.nsa_serie, NULL) ");
    sb.append("            AND tnf.emp_empresa = NVL(qry.empresa, NULL) ");
    sb.append("            AND tnf.fil_filial = NVL(qry.filial, NULL) ");
    sb.append("            AND tnf.tip_codigo = NVL(qry.tipo, NULL) ");
    sb.append("            AND tnf.tit_codigo = NVL(qry.titulo, NULL) ");
    sb.append("            AND ROWNUM = 1) nota ");
    sb.append("       ,qry.titulo ");
    sb.append("       ,qry.emis data_emissao ");
    sb.append("       ,qry.vcto data_vencimento ");
    sb.append("       ,qry.dd dias_vencido ");
    sb.append("       ,qry.valor valor ");
    sb.append("   FROM (SELECT t.emp_empresa empresa ");
    sb.append("               ,t.fil_filial filial ");
    sb.append("               ,t.tip_codigo tipo ");
    sb.append("               ,t.tit_codigo titulo ");
    sb.append("               ,t.tit_datemi emis ");
    sb.append("               ,t.tit_datvenc vcto ");
    sb.append("               ,ROUND(((TRUNC(SYSDATE)) - MIN(t.tit_datvenc))) dd ");
    sb.append("               ,SUM(fnc_ctr_saldo_negociacao(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo, t.sit_codigo_situacao_titulo, t.tit_vlpcp, t.tit_vldeb)) valor ");
    sb.append("           FROM titulos t ");

    if (session.getAttribute("gre_grupo") != null) {
      sb.append("            , grupo_economico ge ");
    }

    sb.append("          WHERE tit_status = 'A' ");
    sb.append("            AND EXISTS (SELECT 1 ");
    sb.append("                   FROM tipos_de_titulo_por_grupo tit_gru ");
    sb.append("                  WHERE tit_gru.gtt_codigo_grupo_tipo_titulo = 4 ");
    sb.append("                    AND NVL(tit_gru.tip_codigo, NULL) = t.tip_codigo) ");
    sb.append("            AND NVL(t.tit_datvenc, NULL) <= TRUNC(SYSDATE - 1) ");
    sb.append("            AND NVL(t.tipo_de_mercado, NULL) = 'MI' ");

    if (session.getAttribute("cli_cdgo") != null) {
      sb.append("            AND t.cli_codigo = "+ (String) session.getAttribute("cli_cdgo"));
      sb.append("            AND t.esc_seqn = "+ (String) session.getAttribute("esc_seqn"));
    } else {
      sb.append("          AND ge.status = 'A' ");
      sb.append("          AND ge.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
      sb.append("          AND ge.cli_cdgo = t.cli_codigo ");
    }

    sb.append(parametros.toString());

    sb.append("            AND NOT EXISTS (SELECT 1 ");
    sb.append("                   FROM mov_receber m ");
    sb.append("                  WHERE NVL(m.emp_empresa, NULL) = NVL(t.emp_empresa, NULL) ");
    sb.append("                    AND NVL(m.fil_filial, NULL) = NVL(t.fil_filial, NULL) ");
    sb.append("                    AND NVL(m.tip_codigo, NULL) = NVL(t.tip_codigo, NULL) ");
    sb.append("                    AND m.tit_codigo = NVL(t.tit_codigo, NULL) ");
    sb.append("                    AND EXISTS (SELECT 1 ");
    sb.append("                           FROM transacoes_por_grupo trn_gru ");
    sb.append("                          WHERE trn_gru.grt_codigo_grupo_transacao = 15 ");
    sb.append("                            AND trn_gru.trn_codigo = m.trn_codigo ");
    sb.append("                            AND data_inicial <= SYSDATE ");
    sb.append("                            AND NVL(data_final, SYSDATE) >= SYSDATE) ");
    sb.append("                    AND NVL(m.mov_sequencia, 0) = 0 ");
    sb.append("                    AND m.mov_data <= TRUNC(SYSDATE - 1) ");
    sb.append("                    AND ROWNUM = 1) ");
    sb.append("          GROUP BY t.emp_empresa ");
    sb.append("                  ,t.fil_filial ");
    sb.append("                  ,t.tip_codigo ");
    sb.append("                  ,t.tit_codigo ");
    sb.append("                  ,t.tit_datemi ");
    sb.append("                  ,t.tit_datvenc) qry ");
    sb.append("  ORDER BY qry.vcto ASC ");


    Vector res_Jw_ficha_cliente_notas = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_ficha_cliente_notas",res_Jw_ficha_cliente_notas);
    if (!(res_Jw_ficha_cliente_notas != null && res_Jw_ficha_cliente_notas.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_cliente_notas", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
}
