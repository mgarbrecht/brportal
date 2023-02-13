package portalbr.dbobj.view;

/** DataBase Object from table .Jw_aprovacao_alteracao_comissao
  * @version 03/04/2013 09:50:48
  */
public class Jw_aprovacao_alteracao_comissao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer id_solicitacao;
  private java.lang.String usuario_solicitacao;
  private java.sql.Timestamp data_solicitacao;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private java.lang.String cli_rzao;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.Integer nfs_nmro;
  private java.lang.String nfs_serie;
  private java.lang.Double valor_total;
  private java.lang.Double valor_calculado;
  private java.lang.String motivo;
  private java.lang.Double valor_aprovado_parcial;

  public Jw_aprovacao_alteracao_comissao() {
  }

  public java.lang.Integer getId_solicitacao() {
    return id_solicitacao;
  }

  public void setId_solicitacao(java.lang.Integer PARAM) {
    this.id_solicitacao = PARAM;
  }

  public java.lang.String getUsuario_solicitacao() {
    return usuario_solicitacao;
  }

  public void setUsuario_solicitacao(java.lang.String PARAM) {
    this.usuario_solicitacao = PARAM;
  }

  public java.sql.Timestamp getData_solicitacao() {
    return data_solicitacao;
  }

  public void setData_solicitacao(java.sql.Timestamp PARAM) {
    this.data_solicitacao = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
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

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.Integer getNfs_nmro() {
    return nfs_nmro;
  }

  public void setNfs_nmro(java.lang.Integer PARAM) {
    this.nfs_nmro = PARAM;
  }

  public java.lang.String getNfs_serie() {
    return nfs_serie;
  }

  public void setNfs_serie(java.lang.String PARAM) {
    this.nfs_serie = PARAM;
  }

  public java.lang.Double getValor_total() {
    return valor_total;
  }

  public void setValor_total(java.lang.Double PARAM) {
    this.valor_total = PARAM;
  }

  public java.lang.Double getValor_calculado() {
    return valor_calculado;
  }

  public void setValor_calculado(java.lang.Double PARAM) {
    this.valor_calculado = PARAM;
  }

  public java.lang.String getMotivo() {
    return motivo;
  }

  public void setMotivo(java.lang.String PARAM) {
    this.motivo = PARAM;
  }

  public java.lang.Double getValor_aprovado_parcial() {
    return valor_aprovado_parcial;
  }

  public void setValor_aprovado_parcial(java.lang.Double PARAM) {
    this.valor_aprovado_parcial = PARAM;
  }

}
