package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedido_regional_representante
  * @version 03/04/2013 09:19:47
  */
public class Jw_pedido_regional_representanteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","ped_nped","7","false","text","ped_nped","","","","","","",},
                            {"java.lang.String","ped_sequencial_maquina","15","false","text","ped_sequencial_maquina","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT r.rep_cdgo, rv.codigo_regional, p.ped_nmro, p.ped_nped, p.ped_sequencial_maquina FROM ped p, regionais_vendas rv, rep r WHERE p.rep_cdgo=r.rep_cdgo AND r.codigo_regional=rv.codigo_regional and p.ped_nmro=313153";
    return query;
  }

}
