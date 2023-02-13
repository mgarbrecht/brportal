package portalbr.dbobj.view;

/** DataBase Object from table .Jw_setor_filial
  * @version 23/05/2014 10:37:12
  */
public class Jw_setor_filialMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","set_cdgo","10","false","text","set_cdgo","","","","","","",},
                            {"java.lang.String","set_nome","60","false","text","set_nome","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT fil_filial       ,s.set_cdgo       ,s.set_nome   FROM setor s       ,set_fil sf  WHERE s.set_cdgo = sf.set_cdgo  ORDER BY fil_filial          ,set_cdgo";
    return query;
  }

}
