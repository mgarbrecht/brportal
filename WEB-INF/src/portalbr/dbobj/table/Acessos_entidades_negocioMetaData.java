package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_entidades_negocio
  * @version 03/04/2013 10:07:50
  */
public class Acessos_entidades_negocioMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ACEN_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACESSOS_ENTIDADES_NEGOCIO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","acen_id","10","true","text","Acen_id","","","true","","","",},
                            {"java.lang.Integer","acen_enne_id","10","true","text","Acen_enne_id","","","true","","","",},
                            {"java.lang.Integer","acen_doin_id","10","true","text","Acen_doin_id","","","true","","","",},
                            {"java.lang.Integer","acen_dias_consulta_retroativa","5","false","text","Acen_dias_consulta_retroativa","","","true","","","",}
                          };
    return metadata;
  }

}
