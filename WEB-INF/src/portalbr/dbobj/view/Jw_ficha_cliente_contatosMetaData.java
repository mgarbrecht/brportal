package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_contatos
  * @version 03/04/2013 09:30:17
  */
public class Jw_ficha_cliente_contatosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","nome","50","false","text","nome","","","","","","",},
                            {"java.lang.String","email","100","false","text","email","","","","","","",},
                            {"java.lang.String","tipo","25","false","text","tipo","","","","","","",},
                            {"java.sql.Date","data_nascimento","22","false","text","data_nascimento","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT p.pec_nome nome       ,p.pec_email email       ,t.tps_desc tipo       ,p.pec_data_nascimento data_nascimento   FROM pec p       ,tps t  WHERE p.tps_cdgo = t.tps_cdgo    AND p.cli_cdgo = 20698    AND esc_seqn = 90";
    return query;
  }

}
