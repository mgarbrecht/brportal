package portalbr.dbobj.view;

/** DataBase Object from table .Jw_embarque_amostras
  * @version 03/04/2013 09:31:09
  */
public class Jw_embarque_amostrasMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","marca","22","false","text","marca","","","","","","",},
                            {"java.lang.String","descricao_marca","30","false","text","descricao_marca","","","","","","",},
                            {"java.lang.String","tipo_linha","240","false","text","tipo_linha","","","","","","",},
                            {"java.lang.String","ind_aberto_fechado","1","false","text","ind_aberto_fechado","","","","","","",},
                            {"java.lang.String","fil_filial","10","false","text","fil_filial","","","","","","",},
                            {"java.sql.Date","data_embarque","22","false","text","data_embarque","","dd/MM/yyyy","","","","",},
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Double","preco","22","false","text","preco","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT fct_marca_produto(r.lin_cdgo, r.ref_cdgo) marca        ,pck_marcas_produtos.get_nome(fct_marca_produto(r.lin_cdgo, r.ref_cdgo)) descricao_marca        ,cg.rv_meaning tipo_linha             ,l.ind_aberto_fechado             ,fnc_retorna_filial_lin_ref(r.lin_cdgo, r.ref_cdgo) fil_filial             ,r.data_embarque       ,r.lin_cdgo       ,r.ref_cdgo       ,brio.fct_preco_medio_vendor(r.lin_cdgo, r.ref_cdgo) * 2.1 preco   FROM REF r       ,lin l       ,(SELECT * FROM cg_ref_codes where RV_DOMAIN = 'IND_ABERTO_FECHADO' ) cg   WHERE l.lin_cdgo = r.lin_cdgo    AND cg.rv_low_value = l.ind_aberto_fechado";
    return query;
  }

}
