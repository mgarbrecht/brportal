package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ac_cliente_dados2
  * @version 03/04/2013 09:54:38
  */
public class Jw_ac_cliente_dados2MetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","cod","22","false","text","cod","","","","","","",},
                            {"java.lang.String","seq","22","false","text","seq","","","","","","",},
                            {"java.lang.String","enome","35","false","text","enome","","","","","","",},
                            {"double","pro","22","false","text","pro","","","","","","",},
                            {"double","valpro","22","false","text","valpro","","","","","","",},
                            {"double","dev","22","false","text","dev","","","","","","",},
                            {"double","vldev","22","false","text","vldev","","","","","","",},
                            {"double","ped_cancel_qtde","22","false","text","ped_cancel_qtde","","","","","","",},
                            {"double","ped_cancel_valor","22","false","text","ped_cancel_valor","","","","","","",},
                            {"double","dev_l","22","false","text","dev_l","","","","","","",},
                            {"double","vdev_l","22","false","text","vdev_l","","","","","","",},
                            {"double","che_l","22","false","text","che_l","","","","","","",},
                            {"double","vche_l","22","false","text","vche_l","","","","","","",},
                            {"double","ch_devol_abertos_qtd","22","false","text","ch_devol_abertos_qtd","","","","","","",},
                            {"double","ch_devol_abertos_saldo","22","false","text","ch_devol_abertos_saldo","","","","","","",},
                            {"double","ch_abertos_qtd","22","false","text","ch_abertos_qtd","","","","","","",},
                            {"double","ch_abertos_vche","22","false","text","ch_abertos_vche","","","","","","",},
                            {"double","qtdtita","22","false","text","qtdtita","","","","","","",},
                            {"double","valtita","22","false","text","valtita","","","","","","",},
                            {"double","vencer_15","22","false","text","vencer_15","","","","","","",},
                            {"double","vvencer_15","22","false","text","vvencer_15","","","","","","",},
                            {"double","vencer15","22","false","text","vencer15","","","","","","",},
                            {"double","vvencer15","22","false","text","vvencer15","","","","","","",},
                            {"double","venc_15","22","false","text","venc_15","","","","","","",},
                            {"double","vvenc_15","22","false","text","vvenc_15","","","","","","",},
                            {"double","venc15","22","false","text","venc15","","","","","","",},
                            {"double","vvenc15","22","false","text","vvenc15","","","","","","",},
                            {"double","pedidos_abertos_qtde","22","false","text","pedidos_abertos_qtde","","","","","","",},
                            {"double","pedidos_abertos_valor","22","false","text","pedidos_abertos_valor","","","","","","",},
                            {"double","cred","22","false","text","cred","","","","","","",},
                            {"double","pedidos","22","false","text","pedidos","","","","","","",},
                            {"double","valor","22","false","text","valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT '' cod       ,'' seq       ,'' enome       ,0.0 pro       ,0.0 valpro       ,0.0 dev       ,0.0 vldev       ,0.0 ped_cancel_qtde       ,0.0 ped_cancel_valor       ,0.0 dev_l       ,0.0 vdev_l       ,0.0 che_l       ,0.0 vche_l       ,0.0 ch_devol_abertos_qtd       ,0.0 ch_devol_abertos_saldo       ,0.0 ch_abertos_qtd       ,0.0 ch_abertos_vche       ,0.0 qtdtita       ,0.0 valtita       ,0.0 vencer_15       ,0.0 vvencer_15       ,0.0 vencer15       ,0.0 vvencer15       ,0.0 venc_15       ,0.0 vvenc_15       ,0.0 venc15       ,0.0 vvenc15       ,0.0 pedidos_abertos_qtde       ,0.0 pedidos_abertos_valor       ,0.0 cred       ,0.0 pedidos       ,0.0 valor   FROM dual";
    return query;
  }

}
