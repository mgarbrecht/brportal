package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_cgc
  * @version 03/04/2013 09:46:27
  */
public class Jw_clientes_cgcMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select b.cli_cdgo,  b.esc_seqn from esc b , ecl c where b.esc_cgc=89700827000111  and	 b.esc_seqn=c.esc_seqn  and	 b.cli_cdgo=c.cli_cdgo  and	(c.ned_cdgo='UNI' or  c.ned_cdgo='ENT')";
    return query;
  }

}
