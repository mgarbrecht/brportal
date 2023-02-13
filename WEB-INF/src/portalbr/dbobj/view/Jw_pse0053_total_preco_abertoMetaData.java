package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_total_preco_aberto
  * @version 22/07/2013 13:21:30
  */
public class Jw_pse0053_total_preco_abertoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","pro_numero","22","false","text","pro_numero","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"double","preco","22","false","text","preco","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT a.pro_numero               ,a.lin_cdgo               ,a.ref_cdgo               ,t.cab_cdgo               ,pck_atelier.get_preco(a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, t.cab_cdgo, a.pro_numero, a.for_codigo, a.fen_seq) preco               ,SUM(a.tal_pares) pares  FROM atelier_pre_envio a      ,talao t WHERE a.fil_filial = '8'   AND a.for_codigo = 1025984   AND a.pro_numero = 6   AND EXISTS (SELECT 1          FROM atelier_pre_envio a2              ,talao t2         WHERE a2.fil_filial = '8'           AND a2.for_codigo = 1025984           AND a2.pro_numero = 6           AND t2.rem_nro = a2.rem_nro           AND a2.lin_cdgo = a.lin_cdgo           AND a2.ref_cdgo = a.ref_cdgo           AND t2.tal_nro = a2.tal_nro           AND a2.data_pre_envio >= TO_DATE('01/01/2012', 'dd/mm/yyyy')           AND a2.data_pre_envio < TO_DATE('10/01/2012', 'dd/mm/yyyy') + 1         GROUP BY a2.pro_numero                 ,a2.lin_cdgo                 ,a2.ref_cdgo)   AND t.rem_nro = a.rem_nro   AND t.tal_nro = a.tal_nro   AND a.data_pre_envio >= TO_DATE('01/01/2012', 'dd/mm/yyyy')   AND a.data_pre_envio < TO_DATE('10/01/2012', 'dd/mm/yyyy') + 1 GROUP BY a.pro_numero         ,a.lin_cdgo         ,a.ref_cdgo         ,t.cab_cdgo         ,pck_atelier.get_preco(a.emp_empresa, a.fil_filial, pck_filial.get_unn_codigo(a.fil_filial, a.emp_empresa), a.lin_cdgo, a.ref_cdgo, t.cab_cdgo, a.pro_numero, a.for_codigo, a.fen_seq)         ORDER BY pro_numero, lin_cdgo, ref_cdgo, preco, cab_cdgo";
    return query;
  }

}
