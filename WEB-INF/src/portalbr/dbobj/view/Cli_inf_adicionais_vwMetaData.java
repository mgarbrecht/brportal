package portalbr.dbobj.view;

/** DataBase Object from table .Cli_inf_adicionais_vw
  * @version 19/01/2015 09:56:58
  */
public class Cli_inf_adicionais_vwMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cli_cdgo","22","false","text","cli_cdgo","","","","","","",},
                            {"java.lang.String","cli_rzao","80","false","text","cli_rzao","","","","","","",},
                            {"java.lang.Integer","esc_seqn","22","false","text","esc_seqn","","","","","","",},
                            {"java.lang.Integer","cli_cdgo_sucessor","22","false","text","cli_cdgo_sucessor","","","","","","",},
                            {"java.lang.Integer","esc_seqn_sucessor","22","false","text","esc_seqn_sucessor","","","","","","",},
                            {"java.lang.String","sistema_ri","3","false","text","sistema_ri","","","","","","",},
                            {"java.lang.String","ordem_compra","1","false","text","ordem_compra","","","","","","",},
                            {"java.lang.String","dt_agendamento","1","false","text","dt_agendamento","","","","","","",},
                            {"java.lang.String","horario_entrega","1","false","text","horario_entrega","","","","","","",},
                            {"java.lang.String","senha_entrega","1","false","text","senha_entrega","","","","","","",},
                            {"java.lang.String","data_emissao","1","false","text","data_emissao","","","","","","",},
                            {"java.lang.String","filial","1","false","text","filial","","","","","","",},
                            {"java.lang.String","nf_nmro","1","false","text","nf_nmro","","","","","","",},
                            {"java.lang.String","nro_volumes","1","false","text","nro_volumes","","","","","","",},
                            {"java.lang.String","cliente_mi","3","false","text","cliente_mi","","","","","","",},
                            {"java.lang.String","possui_carimbo","3","false","text","possui_carimbo","","","","","","",},
                            {"java.lang.String","somente_etiqueta","3","false","text","somente_etiqueta","","","","","","",},
                            {"java.lang.Integer","gre_grupo","6","false","text","Grupo Econômico","","","","","","",},
                            {"java.lang.String","gre_descricao","30","false","text","Descrição Grupo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT f.cli_cdgo      ,pck_cliente.get_nome(f.cli_cdgo) cli_rzao      ,f.esc_seqn      ,f.cli_cdgo_sucessor      ,f.esc_seqn_sucessor      ,DECODE(f.sistema_ri, 'S', 'Sim', 'N', 'Não', 'Não') sistema_ri      ,f.ordem_compra      ,f.dt_agendamento      ,f.horario_entrega      ,f.senha_entrega      ,f.data_emissao      ,f.filial_fat filial            ,f.nf_nmro      ,f.nro_volumes      ,DECODE(f.cliente_mi, 'S', 'Sim', 'N', 'Não', 'Não') cliente_mi      ,DECODE(f.possui_carimbo, 'S', 'Sim', 'N', 'Não', 'Não') possui_carimbo      ,DECODE(f.somente_etiqueta, 'S', 'Sim', 'N', 'Não', 'Não') somente_etiqueta      ,pck_cliente.get_grupo_economico(f.cli_cdgo) gre_grupo      ,pck_grupo_economico.get_nome(pck_cliente.get_grupo_economico(f.cli_cdgo)) gre_descricao  FROM cli_inf_adicionais f";
    return query;
  }

}
