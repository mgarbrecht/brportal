package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_devolucoes
  * @version 03/04/2013 09:30:08
  */
public class Jw_ficha_cliente_devolucoesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ordem","22","false","text","ordem","","","","","","",},
                            {"java.sql.Timestamp","data_cad","22","false","text","data_cad","","dd/MM/yyyy","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","text","nfs_nmro","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.lang.Double","valor","22","false","text","valor","","##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ROWNUM ordem       ,data_cad       ,nfs_nmro       ,pares       ,valor   FROM (SELECT dm.data_cad               ,ns.nfs_nmro               ,SUM(idv.total_pares) pares               ,SUM(idv.valor_total) valor           FROM devolucoes_mercadorias dm               ,itens_devolucoes idv               ,nf_item ni               ,nf_saida ns          WHERE dm.data_cad >= TRUNC(SYSDATE, 'mm')            AND dm.data_cad <= TRUNC(LAST_DAY(SYSDATE))            AND ns.emp_empresa = ni.emp_empresa            AND ns.fil_filial = ni.fil_filial            AND ns.nfs_nmro = ni.nfs_nmro            AND ns.nfs_serie = ni.nfs_serie            AND ni.emp_empresa = dm.nfs_emp_empresa            AND ni.fil_filial = dm.nfs_fil_filial            AND ni.nfs_nmro = dm.nfs_numero            AND ni.nfs_serie = dm.nfs_serie            AND ni.nfi_seqitem = idv.nfi_seqitem            AND dm.codigo = idv.devmerc_codigo            AND ((dm.motdev_codigo <> 85) AND (dm.motdev_codigo <> 54 AND dm.sitdev_codigo <> 2))            AND NOT EXISTS (SELECT *                   FROM nf_refat_dev nrd                  WHERE nrd.emp_empresa = dm.nfs_emp_empresa                    AND nrd.fil_filial = dm.nfs_fil_filial                    AND nrd.nfs_nmro = dm.nfs_numero                    AND nrd.nfs_serie = dm.nfs_serie                    AND CASE                          WHEN nrd.tipo_refaturamento = pck_nf_refat_dev.get_refaturamento AND                               nrd.cli_cdgo <> dm.cli_cdgo THEN                           0                          ELSE                           1                        END = 1                    AND nrd.estagio <> pck_nf_refat_dev.get_estagio_cancelado)            AND NOT EXISTS (SELECT *                   FROM ite ite                       ,ped ped                  WHERE ite.emp_empresa_refat = dm.nfs_emp_empresa                    AND ite.fil_filial_refat = dm.nfs_fil_filial                    AND ite.nfs_nmro_refat = dm.nfs_numero                    AND ite.nfs_serie_refat = dm.nfs_serie                    AND ite.ped_nmro = ped.ped_nmro                    AND CASE                          WHEN ped.cli_cdgo <> dm.cli_cdgo THEN                           0                          ELSE                           1                        END = 1                    AND ped.ped_stat <> 'C'                 )          GROUP BY dm.data_cad                  ,ns.nfs_nmro          ORDER BY dm.data_cad DESC)  WHERE ROWNUM <= 10";
    return query;
  }

}
