package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacoes_pedido
  * @version 03/04/2013 09:09:49
  */
public class Jw_situacoes_pedidoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","dt","75","false","text","dt","","","","","","",},
                            {"java.lang.String","hora","75","false","text","hora","","","","","","",},
                            {"java.lang.String","nome","30","false","text","hora","","","","","","",},
                            {"java.lang.String","descricao","40","false","text","descricao","","","","","","",},
                            {"java.lang.String","obs_sit","400","false","text","obs_sit","","","","","","",},
                            {"java.lang.String","obs_lib","140","false","text","obs_lib","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select to_char(a.dt_cad_situacao,'dd/mm/yyyy')dt, to_char(a.dt_cad_situacao,'hh24:mi')hora, DECODE(b.desc_usuario,null,'Processo Automático',b.desc_usuario)nome, c.descricao_situacao descricao, a.observ_situacao obs_sit, a.observ_liberacao obs_lib from situacoes_pedidos a, dom_usuario b, tipos_situacoes c where a.ts_codigo_situacao=c.codigo_situacao and a.usuario_situacao=b.cod_usuario(+)and a.ped_nmro=3205116";
    return query;
  }

}
