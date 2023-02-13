package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_amostra_pedidos
  * @version 20/08/2013 08:00:41
  */
public class Ped_amostra_pedidosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"PED_NMRO_AMOSTRA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PED_AMOSTRA_PEDIDOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro_amostra","22","true","text","Ped_nmro_amostra","","","true","","","",},
                            {"java.lang.Integer","ped_nmro","22","true","text","Ped_nmro","","","true","","","",},
                            {"java.lang.String","usuario_inclusao","30","true","text","Usuario_inclusao","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","19","true","text","Dthr_inclusao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","19","false","text","Dthr_alteracao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","observacao","200","false","text","Observacao","","","","","","",}
                          };
    return metadata;
  }

}
