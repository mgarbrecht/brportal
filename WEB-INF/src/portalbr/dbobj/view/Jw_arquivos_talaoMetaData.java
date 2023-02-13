package portalbr.dbobj.view;

/** DataBase Object from table .Jw_arquivos_talao
  * @version 22/09/2016 16:04:19
  */
public class Jw_arquivos_talaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","forn_codigo","22","false","text","forn_codigo","","","","","","",},
                            {"java.lang.Integer","interface_arq_compra_id","22","false","text","interface_arq_compra_id","","","","","","",},
                            {"java.lang.Integer","oco_numero","22","false","text","oco_numero","","","","","","",},
                            {"java.lang.Integer","rem_nro","22","false","text","rem_nro","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","arquivo_edi","240","false","text","arquivo_edi","","","","","","",},
                            {"java.lang.String","situacao","100","false","text","situacao","","","","","","",},
                            {"java.lang.String","descricao_situacao","240","false","text","descricao_situacao","","","","","","",},
                            {"java.lang.String","forn_razsoc","240","false","text","forn_razsoc","","","","","","",},
                            {"java.sql.Date","data_compra","22","false","text","data_compra","","","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","100","false","text","lin_nome","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT iac.for_codigo forn_codigo                ,iat.interface_arq_compra_id                ,iat.oco_numero                ,iat.rem_nro                ,iat.fil_filial                ,iac.nome_arquivo arquivo_edi                ,(SELECT situacao                   FROM (SELECT situacao                           FROM edi.interface_arq_compra_tal_log i                          where i.interface_arq_compra_id = iat.interface_arq_compra_id                            and i.oco_numero = iat.oco_numero                            and i.rem_nro = iat.rem_nro                          ORDER BY DECODE(situacao, 'P', 1, 'C', 2, 'G', 3, 'V', 4) DESC)                  WHERE rownum = 1) situacao                ,DECODE(iat.situacao, 'P', 'Publicado', 'C', 'Consultado', 'G', 'Gerado', 'V','Visualizado', '') descricao_situacao                ,pck_fornecedor.get_nome(iac.for_codigo) forn_razsoc				,null data_compra				,iat.lin_cdgo				,iat.lin_nome   FROM interface_arq_compra_tal iat       ,interface_arq_compra     iac  WHERE iac.interface_arq_compra_id = iat.interface_arq_compra_id    AND NVL(iac.ativo, NULL) = 'S'    AND NVL(iac.tipo, NULL) = 'T'";
    return query;
  }

}
