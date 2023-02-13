package portalbr.dbobj.view;

/** DataBase Object from table .Jw_calendarios
  * @version 27/05/2010 10:16:00
  */
public class Jw_calendariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","COD_EMPRESA","3","false","text","","","","","","","",},
                            {"java.lang.String","COD_FILIAL","4","false","text","","","","","","","",},
                            {"java.sql.Date","DATA","12","false","text","","","","","","","",},
                            {"java.lang.String","FERIADO","1","false","text","","","","","","","",},
                            {"double","DIA_SEMANA","22","false","text","","","","","","","",},
                            {"double","PERIODO","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select * from calendarios";
    return query;
  }

}
