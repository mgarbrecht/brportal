package portalbr.dbobj.view;

/** DataBase Object from table .Jw_dom_obri_abatimentos
  * @version 23/07/2018 14:54:39
  */
public class Jw_dom_obri_abatimentosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","nm_obri","100","false","text","nm_obri","","","","","","",},
                            {"java.lang.String","cd_enti","20","false","text","cd_enti","","","","","","",},
                            {"java.lang.String","codi_tipo_ender","30","false","text","codi_tipo_ender","","","","","","",},
                            {"java.lang.String","cd_tipo","100","false","text","cd_tipo","","","","","","",},
                            {"java.lang.String","cd_tran","30","false","text","cd_tran","","","","","","",},
                            {"java.lang.String","nm_descri","200","false","text","","","","","","","",},
                            {"double","vl_pago","18","false","text","vl_pago","","","","","","",},
                            {"java.sql.Timestamp","dt_moob","22","false","text","dt_moob","","","","","","",},
                            {"java.lang.String","te_observ","480","false","text","te_observ","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT nm_obri       ,cd_enti       ,dmo.codi_tipo_ender       ,dmo.cd_tipo       ,dmo.cd_tran       ,de.nm_descri       ,vl_pago       ,dmo.dt_moob       ,dmo.te_observ   FROM dom_movto_obrigacao dmo       ,eventos_Grupo       eg       ,dom_evento          de  WHERE eg.cd_tran = dmo.cd_tran    AND de.cd_tran = eg.cd_tran    AND eg.codigo_grupo_evento = 4";
    return query;
  }

}
