package portalbr.dbobj.view;

/** DataBase Object from table .Jw_arquivos_ordem_compra
  * @version 07/04/2022 14:27:43
  */
public class Jw_arquivos_ordem_compraMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","forn_codigo","22","false","text","forn_codigo","","","","","","",},
                            {"java.lang.Integer","interface_arq_compra_id","22","false","text","interface_arq_compra_id","","","","","","",},
                            {"java.lang.Integer","oco_numero","22","false","text","oco_numero","","","","","","",},
                            {"java.lang.String","fil_filial","10","false","text","fil_filial","","","","","","",},
                            {"java.sql.Timestamp","data_emissao","22","false","text","data_emissao","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","cond_pagto","100","false","text","cond_pagto","","","","","","",},
                            {"java.lang.String","arquivo_edi","240","false","text","arquivo_edi","","","","","","",},
                            {"java.lang.String","situacao","100","false","text","situacao","","","","","","",},
                            {"java.lang.String","descricao_situacao","240","false","text","descricao_situacao","","","","","","",},
                            {"java.sql.Timestamp","data_entrega","22","false","text","data_entrega","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","forn_razsoc","240","false","text","forn_razsoc","","","","","","",},
                            {"java.lang.Integer","rem_nro","22","false","text","rem_nro","","","","","","",},
                            {"java.lang.String","visualizado","20","false","text","visualizado","","","","","","",},
                            {"java.lang.String","amostra","10","false","text","amostra","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.sql.Date","data_entrega_fornecedor","11","false","text","data_entrega_fornecedor","","dd/MM/yyyy","","","","",},
                            {"java.lang.Integer","situacao_ordem_compra","22","false","text","situacao_ordem_compra","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT iac.for_codigo forn_codigo               ,iao.interface_arq_compra_id               ,iao.oco_numero               ,iao.fil_filial               ,iao.data_compra data_emissao               ,iao.cond_pagto               ,iac.nome_arquivo arquivo_edi               ,(SELECT situacao                   FROM (SELECT situacao                           FROM edi.interface_arq_compra_oc_log i                          where i.interface_arq_compra_id = iao.interface_arq_compra_id                            and i.oco_numero = iao.oco_numero                          ORDER BY DECODE(situacao, 'P', 1, 'C', 2, 'G', 3, 'V', 4) DESC)                  WHERE rownum = 1) situacao               ,DECODE(iao.situacao, 'P', 'Publicado', 'C', 'Consultado', 'G', 'Gerado', 'B', 'Baixado', 'V', 'Visualizado', '') descricao_situacao               ,MIN(iao.data_entrega) data_entrega               ,pck_fornecedor.get_nome(iac.for_codigo) forn_razsoc               ,iao.rem_nro               ,CASE                  WHEN NVL(iao.situacao, 'XXX') <> 'V' THEN                   'N'                  ELSE                   'S'                END visualizado    , case when substr(r.lote, length(r.lote), 1) = 'A' then 'S' else 'N' end amostra	, r.lin_cdgo	, iao.data_entrega_fornecedor	, doc.situacao situacao_ordem_compra  FROM interface_arq_compra_oc iao      ,interface_arq_compra    iac      ,dom_ordem_compra doc      ,remessa r WHERE iac.interface_arq_compra_id = iao.interface_arq_compra_id   AND NVL(iac.ativo, NULL) = 'S'   AND NVL(iac.tipo, NULL) = 'O'   and doc.numero = iao.oco_numero   and r.rem_nro (+) = iao.rem_nro   and nvl(doc.situacao,null) <> 9 GROUP BY iac.for_codigo         ,iao.interface_arq_compra_id         ,iao.oco_numero         ,iao.fil_filial         ,iao.data_compra         ,iao.cond_pagto         ,iac.nome_arquivo         ,iao.situacao         ,iao.rem_nro         ,r.lote		 ,r.lin_cdgo		 ,iao.data_entrega_fornecedor		 ,doc.situacao ORDER BY data_entrega";
    return query;
  }

}
