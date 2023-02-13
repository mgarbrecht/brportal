package portalbr.dbobj.view;

/** DataBase Object from table .Jw_verif_caixas_corrugados
  * @version 07/05/2015 09:37:18
  */
public class Jw_verif_caixas_corrugadosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","rem_nro","22","false","text","rem_nro","","","","","","",},
                            {"java.lang.Integer","seq_rotulo","22","false","text","seq_rotulo","","","","","","",},
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","qtt_nume","5","false","text","qtt_nume","","","","","","",},
                            {"java.lang.String","produto","100","false","text","","","","","","","",},
                            {"java.lang.Integer","qtt_pars","22","false","text","qtt_pars","","","","","","",},
                            {"java.lang.String","processou","5","false","text","processou","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT rr.rem_nro       ,rr.seq_rotulo       ,rr.ped_nmro       ,i.lin_cdgo       ,i.ref_cdgo       ,i.cab_cdgo       ,i.cor_cdgo       ,qrr.qtt_nume       ,brio.fct_retorna_ean13(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, i.cor_cdgo, qrr.qtt_nume, p.cli_cdgo) produto       ,SUM(qrr.qtt_pars) qtt_pars	   ,'' processou   FROM rotulos_remessa     rr       ,qtd_rotulos_remessa qrr       ,ite                 i       ,ped                 p  WHERE 1=2     AND rr.ped_nmro = 11377300    AND rr.seq_rotulo_ped = 1    AND rr.rem_nro = qrr.rem_nro    AND rr.rotulo = qrr.rotulo    AND rr.ped_nmro = qrr.ped_nmro    AND rr.ite_seqn = qrr.ite_seqn    AND rr.ped_nmro = i.ped_nmro    AND rr.ite_seqn = i.ite_seqn    AND i.ped_nmro = p.ped_nmro  GROUP BY rr.rem_nro          ,rr.seq_rotulo          ,rr.ped_nmro          ,i.lin_cdgo          ,i.ref_cdgo          ,i.cab_cdgo          ,i.cor_cdgo          ,qrr.qtt_nume          ,brio.fct_retorna_ean13(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, i.cor_cdgo, qrr.qtt_nume, p.cli_cdgo)";
    return query;
  }

}
