package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_ped
  * @version 22/08/2022 15:38:41
  */
public class Jw_consulta_pedidos_pedMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","pedido_beira_rio","22","false","text","pedido_beira_rio","","","","","","",},
                            {"int","qtde_pares","38","false","text","qtde_pares","","","","","","",},
                            {"java.lang.String","pedido_cliente","7","false","text","pedido_cliente","","","","","","",},
                            {"java.lang.String","remessa","10","false","text","remessa","","","","","","",},
                            {"java.lang.String","rep","3","false","text","rep","","","","","","",},
                            {"java.lang.String","status","10","false","text","status","","","","","","",},
                            {"java.lang.String","pt","9","false","text","pt","","","","","","",},
                            {"java.sql.Timestamp","dt_digitacao","22","false","text","dt_digitacao","","","","","","",},
                            {"java.sql.Timestamp","dt_entrega","22","false","text","dt_entrega","","","","","","",},
                            {"java.lang.String","dt_embarque","50","false","text","dt_embarque","","","","","","",},
                            {"java.lang.String","nome_linha","68","false","text","nome_linha","","","","","","",},
                            {"java.lang.String","marca","10","false","text","marca","","","","","","",},
                            {"java.lang.String","filial_pedido","10","false","text","filial_pedido","","","","","","",},
                            {"java.lang.String","cliente","100","false","text","cliente","","","","","","",},
                            {"java.lang.String","emp_empresa","7","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","ped_tipo","10","false","text","ped_tipo","","","","","","",},
                            {"java.lang.String","periodo_entrega","100","false","text","periodo_entrega","","","","","","",},
                            {"java.lang.String","previsao_faturamento","100","false","text","previsao_faturamento","","","","","","",},
                            {"java.lang.Double","valor_pedido","22","false","text","valor_pedido","","","","","","",},
                            {"java.lang.String","recolocado","22","false","text","recolocado","","","","","","",},
                            {"java.lang.String","fora_normas","22","false","text","fora_normas","","","","","","",},
                            {"java.lang.String","valor_indenizado","22","false","text","valor_indenizado","","","","","","",},
                            {"java.lang.Double","valor_bruto","22","false","text","valor_bruto","","","","","","",},
                            {"java.lang.Double","valor_nota","22","false","text","valor_nota","","","","","","",},
                            {"java.lang.String","condicao_pagamento","240","false","text","condicao_pagamento","","","","","","",},
                            {"java.lang.String","descricao_livro","240","false","text","descricao_livro","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct p.ped_nmro pedido_beira_rio, pck_pedidos.get_pares(p.ped_nmro) qtde_pares, 	p.ped_nped pedido_cliente, '' remessa,	lpad(p.rep_cdgo,3,'0')rep, 	decode(p.ped_stat,'A','Liber.Prod','B','Bloq.Imp', 				'C','Cancelado','F','Faturado','L','Liberado','P','Em Análise', 				'PF','Parc.Fat','T','Bloq.Com')status, 				decode(p.ped_stat,'F','Faturado','C','Cancelado','ABERTO')pt, 				p.ped_dadg dt_digitacao, 				p.ped_det dt_entrega, 				p.ped_emba dt_embarque, 				i.lin_cdgo||' - '||	l.lin_nome nome_linha, '' marca,'' filial_pedido               , c.cli_cdgo || ' - '||c.cli_rzao cliente               ,p.emp_empresa, p.ped_tipo,'' periodo_entrega, '' previsao_faturamento, 0.0 valor_pedido, '' condicao_pagamento from ped p, lin l, ite i, esc b, cli c where p.cli_cdgo=123 and p.esc_seqn=1    AND c.cli_cdgo = p.cli_cdgo and b.cli_cdgo=p.cli_cdgo and b.esc_seqn=p.esc_seqn and p.ped_nmro=i.ped_nmro and i.lin_cdgo=l.lin_cdgo and p.ped_det>=decode(null/*w_data*/,null,p.ped_det,null/*w_data*/)";
    return query;
  }

}
