package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cod_barra
  * @version 16/08/2022 11:16:14
  */
public class Jw_cod_barraMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","linha_ref","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cod_linha","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cod_refer","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.String","cabedal","78","false","text","","","","","","","",},
                            {"java.lang.String","cor","73","false","text","","","","","","","",},
                            {"java.lang.String","grade","5","false","text","","","","","","","",},
                            {"java.lang.String","cod_barra","52","false","text","","","","","","","",},
                            {"java.lang.String","status","1","false","text","","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","200","false","text","descricao_marca","","","","","","",},
                            {"java.lang.String","cor_desc","200","false","text","cor_desc","","","","","","",},
                            {"java.lang.String","cab_desc","200","false","text","cab_desc","","","","","","",},
                            {"java.lang.String","grade_ext","5","false","text","","","","","","","",},
                            {"java.lang.String","loja","100","false","text","","","","","","","",},
                            {"java.lang.String","ref_desc","240","false","text","ref_desc","","","","","","",},
                            {"java.lang.String","imagem","100","false","text","Imagem","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","Pares","","","","","","",},
                            {"java.lang.Double","preco_unitario","22","false","text","Preco_unitario","","","","","","",},
                            {"java.lang.Integer","pares_ean13","22","false","text","Pares_ean13","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref      ,ref_bar.lin_cdgo cod_linha      ,ref_bar.ref_cdgo cod_refer      ,ref_bar.cab_cdgo      ,ref_bar.cor_cdgo      ,cabedal.cab_cdgo || ' - ' || cabedal.cab_desc cabedal      ,cor.cor_cdgo || ' - ' || cor_desc cor      ,rfb_numero grade      ,fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) cod_barra      ,ref_status status      ,mp.codigo_marca      ,mp.descricao_marca      ,cor.cor_desc      ,cabedal.cab_desc	  ,'' grade_ext	  ,'' loja	  ,ref.ref_desc	  ,0 pares	  ,0.0 preco_unitario	  ,0 pares_ean13  FROM ref_bar      ,cabedal      ,cor      ,ref_cor      ,REF      ,marcas_produtos mp WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo   AND ref_bar.cor_cdgo = cor.cor_cdgo   AND ref_bar.lin_cdgo = ref_cor.lin_cdgo   AND ref_bar.ref_cdgo = ref_cor.ref_cdgo   AND ref_bar.cab_cdgo = ref_cor.cab_cdgo   AND ref_bar.cor_cdgo = ref_cor.cor_cdgo   AND ref_bar.lin_cdgo = ref.lin_cdgo   AND ref_bar.ref_cdgo = ref.ref_cdgo   AND ref.codigo_marca = mp.codigo_marca   AND NVL(ref_bar.ativo, NULL) IS NULL   AND var_logistica IS NULL";
    return query;
  }

}
