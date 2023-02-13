package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ref_mix
  * @version 19/10/2022 14:55:14
  */
public class Jw_ref_mixMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","codigo_marca","22","false","text","codigo_marca","","","","","","",},
                            {"java.lang.String","descricao_marca","240","false","text","descricao_marca","","","","","","",},
                            {"java.lang.String","mix","24","false","text","mix","","","","","","",},
                            {"java.lang.String","descricao_mix","40","false","text","descricao_mix","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT lin_cdgo      , ref_cdgo      , codigo_marca      , descricao_marca      , mix      , case when mix = 'M' then 'MIX' else 'FORA MIX' end descricao_mix  FROM (SELECT r.lin_cdgo             , r.ref_cdgo             , r.codigo_marca             , mp.descricao_marca             , nvl((SELECT DISTINCT 'M' status                      FROM ref_cor_mix rc                     WHERE data_posicao = trunc(sysdate)                       AND rc.lin_cdgo = r.lin_cdgo                       AND rc.ref_cdgo = r.ref_cdgo                       AND rc.rfc_status = 'A')               ,'F') mix          FROM ref r             , marcas_produtos mp         WHERE r.codigo_marca = mp.codigo_marca)    ORDER BY lin_cdgo           , ref_cdgo";
    return query;
  }

}
