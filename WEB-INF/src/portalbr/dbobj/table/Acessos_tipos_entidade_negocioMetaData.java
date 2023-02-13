package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_tipos_entidade_negocio
  * @version 03/04/2013 10:07:44
  */
public class Acessos_tipos_entidade_negocioMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ATEN_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACESSOS_TIPOS_ENTIDADE_NEGOCIO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","aten_id","10","true","text","Aten_id","","","true","","","",},
                            {"java.lang.Integer","aten_tien_id","10","true","text","Aten_tien_id","","","true","","","",},
                            {"java.lang.Integer","aten_doin_id","10","true","text","Aten_doin_id","","","true","","","",},
                            {"java.lang.Integer","aten_dias_consulta_retroativa","5","false","text","Aten_dias_consulta_retroativa","","","true","","","",}
                          };
    return metadata;
  }

}
