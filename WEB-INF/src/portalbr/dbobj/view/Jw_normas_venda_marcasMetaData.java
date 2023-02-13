package portalbr.dbobj.view;

/** DataBase Object from table .Jw_normas_venda_marcas
  * @version 03/04/2013 09:20:54
  */
public class Jw_normas_venda_marcasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct mp.codigo_marca, mp.descricao_marca  from brio.marcas_produtos mp  where mp.status = 'A'  order by 2";
    return query;
  }

}
