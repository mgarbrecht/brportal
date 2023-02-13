package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_ped_ite
  * @version 09/09/2021 15:15:47
  */
public class Jw_consulta_pedidos_ped_iteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_beira_rio","22","false","text","ped_beira_rio","","","","","","",},
                            {"java.lang.String","tipo","2","false","text","tipo","","","","","","",},
                            {"java.lang.String","ped_repres","7","false","text","ped_repres","","","","","","",},
                            {"java.lang.String","ped_cliente","20","false","text","ped_cliente","","","","","","",},
                            {"java.lang.String","st","10","false","text","st","","","","","","",},
                            {"java.lang.Integer","nota","22","false","text","nota","","","","","","",},
                            {"java.lang.String","serie","10","false","text","serie","","","","","","",},
                            {"java.lang.String","cliente","78","false","text","cliente","","","","","","",},
                            {"java.lang.String","rep","43","false","text","rep","","","","","","",},
                            {"java.lang.String","transportadora","35","false","text","transportadora","","","","","","",},
                            {"java.lang.Double","bon1","7","false","text","bon1","","","","","","",},
                            {"java.lang.Double","bon2","7","false","text","bon2","","","","","","",},
                            {"double","desconto_public","24","false","text","desconto_public","","","","","","",},
                            {"java.lang.String","corr","30","false","text","corr","","","","","","",},
                            {"java.lang.String","emb","30","false","text","emb","","","","","","",},
                            {"java.lang.String","pino_anel","3","false","text","pino_anel","","","","","","",},
                            {"java.lang.String","livro","73","false","text","livro","","","","","","",},
                            {"java.lang.String","cond_pagamento","25","false","text","cond_pagamento","","","","","","",},
                            {"java.sql.Timestamp","dt_entrega","22","false","text","dt_entrega","","","","","","",},
                            {"java.lang.String","ped_data_faturamento","22","false","text","ped_data_faturamento","","","","","","",},
                            {"java.lang.String","dt_digitacao","75","false","text","dt_digitacao","","","","","","",},
                            {"java.lang.String","ped_afv","15","false","text","ped_afv","","","","","","",},
                            {"double","seq","22","false","text","seq","","","","","","",},
                            {"java.lang.String","especie","1","false","text","especie","","","","","","",},
                            {"java.lang.String","observ","130","false","text","observ","","","","","","",},
                            {"java.lang.String","moeda","3","false","text","moeda","","","","","","",},
                            {"java.lang.String","czf_nmro","10","false","text","czf_nmro","","","","","","",},
                            {"java.lang.String","emp_empresa","4","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","codigo_corrugado","22","false","text","codigo_corrugado","","","","","","",},
                            {"java.lang.Integer","codigo_embalagem","22","false","text","codigo_embalagem","","","","","","",},
                            {"java.lang.Integer","les_codigo","22","false","text","les_codigo","","","","","","",},
                            {"java.lang.String","previsao_faturamento","100","false","text","previsao_faturamento","","","","","","",},
                            {"java.lang.String","previsao_fat","100","false","text","previsao_fat","","","","","","",},
                            {"java.lang.String","ped_invoice","20","false","text","ped_invoice","","","","","","",},
                            {"java.lang.String","imagem","100","false","text","imagem","","","","","","",},
                            {"java.lang.String","frete","100","false","text","frete","","","","","","",},
                            {"java.lang.String","recolocado","100","false","text","recolocado","","","","","","",},
                            {"java.lang.String","ped_stat","22","false","text","ped_stat","","","","","","",},
                            {"java.lang.String","fora_normas","100","false","text","fora_normas","","","","","","",},
                            {"java.lang.Double","ped_comr","22","false","text","ped_comr","","","","","","",},
                            {"java.lang.Double","ped_boni_avaria","ped_boni_avaria","false","text","Des. Indenização","","","","","","",},
                            {"java.lang.Double","desc_com_original","10","false","text","Desc. Com. Original","","","","","","",},
                            {"java.lang.Double","desc_prom_original","10","false","text","Desc. Prom. Original","","","","","","",},
                            {"java.lang.String","livro_original","5","false","text","Livro Original","","","","","","",},
                            {"java.lang.String","frete_isento","22","false","text","Frete Isento","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT p.ped_nmro ped_beira_rio      ,p.ped_tipo tipo      ,p.ped_nped ped_repres      ,p.ped_ped_cliente ped_cliente      ,DECODE(p.ped_stat, 'A', 'Liber.Prod', 'B', 'Em Análise', 'C', 'Cancelado', 'F', 'Faturado', 'L', 'Liberado', 'P', 'Bloq.Cred.', 'PF', 'Parc.Fat', 'T', 'Bloq.Com') st      ,nota_fiscal.nota nota      ,'' serie      ,p.cli_cdgo || ' - ' || cl.cli_rzao cliente      ,r.rep_cdgo || ' - ' || rep_rzao rep      ,tra_rzao transportadora      ,TO_CHAR(ped_boni, '990.00') bon1      ,TO_CHAR(ped_boni2, '990.00') bon2      ,ped_desc desconto_public      ,c.descricao corr      ,e.descricao emb      ,DECODE(p.ped_pino_anel, 'S', 'Sim', 'Não') pino_anel      ,l.liv_codigo || ' - ' || l.liv_descri livro      ,cnd_desc cond_pagamento      ,ped_det dt_entrega      ,ped_data_faturamento      ,TO_CHAR(ped_dadg, 'dd/mm/yyyy') dt_digitacao      ,p.ped_sequencial_maquina ped_afv      ,p.esc_seqn seq      ,p.ped_especie_pedido especie      ,p.ped_obse observ      ,p.moe_codigo moeda      ,z.czf_nmro czf_nmro      ,p.emp_empresa      ,p.fil_filial      ,0 codigo_corrugado      ,0 codigo_embalagem      ,0 les_codigo      ,'' previsao_faturamento      ,'' previsao_fat      ,'' ped_invoice      ,'' imagem      ,'' frete      ,'' recolocado	  ,p.ped_stat	  ,'' fora_normas	  ,0.0 ped_comr	  ,0.0 ped_boni_avaria	  ,0.0 desc_com_original      ,0.0 desc_prom_original      ,'' livro_original  FROM ped p	  ,ped_inf_adicionais pia      ,tra t      ,rep r      ,cli cl      ,corrugados c      ,embalagens e      ,cnd n      ,livro l      ,czf z      ,(SELECT nfs_nmro nota              ,ped_nmro              ,fil_filial filial          FROM notas_fiscais_saida_ped_venda         WHERE ped_nmro > 0) nota_fiscal WHERE p.ped_nmro = 3129707   AND p.ped_nmro = pia.ped_nmro(+)   AND p.rep_cdgo = r.rep_cdgo   AND p.cli_cdgo = cl.cli_cdgo   AND p.tra_cdgo = t.tra_cdgo   AND p.ped_tipo_corrugado = c.codigo   AND p.ped_forma_embalagem = e.codigo   AND p.cnd_cdgo = n.cnd_cdgo   AND p.liv_codigo = l.liv_codigo   AND p.cli_cdgo = z.cli_cdgo(+)   AND nota_fiscal.ped_nmro = p.ped_nmro   AND p.esc_seqn = z.esc_seqn(+)";
    return query;
  }

}
