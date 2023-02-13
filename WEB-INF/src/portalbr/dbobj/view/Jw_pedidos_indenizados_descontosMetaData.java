package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedidos_indenizados_descontos
  * @version 06/12/2019 15:28:15
  */
public class Jw_pedidos_indenizados_descontosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","240","false","text","cab_desc","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","240","false","text","cor_desc","","","","","","",},
                            {"java.lang.Integer","quantidade","22","false","text","quantidade","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.Integer","ite_seqn","22","false","text","ite_seqn","","","","","","",},
                            {"java.lang.Double","ite_prco","22","false","text","ite_prco","","","","","","",},
                            {"java.lang.Double","desconto_comercial","22","false","text","desconto_comercial","","","","","","",},
                            {"java.lang.Double","desconto_promocional","22","false","text","desconto_promocional","","","","","","",},
                            {"java.lang.Double","ite_prco_descontos","22","false","text","ite_prco_descontos","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT p.ped_nmro             , i.lin_cdgo			 , i.ref_cdgo			 , i.cab_cdgo			 , ca.cab_desc			 , i.cor_cdgo			 , co.cor_desc			 , 0 quantidade			 , p.cli_cdgo			 , p.esc_seqn			 , i.ite_seqn             , i.ite_prco			 			 , p.ped_boni desconto_comercial			 , ped_boni2 desconto_promocional			 , pck_calculos.subtrai_percentual(ite_prco, (ped_boni+ped_boni2)) ite_prco_descontos			    FROM ped p      , ite i      , cabedal ca      , cor co  WHERE p.ped_nmro = i.ped_nmro    AND co.cor_cdgo = i.cor_cdgo    AND ca.cab_cdgo = i.cab_cdgo    AND p.ped_stat = 'F'  ORDER BY ite_seqn";
    return query;
  }

}
