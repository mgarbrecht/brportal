package portalbr.dbobj.view;

/** DataBase Object from table .Calendarios
  * @version 03/04/2013 10:06:25
  */
public class CalendariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cod_empresa","3","false","text","cod_empresa","","","","","","",},
                            {"java.lang.String","cod_filial","4","false","text","cod_filial","","","","","","",},
                            {"java.sql.Date","data","12","false","text","data","","","","","","",},
                            {"java.lang.String","feriado","1","false","text","feriado","","","","","","",},
                            {"double","dia_semana","22","false","text","dia_semana","","","","","","",},
                            {"double","periodo","22","false","text","periodo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select * from calendarios";
    return query;
  }

}
