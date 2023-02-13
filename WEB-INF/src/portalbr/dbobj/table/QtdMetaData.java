package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Qtd
  * @version 03/09/2010 08:00:08
  */
public class QtdMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"GDE_CDGO","QTD_NUME"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "QTD";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","gde_cdgo","22","true","text","Gde_cdgo","","","true","","","",},
                            {"java.lang.String","qtd_nume","5","true","text","Qtd_nume","","","","","","",},
                            {"java.lang.Integer","qtd_pars","7","true","text","Qtd_pars","","","true","","","",}
                          };
    return metadata;
  }

}
