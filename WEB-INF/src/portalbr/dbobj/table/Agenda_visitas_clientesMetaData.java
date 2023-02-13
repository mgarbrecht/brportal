package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Agenda_visitas_clientes
  * @version 03/04/2013 10:07:11
  */
public class Agenda_visitas_clientesMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"AGVC_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "AGENDA_VISITAS_CLIENTES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","agvc_id","10","true","text","Agvc_id","","","true","","","",},
                            {"java.lang.Integer","agvc_agvi_id","10","true","text","Agvc_agvi_id","","","true","","","",},
                            {"java.lang.Integer","agvc_cli_cdgo","5","true","text","Agvc_cli_cdgo","","","true","","","",},
                            {"java.lang.Integer","agvc_esc_seqn","4","true","text","Agvc_esc_seqn","","","true","","","",},
                            {"java.lang.String","agvc_tipo","1","true","text","Agvc_tipo","","","","","","",},
                            {"java.sql.Timestamp","agvc_dt_exclusao","22","false","text","Agvc_dt_exclusao","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
