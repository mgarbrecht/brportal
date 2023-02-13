package portalbr.dbobj.table;

/** DataBase Object from table CPR.Dom_item_cotacao_preco
  * @version 03/04/2013 10:00:09
  */
public class Dom_item_cotacao_precoMetaData {

  public static final String SCHEMA = "CPR";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CPR_NUMERO","SEQUENCIA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "DOM_ITEM_COTACAO_PRECO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","cpr_numero","22","true","text","Cpr_numero","","","true","","","",},
                            {"int","sequencia","6","true","text","Sequencia","","","true","","","",},
                            {"int","for_codigo","9","true","text","For_codigo","","","true","","","",},
                            {"int","fen_seq","4","true","text","Fen_seq","","","true","","","",},
                            {"int","cpg_codigo","3","true","text","Cpg_codigo","","","true","","","",},
                            {"double","preco_unitario","20","true","text","Preco_unitario","","","true","","","",},
                            {"double","quant_cotada","17","true","text","Quant_cotada","","","true","","","",},
                            {"int","situacao","2","true","text","Situacao","","","true","","","",},
                            {"int","prazo_entrega","3","false","text","Prazo_entrega","","","true","","","",},
                            {"double","custo_financeiro","7","false","text","Custo_financeiro","","","true","","","",},
                            {"double","percentual_ipi","7","false","text","Percentual_ipi","","","true","","","",},
                            {"double","percentual_icms","7","false","text","Percentual_icms","","","true","","","",},
                            {"double","percentual_frete","7","false","text","Percentual_frete","","","true","","","",},
                            {"int","ies_codigo","22","false","text","Ies_codigo","","","true","","","",},
                            {"int","cor_cdgo","22","false","text","Cor_cdgo","","","true","","","",},
                            {"java.lang.String","tai_codigo","5","false","text","Tai_codigo","","","","","","",},
                            {"java.lang.String","item_descricao","120","false","text","Item_descricao","","","","","","",},
                            {"int","seleciona","6","false","text","Seleciona","","","true","","","",},
                            {"java.lang.String","usuario_libera","30","false","text","Usuario_libera","","","","","","",},
                            {"java.sql.Timestamp","data_libera","22","false","text","Data_libera","","","true","","","",},
                            {"java.lang.String","unm_codigo","3","true","text","Unm_codigo","","","","","","",},
                            {"int","sco_numero","22","false","text","Sco_numero","","","true","","","",},
                            {"int","iso_sequencia","6","false","text","Iso_sequencia","","","true","","","",},
                            {"double","preco_final","20","false","text","Preco_final","","","true","","","",},
                            {"java.lang.String","observacoes","500","false","text","Observacoes","","","","","","",},
                            {"java.lang.String","sel_gerente","1","false","text","Sel_gerente","","","","","","",},
                            {"int","tco_codigo","2","false","text","Tco_codigo","","","true","","","",},
                            {"int","tra_codigo","3","false","text","Tra_codigo","","","true","","","",},
                            {"java.lang.String","forma_pgto","3","false","text","Forma_pgto","","","","","","",},
                            {"java.lang.String","moe_codigo","3","false","text","Moe_codigo","","","","","","",},
                            {"int","poi_grupo","5","false","text","Poi_grupo","","","true","","","",},
                            {"int","codigo_depto","5","false","text","Codigo_depto","","","true","","","",},
                            {"java.lang.String","ccta_codigo","8","false","text","Ccta_codigo","","","","","","",},
                            {"java.lang.Double","japr_codigo","22","false","text","Japr_codigo","","##,##0.00","true","","","",},
                            {"java.lang.String","descricao_justificativa","500","false","text","Descricao_justificativa","","","","","","",},
                            {"java.lang.String","sel_diretor","1","false","text","Sel_diretor","","","","","","",},
                            {"java.lang.Double","irrf","15","false","text","Irrf","","##,##0.00","true","","","",},
                            {"java.lang.Double","inss","15","false","text","Inss","","##,##0.00","true","","","",},
                            {"java.lang.Double","issqn","15","false","text","Issqn","","##,##0.00","true","","","",},
                            {"java.lang.Double","csrf","15","false","text","Csrf","","##,##0.00","true","","","",},
                            {"java.lang.Double","pis","15","false","text","Pis","","##,##0.00","true","","","",},
                            {"java.lang.Double","cofins","15","false","text","Cofins","","##,##0.00","true","","","",},
                            {"java.lang.Double","csll","15","false","text","Csll","","##,##0.00","true","","","",}
                          };
    return metadata;
  }

}
