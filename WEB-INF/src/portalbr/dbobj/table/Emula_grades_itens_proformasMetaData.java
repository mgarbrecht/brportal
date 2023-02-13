package portalbr.dbobj.table;

/** DataBase Object from table EXP.Emula_grades_itens_proformas
  * @version 03/04/2013 09:58:49
  */
public class Emula_grades_itens_proformasMetaData {

  public static final String SCHEMA = "EXP";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NUMERO_PEDIDO","NUMERO_ITEM","NUMERACAO_PAR"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "EMULA_GRADES_ITENS_PROFORMAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","numero_pedido","6","true","text","Numero_pedido","","","true","","","",},
                            {"java.lang.Integer","numero_item","4","true","text","Numero_item","","","true","","","",},
                            {"java.lang.String","numeracao_par","5","true","text","Numeracao_par","","","","","","",},
                            {"java.lang.Integer","quantidade_pares","7","false","text","Quantidade_pares","","","true","","","",}
                          };
    return metadata;
  }

}
