package portalbr.dbobj.view;

/** DataBase Object from table .Jw_gerente_regional
  * @version 03/04/2013 09:27:42
  */
public class Jw_gerente_regionalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","gerente","83","false","text","gerente","","","","","","",},
                            {"java.lang.String","regional","83","false","text","regional","","","","","","",},
                            {"java.lang.String","codigo_gerente","22","false","text","codigo_gerente","","","","","","",},
                            {"java.lang.String","codigo_regional","22","false","text","codigo_regional","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT g.codigo_gerente||' - '||nome_gerente gerente,r.codigo_regional||' - '||r.nome_regional regional, g.codigo_gerente,r.codigo_regional,re.rep_cdgo FROM gerentes_regionais_vendas g, regionais_vendas r, rep re WHERE r.codigo_regional=g.codigo_regional AND re.codigo_regional=r.codigo_regional AND g.codigo_gerente>0 AND g.codigo_regional> 0 AND g.situacao_gerente='A' AND ROWNUM=1";
    return query;
  }

}
