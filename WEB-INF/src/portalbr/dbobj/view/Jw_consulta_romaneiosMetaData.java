package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_romaneios
  * @version 22/10/2015 14:28:54
  */
public class Jw_consulta_romaneiosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"double","nro_romaneio_embarque","22","false","text","","","","","","","",},
                            {"double","nfs_nmro","22","false","text","","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","","","","","","","",},
                            {"java.sql.Date","nfs_dtemis","12","false","text","","","","","","","",},
                            {"double","nfs_vltot","26","false","text","","","##,##0.00","","","","",},
                            {"java.lang.String","fil_filial","10","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","cliente","200","false","text","cliente","","","","","","",},
                            {"java.lang.String","cidade","100","false","text","cidade","","","","","","",},
                            {"java.lang.String","uf","20","false","text","uf","","","","","","",},
                            {"java.lang.Integer","nfs_qtdvol","20","false","text","nfs_qtdvol","","","","","","",},
                            {"java.lang.Integer","nfs_total_pares","20","false","text","nfs_total_pares","","","","","","",},
                            {"java.lang.String","conhecimentos","200","false","text","conhecimentos","","","","","","",},
                            {"java.lang.String","ped_nmro","2000","false","text","ped_nmro","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT n.nro_romaneio_embarque      ,n.nfs_nmro      ,n.nfs_serie      ,n.nfs_dtemis      ,n.nfs_vltot      ,n.fil_filial      ,n.cli_cdgo || ' - ' || cliente.cli_rzao cliente      ,cliente.ecl_cdad cidade      ,cliente.est_unifed uf      ,NVL(n.nfs_qtdvol, 0) nfs_qtdvol      ,(SELECT SUM(nfi_qtde) FROM nf_item i where i.nfs_nmro = n.nfs_nmro AND i.nfs_serie = n.nfs_serie AND i.emp_empresa = n.emp_empresa and i.fil_filial = n.fil_filial) nfs_total_pares	        ,NVL((SELECT NVL(cf.numero, 0) || '#' || NVL(cf.peso, 0) || '#' || NVL(cf.valor_frete, 0)             FROM conhecimentos_fretes cf                 ,nf_saida_conhecimentos_fretes s            WHERE s.confrt_numero = cf.numero              AND s.confrt_fen_for_codigo = cf.fen_for_codigo              AND s.confrt_fen_seq = cf.fen_seq              AND s.confrt_data_cad = cf.data_cad              AND cf.peso IS NOT NULL              AND s.nfs_nmro = n.nfs_nmro              AND s.nfs_serie = n.nfs_serie              AND s.nfs_fil_filial = n.fil_filial              AND ROWNUM = 1), '-' || '#' || NVL(n.nfs_pesbru, 0) || '#' || NVL(n.nfs_frete_faturamento, 0)) conhecimentos      ,v.ped_nmro  FROM nf_saida n      ,(SELECT a.cli_cdgo cli_cdgo_cliente              ,a.cli_rzao              ,c.est_unifed              ,ecl_cdad              ,b.esc_seqn              ,b.cli_cdgo          FROM cli a              ,esc b              ,ecl c         WHERE b.esc_seqn = c.esc_seqn           AND a.cli_cdgo = b.cli_cdgo           AND b.cli_cdgo = c.cli_cdgo           AND (c.ned_cdgo = 'UNI' OR c.ned_cdgo = 'ENT')) cliente      ,municipios m      ,notas_fiscais_saida_ped_venda v WHERE cliente.cli_cdgo_cliente = n.cli_cdgo   AND cliente.esc_seqn = n.esc_seqn   AND cliente.ecl_cdad = m.descricao(+)   AND cliente.est_unifed = m.est_unifed(+)   AND v.nfs_nmro(+) = n.nfs_nmro   AND v.nfs_serie(+) = n.nfs_serie   AND v.fil_filial(+) = n.fil_filial   AND v.emp_empresa(+) = n.emp_empresa";
    return query;
  }

}
