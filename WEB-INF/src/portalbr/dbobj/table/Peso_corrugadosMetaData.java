package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Peso_corrugados
  * @version 05/08/2014 11:47:32
  */
public class Peso_corrugadosMetaData {

  public static final String SCHEMA = "BRIO";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"LIN_CDGO","REF_CDGO","CODIGO_CORRUG","QT_PAR_CORRUG"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "PESO_CORRUGADOS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","lin_cdgo","22","true","text","Lin_cdgo","","","true","","","",},
                            {"java.lang.Integer","ref_cdgo","10","true","text","Ref_cdgo","","","true","","","",},
                            {"int","codigo_corrug","22","true","text","Codigo_corrug","","","true","","","",},
                            {"java.lang.Integer","qt_par_corrug","3","true","text","Qt_par_corrug","","","true","","","",},
                            {"java.lang.Double","peso_corrug","8","true","text","Peso_corrug","","##,##0.00","true","","","",},
                            {"java.lang.String","ativo","1","true","text","Ativo","","","","","","",},
                            {"java.lang.Double","altura","11","true","text","Altura","","##,##0.00","true","","","",},
                            {"java.lang.Double","largura","11","true","text","Largura","","##,##0.00","true","","","",},
                            {"java.lang.Double","comprimento","11","true","text","Comprimento","","##,##0.00","true","","","",},
                            {"java.lang.Double","peso_embalagem","8","false","text","Peso_embalagem","","##,##0.00","true","","","",},
                            {"java.lang.Double","peso_adicional","8","false","text","Peso_adicional","","##,##0.00","true","","","",},
                            {"java.lang.String","tipo_mercado","1","true","text","Tipo_mercado","","","","","","",},
                            {"java.sql.Date","data_log_afv","10","false","text","Data_log_afv","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
