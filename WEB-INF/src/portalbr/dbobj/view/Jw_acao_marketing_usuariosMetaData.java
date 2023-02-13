package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing_usuarios
  * @version 03/04/2013 09:53:15
  */
public class Jw_acao_marketing_usuariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cracha","22","false","text","cracha","","","","","","",},
                            {"java.lang.String","nome","40","false","text","nome","","","","","","",},
                            {"java.lang.String","email","40","false","text","email","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","situacao","","","","","","",},
                            {"int","marca","22","false","text","marca","","","","","","",},
                            {"java.lang.String","tipo","1","false","text","tipo","","","","","","",},
                            {"java.lang.String","dono_marca","1","false","text","dono_marca","","","","","","",},
                            {"java.lang.String","coordenador","1","false","text","coordenador","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT cracha,nome,email,situacao,'' marca, tipo, dono_marca, coordenador FROM acao_marketing_usuarios";
    return query;
  }

}
