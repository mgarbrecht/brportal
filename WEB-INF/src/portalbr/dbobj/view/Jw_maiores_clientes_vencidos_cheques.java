package portalbr.dbobj.view;

/** DataBase Object from table .Jw_maiores_clientes_vencidos_cheques
  * @version 03/04/2013 09:22:38
  */
public class Jw_maiores_clientes_vencidos_cheques implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo;
  private java.lang.String fone;
  private java.lang.String cliente;
  private java.lang.String ecl_cdad;
  private java.lang.Integer dias;
  private java.lang.Double valor;

  public Jw_maiores_clientes_vencidos_cheques() {
  }

  public java.lang.String getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.String PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getFone() {
    return fone;
  }

  public void setFone(java.lang.String PARAM) {
    this.fone = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.String getEcl_cdad() {
    return ecl_cdad;
  }

  public void setEcl_cdad(java.lang.String PARAM) {
    this.ecl_cdad = PARAM;
  }

  public java.lang.Integer getDias() {
    return dias;
  }

  public void setDias(java.lang.Integer PARAM) {
    this.dias = PARAM;
  }

  public java.lang.Double getValor() {
    return valor;
  }

  public void setValor(java.lang.Double PARAM) {
    this.valor = PARAM;
  }

}
