package portalbr.adm;

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
 * Creation Date 24/01/2019 09:45:34
 * Last Modify Date 10/09/2021 12:25:13
 */

public class AnaliseCredito_cgAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AnaliseCredito_cgActionForm f = (AnaliseCredito_cgActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_analise_credito_gerencial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AnaliseCredito_cgActionForm f = (AnaliseCredito_cgActionForm) form;
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    Jw_analise_credito_gerencial table = new Jw_analise_credito_gerencial();
    String cliente = null;
    if (!f.getP_cli_cdgo().equals("0")) {
      if (!f.getP_cli_cdgo().equals("")) {
        cliente = f.getP_cli_cdgo();
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT ma.mes || '/' || ma.ano mes_ano ");
    sb.append("       ,fat.fat_vlr vlr_faturado ");
    sb.append("       ,liq.liq_vlr vlr_liquidado ");
    sb.append("       ,proa.proa_vlr vlr_pror_a ");
    sb.append("       ,prol.prol_vlr vlr_pror_l ");
    sb.append("       ,CASE ");
    sb.append("          WHEN shpv.vlr_total_mes IS NULL AND shpv_g.valor_ini_mes IS NULL AND ");
    sb.append("               shpv_g.valor_fin_mes IS NULL THEN ");
    sb.append("           NULL ");
    sb.append("          ELSE ");
    sb.append("           CASE ");
    sb.append("             WHEN shpv.vlr_total_mes IS NOT NULL THEN ");
    sb.append("              shpv.vlr_total_mes ");
    sb.append("             ELSE ");
    sb.append("              CASE ");
    sb.append("                WHEN nvl(shpv_g.valor_ini_mes, 0) >= 0 AND ");
    sb.append("                     nvl(shpv_g.valor_ini_mes, 0) < 1000 THEN ");
    sb.append("                 shpv_g.valor_ini_mes || ' ' ");
    sb.append("                WHEN nvl(shpv_g.valor_ini_mes, 0) >= 1000 AND ");
    sb.append("                     nvl(shpv_g.valor_ini_mes, 0) < 1000000 THEN ");
    sb.append("                 (shpv_g.valor_ini_mes / 1000) || ' MIL ' ");
    sb.append("                WHEN nvl(shpv_g.valor_ini_mes, 0) >= 1000000 THEN ");
    sb.append("                 (shpv_g.valor_ini_mes / 1000000) || ' MI ' ");
    sb.append("              END || 'A ' || CASE ");
    sb.append("                WHEN nvl(shpv_g.valor_fin_mes, 0) >= 0 AND ");
    sb.append("                     nvl(shpv_g.valor_fin_mes, 0) < 1000 THEN ");
    sb.append("                 shpv_g.valor_fin_mes || ' ' ");
    sb.append("                WHEN nvl(shpv_g.valor_fin_mes, 0) >= 1000 AND ");
    sb.append("                     nvl(shpv_g.valor_fin_mes, 0) < 1000000 THEN ");
    sb.append("                 (shpv_g.valor_fin_mes / 1000) || ' MIL ' ");
    sb.append("                WHEN nvl(shpv_g.valor_fin_mes, 0) >= 1000000 THEN ");
    sb.append("                 (shpv_g.valor_fin_mes / 1000000) || ' MI ' ");
    sb.append("              END ");
    sb.append("           END ");
    sb.append("        END pag_mercado ");
    sb.append("   FROM (SELECT DISTINCT TO_CHAR(LAST_DAY(s.data), 'MM') mes ");
    sb.append("                       , TO_CHAR(LAST_DAY(s.data), 'RRRR') ano ");
    sb.append("                       , NULL ");
    sb.append("           FROM semanas s ");
    sb.append("          WHERE s.data BETWEEN to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy') AND to_date('"+f.getData_final() + "', 'dd/mm/yyyy')) ma ");
    sb.append("       ,(SELECT TO_CHAR(nfs.nfs_dtemis, 'MM') mes ");
    sb.append("              , TO_CHAR(nfs.nfs_dtemis, 'RRRR') ano ");
    sb.append("              , SUM(nfi.nfi_vltot * (nfs.nfs_vltot / nfs.nfs_liqpro)) fat_vlr ");
    sb.append("           FROM nf_saida            nfs ");
    sb.append("              , naturezas_operacoes nat ");
    sb.append("              , nf_item             nfi ");
    sb.append("          WHERE nfs.nfs_dtemis BETWEEN to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy') AND to_date('"+f.getData_final() + "', 'dd/mm/yyyy') ");
    sb.append("            AND nfs.emp_empresa = nfi.emp_empresa ");
    sb.append("            AND nfs.fil_filial = nfi.fil_filial ");
    sb.append("            AND nfs.nfs_nmro = nfi.nfs_nmro ");
    sb.append("            AND nfs.nfs_serie = nfi.nfs_serie ");
    sb.append("            AND nfs.natoper_codigo = nat.codigo ");
    if (cliente != null) {
      sb.append("         AND nfs.cli_cdgo = ").append(cliente);
    } else {
      if (!f.getP_grupo_economico().equals("0")) {
        if (!f.getP_grupo_economico().equals("")) {
          sb.append("            AND nfs.cli_cdgo IN (SELECT cli_cdgo ");
          sb.append("                                   FROM grupo_economico g ");
          sb.append("                                  WHERE g.gre_grupo = ").append(f.getP_grupo_economico());
          sb.append("                                    AND g.status = 'A') ");
        }
      }
      if (!f.getP_clientes().equals("0")) {
        if (!f.getP_clientes().equals("")) {
          sb.append("             AND nfs.cli_cdgo IN ("+f.getP_clientes() + ")");
        }
      }
    }
    sb.append("            AND NVL(nfs.stat_codigo, NULL) > 1 ");
    sb.append("            AND NVL(nat.integracao_contas_receber, NULL) = 'S' ");
    sb.append("          GROUP BY TO_CHAR(nfs.nfs_dtemis, 'MM') ");
    sb.append("                 , TO_CHAR(nfs.nfs_dtemis, 'RRRR')) fat ");
    sb.append("       ,(SELECT TO_CHAR(rf.data_mes, 'MM') mes ");
    sb.append("              , TO_CHAR(rf.data_mes, 'RRRR') ano ");
    sb.append("              , SUM(NVL(rf.valor_02, 0) + NVL(rf.valor_36, 0) + NVL(rf.valor_720, 0) + NVL(rf.valor_2130, 0) + NVL(rf.valora_30, 0)) liq_vlr ");
    sb.append("           FROM resumos_financeiro rf ");
    sb.append("          WHERE rf.data_mes BETWEEN to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy') AND to_date('"+f.getData_final() + "', 'dd/mm/yyyy') ");
    if (cliente != null) {
      sb.append("         AND rf.cli_cdgo = ").append(cliente);
    } else {
      if (!f.getP_grupo_economico().equals("0")) {
        if (!f.getP_grupo_economico().equals("")) {
          sb.append("            AND rf.cli_cdgo IN (SELECT cli_cdgo ");
          sb.append("                                  FROM grupo_economico g ");
          sb.append("                                 WHERE g.gre_grupo = ").append(f.getP_grupo_economico());
          sb.append("                                   AND g.status = 'A') ");
        }
      }
      if (!f.getP_clientes().equals("0")) {
        if (!f.getP_clientes().equals("")) {
          sb.append("             AND rf.cli_cdgo IN ("+f.getP_clientes() + ")");
        }
      }
    }
    sb.append("            AND NOT EXISTS (SELECT 1 ");
    sb.append("                   FROM mov_receber mov ");
    sb.append("                       ,titulos     tit ");
    sb.append("                       ,trans_rec   t ");
    sb.append("                  WHERE mov.mov_datarec BETWEEN ADD_MONTHS(to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy'), -1) + 1 AND to_date('"+f.getData_final() + "', 'dd/mm/yyyy') ");
    sb.append("                    AND mov.emp_empresa = tit.emp_empresa ");
    sb.append("                    AND mov.fil_filial = tit.fil_filial ");
    sb.append("                    AND mov.tip_codigo = tit.tip_codigo ");
    sb.append("                    AND mov.tit_codigo = tit.tit_codigo ");
    sb.append("                    AND NVL(mov.trn_codigo, NULL) = t.trn_codigo ");
    sb.append("                    AND NVL(t.natureza_da_operacao, NULL) = 'C' ");
    sb.append("                    AND NVL(mov.mov_sequencia, 0) = 0 ");
    if (cliente != null) {
      sb.append("         AND tit.cli_codigo = ").append(cliente);
    } else {
      if (!f.getP_grupo_economico().equals("0")) {
        if (!f.getP_grupo_economico().equals("")) {
          sb.append("            AND tit.cli_codigo IN (SELECT cli_cdgo ");
          sb.append("                                     FROM grupo_economico g ");
          sb.append("                                    WHERE g.gre_grupo = ").append(f.getP_grupo_economico());
          sb.append("                                      AND g.status = 'A') ");
        }
      }
      if (!f.getP_clientes().equals("0")) {
        if (!f.getP_clientes().equals("")) {
          sb.append("             AND tit.cli_codigo IN ("+f.getP_clientes() + ")");
        }
      }
    }
    sb.append("                    AND TO_CHAR(rf.data_mes, 'MM') = TO_CHAR(mov.mov_datarec, 'MM') ");
    sb.append("                    AND TO_CHAR(rf.data_mes, 'RRRR') = TO_CHAR(mov.mov_datarec, 'RRRR') ");
    sb.append("                    AND EXISTS (SELECT '1' ");
    sb.append("                                  FROM tipos_de_titulo_por_grupo tip ");
    sb.append("                                 WHERE tip.tip_codigo = tit.tip_codigo ");
    sb.append("                                   AND tip.gtt_codigo_grupo_tipo_titulo = 2 ");
    sb.append("                                   AND tip.data_inicial <= SYSDATE ");
    sb.append("                                   AND NVL(tip.data_final, SYSDATE) >= SYSDATE) ");
    sb.append("                    AND EXISTS (SELECT '1' ");
    sb.append("                                  FROM transacoes_por_grupo tpg ");
    sb.append("                                 WHERE tpg.trn_codigo = NVL(mov.trn_codigo, NULL) ");
    sb.append("                                   AND tpg.grt_codigo_grupo_transacao = 158 ");
    sb.append("                                   AND tpg.data_inicial <= SYSDATE ");
    sb.append("                                   AND NVL(tpg.data_final, SYSDATE) >= SYSDATE) ");
    sb.append("                  GROUP BY TO_CHAR(mov.mov_datarec, 'MM') ");
    sb.append("                         , TO_CHAR(mov.mov_datarec, 'RRRR')) ");
    sb.append("          GROUP BY TO_CHAR(rf.data_mes, 'MM') ");
    sb.append("                 , TO_CHAR(rf.data_mes, 'RRRR') ");
    sb.append("         UNION ");
    sb.append("         SELECT TO_CHAR(mov.mov_data, 'MM') mes ");
    sb.append("              , TO_CHAR(mov.mov_data, 'RRRR') ano ");
    sb.append("              , SUM(ABS(NVL(valor_principal, 0) + NVL(mov.valor_juros, 0) + ");
    sb.append("                        NVL(mov.valor_despesa_bancaria, 0) + ");
    sb.append("                        NVL(mov.valor_despesa_cartorio, 0) + ");
    sb.append("                        NVL(mov.valor_abatimento, 0) + ");
    sb.append("                        NVL(mov.valor_atualizacao_cambial, 0) + ");
    sb.append("                        DECODE(NVL(mov.valor_principal, 0), 0, NVL(valor_desconto, 0), 0))) ");
    sb.append("           FROM mov_receber mov ");
    sb.append("              , titulos     tit ");
    sb.append("              , trans_rec   t ");
    sb.append("          WHERE mov.mov_datarec BETWEEN ADD_MONTHS(to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy'), -1) + 1 AND to_date('"+f.getData_final() + "', 'dd/mm/yyyy') ");
    sb.append("            AND mov.emp_empresa = tit.emp_empresa ");
    sb.append("            AND mov.fil_filial = tit.fil_filial ");
    sb.append("            AND mov.tip_codigo = tit.tip_codigo ");
    sb.append("            AND mov.tit_codigo = tit.tit_codigo ");
    sb.append("            AND NVL(mov.trn_codigo, NULL) = t.trn_codigo ");
    sb.append("            AND NVL(t.natureza_da_operacao, NULL) = 'C' ");
    sb.append("            AND NVL(mov.mov_sequencia, 0) = 0 ");
    if (cliente != null) {
      sb.append("         AND tit.cli_codigo = ").append(cliente);
    } else {
      if (!f.getP_grupo_economico().equals("0")) {
        if (!f.getP_grupo_economico().equals("")) {
          sb.append("            AND tit.cli_codigo IN (SELECT cli_cdgo ");
          sb.append("                                     FROM grupo_economico g ");
          sb.append("                                    WHERE g.gre_grupo = ").append(f.getP_grupo_economico());
          sb.append("                                      AND g.status = 'A') ");
        }
      }
      if (!f.getP_clientes().equals("0")) {
        if (!f.getP_clientes().equals("")) {
          sb.append("             AND tit.cli_codigo IN ("+f.getP_clientes() + ")");
        }
      }
    }
    sb.append("            AND EXISTS (SELECT '1' ");
    sb.append("                          FROM tipos_de_titulo_por_grupo tip ");
    sb.append("                         WHERE tip.tip_codigo = tit.tip_codigo ");
    sb.append("                           AND tip.gtt_codigo_grupo_tipo_titulo = 2 ");
    sb.append("                           AND tip.data_inicial <= SYSDATE ");
    sb.append("                           AND NVL(tip.data_final, SYSDATE) >= SYSDATE) ");
    sb.append("            AND EXISTS (SELECT '1' ");
    sb.append("                          FROM transacoes_por_grupo tpg ");
    sb.append("                         WHERE tpg.trn_codigo = NVL(mov.trn_codigo, NULL) ");
    sb.append("                           AND tpg.grt_codigo_grupo_transacao = 158 ");
    sb.append("                           AND tpg.data_inicial <= SYSDATE ");
    sb.append("                           AND NVL(tpg.data_final, SYSDATE) >= SYSDATE) ");
    sb.append("          GROUP BY TO_CHAR(mov.mov_data, 'MM') ");
    sb.append("                 , TO_CHAR(mov.mov_data, 'RRRR')) liq ");
    sb.append("       ,(SELECT TO_CHAR(mov.mov_data, 'MM') mes ");
    sb.append("              , TO_CHAR(mov.mov_data, 'RRRR') ano ");
    sb.append("              , SUM(fnc_ctr_saldo_titulo(tit.emp_empresa, tit.fil_filial, tit.tip_codigo, tit.tit_codigo, tit.sit_codigo_situacao_titulo, tit.tit_vlpcp, tit.tit_vldeb)) proa_vlr ");
    sb.append("           FROM titulos                 tit ");
    sb.append("               ,mov_receber             mov ");
    sb.append("               ,observacoes_mov_titulos o ");
    sb.append("          WHERE mov.mov_data BETWEEN to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy') AND to_date('"+f.getData_final() + "', 'dd/mm/yyyy') ");
    if (cliente != null) {
      sb.append("         AND tit.cli_codigo = ").append(cliente);
    } else {
      if (!f.getP_grupo_economico().equals("0")) {
        if (!f.getP_grupo_economico().equals("")) {
          sb.append("            AND tit.cli_codigo IN (SELECT cli_cdgo ");
          sb.append("                                     FROM grupo_economico g ");
          sb.append("                                    WHERE g.gre_grupo = ").append(f.getP_grupo_economico());
          sb.append("                                      AND g.status = 'A') ");
        }
      }
      if (!f.getP_clientes().equals("0")) {
        if (!f.getP_clientes().equals("")) {
          sb.append("             AND tit.cli_codigo IN ("+f.getP_clientes() + ")");
        }
      }
    }
    sb.append("            AND NVL(tit.tit_status, NULL) = 'A' ");
    sb.append("            AND NVL(tit.emp_empresa, NULL) = mov.emp_empresa ");
    sb.append("            AND NVL(tit.fil_filial, NULL) = mov.fil_filial ");
    sb.append("            AND NVL(tit.tip_codigo, NULL) = mov.tip_codigo ");
    sb.append("            AND NVL(tit.tit_codigo, NULL) = mov.tit_codigo ");
    sb.append("            AND o.emp_empresa = mov.emp_empresa ");
    sb.append("            AND o.fil_filial = mov.fil_filial ");
    sb.append("            AND o.tip_codigo = mov.tip_codigo ");
    sb.append("            AND o.tit_codigo = mov.tit_codigo ");
    sb.append("            AND o.mov_data = mov.mov_data ");
    sb.append("            AND o.trn_codigo = mov.trn_codigo ");
    sb.append("            AND o.mov_sequencia = mov.sequencia ");
    sb.append("            AND NVL(mov.trn_codigo, NULL) = ('VCT') ");
    sb.append("            AND NVL(mov.mov_sequencia, 0) = 0 ");
    sb.append("            AND NVL(o.mmt_codigo_do_motivo, NULL) = 3 ");
    sb.append("            AND mov.sequencia = (SELECT MAX(mr.sequencia) ");
    sb.append("                        FROM mov_receber             mr ");
    sb.append("                          , observacoes_mov_titulos om ");
    sb.append("                      WHERE mr.emp_empresa = tit.emp_empresa ");
    sb.append("                         AND mr.fil_filial = tit.fil_filial ");
    sb.append("                      AND mr.tip_codigo = tit.tip_codigo ");
    sb.append("                      AND mr.tit_codigo = tit.tit_codigo ");
    sb.append("                        AND mr.trn_codigo = 'VCT' ");
    sb.append("                         AND NVL(mr.mov_sequencia, 0) = 0 ");
    sb.append("                       AND mr.mov_data BETWEEN to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy') AND to_date('"+f.getData_final() + "', 'dd/mm/yyyy') ");
    sb.append("                      AND om.emp_empresa = mr.emp_empresa ");
    sb.append("                      AND om.fil_filial = mr.fil_filial ");
    sb.append("                      AND om.tip_codigo = mr.tip_codigo ");
    sb.append("                         AND om.tit_codigo = mr.tit_codigo ");
    sb.append("                         AND om.mov_data = mr.mov_data ");
    sb.append("                      AND om.trn_codigo = mr.trn_codigo ");
    sb.append("                      AND om.mov_sequencia = mr.sequencia ");
    sb.append("                        AND NVL(om.mmt_codigo_do_motivo, NULL) = 3) ");
    sb.append("          GROUP BY TO_CHAR(mov.mov_data, 'MM') ");
    sb.append("                 , TO_CHAR(mov.mov_data, 'RRRR')) proa ");
    sb.append("       ,(SELECT TO_CHAR(mov.mov_data, 'MM') mes ");
    sb.append("              , TO_CHAR(mov.mov_data, 'RRRR') ano ");
    sb.append("              , SUM(mov.mov_valor) prol_vlr ");
    sb.append("           FROM titulos     tit ");
    sb.append("              , mov_receber mov ");
    sb.append("          WHERE mov.mov_data BETWEEN to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy') AND to_date('"+f.getData_final() + "', 'dd/mm/yyyy') ");
    if (cliente != null) {
      sb.append("         AND tit.cli_codigo = ").append(cliente);
    } else {
      if (!f.getP_grupo_economico().equals("0")) {
        if (!f.getP_grupo_economico().equals("")) {
          sb.append("            AND tit.cli_codigo IN (SELECT cli_cdgo ");
          sb.append("                                     FROM grupo_economico g ");
          sb.append("                                    WHERE g.gre_grupo = ").append(f.getP_grupo_economico());
          sb.append("                                      AND g.status = 'A') ");
        }
      }
      if (!f.getP_clientes().equals("0")) {
        if (!f.getP_clientes().equals("")) {
          sb.append("             AND tit.cli_codigo IN ("+f.getP_clientes() + ")");
        }
      }
    }

    sb.append("            AND NVL(tit.emp_empresa, NULL) = mov.emp_empresa ");
    sb.append("            AND NVL(tit.fil_filial, NULL) = mov.fil_filial ");
    sb.append("            AND NVL(tit.tip_codigo, NULL) = mov.tip_codigo ");
    sb.append("            AND NVL(tit.tit_codigo, NULL) = mov.tit_codigo ");
    sb.append("            AND NVL(mov.mov_sequencia, 0) = 0 ");
    sb.append("            AND EXISTS (SELECT '1' ");
    sb.append("                          FROM transacoes_por_grupo tpg ");
    sb.append("                         WHERE tpg.trn_codigo = NVL(mov.trn_codigo, NULL) ");
    sb.append("                           AND tpg.grt_codigo_grupo_transacao = 158 ");
    sb.append("                           AND tpg.data_inicial <= SYSDATE ");
    sb.append("                           AND NVL(tpg.data_final, SYSDATE) >= SYSDATE) ");
    sb.append("            AND EXISTS (SELECT '1' ");
    sb.append("                          FROM tipos_de_titulo_por_grupo tip ");
    sb.append("                         WHERE tip.tip_codigo = tit.tip_codigo ");
    sb.append("                           AND tip.gtt_codigo_grupo_tipo_titulo = 2 ");
    sb.append("                           AND tip.data_inicial <= SYSDATE ");
    sb.append("                           AND NVL(tip.data_final, SYSDATE) >= SYSDATE) ");
    sb.append("            AND (EXISTS (SELECT 1 ");
    sb.append("                           FROM mov_receber             m ");
    sb.append("                              , observacoes_mov_titulos om ");
    sb.append("                   WHERE tit.emp_empresa = m.emp_empresa ");
    sb.append("                     AND tit.fil_filial = m.fil_filial ");
    sb.append("                     AND tit.tip_codigo = m.tip_codigo ");
    sb.append("                     AND tit.tit_codigo = m.tit_codigo ");
    sb.append("                     AND m.trn_codigo = 'VCT' ");
    sb.append("                     AND om.emp_empresa = NVL(m.emp_empresa, NULL) ");
    sb.append("                     AND om.fil_filial = NVL(m.fil_filial, NULL) ");
    sb.append("                     AND om.tip_codigo = NVL(m.tip_codigo, NULL) ");
    sb.append("                     AND om.tit_codigo = NVL(m.tit_codigo, NULL) ");
    sb.append("                     AND om.mov_data = m.mov_data ");
    sb.append("                     AND NVL(om.mmt_codigo_do_motivo, NULL) = 3) OR EXISTS ");
    sb.append("                 (SELECT 1 ");
    sb.append("                    FROM titulos_origem          too ");
    sb.append("                        ,mov_receber             m ");
    sb.append("                        ,observacoes_mov_titulos om ");
    sb.append("                   WHERE too.emp_empresa_origem = tit.emp_empresa ");
    sb.append("                     AND too.fil_filial_origem = tit.fil_filial ");
    sb.append("                     AND too.tip_codigo_origem = tit.tip_codigo ");
    sb.append("                     AND too.tit_codigo_origem = tit.tit_codigo ");
    sb.append("                     AND too.tip_codigo IN ('NCD', 'NCR', 'RCJ') ");
    sb.append("                     AND m.emp_empresa = too.emp_empresa ");
    sb.append("                     AND m.fil_filial = too.fil_filial ");
    sb.append("                     AND m.tip_codigo = too.tip_codigo ");
    sb.append("                     AND m.tit_codigo = too.tit_codigo ");
    sb.append("                     AND m.trn_codigo = 'VCT' ");
    sb.append("                     AND om.emp_empresa = NVL(m.emp_empresa, NULL) ");
    sb.append("                     AND om.fil_filial = NVL(m.fil_filial, NULL) ");
    sb.append("                     AND om.tip_codigo = NVL(m.tip_codigo, NULL) ");
    sb.append("                     AND om.tit_codigo = NVL(m.tit_codigo, NULL) ");
    sb.append("                     AND om.mov_data = m.mov_data ");
    sb.append("                     AND NVL(om.mmt_codigo_do_motivo, NULL) = 3)) ");
    sb.append("          GROUP BY TO_CHAR(mov.mov_data, 'MM') ");
    sb.append("                  ,TO_CHAR(mov.mov_data, 'RRRR')) prol ");
    sb.append("       ,(SELECT TO_CHAR(TO_DATE(ss.ano, 'RR'), 'RRRR') ano ");
    sb.append("              , LPAD(TO_CHAR(ss.mes), 2, '0') mes ");
    sb.append("              , ss.desc_faixa vlr_total_mes ");
    sb.append("           FROM scpc_hist_pagtos_val2 ss ");
    sb.append("              , (SELECT MAX(b1.id) ID ");
    sb.append("                   FROM brconrec.scpc_consultas b1 ");
    sb.append("                      , esc e ");
    sb.append("                  WHERE SUBSTR(b1.cnpj, 1, LENGTH(b1.cnpj) - 6) = SUBSTR(e.esc_cgc, 1, LENGTH(e.esc_cgc) - 6) ");
    if (cliente != null) {
      sb.append("                 AND e.cli_cdgo = ").append(cliente);
    } else {
      sb.append("         AND 1 = 2 ");
    }
    sb.append("                    AND b1.service_name = 'serasa') b2 ");
    sb.append("          WHERE ss.desc_periodo = 'TOTAL MES' ");
    sb.append("            AND ss.consulta_id = b2.id ");
    sb.append("         ) shpv ");
    sb.append("       ,(SELECT lpad(ss.mes, 2, '0') mes ");
    sb.append("              , '20' || ss.ano ano ");
    sb.append("              , SUM(ss.valor_ini) valor_ini_mes ");
    sb.append("              , SUM(ss.valor_fin) valor_fin_mes ");
    sb.append("           FROM scpc_hist_pagtos_val2 ss ");
    sb.append("          WHERE ss.desc_periodo = 'TOTAL MES' ");
    if (cliente != null) {
      sb.append("        AND 1 = 2 ");
    }
    sb.append("            AND ss.consulta_id IN (SELECT MAX(b1.id) ID ");
    sb.append("                                     FROM brconrec.scpc_consultas b1 ");
    sb.append("                                        , grupo_economico         g ");
    sb.append("                                        , esc                     e ");
    sb.append("                                    WHERE g.cli_cdgo = e.cli_cdgo ");

    if (!f.getP_grupo_economico().equals("0")) {
      if (!f.getP_grupo_economico().equals("")) {
        sb.append("             AND g.gre_grupo = " + f.getP_grupo_economico());
      }
    }
    if (!f.getP_clientes().equals("0")) {
      if (!f.getP_clientes().equals("")) {
        sb.append("             AND g.cli_cdgo in (" + f.getP_clientes() + ")");
      }
    }

    sb.append("                                      AND g.status = 'A' ");
    sb.append("                                      AND SUBSTR(b1.cnpj, 1, LENGTH(b1.cnpj) - 6) = SUBSTR(e.esc_cgc, 1, LENGTH(e.esc_cgc) - 6) ");
    sb.append("                                      AND b1.service_name = 'serasa' ");
    sb.append("                                    GROUP BY e.esc_cgc) ");
    sb.append("          GROUP BY mes ");
    sb.append("                 , ano) shpv_g ");
    sb.append("  WHERE ma.mes = liq.mes(+) ");
    sb.append("    AND ma.ano = liq.ano(+) ");
    sb.append("    AND ma.mes = fat.mes(+) ");
    sb.append("    AND ma.ano = fat.ano(+) ");
    sb.append("    AND ma.mes = proa.mes(+) ");
    sb.append("    AND ma.ano = proa.ano(+) ");
    sb.append("    AND ma.mes = prol.mes(+) ");
    sb.append("    AND ma.ano = prol.ano(+) ");
    sb.append("    AND ma.ano = shpv.ano(+) ");
    sb.append("    AND ma.mes = shpv.mes(+) ");
    sb.append("    AND ma.ano = shpv_g.ano(+) ");
    sb.append("    AND ma.mes = shpv_g.mes(+) ");
    sb.append("  ORDER BY ma.ano DESC ");
    sb.append("         , ma.mes DESC ");

    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }
    Vector res_Jw_analise_credito_gerencial = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_analise_credito_gerencial",res_Jw_analise_credito_gerencial);
    if (res_Jw_analise_credito_gerencial != null && res_Jw_analise_credito_gerencial.size() > 0) {
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_analise_credito_gerencial", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AnaliseCredito_cgActionForm f = (AnaliseCredito_cgActionForm) form;
      session.removeAttribute("res_Jw_analise_credito_gerencial");
      f.setData_inicial("");
      f.setData_final("");
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_analise_credito_gerencial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_inicializa_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AnaliseCredito_cgActionForm f = (AnaliseCredito_cgActionForm) form;
      util.consultas.Query query = new util.consultas.Query();
      f.setData_inicial(query.retorna(j, "select to_char(LAST_DAY(ADD_MONTHS(TRUNC(SYSDATE), -6)) + 1,'dd/mm/yyyy') from dual"));
      f.setData_final(query.retorna(j, "select to_char(TRUNC(LAST_DAY(SYSDATE)),'dd/mm/yyyy') from dual"));
      session.removeAttribute("res_Jw_analise_credito_gerencial");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_analise_credito_gerencial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
