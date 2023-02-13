package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Abastecimento
  * @version 20/02/2008 10:51:34
  */
public class AbastecimentoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NRO_DOCUMENTO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Abastecimento";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","nro_documento","8","true","text","","","","","","","",},
                            {"java.sql.Timestamp","data_abastecimento","22","true","text","","","","","","","",},
                            {"java.lang.String","usuario","30","true","text","","","","","","","",},
                            {"int","les_codigo_ori","5","true","text","","","","","","","",},
                            {"int","les_codigo_des","5","true","text","","","","","","","",},
                            {"java.lang.String","set_cdgo","5","false","text","","","","","","","",},
                            {"java.lang.String","observacao","80","false","text","","","","","","","",},
                            {"java.lang.String","status","1","false","text","","","","","","","",},
                            {"int","tes_codigo","2","true","text","","","","","","","",},
                            {"java.lang.String","usuario_geracao","30","false","text","","","","","","","",},
                            {"int","tes_codigo_des","2","false","text","","","","","","","",}
                          };
    return metadata;
  }

}
