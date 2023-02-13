package portalbr.dbobj.view;

/** DataBase Object from table .Jw_retorna_sigla_trans
  * @version 03/04/2013 09:12:33
  */
public class Jw_retorna_sigla_transMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","SIGLA_FILIAL_TRANSP","20","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT tm.sigla_filial_transp   FROM nf_saida ns       ,ecl c       ,transportadoras_municipios tm       ,municipios m  WHERE ns.cli_cdgo = c.cli_cdgo    AND ns.esc_seqn = c.esc_seqn    AND tm.cod_municipio = m.codigo    AND c.ecl_cdad = m.descricao";
    return query;
  }

}
