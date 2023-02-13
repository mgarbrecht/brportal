package portalbr.dbobj.view;

/** DataBase Object from table .Jw_coletas_solicitacoes
  * @version 27/03/2019 10:09:41
  */
public class Jw_coletas_solicitacoesMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","id_solicitacao_coleta","22","false","text","id_solicitacao_coleta","","","","","","",},
                            {"java.sql.Timestamp","data_solicitacao","22","false","text","data_solicitacao","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","solicitante","300","false","text","solicitante","","","","","","",},
                            {"java.sql.Timestamp","data_atendi_solicitacao","22","false","text","data_atendi_solicitacao","","","","","","",},
                            {"java.lang.String","emp_empresa","10","false","text","emp_empresa","","","","","","",},
                            {"java.lang.String","emp_razsoc","200","false","text","emp_razsoc","","","","","","",},
                            {"java.lang.String","fil_filial","10","false","text","fil_filial","","","","","","",},
                            {"java.lang.String","fil_filial_descricao","200","false","text","fil_filial_descricao","","","","","","",},
                            {"java.lang.String","fil_filial_destino","10","false","text","fil_filial_destino","","","","","","",},
                            {"java.lang.String","fil_filial_destino_descricao","200","false","text","fil_filial_destino_descricao","","","","","","",},
                            {"java.lang.Integer","tra_cdgo","22","false","text","tra_cdgo","","","","","","",},
                            {"java.lang.String","tra_nome","200","false","text","tra_nome","","","","","","",},
                            {"double","quantidade_volumes","22","false","text","quantidade_volumes","","","","","","",},
                            {"double","quantidade_cubica","22","false","text","quantidade_cubica","","","","","","",},
                            {"java.lang.String","especie","200","false","text","especie","","","","","","",},
                            {"java.lang.String","tipo_caminhao","300","false","text","tipo_caminhao","","","","","","",},
                            {"java.lang.String","observacoes","500","false","text","observacoes","","","","","","",},
                            {"java.lang.String","usuario_inclusao","300","false","text","usuario_inclusao","","","","","","",},
                            {"java.sql.Timestamp","dthr_inclusao","22","false","text","dthr_inclusao","","dd/MM/yyyy HH:mm:ss","","","","",},
                            {"java.lang.String","usuario_alteracao","300","false","text","usuario_alteracao","","","","","","",},
                            {"java.sql.Timestamp","dthr_alteracao","22","false","text","dthr_alteracao","","","","","","",},
                            {"java.lang.String","tipo_solicitacao","1","false","text","tipo_solicitacao","","","","","","",},
                            {"java.lang.String","descricao_tipo_solicitacao","100","false","text","descricao_tipo_solicitacao","","","","","","",},
                            {"java.lang.String","status","1","false","text","status","","","","","","",},
                            {"java.lang.String","status_descricao","100","false","text","status_descricao","","","","","","",},
                            {"java.lang.String","email_enviado","1","false","text","email_enviado","","","","","","",},
                            {"java.lang.String","email_enviado_descricao","20","false","text","email_enviado_descricao","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT c.id_solicitacao_coleta       ,c.data_solicitacao       ,c.solicitante       ,c.data_atendi_solicitacao       ,c.emp_empresa       ,e.emp_razsoc       ,c.fil_filial       ,pck_filial.get_nome(c.fil_filial) fil_filial_descricao       ,c.fil_filial_destino       ,pck_filial.get_nome(c.fil_filial_destino) fil_filial_destino_descricao       ,c.tra_cdgo       ,pck_transportadora.get_nome(c.tra_cdgo) tra_nome       ,c.quantidade_volumes       ,c.quantidade_cubica       ,c.especie       ,c.tipo_caminhao       ,c.observacoes       ,c.usuario_inclusao       ,c.dthr_inclusao       ,c.usuario_alteracao       ,c.dthr_alteracao       ,c.tipo_solicitacao       ,CASE          WHEN c.tipo_solicitacao = 1 THEN           'COLETA'          WHEN c.tipo_solicitacao = 2 THEN           'CARRO EXTRA'          WHEN c.tipo_solicitacao = 3 THEN           'TRANSFERÊNCIA'        END descricao_tipo_solicitacao       ,c.status       ,CASE          WHEN c.status = 'A' THEN           'ATENDIDA'          WHEN c.status = 'S' THEN           'SOLICITADA'          ELSE           'CANCELADA'        END status_descricao       ,c.email_enviado       ,CASE          WHEN c.email_enviado = 'S' THEN           'SIM'          WHEN c.email_enviado = 'N' THEN           'NÃO'        END email_enviado_descricao   FROM coletas_solicitacoes c       ,empresa              e       ,filial               f  WHERE c.emp_empresa = e.emp_empresa    AND f.emp_empresa = c.emp_empresa    AND f.fil_filial = c.fil_filial";
    return query;
  }

}
