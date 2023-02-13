package portalbr.dbobj.view;

/** DataBase Object from table .Jw_atelieres_quarterizados_cep
  * @version 14/01/2015 09:39:56
  */
public class Jw_atelieres_quarterizados_cep implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String rua;
  private java.lang.String cidade;
  private java.lang.String bairro;
  private java.lang.String uf;
  private java.lang.String cep1;
  private double cep2;
  private java.lang.String tipo;

  public Jw_atelieres_quarterizados_cep() {
  }

  public java.lang.String getRua() {
    return rua;
  }

  public void setRua(java.lang.String PARAM) {
    this.rua = PARAM;
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

  public java.lang.String getUf() {
    return uf;
  }

  public void setUf(java.lang.String PARAM) {
    this.uf = PARAM;
  }

  public java.lang.String getCep1() {
    return cep1;
  }

  public void setCep1(java.lang.String PARAM) {
    this.cep1 = PARAM;
  }

  public double getCep2() {
    return cep2;
  }

  public void setCep2(double PARAM) {
    this.cep2 = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

}
