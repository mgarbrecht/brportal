package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ac_cliente
  * @version 16/05/2014 08:32:10
  */
public class Jw_ac_clienteMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cod","22","false","text","cod","","","","","","",},
                            {"java.lang.String","seq","22","false","text","seq","","","","","","",},
                            {"java.lang.String","enome","35","false","text","enome","","","","","","",},
                            {"java.lang.String","cnpj","19","false","text","cnpj","","","","","","",},
                            {"java.lang.String","desc_bloqueio","120","false","text","desc_bloqueio","","","","","","",},
                            {"java.lang.String","contador","22","false","text","contador","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT c.cli_cdgo cod      ,e.esc_seqn seq      ,cli_rzao enome      ,SUBSTR(TO_CHAR(e.esc_cgc, '00000000000000'), 0, 3) || '.' || SUBSTR(TO_CHAR(e.esc_cgc, '00000000000000'), 4, 3) || '.' || SUBSTR(TO_CHAR(e.esc_cgc, '00000000000000'), 7, 3) || '/' || SUBSTR(TO_CHAR(e.esc_cgc, '00000000000000'), 10, 4) || '-' || SUBSTR(TO_CHAR(e.esc_cgc, '00000000000000'), 14, 2) cnpj      ,bloqueio.descricao desc_bloqueio      ,grupo_economico.contador  FROM cli c      ,esc e      ,(SELECT 'Cliente Bloqueado - Código ' || bloq.blo_codigo_bloqueio || ' - ' || blo_descricao_bloqueio descricao              ,cli_cdgo          FROM bloqueio bloq              ,cli_bloqueio cli_bloq         WHERE NVL(data_inclusao, NULL) = (SELECT MAX(cb.data_inclusao)                                             FROM cli_bloqueio cb                                            WHERE cb.cli_cdgo = 6678                                              AND blo_codigo_bloqueio <> 999)           AND bloq.blo_codigo_bloqueio = cli_bloq.blo_codigo_bloqueio           AND bloq.blo_codigo_bloqueio <> 999           AND cli_bloq.cli_cdgo = 6678) bloqueio      ,(SELECT DECODE(COUNT(1), 0, 0, 1) contador          FROM cli              ,ecl              ,grupo_economico ge         WHERE cli.cli_cdgo = ge.cli_cdgo           AND ecl.cli_cdgo = cli.cli_cdgo           AND ge.gre_grupo = (SELECT MIN(gre_grupo)                                 FROM grupo_economico                                WHERE cli_cdgo = 6678)           AND cli.cli_cdgo = 6678) grupo_economico WHERE c.cli_cdgo = 6678   AND bloqueio.cli_cdgo(+) = c.cli_cdgo   AND c.cli_cdgo = e.cli_cdgo   AND ROWNUM = 1";
    return query;
  }

}
