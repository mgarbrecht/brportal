package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_fones
  * @version 03/04/2013 09:45:02
  */
public class Jw_clientes_fonesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fone","46","false","text","fone","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select to_char(ffs_ddd2, '0000')||'-'||ffs_nmro2 fone  from fax_fon2  where cli_cdgo=1  and esc_seqn=1  and ned_cdgo='UNI'";
    return query;
  }

}
