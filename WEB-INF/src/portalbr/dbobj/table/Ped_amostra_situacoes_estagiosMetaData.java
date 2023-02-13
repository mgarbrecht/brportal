package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_amostra_situacoes_estagios
  * @version 08/09/2011 10:35:52
  */
public class Ped_amostra_situacoes_estagiosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SITUACAO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PED_AMOSTRA_SITUACOES_ESTAGIOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","id_situacao","22","true","text","Id_situacao","","","true","","","",},
                            {"int","ped_nmro","22","false","text","Ped_nmro","","","true","","","",},
                            {"int","estagio","22","false","text","Estagio","","","true","","","",},
                            {"java.lang.String","observacao","2000","false","text","Observacao","","","","","","",},
                            {"java.lang.String","usuario_inclusao","60","false","text","Usuario_inclusao","","","","","","",},
                            {"java.sql.Date","data_inclusao","10","false","text","Data_inclusao","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","obs_atendente","2000","false","text","Observação Atendente","","","","","","",}
                          };
    return metadata;
  }

}
