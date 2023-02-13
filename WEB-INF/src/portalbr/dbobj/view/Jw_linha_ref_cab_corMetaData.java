package portalbr.dbobj.view;

/** DataBase Object from table .Jw_linha_ref_cab_cor
  * @version 03/04/2013 09:26:02
  */
public class Jw_linha_ref_cab_corMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cab_cdgo","22","false","text","cab_cdgo","","","","","","",},
                            {"java.lang.String","cab_desc","35","false","text","cab_desc","","","","","","",},
                            {"java.lang.String","status","7","false","text","status","","","","","","",},
                            {"java.lang.String","cor_cdgo","22","false","text","cor_cdgo","","","","","","",},
                            {"java.lang.String","cor_desc","60","false","text","cor_desc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select r.cab_cdgo,  c.cab_desc,  decode(r.rfb_status,'A','Ativo','I','Inativo')status,  re.cor_cdgo,  co.cor_desc  from ref_cab r,  cabedal c,  cor co,  ref_cor re  where r.cab_cdgo=c.cab_cdgo  AND r.lin_cdgo=415  and r.ref_cdgo=100  AND co.cor_cdgo=re.cor_cdgo  and re.lin_cdgo=r.lin_cdgo  and re.ref_cdgo=r.ref_cdgo  and re.cab_cdgo=r.cab_cdgo";
    return query;
  }

}
