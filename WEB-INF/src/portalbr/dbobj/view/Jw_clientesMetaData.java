package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes
  * @version 05/10/2021 14:50:24
  */
public class Jw_clientesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","qt_contatos","10","false","text","qt_contatos","","","","","","",},
                            {"java.lang.String","qt_telefones","10","false","text","qt_telefones","","","","","","",},
                            {"java.lang.String","codigo","81","false","text","codigo","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","endereco","81","false","text","endereco","","","","","","",},
                            {"java.lang.String","fone","10","false","text","fone","","","","","","",},
                            {"java.lang.String","uf","63","false","text","uf","","","","","","",},
                            {"java.lang.String","bairro","30","false","text","bairro","","","","","","",},
                            {"java.lang.String","cnpj","18","false","text","cnpj","","","","","","",},
                            {"java.lang.String","inscr","18","false","text","inscr","","","","","","",},
                            {"java.lang.String","cep","9","false","text","cep","","","","","","",},
                            {"double","credito","24","false","text","credito","","R$##,##0.00","","","","",},
                            {"java.lang.String","email","100","false","text","email","","","","","","",},
                            {"java.lang.String","situacao","7","false","text","situacao","","","","","","",},
                            {"java.lang.String","segmento","30","false","text","segmento","","","","","","",},
                            {"java.lang.String","grupo","30","false","text","grupo","","","","","","",},
                            {"java.lang.String","contatos","10","false","text","contatos","","","","","","",},
                            {"java.lang.String","fones","10","false","text","fones","","","","","","",},
                            {"java.lang.String","ned_cdgo","3","false","text","ned_cdgo","","","","","","",},
                            {"java.lang.String","ecl_cdad","60","false","text","ecl_cdad","","","","","","",},
                            {"double","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"double","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","classificacao","3","false","text","classificacao","","","","","","",},
                            {"java.lang.String","representantes","4000","false","text","representantes","","","","","","",},
                            {"java.lang.String","ecl_cxpo","20","false","text","ecl_cxpo","","","","","","",},
                            {"java.lang.String","ecl_zona","20","false","text","ecl_zona","","","","","","",},
                            {"java.lang.Integer","tra_consig","20","false","text","tra_consig","","","","","","",},
                            {"java.lang.String","consignatario","100","false","text","consignatario","","","","","","",},
                            {"java.lang.Integer","tra_cdgo","20","false","text","tra_cdgo","","","","","","",},
                            {"java.lang.String","tra_nome","100","false","text","tra_nome","","","","","","",},
                            {"double","pendencia","24","false","text","pendencia","","R$##,##0.00","","","","",},
                            {"double","saldo_disponivel","24","false","text","saldo_disponivel","","R$##,##0.00","","","","",},
                            {"java.lang.String","data_ultima_compra","20","false","text","data_ultima_compra","","","","","","",},
                            {"double","valor_ultima_compra","24","false","text","valor_ultima_compra","","R$##,##0.00","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' qt_contatos      ,'' qt_telefones      ,c.cli_cdgo || '-' || esc.esc_seqn codigo      ,c.cli_rzao      ,c.cli_nome      ,(l.ecl_nome || ', ' || l.ecl_nmro || ' ' || l.ecl_cpto) endereco      ,'' fone      ,l.ecl_cdad || '-' || l.est_unifed uf      ,l.ecl_bair bairro      ,SUBSTR(LTRIM(TO_CHAR(esc.esc_cgc, '00000000000000')), 1, 2) || '.' || SUBSTR(LTRIM(TO_CHAR(esc.esc_cgc, '00000000000000')), 3, 3) || '.' || SUBSTR(LTRIM(TO_CHAR(esc.esc_cgc, '00000000000000')), 6, 3) || '/' || SUBSTR(LTRIM(TO_CHAR(esc.esc_cgc, '00000000000000')), 9, 4) || '-' || SUBSTR(LTRIM(TO_CHAR(esc.esc_cgc, '00000000000000')), 13, 2) cnpj      ,esc.esc_inse inscr      ,SUBSTR(l.ecl_cep, 1, 5) || '-' || SUBSTR(l.ecl_cep, 6, 8) cep      ,c.cli_valor_credito_analista credito      ,esc.esc_email email      ,DECODE(c.cli_situ, 'A', 'Ativo', 'I', 'Inativo') situacao      ,s.seg_desc segmento      ,gre.gre_descricao grupo      ,'' contatos      ,'' fones      ,l.ned_cdgo      ,l.ecl_cdad      ,c.cli_cdgo      ,esc.esc_seqn      ,DECODE(NVL(p.classificacao, '@'), 'C', 'SIM', 'NÃO') classificacao      ,'' representantes	  ,0 pendencia	  ,0 saldo_disponivel	  ,null data_ultima_compra	  ,null valor_ultima_compra  FROM cliente_representante r      ,ecl l      ,esc      ,cli c      ,seg s      ,parametros_cobranca_cliente p      ,grupo_economico gre WHERE s.seg_cdgo = c.seg_cdgo   AND r.codigo_cliente = c.cli_cdgo   AND r.codigo_cliente = l.cli_cdgo   AND r.codigo_sequencial = l.esc_seqn   AND l.cli_cdgo = p.cli_cdgo   AND l.esc_seqn = p.esc_seqn   AND NVL(p.classificacao, '@') = DECODE('T', 'V', 'C', 'N', '@', NVL(p.classificacao, '@'))   AND (l.ned_cdgo = 'UNI' OR l.ned_cdgo = 'ENT')   AND l.esc_seqn = esc.esc_seqn   AND c.cli_cdgo = esc.cli_cdgo   AND gre.cli_cdgo(+) = c.cli_cdgo   AND gre.status = 'A'";
    return query;
  }

}
