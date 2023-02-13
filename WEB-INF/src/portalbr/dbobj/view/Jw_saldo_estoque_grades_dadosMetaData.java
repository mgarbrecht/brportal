package portalbr.dbobj.view;

/** DataBase Object from table .Jw_saldo_estoque_grades_dados
  * @version 03/04/2013 09:11:40
  */
public class Jw_saldo_estoque_grades_dadosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","10","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","fil_filial","10","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","unn_codigo","10","false","text","unn_codigo","","","","","","",},
                            {"double","les_codigo","22","false","text","les_codigo","","","","","","",},
                            {"java.lang.String","dsp_les_codigo","10","false","text","dsp_les_codigo","","","","","","",},
                            {"double","tes_codigo","22","false","text","tes_codigo","","","","","","",},
                            {"double","tco_codigo","22","false","text","tco_codigo","","","","","","",},
                            {"double","gde_codigo","22","false","text","gde_codigo","","","","","","",},
                            {"double","gde_tota","22","false","text","gde_tota","","","","","","",},
                            {"double","caixas","22","false","text","caixas","","","","","","",},
                            {"double","quantidade","22","false","text","quantidade","","","","","","",},
                            {"java.lang.String","tes_descricao","10","false","text","tes_descricao","","","","","","",},
                            {"java.lang.String","tco_descricao","10","false","text","tco_descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' EMP_EMPRESA,  '' FIL_FILIAL,  '' UNN_CODIGO,  0 LES_CODIGO,  '' DSP_LES_CODIGO,  0 TES_CODIGO,  0 TCO_CODIGO,  0 GDE_CODIGO,  0 GDE_TOTA,  0 CAIXAS,  0 QUANTIDADE,  '' tes_descricao,  '' tco_descricao  FROM DUAL";
    return query;
  }

}
