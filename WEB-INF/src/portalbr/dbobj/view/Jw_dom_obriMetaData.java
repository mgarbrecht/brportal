package portalbr.dbobj.view;

/** DataBase Object from table .Jw_dom_obri
  * @version 23/07/2018 15:39:01
  */
public class Jw_dom_obriMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","OBRIGACAO","10","false","text","","","","","","","",},
                            {"java.lang.String","FORNECEDOR","9","false","text","","","","","","","",},
                            {"java.lang.String","SEQUENCIA","3","false","text","","","","","","","",},
                            {"double","PAGO_SEM_DESC","22","false","text","","","","","","","",},
                            {"int","NOTA","22","false","text","","","","","","","",},
                            {"java.lang.String","CNPJ","60","false","text","","","","","","","",},
                            {"java.sql.Date","DATA_VENCIMENTO","22","false","text","","","","","","","",},
                            {"java.sql.Date","DATA_PAGAMENTO","22","false","text","","","","","","","",},
                            {"java.lang.String","STATUS","2","false","text","","","","","","","",},
                            {"java.lang.String","FIL_RAZSOC","30","false","text","","","","","","","",},
                            {"double","VALOR_OBRIGACAO","22","false","text","","","","","","","",},
                            {"java.sql.Date","DATA_EMISSAO","22","false","text","","","","","","","",},
                            {"double","SALDO_PAGAR","22","false","text","","","","","","","",},
                            {"java.lang.String","TIPO","4","false","text","","","","","","","",},
                            {"java.lang.String","fil_cnpj","60","false","text","","","","","","","",},
                            {"java.lang.String","cd_tipo","60","false","text","cd_tipo","","","","","","",},
                            {"int","qtd","22","false","text","qtd","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */       dom.nm_obri obrigacao      ,dom.cd_enti fornecedor      ,dom.codi_tipo_ender sequencia      ,fct_cpg_saldo_obri_for_portal(dom.nm_obri, dom.cd_enti, dom.cd_tipo, dom.codi_tipo_ender) pago_sem_desc      ,dom.cd_docto nota      ,CASE         WHEN fore.fen_cgc IS NULL THEN          ''         ELSE          fct_formata_cnpj(fore.fen_cgc)       END cnpj      ,dom.dt_vcto data_vencimento      ,dom.dt_pgto data_pagamento      ,dom.cd_situ status      ,pck_filial.get_nome(dom.fil_filial) fil_razsoc      ,dom.vl_obri valor_obrigacao      ,dom.dt_emis data_emissao      ,fct_cpg_saldo_obrigacao_new(dom.nm_obri, dom.cd_enti, dom.cd_tipo, dom.codi_tipo_ender) saldo_pagar      ,dom.cd_tiob tipo      ,CASE         WHEN pck_filial.get_cnpj(dom.fil_filial) IS NULL THEN          ''         ELSE          fct_formata_cnpj(pck_filial.get_cnpj(dom.fil_filial))       END fil_cnpj      ,dom.cd_tipo      ,COUNT(dmo.nm_obri) qtd  FROM dom_obrigacao dom      ,for_endere fore      ,(SELECT dmo.nm_obri              ,dmo.cd_tipo              ,dmo.codi_tipo_ender              ,dmo.cd_enti          FROM dom_movto_obrigacao dmo              ,eventos_Grupo       eg         WHERE eg.cd_tran = dmo.cd_tran           AND eg.codigo_grupo_evento = 4) dmo WHERE fore.for_codigo = dom.cd_enti   AND fore.fen_seq = dom.codi_tipo_ender   AND dom.cd_tiob <> 'AGR'   AND dmo.nm_obri(+) = dom.nm_obri   AND dmo.cd_enti(+) = dom.cd_enti   AND dmo.codi_tipo_ender(+) = dom.codi_tipo_ender   AND dmo.cd_tipo(+) = dom.cd_tipo GROUP BY dom.nm_obri         ,dom.cd_enti         ,dom.codi_tipo_ender         ,dom.cd_tipo         ,dom.cd_docto         ,fore.fen_cgc         ,dom.dt_vcto         ,dom.dt_pgto         ,dom.cd_situ         ,dom.fil_filial         ,dom.vl_obri         ,dom.dt_emis         ,dom.cd_tiob ORDER BY dom.dt_pgto";
    return query;
  }

}
