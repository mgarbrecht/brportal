package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Entidades_negocio
  * @version 03/04/2013 09:58:20
  */
public class Entidades_negocioMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ENNE_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Entidades_negocio";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","enne_id","10","true","text","Id","","","true","","","",},
                            {"java.lang.String","enne_descricao","255","true","text","Descrição","","","","","","",},
                            {"java.lang.String","enne_chave","255","true","text","enne_chave","","","","","","",},
                            {"java.lang.Integer","enne_tien_id","10","false","text","enne_tien_id","","","true","","","",}
                          };
    return metadata;
  }

}
