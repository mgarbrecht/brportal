package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_espaco_banco
  * @version 14/12/2015 11:36:13
  */
public class Jw_consulta_espaco_bancoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","dg_name","100","false","text","dg_name","","","","","","",},
                            {"java.lang.String","dg_state","100","false","text","dg_state","","","","","","",},
                            {"double","dg_free_mb","22","false","text","dg_free_mb","","","","","","",},
                            {"double","dg_total_mb","22","false","text","dg_total_mb","","","","","","",},
                            {"double","perc_free","22","false","text","perc_free","","","","","","",},
                            {"java.lang.String","dt_data","16","false","text","dt_data","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT adg.name dg_name                    ,adg.state dg_state                    ,adg.free_mb dg_free_mb                    ,adg.total_mb dg_total_mb                    ,ROUND((adg.free_mb * 100) / adg.total_mb, 2) perc_free                    ,to_char(sysdate,'dd/mm/yyyy hh24:mi') dt_data       FROM v$asm_disk ad           ,v$asm_diskgroup adg      WHERE ad.group_number(+) = adg.group_number";
    return query;
  }

}
