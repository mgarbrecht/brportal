package portalbr.dbobj.view;

/** DataBase Object from table .Jw_web_poi_detalhes
  * @version 05/07/2010 07:04:03
  */
public class Jw_web_poi_detalhesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","lin_nome","25","false","text","lin_nome","","","","","","",},
                            {"java.lang.String","fil","4","false","text","fil","","","","","","",},
                            {"java.lang.String","pe","3","false","text","pe","","","","","","",},
                            {"java.lang.String","dt","10","false","text","dt","","","","","","",},
                            {"java.lang.String","dtf","10","false","text","dtf","","","","","","",},
                            {"double","capacidade","22","false","text","capacidade","","","","","","",},
                            {"double","vendido","22","false","text","vendido","","","","","","",},
                            {"java.lang.String","situacao","7","false","text","situacao","","","","","","",},
                            {"double","bloq","22","false","text","bloq","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT l.lin_nome,  t.cod_filial fil,  substr(min(to_char(t.periodo,'099')||to_char(c.data,'DD/MM/YYYY')),02,03)pe ,  substr(min(to_char(t.periodo,'099')||to_char(c.data,'DD/MM/YYYY')),05,10)dt ,  max(to_char(c.data,'DD/MM/YYYY'))dtf,  max(t.capacidade_pares)capacidade ,  max(t.venda_pares)vendido ,  decode(t.situacao,'F','Fechado','Aberto')situacao,  fnc_pares_retidos_credito(to_date(substr(min(to_char(t.periodo,'099')||to_char(c.data,'DD/MM/YYYY')),05,10),'dd/mm/yyyy'), to_date(max(to_char(c.data,'DD/MM/YYYY')),'dd/mm/yyyy'), 288)bloq  from calendarios_semanal c,  lin l,  toneis t  where t.ano=to_number(to_char(c.data,'yyyy'))  and t.periodo=c.periodo  and trunc(c.data)>=trunc(to_date('01/01/2006','dd/mm/yyyy'),'mm')  and trunc(c.data)<=trunc(last_day(to_date('01/01/2006','dd/mm/yyyy')))  and t.cod_empresa='01'  and c.cod_empresa='01'  and t.cod_filial=c.cod_filial  and t.lin_codigo=l.lin_cdgo  and t.lin_codigo=288  and t.ref_codigo=decode(104,null,t.ref_codigo,104)  AND ROWNUM=1  group BY l.lin_nome,  t.cod_filial ,  t.periodo ,  t.situacao";
    return query;
  }

}
