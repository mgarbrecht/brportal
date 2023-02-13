package portalbr.dbobj.view;

/** DataBase Object from table .Jw_prazos_municipios
  * @version 20/11/2013 14:01:00
  */
public class Jw_prazos_municipiosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id","22","false","text","id","","","","","","",},
                            {"java.lang.String","est_unifed","2","false","text","est_unifed","","","","","","",},
                            {"java.lang.String","est_descri","60","false","text","est_descri","","","","","","",},
                            {"java.lang.Integer","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","descricao","120","false","text","descricao","","","","","","",},
                            {"java.lang.String","distrito","120","false","text","distrito","","","","","","",},
                            {"java.lang.String","codigo_ibge","20","false","text","codigo_ibge","","","","","","",},
                            {"java.lang.Integer","prazo_entrega","22","false","text","prazo_entrega","","","","","","",},
                            {"java.lang.String","sigla_transportadora","20","false","text","sigla_transportadora","","","","","","",},
                            {"java.lang.String","segunda","1","false","text","segunda","","","","","","",},
                            {"java.lang.String","terca","1","false","text","terca","","","","","","",},
                            {"java.lang.String","quarta","1","false","text","quarta","","","","","","",},
                            {"java.lang.String","quinta","1","false","text","quinta","","","","","","",},
                            {"java.lang.String","sexta","1","false","text","sexta","","","","","","",},
                            {"java.lang.String","sabado","1","false","text","sabado","","","","","","",},
                            {"java.lang.String","domingo","1","false","text","domingo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT mp.id       ,m.est_unifed       ,e.est_descri       ,m.codigo       ,m.descricao       ,mp.descricao distrito       ,mp.codigo_ibge       ,mp.prazo_entrega       ,mp.sigla_transportadora       ,decode(mp.segunda,'S','X',NULL) segunda       ,decode(mp.terca,'S','X',NULL) terca       ,decode(mp.quarda,'S','X',NULL) quarta       ,decode(mp.quinta,'S','X',NULL) quinta       ,decode(mp.sexta,'S','X',NULL) sexta       ,decode(mp.sabado,'S','X',NULL) sabado       ,decode(mp.domingo,'S','X',NULL) domingo   FROM brio.municipios_prazos mp       ,municipios m       ,estados e  WHERE mp.codigo = m.codigo    AND mp.est_unifed = m.est_unifed    AND mp.est_unifed = e.est_unifed    AND m.est_pais_codigo = 55  ORDER BY descricao, distrito";
    return query;
  }

}
