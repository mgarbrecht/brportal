package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ncm
  * @version 03/04/2013 09:21:15
  */
public class Jw_ncmMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo_marca","3","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","marca_nome","30","false","text","marca_nome","","","","","","",},
                            {"java.lang.String","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","descricao","100","false","text","descricao","","","","","","",},
                            {"java.lang.String","ncm","10","false","text","ncm","","","","","","",},
                            {"java.lang.String","ref_status","10","false","text","ref_status","","","","","","",},
                            {"java.lang.String","rfb_status","10","false","text","rfb_status","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ref.codigo_marca      ,pck_marcas_produtos.get_nome(ref.codigo_marca) marca_nome      ,d.lin_cdgo      ,d.ref_cdgo      ,d.cab_cdgo      ,d.descricao      ,i.ipi_posi || i.ipi_subp || LPAD(i.ipi_item, 2, 0) ncm      ,ref.ref_status      ,rc.rfb_status  FROM dom_item_estoque d      ,ipi i      ,brio.ref      ,ref_cab rc WHERE i.ipi_codred = d.ipi_codred   AND ref.lin_cdgo = d.lin_cdgo   AND ref.ref_cdgo = d.ref_cdgo   AND rc.lin_cdgo = d.lin_cdgo   AND rc.ref_cdgo = d.ref_cdgo   AND rc.cab_cdgo = d.cab_cdgo";
    return query;
  }

}
