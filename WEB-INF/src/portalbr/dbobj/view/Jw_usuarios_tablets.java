package portalbr.dbobj.view;

/** DataBase Object from table .Jw_usuarios_tablets
  * @version 01/11/2011 09:00:00
  */
public class Jw_usuarios_tablets implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_usuario;
  private java.lang.String nome_usuario;
  private java.lang.String senha_usuario;
  private java.lang.Integer codigo_regional;
  private java.lang.String email;

  public Jw_usuarios_tablets() {
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

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
  }

}
