package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fornecedores_atelier
  * @version 17/02/2021 15:54:11
  */
public class Jw_fornecedores_atelierMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","usua_usuario","30","false","text","","","","","","","",},
                            {"java.lang.String","usua_nome","40","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select usua_usuario , usua_nome  from wbrio.usuarios us       , wbrio.entidades_negocio en    where us.usua_enne_id = en.enne_id      and en.enne_tien_id = 8065";
    return query;
  }

}
