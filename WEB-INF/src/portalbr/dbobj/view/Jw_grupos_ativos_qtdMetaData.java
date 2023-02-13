package portalbr.dbobj.view;

/** DataBase Object from table .Jw_grupos_ativos_qtd
  * @version 03/04/2013 09:27:12
  */
public class Jw_grupos_ativos_qtdMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","qtd_grupos","22","false","text","qtd_grupos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select count(distinct grec.gre_grupo)qtd_grupos from cliente_representante clre, grupo_economico grec, representante_marca rema, rep repr, regionais_vendas reve, marcas_produtos mapr where clre.codigo_representante=repr.rep_cdgo and clre.situacao='A' and grec.cli_cdgo=clre.codigo_cliente and rema.codigo_representante=repr.rep_cdgo and rema.situacao='A' and reve.codigo_regional=repr.codigo_regional and mapr.codigo_marca=rema.marca_produto and reve.codigo_regional=1";
    return query;
  }

}
