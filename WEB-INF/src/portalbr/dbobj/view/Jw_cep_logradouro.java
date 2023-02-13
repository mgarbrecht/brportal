package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cep_logradouro
  * @version 03/04/2013 09:50:04
  */
public class Jw_cep_logradouro implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String logradouro;
  private java.lang.String cidade;
  private java.lang.String bairro;
  private java.lang.String cep;
  private java.lang.String uf;

  public Jw_cep_logradouro() {
  }

  public java.lang.String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(java.lang.String PARAM) {
    this.logradouro = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

  public java.lang.String getBairro() {
    return bairro;
  }

  public void setBairro(java.lang.String PARAM) {
    this.bairro = PARAM;
  }

  public java.lang.String getCep() {
    return cep;
  }

  public void setCep(java.lang.String PARAM) {
    this.cep = PARAM;
  }

  public java.lang.String getUf() {
    return uf;
  }

  public void setUf(java.lang.String PARAM) {
    this.uf = PARAM;
  }

}
