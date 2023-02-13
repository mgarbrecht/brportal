package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Entrada_pedidos_atual_vw
  * @version 08/09/2022 10:48:24
  */
public class Entrada_pedidos_atual_vwMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "ENTRADA_PEDIDOS_ATUAL_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","atualizacao","20","false","text","Atualizacao","","","","","","",},
                            {"java.lang.String","datam","20","false","text","Datam","","","","","","",},
                            {"java.lang.Double","pr_pp","22","false","text","Pr_pp","","0","true","","","",},
                            {"java.lang.Double","vlr_pp","22","false","text","Vlr_pp","","##,##0.00","true","","","",},
                            {"java.lang.Double","pr_pg","22","false","text","Pr_pg","","0","true","","","",},
                            {"java.lang.Double","vlr_pg","22","false","text","Vlr_pg","","##,##0.00","true","","","",},
                            {"java.lang.Double","tot_pares","22","false","text","Tot_pares","","0","true","","","",},
                            {"java.lang.Double","tot_vlr","22","false","text","Tot_vlr","","##,##0.00","true","","","",},
                            {"java.lang.String","tipo","20","false","text","Tipo","","","","","","",},
                            {"java.lang.Integer","codigo_gerente","22","false","text","Codigo_gerente","","","true","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","Codigo_regional","","","true","","","",},
                            {"java.lang.String","rep_cdgo","10","false","text","Rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_rzao","100","false","text","Rep_rzao","","","","","","",},
                            {"java.lang.String","sigla_regional","20","false","text","Sigla_regional","","","","","","",},
                            {"java.lang.Integer","codigo_marca","20","false","text","Codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","100","false","text","Descricao_marca","","","","","","",},
                            {"java.lang.Integer","clientes","22","true","text","Clientes","","","true","","","",},
                            {"java.lang.Integer","total_pares_ano","22","false","text","total_pares_ano","","","","","","",},
                            {"java.lang.Double","total_valor_ano","22","false","text","total_valor_ano","","##,##0.00","","","","",},
                            {"java.lang.Integer","clientes_atendidos_ano","22","false","text","clientes_atendidos_ano","","","","","","",},
                            {"java.lang.Integer","clientes_calcados","22","false","text","clientes_calcados","","","","","","",},
                            {"java.lang.Integer","clientes_botas","22","false","text","clientes_botas","","","","","","",},
                            {"java.lang.Integer","clientes_meias","22","false","text","clientes_meias","","","","","","",}
                          };
    return metadata;
  }

}
