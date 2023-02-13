package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Fornecedor_parametros_edi
  * @version 29/07/2015 10:54:58
  */
public class Fornecedor_parametros_ediMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FORNECEDOR_PARAMETROS_EDI";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","for_codigo","20","true","text","For_codigo","","","true","","","",},
                            {"java.lang.String","caminho_edi_ordem_compra","200","true","text","Caminho_edi_ordem_compra","","","","","","",},
                            {"java.lang.String","caminho_edi_nf","200","false","text","Caminho_edi_nf","","","","","","",},
                            {"java.lang.String","envia_talao","10","false","text","Envia_talao","","","","","","",},
                            {"java.lang.Integer","fen_seq_esc_seqn","4","false","text","Fen_seq_esc_seqn","","","true","","","",},
                            {"java.lang.String","cliente_fornecedor_transp","10","false","text","Cliente_fornecedor_transp","","","","","","",}
                          };
    return metadata;
  }

}
