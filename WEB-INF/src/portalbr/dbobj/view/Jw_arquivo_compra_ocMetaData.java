package portalbr.dbobj.view;

/** DataBase Object from table .Jw_arquivo_compra_oc
  * @version 12/08/2015 11:52:07
  */
public class Jw_arquivo_compra_ocMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","interface_arquivo_compra_id","22","false","text","interface_arquivo_compra_id","","","","","","",},
                            {"java.lang.Integer","forn_codigo","22","false","text","forn_codigo","","","","","","",},
                            {"java.lang.Integer","oco_numero","22","false","text","oco_numero","","","","","","",},
                            {"java.lang.Integer","rem_nro","22","false","text","rem_nro","","","","","","",},
                            {"java.sql.Timestamp","data_compra","22","false","text","data_compra","","","","","","",},
                            {"java.lang.String","nome_arquivo","100","false","text","nome_arquivo","","","","","","",},
                            {"java.lang.String","tipo","10","false","text","tipo","","","","","","",},
                            {"java.lang.String","ativo","10","false","text","ativo","","","","","","",},
                            {"java.lang.String","situacao","10","false","text","situacao","","","","","","",},
                            {"java.lang.String","descricao_situacao","100","false","text","descricao_situacao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT distinct iaco.interface_arquivo_compra_id       ,iac.for_codigo forn_codigo       ,iaco.oco_numero       ,iaco.rem_nro       ,iaco.data_compra       ,iac.nome_arquivo       ,iac.tipo       ,iac.ativo       ,iac.situacao       ,'' descricao_situacao   FROM interface_arquivo_compra_oc iaco       ,interface_arquivo_compra    iac  WHERE iaco.interface_arquivo_compra_id = iac.interface_arquivo_compra_id    AND iac.tipo = 'O'  ORDER BY data_compra";
    return query;
  }

}
