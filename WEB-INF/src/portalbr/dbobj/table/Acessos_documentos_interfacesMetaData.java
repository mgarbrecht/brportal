package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_documentos_interfaces
  * @version 03/04/2013 10:08:00
  */
public class Acessos_documentos_interfacesMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ACDI_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACESSOS_DOCUMENTOS_INTERFACES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","acdi_id","10","true","text","Acdi_id","","","true","","","",},
                            {"java.lang.Integer","acdi_doin_id","10","true","text","Acdi_doin_id","","","true","","","",},
                            {"java.lang.Integer","acdi_usua_id","10","true","text","Acdi_usua_id","","","true","","","",},
                            {"java.lang.String","acdi_favorito","1","true","text","Acdi_favorito","","","","","","",},
                            {"java.lang.Integer","acdi_dias_consulta_retroativa","5","false","text","Acdi_dias_consulta_retroativa","","","true","","","",}
                          };
    return metadata;
  }

}
