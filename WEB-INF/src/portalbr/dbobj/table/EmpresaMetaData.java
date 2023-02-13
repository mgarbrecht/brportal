package portalbr.dbobj.table;

/** DataBase Object from table TCONTAB.Empresa
  * @version 03/04/2013 09:59:07
  */
public class EmpresaMetaData {

  public static final String SCHEMA = "TCONTAB";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"EMP_EMPRESA"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "Empresa";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","true","text","Empresa","","","","","","",},
                            {"java.lang.String","est_unifed","2","true","text","est_unifed","","","","","","",},
                            {"java.lang.String","emp_razsoc","50","true","text","emp_razsoc","","","","","","",},
                            {"java.lang.String","emp_fantas","25","false","text","emp_fantas","","","","","","",},
                            {"java.lang.String","emp_endereco","35","true","text","emp_endereco","","","","","","",},
                            {"java.lang.String","emp_bairro","20","false","text","emp_bairro","","","","","","",},
                            {"java.lang.String","emp_cidade","20","false","text","emp_cidade","","","","","","",},
                            {"java.lang.String","emp_cep","9","false","text","emp_cep","","","","","","",},
                            {"double","emp_cgc","14","true","text","emp_cgc","","","true","","","",},
                            {"java.lang.String","emp_insest","12","false","text","emp_insest","","","","","","",}
                          };
    return metadata;
  }

}
