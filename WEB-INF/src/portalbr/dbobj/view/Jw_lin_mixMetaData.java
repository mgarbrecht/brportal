package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lin_mix
  * @version 19/10/2022 15:28:38
  */
public class Jw_lin_mixMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","240","false","text","lin_nome","","","","","","",},
                            {"java.lang.String","mix","24","false","text","mix","","","","","","",},
                            {"java.lang.String","descricao_mix","40","false","text","descricao_mix","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT lin_cdgo      , lin_nome      , mix      , case when mix = 'M' then 'MIX' else 'FORA MIX' end descricao_mix  FROM (SELECT l.lin_cdgo             , l.lin_nome             , nvl((SELECT DISTINCT 'M' status                      FROM ref_cor_mix rc                     WHERE data_posicao = trunc(sysdate)                       AND rc.lin_cdgo = l.lin_cdgo                       AND rc.rfc_status = 'A')               ,'F') mix          FROM lin l)    ORDER BY lin_cdgo";
    return query;
  }

}
