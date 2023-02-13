package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_duplicata_transacoes
  * @version 16/05/2014 09:18:47
  */
public class Jw_consulta_duplicata_transacoesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","tit_codigo","8","false","text","tit_codigo","","","","","","",},
                            {"java.lang.String","port","4","false","text","port","","","","","","",},
                            {"java.lang.String","trn_codigo","3","false","text","trn_codigo","","","","","","",},
                            {"java.lang.String","transacao","30","false","text","transacao","","","","","","",},
                            {"java.sql.Timestamp","dt","22","false","text","dt","","dd/MM/yyyy","","","","",},
                            {"java.sql.Timestamp","venc_ant","22","false","text","venc_ant","","dd/MM/yyyy","","","","",},
                            {"double","valor_anterior","24","false","text","valor_anterior","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT tit_codigo      ,r.prt_codigo port      ,t.trn_codigo      ,t.trn_descri transacao      ,r.mov_data dt      ,r.mov_datvenc venc_ant      ,r.mov_valor valor_anterior  FROM mov_receber r      ,trans_rec t WHERE r.trn_codigo = t.trn_codigo   AND NVL(r.prt_codigo, ' ') <> '999'";
    return query;
  }

}
