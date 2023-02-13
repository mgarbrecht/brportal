package portalbr.dbobj.view;

/** DataBase Object from table .Jw_agenda_visitas_clientes
  * @version 03/04/2013 09:51:17
  */
public class Jw_agenda_visitas_clientesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","agvc_id","22","false","text","","","","","","","",},
                            {"java.lang.Integer","agvc_agvi_id","22","false","text","","","","","","","",},
                            {"java.lang.Integer","agvc_cli_cdgo","22","false","text","","","","","","","",},
                            {"java.lang.Integer","agvc_esc_seqn","22","false","text","","","","","","","",},
                            {"java.lang.String","agvc_tipo","1","false","text","","","","","","","",},
                            {"java.sql.Timestamp","agvc_dt_exclusao","22","false","text","","","","","","","",},
                            {"java.lang.String","motivo","17","false","text","","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select w.*,decode(agvc_tipo,'V','Venda','R','Reposição','A','Venda e Reposição')motivo,c.cli_rzao from agenda_visitas_clientes w, cli c where w.agvc_agvi_id>0 and w.agvc_cli_cdgo=c.cli_cdgo";
    return query;
  }

}
