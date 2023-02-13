package portalbr.dbobj.view;

/** DataBase Object from table .Jw_circulares
  * @version 03/04/2013 09:49:04
  */
public class Jw_circularesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","numero","7","false","text","numero","","","","","","",},
                            {"java.sql.Timestamp","data","22","false","text","data","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","remetente","20","false","text","remetente","","","","","","",},
                            {"java.lang.String","assunto","30","false","text","assunto","","","","","","",},
                            {"java.lang.String","dest","30","false","text","dest","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT CV.NUMERO,  CV.DATA,  CV.REMETENTE,  CV.ASSUNTO,  CD.DESCRICAO_DESTINO DEST  FROM brio.CIRCULARES_VENDAS CV, brio.CIRCULARES_DESTINO CD  WHERE STATUS='A' AND NUMERO_DESTINO=DESTINATARIO";
    return query;
  }

}
