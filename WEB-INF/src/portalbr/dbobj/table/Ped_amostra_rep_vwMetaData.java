package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_amostra_rep_vw
  * @version 21/08/2013 11:33:39
  */
public class Ped_amostra_rep_vwMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PED_AMOSTRA_REP_VW";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","nfs_nmro","10","true","text","Nfs_nmro","","","true","","","",},
                            {"java.lang.Integer","ped_nmro","22","true","text","Ped_nmro","","","true","","","",},
                            {"java.lang.String","rep","4000","false","text","Rep","","","","","","",},
                            {"java.lang.String","regional","4000","false","text","Regional","","","","","","",},
                            {"java.lang.String","cliente","4000","false","text","Cliente","","","","","","",},
                            {"java.lang.String","tra","4000","false","text","Tra","","","","","","",},
                            {"java.lang.String","consig","4000","false","text","Consig","","","","","","",},
                            {"java.lang.Integer","regional_cdgo","22","false","text","Regional_cdgo","","","true","","","",},
                            {"java.lang.String","rep_cdgo","22","false","text","Rep_cdgo","","","true","","","",},
                            {"java.lang.Integer","cli_cdgo","22","true","text","Cli_cdgo","","","true","","","",},
                            {"java.sql.Date","ped_dadg","10","true","text","Ped_dadg","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","estagios_marcados","200","false","text","Estagios_marcados","","","true","","","",},
                            {"java.lang.String","observacao","2000","false","text","Observacao","","","true","","","",},
                            {"java.lang.String","obs_atendente","2000","false","text","Observacao Atendente","","","true","","","",},
                            {"java.lang.Integer","id_situacao","22","true","text","Id_situacao","","","true","","","",},
                            {"java.lang.String","usuario_data_inclusao","200","false","text","usuario_data_inclusao","","","true","","","",},
                            {"java.lang.Integer","lin_cdgo","10","true","text","Lin_cdgo","","","true","","","",},
                            {"java.lang.Integer","ref_cdgo","10","true","text","Ref_cdgo","","","true","","","",},
                            {"java.lang.Integer","codigo_marca","10","true","text","Codigo_marca","","","true","","","",},
                            {"java.lang.String","descricao_marca","100","false","text","Descricao_marca","","","","","","",},
                            {"java.lang.String","tipo_produto","100","false","text","Tipo_produto","","","","","","",}
                          };
    return metadata;
  }

}
