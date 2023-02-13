package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cli_inf_adicionais
  * @version 19/01/2015 10:07:35
  */
public class Cli_inf_adicionaisMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"CLI_CDGO","ESC_SEQN"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CLI_INF_ADICIONAIS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cli_cdgo","22","true","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.Integer","esc_seqn","4","true","text","Esc_seqn","","","true","","","",},
                            {"java.lang.Integer","cli_cdgo_sucessor","5","false","text","Cli_cdgo_sucessor","","","true","","","",},
                            {"java.lang.Integer","esc_seqn_sucessor","4","false","text","Esc_seqn_sucessor","","","true","","","",},
                            {"java.lang.String","sistema_ri","1","false","text","Sistema_ri","","","","","","",},
                            {"java.lang.String","ordem_compra","1","false","text","Ordem_compra","","","","","","",},
                            {"java.lang.String","dt_agendamento","1","false","text","Dt_agendamento","","","","","","",},
                            {"java.lang.String","horario_entrega","1","false","text","Horario_entrega","","","","","","",},
                            {"java.lang.String","senha_entrega","1","false","text","Senha_entrega","","","","","","",},
                            {"java.lang.String","data_emissao","1","false","text","Data_emissao","","","","","","",},
                            {"java.lang.String","filial","1","false","text","Filial","","","","","","",},
                            {"java.lang.String","nf_nmro","1","false","text","Nf_nmro","","","","","","",},
                            {"java.lang.String","nro_volumes","1","false","text","Nro_volumes","","","","","","",},
                            {"java.lang.String","cliente_mi","1","false","text","Cliente_mi","","","","","","",},
                            {"java.lang.String","possui_carimbo","1","false","text","Possui_carimbo","","","","","","",},
                            {"java.lang.String","somente_etiqueta","1","false","text","Somente_etiqueta","","","","","","",}
                          };
    return metadata;
  }

}
