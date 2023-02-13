package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Links_dinamicos
  * @version 07/02/2014 09:13:48
  */
public class Links_dinamicosMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"LIDI_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "LINKS_DINAMICOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","lidi_id","10","true","text","Lidi_id","","","true","","","",},
                            {"java.lang.String","lidi_titulo","80","true","text","Lidi_titulo","","","","","","",},
                            {"java.lang.String","lidi_descricao","255","false","text","Lidi_descricao","","","","","","",},
                            {"java.lang.String","lidi_caminho","255","true","text","Lidi_caminho","","","","","","",},
                            {"java.lang.Integer","lidi_marca","3","true","text","Lidi_marca","","","true","","","",},
                            {"java.lang.String","lidi_tipo","1","false","text","Lidi_tipo","","","","","","",},
                            {"java.lang.Integer","lidi_tien_id","10","false","text","Lidi_tien_id","","","true","","","",},
                            {"java.lang.Integer","lidi_enne_id","10","false","text","Lidi_enne_id","","","true","","","",}
                          };
    return metadata;
  }

}
