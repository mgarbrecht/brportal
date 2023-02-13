package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_titulos_registros
  * @version 03/04/2013 09:32:12
  */
public class Jw_consulta_titulos_registrosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","tit_datven3","22","false","text","tit_datven3","","","","","","",},
                            {"double","w_tit_dsante","22","false","text","w_tit_dsante","","","","","","",},
                            {"double","w_tit_dspont","22","false","text","w_tit_dspont","","","","","","",},
                            {"double","w_tit_vljuro","22","false","text","w_tit_vljuro","","","","","","",},
                            {"double","w_tit_abatim","22","false","text","w_tit_abatim","","","","","","",},
                            {"java.lang.String","w_cobjur","1","false","text","w_cobjur","","","","","","",},
                            {"java.lang.String","w_condes","1","false","text","w_condes","","","","","","",},
                            {"java.sql.Timestamp","w_datvenc","22","false","text","w_datvenc","","","","","","",},
                            {"double","w_dif","22","false","text","w_dif","","","","","","",},
                            {"java.sql.Timestamp","w_mov_data","22","false","text","w_mov_data","","","","","","",},
                            {"java.lang.String","w_trn_codigo","3","false","text","w_trn_codigo","","","","","","",},
                            {"java.lang.String","titulo","8","false","text","titulo","","","","","","",},
                            {"java.lang.String","status","9","false","text","status","","","","","","",},
                            {"java.lang.String","ncc","3","false","text","ncc","","","","","","",},
                            {"java.lang.String","nf","44","false","text","nf","","","","","","",},
                            {"java.lang.String","desc_sit","30","false","text","desc_sit","","","","","","",},
                            {"java.lang.String","tp","3","false","text","tp","","","","","","",},
                            {"java.sql.Timestamp","dt_venc","22","false","text","dt_venc","","","","","","",},
                            {"java.sql.Timestamp","liquid","22","false","text","liquid","","","","","","",},
                            {"java.sql.Date","tit_datemi","12","false","text","tit_datemi","","","","","","",},
                            {"double","tit_dspont","26","false","text","tit_dspont","","","","","","",},
                            {"double","tit_dsante","26","false","text","tit_dsante","","","","","","",},
                            {"double","valor","22","false","text","valor","","","","","","",},
                            {"double","saldo","22","false","text","saldo","","","","","","",},
                            {"java.lang.String","portador","30","false","text","portador","","","","","","",},
                            {"java.lang.String","prt_codigo","4","false","text","prt_codigo","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.Integer","nr_nota","22","false","text","nr_nota","","","","","","",},
                            {"java.lang.String","nr_serie","3","false","text","nr_serie","","","","","","",},
                            {"java.sql.Timestamp","data_atual","22","false","text","data_atual","","","","","","",},
                            {"java.lang.String","representante","38","false","text","representante","","","","","","",},
                            {"java.lang.String","ped_nmro","22","false","text","ped_nmro","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT TRUNC(SYSDATE) tit_datven3      ,0 w_tit_dsante      ,0 w_tit_dspont      ,0 w_tit_vljuro      ,0 w_tit_abatim      ,'' w_cobjur      ,'' w_condes      ,SYSDATE w_datvenc      ,0 w_dif      ,SYSDATE w_mov_data      ,'' w_trn_codigo      ,'' titulo      ,'' status      ,'' ncc      ,'' nf      ,'' desc_sit      ,'' tp      ,SYSDATE dt_venc      ,SYSDATE liquid      ,SYSDATE tit_datemi      ,0 tit_dspont      ,0 tit_dsante      ,0 valor      ,0 saldo      ,'' portador      ,'' prt_codigo      ,'' emp_empresa      ,'' fil_filial      ,0 nr_nota      ,'' nr_serie      ,TO_DATE(SYSDATE) data_atual      ,'' representante      ,'' ped_nmro  FROM dual";
    return query;
  }

}
