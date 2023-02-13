package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ficha_tec_instrutiva_itens
  * @version 03/04/2013 09:56:55
  */
public class Ficha_tec_instrutiva_itensMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID_NRO","ID_NRO_SEQ"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "FICHA_TEC_INSTRUTIVA_ITENS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Double","id_nro","22","true","text","Id_nro","","0","true","","","",},
                            {"java.lang.Double","id_nro_seq","22","true","text","Id_nro_seq","","0","true","","","",},
                            {"java.lang.Double","cmp_cdgo","22","false","text","Cmp_cdgo","","0","true","","","",},
                            {"java.lang.String","cmp_desc","40","false","text","Cmp_desc","","","","","","",},
                            {"java.lang.Double","codigo_peca","22","false","text","Codigo_peca","","0","true","","","",},
                            {"java.lang.String","descricao_peca","25","false","text","Descricao_peca","","","","","","",},
                            {"java.lang.Double","mat_nro","22","false","text","Mat_nro","","0","true","","","",},
                            {"java.lang.String","mat_nro_desc","100","false","text","Mat_nro_desc","","","","","","",},
                            {"java.lang.Double","cor_cdgo","22","false","text","Cor_cdgo","","0","true","","","",},
                            {"java.lang.String","cor_desc","60","false","text","Cor_desc","","","","","","",},
                            {"java.lang.Integer","cod_peca","22","false","text","Cod_peca","","","","","","",},
                            {"java.lang.String","status","1","false","text","Status","","","","","","",}
                          };
    return metadata;
  }

}
