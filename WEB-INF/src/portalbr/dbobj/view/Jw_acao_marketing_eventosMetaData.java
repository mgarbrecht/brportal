package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing_eventos
  * @version 21/08/2013 11:23:02
  */
public class Jw_acao_marketing_eventosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Date","data_entrega","12","false","text","Data Entrega","","","","","","",},
                            {"int","acao","22","false","text","A��o","","","","","","",},
                            {"int","seq","22","false","text","Seq.","","","","","","",},
                            {"int","codigo_material","22","false","text","C�digo Material","","","","","","",},
                            {"java.lang.String","desc_material","40","false","text","Descri��o Material","","","","","","",},
                            {"java.lang.String","situacao","1","false","text","Situa��o","","","","","","",},
                            {"java.lang.String","imagem","100","false","text","Imagem","","","","","","",},
                            {"java.lang.String","formato","100","false","text","Formato","","","","","","",},
                            {"java.lang.String","observacao","4000","false","text","Observa��o A��o","","","","","","",},
                            {"java.lang.String","email","60","false","text","e-Mail","","","","","","",},
                            {"java.lang.String","obs_evento","60","false","text","Observa��o Evento","","","","","","",},
                            {"java.sql.Date","data_transacao","12","false","text","Data Evento","","","","","","",},
                            {"java.lang.String","usuario_transacao","60","false","text","Usu�rio Transa��o","","","","","","",},
                            {"int","cracha_usuario","22","false","text","Crach�","","","","","","",},
                            {"int","codigo_marca","3","false","text","C�digo Marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","Descri��o Marca","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_rzao","50","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT a.prazo_final data_entrega       ,a.seq_acao_mkt acao       ,e.seq_evento seq       ,a.cdgo_tmidia codigo_material       ,tm.desc_tmidia desc_material       ,a.situacao_acao_mkt situacao       ,a.descr_imagem imagem       ,a.especificacao_tmidia formato       ,a.obs_acao_mkt observacao       ,e.email       ,e.obs_evento       ,e.data_transacao       ,e.usuario_transacao       ,e.cracha_usuario       ,a.codigo_marca       ,pck_marcas_produtos.get_nome(a.codigo_marca) descricao_marca            ,a.cli_cdgo       ,pck_cliente.get_nome(a.cli_cdgo) cli_rzao       ,a.rep_cdgo       ,pck_representante.get_razao_social(a.rep_cdgo) rep_rzao   FROM acao_marketing a      , acao_marketing_eventos e      , tipo_midia tm  WHERE a.prazo_final IS NOT NULL    AND e.seq_acao_mkt = a.seq_acao_mkt    AND tm.cdgo_tmidia = a.cdgo_tmidia  ORDER BY a.prazo_final          , a.seq_acao_mkt         , e.seq_evento DESC";
    return query;
  }

}
