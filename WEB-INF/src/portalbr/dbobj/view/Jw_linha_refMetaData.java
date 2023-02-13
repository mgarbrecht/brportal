package portalbr.dbobj.view;

/** DataBase Object from table .Jw_linha_ref
  * @version 03/04/2013 09:26:11
  */
public class Jw_linha_refMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","referencia","4000","false","text","referencia","","","","","","",},
                            {"java.lang.String","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.String","descricao","53","false","text","descricao","","","","","","",},
                            {"java.lang.String","status","7","false","text","status","","","","","","",},
                            {"java.lang.String","cod_filial","4","false","text","cod_filial","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct fct_mask_modelo(r.lin_cdgo,r.ref_cdgo)referencia, r.lin_cdgo, r.ref_cdgo, l.lin_nome||' - '||r.ref_desc descricao, decode(r.ref_status,'A','Ativo','I','Inativo')status, f.cod_filial from lin l, ref r, filial_linhas f where l.lin_cdgo=r.lin_cdgo and r.lin_cdgo=f.lin_codigo and f.ativa='S' and f.cod_empresa='01' and r.lin_cdgo>0 and r.lin_cdgo <> '999' and r.ref_cdgo <> '999' and r.ref_status=decode('T','A','A','I','I',r.ref_status)";
    return query;
  }

}
