package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ite_motivo_indenizacao
  * @version 16/12/2019 14:47:22
  */
public class Ite_motivo_indenizacaoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"PED_NMRO","ITE_SEQN"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ITE_MOTIVO_INDENIZACAO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","true","text","Ped_nmro","","","true","","","",},
                            {"java.lang.Integer","ite_seqn","22","true","text","Ite_seqn","","","true","","","",},
                            {"java.lang.Integer","quantidade_pares","22","true","text","Quantidade_pares","","","true","","","",},
                            {"java.lang.Integer","moco_codigo","22","true","text","Moco_codigo","","","true","","","",},
                            {"java.lang.String","observacao","400","false","text","Observacao","","","","","","",},
                            {"java.lang.String","usuario_criacao","240","true","text","Usuario_criacao","","","","","","",},
                            {"java.sql.Timestamp","data_criacao","19","true","text","Data_criacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","ped_nmro_indenizado","22","false","text","Ped_nmro_indenizado","","","true","","","",}
                          };
    return metadata;
  }

}
