package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ped_desconto_indenizacao
  * @version 30/07/2021 11:20:19
  */
public class Jw_ped_desconto_indenizacaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.Integer","tipo_desconto","22","false","text","tipo_desconto","","","","","","",},
                            {"java.lang.String","ped_obse","200","false","text","ped_obse","","","","","","",},
                            {"java.lang.Double","valor_desconto","27","false","text","valor_desconto","","","","","","",},
                            {"java.lang.Double","percentual_desc","24","false","text","percentual_desc","","","","","","",},
                            {"java.lang.Integer","cnd_cdgo","22","false","text","cnd_cdgo","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","situacao","","","","","","",},
                            {"java.lang.Integer","prazo_adicional","22","false","text","prazo_adicional","","","","","","",},
                            {"java.lang.String","banco","20","false","text","banco","","","","","","",},
                            {"java.lang.String","ped_sequencial_maquina","50","false","text","ped_sequencial_maquina","","","","","","",},
                            {"java.lang.String","cliente","200","false","text","cliente","","","","","","",},
                            {"java.lang.String","ped_stat","20","false","text","ped_stat","","","","","","",},
                            {"java.lang.Double","valor","27","false","text","valor","","","","","","",},
                            {"java.lang.String","cnd_desc","200","false","text","cnd_desc","","","","","","",},
                            {"java.lang.String","ped_especie_pedido","20","false","text","ped_especie_pedido","","","","","","",},
                            {"java.lang.String","aceita_desconto","20","false","text","aceita_desconto","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","200","false","text","nome_regional","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ped.ped_nmro       ,pd.tipo_desconto       ,pd.ped_obse       ,pd.valor_desconto       ,pd.percentual_desc       ,pd.cnd_cdgo       ,NVL(pd.situacao, 'A') situacao       ,pd.prazo_adicional       ,(SELECT 'S'           FROM ped_desconto_indenizacao          WHERE ped_nmro = ped.ped_nmro) banco       ,ped_sequencial_maquina       ,c.cli_cdgo || '-' || esc_seqn || '-' || INITCAP(c.cli_rzao) cliente       ,ped.ped_stat	   ,pck_condicao_pagamento.get_nome(pd.cnd_cdgo) cnd_desc	   ,ped.ped_especie_pedido	   ,'' aceita_desconto	   ,c.cli_cdgo	   ,(select fct_marca_produto(i.lin_cdgo, i.ref_cdgo) from ite i where i.ped_nmro = ped.ped_nmro and rownum = 1) codigo_marca	   ,ped.esc_seqn       ,rv.codigo_regional       ,rv.nome_regional         FROM ped ped       ,ped_desconto_indenizacao pd       ,cli c       ,rep r       ,regionais_vendas rv       ,gerentes_regionais_vendas gr  WHERE ped.rep_cdgo = r.rep_cdgo    AND c.cli_cdgo = ped.cli_cdgo    AND gr.codigo_gerente = r.codigo_gerente    AND rv.codigo_regional = r.codigo_regional    AND ped.rep_cdgo = NVL(NULL, ped.rep_cdgo)    AND rv.codigo_regional = NVL(NULL, rv.codigo_regional)    AND gr.codigo_gerente = NVL(NULL, gr.codigo_gerente)    AND ped.ped_daem >= TRUNC(SYSDATE) - 120    AND ped.ped_stat NOT IN ('C')    AND pd.ped_nmro(+) = ped.ped_nmro    AND NVL(pd.situacao, 'A') = NVL('A', pd.situacao)    AND ped.ped_dadg >= TO_DATE('01/04/2013', 'dd/mm/yyyy')    AND ped.ped_dadg <= TO_DATE('30/04/2013', 'dd/mm/yyyy')    AND ped.ped_amostra_brinde IS NULL  ORDER BY ped.ped_nmro";
    return query;
  }

}
