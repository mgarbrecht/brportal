package portalbr.dbobj.table;

/** DataBase Object from table TCONTAB.Estados
  * @version 03/04/2013 09:58:03
  */
public class EstadosMetaData {

  public static final String SCHEMA = "TCONTAB";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"EST_UNIFED"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Estados";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","est_unifed","2","true","text","Est_unifed","","","","","","",},
                            {"java.lang.String","est_descri","30","true","text","Est_descri","","","","","","",},
                            {"double","est_icms","6","true","text","Est_icms","","","true","","","",},
                            {"java.lang.String","est_exportador","1","false","text","Est_exportador","","","","","","",},
                            {"int","codigo_regiao","2","true","text","Codigo_regiao","","","true","","","",},
                            {"double","est_icms_interest","7","false","text","Est_icms_interest","","","true","","","",},
                            {"int","est_qtde_dias_transporte","3","false","text","Est_qtde_dias_transporte","","","true","","","",},
                            {"int","pais_codigo","3","true","text","Pais_codigo","","","true","","","",},
                            {"java.lang.String","est_internacional","5","false","text","Est_internacional","","","","","","",},
                            {"double","mark_up","15","false","text","Mark_up","","","true","","","",},
                            {"java.lang.String","regional","25","false","text","Regional","","","","","","",},
                            {"double","est_pis_cofins","6","false","text","Est_pis_cofins","","","true","","","",},
                            {"double","est_publicidade","6","false","text","Est_publicidade","","","true","","","",},
                            {"double","est_desc_banc","6","false","text","Est_desc_banc","","","true","","","",},
                            {"double","est_cpmf","6","false","text","Est_cpmf","","","true","","","",},
                            {"double","est_comissao","6","false","text","Est_comissao","","","true","","","",},
                            {"double","est_frete","6","false","text","Est_frete","","","true","","","",},
                            {"double","est_pontualidade","6","false","text","Est_pontualidade","","","true","","","",},
                            {"double","est_custo_financeiro","6","false","text","Est_custo_financeiro","","","true","","","",},
                            {"java.lang.String","est_unifed_codigo_ibge","2","false","text","Est_unifed_codigo_ibge","","","","","","",},
                            {"double","tra_cdgo_internar","22","false","text","Tra_cdgo_internar","","","true","","","",}
                          };
    return metadata;
  }

}
