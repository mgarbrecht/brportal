package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Fornecedor
  * @version 03/04/2013 09:56:10
  */
public class FornecedorMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"FOR_CODIGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FORNECEDOR";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","for_codigo","9","true","text","For_codigo","","","true","","","",},
                            {"java.lang.String","for_razsoc","40","true","text","For_razsoc","","","","","","",},
                            {"java.lang.String","for_fant","30","true","text","For_fant","","","","","","",},
                            {"java.sql.Date","for_inclus","10","true","text","For_inclus","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","for_tipops","1","false","text","For_tipops","","","","","","",},
                            {"java.lang.String","for_proser","1","false","text","For_proser","","","","","","",},
                            {"java.lang.String","for_conta","16","true","text","For_conta","","","","","","",},
                            {"java.lang.Integer","cpg_cdgo","2","false","text","Cpg_cdgo","","","true","","","",},
                            {"java.sql.Date","for_pricpd","10","false","text","For_pricpd","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Double","for_pricpv","20","false","text","For_pricpv","","##,##0.00","true","","","",},
                            {"java.sql.Date","for_ultcpd","10","false","text","For_ultcpd","","dd/MM/yyyy","true","","","",},
                            {"java.lang.Double","for_ultcpv","20","false","text","For_ultcpv","","##,##0.00","true","","","",},
                            {"java.lang.String","for_pagto","1","false","text","For_pagto","","","","","","",},
                            {"java.lang.String","for_preco","1","false","text","For_preco","","","","","","",},
                            {"java.lang.String","for_qtd","1","false","text","For_qtd","","","","","","",},
                            {"java.lang.String","for_qld","1","false","text","For_qld","","","","","","",},
                            {"java.lang.String","for_status","1","true","text","For_status","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","indic_mala_direta","1","false","text","Indic_mala_direta","","","","","","",},
                            {"java.lang.String","texto_ac","50","false","text","Texto_ac","","","","","","",},
                            {"java.lang.String","for_segmento","1","false","text","For_segmento","","","","","","",}
                          };
    return metadata;
  }

}
