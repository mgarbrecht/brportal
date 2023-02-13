package portalbr.dbobj.view;

/** DataBase Object from table .Jw_arquivos_edi
  * @version 11/02/2019 10:17:55
  */
public class Jw_arquivos_ediMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","nome","35","false","text","nome","","","","","","",},
                            {"java.lang.String","caminho","100","false","text","caminho","","","","","","",},
                            {"java.lang.String","caminho_link","100","false","text","caminho_link","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT a.tra_cdgo codigo             , a.tra_nome nome			 , replace(a.srvweb,'/arquivos/transportadoras/','/home/loja_brportal/arquivos/transportadoras/') caminho			 , a.srvweb caminho_link    	  FROM arquivos_edi a 		 WHERE a.tipo = 'T'";
    return query;
  }

}
