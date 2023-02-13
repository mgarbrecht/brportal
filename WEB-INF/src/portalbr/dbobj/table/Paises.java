package portalbr.dbobj.table;

/** DataBase Object from table DEV.Paises
  * @version 02/04/2012 09:46:09
  */
public class Paises implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo;
  private java.lang.String descricao;
  private java.sql.Timestamp data_cad;
  private java.lang.String sigla;
  private java.lang.String usuario_cad;
  private java.lang.String con_codigo;
  private java.lang.String codigo_siscomex;
  private java.lang.String codigo_ibge;

  public Paises() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.sql.Timestamp getData_cad() {
    return data_cad;
  }

  public void setData_cad(java.sql.Timestamp PARAM) {
    this.data_cad = PARAM;
  }

  public java.lang.String getSigla() {
    return sigla;
  }

  public void setSigla(java.lang.String PARAM) {
    this.sigla = PARAM;
  }

  public java.lang.String getUsuario_cad() {
    return usuario_cad;
  }

  public void setUsuario_cad(java.lang.String PARAM) {
    this.usuario_cad = PARAM;
  }

  public java.lang.String getCon_codigo() {
    return con_codigo;
  }

  public void setCon_codigo(java.lang.String PARAM) {
    this.con_codigo = PARAM;
  }

  public java.lang.String getCodigo_siscomex() {
    return codigo_siscomex;
  }

  public void setCodigo_siscomex(java.lang.String PARAM) {
    this.codigo_siscomex = PARAM;
  }

  public java.lang.String getCodigo_ibge() {
    return codigo_ibge;
  }

  public void setCodigo_ibge(java.lang.String PARAM) {
    this.codigo_ibge = PARAM;
  }

}
