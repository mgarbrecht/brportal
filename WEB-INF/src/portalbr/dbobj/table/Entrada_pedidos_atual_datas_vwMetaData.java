package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Entrada_pedidos_atual_datas_vw
  * @version 01/04/2015 10:28:18
  */
public class Entrada_pedidos_atual_datas_vwMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ENTRADA_PEDIDOS_ATUAL_DATAS_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","dia_anterior","10","false","text","Dia_anterior","","","","","","",},
                            {"java.lang.String","dia_atual","10","false","text","Dia_atual","","","","","","",},
                            {"java.lang.String","mes","3","false","text","Mes","","","","","","",},
                            {"java.lang.String","semana_atual","10","false","text","Semana_atual","","","","","","",}
                          };
    return metadata;
  }

}
