package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ref_cor
  * @version 03/04/2013 09:14:10
  */
public class Jw_ref_corMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","codigo_marca","10","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","10","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","10","false","text","ref_cdgp","","","","","","",},
                            {"java.lang.String","modelo","30","false","text","modelo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT distinct mp.codigo_marca      ,mp.descricao_marca      ,lin_cdgo      ,ref_cdgo      ,fct_mask_modelo(lin_cdgo, ref_cdgo) modelo  FROM ref_cor rc      ,marcas_produtos mp WHERE mp.codigo_marca = fct_marca_produto(rc.lin_cdgo, rc.ref_cdgo)   AND rc.rfc_status = 'A'ORDER BY lin_cdgo, ref_cdgo";
    return query;
  }

}
