package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cod_barra_sscc
  * @version 02/10/2018 12:07:11
  */
public class Jw_cod_barra_ssccMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","240","false","text","descricao_marca","","","","","","",},
                            {"java.lang.String","linha_ref","240","false","text","linha_ref","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.Integer","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","240","false","text","cab_desc","","","","","","",},
                            {"java.lang.String","cor_desc","240","false","text","cor_desc","","","","","","",},
                            {"java.lang.String","numero","20","false","text","numero","","","","","","",},
                            {"java.lang.String","numero_externo","20","false","text","numero_externo","","","","","","",},
                            {"java.lang.Integer","qtd_pares","22","false","text","qtd_pares","","","","","","",},
                            {"java.lang.String","sscc","240","false","text","sscc","","","","","","",},
                            {"java.lang.String","status","240","false","text","status","","","","","","",},
                            {"java.lang.String","loja","100","false","text","","","","","","","",},
                            {"java.lang.String","ref_desc","240","false","text","ref_desc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT mp.codigo_marca       ,mp.descricao_marca       ,fct_mask_modelo(r.lin_cdgo, r.ref_cdgo) linha_ref       ,r.lin_cdgo       ,r.ref_cdgo       ,cab.cab_cdgo       ,co.cor_cdgo       ,cab.cab_desc        ,co.cor_desc        ,q.qtt_nume numero       ,q.qtt_nume_exp numero_externo	   ,'' loja       ,q.qtt_pars qtd_pares       ,DECODE(rr.tipo_geracao, 'P', 'P' || LPAD(rr.ped_nmro, 8, 0) ||                LPAD(rr.seq_rotulo_ped, 4, 0) ||                LPAD(rr.id_versao, 6, 0), 'R', 'R' || LPAD(rr.rem_nro, 8, 0) ||                LPAD(rr.seq_rotulo, 4, 0) ||                LPAD(rr.id_versao, 6, 0), 'E', 'E' || LPAD(rr.rem_nro, 8, 0) ||                LPAD(rr.seq_rotulo, 4, 0) ||                LPAD(rr.id_versao, 6, 0), 'A', 'A' || LPAD(rr.ped_nmro, 8, 0) ||                LPAD(rr.seq_rotulo_ped, 4, 0) ||                LPAD(rr.id_versao, 6, 0)) sscc       ,DECODE(ref_status, 'I', 'Inativa', 'A', 'Ativa', 'Inativa') status	   ,r.ref_desc   FROM rotulos_remessa     rr       ,ite                 i       ,REF                 r       ,cabedal             cab       ,cor                 co       ,marcas_produtos     mp       ,qtd_rotulos_remessa q  WHERE rr.ped_nmro = i.ped_nmro    AND rr.ite_seqn = i.ite_seqn    AND i.lin_cdgo = r.lin_cdgo    AND i.ref_cdgo = r.ref_cdgo    AND i.cab_cdgo = cab.cab_cdgo    AND cab.cab_cdgo = i.cab_cdgo    AND co.cor_cdgo = i.cor_cdgo    AND mp.codigo_marca = r.codigo_marca    AND q.rem_nro = rr.rem_nro    AND q.rotulo = rr.rotulo    AND q.ped_nmro = rr.ped_nmro    AND q.ite_seqn = rr.ite_seqn    AND rr.ped_nmro = 14450684";
    return query;
  }

}
