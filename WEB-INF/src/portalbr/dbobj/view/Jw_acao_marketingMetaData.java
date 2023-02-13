package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing
  * @version 03/04/2013 09:53:45
  */
public class Jw_acao_marketingMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Date","data_entrega","12","false","text","","","","","","","",},
                            {"java.sql.Date","data_entrada","12","false","text","","","","","","","",},
                            {"java.lang.String","competencia","22","false","text","","","","","","","",},
                            {"int","acao","-22","false","text","","","","","","","",},
                            {"int","codigo_material","22","false","text","","","","","","","",},
                            {"java.lang.String","desc_material","40","false","text","","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","","","","","","","",},
                            {"java.lang.String","imagem","100","false","text","","","","","","","",},
                            {"java.lang.String","formato","100","false","text","","","","","","","",},
                            {"java.lang.String","observacao","4000","false","text","","","","","","","",},
                            {"java.lang.String","cracha_usuario","22","false","text","","","","","","","",},
                            {"int","codigo_regional","3","false","text","Código Regional","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","Nome Regional","","","","","","",},
                            {"java.lang.String","email","100","false","text","email","","","","","","",},
                            {"int","codigo_marca","3","false","text","Código Marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","Descrição Marca","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT a.prazo_final data_entrega      ,TRUNC(a.data_transacao) data_entrada      ,to_char(to_date(periodo,'mmyyyy'),'mm/yyyy') competencia	        ,a.seq_acao_mkt acao      ,a.cdgo_tmidia codigo_material      ,tm.desc_tmidia desc_material      ,a.situacao_acao_mkt situacao      ,a.imagem_tmidia imagem      ,a.especificacao_tmidia formato      ,a.obs_acao_mkt observacao      ,(SELECT e.cracha_usuario         FROM acao_marketing_eventos e        WHERE e.seq_acao_mkt = a.seq_acao_mkt          AND e.seq_evento   = (SELECT MAX(ee.seq_evento)                                   FROM acao_marketing_eventos ee                                 WHERE ee.seq_acao_mkt = e.seq_acao_mkt)) cracha_usuario      ,a.codigo_regional      ,r.sigla_regional nome_regional      ,a.email      ,a.codigo_marca      ,DECODE(a.codigo_marca,99,'INSTITUCIONAL',          decode(a.codigo_marca,98,'MULTIMARCA',pck_marcas_produtos.get_nome(a.codigo_marca))) descricao_marca  FROM acao_marketing a      ,tipo_midia tm      ,regionais_vendas r WHERE a.prazo_final IS NOT NULL   AND r.codigo_regional = a.codigo_regional   AND tm.cdgo_tmidia = a.cdgo_tmidia   AND a.situacao_acao_mkt NOT IN (9, 10) ORDER BY a.prazo_final         ,a.seq_acao_mkt";
    return query;
  }

}
