package portalbr.dbobj.view;

/** DataBase Object from table .Jw_interface_arq_compra
  * @version 18/08/2015 14:16:09
  */
public class Jw_interface_arq_compraMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","interface_arq_compra_id","22","false","text","interface_arq_compra_id","","","","","","",},
                            {"java.lang.Integer","forn_codigo","22","false","text","forn_codigo","","","","","","",},
                            {"java.lang.String","nome_arquivo","100","false","text","nome_arquivo","","","","","","",},
                            {"java.lang.String","situacao","10","false","text","situacao","","","","","","",},
                            {"java.lang.String","descricao_situacao","100","false","text","descricao_situacao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT iac.interface_arq_compra_id       ,iac.for_codigo forn_codigo       ,iac.nome_arquivo       ,iac.situacao       ,'' descricao_situacao   FROM interface_arq_compra iac";
    return query;
  }

}
