package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_clientes_nao_atendidos
  * @version 03/04/2013 09:40:21
  */
public class Jw_consulta_clientes_nao_atendidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","cli_cdgo","22","false","text","","","","","","","",},
                            {"int","esc_seqn","22","false","text","","","","","","","",},
                            {"java.lang.String","cli_nome","50","false","text","","","","","","","",},
                            {"java.lang.String","cli_rzao","100","false","text","","","","","","","",},
                            {"java.lang.String","cnpj","20","false","text","","","","","","","",},
                            {"java.lang.String","cidade","50","false","text","","","","","","","",},
                            {"java.lang.String","uf","3","false","text","","","","","","","",},
                            {"java.lang.String","endereco","2000","false","text","","","","","","","",},
                            {"java.sql.Timestamp","cli_dult","12","false","text","","","","","","","",},
                            {"double","limite_credito","22","false","text","","","","","","","",},
                            {"java.lang.String","fone","100","false","text","fone","","","","","","",},
                            {"java.lang.String","esc_email","200","false","text","esc_email","","","","","","",},
                            {"java.lang.String","grupo_economico","200","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT 0 cli_cdgo                 ,0 esc_seqn                 ,'' cli_nome                 ,'' cli_rzao                 ,'' cnpj                 ,'' cidade                 ,'' uf                 ,'' endereco                 ,sysdate cli_dult                 ,0.00 limite_credito				 ,'' fone				 ,'' esc_email				 ,'' grupo_economico    FROM dual";
    return query;
  }

}
