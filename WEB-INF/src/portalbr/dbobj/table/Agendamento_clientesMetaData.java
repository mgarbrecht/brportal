package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Agendamento_clientes
  * @version 21/08/2013 11:09:28
  */
public class Agendamento_clientesMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_AGENDAMENTO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "AGENDAMENTO_CLIENTES";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_agendamento","5","true","text","Id_agendamento","","","true","","","",},
                            {"java.lang.Integer","cli_cdgo","22","true","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.Integer","nro_semana","5","true","text","Nro_semana","","","true","","","",},
                            {"java.sql.Date","dt_inicial","19","true","text","Dt_inicial","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","dt_final","19","true","text","Dt_final","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
