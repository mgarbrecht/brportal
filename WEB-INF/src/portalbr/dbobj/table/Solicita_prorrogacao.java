package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Solicita_prorrogacao
  * @version 16/01/2012 11:02:31
  */
public class Solicita_prorrogacao implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer id_solicitacao;
  private java.lang.Integer nfs_nmro;
  private java.lang.String fil_filial;
  private java.lang.String nfs_serie;
  private java.lang.String emp_empresa;
  private java.lang.Integer nro_dias_prorrogacao;
  private java.lang.Double valor_calculado;
  private java.sql.Timestamp data_solicitacao;
  private java.lang.String usuario_solicitacao;
  private java.lang.String situacao;
  private java.sql.Timestamp data_aprovacao;
  private java.lang.String usuario_aprovacao;
  private java.lang.Integer codigo_historico;
  private java.lang.String motivo;
  private java.lang.Double comissao_nova;

  public Solicita_prorrogacao() {
  }

  public java.lang.Integer getId_solicitacao() {
    return id_solicitacao;
  }

  public void setId_solicitacao(java.lang.Integer PARAM) {
    this.id_solicitacao = PARAM;
  }

  public java.lang.Integer getNfs_nmro() {
    return nfs_nmro;
  }

  public void setNfs_nmro(java.lang.Integer PARAM) {
    this.nfs_nmro = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getNfs_serie() {
    return nfs_serie;
  }

  public void setNfs_serie(java.lang.String PARAM) {
    this.nfs_serie = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.Integer getNro_dias_prorrogacao() {
    return nro_dias_prorrogacao;
  }

  public void setNro_dias_prorrogacao(java.lang.Integer PARAM) {
    this.nro_dias_prorrogacao = PARAM;
  }

  public java.lang.Double getValor_calculado() {
    return valor_calculado;
  }

  public void setValor_calculado(java.lang.Double PARAM) {
    this.valor_calculado = PARAM;
  }

  public java.sql.Timestamp getData_solicitacao() {
    return data_solicitacao;
  }

  public void setData_solicitacao(java.sql.Timestamp PARAM) {
    this.data_solicitacao = PARAM;
  }

  public java.lang.String getUsuario_solicitacao() {
    return usuario_solicitacao;
  }

  public void setUsuario_solicitacao(java.lang.String PARAM) {
    this.usuario_solicitacao = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.sql.Timestamp getData_aprovacao() {
    return data_aprovacao;
  }

  public void setData_aprovacao(java.sql.Timestamp PARAM) {
    this.data_aprovacao = PARAM;
  }

  public java.lang.String getUsuario_aprovacao() {
    return usuario_aprovacao;
  }

  public void setUsuario_aprovacao(java.lang.String PARAM) {
    this.usuario_aprovacao = PARAM;
  }

  public java.lang.Integer getCodigo_historico() {
    return codigo_historico;
  }

  public void setCodigo_historico(java.lang.Integer PARAM) {
    this.codigo_historico = PARAM;
  }

  public java.lang.String getMotivo() {
    return motivo;
  }

  public void setMotivo(java.lang.String PARAM) {
    this.motivo = PARAM;
  }

  public java.lang.Double getComissao_nova() {
    return comissao_nova;
  }

  public void setComissao_nova(java.lang.Double PARAM) {
    this.comissao_nova = PARAM;
  }

}
