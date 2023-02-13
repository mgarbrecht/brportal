package portalbr.dbobj.table;

/** DataBase Object from table LOJA.Usuarios_loja_vw
  * @version 03/04/2013 09:05:35
  */
public class Usuarios_loja_vwMetaData {

  public static final String SCHEMA = "LOJA";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "USUARIOS_LOJA_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","id","22","false","text","Id","","","true","","","",},
                            {"java.lang.String","empresa","4","false","text","Empresa","","","","","","",},
                            {"java.lang.String","cracha","40","false","text","Cracha","","","","","","",},
                            {"java.lang.String","nome","101","false","text","Nome","","","","","","",},
                            {"java.sql.Date","data_inicio_compra","10","false","text","Data_inicio_compra","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","data_fim_compra","10","false","text","Data_fim_compra","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","tipo_acesso","1","false","text","Tipo_acesso","","","","","","",},
                            {"double","limite_credito","22","false","text","Limite_credito","","","true","","","",},
                            {"int","limite_pares","22","false","text","Limite_pares","","","true","","","",},
                            {"java.lang.String","senha","4000","false","text","Senha","","","","","","",},
                            {"java.lang.String","email","100","false","text","Email","","","","","","",},
                            {"java.lang.String","telefone","40","false","text","Telefone","","","","","","",},
                            {"java.lang.String","telefonecelular","40","false","text","Telefonecelular","","","","","","",},
                            {"java.lang.String","telefonerecados","40","false","text","Telefonerecados","","","","","","",},
                            {"java.lang.String","acesso","16","false","text","Acesso","","","","","","",},
                            {"java.lang.String","apelido","80","false","text","Apelido","","","","","","",},
                            {"java.lang.String","msg_pessoal","200","false","text","Msg_pessoal","","","","","","",},
                            {"java.lang.String","img_pessoal","200","false","text","Img_pessoal","","","","","","",}
                          };
    return metadata;
  }

}
