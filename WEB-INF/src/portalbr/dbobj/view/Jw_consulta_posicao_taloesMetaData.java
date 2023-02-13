package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_posicao_taloes
  * @version 03/09/2018 12:09:48
  */
public class Jw_consulta_posicao_taloesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","remessa","22","false","text","remessa","","","","","","",},
                            {"java.lang.Integer","talao","22","false","text","talao","","","","","","",},
                            {"java.lang.Integer","forn_codigo","22","false","text","forn_codigo","","","","","","",},
                            {"java.lang.String","fornecedor","240","false","text","fornecedor","","","","","","",},
                            {"java.lang.Integer","processo","22","false","text","processo","","","","","","",},
                            {"java.lang.String","status","100","false","text","status","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.sql.Timestamp","dt_envio","22","false","text","dt_envio","","","","","","",},
                            {"java.sql.Timestamp","dt_retorno","22","false","text","dt_retorno","","","","","","",},
                            {"java.lang.Integer","oc","22","false","text","oc","","","","","","",},
                            {"java.lang.String","situacao_oc","240","false","text","situacao_oc","","","","","","",},
                            {"java.lang.String","atualiza_controle_producao","10","false","text","atualiza_controle_producao","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","fil_filial","240","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","nota_fiscal","80","false","text","nota_fiscal","","","","","","",},
                            {"java.lang.Integer","fen_seq","22","false","text","fen_seq","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT r.AROC_Rem_Nro remessa       ,r.Tal_Nro talao       ,r.For_Codigo forn_codigo       ,TO_CHAR(r.For_Codigo) || '' - '' || f.For_RazSoc fornecedor       ,r.Pro_Numero processo       ,r.Status       ,DECODE(r.Tal_Tipo_Talao, NULL, t.Tal_Pares, c.Tal_Pares) pares       ,r.Data_Envio dt_envio       ,r.Data_Recebimento dt_retorno       ,r.AROC_OCO_Numero oc       ,s.Rv_Meaning situacao_oc       ,r.atualiza_controle_producao       ,m.lin_cdgo       ,t.ref_cdgo       ,t.cab_cdgo       ,t.cor_cdgo       ,o.fil_filial	          ,(SELECT DISTINCT inf.numero_nota_fiscal || '/' || inf.serie_nota_fiscal nota_fiscal          FROM atelier_rem_tal_interface_nf artin              ,interface_item_nota_fiscal   iinf              ,interface_nota_fiscal        inf         WHERE artin.rem_nro = r.AROC_Rem_Nro           AND artin.tal_nro = r.Tal_Nro           AND iinf.oco_numero = r.AROC_OCO_Numero           AND iinf.id_nota_fiscal = artin.id_nota_fiscal           AND inf.id_nota_fiscal = iinf.id_nota_fiscal           AND NVL(inf.integrar_rdo, NULL) = 'S') nota_fiscal	          ,o.fen_seq  		      FROM Talao_Celula          c       ,Talao                 t       ,Remessa               m       ,Lotes                 l       ,Fornecedor            f       ,Compras_Ref_Codes     s       ,Dom_Ordem_Compra      o       ,Atelier_Rem_Taloes_OC r  WHERE t.Rem_Nro(+) = r.AROC_Rem_Nro    AND t.Tal_Nro(+) = r.Tal_Nro    AND c.Rem_Nro(+) = r.AROC_Rem_Nro    AND c.Tal_Nro(+) = r.Tal_Nro    AND l.Lote_Nro(+) = r.AROC_Rem_Nro    AND m.Rem_Nro(+) = r.AROC_Rem_Nro    AND f.For_Codigo = r.For_Codigo    AND s.rv_Low_Value = o.Situacao    AND s.rv_Domain = 'DMN_SITUACAO'    AND o.Numero = r.AROC_OCO_Numero";
    return query;
  }

}
