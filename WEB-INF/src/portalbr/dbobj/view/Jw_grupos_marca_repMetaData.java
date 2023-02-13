package portalbr.dbobj.view;

/** DataBase Object from table .Jw_grupos_marca_rep
  * @version 03/04/2013 09:27:02
  */
public class Jw_grupos_marca_repMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cod_marca","22","false","text","cod_marca","","","","","","",},
                            {"java.lang.String","marca","30","false","text","marca","","","","","","",},
                            {"java.lang.String","cod_regional","22","false","text","cod_regional","","","","","","",},
                            {"java.lang.String","regional","40","false","text","regional","","","","","","",},
                            {"java.lang.String","cod_rep","5","false","text","cod_rep","","","","","","",},
                            {"java.lang.String","rep","35","false","text","rep","","","","","","",},
                            {"java.lang.String","grupos_ativos","22","false","text","grupos_ativos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select rema.marca_produto cod_marca, mapr.descricao_marca marca, reve.codigo_regional cod_regional, reve.nome_regional regional, repr.rep_cdgo cod_rep, nvl(repr.rep_nome, repr.rep_rzao)rep, count(distinct grec.gre_grupo)grupos_ativos from cliente_representante clre, grupo_economico grec, representante_marca rema, rep repr, regionais_vendas reve, marcas_produtos mapr where clre.codigo_representante=repr.rep_cdgo and clre.situacao='A' and grec.cli_cdgo=clre.codigo_cliente and rema.codigo_representante=repr.rep_cdgo and rema.situacao='A' and reve.codigo_regional=repr.codigo_regional and mapr.codigo_marca=rema.marca_produto group by rema.marca_produto, mapr.descricao_marca, reve.codigo_regional, reve.nome_regional, repr.rep_cdgo, nvl(repr.rep_nome, repr.rep_rzao)";
    return query;
  }

}
