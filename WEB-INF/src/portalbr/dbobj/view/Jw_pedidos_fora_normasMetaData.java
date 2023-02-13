package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedidos_fora_normas
  * @version 03/04/2013 09:19:24
  */
public class Jw_pedidos_fora_normasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","ped_rep","7","false","text","ped_rep","","","","","","",},
                            {"java.lang.String","ped_stat","2","false","text","ped_stat","","","","","","",},
                            {"java.lang.String","ped_stat_real","10","false","text","ped_stat_real","","","","","","",},
                            {"java.sql.Timestamp","ped_data","22","false","text","ped_data","","dd/MM/yyyy","","","","",},
                            {"java.sql.Timestamp","ped_det","22","false","text","ped_det","","dd/MM/yyyy","","","","",},
                            {"java.sql.Timestamp","ped_emb","22","false","text","ped_emb","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","rep_codigo","5","false","text","rep_codigo","","","","","","",},
                            {"java.lang.String","cod_lin","22","false","text","cod_lin","","","","","","",},
                            {"java.lang.String","nome_lin","25","false","text","nome_lin","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct ped.ped_nmro ped_nmro, ped.ped_nped ped_rep, 		 ped.ped_stat ped_stat, 		 decode(ped.ped_stat,'A','Liber.Prod','B','Bloq.Imp', 		 'C','Cancelado','F','Faturado','L','Liberado','P','Bloq.Cred.', 		 'PF','Parc.Fat','T','Bloq.Com')ped_stat_real, 		 ped.ped_dadg ped_data, 		 ped.ped_det ped_det, 		 ped.ped_emba ped_emb, 		 ped.rep_cdgo rep_codigo, 		 ite.lin_cdgo cod_lin, 		 lin.lin_nome nome_lin from ped, ite, lin where ped.rep_cdgo=decode(54,null,ped.rep_cdgo,54)and ped.ped_stat <> 'C' and ped.ped_devolver_repres='X' and ped.ped_dadg>=to_date('10/10/2005','dd/mm/yyyy')and ped.ped_dadg < to_date('30/10/2005','dd/mm/yyyy')and ite.lin_cdgo=lin.lin_cdgo and ite.ped_nmro 			=ped.ped_nmro and ite.lin_cdgo 				=decode(NULL,null,ite.lin_cdgo,NULL)and ite.ref_cdgo 				=decode(NULL,null,ite.ref_cdgo,NULL)and ped.cli_cdgo=decode(NULL,null,ped.cli_cdgo,NULL)";
    return query;
  }

}
