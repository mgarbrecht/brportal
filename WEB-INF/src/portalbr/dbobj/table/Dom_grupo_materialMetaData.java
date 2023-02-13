package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_grupo_material
  * @version 09/08/2013 10:45:51
  */
public class Dom_grupo_materialMetaData {

  public static final String SCHEMA = "EST";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"GPO_MATER_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "DOM_GRUPO_MATERIAL";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","gpo_mater_cdgo","6","true","text","Gpo_mater_cdgo","","","true","","","",},
                            {"java.lang.String","gpo_mater_desc","40","true","text","Gpo_mater_desc","","","","","","",},
                            {"java.lang.String","senha","100","false","text","Senha","","","","","","",}
                          };
    return metadata;
  }

}
