package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_pedidos_atual_datas
  * @version 03/03/2022 17:42:30
  */
public class Jw_entrada_pedidos_atual_datasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","dia_anterior","10","false","text","dia_anterior","","","","","","",},
                            {"java.lang.String","dia_atual","10","false","text","dia_atual","","","","","","",},
                            {"java.lang.String","mes","3","false","text","mes","","","","","","",},
                            {"java.lang.String","semana_atual","10","false","text","semana_atual","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT to_char(NVL((SELECT sem.data_mapa              FROM semanas sem             WHERE data = (SELECT sem.data_mapa                             FROM semanas sem                            WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) - 1), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END) - 1),'dd/mm/yyyy') dia_anterior       ,to_char(NVL((SELECT sem.data_mapa              FROM semanas sem             WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)), TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)),'dd/mm/yyyy') dia_atual       ,'MÊS' mes       ,(SELECT sem.semana              FROM semanas sem             WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) semana_atual   FROM dual";
    return query;
  }

}
