package portalbr.dbobj.view;

/** DataBase Object from table .Jw_comunicacao_rel
  * @version 16/05/2014 09:10:36
  */
public class Jw_comunicacao_rel implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Date data_comunicacao;
  private java.lang.Integer sequencia;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.Integer codigo_argumento;
  private java.lang.String descricao_argumento;
  private java.lang.Integer codigo_colecao;
  private java.lang.String descricao;
  private java.lang.Integer codigo_marca;
  private java.lang.String descricao_marca;
  private java.lang.Integer lin_cdgo;
  private java.sql.Clob descricao_comunicacao;
  private java.sql.Date data_retorno;
  private java.lang.String usuario_retorno;
  private java.sql.Clob descricao_retorno;
  private java.lang.Integer qtd_retornos;

  public Jw_comunicacao_rel() {
  }

  public java.sql.Date getData_comunicacao() {
    return data_comunicacao;
  }

  public void setData_comunicacao(java.sql.Date PARAM) {
    this.data_comunicacao = PARAM;
  }

  public java.lang.Integer getSequencia() {
    return sequencia;
  }

  public void setSequencia(java.lang.Integer PARAM) {
    this.sequencia = PARAM;
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

  public java.lang.Integer getCodigo_argumento() {
    return codigo_argumento;
  }

  public void setCodigo_argumento(java.lang.Integer PARAM) {
    this.codigo_argumento = PARAM;
  }

  public java.lang.String getDescricao_argumento() {
    return descricao_argumento;
  }

  public void setDescricao_argumento(java.lang.String PARAM) {
    this.descricao_argumento = PARAM;
  }

  public java.lang.Integer getCodigo_colecao() {
    return codigo_colecao;
  }

  public void setCodigo_colecao(java.lang.Integer PARAM) {
    this.codigo_colecao = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.sql.Clob getDescricao_comunicacao() {
    return descricao_comunicacao;
  }

  public void setDescricao_comunicacao(java.sql.Clob PARAM) {
    this.descricao_comunicacao = PARAM;
  }

  public java.sql.Date getData_retorno() {
    return data_retorno;
  }

  public void setData_retorno(java.sql.Date PARAM) {
    this.data_retorno = PARAM;
  }

  public java.lang.String getUsuario_retorno() {
    return usuario_retorno;
  }

  public void setUsuario_retorno(java.lang.String PARAM) {
    this.usuario_retorno = PARAM;
  }

  public java.sql.Clob getDescricao_retorno() {
    return descricao_retorno;
  }

  public void setDescricao_retorno(java.sql.Clob PARAM) {
    this.descricao_retorno = PARAM;
  }

  public java.lang.Integer getQtd_retornos() {
    return qtd_retornos;
  }

  public void setQtd_retornos(java.lang.Integer PARAM) {
    this.qtd_retornos = PARAM;
  }

}
