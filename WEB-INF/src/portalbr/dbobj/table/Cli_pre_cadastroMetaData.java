package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cli_pre_cadastro
  * @version 21/08/2013 11:12:58
  */
public class Cli_pre_cadastroMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ESC_CGC"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CLI_PRE_CADASTRO";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","esc_cgc","14","true","text","CNPJ","","","true","","","",},
                            {"java.lang.String","cli_rzao","50","true","text","Razão Social","","","","","","",},
                            {"java.lang.String","cli_nome","50","true","text","Nome Fantasia","","","","","","",},
                            {"java.lang.String","esc_insm","15","true","text","Inscrição Municipal","","","","","","",},
                            {"java.lang.String","esc_inse","18","true","text","Inscrição Estadual","","","","","","",},
                            {"java.lang.String","tipo_loja","18","true","text","Tipo Loja","","","","","","",},
                            {"java.lang.String","esc_email","100","true","text","Email","","","","","","",},
                            {"java.lang.String","pec_nome","35","true","text","Contato","","","","","","",},
                            {"java.lang.String","ecl_rua","65","true","text","Logradouro","","","","","","",},
                            {"java.lang.String","ecl_nmro","7","true","text","Número","","","","","","",},
                            {"java.lang.String","ecl_cpto","6","false","text","Complemento","","","","","","",},
                            {"java.lang.String","ecl_bair","30","true","text","Bairro","","","","","","",},
                            {"java.lang.String","ecl_cdad","60","true","text","Cidade","","","","","","",},
                            {"java.lang.String","ecl_cep","8","true","text","CEP","","","","","","",},
                            {"java.lang.String","est_unifed","2","true","text","UF","","","","","","",},
                            {"java.lang.Integer","ffs_ddi","3","false","text","DDI","","","true","","","",},
                            {"java.lang.Integer","ffs_ddd","4","true","text","DDD","","","true","","","",},
                            {"java.lang.Integer","ffs_nmro","8","true","text","Telefone","","","true","","","",},
                            {"java.lang.Integer","ffs_rmal","5","false","text","Ramal","","","true","","","",},
                            {"java.lang.String","contrato_social","60","true","text","Contrato_social","","","","","","",},
                            {"java.sql.Timestamp","cli_dtin","19","true","text","Cli_dtin","","dd/MM/yyyy HH:mm:ss","true","","","",},
                            {"java.lang.String","cli_situ","1","true","text","Cli_situ","","","","","","",},
                            {"java.lang.Integer","cli_cdgo","22","false","text","Cli_cdgo","","","true","","","",},
                            {"java.lang.String","inf_complementar","2000","false","text","Informações Complementares","","","","","","",}
                          };
    return metadata;
  }

}
