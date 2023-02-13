package portalbr.dbobj.view;

/** DataBase Object from table .Jw_afv_tipo_marketing
  * @version 03/04/2013 09:51:38
  */
public class Jw_afv_tipo_marketingMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","CodTipoMarketing","22","false","text","","","","","","","",},
                            {"java.lang.String","Descricao","40","false","text","","","","","","","",},
                            {"java.lang.String","CtrlOperacao","1","false","text","","","","","","","",},
                            {"java.sql.Timestamp","CtrlDataOperacao","22","false","text","","","","","","","",},
                            {"double","ID","22","false","text","","","","","","","",},
                            {"double","IDExterno","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select * from afv_tipo_marketing@afvsql";
    return query;
  }

}
