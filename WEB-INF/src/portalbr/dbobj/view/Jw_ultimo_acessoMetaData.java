package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ultimo_acesso
  * @version 05/07/2010 07:05:48
  */
public class Jw_ultimo_acessoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cli","22","false","text","cli","","","","","","",},
                            {"java.lang.String","razao","35","false","text","razao","","","","","","",},
                            {"java.sql.Timestamp","data_ultimo","22","false","text","data_ultimo","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","cli_situ","1","false","text","cli_situ","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select a.cli_cdgo cli,  a.cli_rzao razao,  u.usua_dt_ultimo_acesso data_ultimo,  a.cli_situ  from cli a,  wbrio.usuarios u,  wbrio.entidades_negocio e,  wbrio.tipos_entidade_negocio t  where u.usua_usuario=to_char(a.cli_cdgo)  and e.enne_id=u.usua_enne_id  and t.tien_id=e.enne_tien_id  and t.tien_id in(2193, 2194)  order by 3 asc";
    return query;
  }

}
