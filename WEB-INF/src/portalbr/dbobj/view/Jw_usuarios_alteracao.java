package portalbr.dbobj.view;

/** DataBase Object from table .Jw_usuarios_alteracao
  * @version 16/09/2015 16:38:39
  */
public class Jw_usuarios_alteracao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String usuario;
  private java.lang.String nome;
  private java.sql.Timestamp data_alteracao;
  private java.lang.String usuario_alteracao;

  public Jw_usuarios_alteracao() {
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.sql.Timestamp getData_alteracao() {
    return data_alteracao;
  }

  public void setData_alteracao(java.sql.Timestamp PARAM) {
    this.data_alteracao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

}
