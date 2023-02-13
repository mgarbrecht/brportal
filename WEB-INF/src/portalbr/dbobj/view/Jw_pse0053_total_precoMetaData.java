package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_total_preco
  * @version 03/04/2013 09:14:32
  */
public class Jw_pse0053_total_precoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","pares","22","false","text","","","","","","","",},
                            {"double","preco","22","false","text","","","","","","","",},
                            {"double","total","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select pares, preco, pares*preco total from (  SELECT SUM(tal_pares) pares  ,  pck_atelier.get_preco(a.emp_empresa,a.fil_filial,pck_filial.get_unn_codigo(a.fil_filial,a.emp_empresa),a.lin_cdgo,a.ref_cdgo,null,a.pro_numero,a.for_codigo,a.fen_seq) preco    FROM atelier_pre_envio a    WHERE a.fil_filial = '16'       AND a.for_codigo = 703455      AND a.pro_numero = 1       AND a.data_pre_envio >= to_date('18/08/2009','dd/mm/yyyy')       AND a.data_pre_envio < to_date('17/09/2009','dd/mm/yyyy') + 1       AND (('E' = 'E' AND a.status IS NULL) OR ('E' = 'R' AND a.status_retorno = 'C'))  group by pck_atelier.get_preco(a.emp_empresa,a.fil_filial,pck_filial.get_unn_codigo(a.fil_filial,a.emp_empresa),a.lin_cdgo,a.ref_cdgo,null,a.pro_numero,a.for_codigo,a.fen_seq)      )";
    return query;
  }

}
