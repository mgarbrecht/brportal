package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_enderecos
  * @version 06/03/2018 10:34:27
  */
public class Jw_clientes_enderecosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","ned_cdgo","3","false","text","ned_cdgo","","","","","","",},
                            {"java.lang.String","endereco","75","false","text","endereco","","","","","","",},
                            {"java.lang.String","cep","9","false","text","cep","","","","","","",},
                            {"java.lang.String","bairro_cidade","96","false","text","bairro_cidade","","","","","","",},
                            {"java.lang.String","pais","100","false","text","pais","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT a.cli_cdgo,b.esc_seqn,c.ned_cdgo,c.ecl_nome||' , '||c.ecl_nmro endereco,  substr(c.ecl_cep,1,5)||'-'||substr(c.ecl_cep, 6,3)cep,  c.ecl_bair||' - '||c.ecl_cdad||'/'||c.est_unifed bairro_cidade  FROM BRIO.CLI A, BRIO.ESC B, BRIO.ECL C, CLIENTE_REPRESENTANTE CR  WHERE B.ESC_SEQN=C.ESC_SEQN   AND A.CLI_CDGO=B.CLI_CDGO   AND B.CLI_CDGO=C.CLI_CDGO   AND CR.CODIGO_CLIENTE=A.CLI_CDGO   AND CR.CODIGO_SEQUENCIAL=B.ESC_SEQN  AND a.cli_situ='A'  AND b.esc_situacao='A'  AND cr.situacao='A'  AND A.CLI_CDGO=3130   AND b.esc_seqn=2";
    return query;
  }

}
