package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_transportadora
  * @version 03/10/2018 12:32:36
  */
public class Jw_clientes_transportadoraMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_transportadora","10","false","text","codigo_transportadora","","","","","","",},
                            {"java.lang.String","razao_transportadora","100","false","text","razao_transportadora","","","","","","",},
                            {"java.lang.Integer","codigo_cliente","10","false","text","codigo_cliente","","","","","","",},
                            {"java.lang.String","razao_social","100","false","text","razao_social","","","","","","",},
                            {"java.lang.String","cidade","100","false","text","cidade","","","","","","",},
                            {"java.lang.String","uf","2","false","text","uf","","","","","","",},
                            {"java.lang.String","consignatario","2","false","text","consignatario","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT codigo_Transportadora      ,razao_transportadora      ,codigo_cliente      ,razao_social      ,cidade      ,uf      ,consignatario  FROM (SELECT DISTINCT t.tra_cdgo codigo_transportadora                       ,t.tra_rzao razao_transportadora                       ,c.cli_cdgo codigo_cliente                       ,c.cli_rzao razao_social                       ,tm.municipio_nome cidade                       ,tm.unifed uf                       ,'N' consignatario          FROM esc                        e              ,ecl                        l              ,transportadoras_municipios tm              ,cli                        c              ,tra                        t         WHERE e.cli_cdgo = l.cli_cdgo           AND e.esc_seqn = l.esc_seqn           AND t.tra_cdgo = e.tra_cdgo           AND c.cli_cdgo = e.cli_cdgo           AND tm.cod_transportadora = e.tra_cdgo           AND tm.municipio_nome = l.ecl_cdad           AND tm.unifed = l.est_unifed           AND e.esc_situacao = 'A'           AND tm.pais_codigo = 55        UNION        SELECT DISTINCT t.tra_cdgo codigo_transportadora                       ,t.tra_rzao razao_transportadora                       ,c.cli_cdgo codigo_cliente                       ,c.cli_rzao razao_social                       ,tm.municipio_nome cidade                       ,tm.unifed uf                       ,'S' consignatario          FROM esc                        e              ,ecl                        l              ,transportadoras_municipios tm              ,cli                        c              ,tra                        t         WHERE e.cli_cdgo = l.cli_cdgo           AND e.esc_seqn = l.esc_seqn           AND t.tra_cdgo = e.tra_consig           AND c.cli_cdgo = e.cli_cdgo           AND tm.cod_transportadora = e.tra_cdgo           AND tm.municipio_nome = l.ecl_cdad           AND tm.unifed = l.est_unifed           AND e.esc_situacao = 'A'           AND tm.pais_codigo = 55         ORDER BY codigo_transportadora                 ,codigo_cliente                 ,cidade)";
    return query;
  }

}
