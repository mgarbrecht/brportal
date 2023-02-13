package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_cad_roteiros
  * @version 27/11/2020 15:22:29
  */
public class Jw_clientes_cad_roteirosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cliente","83","false","text","cliente","","","","","","",},
                            {"java.lang.String","cliente_desde","20","false","text","cliente_desde","","","","","","",},
                            {"java.lang.String","situacao_cliente","38","false","text","situacao_cliente","","","","","","",},
                            {"java.lang.String","situacao_loja","7","false","text","situacao_loja","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","bairro_cidade_uf","96","false","text","bairro_cidade_uf","","","","","","",},
                            {"java.lang.String","esc_email","100","false","text","esc_email","","","","","","",},
                            {"java.lang.String","transportadora","100","false","text","transportadora","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","classificacao","10","false","text","classificacao","","","","","","",},
                            {"java.lang.String","seg_desc","30","false","text","seg_desc","","","","","","",},
                            {"java.lang.String","cli_aceita_antecipacao","3","false","text","cli_aceita_antecipacao","","","","","","",},
                            {"java.lang.String","cli_aceita_antecipacao_allegro","3","false","text","cli_aceita_antecipacao_allegro","","","","","","",},
                            {"java.lang.String","cli_aceita_antecipacao_riva","3","false","text","cli_aceita_antecipacao_riva","","","","","","",},
                            {"java.lang.String","grupo_economico","100","false","text","grupo_economico","","","","","","",},
                            {"java.lang.String","situacao_grupo","30","false","text","situacao_grupo","","","","","","",},
                            {"java.lang.Integer","codigo_motivo","22","false","text","codigo_motivo","","","","","","",},
                            {"java.lang.String","descricao_motivo","240","false","text","descricao_motivo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT cli.cli_cdgo || ' - ' || esc.esc_seqn cliente               ,TO_CHAR(cli_dtin, 'dd/mm/yyyy') || '(Rep' || NVL(codigo_representante_abertura, '-') || ')' cliente_desde               ,DECODE(cli_situ, 'A', 'Ativo', 'Inativo') || ' ' || mot.descricao_motivo situacao_cliente               ,DECODE(esc.esc_situacao, 'A', 'Ativo', 'Inativo') situacao_loja               ,cli_rzao               ,cli_nome               ,ecl_bair || ' - ' || ecl_cdad || '/' || ecl.est_unifed bairro_cidade_uf               ,esc.esc_email               ,tra.tra_nome transportadora               ,cli.cli_cdgo               ,esc.esc_seqn               ,'' classificacao               ,seg.seg_desc               ,DECODE(cli.cli_aceita_antecipacao, 'S', 'Sim', 'N', 'Não') cli_aceita_antecipacao               ,DECODE(cli.cli_aceita_antecipacao_allegro, 'S', 'Sim', 'N', 'Não') cli_aceita_antecipacao_allegro               ,DECODE(cli.cli_aceita_antecipacao_riva, 'S', 'Sim', 'N', 'Não') cli_aceita_antecipacao_riva               ,'' grupo_economico               ,'' situacao_grupo			   ,null codigo_motivo			   ,'' descricao_motivo  FROM cli cli      ,esc esc      ,ecl ecl      ,cliente_representante cli_rep      ,rep rep      ,motivos_bloqueios mot      ,seg seg      ,tra tra WHERE mot.codigo_motivo(+) = cli.codigo_motivo   AND seg.seg_cdgo = cli.seg_cdgo   AND esc.esc_seqn = ecl.esc_seqn   AND cli.cli_cdgo = esc.cli_cdgo   AND esc.cli_cdgo = ecl.cli_cdgo   AND esc.cli_cdgo = cli_rep.codigo_cliente   AND esc.esc_seqn = cli_rep.codigo_sequencial   AND rep.rep_cdgo = cli_rep.codigo_representante   AND (ecl.ned_cdgo = 'UNI' OR ecl.ned_cdgo = 'ENT')   AND esc.tra_cdgo = tra.tra_cdgo";
    return query;
  }

}
