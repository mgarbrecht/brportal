package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_clientes
  * @version 03/04/2013 09:24:26
  */
public class Jw_lv_clientesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo","13","false","text","codigo","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cid_est","63","false","text","cid_est","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select a.cli_cdgo||' - '||b.esc_seqn codigo,  a.cli_rzao,  ecl_cdad||'-'||c.est_unifed cid_est,  b.esc_seqn,  b.cli_cdgo  from cli a, esc b, ecl c  where b.esc_seqn=c.esc_seqn and a.cli_cdgo=b.cli_cdgo and  b.cli_cdgo=c.cli_cdgo and (c.ned_cdgo='UNI' or c.ned_cdgo='ENT')  and a.cli_cdgo=121";
    return query;
  }

}
