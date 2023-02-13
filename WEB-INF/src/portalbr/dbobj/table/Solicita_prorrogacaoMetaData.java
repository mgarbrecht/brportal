package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Solicita_prorrogacao
  * @version 16/01/2012 11:02:33
  */
public class Solicita_prorrogacaoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_SOLICITACAO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "SOLICITA_PRORROGACAO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_solicitacao","22","true","text","Id_solicitacao","","","true","","","",},
                            {"java.lang.Integer","nfs_nmro","7","true","text","Nfs_nmro","","","true","","","",},
                            {"java.lang.String","fil_filial","4","true","text","Fil_filial","","","","","","",},
                            {"java.lang.String","nfs_serie","3","true","text","Nfs_serie","","","","","","",},
                            {"java.lang.String","emp_empresa","3","true","text","Emp_empresa","","","","","","",},
                            {"java.lang.Integer","nro_dias_prorrogacao","2","false","text","Nro_dias_prorrogacao","","","true","","","",},
                            {"java.lang.Double","valor_calculado","22","false","text","Valor_calculado","","##,##0.00","true","","","",},
                            {"java.sql.Timestamp","data_solicitacao","19","true","text","Data_solicitacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_solicitacao","50","true","text","Usuario_solicitacao","","","","","","",},
                            {"java.lang.String","situacao","1","true","text","Situacao","","","","","","",},
                            {"java.sql.Timestamp","data_aprovacao","19","false","text","Data_aprovacao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_aprovacao","50","false","text","Usuario_aprovacao","","","","","","",},
                            {"java.lang.Integer","codigo_historico","22","false","text","Codigo_historico","","","true","","","",},
                            {"java.lang.String","motivo","200","false","text","Motivo","","","","","","",},
                            {"java.lang.Double","comissao_nova","22","false","text","Comissão Nova","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
