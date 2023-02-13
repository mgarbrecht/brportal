package portalbr.dbobj.view;

/** DataBase Object from table .Jw_marcas_produtos_sbr436
  * @version 19/10/2009 14:53:01
  */
public class Jw_marcas_produtos_sbr436MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_marca","3","false","text","","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select codigo_marca, descricao_marca from marcas_produtos where codigo_marca in (1,3,15,16,17)  union select 99 codigo_marca, 'MOLECA + MOLEKINHA' from dual";
    return query;
  }

}
