package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_mkt_relatorio_showroom
  * @version 03/04/2013 09:53:05
  */
public class Jw_acao_mkt_relatorio_showroomMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","nome_regional","","","","","","",},
                            {"java.lang.Integer","id_showroom","22","false","text","id_showroom","","","","","","",},
                            {"java.lang.String","evento","400","false","text","Evento","","","","","","",},
                            {"java.lang.Integer","mun_codigo","22","false","text","mun_codigo","","","","","","",},
                            {"java.lang.String","mun_nome","200","false","text","mun_nome","","","","","","",},
                            {"java.lang.String","est_unifed","2","false","text","est_unifed","","","","","","",},
                            {"java.lang.String","est_descricao","100","false","text","est_descricao","","","","","","",},
                            {"java.lang.Integer","est_pais_codigo","22","false","text","est_pais_codigo","","","","","","",},
                            {"java.lang.String","pais_nome","200","false","text","pais_nome","","","","","","",},
                            {"java.sql.Date","dt_periodo_ini","22","false","text","dt_periodo_ini","","dd/MM/yyyy","","","","",},
                            {"java.sql.Date","dt_periodo_fim","22","false","text","dt_periodo_fim","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.lang.Integer","clientes_atendidos","22","false","text","clientes_atendidos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo_regional      ,nome_regional      ,id_showroom      ,evento      ,mun_codigo      ,mun_nome      ,est_unifed      ,est_descricao      ,est_pais_codigo      ,pais_nome      ,dt_periodo_ini      ,dt_periodo_fim      ,rep_cdgo      ,rep_rzao      ,codigo_marca      ,descricao_marca      ,SUM(pares) pares      ,COUNT(DISTINCT cli_cdgo) clientes_atendidos  FROM (SELECT DISTINCT ams.codigo_regional                       ,rv.nome_regional                       ,ams.id_showroom                       ,ams.evento                       ,ams.mun_codigo                       ,pck_municipio.get_nome(ams.mun_codigo) mun_nome                       ,ams.est_unifed                       ,pck_estados.get_nome(ams.est_unifed) est_descricao                       ,ams.est_pais_codigo                       ,pck_pais.get_nome(ams.est_pais_codigo) pais_nome                       ,ams.dt_periodo_ini                       ,ams.dt_periodo_fim                       ,r.rep_cdgo                       ,r.rep_rzao                       ,mp.codigo_marca                       ,mp.descricao_marca                       ,pck_pedidos.get_pares(p.ped_nmro) pares                       ,p.cli_cdgo          FROM brio.ped_inf_adicionais pif              ,acao_mkt_showroom ams              ,ped p              ,ite i              ,rep r              ,regionais_vendas rv              ,marcas_produtos mp         WHERE p.ped_nmro = i.ped_nmro           AND pif.ped_nmro = p.ped_nmro           AND rv.codigo_regional = ams.codigo_regional           AND ams.id_showroom = pif.id_showroom           AND r.rep_cdgo = p.rep_cdgo           AND mp.codigo_marca = fct_marca_produto(i.lin_cdgo, i.ref_cdgo)) GROUP BY codigo_regional         ,nome_regional         ,id_showroom         ,evento         ,mun_codigo         ,mun_nome         ,est_unifed         ,est_descricao         ,est_pais_codigo         ,pais_nome         ,dt_periodo_ini         ,dt_periodo_fim         ,rep_cdgo         ,rep_rzao         ,codigo_marca         ,descricao_marca ORDER BY codigo_regional         ,id_showroom         ,rep_cdgo         ,codigo_marca";
    return query;
  }

}
