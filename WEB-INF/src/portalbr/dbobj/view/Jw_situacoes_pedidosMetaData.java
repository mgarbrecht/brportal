package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacoes_pedidos
  * @version 03/04/2013 09:09:34
  */
public class Jw_situacoes_pedidosMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.util.Date","dat","22","false","text","dat","","","","","","",},
                            {"java.lang.String","trn","3","false","text","trn","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select mov_data dat, trn_codigo trn from mov_receber where emp_empresa='01' and fil_filial='16' and tip_codigo='1' and tit_codigo='1' and trn_codigo='DIS' and nvl(mov_sequencia,0)=0 and rownum=1";
    return query;
  }

}
