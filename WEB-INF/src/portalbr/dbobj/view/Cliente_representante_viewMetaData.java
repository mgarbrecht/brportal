package portalbr.dbobj.view;

/** DataBase Object from table .Cliente_representante_view
  * @version 03/04/2013 10:04:06
  */
public class Cliente_representante_viewMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_cliente","22","false","text","Código","","","","","","",},
                            {"java.lang.String","codigo_representante","5","false","text","","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct(cr.codigo_cliente), cr.codigo_representante, c.cli_nome,c.cli_rzao from cliente_representante cr, cli c where c.cli_cdgo=cr.codigo_cliente and c.cli_situ='A'";
    return query;
  }

}
