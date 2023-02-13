package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Solicita_prorrog_lancamentos
  * @version 16/01/2012 15:29:37
  */
public class Solicita_prorrog_lancamentosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SOLICITACAO","ID_LANCAMENTO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "SOLICITA_PRORROG_LANCAMENTOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_solicitacao","22","true","text","Id_solicitacao","","","true","","","",},
                            {"java.lang.Integer","id_lancamento","22","true","text","Id_lancamento","","","true","","","",},
                            {"java.lang.Double","valor_lancamento","22","true","text","Valor_lancamento","","##,##0.00","true","","","",},
                            {"java.sql.Timestamp","data_lancamento","19","true","text","Data_lancamento","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_lancamento","50","true","text","Usuario_lancamento","","","","","","",},
                            {"java.lang.String","motivo","200","false","text","Motivo","","","","","","",}
                          };
    return metadata;
  }

}
