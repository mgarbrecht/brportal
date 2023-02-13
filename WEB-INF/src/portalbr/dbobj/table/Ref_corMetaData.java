package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref_cor
  * @version 05/08/2014 12:00:35
  */
public class Ref_corMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"LIN_CDGO","REF_CDGO","CAB_CDGO","COR_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REF_COR";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","lin_cdgo","22","true","text","Lin_cdgo","","","true","","","",},
                            {"int","ref_cdgo","10","true","text","Ref_cdgo","","","true","","","",},
                            {"int","cab_cdgo","22","true","text","Cab_cdgo","","","true","","","",},
                            {"int","cor_cdgo","22","true","text","Cor_cdgo","","","true","","","",},
                            {"double","rfc_ratplv","13","false","text","Rfc_ratplv","","","true","","","",},
                            {"java.lang.String","rfc_status","1","false","text","Rfc_status","","","","","","",},
                            {"java.lang.String","observacao","40","false","text","Observacao","","","","","","",},
                            {"int","min_pares_me","6","false","text","Min_pares_me","","","true","","","",},
                            {"java.lang.String","barra_ok","1","false","text","Barra_ok","","","","","","",},
                            {"java.sql.Timestamp","data_log_afv","22","false","text","Data_log_afv","","","true","","","",}
                          };
    return metadata;
  }

}
