package portalbr.dbobj.table;

/** DataBase Object from table CPR.Atelier_pre_envio
  * @version 02/07/2015 08:41:04
  */
public class Atelier_pre_envioMetaData {

  public static final String SCHEMA = "CPR";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"FOR_CODIGO","FEN_SEQ","REM_NRO","TAL_NRO","PRO_NUMERO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ATELIER_PRE_ENVIO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","for_codigo","9","true","text","For_codigo","","","true","","","",},
                            {"java.lang.Integer","fen_seq","4","true","text","Fen_seq","","","true","","","",},
                            {"java.lang.Integer","ref_cdgo","10","false","text","Ref_cdgo","","","true","","","",},
                            {"java.lang.Double","lin_cdgo","22","false","text","Lin_cdgo","","##,##0.00","true","","","",},
                            {"java.lang.Integer","pro_numero","3","true","text","Pro_numero","","","true","","","",},
                            {"java.lang.Integer","tal_pares","5","false","text","Tal_pares","","","true","","","",},
                            {"java.sql.Timestamp","data_pre_envio","10","false","text","Data_pre_envio","","dd/MM/yyyy HH:mm","true","","","",},
                            {"java.lang.Integer","rem_nro","22","true","text","Rem_nro","","","true","","","",},
                            {"java.lang.Integer","tal_nro","4","true","text","Tal_nro","","","true","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",},
                            {"java.lang.String","status_retorno","1","false","text","Status_retorno","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","Fil_filial","","","","","","",}
                          };
    return metadata;
  }

}
