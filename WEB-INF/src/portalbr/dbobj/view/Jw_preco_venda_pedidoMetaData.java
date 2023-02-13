package portalbr.dbobj.view;

/** DataBase Object from table .Jw_preco_venda_pedido
  * @version 21/09/2016 12:09:14
  */
public class Jw_preco_venda_pedidoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"int","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","100","false","text","cli_rzao","","","","","","",},
                            {"java.sql.Timestamp","ped_daem","22","false","text","ped_daem","","","","","","",},
                            {"int","ite_seqn","22","false","text","ite_seqn","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.Double","ite_preco_venda","18","false","text","ite_preco_venda","","","","","","",},
                            {"java.lang.String","ped_ped_cliente","100","false","text","ped_ped_cliente","","","","","","",},
                            {"java.lang.String","rep_cdgo","20","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT p.ped_nmro        ,p.cli_cdgo        ,p.esc_seqn        ,c.cli_rzao        ,p.ped_daem        ,i.ite_seqn        ,i.lin_cdgo        ,i.ref_cdgo        ,i.cab_cdgo        ,i.cor_cdgo        ,i.ite_preco_venda        ,p.ped_ped_cliente        ,r.rep_cdgo        ,r.codigo_regional		    FROM ped p        ,ite i        ,cli c		,rep r   WHERE p.ped_nmro = i.ped_nmro     AND p.cli_cdgo = c.cli_cdgo	 AND p.rep_cdgo = r.rep_cdgo     AND p.ped_stat NOT IN ('C', 'F', 'L')   ORDER BY ped_daem DESC           ,p.ped_nmro           ,i.ite_seqn";
    return query;
  }

}
