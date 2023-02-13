package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_inf_adicionais
  * @version 20/01/2022 10:59:39
  */
public class Ped_inf_adicionais implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer ped_nmro;
  private java.lang.String etiquetas;
  private java.lang.String obse_adicionais;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial_fat;
  private java.sql.Date dt_fatur_filial;
  private java.sql.Date data_etiquetagem;
  private java.lang.String carimbo;
  private java.lang.String rotulos;
  private java.sql.Date dt_envio_amostras;
  private java.sql.Date dt_agendamento;
  private java.lang.String agendamento_cdgo;
  private java.lang.String horario_entrega;
  private java.lang.String senha_entrega;
  private java.lang.String seq_acao_mkt;
  private java.lang.Double valor_bonificado;
  private java.lang.String id_showroom;
  private java.sql.Date dt_showroom;
  private java.sql.Date dt_inspecao;
  private java.sql.Date dt_entrega_etiqueta;
  private java.lang.String cabide;
  private java.lang.Integer sp_ped_nmro;
  private java.lang.Integer sp_ts_cdgo_situacao;
  private java.sql.Date sp_dt_cad_situacao;
  private java.lang.Integer sp_ite_seqn;
  private java.sql.Date dt_ent_amostra_comercial;
  private java.sql.Date dt_ent_amostra_pcp;
  private java.lang.String encarte;
  private java.lang.String portao;
  private java.lang.String cd_entrega;
  private java.sql.Date dt_rec_etiqueta_filial;
  private java.lang.String prioridade_embarque;
  private java.sql.Date dt_solicitacao_alarme;
  private java.sql.Date dt_rec_alarme_pcp;
  private java.sql.Date dt_rec_alarme_filial;
  private java.lang.Integer nfe_numero;
  private java.lang.String gerar_requisicao;
  private java.lang.String modelo_alarme;

  public Ped_inf_adicionais() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getEtiquetas() {
    return etiquetas;
  }

  public void setEtiquetas(java.lang.String PARAM) {
    this.etiquetas = PARAM;
  }

  public java.lang.String getObse_adicionais() {
    return obse_adicionais;
  }

  public void setObse_adicionais(java.lang.String PARAM) {
    this.obse_adicionais = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFil_filial_fat() {
    return fil_filial_fat;
  }

  public void setFil_filial_fat(java.lang.String PARAM) {
    this.fil_filial_fat = PARAM;
  }

  public java.sql.Date getDt_fatur_filial() {
    return dt_fatur_filial;
  }

  public void setDt_fatur_filial(java.sql.Date PARAM) {
    this.dt_fatur_filial = PARAM;
  }

  public java.sql.Date getData_etiquetagem() {
    return data_etiquetagem;
  }

  public void setData_etiquetagem(java.sql.Date PARAM) {
    this.data_etiquetagem = PARAM;
  }

  public java.lang.String getCarimbo() {
    return carimbo;
  }

  public void setCarimbo(java.lang.String PARAM) {
    this.carimbo = PARAM;
  }

  public java.lang.String getRotulos() {
    return rotulos;
  }

  public void setRotulos(java.lang.String PARAM) {
    this.rotulos = PARAM;
  }

  public java.sql.Date getDt_envio_amostras() {
    return dt_envio_amostras;
  }

  public void setDt_envio_amostras(java.sql.Date PARAM) {
    this.dt_envio_amostras = PARAM;
  }

  public java.sql.Date getDt_agendamento() {
    return dt_agendamento;
  }

  public void setDt_agendamento(java.sql.Date PARAM) {
    this.dt_agendamento = PARAM;
  }

  public java.lang.String getAgendamento_cdgo() {
    return agendamento_cdgo;
  }

  public void setAgendamento_cdgo(java.lang.String PARAM) {
    this.agendamento_cdgo = PARAM;
  }

  public java.lang.String getHorario_entrega() {
    return horario_entrega;
  }

  public void setHorario_entrega(java.lang.String PARAM) {
    this.horario_entrega = PARAM;
  }

  public java.lang.String getSenha_entrega() {
    return senha_entrega;
  }

  public void setSenha_entrega(java.lang.String PARAM) {
    this.senha_entrega = PARAM;
  }

  public java.lang.String getSeq_acao_mkt() {
    return seq_acao_mkt;
  }

  public void setSeq_acao_mkt(java.lang.String PARAM) {
    this.seq_acao_mkt = PARAM;
  }

  public java.lang.Double getValor_bonificado() {
    return valor_bonificado;
  }

  public void setValor_bonificado(java.lang.Double PARAM) {
    this.valor_bonificado = PARAM;
  }

  public java.lang.String getId_showroom() {
    return id_showroom;
  }

  public void setId_showroom(java.lang.String PARAM) {
    this.id_showroom = PARAM;
  }

  public java.sql.Date getDt_showroom() {
    return dt_showroom;
  }

  public void setDt_showroom(java.sql.Date PARAM) {
    this.dt_showroom = PARAM;
  }

  public java.sql.Date getDt_inspecao() {
    return dt_inspecao;
  }

  public void setDt_inspecao(java.sql.Date PARAM) {
    this.dt_inspecao = PARAM;
  }

  public java.sql.Date getDt_entrega_etiqueta() {
    return dt_entrega_etiqueta;
  }

  public void setDt_entrega_etiqueta(java.sql.Date PARAM) {
    this.dt_entrega_etiqueta = PARAM;
  }

  public java.lang.String getCabide() {
    return cabide;
  }

  public void setCabide(java.lang.String PARAM) {
    this.cabide = PARAM;
  }

  public java.lang.Integer getSp_ped_nmro() {
    return sp_ped_nmro;
  }

  public void setSp_ped_nmro(java.lang.Integer PARAM) {
    this.sp_ped_nmro = PARAM;
  }

  public java.lang.Integer getSp_ts_cdgo_situacao() {
    return sp_ts_cdgo_situacao;
  }

  public void setSp_ts_cdgo_situacao(java.lang.Integer PARAM) {
    this.sp_ts_cdgo_situacao = PARAM;
  }

  public java.sql.Date getSp_dt_cad_situacao() {
    return sp_dt_cad_situacao;
  }

  public void setSp_dt_cad_situacao(java.sql.Date PARAM) {
    this.sp_dt_cad_situacao = PARAM;
  }

  public java.lang.Integer getSp_ite_seqn() {
    return sp_ite_seqn;
  }

  public void setSp_ite_seqn(java.lang.Integer PARAM) {
    this.sp_ite_seqn = PARAM;
  }

  public java.sql.Date getDt_ent_amostra_comercial() {
    return dt_ent_amostra_comercial;
  }

  public void setDt_ent_amostra_comercial(java.sql.Date PARAM) {
    this.dt_ent_amostra_comercial = PARAM;
  }

  public java.sql.Date getDt_ent_amostra_pcp() {
    return dt_ent_amostra_pcp;
  }

  public void setDt_ent_amostra_pcp(java.sql.Date PARAM) {
    this.dt_ent_amostra_pcp = PARAM;
  }

  public java.lang.String getEncarte() {
    return encarte;
  }

  public void setEncarte(java.lang.String PARAM) {
    this.encarte = PARAM;
  }

  public java.lang.String getPortao() {
    return portao;
  }

  public void setPortao(java.lang.String PARAM) {
    this.portao = PARAM;
  }

  public java.lang.String getCd_entrega() {
    return cd_entrega;
  }

  public void setCd_entrega(java.lang.String PARAM) {
    this.cd_entrega = PARAM;
  }

  public java.sql.Date getDt_rec_etiqueta_filial() {
    return dt_rec_etiqueta_filial;
  }

  public void setDt_rec_etiqueta_filial(java.sql.Date PARAM) {
    this.dt_rec_etiqueta_filial = PARAM;
  }

  public java.lang.String getPrioridade_embarque() {
    return prioridade_embarque;
  }

  public void setPrioridade_embarque(java.lang.String PARAM) {
    this.prioridade_embarque = PARAM;
  }

  public java.sql.Date getDt_solicitacao_alarme() {
    return dt_solicitacao_alarme;
  }

  public void setDt_solicitacao_alarme(java.sql.Date PARAM) {
    this.dt_solicitacao_alarme = PARAM;
  }

  public java.sql.Date getDt_rec_alarme_pcp() {
    return dt_rec_alarme_pcp;
  }

  public void setDt_rec_alarme_pcp(java.sql.Date PARAM) {
    this.dt_rec_alarme_pcp = PARAM;
  }

  public java.sql.Date getDt_rec_alarme_filial() {
    return dt_rec_alarme_filial;
  }

  public void setDt_rec_alarme_filial(java.sql.Date PARAM) {
    this.dt_rec_alarme_filial = PARAM;
  }

  public java.lang.Integer getNfe_numero() {
    return nfe_numero;
  }

  public void setNfe_numero(java.lang.Integer PARAM) {
    this.nfe_numero = PARAM;
  }

  public java.lang.String getGerar_requisicao() {
    return gerar_requisicao;
  }

  public void setGerar_requisicao(java.lang.String PARAM) {
    this.gerar_requisicao = PARAM;
  }

  public java.lang.String getModelo_alarme() {
    return modelo_alarme;
  }

  public void setModelo_alarme(java.lang.String PARAM) {
    this.modelo_alarme = PARAM;
  }

}
