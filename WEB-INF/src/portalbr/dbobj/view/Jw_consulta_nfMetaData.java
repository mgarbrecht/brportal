package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_nf
  * @version 03/04/2018 16:07:02
  */
public class Jw_consulta_nfMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","nmro_serie","46","false","text","nmro_serie","","","","","","",},
                            {"java.lang.String","empresa","56","false","text","empresa","","","","","","",},
                            {"java.lang.String","filial","57","false","text","filial","","","","","","",},
                            {"java.lang.String","cliente","119","false","text","cliente","","","","","","",},
                            {"java.lang.String","status","63","false","text","status","","","","","","",},
                            {"java.sql.Timestamp","data_emissao","12","false","text","data_emissao","","","","","","",},
                            {"java.lang.String","valor_total","43","false","text","valor_total","","","","","","",},
                            {"double","requisicao","22","false","text","requisicao","","","","","","",},
                            {"java.lang.String","rep","43","false","text","rep","","","","","","",},
                            {"java.lang.String","comissao","41","false","text","comissao","","","","","","",},
                            {"java.lang.String","transportadora","78","false","text","transportadora","","","","","","",},
                            {"java.lang.String","bonif1","41","false","text","bonif1","","","","","","",},
                            {"java.lang.String","bonif2","41","false","text","bonif2","","","","","","",},
                            {"java.lang.String","desc_pont","41","false","text","desc_pont","","","","","","",},
                            {"double","peso_bruto","25","false","text","peso_bruto","","","","","","",},
                            {"double","peso_liq","25","false","text","peso_liq","","","","","","",},
                            {"java.lang.Integer","cs","22","false","text","cs","","","","","","",},
                            {"java.lang.String","cons_desc","40","false","text","cons_desc","","","","","","",},
                            {"java.lang.String","prt_codigo","4","false","text","prt_codigo","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"double","nfs_icms","24","false","text","nfs_icms","","","","","","",},
                            {"double","nfs_valicm","26","false","text","nfs_valicm","","","","","","",},
                            {"java.lang.String","nfs_qtdvol","22","false","text","nfs_qtdvol","","","","","","",},
                            {"java.lang.String","chave_nfe","100","false","text","chave_nfe","","","","","","",},
                            {"java.lang.Integer","natoper_codigo","22","false","text","natoper_codigo","","","","","","",},
                            {"java.lang.String","descricao_natureza_operacao","240","false","text","descricao_natureza_operacao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' nmro_serie      ,'' empresa      ,'' filial      ,'' cliente      ,'' status      ,sysdate data_emissao      ,'' valor_total      ,0 requisicao      ,'' rep      ,'' comissao      ,'' transportadora      ,'' bonif1      ,'' bonif2      ,'' desc_pont      ,0 peso_bruto      ,0 peso_liq      ,0 cs      ,'' cons_desc      ,'' prt_codigo      ,'' nfs_serie      ,0 nfs_icms      ,0 nfs_valicm      ,'' nfs_qtdvol	  ,'' chave_nfe	  ,0 natoper_codigo	  ,'' descricao_natureza_operacao  FROM dual";
    return query;
  }

}
