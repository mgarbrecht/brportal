package portalbr.dbobj.view;

/** DataBase Object from table .Jw_usuarios_troca_senha
  * @version 03/02/2011 07:49:56
  */
public class Jw_usuarios_troca_senha implements java.io.Serializable, com.egen.util.jdbc.View {
  private int usua_id;
  private java.lang.String usua_usuario;
  private java.lang.String usua_nome;
  private java.lang.String usua_email;

  public Jw_usuarios_troca_senha() {
  }

  public int getUsua_id() {
    return usua_id;
  }

  public void setUsua_id(int PARAM) {
    this.usua_id = PARAM;
  }

  public java.lang.String getUsua_usuario() {
    return usua_usuario;
  }

  public void setUsua_usuario(java.lang.String PARAM) {
    this.usua_usuario = PARAM;
  }

  public java.lang.String getUsua_nome() {
    return usua_nome;
  }

  public void setUsua_nome(java.lang.String PARAM) {
    this.usua_nome = PARAM;
  }

  public java.lang.String getUsua_email() {
    return usua_email;
  }

  public void setUsua_email(java.lang.String PARAM) {
    this.usua_email = PARAM;
  }

}
