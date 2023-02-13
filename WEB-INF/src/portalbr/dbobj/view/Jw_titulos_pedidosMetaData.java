package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_pedidos
  * @version 05/07/2010 07:06:35
  */
public class Jw_titulos_pedidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","emp_empresa","3","false","text","Empresa","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","Filial","","","","","","",},
                            {"java.lang.String","tip_codigo","3","false","text","Tipo","","","","","","",},
                            {"java.lang.String","tit_codigo","8","false","text","Título","","","","","","",},
                            {"int","ped_nmro","22","false","text","Pedido","","","","","","",},
                            {"java.lang.String","cliente","78","false","text","Cliente","","","","","","",},
                            {"java.lang.String","representante","41","false","text","Representante","","","","","","",},
                            {"java.lang.String","nf","44","false","text","NF","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT         t.emp_empresa      , t.fil_filial      , t.tip_codigo      , t.tit_codigo      , nfv.ped_nmro      , cli.cli_cdgo ||' - '|| nvl(cli.cli_rzao,cli.cli_nome) cliente      , r.rep_cdgo||'-'||nvl(r.rep_rzao,r.rep_nome) representante      , tn.nsa_numero||'-'||tn.nsa_serie nf   FROM titulos t       , rep r      , regionais_vendas rv      , notas_fiscais_saida_ped_venda nfv      , tit_nf tn      , cli   WHERE r.rep_cdgo          =  t.rep_codigo     AND rv.codigo_regional  =  r.codigo_regional     AND tn.emp_empresa      =  t.emp_empresa     AND tn.fil_filial       =  t.fil_filial     AND tn.tip_codigo       =  t.tip_codigo     AND tn.tit_codigo       =  t.tit_codigo     AND cli.cli_cdgo        =  t.cli_codigo     AND nfv.nfs_nmro    (+) =  tn.nsa_numero     AND nfv.nfs_serie   (+) =  tn.nsa_serie     AND nfv.emp_empresa (+) =  tn.emp_empresa     AND nfv.fil_filial  (+) =  tn.fil_filial";
    return query;
  }

}
