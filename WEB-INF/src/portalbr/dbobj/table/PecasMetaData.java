package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Pecas
  * @version 20/12/2010 11:01:48
  */
public class PecasMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PECAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo","22","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","25","true","text","Descricao","","","","","","",},
                            {"java.lang.Double","conver","9","false","text","Conver","","##,##0.00","true","","","",},
                            {"java.lang.Integer","cmp_cdgo","5","false","text","Cmp_cdgo","","","true","","","",},
                            {"java.lang.String","grupo_sola","1","false","text","Grupo_sola","","","","","","",},
                            {"java.lang.String","set_cdgo","5","false","text","Set_cdgo","","","","","","",}
                          };
    return metadata;
  }

}
