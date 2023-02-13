package portalbr.dbobj.table;

/** DataBase Object from table EST.Req_sdo_abastecimento_fornec
  * @version 13/08/2013 16:34:19
  */
public class Req_sdo_abastecimento_fornecMetaData {

  public static final String SCHEMA = "EST";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "REQ_SDO_ABASTECIMENTO_FORNEC";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Long","ies_codigo","22","true","text","Ies_codigo","","","true","","","",},
                            {"java.lang.Integer","cor_cdgo","22","true","text","Cor_cdgo","","","true","","","",},
                            {"java.lang.String","tai_codigo","5","true","text","Tai_codigo","","","","","","",},
                            {"java.lang.Integer","cod_min_fabr","4","false","text","Cod_min_fabr","","","true","","","",},
                            {"java.lang.Long","for_codigo","22","false","text","For_codigo","","","true","","","",},
                            {"java.lang.Integer","fen_seq","1-","false","text","Fen_seq","","","true","","","",},
                            {"java.lang.Double","quantidade_transito","23","false","text","Quantidade_transito","","##,##0.00","true","","","",},
                            {"java.lang.Double","quantidade_produzida","23","false","text","Quantidade_produzida","","##,##0.00","true","","","",},
                            {"java.lang.Double","quantidade_atraso","23","false","text","Quantidade_atraso","","##,##0.00","true","","","",},
                            {"java.sql.Date","data_entrega","19","false","text","Data_entrega","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Double","sdo_req","23","true","text","Sdo_req","","##,##0.00","true","","","",},
                            {"java.sql.Timestamp","data_atualizacao","19","false","text","Data_atualizacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","id","22","true","text","Id","","","true","","","",}
                          };
    return metadata;
  }

}
