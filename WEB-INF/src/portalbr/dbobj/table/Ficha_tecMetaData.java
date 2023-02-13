package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ficha_tec
  * @version 05/08/2014 09:51:16
  */
public class Ficha_tecMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"LIN_CDGO","REF_CDGO","CAB_CDGO","FIT_VERSAO","COR_CDGO","FIL_FILIAL"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Ficha_tec";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","lin_cdgo","10","true","text","lin_cdgo","","","true","","","",},
                            {"int","ref_cdgo","10","true","text","ref_cdgo","","","true","","","",},
                            {"int","cab_cdgo","10","true","text","cab_cdgo","","","true","","","",},
                            {"int","fit_versao","10","true","text","fit_versao","","","true","","","",},
                            {"java.sql.Timestamp","fit_implan","22","true","text","fit_implan","","","true","","","",},
                            {"java.lang.Integer","mat_nro","6","false","text","mat_nro","","","true","","","",},
                            {"java.lang.String","fil_filial","4","true","text","fil_filial","","","","","","",},
                            {"java.lang.String","emp_empresa","3","true","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fit_status","1","true","text","fit_status","","","","","","",},
                            {"java.lang.Integer","cod_peca","3","false","text","cod_peca","","","true","","","",},
                            {"int","cor_cdgo","10","true","text","cor_cdgo","","","true","","","",},
                            {"java.lang.Double","qtde_formula","9","false","text","qtde_formula","","","true","","","",},
                            {"java.lang.String","forma","15","false","text","forma","","","","","","",},
                            {"java.lang.String","fit_imagem","100","false","text","fit_imagem","","","","","","",},
                            {"java.lang.String","fit_liberada","1","true","text","fit_liberada","","","","","","",},
                            {"java.lang.String","tipo_material_forro","1","false","text","Tipo_material_forro","","","","","","",},
                            {"java.sql.Date","fit_data_liberada","10","false","text","Fit_data_liberada","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
