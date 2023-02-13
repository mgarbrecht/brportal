package portalbr.dbobj.view;

/** DataBase Object from table .Jw_maiores_clientes_vencidos
  * @version 03/04/2013 09:22:50
  */
public class Jw_maiores_clientes_vencidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_regional;
  private java.lang.String grupo_economico;
  private java.lang.String codigo;
  private java.lang.String sequencial;
  private java.lang.String fone;
  private java.lang.String cliente;
  private java.lang.String ecl_cdad;
  private java.lang.String dias;
  private double valor;
  private java.lang.String observacao;

  public Jw_maiores_clientes_vencidos() {
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getGrupo_economico() {
    return grupo_economico;
  }

  public void setGrupo_economico(java.lang.String PARAM) {
    this.grupo_economico = PARAM;
  }

  public java.lang.String getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.String PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getSequencial() {
    return sequencial;
  }

  public void setSequencial(java.lang.String PARAM) {
    this.sequencial = PARAM;
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

  public java.lang.String getDias() {
    return dias;
  }

  public void setDias(java.lang.String PARAM) {
    this.dias = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

}
