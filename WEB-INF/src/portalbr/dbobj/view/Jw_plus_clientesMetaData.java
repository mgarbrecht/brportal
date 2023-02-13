package portalbr.dbobj.view;

/** DataBase Object from table .Jw_plus_clientes
  * @version 03/04/2013 09:18:34
  */
public class Jw_plus_clientesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","35","false","text","cli_rzao","","","","","","",},
                            {"java.lang.String","cli_nome","35","false","text","cli_nome","","","","","","",},
                            {"java.lang.String","cli_situ","7","false","text","cli_situ","","","","","","",},
                            {"java.lang.String","esc_situacao","7","false","text","esc_situacao","","","","","","",},
                            {"java.sql.Timestamp","cli_dtin","22","false","text","cli_dtin","","dd/MM/yyyy","","","","",},
                            {"java.lang.String","cli_exige_pc","3","false","text","cli_exige_pc","","","","","","",},
                            {"java.lang.String","cli_agrupa_notas","3","false","text","cli_agrupa_notas","","","","","","",},
                            {"java.lang.String","cli_aceita_antecipacao","3","false","text","cli_aceita_antecipacao","","","","","","",},
                            {"java.lang.String","seg_desc","30","false","text","seg_desc","","","","","","",},
                            {"java.lang.String","cgc","18","false","text","cgc","","","","","","",},
                            {"java.lang.String","inscricao","18","false","text","inscricao","","","","","","",},
                            {"java.lang.String","ender","86","false","text","ender","","","","","","",},
                            {"java.lang.String","bairro_cidade","96","false","text","bairro_cidade","","","","","","",},
                            {"java.lang.String","cid_uf","65","false","text","cid_uf","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT C.CLI_CDGO,  E.ESC_SEQN,  C.CLI_RZAO,  C.CLI_NOME,  DECODE(C.CLI_SITU, 'A', 'Ativo', 'I', 'Inativo')CLI_SITU,  DECODE(S.ESC_SITUACAO,'A','Ativo','I','Inativo','F','Fechado')ESC_SITUACAO,  C.CLI_DTIN,  decode(c.cli_exige_pc,'S','Sim','N','Não','')cli_exige_pc,  decode(C.cli_agrupa_notas,'S','Sim','N','Não','')cli_agrupa_notas,  decode(C.cli_aceita_antecipacao,'S','Sim','N','Não','')cli_aceita_antecipacao,  SE.SEG_DESC,  SUBSTR(S.ESC_CGC, 1, 2)||'.'||SUBSTR(S.ESC_CGC, 3, 3)||'.'||  SUBSTR(S.ESC_CGC, 6, 3)||'/'||SUBSTR(S.ESC_CGC, 9, 4)||'-'||  SUBSTR(S.ESC_CGC, 13, 2)CGC,  S.ESC_INSE INSCRICAO,  E.ECL_NOME||', '||E.ECL_NMRO||' - '||  SUBSTR(E.ECL_CEP, 1, 5)||'-'||SUBSTR(E.ECL_CEP, 6, 3)ENDER,  E.ECL_BAIR||' - '||E.ECL_CDAD||'/'||E.EST_UNIFED BAIRRO_CIDADE,  E.ECL_CDAD||' - '||E.EST_UNIFED CID_UF  FROM ECL E, CLI C, ESC S, SEG SE  WHERE E.CLI_CDGO=S.CLI_CDGO AND E.CLI_CDGO=C.CLI_CDGO AND  C.SEG_CDGO=SE.SEG_CDGO AND E.ESC_SEQN=S.ESC_SEQN AND  E.CLI_CDGO=1622 AND E.ESC_SEQN=1 AND (E.NED_CDGO='UNI' OR E.NED_CDGO='ENT')";
    return query;
  }

}
