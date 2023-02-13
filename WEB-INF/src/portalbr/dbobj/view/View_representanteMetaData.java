package portalbr.dbobj.view;

/** DataBase Object from table .View_representante
  * @version 03/04/2013 09:05:10
  */
public class View_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","regional","44","false","text","regional","","","","","","",},
                            {"java.lang.String","representante","36","false","text","representante","","","","","","",},
                            {"java.lang.String","codigo_representante","5","false","text","codigo_representante","","","","","","",},
                            {"double","clientes_ativos","22","false","text","clientes_ativos","","","","","","",},
                            {"double","clientes_atendidos","22","false","text","clientes_atendidos","","","","","","",},
                            {"double","clientes_nao_atendidos","22","false","text","clientes_nao_atendidos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select lpad(rp.codigo_regional, 3, 0)||'-'||rv.nome_regional regional, cr.codigo_representante||'-'||rep.rep_nome representante, cr.codigo_representante, count(distinct(c.cli_cdgo))clientes_ativos, count(distinct(rp.cli_cdgo))clientes_atendidos, count(distinct(c.cli_cdgo))-count(distinct(rp.cli_cdgo))clientes_nao_atendidos from resumo_ped rp, cliente_representante cr, cli c, regionais_vendas rv, represen rep where rp.rep_cdgo=cr.codigo_representante and c.cli_cdgo=cr.codigo_cliente and rv.codigo_regional=rp.codigo_regional and rp.data_dig='10-NOV-2005' and cr.situacao='A' and rep.rep_cdgo=cr.codigo_representante group by rp.codigo_regional, rv.nome_regional, cr.codigo_representante, rep.rep_nome, cr.codigo_representante";
    return query;
  }

}
