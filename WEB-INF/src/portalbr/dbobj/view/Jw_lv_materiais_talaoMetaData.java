package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_materiais_talao
  * @version 20/01/2016 12:30:02
  */
public class Jw_lv_materiais_talaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","ies_codigo","200","false","text","ies_codigo","","","","","","",},
                            {"java.lang.String","ies_descricao","200","false","text","ies_descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT itm.cod_peca ies_codigo                      , itm.desc_peca ies_descricao   FROM interface_arq_compra_tal     iat       ,interface_arq_compra_tal_mat itm       ,interface_arq_compra         iac       ,interface_arq_compra_oc      iaco  WHERE iac.interface_arq_compra_id = iat.interface_arq_compra_id    AND iaco.oco_numero = iat.oco_numero    AND iat.interface_arq_compra_id = itm.interface_arq_compra_id    AND iat.rem_nro = itm.rem_nro    AND iat.tal_nro = itm.tal_nro    AND NVL(iac.ativo, NULL) = 'S'    AND NVL(iac.tipo, NULL) = 'T'";
    return query;
  }

}
