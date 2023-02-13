package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tabela_preco_exp
  * @version 16/10/2015 10:32:15
  */
public class Jw_tabela_preco_expMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","imagem","100","false","text","imagem","","","","","","",},
                            {"java.lang.String","marca","100","false","text","marca","","","","","","",},
                            {"java.lang.String","modelo","100","false","text","modelo","","","","","","",},
                            {"java.lang.String","cabedal","100","false","text","cabedal","","","","","","",},
                            {"java.lang.String","cor","100","false","text","cor","","","","","","",},
                            {"java.sql.Timestamp","versao_tabela_tp","22","false","text","versao_tabela_tp","","","","","","",},
                            {"java.lang.String","nro_ini_brasil","5","false","text","nro_ini_brasil","","","","","","",},
                            {"java.lang.String","nro_ini_europa","5","false","text","nro_ini_europa","","","","","","",},
                            {"java.lang.String","nro_fin_brasil","5","false","text","nro_fin_brasil","","","","","","",},
                            {"java.lang.String","nro_fin_europa","5","false","text","nro_fin_europa","","","","","","",},
                            {"double","preco","22","false","text","preco","","","","","","",},
                            {"java.lang.String","moeda","10","false","text","moeda","","","","","","",},
                            {"java.lang.String","cab_cdgo","100","false","text","cab_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT REPLACE(fct_retorna_fit_imagem(tp.codigo_linha_tp, tp.codigo_referencia_tp), '.gif', '.jpg') imagem       ,descricao_marca marca       ,fct_mask_modelo(tp.codigo_linha_tp, tp.codigo_referencia_tp) modelo       ,'' cabedal       ,'' cor       ,versao_tabela_tp       ,nro_ini_brasil       ,(SELECT nuco_num_cont           FROM numeracao_continentes e          WHERE nuco_con_codigo = 'EURO'            AND nuco_num_brasil = nro_ini_brasil) nro_ini_europa       ,nro_fin_brasil       ,(SELECT nuco_num_cont           FROM numeracao_continentes e          WHERE nuco_con_codigo = 'EURO'            AND nuco_num_brasil = nro_fin_brasil) nro_fin_europa       ,(brio.fct_busca_preco_mercado_ext(versao_tabela, tp.codigo_linha_tp, tp.codigo_referencia_tp, 50, tp.cab_cdgo)) preco       ,moeda       ,cab_cdgo   FROM (SELECT DISTINCT te.versao_tabela                        ,rc.lin_cdgo codigo_linha_tp                        ,rc.ref_cdgo codigo_referencia_tp                        ,te.versao_tabela versao_tabela_tp                        ,MIN(q.qtd_nume) nro_ini_brasil                        ,MAX(q.qtd_nume) nro_fin_brasil                        ,CAST(NVL(tp.moe_codigo, 'US$') AS VARCHAR2(10)) moeda                        ,mp.descricao_marca                        ,rc.cab_cdgo           FROM tabela_preco_mercado_externo te               ,tabela_preco                 tp               ,ref_gde                      fg               ,ref_cor                      rc               ,REF                          r               ,lin                          l               ,qtd                          q               ,marcas_produtos              mp          WHERE tp.codigo_livro = te.codigo_livro            AND tp.codigo_pais = te.codigo_pais            AND tp.versao_tabela = te.versao_tabela            AND q.gde_cdgo = fg.gde_cdgo            AND fg.lin_cdgo = te.codigo_linha            AND fg.ref_cdgo = te.codigo_referencia            AND rc.lin_cdgo = te.codigo_linha            AND rc.ref_cdgo = te.codigo_referencia            AND r.lin_cdgo = rc.lin_cdgo            AND r.ref_cdgo = rc.ref_cdgo            AND r.lin_cdgo = l.lin_cdgo            AND NVL(te.codigo_cabedal, 999) =                DECODE(NVL(te.codigo_cabedal, 999), 999, 999, rc.cab_cdgo)            AND te.codigo_livro = 50            AND te.codigo_pais = 1            AND te.versao_tabela =                to_date('13/10/201514:33:17', 'dd/mm/yyyy hh24:mi:ss')            AND fct_marca_produto(fg.lin_cdgo, fg.ref_cdgo) = mp.codigo_marca            AND rc.rfc_status = 'A'            AND te.status = 'A'          GROUP BY te.versao_tabela                  ,rc.lin_cdgo                  ,rc.ref_cdgo                  ,rc.cab_cdgo                  ,mp.descricao_marca                  ,tp.moe_codigo) tp  GROUP BY tp.versao_tabela_tp          ,tp.codigo_linha_tp          ,tp.codigo_referencia_tp          ,tp.cab_cdgo          ,nro_ini_brasil          ,nro_fin_brasil          ,moeda          ,descricao_marca  ORDER BY marca          ,modelo          ,cab_cdgo";
    return query;
  }

}
