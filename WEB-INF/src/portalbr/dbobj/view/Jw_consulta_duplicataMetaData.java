package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_duplicata
  * @version 17/10/2018 13:16:42
  */
public class Jw_consulta_duplicataMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","status","9","false","text","","","","","","","",},
                            {"java.sql.Timestamp","dt_emissao","22","false","text","Data de Emissão","","dd/MM/yyyy","","","","",},
                            {"java.sql.Timestamp","dt_venc","22","false","text","Data de Vencimento","","dd/MM/yyyy","","","","",},
                            {"double","cli_cdgo","22","false","text","","","","","","","",},
                            {"double","esc_seqn","22","false","text","","","","","","","",},
                            {"java.lang.String","cliente_desc","119","false","text","","","","","","","",},
                            {"java.sql.Timestamp","dt_pagamento","22","false","text","Data de Pagamento","","","","","","",},
                            {"java.sql.Timestamp","triplic","22","false","text","","","","","","","",},
                            {"java.sql.Timestamp","anuencia","22","false","text","Data Anuência","","dd/MM/yyyy","","","","",},
                            {"java.sql.Timestamp","ins_prot","22","false","text","Instrução de Protesto","","","","","","",},
                            {"java.lang.String","carteira","40","false","text","Carteira","","","","","","",},
                            {"java.lang.String","banc","30","false","text","Banco","","","","","","",},
                            {"java.lang.String","agencia_cobranca","5","false","text","Agência de Cobrança","","","","","","",},
                            {"java.lang.String","agencia_cedente","5","false","text","Agência Cedente","","","","","","",},
                            {"java.lang.String","nr_banco","12","false","text","Número do Banco","","","","","","",},
                            {"double","desc_pontualidade","26","false","text","Desconto de Pontualidade","","","","","","",},
                            {"double","desc_antecipacao","26","false","text","Desconto de Antecipação","","","","","","",},
                            {"double","juros","24","false","text","Juros","","","","","","",},
                            {"double","correcao","24","false","text","Correção","","","","","","",},
                            {"double","valor_receb","24","false","text","Valor Recebido","","","","","","",},
                            {"double","valor_abatim","24","false","text","Abatimento","","","","","","",},
                            {"double","desconto","24","false","text","Desconto","","","","","","",},
                            {"double","cartorio","22","false","text","Cartório","","","","","","",},
                            {"double","desban","22","false","text","Despesas Bancárias","","","","","","",},
                            {"double","saldo","22","false","text","Saldo","","","","","","",},
                            {"java.lang.String","empresa","100","false","text","","","","","","","",},
                            {"java.lang.String","filial","4","false","text","","","","","","","",},
                            {"java.lang.String","tip_codigo","3","false","text","","","","","","","",},
                            {"java.lang.String","titulo","8","false","text","","","","","","","",},
                            {"java.lang.String","rep_codigo","5","false","text","","","","","","","",},
                            {"java.sql.Timestamp","rec_prot","12","false","text","","","","","","","",},
                            {"double","valor","24","false","text","Valor","","","","","","",},
                            {"java.lang.String","cliente","78","false","text","","","","","","","",},
                            {"java.lang.String","ped_nmro","22","false","text","","","","","","","",},
                            {"java.lang.String","nf","44","false","text","","","","","","","",},
                            {"java.lang.String","rep","41","false","text","","","","","","","",},
                            {"double","encargos","22","false","text","","","","","","","",},
                            {"double","valor_vendor","24","false","text","","","","","","","",},
                            {"java.lang.String","prt_codigo","40","false","text","Prt_codigo","","","","","","",},
                            {"java.lang.String","vendor","40","false","text","Vendor","","","","","","",},
                            {"java.lang.String","esc_cgc","40","false","text","esc_cgc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DECODE(tit_status, 'A', 'Aberto', 'L', 'Liquidado', 'Cancelado') status      ,tit_datemi dt_emissao      ,tit_datvenc dt_venc      ,t.cli_codigo cli_cdgo      ,t.esc_seqn esc_seqn      ,t.cli_codigo || '-' || t.esc_seqn || ' - ' || cli_rzao cliente_desc      ,tit_datrec dt_pagamento      ,t.tit_dt_emissao_triplicata triplic      ,t.tit_dt_emissao_anuencia anuencia      ,t.tit_dt_emissao_ins_protesto ins_prot      ,car_descri carteira      ,prt_descri banc      ,tit_agecob agencia_cobranca      ,tit_ageced agencia_cedente      ,tit_numbco nr_banco      ,tit_dspont desc_pontualidade      ,tit_dsante desc_antecipacao      ,tit_vljuro juros      ,tit_vlcor correcao      ,tit_vlrec valor_receb      ,tit_abatim valor_abatim      ,tit_vldesc desconto      ,0 cartorio      ,0 desban      ,TRUNC(NVL(tit_valor, 0) - NVL(tit_vlrec, 0) - NVL(tit_vldesc, 0) - NVL(tit_abatim, 0) + NVL(0, 0) + NVL(0, 0) + NVL(tit_vljuro, 0) + NVL(tit_vlcor, 0), 2) saldo      ,t.emp_empresa empresa      ,t.fil_filial filial      ,t.tip_codigo tip_codigo      ,t.tit_codigo titulo      ,t.rep_codigo rep_codigo      ,t.tit_dt_receb_protesto rec_prot      ,tit_valor valor      ,cli.cli_cdgo || ' - ' || NVL(cli.cli_rzao, cli.cli_nome) cliente      ,nfv.ped_nmro      ,tn.nsa_numero || '-' || tn.nsa_serie nf      ,rep.rep_cdgo || '-' || NVL(rep.rep_rzao, rep.rep_nome) rep      ,t.valor_titulo_vencimento - t.tit_valor encargos      ,t.valor_titulo_vencimento valor_vendor      ,p.prt_codigo      ,'S' vendor	  ,'' esc_cgc  FROM brconrec.titulos t      ,cart_cobranca c      ,portadores p      ,notas_fiscais_saida_ped_venda nfv      ,tit_nf tn      ,cli      ,rep WHERE c.car_codigo(+) = t.car_codigo   AND p.prt_codigo(+) = t.prt_codigo   AND tn.emp_empresa = t.emp_empresa   AND tn.fil_filial = t.fil_filial   AND tn.tip_codigo = t.tip_codigo   AND tn.tit_codigo = t.tit_codigo   AND nfv.nfs_nmro = tn.nsa_numero   AND nfv.nfs_serie = tn.nsa_serie   AND nfv.emp_empresa = tn.emp_empresa   AND nfv.fil_filial = tn.fil_filial   AND cli.cli_cdgo = t.cli_codigo   AND rep.rep_cdgo = t.rep_codigo";
    return query;
  }

}
