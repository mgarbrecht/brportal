package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cli_inf_adicionais
  * @version 19/01/2015 10:07:34
  */
public class Cli_inf_adicionais implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private java.lang.Integer cli_cdgo_sucessor;
  private java.lang.Integer esc_seqn_sucessor;
  private java.lang.String sistema_ri;
  private java.lang.String ordem_compra;
  private java.lang.String dt_agendamento;
  private java.lang.String horario_entrega;
  private java.lang.String senha_entrega;
  private java.lang.String data_emissao;
  private java.lang.String filial;
  private java.lang.String nf_nmro;
  private java.lang.String nro_volumes;
  private java.lang.String cliente_mi;
  private java.lang.String possui_carimbo;
  private java.lang.String somente_etiqueta;

  public Cli_inf_adicionais() {
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.Integer getCli_cdgo_sucessor() {
    return cli_cdgo_sucessor;
  }

  public void setCli_cdgo_sucessor(java.lang.Integer PARAM) {
    this.cli_cdgo_sucessor = PARAM;
  }

  public java.lang.Integer getEsc_seqn_sucessor() {
    return esc_seqn_sucessor;
  }

  public void setEsc_seqn_sucessor(java.lang.Integer PARAM) {
    this.esc_seqn_sucessor = PARAM;
  }

  public java.lang.String getSistema_ri() {
    return sistema_ri;
  }

  public void setSistema_ri(java.lang.String PARAM) {
    this.sistema_ri = PARAM;
  }

  public java.lang.String getOrdem_compra() {
    return ordem_compra;
  }

  public void setOrdem_compra(java.lang.String PARAM) {
    this.ordem_compra = PARAM;
  }

  public java.lang.String getDt_agendamento() {
    return dt_agendamento;
  }

  public void setDt_agendamento(java.lang.String PARAM) {
    this.dt_agendamento = PARAM;
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

  public java.lang.String getData_emissao() {
    return data_emissao;
  }

  public void setData_emissao(java.lang.String PARAM) {
    this.data_emissao = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.String getNf_nmro() {
    return nf_nmro;
  }

  public void setNf_nmro(java.lang.String PARAM) {
    this.nf_nmro = PARAM;
  }

  public java.lang.String getNro_volumes() {
    return nro_volumes;
  }

  public void setNro_volumes(java.lang.String PARAM) {
    this.nro_volumes = PARAM;
  }

  public java.lang.String getCliente_mi() {
    return cliente_mi;
  }

  public void setCliente_mi(java.lang.String PARAM) {
    this.cliente_mi = PARAM;
  }

  public java.lang.String getPossui_carimbo() {
    return possui_carimbo;
  }

  public void setPossui_carimbo(java.lang.String PARAM) {
    this.possui_carimbo = PARAM;
  }

  public java.lang.String getSomente_etiqueta() {
    return somente_etiqueta;
  }

  public void setSomente_etiqueta(java.lang.String PARAM) {
    this.somente_etiqueta = PARAM;
  }

}
