package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedidos_bloqueados
  * @version 03/04/2013 09:19:35
  */
public class Jw_pedidos_bloqueadosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","representante","43","false","text","representante","","","","","","",},
                            {"java.sql.Timestamp","entrega","22","false","text","entrega","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","digitacao","75","false","text","digitacao","","","","","","",},
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","tipo","11","false","text","tipo","","","","","","",},
                            {"java.lang.String","ped_nped","7","false","text","ped_nped","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select r.rep_cdgo||' - '||r.rep_rzao representante, p.ped_det entrega, to_char(p.ped_dadg,'dd/mm/yyyy')digitacao, p.cli_cdgo, c.cli_rzao, p.ped_nmro, decode(p.ped_tipo,'PG','Programado','EX','Exportação','PP','Ped. Pronto')tipo, p.ped_nped from ped p, cli c, rep r where p.cli_cdgo=c.cli_cdgo AND r.rep_cdgo=p.rep_cdgo AND r.codigo_regional=2 AND p.ped_det>=to_date('01/01/2000','dd/mm/yyyy')AND p.ped_det <=to_date('01/12/2007','dd/mm/yyyy')AND p.rep_cdgo> 0 AND p.ped_stat='P' AND p.emp_empresa='01'";
    return query;
  }

}
