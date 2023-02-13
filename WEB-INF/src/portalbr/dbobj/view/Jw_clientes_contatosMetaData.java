package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_contatos
  * @version 03/04/2013 09:46:17
  */
public class Jw_clientes_contatosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","pec_nome","35","false","text","pec_nome","","","","","","",},
                            {"java.lang.String","pec_cpf","22","false","text","pec_cpf","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select pec.pec_nome,pec_cpf  from pec  where pec.cli_cdgo=23435  and pec.esc_seqn=1";
    return query;
  }

}
