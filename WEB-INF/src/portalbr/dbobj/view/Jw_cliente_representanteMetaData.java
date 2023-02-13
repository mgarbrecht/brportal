package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cliente_representante
  * @version 03/04/2013 09:48:54
  */
public class Jw_cliente_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_cliente","22","false","text","codigo_cliente","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","codigo_representante","5","false","text","codigo_representante","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","rep_nome","30","false","text","rep_nome","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT CR.CODIGO_CLIENTE, C.CLI_RZAO, C.CLI_NOME, S.ESC_SEQN, CR.CODIGO_REPRESENTANTE, R.REP_RZAO, R.REP_NOME FROM CLIENTE_REPRESENTANTE CR, REP R, CLI C, ESC S WHERE CR.CODIGO_REPRESENTANTE=R.REP_CDGO AND S.CLI_CDGO=C.CLI_CDGO AND CR.CODIGO_CLIENTE=C.CLI_CDGO AND R.REP_SITU='A' AND CR.SITUACAO='A' AND CR.CODIGO_CLIENTE> 0 AND CR.CODIGO_SEQUENCIAL=s.esc_seqn";
    return query;
  }

}
