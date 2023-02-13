package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_cad_dados
  * @version 03/04/2013 09:47:07
  */
public class Jw_clientes_cad_dadosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_representante","5","false","text","codigo_representante","","","","","","",},
                            {"java.lang.String","representante","36","false","text","representante","","","","","","",},
                            {"java.lang.String","marca","14","false","text","marca","","","","","","",},
                            {"java.lang.String","sit_cli_rep","7","false","text","sit_cli_rep","","","","","","",},
                            {"java.lang.String","marcas","400","false","text","marcas","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct cr.codigo_representante, cr.codigo_representante||'-'||r.rep_nome representante, decode(r.rep_tipo_marca,'V','Rep. Vizzano','Rep. Beira Rio')marca, decode(cr.situacao,'A','Ativo','Inativo')sit_cli_rep, '' marcas from cliente_representante cr, rep r where cr.codigo_representante=r.rep_cdgo AND rep_situ='A' AND cr.codigo_cliente=38096 and cr.codigo_sequencial=1";
    return query;
  }

}
