package portalbr.dbobj.view;

/** DataBase Object from table .Jw_vendas_principais
  * @version 05/07/2010 07:04:25
  */
public class Jw_vendas_principaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","marca","9","false","text","marca","","","","","","",},
                            {"java.lang.String","periodo","7","false","text","periodo","","","","","","",},
                            {"int","pares","22","false","text","pares","","","","","","",},
                            {"double","valor","22","false","text","valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select marca, periodo, sum(pares)pares, sum(valor)valor from( select decode(p.codigo_marca,1,'VIZZANO','BEIRA RIO')marca,   to_char(trunc(data_dig,'MM'),'MM/YYYY')periodo,   sum(pares)pares,   sum(valor)valor from resumo_ped p,  grupo_economico g where data_dig>=to_date('10/10/2005','dd/mm/yyyy')  and data_dig < to_date('01/03/2006','dd/mm/yyyy')+ 1  and p.cli_cdgo=g.cli_cdgo  and g.gre_grupo=10 group by p.codigo_marca, trunc(data_dig,'MM') UNION ALL select decode(p.codigo_marca,1,'VIZZANO','BEIRA RIO')marca,   to_char(trunc(data_dig,'MM'),'MM/YYYY')periodo,   sum(pares)pares,   sum(valor)valor from resumo_pedidos p,  grupo_economico g where data_dig>=to_date('10/10/2005','dd/mm/yyyy')  and data_dig < to_date('01/03/2006','dd/mm/yyyy')+ 1  and p.cli_cdgo=g.cli_cdgo  and g.gre_grupo=10 group by p.codigo_marca, trunc(data_dig,'MM') ) group by marca, periodo";
    return query;
  }

}
