package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_titulos
  * @version 28/12/2017 15:13:29
  */
public class Jw_consulta_titulosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cliente","81","false","text","cliente","","","","","","",},
                            {"java.lang.String","razao","35","false","text","razao","","","","","","",},
                            {"java.lang.String","br","30","false","text","br","","","","","","",},
                            {"java.lang.String","cid_est","63","false","text","cid_est","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","codigo_sucessor","22","false","text","codigo_sucessor","","","","","","",},
                            {"java.lang.Integer","sequencial_sucessor","22","false","text","sequencial_sucessor","","","","","","",},
                            {"java.lang.String","razao_social_sucessor","200","false","text","razao_social_sucessor","","","","","","",},
                            {"java.lang.String","cid_uf_sucessor","200","false","text","cid_uf_sucessor","","","","","","",},
                            {"java.lang.String","br_sucessor","200","false","text","br_sucessor","","","","","","",},
                            {"java.lang.String","esc_cgc","100","false","text","esc_cgc","","","","","","",},
                            {"java.lang.String","esc_situacao","10","false","text","esc_situacao","","","","","","",},
                            {"java.lang.String","descricao_esc_situacao","240","false","text","descricao_esc_situacao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT a.cli_cdgo || '-' || b.esc_seqn cliente      ,cli_rzao razao      ,ecl_bair br      ,ecl_cdad || '-' || c.est_unifed cid_est      ,b.esc_seqn      ,a.cli_cdgo      ,ca.cli_cdgo_sucessor codigo_sucessor      ,ca.esc_seqn_sucessor sequencial_sucessor      ,pck_cliente.get_nome(ca.cli_cdgo_sucessor) razao_social_sucessor      ,(SELECT ec.ecl_cdad || ' - ' || ec.est_unifed          FROM ecl ec         WHERE ec.cli_cdgo = ca.cli_cdgo_sucessor           AND esc_seqn = ca.esc_seqn_sucessor           AND ROWNUM = 1) cid_uf_sucessor       ,'' br_sucessor     , b.esc_cgc	 , b.esc_situacao	 , decode(nvl(b.esc_situacao,'I'),'I','INATIVO','ATIVO') descricao_esc_situacao  FROM cli a      ,esc b      ,ecl c      ,brio.cli_inf_adicionais ca WHERE b.esc_seqn = c.esc_seqn   AND a.cli_cdgo = b.cli_cdgo   AND b.cli_cdgo = c.cli_cdgo   AND ca.cli_cdgo(+) = b.cli_cdgo   AND ca.esc_seqn(+) = b.esc_seqn   AND (c.ned_cdgo = 'UNI' OR c.ned_cdgo = 'COB')   AND a.cli_cdgo = 1";
    return query;
  }

}
