package portalbr.dbobj.table;

/** DataBase Object from table .Jw_ficha_tec_imagem
  * @version 25/03/2008 15:33:18
  */
public class Jw_ficha_tec_imagemMetaData {

  public static final String SCHEMA = "";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Jw_ficha_tec_imagem";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"int","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","fit_imagem","100","false","text","fit_imagem","","","","","","",}
                          };
    return metadata;
  }

}
