package portalbr.dbobj.view;

/** DataBase Object from table .Jw_item_pedido
  * @version 04/03/2019 17:00:16
  */
public class Jw_item_pedidoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","linha","4000","false","text","Linha","","","","","","",},
                            {"java.lang.String","referencia","4000","false","text","Referencia","","","","","","",},
                            {"java.lang.String","cabedal","4000","false","text","Cabedal","","","","","","",},
                            {"java.lang.String","cor","4000","false","text","Cor","","","","","","",},
                            {"int","sequencial","22","false","text","Sequencial","","","","","","",},
                            {"int","codigo_linha","-105","false","text","Codigo_linha","","","","","","",},
                            {"int","codigo_referencia","-105","false","text","Codigo_referencia","","","","","","",},
                            {"int","codigo_cabedal","-105","false","text","Codigo_cabedal","","","","","","",},
                            {"int","codigo_cor","-105","false","text","Codigo_cor","","","","","","",},
                            {"int","ped_nmro","-105","false","text","Pedido","","","","","","",},
                            {"java.lang.String","descricao_item","2000","false","text","Descricao_item","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select pck_linha.get_nome(i.lin_cdgo) AS linha,       pck_referencia.get_nome(i.lin_cdgo, i.ref_cdgo) AS referencia,       pck_cabedal.get_nome(i.cab_cdgo) AS cabedal,       pck_cor.get_nome(i.cor_cdgo) AS cor,       i.ite_seqn AS sequencial,       i.lin_cdgo AS codigo_linha,       i.ref_cdgo AS codigo_referencia,       i.cab_cdgo AS codigo_cabedal,       i.cor_cdgo AS codigo_cor,       p.ped_nmro,       'Ref: ' || i.lin_cdgo || '.' || i.ref_cdgo || '.' || i.cab_cdgo || ' - ' || i.cor_cdgo ||' '|| i.ite_descricao || ', COR ' || pck_cor.get_nome(i.cor_cdgo) AS descricao_item  from ite i, ped p where i.ped_nmro = p.ped_nmro";
    return query;
  }

}
