package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cod_barra_ambos
  * @version 01/09/2021 13:41:42
  */
public class Jw_cod_barra_ambosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_marca","4","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","240","false","text","descricao_marca","","","","","","",},
                            {"java.lang.String","linha_ref","240","false","text","linha_ref","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cabedal","240","false","text","cabedal","","","","","","",},
                            {"java.lang.String","cor","240","false","text","cor","","","","","","",},
                            {"java.lang.String","numero","5","false","text","numero","","","","","","",},
                            {"java.lang.String","ean13","240","false","text","ean13","","","","","","",},
                            {"java.lang.Integer","gde_cdgo","22","false","text","gde_cdgo","","","","","","",},
                            {"java.lang.String","cod_dun14","240","false","text","cod_dun14","","","","","","",},
                            {"java.lang.Integer","qtd_pares","22","false","text","qtd_pares","","","","","","",},
                            {"java.lang.String","status","22","false","text","status","","","","","","",},
                            {"java.lang.String","sscc","240","false","text","sscc","","","","","","",},
                            {"java.lang.String","numero_externo","20","false","text","numero_externo","","","","","","",},
                            {"java.lang.String","loja","100","false","text","","","","","","","",},
                            {"java.lang.String","ref_desc","240","false","text","ref_desc","","","","","","",},
                            {"java.lang.String","imagem","100","false","text","Imagem","","","","","","",},
                            {"java.lang.Double","preco_unitario","22","false","text","preco_unitario","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+ all_rows */ mp.codigo_marca,mp.descricao_marca,fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref,ref_bar.lin_cdgo,ref_bar.ref_cdgo,ref_bar.cab_cdgo,ref_bar.cor_cdgo,cabedal.cab_desc cabedal,cor.cor_desc cor,rfb_numero numero,fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) ean13,NULL gde_cdgo,NULL cod_dun14,NULL qtd_pares,ref_status status,NULL sscc,NULL numero_externo,'' loja,ref.ref_desc,0.0 preco_unitario  FROM ref_bar      ,cabedal      ,cor      ,ref_cor      ,REF      ,marcas_produtos mp WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo   AND ref_bar.cor_cdgo = cor.cor_cdgo   AND ref_bar.lin_cdgo = ref_cor.lin_cdgo   AND ref_bar.ref_cdgo = ref_cor.ref_cdgo   AND ref_bar.cab_cdgo = ref_cor.cab_cdgo   AND ref_bar.cor_cdgo = ref_cor.cor_cdgo   AND ref_bar.lin_cdgo = ref.lin_cdgo   AND ref_bar.ref_cdgo = ref.ref_cdgo   AND ref.codigo_marca = mp.codigo_marca   AND NVL(ref_bar.ativo, NULL) IS NULL   AND var_logistica IS NULLUNIONSELECT mp.codigo_marca      ,mp.descricao_marca      ,fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref      ,ref_bar.lin_cdgo      ,ref_bar.ref_cdgo      ,ref_bar.cab_cdgo      ,ref_bar.cor_cdgo      ,cabedal.cab_desc cabedal      ,cor_desc cor      ,NULL numero      ,NULL ean13      ,ref_bar.gde_cdgo      ,TO_CHAR(codigo_barra_dum14) cod_dun14      ,qtde_pares qtd_pares      ,ref_status status      ,NULL sscc      ,NULL numero_externo	  ,'' loja	  ,ref.ref_desc	  ,0.0 preco_unitario  FROM ref_bar      ,cabedal      ,cor      ,ref_cor      ,REF      ,marcas_produtos mp WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo   AND ref_bar.cor_cdgo = cor.cor_cdgo   AND ref_bar.lin_cdgo = ref_cor.lin_cdgo   AND ref_bar.ref_cdgo = ref_cor.ref_cdgo   AND ref_bar.cab_cdgo = ref_cor.cab_cdgo   AND ref_bar.cor_cdgo = ref_cor.cor_cdgo   AND ref_bar.lin_cdgo = ref.lin_cdgo   AND ref_bar.ref_cdgo = ref.ref_cdgo   AND ref.codigo_marca = mp.codigo_marca   AND NVL(ref_bar.ativo, NULL) IS NULL   AND var_logistica IS NOT NULL   AND ref_bar.rfb_numero = '0'UNIONSELECT mp.codigo_marca      ,mp.descricao_marca      ,fct_mask_modelo(r.lin_cdgo, r.ref_cdgo) linha_ref      ,r.lin_cdgo      ,r.ref_cdgo      ,cab.cab_cdgo      ,co.cor_cdgo      ,cab.cab_desc cabedal      ,co.cor_desc cor      ,q.qtt_nume numero      ,NULL ean13      ,NULL gde_cdgo      ,NULL	  ,'' loja      ,q.qtt_pars qtd_pares      ,DECODE(ref_status, 'I', 'Inativa', 'A', 'Ativa', 'Inativa') status      ,DECODE(rr.tipo_geracao, 'P', 'P' || LPAD(rr.ped_nmro, 8, 0) ||               LPAD(rr.seq_rotulo_ped, 4, 0) ||               LPAD(rr.id_versao, 6, 0), 'R', 'R' || LPAD(rr.rem_nro, 8, 0) ||               LPAD(rr.seq_rotulo, 4, 0) ||               LPAD(rr.id_versao, 6, 0), 'E', 'E' || LPAD(rr.rem_nro, 8, 0) ||               LPAD(rr.seq_rotulo, 4, 0) ||               LPAD(rr.id_versao, 6, 0), 'A', 'A' || LPAD(rr.ped_nmro, 8, 0) ||               LPAD(rr.seq_rotulo_ped, 4, 0) ||               LPAD(rr.id_versao, 6, 0)) sscc      ,q.qtt_nume_exp numero_externo	  ,r.ref_desc	  ,0.0 preco_unitario  FROM rotulos_remessa     rr      ,ite                 i      ,REF                 r      ,cabedal             cab      ,cor                 co      ,marcas_produtos     mp      ,qtd_rotulos_remessa q WHERE rr.ped_nmro = i.ped_nmro   AND rr.ite_seqn = i.ite_seqn   AND i.lin_cdgo = r.lin_cdgo   AND i.ref_cdgo = r.ref_cdgo   AND i.cab_cdgo = cab.cab_cdgo   AND cab.cab_cdgo = i.cab_cdgo   AND co.cor_cdgo = i.cor_cdgo   AND mp.codigo_marca = r.codigo_marca   AND q.rem_nro = rr.rem_nro   AND q.rotulo = rr.rotulo   AND q.ped_nmro = rr.ped_nmro   AND q.ite_seqn = rr.ite_seqn";
    return query;
  }

}
