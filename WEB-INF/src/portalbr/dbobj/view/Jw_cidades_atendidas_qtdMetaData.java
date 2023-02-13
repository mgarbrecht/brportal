package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cidades_atendidas_qtd
  * @version 27/05/2014 15:49:25
  */
public class Jw_cidades_atendidas_qtdMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cidades_atendidas_qtd","22","false","text","cidades_atendidas_qtd","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT COUNT(DISTINCT cidade) cidades_atendidas_qtd   FROM (SELECT DISTINCT (ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade           FROM resumo_ped res               ,ecl               ,cli               ,rep               ,cliente_representante clr               ,representante_marca rm          WHERE res.rep_cdgo = NVL(NULL, res.rep_cdgo)            AND res.data_dig >= TO_DATE('01/01/2006', 'dd/MM/yyyy')            AND res.data_dig < TO_DATE('31/08/2006', 'dd/MM/yyyy') + 1            AND res.lin_cdgo = NVL(NULL, res.lin_cdgo)            AND res.codigo_marca = NVL(NULL, res.codigo_marca)            AND ecl.cli_cdgo = res.cli_cdgo            AND cli.cli_cdgo = res.cli_cdgo            AND rep.rep_cdgo = res.rep_cdgo            AND clr.codigo_cliente = cli.cli_cdgo            AND rm.codigo_representante = rep.rep_cdgo            AND clr.codigo_representante = rep.rep_cdgo            AND clr.codigo_sequencial = res.esc_seqn            AND rm.marca_produto = res.codigo_marca            AND res.rep_cdgo = NVL(NULL, res.rep_cdgo)            AND rm.marca_produto = NVL(NULL, rm.marca_produto)            AND res.codigo_regional = NVL(4, res.codigo_regional)            AND ecl.ned_cdgo IN ('COB', 'UNI')            AND ecl.esc_seqn = res.esc_seqn            AND cli.cli_situ = NVL('A',cli.cli_situ)            AND rm.situacao = 'A'            AND rep.rep_situ = 'A'         UNION         SELECT DISTINCT (ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade           FROM resumo_pedidos res               ,ecl               ,cli               ,rep               ,cliente_representante clr               ,representante_marca rm          WHERE res.rep_cdgo = NVL(NULL, res.rep_cdgo)            AND res.data_dig >= TO_DATE('01/01/2006', 'dd/MM/yyyy')            AND res.data_dig < TO_DATE('31/08/2006', 'dd/MM/yyyy') + 1            AND res.lin_cdgo = NVL(NULL, res.lin_cdgo)            AND res.codigo_marca = NVL(NULL, res.codigo_marca)            AND ecl.cli_cdgo = res.cli_cdgo            AND cli.cli_cdgo = res.cli_cdgo            AND rep.rep_cdgo = res.rep_cdgo            AND clr.codigo_cliente = cli.cli_cdgo            AND clr.codigo_representante = rep.rep_cdgo            AND clr.codigo_sequencial = res.esc_seqn            AND rm.codigo_representante = rep.rep_cdgo            AND ecl.ned_cdgo IN ('COB', 'UNI')            AND ecl.esc_seqn = res.esc_seqn            AND rm.marca_produto = res.codigo_marca            AND res.rep_cdgo = NVL(NULL, res.rep_cdgo)            AND rm.marca_produto = NVL(NULL, rm.marca_produto)            AND res.codigo_regional = NVL(4, res.codigo_regional)            AND cli.cli_situ = NVL('A',cli.cli_situ)            AND rm.situacao = 'A'            AND rep.rep_situ = 'A')";
    return query;
  }

}
