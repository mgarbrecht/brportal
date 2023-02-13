package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_desconto_indenizacao
  * @version 22/11/2016 15:20:26
  */
public class Ped_desconto_indenizacaoMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"PED_NMRO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PED_DESCONTO_INDENIZACAO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","ped_nmro","22","true","text","Ped_nmro","","","true","","","",},
                            {"java.lang.Integer","tipo_desconto","22","true","text","Tipo_desconto","","","true","","","",},
                            {"java.lang.String","ped_obse","800","false","text","Ped_obse","","","","","","",},
                            {"java.lang.Double","valor_desconto","22","false","text","Valor_desconto","","##,##0.00","true","","","",},
                            {"java.lang.Double","percentual_desc","22","false","text","Percentual_desc","","##,##0.00","true","","","",},
                            {"java.lang.Integer","cnd_cdgo","22","false","text","Cnd_cdgo","","","true","","","",},
                            {"java.lang.String","situacao","1","false","text","Situacao","","","","","","",},
                            {"java.lang.Integer","cnd_cdgo_ped","22","false","text","Cnd_cdgo_ped","","","true","","","",},
                            {"java.lang.Integer","prazo_adicional","22","true","text","Prazo Adicional","","","true","","","",},
                            {"java.lang.String","usuario_criacao","50","false","text","Usuario_criacao","","","true","","","",},
                            {"java.sql.Timestamp","data_criacao","22","false","text","Data_criacao","","","true","","","",}
                          };
    return metadata;
  }

}
