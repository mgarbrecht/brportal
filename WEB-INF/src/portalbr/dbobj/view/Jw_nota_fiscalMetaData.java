package portalbr.dbobj.view;

/** DataBase Object from table .Jw_nota_fiscal
  * @version 03/04/2013 09:20:44
  */
public class Jw_nota_fiscalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","text","nfs_nmro","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"java.lang.String","emp_razsoc","50","false","text","emp_razsoc","","","","","","",},
                            {"java.lang.String","fil_razsoc","50","false","text","fil_razsoc","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","50","false","text","cli_rzao","","","","","","",},
                            {"java.lang.Integer","stat_codigo","22","false","text","stat_codigo","","","","","","",},
                            {"java.lang.String","descricao","20","false","text","descricao","","","","","","",},
                            {"java.sql.Date","data_emissao","22","false","text","data_emissao","","","","","","",},
                            {"java.lang.Double","valor_total","22","false","text","valor_total","","","","","","",},
                            {"java.lang.Integer","requisicao","22","false","text","requisicao","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.Double","comissao","22","false","text","comissao","","","","","","",},
                            {"java.lang.Integer","tra_cdgo","22","false","text","tra_cdgo","","","","","","",},
                            {"java.lang.String","tra_rzao","35","false","text","tra_rzao","","","","","","",},
                            {"java.lang.Double","bonif1","22","false","text","bonif1","","","","","","",},
                            {"java.lang.Double","bonif2","22","false","text","bonif2","","","","","","",},
                            {"java.lang.Double","desc_pont","22","false","text","desc_pont","","","","","","",},
                            {"java.lang.Double","peso_bruto","22","false","text","peso_bruto","","","","","","",},
                            {"java.lang.Double","peso_liq","22","false","text","peso_liq","","","","","","",},
                            {"java.lang.Double","cs","22","false","text","cs","","","","","","",},
                            {"java.lang.String","cons_desc","35","false","text","cons_desc","","","","","","",},
                            {"java.lang.String","prt_codigo","4","false","text","prt_codigo","","","","","","",},
                            {"java.lang.Integer","nfs_qtdvol","22","false","text","nfs_qtdvol","","","","","","",},
                            {"java.lang.Integer","qtd_duplicatas","22","false","text","qtd_duplicatas","","","","","","",},
                            {"java.lang.Double","ped_boni","22","false","text","ped_boni","","","","","","",},
                            {"java.lang.Double","ped_comr","22","false","text","ped_comr","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT nf.emp_empresa       ,nf.fil_filial       ,nfs_nmro       ,nfs_serie       ,emp.emp_razsoc       ,fil.fil_razsoc       ,nf.cli_cdgo       ,nf.esc_seqn       ,cli.cli_rzao       ,stat_codigo       ,s.descricao       ,nfs_dtemis data_emissao       ,NVL(nfs_vltot, 0) valor_total       ,nf.ped_nmro requisicao       ,nf.rep_cdgo       ,r.rep_rzao       ,NVL(nfs_comissao_representante, 0) comissao       ,nf.tra_cdgo       ,tra.tra_rzao       ,NVL(nfs_percentual_bonificacao, 0) bonif1       ,NVL(nfs_percentual_bonificacao2, 0) bonif2       ,NVL(nfs_descon, 0) desc_pont       ,NVL(nfs_pesbru, 0) peso_bruto       ,NVL(nfs_pesliq, 0) peso_liq       ,nfs_cons cs       ,cons.tra_rzao cons_desc       ,nf.prt_codigo       ,nfs_qtdvol       ,(SELECT count(*) FROM tit_nf t WHERE t.emp_empresa = nf.emp_empresa AND t.fil_filial = nf.fil_filial AND t.nsa_numero = nf.nfs_nmro AND t.nsa_serie = nf.nfs_serie) qtd_duplicatas       ,nvl(p.ped_boni,0) ped_boni       ,nvl(p.ped_comr,0) ped_comr   FROM nf_saida nf       ,empresas emp       ,filial   fil       ,cli      cli       ,status   s       ,rep      r       ,tra       ,tra      cons       ,ped      p  WHERE emp.emp_empresa = nf.emp_empresa    AND fil.fil_filial = nf.fil_filial    AND p.ped_nmro (+) = nf.ped_nmro    AND cli.cli_cdgo = nf.cli_cdgo    AND nf.stat_codigo = s.codigo    AND r.rep_cdgo = nf.rep_cdgo    AND tra.tra_cdgo = nf.tra_cdgo    AND nf.nfs_cons = cons.tra_cdgo(+)";
    return query;
  }

}
