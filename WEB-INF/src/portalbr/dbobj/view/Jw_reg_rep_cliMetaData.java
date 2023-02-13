package portalbr.dbobj.view;

/** DataBase Object from table .Jw_reg_rep_cli
  * @version 03/04/2013 09:13:48
  */
public class Jw_reg_rep_cliMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT rv.codigo_regional,r.rep_cdgo,c.cli_cdgo FROM cli c, rep r, regionais_vendas rv, cliente_representante cr WHERE r.codigo_regional=r.codigo_regional AND r.rep_cdgo=cr.codigo_representante AND rv.codigo_regional=r.codigo_regional AND c.cli_cdgo=cr.codigo_cliente AND rv.codigo_regional=1";
    return query;
  }

}
