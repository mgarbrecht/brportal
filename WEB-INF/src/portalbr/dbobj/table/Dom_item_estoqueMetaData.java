package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_item_estoque
  * @version 05/08/2014 09:42:29
  */
public class Dom_item_estoqueMetaData {

  public static final String SCHEMA = "EST";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "DOM_ITEM_ESTOQUE";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo","22","true","text","Codigo","","","true","","","",},
                            {"java.lang.String","descricao","100","false","text","Descricao","","","","","","",},
                            {"java.lang.String","tipo","1","false","text","Tipo","","","","","","",},
                            {"java.lang.Integer","ipi_codred","22","false","text","Ipi_codred","","","true","","","",},
                            {"java.lang.String","unm_codigo","3","false","text","Unm_codigo","","","","","","",},
                            {"java.lang.Integer","gpo_codigo","6","false","text","Gpo_codigo","","","true","","","",},
                            {"java.lang.Integer","ges_codigo","6","false","text","Ges_codigo","","","true","","","",},
                            {"java.lang.String","finalidade","1","false","text","Finalidade","","","","","","",},
                            {"java.lang.Integer","trf_cdgo","2","false","text","Trf_cdgo","","","true","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","Lin_cdgo","","","true","","","",},
                            {"java.lang.Integer","ref_cdgo","10","false","text","Ref_cdgo","","","true","","","",},
                            {"java.lang.Integer","cab_cdgo","22","false","text","Cab_cdgo","","","true","","","",},
                            {"double","clf_codigo","10","false","text","Clf_codigo","","","true","","","",},
                            {"java.lang.Integer","dias_antecedencia","3","false","text","Dias_antecedencia","","","true","","","",},
                            {"java.lang.String","curva_abc","1","false","text","Curva_abc","","","","","","",},
                            {"java.lang.Double","custo_unitario","20","false","text","Custo_unitario","","","true","","","",},
                            {"java.lang.Double","valor_poi","20","false","text","Valor_poi","","","true","","","",},
                            {"java.lang.String","gera_oc","1","false","text","Gera_oc","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","cor","1","false","text","Cor","","","","","","",},
                            {"java.lang.String","tamanho","1","false","text","Tamanho","","","","","","",},
                            {"java.lang.String","forma","1","false","text","Forma","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","22","false","text","Dthr_inclusao","","","true","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","22","false","text","Dthr_alteracao","","","true","","","",},
                            {"java.lang.String","usuario_inclusao","30","false","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.lang.String","composicao","1","false","text","Composicao","","","","","","",},
                            {"java.lang.Integer","ccs_codigo","6","false","text","Ccs_codigo","","","true","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",},
                            {"java.lang.String","compra_por_remessa","1","false","text","Compra_por_remessa","","","","","","",},
                            {"java.lang.Integer","dimensao_chapa_eva","20","false","text","Dimensao_chapa_eva","","","true","","","",},
                            {"java.lang.Double","largura","20","false","text","Largura","","##,##0.00","true","","","",},
                            {"java.lang.Double","comprimento","11","false","text","Comprimento","","##,##0.00","true","","","",},
                            {"java.lang.Double","peso","8","false","text","Peso","","##,##0.00","true","","","",},
                            {"java.lang.Double","altura","11","false","text","Altura","","##,##0.00","true","","","",},
                            {"java.lang.Double","espessura","11","false","text","Espessura","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
