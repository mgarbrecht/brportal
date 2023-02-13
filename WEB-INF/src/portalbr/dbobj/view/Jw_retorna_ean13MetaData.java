package portalbr.dbobj.view;

/** DataBase Object from table .Jw_retorna_ean13
  * @version 13/01/2016 14:41:09
  */
public class Jw_retorna_ean13MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","ean13","52","false","text","ean13","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) ean13  FROM ref_bar WHERE NVL(ativo, NULL) IS NULL AND rfb_numero <> '0'   AND lin_cdgo = 415";
    return query;
  }

}
