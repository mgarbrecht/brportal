package portalbr.dbobj.table;

/** DataBase Object from table EDI.Interface_arq_compra_tal_comp
  * @version 17/09/2015 08:50:36
  */
public class Interface_arq_compra_tal_compMetaData {

  public static final String SCHEMA = "EDI";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"INTERFACE_ARQ_COMPRA_ID","REM_NRO","TAL_NRO","IES_CODIGO","COR_MATERIAL","COMP_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "INTERFACE_ARQ_COMPRA_TAL_COMP";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","interface_arq_compra_id","22","true","text","Interface_arq_compra_id","","","true","","","",},
                            {"java.lang.Integer","rem_nro","22","true","text","Rem_nro","","","true","","","",},
                            {"java.lang.Integer","tal_nro","22","true","text","Tal_nro","","","true","","","",},
                            {"java.lang.Long","ies_codigo","22","true","text","Ies_codigo","","","true","","","",},
                            {"java.lang.Integer","cor_material","22","true","text","Cor_material","","","true","","","",},
                            {"java.lang.Integer","comp_cdgo","22","true","text","Comp_cdgo","","","true","","","",},
                            {"java.lang.String","comp_desc","240","true","text","Comp_desc","","","","","","",},
                            {"java.lang.Integer","cor_comp","22","true","text","Cor_comp","","","true","","","",},
                            {"java.lang.String","cor_comp_desc","240","true","text","Cor_comp_desc","","","","","","",},
                            {"java.lang.Double","consumo","22","true","text","Consumo","","##,##0.00","true","","","",},
                            {"java.lang.String","usuario_inclusao","30","true","text","Usuario_inclusao","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","19","true","text","Dthr_inclusao","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","19","false","text","Dthr_alteracao","","dd/MM/yyyy HH:mm:ss","true","","","",}
                          };
    return metadata;
  }

}
