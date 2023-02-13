package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ficha_tec_instrutiva
  * @version 03/04/2013 09:57:04
  */
public class Ficha_tec_instrutivaMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_NRO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FICHA_TEC_INSTRUTIVA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Double","id_nro","22","true","text","Id_nro","","0","true","","","",},
                            {"java.sql.Date","data","10","false","text","Data","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","projeto_cdgo","15","false","text","Projeto_cdgo","","","","","","",},
                            {"java.lang.String","fma_cdgo","10","false","text","Fma_cdgo","","","","","","",},
                            {"java.lang.String","base","20","false","text","Base","","","","","","",},
                            {"java.lang.Integer","codigo_colecao","2","false","text","Codigo_colecao","","","true","","","",},
                            {"java.lang.Double","gde_cdgo","22","false","text","Gde_cdgo","","0","true","","","",},
                            {"java.lang.Double","lin_cdgo","22","false","text","Lin_cdgo","","0","true","","","",},
                            {"java.lang.String","projeto_desc","100","false","text","Projeto_desc","","","","","","",},
                            {"java.lang.String","forma_desc","100","false","text","Forma_desc","","","","","","",},
                            {"java.lang.String","grade_desc","100","false","text","Grade_desc","","","","","","",},
                            {"java.lang.String","linha_desc","100","false","text","Linha_desc","","","","","","",},
                            {"java.lang.Double","ref_cdgo","22","false","text","Ref_cdgo","","0","true","","","",},
                            {"java.lang.String","ref_desc","100","false","text","Ref_desc","","","","","","",},
                            {"java.lang.String","padrao","100","false","text","Padrao","","","","","","",},
                            {"java.lang.String","codigo_desc","100","false","text","Codigo_desc","","","","","","",},
                            {"java.lang.Double","cod_mini_fab","22","false","text","Cod_mini_fab","","0","true","","","",},
                            {"java.lang.String","cod_mini_fab_desc","100","false","text","Cod_mini_fab_desc","","","","","","",},
                            {"java.lang.String","tecnico_resp","100","false","text","Tecnico_resp","","","","","","",},
                            {"java.lang.String","tecnico_pre","100","false","text","Tecnico_pre","","","","","","",},
                            {"java.sql.Date","data_entrega_amostra","10","false","text","Data_entrega_amostra","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","dthr_inclusao","10","false","text","Dthr_inclusao","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","dthr_alteracao","10","false","text","Dthr_alteracao","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","usuario_inclusao","30","false","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","usuario_alteracao","30","false","text","Usuario_alteracao","","","","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",}
                          };
    return metadata;
  }

}
