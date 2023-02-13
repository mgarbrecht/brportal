package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ite_distribuicao_cliente
  * @version 08/01/2016 09:47:08
  */
public class Ite_distribuicao_clienteMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"PED_NMRO","ITE_SEQN","CLIENTE"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ITE_DISTRIBUICAO_CLIENTE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","true","text","Ped_nmro","","","true","","","",},
                            {"java.lang.Integer","ite_seqn","2","true","text","Ite_seqn","","","true","","","",},
                            {"java.lang.String","cliente","20","true","text","Cliente","","","","","","",},
                            {"java.lang.Integer","qtd_caixas","5","true","text","Qtd_caixas","","","true","","","",}
                          };
    return metadata;
  }

}
