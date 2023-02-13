package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_notas
  * @version 03/04/2013 09:29:35
  */
public class Jw_ficha_cliente_notasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","empresa","3","false","text","empresa","","","","","","",},
                            {"java.lang.Integer","nota","22","false","text","nota","","","","","","",},
                            {"java.lang.String","titulo","20","false","text","titulo","","","","","","",},
                            {"java.sql.Date","data_emissao","22","false","text","data_emissao","","dd/MM/yyyy","","","","",},
                            {"java.sql.Date","data_vencimento","22","false","text","data_vencimento","","dd/MM/yyyy","","","","",},
                            {"java.lang.Integer","dias_vencido","22","false","text","dias_vencido","","","","","","",},
                            {"java.lang.Double","valor","22","false","text","valor","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT qry.empresa       ,(SELECT nfs.nfs_nmro           FROM nf_saida nfs               ,tit_nf tnf          WHERE nfs.emp_empresa = NVL(tnf.emp_empresa, NULL)            AND nfs.fil_filial = NVL(tnf.fil_filial, NULL)            AND nfs.nfs_nmro = NVL(tnf.nsa_numero, NULL)            AND nfs.nfs_serie = NVL(tnf.nsa_serie, NULL)            AND tnf.emp_empresa = NVL(qry.empresa, NULL)            AND tnf.fil_filial = NVL(qry.filial, NULL)            AND tnf.tip_codigo = NVL(qry.tipo, NULL)            AND tnf.tit_codigo = NVL(qry.titulo, NULL)            AND ROWNUM = 1) nota       ,qry.titulo       ,qry.emis data_emissao       ,qry.vcto data_vencimento       ,qry.dd dias_vencido       ,qry.valor valor   FROM (SELECT t.emp_empresa empresa               ,t.fil_filial filial               ,t.tip_codigo tipo               ,t.tit_codigo titulo               ,t.tit_datemi emis               ,t.tit_datvenc vcto               ,ROUND(((TRUNC(SYSDATE)) - MIN(t.tit_datvenc))) dd               ,SUM(fnc_ctr_saldo_negociacao(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo, t.sit_codigo_situacao_titulo, t.tit_vlpcp, t.tit_vldeb)) valor           FROM titulos t          WHERE tit_status = 'A'            AND EXISTS (SELECT 1                   FROM tipos_de_titulo_por_grupo tit_gru                  WHERE tit_gru.gtt_codigo_grupo_tipo_titulo = 4                    AND NVL(tit_gru.tip_codigo, NULL) = t.tip_codigo)            AND NVL(t.tit_datvenc, NULL) < TRUNC(SYSDATE - 1)            AND NVL(t.tipo_de_mercado, NULL) = 'MI'            AND t.cli_codigo = 3130            AND NOT EXISTS (SELECT 1                   FROM mov_receber m                  WHERE NVL(m.emp_empresa, NULL) = NVL(t.emp_empresa, NULL)                    AND NVL(m.fil_filial, NULL) = NVL(t.fil_filial, NULL)                    AND NVL(m.tip_codigo, NULL) = NVL(t.tip_codigo, NULL)                    AND m.tit_codigo = NVL(t.tit_codigo, NULL)                    AND EXISTS (SELECT 1                           FROM transacoes_por_grupo trn_gru                          WHERE trn_gru.grt_codigo_grupo_transacao = 15                            AND trn_gru.trn_codigo = m.trn_codigo                            AND data_inicial <= SYSDATE                            AND NVL(data_final, SYSDATE) >= SYSDATE)                    AND NVL(m.mov_sequencia, 0) = 0                    AND m.mov_data <= TRUNC(SYSDATE - 1)                    AND ROWNUM = 1)          GROUP BY t.emp_empresa                  ,t.fil_filial                  ,t.tip_codigo                  ,t.tit_codigo                  ,t.tit_datemi                  ,t.tit_datvenc) qry  ORDER BY qry.vcto ASC";
    return query;
  }

}
