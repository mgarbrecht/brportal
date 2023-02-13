package portalbr.dbobj.view;

/** DataBase Object from table .Jw_controle_clientes_especiais_log
  * @version 04/05/2016 12:46:44
  */
public class Jw_controle_clientes_especiais_logMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","data_log","22","false","text","data_log","","","","","","",},
                            {"java.lang.String","usuario","100","false","text","usuario","","","","","","",},
                            {"java.lang.String","acao","100","false","text","acao","","","","","","",},
                            {"java.lang.String","nome_coluna","100","false","text","nome_coluna","","","","","","",},
                            {"java.lang.String","old_value","2000","false","text","old_value","","","","","","",},
                            {"java.lang.String","new_value","2000","false","text","new_value","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT lo.data data_log       ,lo.usuario        ,lo.acao        ,lc.nome_coluna        ,lc.old_value        ,lc.new_value    FROM log_coluna lc        ,log_operacao lo   WHERE lc.log_operacao_seq = lo.log_operacao_seq     AND lc.log_operacao_seq IN (SELECT e.log_operacao_seq                                   FROM log_operacao e                                       ,log_coluna l                                  WHERE NVL(e.tabela, NULL) = 'PED_INF_ADICIONAIS'                                    AND e.log_operacao_seq = l.log_operacao_seq                                    AND l.nome_coluna = 'PED_NMRO'                                    AND l.new_value = TO_CHAR(12837448))     AND lc.nome_coluna <> 'PED_NMRO'   ORDER BY lo.data DESC           ,lo.log_operacao_seq";
    return query;
  }

}
