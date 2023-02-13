package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Forma
  * @version 03/04/2013 09:56:25
  */
public class FormaMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"FMA_CDGO"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FORMA";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","mat_nro","9","false","text","Mat_nro","","","true","","","",},
                            {"java.lang.String","fma_cdgo","10","true","text","Fma_cdgo","","","","","","",},
                            {"java.lang.String","fma_nchave","5","true","text","Fma_nchave","","","","","","",},
                            {"java.lang.String","fma_espec","50","true","text","Fma_espec","","","","","","",},
                            {"java.lang.String","fma_obs","200","false","text","Fma_obs","","","","","","",},
                            {"java.lang.Integer","fma_tipo_material_cdgo","22","false","text","Fma_tipo_material_cdgo","","0","true","","","",},
                            {"java.lang.Integer","fma_tipo_forma_cdgo","22","false","text","Fma_tipo_forma_cdgo","","0","true","","","",},
                            {"java.sql.Date","vigencia_inicial","10","false","text","Vigencia_inicial","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","vigencia_final","10","false","text","Vigencia_final","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","data_cadastro","10","false","text","Data_cadastro","","dd/MM/yyyy","true","","","",},
                            {"java.lang.String","usuario_cadastro","30","false","text","Usuario_cadastro","","","","","","",},
                            {"java.lang.String","fma_altura_salto","50","false","text","Fma_altura_salto","","","","","","",},
                            {"java.lang.String","fma_imagem","100","false","text","Fma_imagem","","","","","","",},
                            {"java.lang.String","fma_altura_bico","50","false","text","Fma_altura_bico","","","","","","",},
                            {"java.lang.String","fma_base","50","false","text","Fma_base","","","","","","",},
                            {"java.lang.Integer","for_codigo","9","false","text","For_codigo","","","true","","","",}
                          };
    return metadata;
  }

}
