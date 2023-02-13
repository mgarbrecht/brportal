package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedido_afv
  * @version 03/04/2013 09:20:00
  */
public class Jw_pedido_afvMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","false","text","ped_nmro","","","","","","",},
                            {"java.lang.String","ped_sequencial_maquina","15","false","text","ped_sequencial_maquina","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select ped_nmro,ped_sequencial_maquina from ped where ped_sequencial_maquina='5504'";
    return query;
  }

}
