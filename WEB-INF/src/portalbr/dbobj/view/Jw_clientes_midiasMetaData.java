package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_midias
  * @version 03/04/2013 09:44:42
  */
public class Jw_clientes_midiasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","marca","80","false","text","","","","","","","",},
                            {"java.lang.String","regional","80","false","text","","","","","","","",},
                            {"java.lang.String","cliente","200","false","text","","","","","","","",},
                            {"java.lang.String","cnpj","22","false","text","","","","","","","",},
                            {"java.lang.String","inscricao_estadual","18","false","text","","","","","","","",},
                            {"java.lang.String","fone","83","false","text","","","","","","","",},
                            {"java.lang.String","endereco","200","false","text","","","","","","","",},
                            {"java.lang.String","ecl_cep","8","false","text","","","","","","","",},
                            {"java.lang.String","bairro_cidade_estado","200","false","text","","","","","","","",},
                            {"java.lang.String","codigo_marca","22","false","text","","","","","","","",},
                            {"java.lang.String","codigo_regional","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT rm.marca_produto || '-' || pck_marcas_produtos.get_nome(rm.marca_produto) marca ,pck_representante.get_regional(cr.codigo_representante) || '-' || pck_regionais_vendas.get_nome(pck_representante.get_regional(cr.codigo_representante)) regional ,cli.cli_cdgo || ' - ' || ecl.esc_seqn || '/' || LTRIM(cli.cli_rzao) cliente ,esc.esc_cgc cnpj ,esc.esc_inse inscricao_estadual ,'(' || f.ffs_ddd2 || ') ' || f.ffs_nmro2 fone ,ecl.ecl_nome || ', ' || ecl.ecl_nmro || ' - ' || ecl.ecl_cpto endereco ,ecl.ecl_cep ,ecl.ecl_bair || ' - ' || ecl.ecl_cdad || '/' || ecl.est_unifed bairro_cidade_estado ,rm.marca_produto codigo_marca ,pck_representante.get_regional(cr.codigo_representante) codigo_regional  FROM cli  ,esc  ,ecl  ,fax_fon2 f  ,cliente_representante cr  ,representante_marca rm  ,brio.ecl_midia e   WHERE cr.codigo_cliente = esc.cli_cdgo  AND cr.codigo_sequencial = esc.esc_seqn  AND cr.codigo_cliente = ecl.cli_cdgo  AND cr.codigo_sequencial = ecl.esc_seqn  AND cr.codigo_cliente = cli.cli_cdgo  AND cli.cli_cdgo = esc.cli_cdgo  AND esc.cli_cdgo = ecl.cli_cdgo  AND esc.esc_seqn = ecl.esc_seqn  AND f.cli_cdgo(+) = ecl.cli_cdgo  AND f.esc_seqn(+) = ecl.esc_seqn  AND f.ned_cdgo(+) = ecl.ned_cdgo  AND rm.codigo_representante = cr.codigo_representante  AND e.codigo_marca = rm.marca_produto  AND e.codigo_regional = pck_representante.get_regional(cr.codigo_representante)  AND e.codigo_cliente = cli.cli_cdgo  AND e.codigo_sequencial = esc.esc_seqn";
    return query;
  }

}
