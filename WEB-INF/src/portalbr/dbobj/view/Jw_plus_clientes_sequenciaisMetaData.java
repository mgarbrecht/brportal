package portalbr.dbobj.view;

/** DataBase Object from table .Jw_plus_clientes_sequenciais
  * @version 03/04/2013 09:18:22
  */
public class Jw_plus_clientes_sequenciaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo","81","false","text","codigo","","","","","","",},
                            {"java.lang.String","razao_social","35","false","text","razao_social","","","","","","",},
                            {"java.lang.String","cidade_uf","63","false","text","cidade_uf","","","","","","",},
                            {"java.lang.String","seqn","22","false","text","seqn","","","","","","",},
                            {"java.lang.String","cod","22","false","text","cod","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT A.CLI_CDGO||'-'||B.ESC_SEQN CODIGO,  CLI_RZAO RAZAO_SOCIAL,  c.ecl_cdad||'-'||c.est_unifed cidade_uf,  B.ESC_SEQN SEQN,  B.CLI_CDGO COD  FROM BRIO.CLI A,   BRIO.ESC B,   BRIO.ECL C,  cliente_representante cr  WHERE a.cli_cdgo=3130 AND B.ESC_SEQN=C.ESC_SEQN AND  A.CLI_CDGO=B.CLI_CDGO AND B.CLI_CDGO=C.CLI_CDGO AND (C.NED_CDGO='UNI' OR C.NED_CDGO='ENT')  AND cr.codigo_cliente=a.cli_cdgo  AND cr.codigo_sequencial=b.esc_seqn";
    return query;
  }

}
