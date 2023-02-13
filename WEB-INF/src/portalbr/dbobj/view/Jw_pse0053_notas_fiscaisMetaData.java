package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_notas_fiscais
  * @version 20/07/2017 11:10:10
  */
public class Jw_pse0053_notas_fiscaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","pro_numero","22","false","text","pro_numero","","","","","","",},
                            {"java.lang.String","pro_nome","100","false","text","pro_nome","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","text","nfs_nmro","","","","","","",},
                            {"java.lang.String","remessas","2000","false","text","remessas","","","","","","",},
                            {"java.lang.String","oc","2000","false","text","oc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT                  a.pro_numero				,pck_processo_fab.get_nome(a.pro_numero) pro_nome                ,n.fil_filial                ,n.nfs_serie                ,n.nfs_nmro				,'' remessas				,'' oc   FROM atelier_pre_envio a       ,cpr.dom_item_ordem_item_requisicao i       ,atelier_rem_taloes_oc o       ,fat.notas_fiscais_saida_requis n  WHERE a.fil_filial = '12'    AND a.for_codigo = 701838    AND a.pro_numero = 3    AND a.data_pre_envio >= TO_DATE('17/07/2013', 'dd/mm/yyyy')    AND a.data_pre_envio < TO_DATE('17/12/2013', 'dd/mm/yyyy') + 1    AND a.rem_nro = o.aroc_rem_nro    AND a.tal_nro = o.tal_nro    AND a.pro_numero = o.pro_numero    AND a.for_codigo = o.for_codigo    AND o.aroc_oco_numero = i.oco_numero    AND i.reqnf_numero = n.reqnf_numero  ORDER BY pro_numero, fil_filial, nfs_serie, nfs_nmro";
    return query;
  }

}
