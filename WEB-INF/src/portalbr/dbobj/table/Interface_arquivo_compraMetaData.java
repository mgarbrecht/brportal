package portalbr.dbobj.table;

/** DataBase Object from table EDI.Interface_arquivo_compra
  * @version 10/08/2015 08:09:34
  */
public class Interface_arquivo_compraMetaData {

  public static final String SCHEMA = "EDI";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"INTERFACE_ARQUIVO_COMPRA_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "INTERFACE_ARQUIVO_COMPRA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","interface_arquivo_compra_id","22","true","text","Interface_arquivo_compra_id","","","true","","","",},
                            {"java.lang.Integer","for_codigo","22","true","text","For_codigo","","","true","","","",},
                            {"java.lang.String","nome_arquivo","300","true","text","Nome_arquivo","","","","","","",},
                            {"java.lang.String","tipo","1","true","text","Tipo","","","","","","",},
                            {"java.lang.String","ativo","1","true","text","Ativo","","","","","","",},
                            {"java.lang.String","situacao","1","true","text","Situacao","","","","","","",},
                            {"java.lang.String","usuario_inclusao","30","true","text","Usuario_inclusao","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","19","true","text","Dthr_inclusao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","19","false","text","Dthr_alteracao","","dd/MM/yyyy HH:mm:ss","true","","","",}
                          };
    return metadata;
  }

}
