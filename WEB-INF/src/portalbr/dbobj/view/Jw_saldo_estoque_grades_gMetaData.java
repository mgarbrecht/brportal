package portalbr.dbobj.view;

/** DataBase Object from table .Jw_saldo_estoque_grades_g
  * @version 03/04/2013 09:10:13
  */
public class Jw_saldo_estoque_grades_gMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","numero","5","false","text","numero","","","","","","",},
                            {"java.lang.Integer","quantidade","22","false","text","quantidade","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select qtp_nume numero,  qtp_pars quantidade from qtd_prg where ped_nmro=3338586   AND ite_seqn=2";
    return query;
  }

}
