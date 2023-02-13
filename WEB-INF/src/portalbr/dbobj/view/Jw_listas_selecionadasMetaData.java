package portalbr.dbobj.view;

/** DataBase Object from table .Jw_listas_selecionadas
  * @version 03/04/2013 09:25:28
  */
public class Jw_listas_selecionadasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","id_lista","22","false","text","id_lista","","","","","","",},
                            {"java.lang.String","nome_lista","35","false","text","nome_lista","","","","","","",},
                            {"java.lang.String","selecionado","1","false","text","selecionado","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT id_lista       ,nome_lista       ,'N' selecionado   FROM acao_mkt_mailing_listas a  WHERE situacao_lista = 'A'    AND NOT EXISTS (SELECT 1           FROM acao_mkt_solic_listas l          WHERE l.id_solicitacao = 63            AND l.id_lista = a.id_lista) UNION SELECT ml.id_lista       ,ml.nome_lista       ,'S' selecionado   FROM acao_mkt_solic_listas sl       ,acao_mkt_mailing_listas ml  WHERE sl.id_lista = ml.id_lista    AND sl.id_solicitacao = 63";
    return query;
  }

}
