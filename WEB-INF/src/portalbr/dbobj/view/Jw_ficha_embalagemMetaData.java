package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_embalagem
  * @version 03/04/2013 09:29:02
  */
public class Jw_ficha_embalagemMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","lin_cdgo","22","false","text","lin_cdgo","","","","","","",},
                            {"java.lang.String","lin_nome","25","false","text","lin_nome","","","","","","",},
                            {"java.lang.Integer","ref_cdgo","22","false","text","ref_cdgo","","","","","","",},
                            {"java.lang.Integer","codigo_corrugado","22","false","text","codigo_corrugado","","","","","","",},
                            {"java.lang.String","descricao_corrugado","30","false","text","descricao_corrugado","","","","","","",},
                            {"java.lang.Integer","mat_nro","22","false","text","mat_nro","","","","","","",},
                            {"java.lang.String","descricao","100","false","text","descricao","","","","","","",},
                            {"java.lang.Double","altura","26","false","text","altura","","","","","","",},
                            {"java.lang.Double","largura","26","false","text","largura","","","","","","",},
                            {"java.lang.Double","comprimento","26","false","text","comprimento","","","","","","",},
                            {"java.lang.Integer","qt_par_corrug","22","false","text","qt_par_corrug","","","","","","",},
                            {"java.lang.Integer","cod_cx_ind","22","false","text","cod_cx_ind","","","","","","",},
                            {"java.lang.String","cod_cx_ind_desc","200","false","text","cod_cx_ind_desc","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT ftec.lin_cdgo                ,l.lin_nome                ,ftec.ref_cdgo                ,ft.codigo codigo_corrugado                ,c.descricao descricao_corrugado                ,ft.mat_nro                ,ies.descricao                ,pc.altura                ,pc.largura                ,pc.comprimento                ,pc.qt_par_corrug                ,comp.mat_nro cod_cx_ind                ,pck_item_estoque.get_nome(comp.mat_nro) cod_cx_ind_desc   FROM ficha_embalagem ft       ,corrugados c       ,ficha_tec ftec       ,componente comp       ,peso_corrugados pc       ,dom_item_estoque ies       ,REF r       ,lin l       ,ref_cor rc       ,cor_compo ccmp  WHERE l.lin_cdgo = ft.lin_cdgo    AND NVL(l.situacao, 'A') = 'A'    AND r.lin_cdgo = ft.lin_cdgo    AND r.ref_cdgo = ft.ref_cdgo    AND ies.codigo = ft.mat_nro    AND c.codigo = ft.codigo    AND c.ativo = 'S'    AND ftec.lin_cdgo = ft.lin_cdgo    AND ftec.ref_cdgo = ft.ref_cdgo    AND comp.lin_cdgo(+) = ftec.lin_cdgo    AND comp.ref_cdgo(+) = ftec.ref_cdgo    AND comp.cab_cdgo(+) = ftec.cab_cdgo    AND comp.fil_filial(+) = ftec.fil_filial    AND comp.fit_versao(+) = ftec.fit_versao    AND comp.cod_peca(+) = 100    AND pc.lin_cdgo(+) = ft.lin_cdgo    AND pc.ref_cdgo(+) = ft.ref_cdgo    AND pc.codigo_corrug(+) = ft.codigo    AND pc.ativo(+) = 'A'    AND ftec.lin_cdgo = 9000    AND ftec.ref_cdgo = 100    AND rc.lin_cdgo = ftec.lin_cdgo    AND rc.ref_cdgo = ftec.ref_cdgo    AND rc.cab_cdgo = ftec.cab_cdgo    AND ccmp.cor_ref = rc.cor_cdgo    AND ccmp.cab_cdgo = rc.cab_cdgo    AND ccmp.ref_cdgo = rc.ref_cdgo    AND ccmp.lin_cdgo = rc.lin_cdgo  ORDER BY ftec.lin_cdgo          ,l.lin_nome          ,ftec.ref_cdgo";
    return query;
  }

}
