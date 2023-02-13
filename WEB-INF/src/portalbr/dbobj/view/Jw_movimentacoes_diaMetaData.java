package portalbr.dbobj.view;

/** DataBase Object from table .Jw_movimentacoes_dia
  * @version 03/04/2013 09:21:37
  */
public class Jw_movimentacoes_diaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","ped","10","false","text","","","","","","","",},
                            {"java.lang.String","sts","10","false","text","","","","","","","",},
                            {"java.lang.String","tp","10","false","text","","","","","","","",},
                            {"java.lang.String","cliente","10","false","text","","","","","","","",},
                            {"java.lang.String","nome","10","false","text","","","","","","","",},
                            {"java.lang.String","uf","10","false","text","","","","","","","",},
                            {"java.lang.String","email","10","false","text","","","","","","","",},
                            {"java.lang.String","fone","10","false","text","","","","","","","",},
                            {"java.lang.String","rep","10","false","text","","","","","","","",},
                            {"java.lang.String","liv","10","false","text","","","","","","","",},
                            {"java.lang.String","cnd","10","false","text","","","","","","","",},
                            {"java.lang.String","marca","10","false","text","","","","","","","",},
                            {"java.lang.String","linha","10","false","text","","","","","","","",},
                            {"java.lang.String","ref","10","false","text","","","","","","","",},
                            {"java.lang.String","cab","10","false","text","","","","","","","",},
                            {"java.lang.String","cor","10","false","text","","","","","","","",},
                            {"java.lang.Integer","qtd","22","false","text","","","","","","","",},
                            {"double","vlr","22","false","text","","","","","","","",},
                            {"java.sql.Timestamp","data","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' ped       ,'' sts       ,'' tp       ,'' cliente       ,'' nome       ,'' uf       ,'' email       ,'' fone       ,'' rep       ,'' liv       ,'' cnd       ,'' marca       ,'' linha       ,'' REF       ,'' cab       ,'' cor       ,0 qtd       ,0.0 vlr       ,SYSDATE data   FROM dual";
    return query;
  }

}
