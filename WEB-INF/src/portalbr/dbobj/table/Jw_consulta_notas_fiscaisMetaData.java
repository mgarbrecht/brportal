package portalbr.dbobj.table;

/** DataBase Object from table .Jw_consulta_notas_fiscais
  * @version 27/05/2010 10:16:14
  */
public class Jw_consulta_notas_fiscaisMetaData {

  public static final String SCHEMA = "";

  /*** Table Primary Key fields. */
  public static final String[] PK = new String[0];

  /*** Data Base object name. */
  public static final String DB_OBJECT = "";

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","nota","46","false","text","Número","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","Filial","","","","","","",},
                            {"java.lang.String","cc","78","false","text","Cliente","","","","","","",},
                            {"java.lang.String","ecl_cdad","63","false","text","Cidade","","","","","","",},
                            {"java.lang.String","est_unifed","63","false","text","UF","","","","","","",},
                            {"java.lang.String","linha","40","false","text","Linha","","","","","","",},
                            {"java.sql.Timestamp","nfs_dtemis","12","false","text","Emissão","","","","","","",},
                            {"java.lang.Integer","nfs_nmro","22","false","hidden","nfs_nmro","","","","","","",},
                            {"java.lang.String","nfs_serie","3","false","text","nfs_serie","","","","","","",},
                            {"java.lang.Double","nfs_valicm","26","false","text","nfs_valicm","","","","","","",},
                            {"java.lang.Integer","nfs_qtdvol","22","false","text","nfs_qtdvol","","","","","","",},
                            {"java.lang.Integer","qtde_de_notas","20","false","text","Nro de Notas","","","","","","",},
                            {"java.lang.Double","nfs_vltot","26","false","text","nfs_vltot","","","","","","",},
                            {"java.lang.String","sigla_trans","4","false","text","Sigla da Transportadora","","","","","","",},
                            {"java.lang.String","nro_romaneio_embarque","22","false","text","Romaneio","","","","","","",},
                            {"java.sql.Timestamp","finalizacao_romaneio","12","false","text","Finalização Romaneio","","","","","","",},
                            {"java.lang.String","conhecimentos","50","false","text","conhecimentos","","","","","","",},
                            {"double","nfs_total_pares","50","false","text","nfs_total_pares","","","","","","",}
                          };
    return metadata;
  }

}
