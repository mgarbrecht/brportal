package portalbr.dbobj.view;

/** DataBase Object from table .Jw_embarque_exportacao
  * @version 12/09/2019 14:38:12
  */
public class Jw_embarque_exportacaoMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.Integer","REM_NRO","22","false","text","","","","","","","",},
                            {"java.lang.Integer","PED_NMRO","22","false","text","","","","","","","",},
                            {"java.lang.String","PED_INVOICE","80","false","text","","","","","","","",},
                            {"int","ITE_SEQN","3","false","text","","","","","","","",},
                            {"java.lang.Integer","LIN_CDGO","22","false","text","","","","","","","",},
                            {"java.lang.Integer","REF_CDGO","22","false","text","","","","","","","",},
                            {"java.lang.Integer","CAB_CDGO","22","false","text","","","","","","","",},
                            {"java.lang.Integer","COR_CDGO","22","false","text","","","","","","","",},
                            {"java.lang.String","NUMERACAO_INTERNA","80","false","text","","","","","","","",},
                            {"java.lang.String","NUMERACAO_EXTERNA","80","false","text","","","","","","","",},
                            {"int","PARES","22","false","text","","","","","","","",},
                            {"java.lang.String","LOJA_CLIENTE","640","false","text","","","","","","","",},
                            {"java.lang.String","CAIXA","4000","false","text","","","","","","","",},
                            {"int","TOTAL_ROTULOS_PED","22","false","text","","","","","","","",},
                            {"int","TOTAL_ROTULOS","22","false","text","","","","","","","",},
                            {"int","SEQ_ROTULO","22","false","text","","","","","","","",},
                            {"java.lang.Integer","SEQ_ROTULO_FATURA","22","false","text","","","","","","","",},
                            {"java.lang.Integer","TOTAL_ROTULOS_FATURA","22","false","text","","","","","","","",},
                            {"java.lang.String","BAR","4000","false","text","","","","","","","",},
                            {"int","NFS_NMRO","22","false","text","","","","","","","",},
                            {"java.lang.String","NFS_SERIE","80","false","text","","","","","","","",},
                            {"java.lang.Integer","REQNF_NUMERO","22","false","text","","","","","","","",},
                            {"int","NFS_QTDVOL","22","false","text","","","","","","","",},
                            {"java.lang.String","fil_filial","80","false","text","fil_filial","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT DISTINCT /*+ all_rows */ rem_nro               ,ped_nmro               ,ped_invoice               ,ite_seqn               ,lin_cdgo               ,ref_cdgo               ,cab_cdgo               ,cor_cdgo               ,NULL numeracao_interna               ,NULL numeracao_externa               ,pares               ,loja_cliente               ,caixa               ,total_rotulos_ped               ,total_rotulos               ,seq_rotulo               ,seq_rotulo_fatura               ,total_rotulos_fatura               ,bar               ,nfs_nmro               ,nfs_serie               ,reqnf_numero               ,nfs_qtdvol               ,fil_filial  FROM (SELECT rr.rem_nro              ,i.ped_nmro              ,i.ite_seqn              ,i.lin_cdgo lin_cdgo              ,i.ref_cdgo ref_cdgo              ,i.cab_cdgo cab_cdgo              ,i.cor_cdgo cor_cdgo              ,q.qtt_nume numeracao_interna              ,q.qtt_nume_exp numeracao_externa              ,q.qtt_pars pares              ,REPLACE(rr.cli_distr, '''', '''''') loja_cliente              ,LPAD(rr.seq_rotulo_ped, 4, 0) caixa              ,rr.total_rotulos_ped              ,rr.total_rotulos              ,rr.seq_rotulo              ,rr.seq_rotulo_fatura              ,rr.total_rotulos_fatura              ,DECODE(rr.tipo_geracao, 'P', 'P' || LPAD(rr.ped_nmro, 8, 0) || LPAD(rr.seq_rotulo_ped, 4, 0) || LPAD(rr.id_versao, 6, 0), 'R', 'R' || LPAD(rr.rem_nro, 8, 0) || LPAD(rr.seq_rotulo, 4, 0) || LPAD(rr.id_versao, 6, 0), 'E', 'E' || LPAD(rr.rem_nro, 8, 0) || LPAD(rr.seq_rotulo, 4, 0) || LPAD(rr.id_versao, 6, 0), 'A', 'A' || LPAD(rr.ped_nmro, 8, 0) || LPAD(rr.seq_rotulo_ped, 4, 0) || LPAD(rr.id_versao, 6, 0)) bar              ,ns.nfs_nmro              ,ns.nfs_serie              ,nfsr.reqnf_numero              ,ns.nfs_qtdvol              ,ped.ped_invoice              ,ns.fil_filial          FROM rotulos_remessa rr              ,ite i              ,qtd_rotulos_remessa q              ,ped              ,requisicoes_ite ri              ,notas_fiscais_saida_requis nfsr              ,nf_saida ns              ,operacoes_grupo_saida ogs         WHERE rr.ped_nmro = ped.ped_nmro           AND rr.ped_nmro = i.ped_nmro           AND rr.ite_seqn = i.ite_seqn           AND q.rem_nro = rr.rem_nro           AND q.rotulo = rr.rotulo           AND q.ped_nmro = rr.ped_nmro           AND q.ite_seqn = rr.ite_seqn           AND nfsr.reqnf_numero = ri.reqnf_numero           AND nfsr.nfs_nmro = ns.nfs_nmro           AND nfsr.nfs_serie = ns.nfs_serie           AND nfsr.emp_empresa = ns.emp_empresa           AND nfsr.fil_filial = ns.fil_filial           AND ns.stat_codigo NOT IN (1, 0)           AND ped.ped_nmro = ri.ped_nmro           AND ogs.nat_codigo = ns.natoper_codigo           AND ogs.gos_codigo = DECODE(ped.ped_tipo, 'EX', 5, 1)        UNION        SELECT rr.rem_nro              ,i.ped_nmro              ,i.ite_seqn              ,i.lin_cdgo lin_cdgo              ,i.ref_cdgo ref_cdgo              ,i.cab_cdgo cab_cdgo              ,i.cor_cdgo cor_cdgo              ,q.qtt_nume numeracao_interna              ,q.qtt_nume_exp numeracao_externa              ,q.qtt_pars pares              ,REPLACE(rr.cli_distr, '''', '''''') loja_cliente              ,LPAD(rr.seq_rotulo_ped, 4, 0) caixa              ,rr.total_rotulos_ped              ,rr.total_rotulos              ,rr.seq_rotulo              ,rr.seq_rotulo_fatura              ,rr.total_rotulos_fatura              ,DECODE(rr.tipo_geracao, 'P', 'P' || LPAD(rr.ped_nmro, 8, 0) || LPAD(rr.seq_rotulo_ped, 4, 0) || LPAD(rr.id_versao, 6, 0), 'R', 'R' || LPAD(rr.rem_nro, 8, 0) || LPAD(rr.seq_rotulo, 4, 0) || LPAD(rr.id_versao, 6, 0), 'E', 'E' || LPAD(rr.rem_nro, 8, 0) || LPAD(rr.seq_rotulo, 4, 0) || LPAD(rr.id_versao, 6, 0), 'A', 'A' || LPAD(rr.ped_nmro, 8, 0) || LPAD(rr.seq_rotulo_ped, 4, 0) || LPAD(rr.id_versao, 6, 0)) bar              ,ns.nfs_nmro              ,ns.nfs_serie              ,NULL reqnf_numero              ,ns.nfs_qtdvol              ,ped.ped_invoice              ,ns.fil_filial          FROM rotulos_remessa rr              ,ite i              ,qtd_rotulos_remessa q              ,ped              ,notas_fiscais_saida_ite_venda nfsiv              ,nf_saida ns         WHERE i.ped_nmro = ped.ped_nmro           AND rr.ped_nmro = i.ped_nmro           AND rr.ite_seqn = i.ite_seqn           AND q.rem_nro = rr.rem_nro           AND q.rotulo = rr.rotulo           AND q.ped_nmro = rr.ped_nmro           AND q.ite_seqn = rr.ite_seqn           AND nfsiv.ped_nmro = i.ped_nmro           AND nfsiv.ite_seqn = i.ite_seqn           AND ns.nfs_nmro = nfsiv.nfs_nmro           AND ns.nfs_serie = nfsiv.nfs_serie           AND ns.emp_empresa = nfsiv.emp_empresa           AND ns.fil_filial = nfsiv.fil_filial           AND ns.stat_codigo NOT IN (1, 0)           AND NOT EXISTS (SELECT NULL                  FROM requisicoes_ite ri                      ,notas_fiscais_saida_requis nfsr                      ,nf_saida nss                      ,operacoes_grupo_saida ogs                 WHERE nfsr.reqnf_numero = ri.reqnf_numero                   AND nss.emp_empresa = nfsr.emp_empresa                   AND nss.fil_filial = nfsr.fil_filial                   AND nss.nfs_nmro = nfsr.nfs_nmro                   AND nss.nfs_serie = nfsr.nfs_serie                   AND ogs.nat_codigo = nss.natoper_codigo                   AND ogs.gos_codigo = DECODE(ped.ped_tipo, 'EX', 5, 1)                   AND nss.nfs_nmro = ns.nfs_nmro                   AND nss.fil_filial = ns.fil_filial                   AND nss.nfs_serie = ns.nfs_serie                   AND nss.emp_empresa = ns.emp_empresa))";
    return query;
  }

}
