package portalbr.dbobj.view;

/** DataBase Object from table .Necessidadeliquida
  * @version 02/03/2012 09:01:12
  */
public class NecessidadeliquidaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","FORNECEDOR_RAZSOC","81","false","text","","","","","","","",},
                            {"java.lang.Double","FORNECEDOR","22","false","text","","","","","","","",},
                            {"java.lang.Double","FEN_SEQ","22","false","text","","","","","","","",},
                            {"java.lang.Double","IES_CODIGO","22","false","text","","","","","","","",},
                            {"java.lang.String","IES_DESCRICAO","100","false","text","","","","","","","",},
                            {"java.lang.String","UNM_CODIGO","10","false","text","","","","","","","",},
                            {"java.lang.Double","COR_CDGO","22","false","text","","","","","","","",},
                            {"java.lang.String","COR_DESC","40","false","text","","","","","","","",},
                            {"java.lang.String","TAI_CODIGO","10","false","text","","","","","","","",},
                            {"java.lang.String","NOMECLATURA","50","false","text","","","","","","","",},
                            {"java.lang.Double","CONSUMOS","22","false","text","","","","","","","",},
                            {"java.lang.Double","CONSUMO_ANTERIOR","22","false","text","","","","","","","",},
                            {"java.lang.Double","ENTRADA_RETROATIVA","22","false","text","","","","","","","",},
                            {"java.lang.Double","ENTRADA_RETROATIVA2","22","false","text","","","","","","","",},
                            {"java.lang.Double","ESTOQUE","22","false","text","","","","","","","",},
                            {"java.lang.Double","OC","22","false","text","","","","","","","",},
                            {"java.lang.Double","ABASTEC","22","false","text","","","","","","","",},
                            {"java.lang.Double","CONSUMO","22","false","text","","","","","","","",},
                            {"java.lang.Double","LIQ_PROD","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCSEMANA1","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCSEMANA2","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCSEMANA3","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCSEMANA4","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCMES1","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCMES2","22","false","text","","","","","","","",},
                            {"java.lang.Double","OCMES3","22","false","text","","","","","","","",},
                            {"java.lang.Double","PEDSEMANA1","22","false","text","","","","","","","",},
                            {"java.lang.Double","PEDSEMANA2","22","false","text","","","","","","","",},
                            {"java.lang.Double","PEDSEMANA3","22","false","text","","","","","","","",},
                            {"java.lang.Double","PEDSEMANA4","22","false","text","","","","","","","",},
                            {"java.lang.Double","PEDMES1","22","false","text","","","","","","","",},
                            {"java.lang.Double","PEDMES2","22","false","text","","","","","","","",},
                            {"java.lang.Double","PEDMES3","22","false","text","","","","","","","",},
                            {"java.lang.String","VENDA_DIA","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' FORNECEDOR_RAZSOC,        0 FORNECEDOR,        0 IES_CODIGO,        '' IES_DESCRICAO,        '' UNM_CODIGO,        0 COR_CDGO,        '' COR_DESC,        '' TAI_CODIGO,        '' Nomeclatura,        0 CONSUMOS,        0 CONSUMO_ANTERIOR,        0 ENTRADA_RETROATIVA,		0 ENTRADA_RETROATIVA2,        0 ESTOQUE,        0 OC,        0 ABASTEC,        0 CONSUMO,        0 LIQ_PROD,        0 OCSEMANA1,        0 OCSEMANA2,        0 OCSEMANA3,        0 OCSEMANA4,        0 OCMES1,        0 OCMES2,        0 OCMES3,        0 PEDSEMANA1,        0 PEDSEMANA2,        0 PEDSEMANA3,        0 PEDSEMANA4,        0 PEDMES1,        0 PEDMES2,        0 PEDMES3,        0 VENDA_DIA        from dual";
    return query;
  }

}
