package portalbr.dbobj.table;

/** DataBase Object from table .Jw_fotos_linhas_cliente
  * @version 04/05/2009 08:25:18
  */
public class Jw_fotos_linhas_clienteMetaData {

  public static final String SCHEMA = "";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Jw_fotos_linhas_cliente";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","68","false","text","lin_nome","","","","","","",},
                            {"java.lang.String","nome","25","false","text","nome","","","","","","",}
                          };
    return metadata;
  }

}
