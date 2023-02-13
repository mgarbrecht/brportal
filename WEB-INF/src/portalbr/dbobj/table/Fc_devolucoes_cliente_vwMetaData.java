package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Fc_devolucoes_cliente_vw
  * @version 03/04/2013 09:57:42
  */
public class Fc_devolucoes_cliente_vwMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FC_DEVOLUCOES_CLIENTE_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","repres","5","false","text","Repres","","","","","","",},
                            {"java.lang.Integer","cliente","5","false","text","Cliente","","","true","","","",},
                            {"java.sql.Timestamp","data_dev","19","false","text","Data","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Double","linha","-127","false","text","Linha","","##,##0.00","true","","","",},
                            {"java.lang.String","motivo","101","false","text","Motivo","","","","","","",},
                            {"java.lang.Double","prs","-127","false","text","Prs","","##,##0.00","true","","","",},
                            {"java.lang.Double","vlr","-127","false","text","Vlr","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
