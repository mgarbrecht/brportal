package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_nao_atendidos_segmentos
  * @version 16/05/2014 08:56:42
  */
public class Jw_clientes_nao_atendidos_segmentosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","seg_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.String","seg_desc","30","false","text","","","","","","","",},
                            {"int","pequenos","22","false","text","","","","","","","",},
                            {"int","medios","22","false","text","","","","","","","",},
                            {"int","grandes","22","false","text","","","","","","","",},
                            {"int","todos","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT seg_cdgo      ,seg_desc      ,SUM(pequeno) pequenos      ,SUM(medio) medios      ,SUM(grande) grandes      ,SUM(todos) todos  FROM (SELECT seg_cdgo              ,seg_desc              ,NVL(CASE                     WHEN limite = 'Pequeno' THEN                      COUNT(DISTINCT cli_cdgo)                   END, 0) pequeno              ,NVL(CASE                     WHEN limite = 'Médio' THEN                      COUNT(DISTINCT cli_cdgo)                   END, 0) medio              ,NVL(CASE                     WHEN limite = 'Grande' THEN                      COUNT(DISTINCT cli_cdgo)                   END, 0) grande              ,NVL(COUNT(DISTINCT cli_cdgo), 0) todos          FROM (SELECT cli.cli_cdgo                      ,s.seg_cdgo                      ,s.seg_desc                      ,CASE                         WHEN p.limite_credito <= 50000 THEN                          'Pequeno'                         WHEN p.limite_credito > 50000 AND                              p.limite_credito <= 200000 THEN                          'Médio'                         WHEN p.limite_credito > 200000 THEN                          'Grande'                       END limite                  FROM rep                      ,cliente_representante clr                      ,cli                      ,representante_marca rm                      ,parametros_cliente p                      ,seg s                 WHERE clr.codigo_representante = rep.rep_cdgo                   AND cli.cli_cdgo = clr.codigo_cliente                   AND rm.codigo_representante = rep.rep_cdgo                   AND cli.cli_situ = 'A'                   AND cli.seg_cdgo NOT IN (9, 153)                   AND rep.rep_situ = 'A'                   AND clr.situacao = 'A'                   AND rm.situacao = 'A'                   AND p.cli_cdgo = cli.cli_cdgo                   AND cli.seg_cdgo = s.seg_cdgo)         GROUP BY limite                 ,seg_desc                 ,seg_cdgo) GROUP BY seg_desc         ,seg_cdgo";
    return query;
  }

}
