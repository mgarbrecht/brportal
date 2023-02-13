package portalbr.dbobj.table;

/** DataBase Object from table FRETES.Conhecimentos_frt_ocorrencias
  * @version 03/04/2013 10:01:07
  */
public class Conhecimentos_frt_ocorrenciasMetaData {

  public static final String SCHEMA = "FRETES";

  /*** Table Primary Key fields. */
  public static final String[] PK = {"ID"};

  /*** Data Base object name. */
  public static final String DB_OBJECT = "CONHECIMENTOS_FRT_OCORRENCIAS";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Long","id","22","true","text","Id","","","true","","","",},
                            {"java.lang.Integer","fen_for_codigo","9","true","text","Fen_for_codigo","","","true","","","",},
                            {"java.lang.Integer","fen_seq","4","true","text","Fen_seq","","","true","","","",},
                            {"java.lang.String","numero","20","true","text","Numero","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","Emp_empresa","","","","","","",},
                            {"java.lang.String","filial","3","false","text","Filial","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","10","false","text","Nfs_nmro","","","true","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","Nfs_serie","","","","","","",},
                            {"java.lang.Integer","mot_codigo","22","false","text","Mot_codigo","","","true","","","",},
                            {"java.lang.String","observacao","400","false","text","Observacao","","","","","","",},
                            {"java.lang.String","usuario_cad","30","true","text","Usuario_cad","","","","","","",},
                            {"java.sql.Date","data_cad","19","true","text","Data_cad","","dd/MM/yyyy","true","","","",},
                            {"java.sql.Date","data_ocorrencia","19","false","text","Data_ocorrencia","","dd/MM/yyyy","true","","","",}
                          };
    return metadata;
  }

}
