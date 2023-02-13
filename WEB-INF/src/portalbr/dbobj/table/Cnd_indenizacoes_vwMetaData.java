package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cnd_indenizacoes_vw
  * @version 03/04/2013 10:02:16
  */
public class Cnd_indenizacoes_vwMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CND_INDENIZACOES_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","cnd_cdgo","22","true","text","Cnd_cdgo","","","true","","","",},
                            {"java.lang.String","cnd_desc","25","true","text","Cnd_desc","","","","","","",},
                            {"java.lang.Integer","cnd_inte","2","true","text","Cnd_inte","","","true","","","",},
                            {"java.lang.Integer","cnd_parc","2","true","text","Cnd_parc","","","true","","","",},
                            {"java.lang.Integer","cnd_prim","3","true","text","Cnd_prim","","","true","","","",},
                            {"java.lang.Double","cnd_dsct","6","true","text","Cnd_dsct","","##,##0.00","true","","","",},
                            {"java.lang.Double","cnd_mora","5","true","text","Cnd_mora","","##,##0.00","true","","","",},
                            {"java.lang.Integer","cnd_przo","3","true","text","Cnd_przo","","","true","","","",},
                            {"java.lang.Double","cnd_vlor","6","true","text","Cnd_vlor","","##,##0.00","true","","","",},
                            {"java.lang.Double","cnd_vlom","10","true","text","Cnd_vlom","","##,##0.00","true","","","",},
                            {"java.lang.String","cnd_status","1","true","text","Cnd_status","","","","","","",},
                            {"java.lang.Integer","cnd_przmed","3","false","text","Cnd_przmed","","","true","","","",},
                            {"java.lang.String","cnd_emissao_bloquete","1","false","text","Cnd_emissao_bloquete","","","","","","",},
                            {"java.lang.String","tipo_mercado","2","false","text","Tipo_mercado","","","","","","",}
                          };
    return metadata;
  }

}
