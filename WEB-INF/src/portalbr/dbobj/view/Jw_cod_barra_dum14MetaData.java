package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cod_barra_dum14
  * @version 01/09/2021 14:53:15
  */
public class Jw_cod_barra_dum14MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","linha_ref","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cod_linha","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cod_refer","22","false","text","","","","","","","",},
                            {"java.lang.String","cabedal","78","false","text","","","","","","","",},
                            {"java.lang.String","cor","73","false","text","","","","","","","",},
                            {"java.lang.String","gde_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.Integer","qtd_pares","22","false","text","","","","","","","",},
                            {"java.lang.String","cod_dum14","40","false","text","","","","","","","",},
                            {"java.lang.String","status","1","false","text","","","","","","","",},
                            {"int","cab_cdgo","22","false","text","","","","","","","",},
                            {"int","cor_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.Integer","numero_fatura_proforma","10","false","text","Numero_fatura_proforma","","","","","","",},
                            {"java.lang.Integer","ano_fatura_proforma","10","false","text","","","","","","","",},
                            {"java.lang.String","loja","100","false","text","","","","","","","",},
                            {"java.lang.String","ref_desc","240","false","text","ref_desc","","","","","","",},
                            {"java.lang.String","imagem","100","false","text","Imagem","","","","","","",},
                            {"java.lang.Double","preco_unitario","22","false","text","Preco_unitario","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref      ,ref_bar.lin_cdgo cod_linha      ,ref_bar.ref_cdgo cod_refer      ,cabedal.cab_desc cabedal      ,cor_desc cor      ,ref_bar.gde_cdgo      ,qtde_pares qtd_pares      ,TO_CHAR(codigo_barra_dum14) cod_dum14      ,ref_status status      ,ref_bar.cab_cdgo      ,ref_bar.cor_cdgo      ,-1 numero_fatura_proforma      ,-1 ano_fatura_proforma	  ,'' loja	  ,ref.ref_desc	  ,0.0 preco_unitario  FROM ref_bar      ,cabedal      ,cor      ,ref_cor      ,REF WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo   AND ref_bar.cor_cdgo = cor.cor_cdgo   AND ref_bar.lin_cdgo = ref_cor.lin_cdgo   AND ref_bar.ref_cdgo = ref_cor.ref_cdgo   AND ref_bar.cab_cdgo = ref_cor.cab_cdgo   AND ref_bar.cor_cdgo = ref_cor.cor_cdgo   AND ref_bar.lin_cdgo = ref.lin_cdgo   AND ref_bar.ref_cdgo = ref.ref_cdgo   AND NVL(ref_bar.ativo, NULL) IS NULL   AND var_logistica IS NOT NULL   AND ref_bar.rfb_numero = 0UNIONSELECT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref      ,ref_bar.lin_cdgo cod_linha      ,ref_bar.ref_cdgo cod_refer      ,cabedal.cab_desc cabedal      ,cor_desc cor      ,ref_bar.gde_cdgo      ,qtde_pares qtd_pares      ,TO_CHAR(codigo_barra_dum14) cod_dum14      ,ref_status status      ,ref_bar.cab_cdgo      ,ref_bar.cor_cdgo      ,i.numero_fatura_proforma      ,i.ano_fatura_proforma	  ,'' loja	  ,ref.ref_desc	  ,0.0 preco_unitario  FROM ref_bar      ,cabedal      ,cor      ,itens_faturas_proformas i      ,ref_cor      ,REF WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo   AND ref_bar.cor_cdgo = cor.cor_cdgo   AND ref_bar.lin_cdgo = ref_cor.lin_cdgo   AND ref_bar.ref_cdgo = ref_cor.ref_cdgo   AND ref_bar.cab_cdgo = ref_cor.cab_cdgo   AND ref_bar.cor_cdgo = ref_cor.cor_cdgo   AND ref_bar.lin_cdgo = ref.lin_cdgo   AND ref_bar.ref_cdgo = ref.ref_cdgo   AND i.empresa_fatura_proforma = '01'   AND i.codigo_linha = ref_bar.lin_cdgo   AND i.codigo_referencia = ref_bar.ref_cdgo   AND i.codigo_cabedal = ref_bar.cab_cdgo   AND i.codigo_cor = ref_bar.cor_cdgo   AND NVL(ref_bar.ativo, NULL) IS NULL   AND var_logistica IS NOT NULL   AND ref_bar.rfb_numero = 0";
    return query;
  }

}
