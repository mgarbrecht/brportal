package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_nota_titulo
  * @version 27/05/2019 11:55:29
  */
public class Jw_t_nota_tituloMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","nota","22","false","text","nota","","","","","","",},
                            {"java.lang.String","serie","3","false","text","serie","","","","","","",},
                            {"java.lang.String","filial","4","false","text","filial","","","","","","",},
                            {"java.lang.String","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","pedido","22","false","text","pedido","","","","","","",},
                            {"java.lang.String","esc_cgc","40","false","text","esc_cgc","","","","","","",},
                            {"java.lang.String","cli_rzao","240","false","text","cli_rzao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select nf.nsa_numero nota, nf.nsa_serie serie, nf.fil_filial filial, nfs.ped_nmro, p.ped_nmro pedido, null esc_cgc, null cli_rzao from tit_nf nf, notas_fiscais_saida_ped_venda nfs, ped p where nf.emp_empresa=nfs.emp_empresa AND nf.fil_filial=nfs.fil_filial AND nfs.nfs_nmro=nf.nsa_numero AND nfs.nfs_serie=nf.nsa_serie AND nf.emp_empresa='01' and nf.fil_filial='MT' and nf.tip_codigo='DUP' and nf.tit_codigo='1M33577A'  AND p.ped_nmro(+)=nfs.ped_nmro";
    return query;
  }

}
