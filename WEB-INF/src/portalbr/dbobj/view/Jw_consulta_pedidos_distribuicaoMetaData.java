package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_distribuicao
  * @version 29/10/2021 10:45:11
  */
public class Jw_consulta_pedidos_distribuicaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.Integer","item","22","false","text","item","","","","","","",},
                            {"java.lang.Integer","quantidade_pares","22","false","text","quantidade_pares","","","","","","",},
                            {"java.lang.Integer","grade","22","false","text","grade","","","","","","",},
                            {"java.lang.Integer","codigo_corrugado","22","false","text","codigo_corrugado","","","","","","",},
                            {"java.lang.Integer","qt_par_corrug","22","false","text","qt_par_corrug","","","","","","",},
                            {"java.lang.Integer","total_caixas","22","false","text","total_caixas","","","","","","",},
                            {"java.lang.String","descricao_corrugado","300","false","text","descricao_corrugado","","","","","","",},
                            {"java.lang.Integer","qtde_caixas_distribuidas","22","false","text","qtde_caixas_distribuidas","","","","","","",},
                            {"java.lang.String","ite_situ","20","false","text","ite_situ","","","","","","",},
                            {"java.lang.String","ite_stat","20","false","text","ite_stat","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT i.ped_nmro      ,i.ite_seqn item      ,ite_qtde quantidade_pares      ,i.gde_cdgo grade      ,i.codigo_corrugado      ,cg.qt_par_corrug      ,case when mod(CASE WHEN (ite_qtde / qt_par_corrug) > 0 AND (ite_qtde / qt_par_corrug) < 1 THEN 1 ELSE (ite_qtde / qt_par_corrug) END,1) = 0 then         CASE WHEN (ite_qtde / qt_par_corrug) > 0 AND (ite_qtde / qt_par_corrug) < 1 THEN 1 ELSE (ite_qtde / qt_par_corrug) END          else trunc (CASE WHEN (ite_qtde / qt_par_corrug) > 0 AND (ite_qtde / qt_par_corrug) < 1 THEN 1 ELSE (ite_qtde / qt_par_corrug) end) + 1 end  total_caixas      ,cg.descricao descricao_corrugado      ,NVL(SUM(idc.qtd_caixas), 0) qtde_caixas_distribuidas      ,i.ite_situ      ,i.ite_stat	    FROM ped                      p      ,ite                      i      ,corrugados               cg      ,ite_distribuicao_cliente idc WHERE p.ped_nmro = i.ped_nmro   AND cg.codigo = i.codigo_corrugado   AND idc.ped_nmro(+) = i.ped_nmro   AND idc.ite_seqn(+) = i.ite_seqn GROUP BY i.ped_nmro         ,i.ite_seqn         ,i.ite_qtde         ,i.gde_cdgo         ,i.codigo_corrugado         ,cg.qt_par_corrug         ,cg.descricao		 ,i.ite_situ         ,i.ite_stat";
    return query;
  }

}
