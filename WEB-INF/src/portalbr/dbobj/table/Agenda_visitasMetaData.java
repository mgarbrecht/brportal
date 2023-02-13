package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Agenda_visitas
  * @version 03/04/2013 10:07:20
  */
public class Agenda_visitasMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"AGVI_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "AGENDA_VISITAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","agvi_id","10","true","text","Agvi_id","","","true","","","",},
                            {"java.lang.String","agvi_rep_cdgo","5","true","text","Representante","","","","","","",},
                            {"java.sql.Timestamp","agvi_dt_inicial","22","true","text","Data Inicial","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Timestamp","agvi_dt_final","22","true","text","Data Final","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Timestamp","agvi_dt_exclusao","22","false","text","Data Exclusão","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
