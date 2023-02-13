package portalbr.dbobj.view;

/** DataBase Object from table .Jw_normas_vendas_marcas
  * @version 08/05/2009 09:10:57
  */
public class Jw_normas_vendas_marcasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","CODIGO_MARCA","22","false","text","","","","","","","",},
                            {"java.lang.String","DESCRICAO_MARCA","30","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct mp.codigo_marca, mp.descricao_marca  from brio.marcas_produtos mp  where mp.codigo_marca in(1,3,16,17)  order by 2";
    return query;
  }

}
