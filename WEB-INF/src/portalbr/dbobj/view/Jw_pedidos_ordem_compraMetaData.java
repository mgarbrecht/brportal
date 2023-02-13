package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedidos_ordem_compra
  * @version 24/08/2016 15:13:39
  */
public class Jw_pedidos_ordem_compraMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","NUMERO","22","false","text","","","","","","","",},
                            {"java.lang.String","CLIENTE","4000","false","text","","","","","","","",},
                            {"java.lang.String","SEQUENCIAL","10","false","text","","","","","","","",},
                            {"java.lang.Integer","GRUPO","22","false","text","","","","","","","",},
                            {"java.lang.String","OC","20","false","text","","","","","","","",},
                            {"java.lang.String","CLI_RZAO","4000","false","text","","","","","","","",},
                            {"java.lang.String","NOME_GRUPO","4000","false","text","","","","","","","",},
                            {"java.lang.String","REP_CDGO","20","false","text","","","","","","","",},
                            {"java.lang.String","REGIONAL","20","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT ped.ped_nmro numero        ,ped.cli_cdgo cliente		,ped.esc_seqn sequencial        ,pck_cliente.get_grupo_economico(ped.cli_cdgo) grupo        ,ped.ped_ped_cliente oc		,pck_cliente.get_nome(ped.cli_cdgo) cli_rzao		,pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(ped.cli_cdgo)) nome_grupo		,ped.rep_cdgo        ,pck_representante.get_regional(ped.rep_cdgo) regional    FROM ped   WHERE ped.ped_stat NOT IN ('C', 'F')";
    return query;
  }

}
