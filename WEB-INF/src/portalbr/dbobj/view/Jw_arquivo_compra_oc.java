package portalbr.dbobj.view;

/** DataBase Object from table .Jw_arquivo_compra_oc
  * @version 12/08/2015 11:52:07
  */
public class Jw_arquivo_compra_oc implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer interface_arquivo_compra_id;
  private java.lang.Integer forn_codigo;
  private java.lang.Integer oco_numero;
  private java.lang.Integer rem_nro;
  private java.sql.Timestamp data_compra;
  private java.lang.String nome_arquivo;
  private java.lang.String tipo;
  private java.lang.String ativo;
  private java.lang.String situacao;
  private java.lang.String descricao_situacao;

  public Jw_arquivo_compra_oc() {
  }

  public java.lang.Integer getInterface_arquivo_compra_id() {
    return interface_arquivo_compra_id;
  }

  public void setInterface_arquivo_compra_id(java.lang.Integer PARAM) {
    this.interface_arquivo_compra_id = PARAM;
  }

  public java.lang.Integer getForn_codigo() {
    return forn_codigo;
  }

  public void setForn_codigo(java.lang.Integer PARAM) {
    this.forn_codigo = PARAM;
  }

  public java.lang.Integer getOco_numero() {
    return oco_numero;
  }

  public void setOco_numero(java.lang.Integer PARAM) {
    this.oco_numero = PARAM;
  }

  public java.lang.Integer getRem_nro() {
    return rem_nro;
  }

  public void setRem_nro(java.lang.Integer PARAM) {
    this.rem_nro = PARAM;
  }

  public java.sql.Timestamp getData_compra() {
    return data_compra;
  }

  public void setData_compra(java.sql.Timestamp PARAM) {
    this.data_compra = PARAM;
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

  public java.lang.String getDescricao_situacao() {
    return descricao_situacao;
  }

  public void setDescricao_situacao(java.lang.String PARAM) {
    this.descricao_situacao = PARAM;
  }

}
