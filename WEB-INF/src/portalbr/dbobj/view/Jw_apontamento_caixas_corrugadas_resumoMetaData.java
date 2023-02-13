package portalbr.dbobj.view;

/** DataBase Object from table .Jw_apontamento_caixas_corrugadas_resumo
  * @version 23/09/2022 12:25:16
  */
public class Jw_apontamento_caixas_corrugadas_resumoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","total_caixas","22","false","text","total_caixas","","","","","","",},
                            {"java.lang.Integer","caixas_pendentes","22","false","text","caixas_pendentes","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT        x.lin_cdgo       ,COUNT(x.qtde) total_caixas       ,COUNT(x.qtde) - SUM(caixa_apontada) caixas_pendentes   FROM (SELECT rr.rem_nro               ,rr.seq_rotulo               ,i.lin_cdgo               ,rr.total_pares qtde               ,COUNT(DISTINCT rra.rem_nro || rra.rotulo || rra.ped_nmro) caixa_apontada           FROM rotulos_remessa_apont rra               ,rotulos_remessa       rr               ,ped                   p               ,ite                   i               ,rep                   r          WHERE rra.rem_nro(+) = rr.rem_nro            AND rra.ped_nmro(+) = rr.ped_nmro            AND rra.ite_seqn(+) = rr.ite_seqn            AND rra.rotulo(+) = rr.seq_rotulo            AND p.ped_nmro = rr.ped_nmro            AND NVL(rr.tipo_geracao, NULL) <> 'E'            AND i.ped_nmro = rr.ped_nmro            AND i.ite_seqn = rr.ite_seqn            AND r.rep_cdgo = p.rep_cdgo            AND rr.rem_nro IN (2143178, 2104249, 2135083)          GROUP BY rr.rem_nro                  ,rr.seq_rotulo                  ,i.lin_cdgo                  ,rr.total_pares) x  GROUP BY x.lin_cdgo  order by lin_cdgo";
    return query;
  }

}
