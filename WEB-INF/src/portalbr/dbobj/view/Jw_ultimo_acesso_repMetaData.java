package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ultimo_acesso_rep
  * @version 05/07/2010 07:05:23
  */
public class Jw_ultimo_acesso_repMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_regional","22","false","hidden","","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","","","","","","","",},
                            {"java.lang.String","codigo","5","false","text","Código","","","","","","",},
                            {"java.lang.String","nome","35","false","text","Nome","","","","","","",},
                            {"java.sql.Timestamp","usua_dt_ultimo_acesso","22","false","text","","","","","","","",},
                            {"java.lang.String","rep_situ","7","false","text","Situação","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select r.codigo_regional, rv.nome_regional, rep_cdgo codigo, rep_rzao nome, u.usua_dt_ultimo_acesso, decode(r.rep_situ,'A','Ativo','I','Inativo')rep_situ from brio.rep r, wbrio.usuarios u, regionais_vendas rv where r.rep_cdgo=u.usua_usuario and r.codigo_regional=rv.codigo_regional";
    return query;
  }

}
