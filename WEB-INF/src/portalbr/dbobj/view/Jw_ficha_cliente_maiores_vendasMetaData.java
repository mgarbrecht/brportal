package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_maiores_vendas
  * @version 03/04/2013 09:29:45
  */
public class Jw_ficha_cliente_maiores_vendasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","modelo","100","false","text","modelo","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.lang.Double","valor","22","false","text","valor","","","","","","",},
                            {"java.lang.String","imagem","100","false","text","Imagem","","","","","","",},
                            {"java.lang.Integer","codigo_marca","10","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","100","false","text","descricao_marca","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","10","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","10","false","text","ref_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT /*+use index (p RESUMO_PED) */  '' linha ,SUM(p.pares) pares ,SUM(p.valor) valor ,fct_retorna_fit_imagem(p.linha) imagem ,0 codigo_marca ,'' descricao_marca ,0 lin_cdgo ,0 ref_cdgo   FROM resumo_ped p       ,cli c       ,rep r       ,lin l       ,REF f  WHERE p.data_dig >= TRUNC(SYSDATE, 'month')    AND p.data_dig < TRUNC(LAST_DAY(SYSDATE)) + 1    AND c.cli_cdgo = p.cli_cdgo    AND r.rep_cdgo = p.rep_cdgo    AND p.lin_cdgo = f.lin_cdgo    AND p.ref_cdgo = f.ref_cdgo    AND l.lin_cdgo = p.lin_cdgo    AND l.ind_aberto_fechado IS NOT NULL    AND p.codigo_regional IN (SELECT DISTINCT r.codigo_regional                                FROM rep r                                    ,cliente_representante cr                               WHERE cr.codigo_representante = r.rep_cdgo                                 AND r.codigo_regional <> 99                                 AND cr.codigo_cliente = 3495                                 AND ROWNUM = 1)  GROUP BY p.lin_cdgo  ORDER BY pares DESC          ,valor DESC";
    return query;
  }

}
