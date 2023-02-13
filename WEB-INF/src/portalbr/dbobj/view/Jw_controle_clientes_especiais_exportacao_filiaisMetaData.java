package portalbr.dbobj.view;

/** DataBase Object from table .Jw_controle_clientes_especiais_exportacao_filiais
  * @version 11/02/2016 08:54:02
  */
public class Jw_controle_clientes_especiais_exportacao_filiaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","filial","10","false","text","filial","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT fct_retorna_fil_producao(p.ped_nmro, 1) filial   FROM faturas_proformas       fp       ,itens_faturas_proformas ifp       ,ite                     i       ,ped                     p       ,cli                     c       ,esc                     e  WHERE fp.empresa_fatura_proforma = i.empresa_fatura_proforma    AND fp.ano_fatura_proforma = i.ano_fatura_proforma    AND fp.numero_fatura_proforma = i.numero_fatura_proforma    AND fp.empresa_fatura_proforma = ifp.empresa_fatura_proforma    AND fp.ano_fatura_proforma = ifp.ano_fatura_proforma    AND fp.numero_fatura_proforma = ifp.numero_fatura_proforma    AND c.cli_cdgo = fp.codigo_cliente    AND e.cli_cdgo = fp.codigo_cliente    AND e.esc_seqn = fp.estabelecimento_cliente    AND p.ped_nmro = i.ped_nmro    AND i.numero_item_fatura_proforma = ifp.numero_item    AND p.ped_nmro IN (12487767, 12487768)  GROUP BY fp.data_entrega          ,fp.numero_fatura_proforma          ,fp.codigo_cliente          ,fp.estabelecimento_cliente          ,c.cli_rzao          ,e.est_unifed          ,fct_retorna_fil_producao(p.ped_nmro, 1)          ,i.fil_filial_producao          ,i.ite_seqn  ORDER BY TO_NUMBER(DECODE(filial, 'MT', 1, 3, 3, 6, 6, 8, 8, 9, 9, 10, 10, 12, 12, 15, 15, 16, 16, 18, 18, 17, 17, 29, 29, 30, 30, 20, 20, 0))";
    return query;
  }

}
