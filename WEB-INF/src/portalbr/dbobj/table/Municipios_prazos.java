package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Municipios_prazos
  * @version 18/11/2013 16:00:09
  */
public class Municipios_prazos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo;
  private java.lang.String codigo_ibge;
  private java.lang.Integer prazo_entrega;
  private java.lang.String sigla_transportadora;
  private java.lang.String est_unifed;
  private java.lang.String segunda;
  private java.lang.String terca;
  private java.lang.String quarda;
  private java.lang.String quinta;
  private java.lang.String sexta;
  private java.lang.String sabado;
  private java.lang.String domingo;
  private java.sql.Timestamp dthr_inclusao;
  private java.lang.String usuario_inclusao;
  private java.sql.Timestamp dthr_alteracao;
  private java.lang.String usuario_alteracao;
  private java.lang.String descricao;
  private java.lang.Integer id;

  public Municipios_prazos() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getCodigo_ibge() {
    return codigo_ibge;
  }

  public void setCodigo_ibge(java.lang.String PARAM) {
    this.codigo_ibge = PARAM;
  }

  public java.lang.Integer getPrazo_entrega() {
    return prazo_entrega;
  }

  public void setPrazo_entrega(java.lang.Integer PARAM) {
    this.prazo_entrega = PARAM;
  }

  public java.lang.String getSigla_transportadora() {
    return sigla_transportadora;
  }

  public void setSigla_transportadora(java.lang.String PARAM) {
    this.sigla_transportadora = PARAM;
  }

  public java.lang.String getEst_unifed() {
    return est_unifed;
  }

  public void setEst_unifed(java.lang.String PARAM) {
    this.est_unifed = PARAM;
  }

  public java.lang.String getSegunda() {
    return segunda;
  }

  public void setSegunda(java.lang.String PARAM) {
    this.segunda = PARAM;
  }

  public java.lang.String getTerca() {
    return terca;
  }

  public void setTerca(java.lang.String PARAM) {
    this.terca = PARAM;
  }

  public java.lang.String getQuarda() {
    return quarda;
  }

  public void setQuarda(java.lang.String PARAM) {
    this.quarda = PARAM;
  }

  public java.lang.String getQuinta() {
    return quinta;
  }

  public void setQuinta(java.lang.String PARAM) {
    this.quinta = PARAM;
  }

  public java.lang.String getSexta() {
    return sexta;
  }

  public void setSexta(java.lang.String PARAM) {
    this.sexta = PARAM;
  }

  public java.lang.String getSabado() {
    return sabado;
  }

  public void setSabado(java.lang.String PARAM) {
    this.sabado = PARAM;
  }

  public java.lang.String getDomingo() {
    return domingo;
  }

  public void setDomingo(java.lang.String PARAM) {
    this.domingo = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getId() {
    return id;
  }

  public void setId(java.lang.Integer PARAM) {
    this.id = PARAM;
  }

}
