package portalbr.dbobj.view;

/** DataBase Object from table .Jw_kanban_clientes_novos
  * @version 03/04/2013 09:26:52
  */
public class Jw_kanban_clientes_novosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cnpj","15","false","text","cnpj","","","","","","",},
                            {"java.lang.Integer","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","sigla_regional","100","false","text","sigla_regional","","","","","","",},
                            {"java.lang.String","situacao","10","false","text","situacao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT cnpj       ,codigo_regional       ,sigla_regional        ,CASE         WHEN (trunc(SYSDATE - dt_inclusao) < 3) THEN          'VERDE'         WHEN (trunc(SYSDATE - dt_inclusao) BETWEEN 3 AND 5) THEN          'AMARELO'         WHEN (trunc(SYSDATE - dt_inclusao) > 5) THEN          'VERMELHO'       END situacao   FROM webstore.wt_cliente_kanban_vw@sadig  WHERE atendido = 'N'";
    return query;
  }

}
