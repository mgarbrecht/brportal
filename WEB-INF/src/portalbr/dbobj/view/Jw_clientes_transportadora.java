package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_transportadora
  * @version 03/10/2018 12:32:36
  */
public class Jw_clientes_transportadora implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_transportadora;
  private java.lang.String razao_transportadora;
  private java.lang.Integer codigo_cliente;
  private java.lang.String razao_social;
  private java.lang.String cidade;
  private java.lang.String uf;
  private java.lang.String consignatario;

  public Jw_clientes_transportadora() {
  }

  public java.lang.Integer getCodigo_transportadora() {
    return codigo_transportadora;
  }

  public void setCodigo_transportadora(java.lang.Integer PARAM) {
    this.codigo_transportadora = PARAM;
  }

  public java.lang.String getRazao_transportadora() {
    return razao_transportadora;
  }

  public void setRazao_transportadora(java.lang.String PARAM) {
    this.razao_transportadora = PARAM;
  }

  public java.lang.Integer getCodigo_cliente() {
    return codigo_cliente;
  }

  public void setCodigo_cliente(java.lang.Integer PARAM) {
    this.codigo_cliente = PARAM;
  }

  public java.lang.String getRazao_social() {
    return razao_social;
  }

  public void setRazao_social(java.lang.String PARAM) {
    this.razao_social = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

  public java.lang.String getUf() {
    return uf;
  }

  public void setUf(java.lang.String PARAM) {
    this.uf = PARAM;
  }

  public java.lang.String getConsignatario() {
    return consignatario;
  }

  public void setConsignatario(java.lang.String PARAM) {
    this.consignatario = PARAM;
  }

}
