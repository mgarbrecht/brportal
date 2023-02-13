package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Comunicacao
  * @version 03/04/2013 10:01:22
  */
public class Comunicacao implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int sequencia;
  private java.lang.String rep_cdgo;
  private java.lang.Integer cli_cdgo;
  private java.sql.Clob descricao_comunicacao;
  private java.sql.Timestamp data_comunicacao;
  private java.lang.String usuario_cadastramento;
  private java.lang.Integer codigo_colecao;
  private java.lang.Integer codigo_argumento;
  private java.lang.Integer codigo_marca;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer cab_cdgo;
  private java.lang.Integer cor_cdgo;
  private java.lang.String status;

  public Comunicacao() {
  }

  public int getSequencia() {
    return sequencia;
  }

  public void setSequencia(int PARAM) {
    this.sequencia = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.sql.Clob getDescricao_comunicacao() {
    return descricao_comunicacao;
  }

  public void setDescricao_comunicacao(java.sql.Clob PARAM) {
    this.descricao_comunicacao = PARAM;
  }

  public java.sql.Timestamp getData_comunicacao() {
    return data_comunicacao;
  }

  public void setData_comunicacao(java.sql.Timestamp PARAM) {
    this.data_comunicacao = PARAM;
  }

  public java.lang.String getUsuario_cadastramento() {
    return usuario_cadastramento;
  }

  public void setUsuario_cadastramento(java.lang.String PARAM) {
    this.usuario_cadastramento = PARAM;
  }

  public java.lang.Integer getCodigo_colecao() {
    return codigo_colecao;
  }

  public void setCodigo_colecao(java.lang.Integer PARAM) {
    this.codigo_colecao = PARAM;
  }

  public java.lang.Integer getCodigo_argumento() {
    return codigo_argumento;
  }

  public void setCodigo_argumento(java.lang.Integer PARAM) {
    this.codigo_argumento = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.Integer getCab_cdgo() {
    return cab_cdgo;
  }

  public void setCab_cdgo(java.lang.Integer PARAM) {
    this.cab_cdgo = PARAM;
  }

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

}
