package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_contatos
  * @version 03/04/2013 09:30:15
  */
public class Jw_ficha_cliente_contatos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String nome;
  private java.lang.String email;
  private java.lang.String tipo;
  private java.sql.Date data_nascimento;

  public Jw_ficha_cliente_contatos() {
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.sql.Date getData_nascimento() {
    return data_nascimento;
  }

  public void setData_nascimento(java.sql.Date PARAM) {
    this.data_nascimento = PARAM;
  }

}
