package portalbr.dbobj.view;

/** DataBase Object from table .Jw_dom_ordem_compra
  * @version 21/01/2016 14:40:40
  */
public class Jw_dom_ordem_compraMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","numero","22","false","text","numero","","","","","","",},
                            {"java.sql.Date","data_compra","22","false","text","data_compra","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","unn_codigo","3","false","text","unn_codigo","","","","","","",},
                            {"java.lang.Integer","forn_codigo","22","false","text","forn_codigo","","","","","","",},
                            {"java.lang.Integer","fen_seq","22","false","text","fen_seq","","","","","","",},
                            {"java.lang.Integer","cpg_codigo","22","false","text","cpg_codigo","","","","","","",},
                            {"java.lang.Integer","com_codigo","22","false","text","com_codigo","","","","","","",},
                            {"java.lang.Integer","situacao","22","false","text","situacao","","","","","","",},
                            {"java.lang.Integer","tra_cdgo","22","false","text","tra_cdgo","","","","","","",},
                            {"java.lang.String","forn_razsoc","100","false","text","forn_razsoc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT d.numero      ,d.data_compra      ,d.emp_empresa      ,d.fil_filial      ,d.unn_codigo      ,nvl(d.for_codigo,null) forn_codigo      ,d.fen_seq      ,d.cpg_codigo      ,d.com_codigo      ,d.situacao      ,d.tra_cdgo      ,f.for_razsoc forn_razsoc  FROM dom_ordem_compra d     , fornecedor f     , fornecedor_parametros_edi fpe WHERE f.for_codigo = d.for_codigo   AND fpe.for_codigo = f.for_codigo   AND nvl(d.situacao,null) <> 9";
    return query;
  }

}
