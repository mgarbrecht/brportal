package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_peso_cubagem_pedido
  * @version 14/12/2010 07:47:07
  */
public class Prc_peso_cubagem_pedidoMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_PESO_CUBAGEM_PEDIDO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","p_ped_nmro","22","in","text","P_ped_nmro","","0","true","","","",},
                            {"double","p_peso_bruto","22","out","text","P_peso_bruto","","##,##0.00","true","","","",},
                            {"double","p_peso_liquido","22","out","text","P_peso_liquido","","##,##0.00","true","","","",},
                            {"double","p_cubagem","22","out","text","P_cubagem","","##,##0.00","true","","","",},
                            {"double","p_volumes","22","out","text","P_volumes","","0","true","","","",}
                          };
    return metadata;
  }

}
