package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cabedal
  * @version 03/04/2013 10:06:38
  */
public class CabedalMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CAB_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Cabedal";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cab_cdgo","4","true","text","Código","","","true","","","",},
                            {"java.lang.String","cab_desc","35","true","text","Descrição","","","","","","",},
                            {"java.lang.String","cab_nomesp","35","false","text","cab_nomesp","","","","","","",},
                            {"java.lang.String","cab_sintic","1","false","text","cab_sintic","","","","","","",},
                            {"java.lang.Integer","tip_mat_cdgo","2","false","text","tip_mat_cdgo","","","","","","",},
                            {"java.lang.String","cab_nome_ingles","35","false","text","cab_nome_ingles","","","","","","",},
                            {"java.sql.Timestamp","cab_data_alteracao","22","true","text","cab_data_alteracao","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
