package portalbr.dbobj.view;

/** DataBase Object from table .Jw_grade_solicitacao_especial
  * @version 03/04/2013 09:27:32
  */
public class Jw_grade_solicitacao_especialMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","numeracao","22","false","text","numeracao","","","","","","",},
                            {"java.lang.Integer","pares","pares","false","text","","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","linha","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ((n.numeracao_inicial - 1) + ROWNUM) numeracao       ,0 pares       ,n.lin_cdgo   FROM wbrio.numeracoes_grades_validas n       ,wbrio.usuarios  WHERE ROWNUM <= (n.numeracao_final - n.numeracao_inicial) + 1";
    return query;
  }

}
