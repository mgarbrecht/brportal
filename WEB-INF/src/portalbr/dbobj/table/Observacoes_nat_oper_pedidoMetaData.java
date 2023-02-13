package portalbr.dbobj.table;

/** DataBase Object from table FAT.Observacoes_nat_oper_pedido
  * @version 30/05/2019 14:33:50
  */
public class Observacoes_nat_oper_pedidoMetaData {

  public static final String SCHEMA = "FAT";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"NUMERO","DATA_FATURAMENTO","NATOPER_CODIGO","PED_NMRO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "OBSERVACOES_NAT_OPER_PEDIDO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Timestamp","data_faturamento","19","true","text","Data_faturamento","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.Integer","numero","10","true","text","Numero","","","true","","","",},
                            {"java.lang.Integer","natoper_codigo","10","true","text","Natoper_codigo","","","true","","","",},
                            {"java.lang.Integer","ped_nmro","22","true","text","Ped_nmro","","","true","","","",},
                            {"java.sql.Timestamp","data_cad","19","true","text","Data_cad","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_cad","300","true","text","Usuario_cad","","","","","","",},
                            {"java.lang.String","texto","250","false","text","Texto","","","","","","",},
                            {"java.lang.Integer","obs_cdgo","10","false","text","Obs_cdgo","","","true","","","",}
                          };
    return metadata;
  }

}
