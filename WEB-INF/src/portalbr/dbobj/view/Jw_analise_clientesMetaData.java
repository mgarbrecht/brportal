package portalbr.dbobj.view;

/** DataBase Object from table .Jw_analise_clientes
  * @version 03/04/2013 09:51:07
  */
public class Jw_analise_clientesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","codigo_representante","5","false","text","codigo_representante","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select r.codigo_regional, cr.codigo_representante, e.cli_cdgo, e.esc_seqn from cli c, esc e, cliente_representante cr, rep r where c.cli_cdgo=e.cli_cdgo AND cr.codigo_representante=r.rep_cdgo AND cr.codigo_cliente(+)=c.cli_cdgo AND c.cli_cdgo=370 and rownum=1";
    return query;
  }

}
