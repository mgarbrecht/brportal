package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Tipos_entidade_negocio
  * @version 03/04/2013 09:06:56
  */
public class Tipos_entidade_negocioMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"TIEN_ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TIPOS_ENTIDADE_NEGOCIO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","tien_id","10","true","text","Tien_id","","","true","","","",},
                            {"java.lang.String","tien_tipo","40","true","text","Tien_tipo","","","","","","",},
                            {"java.lang.String","tien_tabela","30","true","text","Tien_tabela","","","","","","",},
                            {"java.lang.String","tien_campos_descr","255","true","text","Tien_campos_descr","","","","","","",},
                            {"java.lang.String","tien_campos_chave","255","true","text","Tien_campos_chave","","","","","","",},
                            {"java.lang.String","tien_condicional","255","false","text","Tien_condicional","","","","","","",},
                            {"int","tien_dias_consulta_retroativa","10","false","text","Tien_dias_consulta_retroativa","","","true","","","",}
                          };
    return metadata;
  }

}
