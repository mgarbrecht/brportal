package portalbr.dbobj.view;

/** DataBase Object from table .Jw_romaneios_embarque
  * @version 30/07/2021 10:55:50
  */
public class Jw_romaneios_embarqueMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","EMP_EMPRESA","3","false","text","","","","","","","",},
                            {"java.lang.String","FIL_FILIAL","4","false","text","","","","","","","",},
                            {"java.lang.String","NUMERO","22","false","text","","","","","","","",},
                            {"java.sql.Date","DATA_EMISSAO","12","false","text","","","","","","","",},
                            {"java.sql.Timestamp","DATA_FINALIZACAO","12","false","text","","","","","","","",},
                            {"java.lang.String","TRA_CDGO","22","false","text","","","","","","","",},
                            {"java.lang.String","TRA_NOME","35","false","text","","","","","","","",},
                            {"java.lang.String","FILIAL","57","false","text","","","","","","","",},
                            {"java.lang.String","SITUACAO","10","false","text","","","","","","","",},
                            {"java.sql.Timestamp","DATA_ENVIO","12","false","text","","","","","","","",},
                            {"java.lang.String","USUARIO_INCLUSAO","240","false","text","Usuario_inclusao","","","","","","",},
                            {"java.lang.String","QTDE_NOTAS","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT re.emp_empresa                ,re.fil_filial                ,re.numero                ,re.data_emissao                ,re.dthr_alteracao data_finalizacao                ,re.tra_cdgo                ,t.tra_nome                ,re.fil_filial || ' - ' || f.fil_razsoc filial                ,DECODE(re.situacao, 'A', 'Aberto', 'F', 'Finalizado') situacao                ,ns.nfs_data_edi data_envio                ,re.usuario_inclusao				,0 qtde_notas   FROM nf_saida ns       ,romaneios_embarque re       ,tra t       ,filial f  WHERE NVL(re.numero, NULL) = ns.nro_romaneio_embarque    AND re.tra_cdgo = t.tra_cdgo    AND f.fil_filial = re.fil_filial";
    return query;
  }

}
