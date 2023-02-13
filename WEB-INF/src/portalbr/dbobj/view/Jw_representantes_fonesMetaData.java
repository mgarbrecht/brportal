package portalbr.dbobj.view;

/** DataBase Object from table .Jw_representantes_fones
  * @version 03/04/2013 09:12:59
  */
public class Jw_representantes_fonesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fone","14","false","text","fone","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select Decode(SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-9,1), '0',  SubStr(lpad(ffs_ddd, 3, '0'),1, 3)||'-'||SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-6),  SubStr(lpad(ffs_ddd, 3, '0'),1, 2)||'-'||SubStr(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'), Length(lpad(ffs_ddd, 3, '0')||lpad(ffs_nmro, 7, '0'))-7))fone from fax_fon where rep_cdgo=54 and(ffs_tipo=7 or ffs_tipo=1)";
    return query;
  }

}
