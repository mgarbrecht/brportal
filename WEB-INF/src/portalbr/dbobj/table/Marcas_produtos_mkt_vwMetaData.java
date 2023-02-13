package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Marcas_produtos_mkt_vw
  * @version 12/01/2011 08:34:38
  */
public class Marcas_produtos_mkt_vwMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "MARCAS_PRODUTOS_MKT_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_marca","22","false","text","Codigo_marca","","","true","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","Descricao_marca","","","","","","",}
                          };
    return metadata;
  }

}
