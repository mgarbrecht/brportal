package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_representantes
  * @version 03/04/2013 09:42:49
  */
public class Jw_clientes_representantesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_cliente","22","false","text","codigo_cliente","","","","","","",},
                            {"java.lang.String","codigo_representante","5","false","text","codigo_representante","","","","","","",},
                            {"java.lang.String","representante","43","false","text","representante","","","","","","",},
                            {"java.lang.String","rep_nome","30","false","text","rep_nome","","","","","","",},
                            {"java.lang.String","marca","9","false","text","marca","","","","","","",},
                            {"java.lang.String","telefone","10","false","text","telefone","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select cr.codigo_cliente, cr.codigo_representante,r.rep_cdgo||' - '||r.rep_rzao representante, r.rep_nome, decode(r.rep_tipo_marca,'A','Allegro','B','Beira Rio','V','Vizzano',null)marca, '' telefone from cliente_representante cr, rep r where cr.codigo_cliente> 0 and cr.codigo_representante=r.rep_cdgo and cr.situacao='A'";
    return query;
  }

}
