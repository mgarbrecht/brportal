package portalbr.dbobj.view;

/** DataBase Object from table .Jw_registros_exportacao
  * @version 22/08/2017 12:03:39
  */
public class Jw_registros_exportacaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","numero_re","200","false","text","numero_re","","","","","","",},
                            {"java.sql.Date","data_embarque","22","false","text","data_embarque","","dd/MM/yyyy","","","","",},
                            {"java.sql.Date","data_averbacao","22","false","text","data_averbacao","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","emp_empresa","20","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","ano_fatura","20","false","text","ano_fatura","","","","","","",},
                            {"java.lang.String","numero_fatura","20","false","text","numero_fatura","","","","","","",},
                            {"java.lang.String","ncm","200","false","text","ncm","","","","","","",},
                            {"java.lang.Integer","pares","22","false","text","pares","","","","","","",},
                            {"java.lang.Double","perc_comissao","20","false","text","perc_comissao","","","","","","",},
                            {"java.lang.Double","fob","22","false","text","fob","","","","","","",},
                            {"java.lang.Double","valor_comissao","22","false","text","valor_comissao","","","","","","",},
                            {"java.lang.Double","fob_liquido","22","false","text","fob_liquido","","","","","","",},
                            {"java.lang.String","nome_despachante","200","false","text","nome_despachante","","","","","","",},
                            {"java.lang.Double","valor_unitario","22","false","text","valor_unitario","","","","","","",},
                            {"java.lang.String","dde","200","false","text","dde","","","","","","",},
                            {"java.lang.String","produto","200","false","text","produto","","","","","","",},
                            {"java.lang.String","descricao_produto","2000","false","text","descricao_produto","","","","","","",},
                            {"java.lang.String","numero_drawback","2000","false","text","numero_drawback","","","","","","",},
                            {"java.lang.String","componente","2000","false","text","componente","","","","","","",},
                            {"java.lang.Double","consumo","22","false","text","consumo","","","","","","",},
                            {"java.lang.Object","lista_componente_consumo","2000","false","text","componentes_consumo","","","","","","",},
                            {"java.lang.String","fil_filial","200","false","text","fil_filial","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT         '' numero_re        ,trunc(SYSDATE) data_embarque       ,trunc(SYSDATE) data_averbacao	   ,'' emp_empresa       ,'' ano_fatura 	   ,'' numero_fatura 	          ,'' NCM       ,0 pares       ,'' perc_comissao       ,0.0 fob       ,0.0 valor_comissao       ,0.0 fob_liquido       ,'' nome_despachante       ,0.0 valor_unitario       ,'' dde	   ,'' produto       ,'' descricao_produto       ,'' numero_drawback	   ,'' componente	   ,0.0 consumo	   ,'' fil_filial   FROM dual";
    return query;
  }

}
