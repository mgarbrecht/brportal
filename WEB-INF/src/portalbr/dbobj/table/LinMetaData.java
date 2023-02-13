package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Lin
  * @version 03/04/2013 10:35:53
  */
public class LinMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"LIN_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "LIN";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","lin_cdgo","22","true","text","Lin_cdgo","","","true","","","",},
                            {"java.lang.String","lin_nome","25","true","text","Lin_nome","","","","","","",},
                            {"int","lin_partal","5","true","text","Lin_partal","","","true","","","",},
                            {"int","lin_parrem","5","true","text","Lin_parrem","","","true","","","",},
                            {"int","lin_minimo","3","true","text","Lin_minimo","","","true","","","",},
                            {"int","lin_platal","5","true","text","Lin_platal","","","true","","","",},
                            {"int","lin_plarem","5","true","text","Lin_plarem","","","true","","","",},
                            {"java.lang.String","lin_nometi","25","false","text","Lin_nometi","","","","","","",},
                            {"java.lang.String","lin_nomesp","25","false","text","Lin_nomesp","","","","","","",},
                            {"java.lang.String","unid_negocio","3","true","text","Unid_negocio","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","Situacao","","","","","","",},
                            {"java.sql.Timestamp","data_log_afv","22","false","text","Data_log_afv","","","true","","","",},
                            {"java.lang.String","lin_gera_lote","1","false","text","Lin_gera_lote","","","","","","",},
                            {"int","lin_toler_menos_lote","5","false","text","Lin_toler_menos_lote","","","true","","","",},
                            {"int","lin_toler_mais_lote","5","false","text","Lin_toler_mais_lote","","","true","","","",},
                            {"int","lin_prs_lote","6","false","text","Lin_prs_lote","","","true","","","",},
                            {"int","lin_prs_tal_lote","6","false","text","Lin_prs_tal_lote","","","true","","","",},
                            {"java.lang.String","lin_cabedal","1","false","text","Lin_cabedal","","","","","","",},
                            {"int","lin_dias_almoxarifado","3","false","text","Lin_dias_almoxarifado","","","true","","","",},
                            {"int","lin_dias_costura","3","false","text","Lin_dias_costura","","","true","","","",},
                            {"int","lin_dias_montagem","3","false","text","Lin_dias_montagem","","","true","","","",},
                            {"int","lin_dias_expedicao","3","false","text","Lin_dias_expedicao","","","true","","","",},
                            {"int","codigo_mini_fabs","3","false","text","Codigo_mini_fabs","","","true","","","",},
                            {"double","investimento","16","false","text","Investimento","","##,##0.00","true","","","",},
                            {"double","p_equilibrio","16","false","text","P_equilibrio","","##,##0.00","true","","","",},
                            {"java.lang.String","ind_aberto_fechado","1","false","text","Ind_aberto_fechado","","","","","","",},
                            {"java.lang.String","ind_grupo","1","false","text","Ind_grupo","","","","","","",},
                            {"java.sql.Timestamp","dt_embarque","22","false","text","Dt_embarque","","","true","","","",},
                            {"java.lang.String","musical_solido","1","false","text","Musical_solido","","","","","","",},
                            {"java.lang.String","projeto_cdgo","15","false","text","Projeto_cdgo","","","","","","",}
                          };
    return metadata;
  }

}
