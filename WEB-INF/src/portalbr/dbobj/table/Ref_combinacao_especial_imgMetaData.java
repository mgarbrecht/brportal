package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref_combinacao_especial_img
  * @version 09/06/2015 16:04:24
  */
public class Ref_combinacao_especial_imgMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SOLICITACAO","ID_IMAGEM"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REF_COMBINACAO_ESPECIAL_IMG";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_solicitacao","22","true","text","Id_solicitacao","","","true","","","",},
                            {"java.lang.Integer","id_imagem","22","true","text","Id_imagem","","","true","","","",},
                            {"java.lang.String","imagem","100","false","text","Imagem","","","","","","",},
                            {"java.lang.String","descricao_imagem","100","false","text","Descricao_imagem","","","","","","",}
                          };
    return metadata;
  }

}
