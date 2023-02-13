package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Tra
  * @version 03/04/2013 09:06:35
  */
public class TraMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"TRA_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "TRA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","tra_cdgo","22","true","text","Tra_cdgo","","","true","","","",},
                            {"java.lang.String","via_cdgo","1","true","text","Via_cdgo","","","","","","",},
                            {"java.lang.String","tra_nome","35","true","text","Tra_nome","","","","","","",},
                            {"java.lang.String","tra_rzao","35","true","text","Tra_rzao","","","","","","",},
                            {"int","tra_cuba","3","false","text","Tra_cuba","","","true","","","",},
                            {"double","tra_fret","6","false","text","Tra_fret","","","true","","","",},
                            {"double","tra_vlrs","13","false","text","Tra_vlrs","","","true","","","",},
                            {"java.lang.String","tra_segt","1","false","text","Tra_segt","","","","","","",},
                            {"java.lang.String","tra_situacao","1","false","text","Tra_situacao","","","","","","",},
                            {"int","tra_corte","4","false","text","Tra_corte","","","true","","","",},
                            {"int","tra_seq_arq","22","false","text","Tra_seq_arq","","","true","","","",},
                            {"java.lang.String","tra_end_postal","30","false","text","Tra_end_postal","","","","","","",},
                            {"int","for_codigo","9","false","text","For_codigo","","","true","","","",},
                            {"int","fen_seq","4","false","text","Fen_seq","","","true","","","",},
                            {"java.lang.String","cd_enti","9","false","text","Cd_enti","","","","","","",},
                            {"java.lang.String","cd_tipo","1","false","text","Cd_tipo","","","","","","",},
                            {"java.lang.String","codi_tipo_ender","3","false","text","Codi_tipo_ender","","","","","","",},
                            {"java.lang.String","tra_emite_ean128","1","false","text","Tra_emite_ean128","","","","","","",},
                            {"java.lang.String","tra_observacao","255","false","text","Tra_observacao","","","","","","",},
                            {"java.lang.String","tra_avalia_performance","1","false","text","Tra_avalia_performance","","","","","","",},
                            {"java.lang.String","tra_trans_consig","1","false","text","Tra_trans_consig","","","","","","",},
                            {"int","exportado","1","false","text","Exportado","","","true","","","",},
                            {"java.lang.String","ativo","1","false","text","Ativo","","","","","","",}
                          };
    return metadata;
  }

}
