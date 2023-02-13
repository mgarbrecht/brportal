package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_peso_cubagem_nota
  * @version 14/12/2010 08:47:21
  */
public class Prc_peso_cubagem_notaMetaData {

  public static final String SCHEMA = "WBRIO";

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PRC_PESO_CUBAGEM_NOTA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","p_emp_empresa","10","in","text","P_emp_empresa","","","","","","",},
                            {"java.lang.String","p_fil_filial","10","in","text","P_fil_filial","","","","","","",},
                            {"java.lang.String","p_nfs_nmro","22","in","text","P_nfs_nmro","","","true","","","",},
                            {"java.lang.String","p_nfs_serie","10","in","text","P_nfs_serie","","","","","","",},
                            {"double","p_peso_bruto","22","out","text","P_peso_bruto","","##,##0.00","true","","","",},
                            {"double","p_peso_liquido","22","out","text","P_peso_liquido","","##,##0.00","true","","","",},
                            {"double","p_cubagem","22","out","text","P_cubagem","","##,##0.00","true","","","",},
                            {"double","p_volumes","22","out","text","P_volumes","","0","true","","","",}
                          };
    return metadata;
  }

}
