package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_atend_atendidos
  * @version 11/02/2014 07:58:27
  */
public class Jw_clientes_atend_atendidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","clientes","22","false","text","Clientes","","","","","","",},
                            {"java.lang.Integer","grupos","22","false","text","Grupos","","","","","","",},
                            {"java.lang.Integer","cidades","22","false","text","Cidades","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select 0 clientes ,0 grupos ,0 cidades from dual";
    return query;
  }

}
