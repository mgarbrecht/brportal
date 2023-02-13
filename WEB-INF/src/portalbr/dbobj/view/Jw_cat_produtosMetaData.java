package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cat_produtos
  * @version 19/05/2020 14:39:40
  */
public class Jw_cat_produtosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","marca","22","false","text","marca","","","","","","",},
                            {"java.lang.Integer","linha","22","false","text","linha","","","","","","",},
                            {"java.lang.Integer","referencia","22","false","text","referencia","","","","","","",},
                            {"java.lang.Integer","cabedal","22","false","text","cabedal","","","","","","",},
                            {"java.lang.Integer","cor","22","false","text","cor","","","","","","",},
                            {"java.lang.String","imagem","200","false","text","imagem","","","","","","",},
                            {"java.lang.String","venda_exportacao","10","false","text","venda_exportacao","","","","","","",},
                            {"java.lang.String","categoria_produto","240","false","text","categoria_produto","","","","","","",},
                            {"java.lang.String","descricao_categoria_produto","240","false","text","descricao_categoria_produto","","","","","","",},
                            {"java.lang.Integer","tipo","22","false","text","tipo","","","","","","",},
                            {"java.lang.String","descricao_tipo","240","false","text","descricao_tipo","","","","","","",},
                            {"java.lang.String","descricao_produto","400","false","text","descricao_produto","","","","","","",},
                            {"java.lang.String","descricao_cabedal","400","false","text","descricao_cabedal","","","","","","",},
                            {"java.lang.String","descricao_cor","400","false","text","descricao_cor","","","","","","",},
                            {"java.lang.Integer","sequencial_angulo","22","false","text","sequencial_angulo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT marca       ,linha       ,referencia       ,cabedal       ,cor       ,replace(imagem,'jpg','gif') imagem       ,cpt.venda_exportacao       ,cpt.categoria_produto       ,cpt.descricao_categoria_produto       ,cpt.tipo       ,cpt.descricao_tipo       ,cpt.descricao_produto	   ,cpt.descricao_cabedal	   ,cpt.descricao_cor	   ,sequencial_angulo   FROM cat_produtos_table cpt  WHERE codigo_idioma = 3  ORDER BY marca          ,linha          ,referencia          ,cabedal          ,cor";
    return query;
  }

}
