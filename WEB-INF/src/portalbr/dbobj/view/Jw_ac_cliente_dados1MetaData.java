package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ac_cliente_dados1
  * @version 16/05/2014 08:34:33
  */
public class Jw_ac_cliente_dados1MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cod","22","false","text","cod","","","","","","",},
                            {"java.lang.String","seq","22","false","text","seq","","","","","","",},
                            {"java.lang.String","enome","35","false","text","enome","","","","","","",},
                            {"java.sql.Timestamp","dt_pricom","22","false","text","dt_pricom","","","","","","",},
                            {"double","vl_pricom","24","false","text","vl_pricom","","","","","","",},
                            {"java.sql.Timestamp","dt_ultcom","22","false","text","dt_ultcom","","","","","","",},
                            {"double","vl_ultcom","24","false","text","vl_ultcom","","","","","","",},
                            {"java.sql.Timestamp","dt_maicom","22","false","text","dt_maicom","","","","","","",},
                            {"double","vl_maicom","24","false","text","vl_maicom","","","","","","",},
                            {"double","somafat","22","false","text","somafat","","","","","","",},
                            {"double","vlfat","22","false","text","vlfat","","","","","","",},
                            {"double","pgto_pontual_qtde","22","false","text","pgto_pontual_qtde","","","","","","",},
                            {"double","pgto_pontual_valor","22","false","text","pgto_pontual_valor","","","","","","",},
                            {"double","qtd_15","22","false","text","qtd_15","","","","","","",},
                            {"double","mm_15","22","false","text","mm_15","","","","","","",},
                            {"double","qtd15","22","false","text","qtd15","","","","","","",},
                            {"double","mm15","22","false","text","mm15","","","","","","",},
                            {"double","car","22","false","text","car","","","","","","",},
                            {"double","vlcar","22","false","text","vlcar","","","","","","",},
                            {"double","pgpultm","22","false","text","pgpultm","","","","","","",},
                            {"double","pgpultmsoma","22","false","text","pgpultmsoma","","","","","","",},
                            {"double","pgultm","22","false","text","pgultm","","","","","","",},
                            {"double","pgultmsoma","22","false","text","pgultmsoma","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT c.cli_cdgo cod      ,e.esc_seqn seq      ,cli_rzao enome      ,c.cli_pricom dt_pricom      ,c.cli_vlpricom vl_pricom      ,ultima_compra.dt_ultima_compra dt_ultcom      ,c.cli_vlultcom vl_ultcom      ,c.cli_dtmaicom dt_maicom      ,c.cli_maicom vl_maicom      ,faturamento.soma somafat      ,faturamento.vlfat      ,pagamentos_pontuais.qtdpont pgto_pontual_qtde      ,pagamentos_pontuais.pont pgto_pontual_valor      ,pagamentos_atraso.qtd_15      ,pagamentos_atraso.mm_15 mm_15      ,pagamentos_atraso.qtd15      ,pagamentos_atraso.mm15 mm15      ,cartorio.car      ,cartorio.vlcar      ,pagamentos_penultimo_mes.pgpultm      ,pagamentos_penultimo_mes.pgpultmsoma      ,pagamentos_ultimo_mes.pgultm      ,pagamentos_ultimo_mes.pgultmsoma  FROM cli c      ,esc e      ,(SELECT MAX(nfs_dtemis) dt_ultima_compra              ,cli_cdgo          FROM nf_saida         WHERE cli_cdgo = 5123           AND NVL(stat_codigo, NULL) = 4         GROUP BY cli_cdgo) ultima_compra      ,(SELECT COUNT(*) soma              ,SUM(nf.nfs_vltot) vlfat              ,nf.cli_cdgo          FROM nf_saida nf              ,fat.naturezas_operacoes x         WHERE nf.natoper_codigo = x.codigo           AND NVL(x.integracao_contas_receber, NULL) = 'S'           AND nf.nfs_dtemis BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE           AND nf.stat_codigo <> 1           AND nf.cli_cdgo = 5123         GROUP BY nf.cli_cdgo) faturamento      ,(SELECT SUM(qtdpont) qtdpont              ,SUM(pont) pont              ,cli_codigo          FROM (SELECT SUM(DECODE(SIGN(tit_datrec - tit_datvenc), 0, 1, -1, 1, DECODE(NVL(tit_vldesc, 0), 0, 0, 1))) qtdpont                      ,SUM(DECODE(SIGN(tit_datrec - tit_datvenc), 0, NVL(tit_vlrec, 0), -1, NVL(tit_vlrec, 0), DECODE(NVL(tit_vldesc, 0), 0, 0, NVL(tit_vlrec, 0)))) pont                      ,cli_codigo                  FROM titulos                 WHERE tit_status = 'L'                   AND tip_codigo <> 'NTD'                   AND tit_datrec IS NOT NULL                   AND cli_codigo = 5123                 GROUP BY cli_codigo                UNION                SELECT SUM(DECODE(SIGN(tit_datrec - tit_datvenc), 0, 1, -1, 1, DECODE(NVL(tit_vldesc, 0), 0, 0, 1))) qtdpont                      ,SUM(DECODE(SIGN(tit_datrec - tit_datvenc), 0, NVL(tit_vlrec, 0), -1, NVL(tit_vlrec, 0), DECODE(NVL(tit_vldesc, 0), 0, 0, NVL(tit_vlrec, 0)))) pont                      ,cli_codigo                  FROM titulos                 WHERE tit_status = 'L'                   AND tip_codigo <> 'NTD'                   AND TO_CHAR(tit_datrec, 'd') = 2                   AND TO_CHAR(tit_datvenc, 'd') IN (1, 7)                   AND cli_codigo = 5123                 GROUP BY cli_codigo)         GROUP BY cli_codigo) pagamentos_pontuais      ,(SELECT SUM(DECODE(SIGN((tit_datrec - tit_datvenc) - 15), -1, 1, 0)) qtd_15              ,SUM(DECODE(SIGN((tit_datrec - tit_datvenc) - 15), -1, NVL(tit_vlrec, 0), 0)) mm_15              ,SUM(DECODE(SIGN((tit_datrec - tit_datvenc) - 15), 1, 1, 0)) qtd15              ,SUM(DECODE(SIGN((tit_datrec - tit_datvenc) - 15), 1, NVL(tit_vlrec, 0), 0)) mm15              ,cli_codigo          FROM titulos t         WHERE tit_status = 'L'           AND tip_codigo <> 'NTD'           AND tit_datrec > tit_datvenc           AND tit_datrec IS NOT NULL           AND cli_codigo = 5123           AND t.tit_codigo NOT IN (SELECT m.tit_codigo                                      FROM mov_receber m                                     WHERE m.tit_codigo = t.tit_codigo                                       AND m.emp_empresa = t.emp_empresa                                       AND m.fil_filial = t.fil_filial                                       AND m.tip_codigo = t.tip_codigo                                       AND m.trn_codigo IN ('CAR'))         GROUP BY cli_codigo) pagamentos_atraso      ,(SELECT SUM(DECODE(m.trn_codigo, 'CAR', 1, 0)) car              ,SUM(DECODE(m.trn_codigo, 'CAR', NVL(t.tit_vlrec, 0), 0)) vlcar              ,cli_codigo          FROM mov_receber m              ,titulos t         WHERE t.emp_empresa = m.emp_empresa           AND t.fil_filial = m.fil_filial           AND t.tip_codigo = m.tip_codigo           AND t.tit_codigo = m.tit_codigo           AND t.tip_codigo <> 'NTD'           AND tit_status = 'L'           AND m.trn_codigo = 'CAR'           AND t.cli_codigo = 5123         GROUP BY cli_codigo) cartorio      ,(SELECT SUM(pgpultm) pgpultm              ,SUM(pgpultmsoma) pgpultmsoma              ,cli_codigo          FROM (SELECT COUNT(m.trn_codigo) pgpultm                      ,SUM(NVL(m.valor_principal, 0) + NVL(m.valor_abatimento, 0)) pgpultmsoma                      ,cli_codigo                  FROM mov_receber m                      ,titulos t                      ,trans_rec tr                 WHERE NVL(t.cli_codigo, NULL) = 5123                   AND m.tit_codigo = t.tit_codigo                   AND m.trn_codigo = tr.trn_codigo                   AND NVL(tr.natureza_da_operacao, NULL) IN ('D', 'C')                   AND NVL(m.mov_sequencia, 0) = 0                   AND m.mov_data BETWEEN TRUNC(ADD_MONTHS(SYSDATE, -2), 'MONTH') AND LAST_DAY(ADD_MONTHS(SYSDATE, -2))                 GROUP BY cli_codigo                UNION                SELECT COUNT(*) pgpultm                      ,SUM(NVL(che_valor, 0)) pgpultmsoma                      ,cli_cdgo cli_codigo                  FROM cheque m                 WHERE m.cli_cdgo = 5123                   AND (NVL(m.che_dtdep, NULL) BETWEEN TRUNC(ADD_MONTHS(SYSDATE, -2), 'MONTH') AND LAST_DAY(ADD_MONTHS(SYSDATE, -2)) OR (NVL(m.che_dtrec, NULL) BETWEEN TRUNC(ADD_MONTHS(SYSDATE, -2), 'MONTH') AND LAST_DAY(ADD_MONTHS(SYSDATE, -2)) AND NVL(m.che_dtdep, NULL) IS NULL))                   AND m.che_status = 'L'                 GROUP BY cli_cdgo)         GROUP BY cli_codigo) pagamentos_penultimo_mes      ,(SELECT SUM(pagto) pgultm              ,SUM(valor) pgultmsoma              ,cli_codigo          FROM (SELECT COUNT(m.trn_codigo) pagto                      ,SUM(NVL(m.valor_principal, 0) + NVL(m.valor_abatimento, 0)) valor                      ,t.cli_codigo                  FROM mov_receber m                      ,titulos t                      ,trans_rec tr                 WHERE NVL(t.cli_codigo, NULL) = 5123                   AND m.tit_codigo = t.tit_codigo                   AND m.trn_codigo = tr.trn_codigo                   AND NVL(tr.natureza_da_operacao, NULL) IN ('D', 'C')                   AND NVL(m.mov_sequencia, 0) = 0                   AND m.mov_data BETWEEN TRUNC(ADD_MONTHS(SYSDATE, -1), 'MONTH') AND LAST_DAY(ADD_MONTHS(SYSDATE, -1))                 GROUP BY t.cli_codigo                UNION                SELECT COUNT(*) pagto                      ,SUM(NVL(che_valor, 0)) valor                      ,m.cli_cdgo cli_codigo                  FROM cheque m                 WHERE m.cli_cdgo = 5123                   AND (NVL(m.che_dtdep, NULL) BETWEEN TRUNC(ADD_MONTHS(SYSDATE, -1), 'MONTH') AND LAST_DAY(ADD_MONTHS(SYSDATE, -1)) OR (NVL(m.che_dtrec, NULL) BETWEEN TRUNC(ADD_MONTHS(SYSDATE, -1), 'MONTH') AND LAST_DAY(ADD_MONTHS(SYSDATE, -1)) AND NVL(m.che_dtdep, NULL) IS NULL))                   AND m.che_status = 'L'                 GROUP BY cli_cdgo)         GROUP BY cli_codigo) pagamentos_ultimo_mes WHERE c.cli_cdgo = 5123   AND c.cli_cdgo = e.cli_cdgo   AND ultima_compra.cli_cdgo(+) = c.cli_cdgo   AND faturamento.cli_cdgo(+) = c.cli_cdgo   AND pagamentos_pontuais.cli_codigo(+) = c.cli_cdgo   AND pagamentos_atraso.cli_codigo(+) = c.cli_cdgo   AND cartorio.cli_codigo(+) = c.cli_cdgo   AND pagamentos_penultimo_mes.cli_codigo(+) = c.cli_cdgo   AND pagamentos_ultimo_mes.cli_codigo(+) = c.cli_cdgo   AND ROWNUM = 1";
    return query;
  }

}
