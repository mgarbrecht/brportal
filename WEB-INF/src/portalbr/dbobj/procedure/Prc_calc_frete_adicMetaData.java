package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_calc_frete_adic
  * @version 20/05/2013 09:25:48
  */
public class Prc_calc_frete_adicMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_CALC_FRETE_ADIC";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","p_pedido","22","in","text","P_pedido","","","true","","","",},
                            {"int","p_retorno","22","out","text","P_retorno","","","true","","","",}
                          };
    return metadata;
  }

}
