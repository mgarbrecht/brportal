package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos
  * @version 03/04/2013 09:38:34
  */
public class Jw_consulta_pedidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo","81","false","text","codigo","","","","","","",},
                            {"java.lang.String","razao_social","35","false","text","razao_social","","","","","","",},
                            {"java.lang.String","cid_uf","65","false","text","cid_uf","","","","","","",},
                            {"java.lang.String","eunifed","2","false","text","eunifed","","","","","","",},
                            {"java.lang.String","ecidad","60","false","text","ecidad","","","","","","",},
                            {"java.lang.Integer","seqn","22","false","text","seqn","","","","","","",},
                            {"java.lang.Integer","cod","22","false","text","cod","","","","","","",},
                            {"java.lang.String","codigo_sucessor","22","false","text","Codigo Sucessor","","","","","","",},
                            {"java.lang.String","sequencial_sucessor","22","false","text","Sequencial Sucessor","","","","","","",},
                            {"java.lang.String","razao_social_sucessor","100","false","text","Razão Social Sucessor","","","","","","",},
                            {"java.lang.String","cid_uf_sucessor","100","false","text","Cidade","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select a.cli_cdgo||'-'||b.esc_seqn codigo,  cli_rzao razao_social,  ecl_cdad||' - '||c.est_unifed cid_uf,  c.est_unifed eunifed,  ecl_cdad ecidad,  b.esc_seqn seqn,  b.cli_cdgo cod, '' codigo_sucessor,'' sequencial_sucessor, '' razao_social_sucessor, '' cid_uf_sucessor  from brio.cli a, brio.esc b, brio.ecl c  where a.cli_rzao like 'P%' and b.esc_seqn=c.esc_seqn and  a.cli_cdgo=b.cli_cdgo and b.cli_cdgo=c.cli_cdgo and (c.ned_cdgo='UNI' or c.ned_cdgo='ENT')";
    return query;
  }

}
