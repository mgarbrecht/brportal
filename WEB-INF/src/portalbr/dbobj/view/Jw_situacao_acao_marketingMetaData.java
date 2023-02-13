package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacao_acao_marketing
  * @version 05/04/2013 10:53:42
  */
public class Jw_situacao_acao_marketingMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","nome_regional","100","false","text","nome_regional","","","","","","",},
                            {"java.lang.String","sigla_uf","20","false","text","sigla_uf","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","100","false","text","descricao_marca","","","","","","",},
                            {"java.lang.Integer","acao","20","false","text","acao","","","","","","",},
                            {"java.sql.Date","data_transacao","22","false","text","data_transacao","","","","","","",},
                            {"java.lang.Integer","cdgo_tmidia","22","false","text","cdgo_tmidia","","","","","","",},
                            {"java.lang.String","desc_tmidia","200","false","text","desc_tmidia","","","","","","",},
                            {"java.lang.Integer","codigo_situacao","22","false","text","codigo_situacao","","","","","","",},
                            {"java.lang.String","descricao_situacao","80","false","text","descricao_situacao","","","","","","",},
                            {"java.lang.String","estagios_marcados","4000","false","text","estagios_marcados","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_rzao","200","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","rep_cdgo","10","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","80","false","text","rep_rzao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select a.codigo_regional        , pck_regionais_vendas.get_nome(a.codigo_regional) nome_regional        , pck_regionais_vendas.get_sigla(a.codigo_regional) sigla_uf        , a.codigo_marca        , decode(a.codigo_marca,98,'MULTIMARCA',99,'INSTITUCIONAL',pck_marcas_produtos.get_nome(a.codigo_marca)) descricao_marca        , a.seq_acao_mkt acao        , a.data_transacao        , a.cdgo_tmidia        , tm.desc_tmidia        , s.codigo codigo_situacao        , DECODE(a.situacao_acao_mkt, 1, '1 - COTADA' , DECODE(a.situacao_acao_mkt,9,'9 - CANCELADA','2 - APROVADA')) descricao_situacao            , (SELECT rowtocol('SELECT estagio_cdgo FROM brio.acao_marketing_estagios_status WHERE seq_acao_mkt = '||a.seq_acao_mkt) FROM dual) estagios_marcados        , a.cli_cdgo        , pck_cliente.get_nome(a.cli_cdgo) cli_rzao        , r.rep_cdgo        , r.rep_rzao     FROM acao_marketing a        , tipo_midia     tm        , acao_marketing_situacoes s        , rep r    WHERE a.cdgo_tmidia   = tm.cdgo_tmidia      AND s.codigo        = a.situacao_acao_mkt      AND r.rep_cdgo  (+) = a.rep_cdgo      AND ROWNUM = 1   ORDER BY data_transacao DESC";
    return query;
  }

}
