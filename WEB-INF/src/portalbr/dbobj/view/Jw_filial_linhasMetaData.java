package portalbr.dbobj.view;

/** DataBase Object from table .Jw_filial_linhas
  * @version 03/04/2013 09:28:41
  */
public class Jw_filial_linhasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cod_empresa","3","false","text","","","","","","","",},
                            {"java.lang.String","cod_filial","4","false","text","","","","","","","",},
                            {"java.lang.String","lin_codigo","22","false","text","","","","","","","",},
                            {"java.lang.String","ref_codigo","22","false","text","","","","","","","",},
                            {"java.lang.String","fil_razsoc","50","false","text","","","","","","","",},
                            {"java.lang.String","mix","1","false","text","","","","","","","",},
                            {"java.lang.String","ativa","1","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select fl.cod_empresa,        fl.cod_filial,        fl.lin_codigo,        fl.ref_codigo,        fi.fil_razsoc,        brio.fct_mix_produto(fl.lin_codigo, 0) mix,        fl.ativa   from filial_linhas fl, filial fi  where fl.cod_empresa = fi.emp_empresa    and fl.cod_filial = fi.fil_filial";
    return query;
  }

}
