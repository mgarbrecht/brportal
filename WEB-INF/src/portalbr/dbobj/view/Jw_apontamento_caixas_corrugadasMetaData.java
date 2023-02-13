package portalbr.dbobj.view;

/** DataBase Object from table .Jw_apontamento_caixas_corrugadas
  * @version 21/09/2022 11:25:01
  */
public class Jw_apontamento_caixas_corrugadasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","22","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","40","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","240","false","text","descricao_marca","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_desc","240","false","text","cli_desc","","","","","","",},
                            {"java.lang.String","apont","22","false","text","apont","","","","","","",},
                            {"java.sql.Timestamp","data_apont","22","false","text","data_apont","","","","","","",},
                            {"java.lang.String","usuario_apont","240","false","text","usuario_apont","","","","","","",},
                            {"java.sql.Timestamp","data_alteracao","22","false","text","data_alteracao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","240","false","text","usuario_alteracao","","","","","","",},
                            {"java.lang.String","ped_invoice","20","false","text","ped_invoice","","","","","","",},
                            {"java.lang.Integer","normativa","22","false","text","normativa","","","","","","",},
                            {"java.lang.Integer","tra_cdgo","22","false","text","tra_cdgo","","","","","","",},
                            {"java.lang.Integer","rem_nro","22","false","text","rem_nro","","","","","","",},
                            {"java.lang.Integer","seq_rotulo","22","false","text","seq_rotulo","","","","","","",},
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.Integer","ite_seqn","22","false","text","ite_seqn","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.Integer","qtde","22","false","text","qtde","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT *    FROM (SELECT DISTINCT p.emp_empresa                         ,fct_retorna_fil_producao(p.ped_nmro, i.ite_seqn) fil_filial                         ,i.codigo_marca                         ,mp.descricao_marca                         ,p.cli_cdgo                         ,c.cli_rzao cli_desc                         ,'NÃO' apont                         ,NULL data_apont                         ,NULL usuario_apont                         ,NULL data_alteracao                         ,NULL usuario_alteracao                         ,p.ped_invoice                         ,pck_cliente.get_normativa(p.cli_cdgo, p.esc_seqn) normativa                         ,p.tra_cdgo                         ,rr.rem_nro                         ,rr.seq_rotulo                         ,rr.ped_nmro                         ,rr.ite_seqn                         ,i.lin_cdgo                         ,i.ref_cdgo                         ,i.cab_cdgo                         ,i.cor_cdgo                         ,rr.total_pares qtde            FROM rotulos_remessa     rr                ,ped                 p                ,qtd_rotulos_remessa q                ,ite                 i                ,rep                 r                ,cli                 c                ,marcas_produtos     mp           WHERE ('N' = 'T' OR 'N' = 'N')            AND p.ped_nmro = rr.ped_nmro             AND p.cli_cdgo = c.cli_cdgo             AND i.codigo_marca = mp.codigo_marca             AND (rr.tipo_geracao != 'E' OR EXISTS (SELECT NULL                                                      FROM ped_inf_adicionais a                                                     WHERE a.ped_nmro = p.ped_nmro                                                       AND a.etiquetas IS NOT NULL))             AND q.ped_nmro = rr.ped_nmro             AND q.ite_seqn = rr.ite_seqn             AND q.rem_nro = rr.rem_nro             AND q.rotulo = rr.rotulo             AND i.ped_nmro = rr.ped_nmro             AND i.ite_seqn = rr.ite_seqn             AND r.rep_cdgo = p.rep_cdgo             AND rr.rem_nro IN (2143178, 2104249)             AND NOT EXISTS (SELECT *                    FROM rotulos_remessa_apont a                   WHERE a.ped_nmro = rr.ped_nmro                     AND a.ite_seqn = rr.ite_seqn                     AND a.rem_nro = rr.rem_nro                     AND a.rotulo = rr.seq_rotulo                     AND ROWNUM = 1)          UNION ALL          SELECT DISTINCT p.emp_empresa                         ,fct_retorna_fil_producao(p.ped_nmro, i.ite_seqn) fil_filial                         ,i.codigo_marca                         ,mp.descricao_marca                         ,p.cli_cdgo                         ,c.cli_rzao cli_desc                         ,'SIM' apont                         ,a.data_apont_leitura data_apont                         ,a.usuario_inclusao usuario_apont                         ,a.dthr_alteracao data_alteracao                         ,a.usuario_alteracao usuario_alteracao                         ,p.ped_invoice                         ,pck_cliente.get_normativa(p.cli_cdgo, p.esc_seqn) normativa                         ,p.tra_cdgo                         ,rr.rem_nro                         ,rr.seq_rotulo                         ,rr.ped_nmro                         ,rr.ite_seqn                         ,i.lin_cdgo                         ,i.ref_cdgo                         ,i.cab_cdgo                         ,i.cor_cdgo                         ,rr.total_pares qtde            FROM rotulos_remessa       rr                ,ped                   p                ,qtd_rotulos_remessa   q                ,ite                   i                ,rep                   r                ,cli                   c                ,marcas_produtos       mp                ,rotulos_remessa_apont a           WHERE ('N' = 'T' OR 'N' = 'A')             AND p.ped_nmro = rr.ped_nmro             AND p.cli_cdgo = c.cli_cdgo             AND i.codigo_marca = mp.codigo_marca             AND (rr.tipo_geracao != 'E' OR EXISTS (SELECT NULL                                                      FROM ped_inf_adicionais a                                                     WHERE a.ped_nmro = p.ped_nmro                                                       AND a.etiquetas IS NOT NULL))             AND q.ped_nmro = rr.ped_nmro             AND q.ite_seqn = rr.ite_seqn             AND q.rem_nro = rr.rem_nro             AND q.rotulo = rr.rotulo             AND i.ped_nmro = rr.ped_nmro             AND i.ite_seqn = rr.ite_seqn             AND r.rep_cdgo = p.rep_cdgo             AND a.ped_nmro = rr.ped_nmro             AND a.ite_seqn = rr.ite_seqn             AND a.rem_nro = rr.rem_nro             AND a.rotulo = rr.seq_rotulo             AND rr.rem_nro IN (2143178, 2104249)         )   ORDER BY emp_empresa           ,fil_filial           ,codigo_marca           ,cli_cdgo";
    return query;
  }

}
