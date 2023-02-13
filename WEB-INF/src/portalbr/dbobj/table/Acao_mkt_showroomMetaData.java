package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_mkt_showroom
  * @version 03/04/2013 10:08:22
  */
public class Acao_mkt_showroomMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SHOWROOM"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ACAO_MKT_SHOWROOM";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_showroom","22","true","text","Id_showroom","","","true","","","",},
                            {"java.lang.Integer","codigo_regional","3","true","text","Codigo_regional","","","true","","","",},
                            {"java.lang.String","evento","200","false","text","Evento","","","","","","",},
                            {"java.lang.Integer","mun_codigo","5","true","text","Mun_codigo","","","true","","","",},
                            {"java.lang.String","est_unifed","2","true","text","Est_unifed","","","","","","",},
                            {"java.lang.Integer","est_pais_codigo","3","true","text","Est_pais_codigo","","","true","","","",},
                            {"java.sql.Date","dt_periodo_ini","19","true","text","Dt_periodo_ini","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","dt_periodo_fim","19","true","text","Dt_periodo_fim","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
