package portalbr.dbobj.view;

/** DataBase Object from table .Jw_status_situacoes
  * @version 16/07/2019 08:49:17
  */
public class Jw_status_situacoesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","status_situacoes","10","false","text","status_situacoes","","","","","","",},
                            {"java.lang.String","ped_stat","10","false","text","ped_stat","","","","","","",},
                            {"java.lang.Integer","ite_situ","22","false","text","ite_situ","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select valor status_situacoes, substr(valor,0,1) ped_stat, substr(valor,2,2) ite_situ from wbrio.parametros where nome = 'status_situacoes_pedidos' and par_sist_codigo = 'BRPORTAL'order by status_situacoes";
    return query;
  }

}
