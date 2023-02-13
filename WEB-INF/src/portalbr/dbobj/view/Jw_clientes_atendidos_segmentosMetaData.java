package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_atendidos_segmentos
  * @version 27/05/2014 16:03:36
  */
public class Jw_clientes_atendidos_segmentosMetaData {

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
    String query = "select seg_cdgo      , seg_desc      , sum(pequeno) pequenos      , sum(medio) medios       , sum(grande) grandes      , sum(todos) todos   from ( select seg_cdgo               , seg_desc               , nvl(case when limite = 'Pequeno' then count(distinct cli_cdgo) end,0) pequeno               , nvl(case when limite = 'Médio' then count(distinct cli_cdgo) end,0) medio                , nvl(case when limite = 'Grande' then count(distinct cli_cdgo) end,0) grande                , nvl(count(distinct cli_cdgo),0) todos            from ( SELECT cli.cli_cdgo                        , s.seg_cdgo                        , s.seg_desc                        , case when p.limite_credito <=50000 then 'Pequeno'                               when p.limite_credito > 50000 and p.limite_credito <= 200000 then 'Médio'                               when p.limite_credito > 200000 then 'Grande'                               end limite                     FROM rep                         , cliente_representante clr                          , cli                         , representante_marca rm                        , PARAMETROS_CLIENTE P                        , seg s                    WHERE clr.codigo_representante = rep.rep_cdgo                       AND cli.cli_cdgo             = clr.codigo_cliente                        AND rm.codigo_representante  = rep.rep_cdgo                       AND cli.cli_situ             = 'A'                       AND cli.seg_cdgo             not in (9, 153)                       AND rep.rep_situ             = nvl('A',rep.rep_situ)                       AND clr.situacao             = nvl('A',clr.situacao)                       AND rm.situacao              = nvl('A',rm.situacao) 			                      and p.cli_cdgo = cli.cli_cdgo                      AND cli.seg_cdgo = s.seg_cdgo                      AND rep.codigo_regional = 1                 )          group by limite, seg_desc, seg_cdgo                 )   group by seg_desc, seg_cdgo";
    return query;
  }

}
