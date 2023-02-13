package portalbr.dbobj.view;

/** DataBase Object from table .Jw_status_pedidos
  * @version 03/06/2019 14:30:09
  */
public class Jw_status_pedidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","status","10","false","text","status","","","","","","",},
                            {"java.lang.String","descricao","40","false","text","descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select 'A' status, 'PEDIDOS ABERTOS' descricao, 1 ordem from dual union  select 'B' status, 'BLOQUEADOS NA DIGITACAO' descricao, 2 ordem from dual UNION select 'C' status, 'PEDIDOS CANCELADOS' descricao, 3 ordem from dual UNION select 'F' status, 'PEDIDOS FATURADOS' descricao, 4 ordem from dual  UNION select 'L' status, 'PEDIDOS LIBERADOS' descricao, 5 ordem from dual UNION select 'P' status, 'BLOQUEADOS NO CREDITO' descricao, 6 ordem from dual UNION select 'PF' status, 'PARCIALMENTE FATURADO' descricao, 7 ordem from dual UNION select 'R' status, 'ANALISE COMERCIAL' descricao, 8 ordem from dual UNION select 'T' status, 'BLOQUEADOS COMERCIAL' descricao, 9 ordem from dual order by ordem";
    return query;
  }

}
