package portalbr.dbobj.view;

/** DataBase Object from table .Jw_geracao_romaneio_filtro
  * @version 25/08/2015 16:44:11
  */
public class Jw_geracao_romaneio_filtroMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","10","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","10","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","text","nfs_nmro","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"java.sql.Timestamp","nfs_dtemis","22","false","text","nfs_dtemis","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","50","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.String","possui_sku","1","false","text","possui_sku","","","","","","",},
                            {"java.lang.String","preco_final_liquido","1","false","text","preco_final_liquido","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT n.emp_empresa               ,n.fil_filial               ,n.nfs_nmro               ,n.nfs_serie               ,n.nfs_dtemis               ,n.cli_cdgo               ,n.esc_seqn               ,cl.cli_rzao               ,n.rep_cdgo               ,r.rep_rzao               ,NVL((SELECT 'N'                  FROM nf_saida ni                      ,nf_item ii                      ,numeracoes_itens_nf ti                 WHERE ni.nfs_nmro = ii.nfs_nmro                   AND ni.fil_filial = ii.fil_filial                   AND ni.nfs_serie = ii.nfs_serie                   AND ni.emp_empresa = ii.emp_empresa                   AND ii.nfi_seqitem = ti.nfi_seqitem                   AND ii.nfs_nmro = ti.nfs_nmro                   AND ii.fil_filial = ti.fil_filial                   AND ii.emp_empresa = ti.emp_empresa                   AND ii.nfs_serie = ti.nfs_serie                   AND ni.nfs_nmro = n.nfs_nmro                   AND ni.emp_empresa = n.emp_empresa                   AND ni.fil_filial = n.fil_filial                   AND ni.nfs_serie = n.nfs_serie                   AND NOT EXISTS (SELECT 1                          FROM ref_cli_gde ci                         WHERE ci.lin_cdgo = ii.lin_cdgo                           AND ci.ref_cdgo = ii.ref_cdgo                           AND ci.cab_cdgo = ii.cab_cdgo                           AND ci.cor_cdgo = ii.cor_cdgo                           AND ci.tai_codigo = ti.numero                           AND ci.cli_cdgo = ni.cli_cdgo)                   AND ROWNUM = 1),'S') possui_sku       ,null preco_final_liquido  FROM nf_saida n      ,nf_item i      ,cli cl      ,notas_fiscais_saida_ped_venda v      ,ped p      ,numeracoes_itens_nf t      ,ref_cli_gde c      ,cor o      ,rep r      ,filial f WHERE n.nfs_nmro = i.nfs_nmro   AND n.fil_filial = i.fil_filial   AND n.nfs_serie = i.nfs_serie   AND n.emp_empresa = i.emp_empresa   AND cl.cli_cdgo = n.cli_cdgo   AND f.fil_filial = n.fil_filial   AND r.rep_cdgo = n.rep_cdgo   AND v.nfs_nmro = n.nfs_nmro   AND v.fil_filial = n.fil_filial   AND v.emp_empresa = n.emp_empresa   AND v.nfs_serie = n.nfs_serie   AND p.ped_nmro = v.ped_nmro   AND i.nfi_seqitem = t.nfi_seqitem   AND i.nfs_nmro = t.nfs_nmro   AND i.fil_filial = t.fil_filial   AND i.emp_empresa = t.emp_empresa   AND i.nfs_serie = t.nfs_serie   AND c.lin_cdgo = i.lin_cdgo   AND c.ref_cdgo = i.ref_cdgo   AND c.cab_cdgo = i.cab_cdgo   AND c.cor_cdgo = i.cor_cdgo   AND c.cli_cdgo = n.cli_cdgo   AND c.tai_codigo = t.numero   AND i.cor_cdgo = o.cor_cdgo   AND NVL(n.stat_codigo, NULL) = 4";
    return query;
  }

}
