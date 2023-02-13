package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_mkt_showroom
  * @version 03/04/2013 09:52:52
  */
public class Jw_acao_mkt_showroomMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_showroom","22","false","text","id_showroom","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","100","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","evento","200","false","text","evento","","","","","","",},
                            {"java.lang.Integer","mun_codigo","22","false","text","mun_codigo","","","","","","",},
                            {"java.lang.String","est_unifed","2","false","text","est_unifed","","","","","","",},
                            {"java.lang.Integer","est_pais_codigo","22","false","text","est_pais_codigo","","","","","","",},
                            {"java.sql.Date","dt_periodo_ini","22","false","text","dt_periodo_ini","","","","","","",},
                            {"java.sql.Date","dt_periodo_fim","22","false","text","dt_periodo_fim","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT am.id_showroom      , am.codigo_regional      , rv.nome_regional      , am.evento      , am.mun_codigo      , am.est_unifed      , am.est_pais_codigo      , am.dt_periodo_ini      , am.dt_periodo_fim   FROM brio.acao_mkt_showroom am      , regionais_vendas rv  WHERE am.codigo_regional = rv.codigo_regional";
    return query;
  }

}
