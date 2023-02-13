package portalbr.dbobj.table;

/** DataBase Object from table EDI.Interface_arquivo_compra
  * @version 10/08/2015 08:09:30
  */
public class Interface_arquivo_compra implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer interface_arquivo_compra_id;
  private java.lang.Integer for_codigo;
  private java.lang.String nome_arquivo;
  private java.lang.String tipo;
  private java.lang.String ativo;
  private java.lang.String situacao;
  private java.lang.String usuario_inclusao;
  private java.sql.Timestamp dthr_inclusao;
  private java.lang.String usuario_alteracao;
  private java.sql.Timestamp dthr_alteracao;

  public Interface_arquivo_compra() {
  }

  public java.lang.Integer getInterface_arquivo_compra_id() {
    return interface_arquivo_compra_id;
  }

  public void setInterface_arquivo_compra_id(java.lang.Integer PARAM) {
    this.interface_arquivo_compra_id = PARAM;
  }

  public java.lang.Integer getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.Integer PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.String getNome_arquivo() {
    return nome_arquivo;
  }

  public void setNome_arquivo(java.lang.String PARAM) {
    this.nome_arquivo = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.lang.String getAtivo() {
    return ativo;
  }

  public void setAtivo(java.lang.String PARAM) {
    this.ativo = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

}
