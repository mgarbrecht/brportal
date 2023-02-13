package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_notas_fiscais
  * @version 13/12/2017 16:23:51
  */
public class Jw_consulta_notas_fiscaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","nota","46","false","text","Número","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","Empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","Filial","","","","","","",},
                            {"java.lang.String","cc","78","false","text","Cliente","","","","","","",},
                            {"java.lang.String","ecl_cdad","63","false","text","Cidade","","","","","","",},
                            {"java.lang.String","est_unifed","63","false","text","UF","","","","","","",},
                            {"java.lang.String","linha","40","false","text","Linha","","","","","","",},
                            {"java.lang.Integer","linha_cdgo","40","false","text","Linha Código","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","40","false","text","Referência Código","","","","","","",},
                            {"java.sql.Timestamp","nfs_dtemis","12","false","text","Emissão","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","hidden","nfs_nmro","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"java.lang.Double","nfs_valicm","26","false","text","nfs_valicm","","","","","","",},
                            {"java.lang.Integer","nfs_qtdvol","22","false","text","nfs_qtdvol","","","","","","",},
                            {"java.lang.Integer","qtde_de_notas","20","false","text","Nro de Notas","","","","","","",},
                            {"java.lang.Double","nfs_vltot","26","false","text","nfs_vltot","","","","","","",},
                            {"java.lang.String","sigla_trans","4","false","text","Sigla da Transportadora","","","","","","",},
                            {"java.lang.String","nro_romaneio_embarque","22","false","text","Romaneio","","","","","","",},
                            {"java.sql.Timestamp","finalizacao_romaneio","12","false","text","Finalização Romaneio","","","","","","",},
                            {"java.lang.String","conhecimentos","50","false","text","conhecimentos","","","","","","",},
                            {"double","nfs_total_pares","50","false","text","nfs_total_pares","","","","","","",},
                            {"java.lang.String","placa_veiculo","20","false","text","placa_veiculo","","","","","","",},
                            {"double","cubagem","22","false","text","cubagem","","","","","","",},
                            {"java.lang.String","cons","200","false","text","cons","","","","","","",},
                            {"java.lang.String","ocorrencia","400","false","text","cons","","","","","","",},
                            {"java.lang.String","ped_nmro","2000","false","hidden","ped_nmro","","","","","","",},
                            {"java.lang.String","chave_nfe","100","false","text","Chave_nfe","","","","","","",},
                            {"java.lang.Double","taxa_dolar","26","false","text","taxa_dolar","","","","","","",},
                            {"java.lang.Double","nfs_pesbru","26","false","text","nfs_pesbru","","","","","","",},
                            {"java.lang.Double","nfs_pesliq","26","false","text","nfs_pesliq","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","40","false","text","Cab_cdgo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","40","false","text","Cor_cdgo","","","","","","",},
                            {"java.lang.String","tamanho","40","false","text","Tamanho","","","","","","",},
                            {"java.lang.Integer","id","40","false","text","Id","","","","","","",},
                            {"java.lang.String","nfi_descricao","400","false","text","Nfi_descricao","","","","","","",},
                            {"java.lang.String","ncm","40","false","text","Ncm","","","","","","",},
                            {"double","total_pares","50","false","text","total_pares","","","","","","",},
                            {"double","nfi_vlunit","50","false","text","nfi_vlunit","","","","","","",},
                            {"java.lang.String","fil_cgc","46","false","text","fil_cgc","","","","","","",},
                            {"java.lang.Integer","tra_cdgo","40","false","text","tra_cdgo","","","","","","",},
                            {"java.lang.String","fil_prod","4","false","text","Filial Prod.","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT '' nota               ,'' emp_empresa               ,'' fil_filial               ,'' cc               ,'' ecl_cdad               ,'' est_unifed               ,'' linha               ,0 linha_cdgo               ,SYSDATE nfs_dtemis               ,0 nfs_nmro               ,'' nfs_serie               ,0 nfs_valicm               ,0 nfs_qtdvol               ,0 qtde_de_notas               ,0 nfs_vltot               ,'' sigla_trans               ,'' nro_romaneio_embarque               ,SYSDATE finalizacao_romaneio               ,'' conhecimentos               ,'' placa_veiculo               ,0 cubagem               ,'' cons			   ,'' ocorrencia			   ,'' chave_nfe			   ,0.0 taxa_dolar			   ,0.0 nfs_pesbru			   ,0.0 nfs_pesliq			   ,'' fil_cgc			   ,null tra_cdgo			   ,'' fil_prod  FROM dual";
    return query;
  }

}
