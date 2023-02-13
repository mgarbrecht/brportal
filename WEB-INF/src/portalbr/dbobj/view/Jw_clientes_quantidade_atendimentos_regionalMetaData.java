package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_quantidade_atendimentos_regional
  * @version 10/12/2020 15:01:05
  */
public class Jw_clientes_quantidade_atendimentos_regionalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","atendimentos","22","false","text","atendimentos","","","","","","",},
                            {"java.lang.Integer","clientes","22","false","text","clientes","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","240","false","text","nome_regional","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT atendimentos      , COUNT(DISTINCT cli_cdgo || '-' || esc_seqn) clientes   FROM (SELECT cli_cdgo              , esc_seqn              , COUNT(DISTINCT ped_nmro) atendimentos           FROM (SELECT p.cli_cdgo                      , p.esc_seqn                      , p.ped_nmro                   FROM ped p                      , rep r                      , ite i                  WHERE p.ped_dadg >= to_date('01122020', 'ddmmyyyy')                    AND p.ped_dadg < to_date('31122020', 'ddmmyyyy') + 1                    AND r.rep_cdgo = p.rep_cdgo                    AND NVL(p.ped_stat, 'X') <> 'C'                    AND NVL(p.ped_tipo, 'XX') IN ('EX', 'PG', 'PP')                    AND NVL(p.ped_especie_pedido, 'x') IN                        ('F', 'N', 'M', 'P', 'X')                    AND NVL(p.ped_substituicao, 'N') <> 'S'                    AND i.ped_nmro = p.ped_nmro                    AND NVL(p.cli_cdgo, NULL) <> 40000                 UNION                 SELECT p.cli_cdgo                       ,p.esc_seqn                       ,p.ped_nmro                   FROM ped p                       ,rep r                       ,ite i                  WHERE p.ped_dadg >= to_date('01122020', 'ddmmyyyy')                    AND p.ped_dadg < to_date('31122020', 'ddmmyyyy') + 1                    AND r.rep_cdgo = p.rep_cdgo                    AND NVL(p.ped_stat, 'X') <> 'C'                    AND NVL(p.ped_tipo, 'XX') IN ('EX', 'PG', 'PP')                    AND (NVL(p.ped_especie_pedido, 'x') IN ('C', 'R') OR                        NVL(p.ped_substituicao, 'N') = 'S')                    AND i.ped_nmro = p.ped_nmro                 )          GROUP BY cli_cdgo                  ,esc_seqn)  GROUP BY atendimentos  ORDER BY 1";
    return query;
  }

}
