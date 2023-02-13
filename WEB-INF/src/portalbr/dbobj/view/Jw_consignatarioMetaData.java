package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consignatario
  * @version 20/05/2014 08:28:52
  */
public class Jw_consignatarioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","tra_cdgo","22","false","text","tra_cdgo","","","","","","",},
                            {"java.lang.String","via_cdgo","1","false","text","via_cdgo","","","","","","",},
                            {"java.lang.String","tra_nome","35","false","text","tra_nome","","","","","","",},
                            {"java.lang.String","tra_rzao","35","false","text","tra_rzao","","","","","","",},
                            {"java.lang.Integer","tra_cuba","22","false","text","tra_cuba","","","","","","",},
                            {"double","tra_fret","24","false","text","tra_fret","","","","","","",},
                            {"double","tra_vlrs","24","false","text","tra_vlrs","","","","","","",},
                            {"java.lang.String","tra_segt","1","false","text","tra_segt","","","","","","",},
                            {"java.lang.String","tra_situacao","1","false","text","tra_situacao","","","","","","",},
                            {"java.lang.Integer","tra_corte","22","false","text","tra_corte","","","","","","",},
                            {"java.lang.Integer","tra_seq_arq","22","false","text","tra_seq_arq","","","","","","",},
                            {"java.lang.String","tra_end_postal","30","false","text","tra_end_postal","","","","","","",},
                            {"java.lang.Integer","for_codigo","22","false","text","for_codigo","","","","","","",},
                            {"java.lang.Integer","fen_seq","22","false","text","fen_seq","","","","","","",},
                            {"java.lang.String","cd_enti","9","false","text","cd_enti","","","","","","",},
                            {"java.lang.String","cd_tipo","1","false","text","cd_tipo","","","","","","",},
                            {"java.lang.String","codi_tipo_ender","3","false","text","codi_tipo_ender","","","","","","",},
                            {"java.lang.String","tra_emite_ean128","1","false","text","tra_emite_ean128","","","","","","",},
                            {"java.lang.String","tra_observacao","255","false","text","tra_observacao","","","","","","",},
                            {"java.lang.String","tra_avalia_performance","1","false","text","tra_avalia_performance","","","","","","",},
                            {"java.lang.String","tra_trans_consig","1","false","text","tra_trans_consig","","","","","","",},
                            {"java.lang.Integer","exportado","22","false","text","exportado","","","","","","",},
                            {"java.lang.String","ativo","1","false","text","ativo","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","22","false","text","dthr_inclusao","","","","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","22","false","text","dthr_alteracao","","","","","","",},
                            {"java.lang.String","usuario_inclusao","30","false","text","usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","usuario_alteracao","","","","","","",},
                            {"java.lang.String","tra_tipops","1","false","text","tra_tipops","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT *   FROM tra  WHERE tra_trans_consig = 'S'";
    return query;
  }

}
