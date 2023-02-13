package portalbr.dbobj.table;

/** DataBase Object from table DEV.Paises
  * @version 02/04/2012 09:46:10
  */
public class PaisesMetaData {

  public static final String SCHEMA = "DEV";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PAISES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","3","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","50","true","text","Descricao","","","","","","",},
                            {"java.sql.Timestamp","data_cad","19","true","text","Data_cad","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","sigla","4","true","text","Sigla","","","","","","",},
                            {"java.lang.String","usuario_cad","30","true","text","Usuario_cad","","","","","","",},
                            {"java.lang.String","con_codigo","4","false","text","Con_codigo","","","","","","",},
                            {"java.lang.String","codigo_siscomex","4","false","text","Codigo_siscomex","","","","","","",},
                            {"java.lang.String","codigo_ibge","4","false","text","Codigo_ibge","","","","","","",}
                          };
    return metadata;
  }

}
