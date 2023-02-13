package portalbr.dbobj.table;

/** DataBase Object from table DEV.Municipios
  * @version 18/11/2013 11:35:24
  */
public class Municipios implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo;
  private java.lang.String est_unifed;
  private java.lang.Integer est_pais_codigo;
  private java.lang.String descricao;
  private java.lang.String usuario_cad;
  private java.sql.Timestamp data_cad;
  private java.lang.String complemento;
  private java.lang.Integer populacao;
  private java.lang.Integer eleitores;
  private java.lang.Integer votos;
  private java.lang.Integer prc_numero_praca_compensacao;
  private java.lang.String indicador_comissao;
  private java.sql.Timestamp data_log_afv;
  private java.lang.Double ipc;
  private java.lang.String codigo_ibge;
  private java.lang.String reg_cdgo;

  public Municipios() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getEst_unifed() {
    return est_unifed;
  }

  public void setEst_unifed(java.lang.String PARAM) {
    this.est_unifed = PARAM;
  }

  public java.lang.Integer getEst_pais_codigo() {
    return est_pais_codigo;
  }

  public void setEst_pais_codigo(java.lang.Integer PARAM) {
    this.est_pais_codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getUsuario_cad() {
    return usuario_cad;
  }

  public void setUsuario_cad(java.lang.String PARAM) {
    this.usuario_cad = PARAM;
  }

  public java.sql.Timestamp getData_cad() {
    return data_cad;
  }

  public void setData_cad(java.sql.Timestamp PARAM) {
    this.data_cad = PARAM;
  }

  public java.lang.String getComplemento() {
    return complemento;
  }

  public void setComplemento(java.lang.String PARAM) {
    this.complemento = PARAM;
  }

  public java.lang.Integer getPopulacao() {
    return populacao;
  }

  public void setPopulacao(java.lang.Integer PARAM) {
    this.populacao = PARAM;
  }

  public java.lang.Integer getEleitores() {
    return eleitores;
  }

  public void setEleitores(java.lang.Integer PARAM) {
    this.eleitores = PARAM;
  }

  public java.lang.Integer getVotos() {
    return votos;
  }

  public void setVotos(java.lang.Integer PARAM) {
    this.votos = PARAM;
  }

  public java.lang.Integer getPrc_numero_praca_compensacao() {
    return prc_numero_praca_compensacao;
  }

  public void setPrc_numero_praca_compensacao(java.lang.Integer PARAM) {
    this.prc_numero_praca_compensacao = PARAM;
  }

  public java.lang.String getIndicador_comissao() {
    return indicador_comissao;
  }

  public void setIndicador_comissao(java.lang.String PARAM) {
    this.indicador_comissao = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.lang.Double getIpc() {
    return ipc;
  }

  public void setIpc(java.lang.Double PARAM) {
    this.ipc = PARAM;
  }

  public java.lang.String getCodigo_ibge() {
    return codigo_ibge;
  }

  public void setCodigo_ibge(java.lang.String PARAM) {
    this.codigo_ibge = PARAM;
  }

  public java.lang.String getReg_cdgo() {
    return reg_cdgo;
  }

  public void setReg_cdgo(java.lang.String PARAM) {
    this.reg_cdgo = PARAM;
  }

}
