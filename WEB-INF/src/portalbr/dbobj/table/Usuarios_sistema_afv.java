package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Usuarios_sistema_afv
  * @version 03/04/2013 09:05:21
  */
public class Usuarios_sistema_afv implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String codigo_usuario;
  private java.lang.String nome_usuario;
  private java.lang.String senha_usuario;
  private java.lang.Integer codigo_regional;
  private java.lang.String codigo_representante;
  private java.sql.Timestamp data_cadastro;
  private java.lang.String usuario;
  private java.lang.Integer id_tablet;

  public Usuarios_sistema_afv() {
  }

  public java.lang.String getCodigo_usuario() {
    return codigo_usuario;
  }

  public void setCodigo_usuario(java.lang.String PARAM) {
    this.codigo_usuario = PARAM;
  }

  public java.lang.String getNome_usuario() {
    return nome_usuario;
  }

  public void setNome_usuario(java.lang.String PARAM) {
    this.nome_usuario = PARAM;
  }

  public java.lang.String getSenha_usuario() {
    return senha_usuario;
  }

  public void setSenha_usuario(java.lang.String PARAM) {
    this.senha_usuario = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getCodigo_representante() {
    return codigo_representante;
  }

  public void setCodigo_representante(java.lang.String PARAM) {
    this.codigo_representante = PARAM;
  }

  public java.sql.Timestamp getData_cadastro() {
    return data_cadastro;
  }

  public void setData_cadastro(java.sql.Timestamp PARAM) {
    this.data_cadastro = PARAM;
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

  public java.lang.Integer getId_tablet() {
    return id_tablet;
  }

  public void setId_tablet(java.lang.Integer PARAM) {
    this.id_tablet = PARAM;
  }

}
