package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Esc
  * @version 21/08/2013 11:17:37
  */
public class EscMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CLI_CDGO","ESC_SEQN"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ESC";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cli_cdgo","22","true","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.Integer","esc_seqn","4","true","text","Esc_seqn","","","true","","","",},
                            {"java.lang.String","reg_cdgo","3","false","text","Reg_cdgo","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","Rep_cdgo","","","","","","",},
                            {"java.lang.Double","esc_icms","6","true","text","Esc_icms","","##,##0.00","true","","","",},
                            {"java.lang.Integer","esc_cgc","14","true","text","Esc_cgc","","","true","","","",},
                            {"java.lang.String","esc_insm","15","false","text","Esc_insm","","","","","","",},
                            {"java.lang.String","esc_inse","18","false","text","Esc_inse","","","","","","",},
                            {"java.lang.String","esc_mald","1","true","text","Esc_mald","","","","","","",},
                            {"java.lang.String","prt_codigo","4","false","text","Prt_codigo","","","","","","",},
                            {"java.lang.Integer","tra_cdgo","22","true","text","Tra_cdgo","","","true","","","",},
                            {"java.lang.String","esc_indic_prote","3","true","text","Esc_indic_prote","","","","","","",},
                            {"java.lang.Integer","esc_num_dias_prote","3","true","text","Esc_num_dias_prote","","","true","","","",},
                            {"java.lang.String","rep_projetado","3","false","text","Rep_projetado","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","esc_cli_tem_cd","1","false","text","Esc_cli_tem_cd","","","","","","",},
                            {"java.lang.String","esc_situacao","1","true","text","Esc_situacao","","","","","","",},
                            {"java.lang.String","esc_observacao","80","false","text","Esc_observacao","","","","","","",},
                            {"java.lang.Integer","esc_ean","14","false","text","Esc_ean","","","true","","","",},
                            {"java.lang.String","est_unifed","2","true","text","Est_unifed","","","","","","",},
                            {"java.lang.String","moe_codigo","3","false","text","Moe_codigo","","","","","","",},
                            {"java.lang.Integer","idio_codigo_idioma","3","false","text","Idio_codigo_idioma","","","true","","","",},
                            {"java.lang.String","esc_email","100","false","text","Esc_email","","","","","","",},
                            {"java.lang.Integer","codigo_motivo","2","false","text","Codigo_motivo","","","true","","","",},
                            {"java.lang.Integer","tra_consig","3","false","text","Tra_consig","","","true","","","",},
                            {"java.sql.Date","data_primeira_compra","10","false","text","Data_primeira_compra","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Double","valor_primeira_compra","16","false","text","Valor_primeira_compra","","##,##0.00","true","","","",},
                            {"java.sql.Date","data_ultima_compra","10","false","text","Data_ultima_compra","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Double","valor_ultima_compra","16","false","text","Valor_ultima_compra","","##,##0.00","true","","","",},
                            {"java.sql.Date","data_ultima_alteracao","10","false","text","Data_ultima_alteracao","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","data_log_afv","10","false","text","Data_log_afv","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Integer","tra_cdgo_internar","22","false","text","Tra_cdgo_internar","","","true","","","",}
                          };
    return metadata;
  }

}
