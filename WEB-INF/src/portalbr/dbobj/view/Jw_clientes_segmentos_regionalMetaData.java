package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_segmentos_regional
  * @version 03/04/2013 09:42:40
  */
public class Jw_clientes_segmentos_regionalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_regional","10","false","text","","","","","","","",},
                            {"java.lang.String","nome","10","false","text","","","","","","","",},
                            {"java.lang.String","situacao","20","false","text","","","","","","","",},
                            {"int","pequenos","22","false","text","","","","","","","",},
                            {"int","medios","22","false","text","","","","","","","",},
                            {"int","grandes","22","false","text","","","","","","","",},
                            {"int","todos","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select 1 codigo_regional,         ''  nome,         'Atendidos' situacao,         0 pequenos,          0 medios,          0 grandes,          0 todos          from  dual";
    return query;
  }

}
