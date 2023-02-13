package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_insere_item_pedidos_norma
  * @version 05/10/2010 14:44:57
  */
public class Prc_insere_item_pedidos_normaMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_INSERE_ITEM_PEDIDOS_NORMA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_numero_pedido","100","in","text","P_numero_pedido","","","","","","",},
                            {"java.lang.String","p_controle","100","in","text","P_controle","","","","","","",}
                          };
    return metadata;
  }

}
