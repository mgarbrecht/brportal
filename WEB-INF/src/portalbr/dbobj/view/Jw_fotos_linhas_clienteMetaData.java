package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fotos_linhas_cliente
  * @version 03/04/2013 09:28:11
  */
public class Jw_fotos_linhas_clienteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","68","false","text","lin_nome","","","","","","",},
                            {"java.lang.String","nome","25","false","text","nome","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct lin.lin_cdgo, lin.lin_cdgo||' - '||lin.lin_nome lin_nome, lin.lin_nome nome from lin, ref where ref.lin_cdgo=lin.lin_cdgo and ref.codigo_marca in(SELECT codigo_marca FROM marcas_produtos WHERE status = 'A')and ref.ref_status='A' and ref.ref_tipo='PG' order by 3, 1";
    return query;
  }

}
