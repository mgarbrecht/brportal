package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Parametros
  * @version 01/08/2014 12:32:05
  */
public class Parametros implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String nome;
  private java.lang.String valor;
  private java.lang.String par_sist_codigo;
  private java.lang.String email;

  public Parametros() {
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.lang.String getValor() {
    return valor;
  }

  public void setValor(java.lang.String PARAM) {
    this.valor = PARAM;
  }

  public java.lang.String getPar_sist_codigo() {
    return par_sist_codigo;
  }

  public void setPar_sist_codigo(java.lang.String PARAM) {
    this.par_sist_codigo = PARAM;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
  }

}
