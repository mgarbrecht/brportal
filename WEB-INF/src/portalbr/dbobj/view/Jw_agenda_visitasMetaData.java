package portalbr.dbobj.view;

/** DataBase Object from table .Jw_agenda_visitas
  * @version 03/04/2013 09:51:27
  */
public class Jw_agenda_visitasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","agvi_id","22","false","text","","","","","","","",},
                            {"java.lang.String","agvi_rep_cdgo","5","false","text","","","","","","","",},
                            {"java.sql.Timestamp","agvi_dt_inicial","22","false","text","","","","","","","",},
                            {"java.sql.Timestamp","agvi_dt_final","22","false","text","","","","","","","",},
                            {"java.sql.Timestamp","agvi_dt_exclusao","22","false","text","","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select a.*, r.rep_cdgo,r.rep_rzao,r.codigo_regional from agenda_visitas a, rep r where a.agvi_rep_cdgo=r.rep_cdgo";
    return query;
  }

}
