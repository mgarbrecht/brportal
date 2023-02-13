package portalbr.dbobj.view;

/** DataBase Object from table .Jw_envio_edi_notas
  * @version 03/04/2013 09:30:37
  */
public class Jw_envio_edi_notasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","transportadora","78","false","text","Transportadora","","","","","","",},
                            {"double","qtd_notas","22","false","text","Notas","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT tra_cdgo || ' - ' || tra_nome transportadora       ,COUNT(nfs_nmro) qtd_notas    FROM notas_temp  GROUP BY tra_cdgo          ,tra_nome";
    return query;
  }

}
