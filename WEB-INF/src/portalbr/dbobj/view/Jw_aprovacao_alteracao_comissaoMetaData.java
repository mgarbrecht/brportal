package portalbr.dbobj.view;

/** DataBase Object from table .Jw_aprovacao_alteracao_comissao
  * @version 03/04/2013 09:50:51
  */
public class Jw_aprovacao_alteracao_comissaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_solicitacao","22","false","text","id_solicitacao","","","","","","",},
                            {"java.lang.String","usuario_solicitacao","50","false","text","usuario_solicitacao","","","","","","",},
                            {"java.sql.Timestamp","data_solicitacao","22","false","text","data_solicitacao","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","10","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","50","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","text","nfs_nmro","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"java.lang.Double","valor_total","22","false","text","valor_total","","##,##0.00","","","","",},
                            {"java.lang.Double","valor_calculado","22","false","text","valor_calculado","","##,##0.00","","","","",},
                            {"java.lang.String","motivo","200","false","text","motivo","","","","","","",},
                            {"java.lang.Double","valor_aprovado_parcial","22","false","text","valor_aprovado_parcial","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT p.id_solicitacao       ,initcap(p.usuario_solicitacao) usuario_solicitacao       ,p.data_solicitacao       ,nf.rep_cdgo       ,initcap(r.rep_rzao) rep_rzao       ,nf.cli_cdgo       ,nf.esc_seqn       ,initcap(cli.cli_rzao) cli_rzao       ,nf.emp_empresa       ,nf.fil_filial       ,nf.nfs_nmro       ,nf.nfs_serie       ,NVL(nfs_vltot, 0) valor_total       ,p.valor_calculado       ,initcap(p.motivo) motivo	   ,(SELECT SUM(valor_lancamento) FROM brio.solicita_prorrog_lancamentos WHERE id_solicitacao = p.id_solicitacao ) valor_aprovado_parcial   FROM nf_saida             nf       ,cli                  cli       ,rep                  r       ,brio.solicita_prorrogacao p  WHERE cli.cli_cdgo = nf.cli_cdgo    AND r.rep_cdgo = nf.rep_cdgo    AND p.situacao = 'P'    AND p.emp_empresa = nf.emp_empresa    AND p.fil_filial = nf.fil_filial    AND p.nfs_nmro = nf.nfs_nmro    AND p.nfs_serie = nf.nfs_serie";
    return query;
  }

}
