package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_cld_usuarios
  * @version 05/07/2010 07:07:41
  */
public class Jw_titulos_cld_usuariosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_reg","22","false","text","codigo_reg","","","","","","",},
                            {"java.lang.String","nome_reg","40","false","text","nome_reg","","","","","","",},
                            {"java.lang.String","codigo_ger","22","false","text","codigo_ger","","","","","","",},
                            {"java.lang.String","nome_ger","40","false","text","nome_ger","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "Select distinct reg.codigo_regional		codigo_reg, reg.nome_regional			nome_reg, ger.codigo_gerente			codigo_ger, ger.nome_gerente				nome_ger from regionais_vendas				reg, rep 				rep, gerentes_regionais_vendas ger where reg.codigo_regional=nvl(NULL,reg.codigo_regional)and rep.rep_cdgo=nvl(NULL,rep.rep_cdgo)and reg.codigo_regional=rep.codigo_regional and rep.codigo_gerente=ger.codigo_gerente";
    return query;
  }

}
