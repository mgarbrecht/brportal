package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ultimo_acesso_analista
  * @version 05/07/2010 07:05:36
  */
public class Jw_ultimo_acesso_analistaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","divisao_gerente","1","false","text","divisao_gerente","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","35","false","text","rep_rzao","","","","","","",},
                            {"java.sql.Timestamp","data_ultimo_acesso","22","false","text","data_ultimo_acesso","","dd/MM/yyyy HH:mm","","","","",},
                            {"java.lang.String","rep_situ","1","false","text","rep_situ","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select g.divisao_gerente, rep_cdgo, rep_rzao, u.usua_dt_ultimo_acesso data_ultimo_acesso, r.rep_situ from brio.rep r, brio.gerentes_regionais_vendas g, wbrio.usuarios u, wbrio.entidades_negocio e, wbrio.tipos_entidade_negocio t where u.usua_usuario=r.rep_cdgo and g.codigo_gerente=r.rep_cdgo and e.enne_id=u.usua_enne_id and t.tien_id=e.enne_tien_id and t.tien_id=2101";
    return query;
  }

}
