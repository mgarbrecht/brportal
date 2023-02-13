package portalbr.dbobj.table;

/** DataBase Object from table CPG.Dom_obrigacao
  * @version 08/05/2012 16:04:00
  */
public class Dom_obrigacaoMetaData {

  public static final String SCHEMA = "CPG";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NM_OBRI","CD_ENTI","CD_TIPO","CODI_TIPO_ENDER"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "DOM_OBRIGACAO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","nm_obri","10","true","text","Nm_obri","","","","","","",},
                            {"java.lang.String","cd_enti","9","true","text","Cd_enti","","","","","","",},
                            {"java.lang.String","cd_tipo","1","true","text","Cd_tipo","","","","","","",},
                            {"java.lang.String","codi_tipo_ender","3","true","text","Codi_tipo_ender","","","","","","",},
                            {"java.lang.Integer","centro_codigo","6","true","text","Centro_codigo","","","true","","","",},
                            {"java.lang.String","emp_empresa","3","true","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","true","text","Fil_filial","","","","","","",},
                            {"java.lang.String","unn_codigo","3","true","text","Unn_codigo","","","","","","",},
                            {"java.lang.String","cd_tiob","3","true","text","Cd_tiob","","","","","","",},
                            {"java.lang.Double","vl_abatim","12","true","text","Vl_abatim","","##,##0.00","true","","","",},
                            {"java.lang.Integer","cd_docto","8","true","text","Cd_docto","","","true","","","",},
                            {"java.sql.Date","dt_vcto","19","true","text","Dt_vcto","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Double","vl_cred","16","true","text","Vl_cred","","##,##0.00","true","","","",},
                            {"java.lang.Double","vl_desp","12","true","text","Vl_desp","","##,##0.00","true","","","",},
                            {"java.lang.Double","vl_face","20","true","text","Vl_face","","##,##0.00","true","","","",},
                            {"java.lang.Double","vl_obri","16","true","text","Vl_obri","","##,##0.00","true","","","",},
                            {"java.lang.Double","vl_pago","16","true","text","Vl_pago","","##,##0.00","true","","","",},
                            {"java.sql.Timestamp","dt_emis","19","true","text","Dt_emis","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","cd_situ","1","true","text","Cd_situ","","","","","","",},
                            {"java.lang.Integer","codi_moeda","4","true","text","Codi_moeda","","","true","","","",},
                            {"java.lang.String","cd_loco","1","true","text","Cd_loco","","","","","","",},
                            {"java.lang.Double","vl_juro","12","true","text","Vl_juro","","##,##0.00","true","","","",},
                            {"java.lang.Double","vl_dsc_pr","12","true","text","Vl_dsc_pr","","##,##0.00","true","","","",},
                            {"java.lang.Double","vl_desc","12","true","text","Vl_desc","","##,##0.00","true","","","",},
                            {"java.lang.Double","vl_corr","12","true","text","Vl_corr","","##,##0.00","true","","","",},
                            {"java.lang.Integer","codi_banco","5","true","text","Codi_banco","","","true","","","",},
                            {"java.lang.String","cd_mepa","6","false","text","Cd_mepa","","","","","","",},
                            {"java.lang.String","cd_recu","6","false","text","Cd_recu","","","","","","",},
                            {"java.lang.String","cd_age_cob","10","false","text","Cd_age_cob","","","","","","",},
                            {"java.lang.String","cd_bancario","12","false","text","Cd_bancario","","","","","","",},
                            {"java.lang.String","cd_status","1","false","text","Cd_status","","","","","","",},
                            {"java.sql.Timestamp","dt_pgto","19","false","text","Dt_pgto","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","te_observ","100","false","text","Te_observ","","","","","","",},
                            {"java.sql.Timestamp","dt_vct_ant","19","false","text","Dt_vct_ant","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","dt_prot","19","false","text","Dt_prot","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.sql.Timestamp","dt_lim_dsc","19","false","text","Dt_lim_dsc","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","in_repa","1","false","text","In_repa","","","","","","",},
                            {"java.lang.Integer","nu_repa","6","false","text","Nu_repa","","","true","","","",},
                            {"java.sql.Timestamp","dt_entrada","19","true","text","Dt_entrada","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","cco_codigo","5","false","text","Cco_codigo","","","true","","","",},
                            {"java.lang.Integer","cd_motjuro","3","false","text","Cd_motjuro","","","true","","","",},
                            {"java.lang.String","intr_juro_desc","1","false","text","Intr_juro_desc","","","","","","",},
                            {"java.lang.Integer","poi_codigo","5","true","text","Poi_codigo","","","true","","","",},
                            {"java.lang.String","area","1","true","text","Area","","","","","","",},
                            {"java.lang.Integer","codigo_departamento","5","false","text","Codigo_departamento","","","true","","","",},
                            {"java.lang.Double","vl_previsao_inicial","16","false","text","Vl_previsao_inicial","","##,##0.00","true","","","",},
                            {"java.lang.Integer","subgrupo_poi","5","false","text","Subgrupo_poi","","","true","","","",},
                            {"java.lang.String","situacao_pgto_escritural","2","true","text","Situacao_pgto_escritural","","","","","","",},
                            {"java.lang.String","nro_pagamento","16","false","text","Nro_pagamento","","","","","","",},
                            {"java.lang.String","codigo_barra","60","false","text","Codigo_barra","","","","","","",},
                            {"java.lang.String","cod_carteira","3","false","text","Cod_carteira","","","","","","",},
                            {"java.lang.String","cod_seu_numero","15","false","text","Cod_seu_numero","","","","","","",},
                            {"java.lang.String","cod_nosso_numero","12","false","text","Cod_nosso_numero","","","","","","",},
                            {"java.lang.String","conta_corrente_fornecedor","20","false","text","Conta_corrente_fornecedor","","","","","","",},
                            {"java.lang.Integer","cap_sequencia","8","false","text","Cap_sequencia","","","true","","","",},
                            {"java.lang.Double","oco_numero","-127","false","text","Oco_numero","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
