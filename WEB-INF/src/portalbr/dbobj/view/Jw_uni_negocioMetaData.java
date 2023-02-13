package portalbr.dbobj.view;

/** DataBase Object from table .Jw_uni_negocio
  * @version 05/07/2010 07:05:12
  */
public class Jw_uni_negocioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo","3","false","text","codigo","","","","","","",},
                            {"java.lang.String","nome","50","false","text","nome","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '0' CODIGO  ,'Todos' NOME FROM DUAL Union SELECT TMP.UNID_NEGOCIO CODIGO  ,UN.UNN_DESCRI NOME FROM UNI_NEGOCIO UN  ,TMP_SBR438 TMP WHERE UN.UNN_CODIGO=TMP.UNID_NEGOCIO GROUP BY TMP.UNID_NEGOCIO  ,UN.UNN_DESCRI ORDER BY 2";
    return query;
  }

}
