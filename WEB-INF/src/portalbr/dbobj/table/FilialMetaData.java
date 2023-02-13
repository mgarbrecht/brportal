package portalbr.dbobj.table;

/** DataBase Object from table TCONTAB.Filial
  * @version 03/04/2013 09:56:46
  */
public class FilialMetaData {

  public static final String SCHEMA = "TCONTAB";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"EMP_EMPRESA","FIL_FILIAL"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Filial";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","true","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","true","text","Filial","","","","","","",},
                            {"java.lang.String","est_unifed","2","true","text","est_unifed","","","","","","",},
                            {"java.lang.String","unn_codigo","3","true","text","unn_codigo","","","","","","",},
                            {"java.lang.String","fil_razsoc","50","true","text","fil_razsoc","","","","","","",},
                            {"java.lang.String","fil_fantas","25","false","text","fil_fantas","","","","","","",},
                            {"java.lang.String","fil_endereco","35","true","text","fil_endereco","","","","","","",},
                            {"java.lang.String","fil_bairro","20","false","text","fil_bairro","","","","","","",},
                            {"java.lang.String","fil_cidade","20","true","text","fil_cidade","","","","","","",},
                            {"java.lang.String","fil_cep","9","false","text","fil_cep","","","","","","",},
                            {"double","fil_cgc","14","true","text","fil_cgc","","","true","","","",},
                            {"java.lang.String","fil_insest","12","false","text","fil_insest","","","","","","",},
                            {"java.lang.String","fil_segmto","3","true","text","fil_segmto","","","","","","",},
                            {"java.lang.String","fil_gerent","15","false","text","fil_gerent","","","","","","",},
                            {"java.lang.String","fil_ddi","5","false","text","fil_ddi","","","","","","",},
                            {"java.lang.String","fil_ddd","5","false","text","fil_ddd","","","","","","",},
                            {"int","fil_fone","8","false","text","fil_fone","","","true","","","",},
                            {"int","fil_fax","7","false","text","fil_fax","","","true","","","",},
                            {"java.lang.String","fil_telex","10","false","text","fil_telex","","","","","","",},
                            {"java.lang.String","fil_cxpost","5","false","text","fil_cxpost","","","","","","",},
                            {"java.lang.String","fil_documento_contabil","8","false","text","fil_documento_contabil","","","","","","",},
                            {"java.lang.String","fil_gln","14","false","text","fil_gln","","","","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",}
                          };
    return metadata;
  }

}
