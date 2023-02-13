package portalbr.dbobj.view;

/** DataBase Object from table .Jw_geracao_romaneio
  * @version 16/03/2016 17:35:59
  */
public class Jw_geracao_romaneioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","linha1","100","false","text","","","","","","","",},
                            {"java.lang.String","linha2","100","false","text","","","","","","","",},
                            {"java.lang.String","linha3","100","false","text","","","","","","","",},
                            {"java.lang.String","linha4","100","false","text","","","","","","","",},
                            {"java.lang.String","linha5","100","false","text","","","","","","","",},
                            {"java.lang.Integer","linha6","22","false","text","","","","","","","",},
                            {"java.lang.String","linha7","3","false","text","","","","","","","",},
                            {"java.lang.String","linha8","100","false","text","","","","","","","",},
                            {"java.lang.String","linha9","4000","false","text","","","","","","","",},
                            {"java.lang.String","linha10","4000","false","text","","","","","","","",},
                            {"java.lang.String","emp_empresa","10","false","text","","","","","","","",},
                            {"java.lang.String","fil_filial","10","false","text","","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","","","","","","","",},
                            {"java.sql.Timestamp","nfs_dtemis","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","","","","","","","",},
                            {"java.lang.String","cli_rzao","100","false","text","","","","","","","",},
                            {"java.lang.String","rep_cdgo","10","false","text","","","","","","","",},
                            {"java.lang.String","rep_rzao","100","false","text","","","","","","","",},
                            {"java.lang.String","nome_arquivo","200","false","text","nome_arquivo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT TO_CHAR(TRUNC(SYSDATE), 'YYYYMMDD') || '-YOK-NFe' ||                n.chave_nfe || '-a00' linha1               ,'CALCADOS BEIRA RIO SA' linha2               ,'*' || f.fil_cgc linha3               ,substr(i.descricao_marca, 8, 30) linha4               ,r.rep_endereco_eletronico linha5               ,n.nfs_nmro linha6               ,n.nfs_serie linha7               ,p.ped_ped_cliente linha8               ,i.nfi_seqitem || ';' ||                est.fct_ies_codigo_nativo(i.itest_codigo, i.cor_cdgo, t.numero) || ';' ||                c.ref_ref_cli || ';' || i.nfi_descricao || i.complemento || ';' ||                o.cor_cdgo || ' - ' || o.cor_desc || ';' || t.numero || ';' ||                t.total_pares || ';' ||                REPLACE(TRIM(to_char(fct_preco_desconto(n.nfs_nmro, n.nfs_serie, n.fil_filial, n.emp_empresa, i.nfi_vlunit), '99999999.99')), '.', ',') || ';' ||                p.ped_ped_cliente linha9               ,i.nfi_seqitem || ';' ||                est.fct_ies_codigo_nativo(i.itest_codigo, i.cor_cdgo, t.numero) || ';' ||                c.ref_ref_cli || ';' || i.nfi_descricao || i.complemento || ';' ||                o.cor_cdgo || ' - ' || o.cor_desc || ';' || t.numero || ';' ||                t.total_pares || ';' ||                REPLACE(TRIM(to_char(i.nfi_vlunit, '99999999.99')), '.', ',') || ';' ||                p.ped_ped_cliente linha10               ,n.emp_empresa               ,n.fil_filial               ,n.nfs_nmro               ,n.nfs_serie               ,n.nfs_dtemis               ,n.cli_cdgo               ,n.esc_seqn               ,cl.cli_rzao               ,n.rep_cdgo               ,r.rep_rzao               ,'Romaneio_' || f.fil_cgc || '_' ||                to_char(TRUNC(SYSDATE), 'yyyymmdd') || '_' || n.nfs_nmro || '_' ||                n.nfs_serie || '_' || n.cli_cdgo || '_' ||                'CALCADOS BEIRA RIO SA.csv' nome_arquivo               ,i.nfi_seqitem               ,'N' tipo_geracao  FROM notas_fiscais_saida_ite_venda ix      ,numeracoes_itens_nf           t      ,notas_fiscais_saida_ped_venda nv      ,nf_saida                      n      ,nf_item                       i      ,ped                           p      ,filial                        f      ,cli                           cl      ,ref_cli_gde                   c      ,cor                           o      ,rep                           r WHERE c.lin_cdgo = i.lin_cdgo   AND c.ref_cdgo = i.ref_cdgo   AND c.cab_cdgo = i.cab_cdgo   AND c.cor_cdgo = i.cor_cdgo   AND c.cli_cdgo = n.cli_cdgo   AND c.tai_codigo = t.numero   AND r.rep_cdgo = n.rep_cdgo   AND i.cor_cdgo = o.cor_cdgo   AND n.emp_empresa = ix.emp_empresa   AND n.fil_filial = ix.fil_filial   AND n.nfs_nmro = ix.nfs_nmro   AND n.nfs_serie = ix.nfs_serie   AND i.emp_empresa = n.emp_empresa   AND i.fil_filial = n.fil_filial   AND i.nfi_seqitem = t.nfi_seqitem   AND i.nfs_nmro = t.nfs_nmro   AND i.fil_filial = t.fil_filial   AND i.emp_empresa = t.emp_empresa   AND i.nfs_serie = t.nfs_serie   AND i.nfs_nmro = n.nfs_nmro   AND i.nfs_serie = n.nfs_serie   AND p.ped_nmro = ix.ped_nmro   AND i.nfi_seqitem = ix.nfi_seqitem   AND f.fil_filial = n.fil_filial   AND cl.cli_cdgo = n.cli_cdgo   AND nv.nfs_nmro = n.nfs_nmro   AND nv.fil_filial = n.fil_filial   AND nv.emp_empresa = n.emp_empresa   AND nv.nfs_serie = n.nfs_serie   AND nv.ped_nmro = p.ped_nmro   AND NVL(n.stat_codigo, NULL) = 4 ORDER BY nfs_nmro         ,nfi_seqitem";
    return query;
  }

}
