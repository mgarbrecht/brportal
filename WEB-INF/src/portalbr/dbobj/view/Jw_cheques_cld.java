package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cheques_cld
  * @version 03/04/2013 09:49:42
  */
public class Jw_cheques_cld implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String numero;
  private java.lang.String agencia;
  private java.lang.String portador;
  private java.lang.String cod_repres;
  private java.lang.String rep_razao;
  private java.lang.String cliente;
  private java.lang.String nome;
  private java.lang.String tipo;
  private java.lang.String codigo_gerente;
  private double valor_pcp;
  private double valor_deb;
  private double saldo;

  public Jw_cheques_cld() {
  }

  public java.lang.String getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.String PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

  public java.lang.String getNumero() {
    return numero;
  }

  public void setNumero(java.lang.String PARAM) {
    this.numero = PARAM;
  }

  public java.lang.String getAgencia() {
    return agencia;
  }

  public void setAgencia(java.lang.String PARAM) {
    this.agencia = PARAM;
  }

  public java.lang.String getPortador() {
    return portador;
  }

  public void setPortador(java.lang.String PARAM) {
    this.portador = PARAM;
  }

  public java.lang.String getCod_repres() {
    return cod_repres;
  }

  public void setCod_repres(java.lang.String PARAM) {
    this.cod_repres = PARAM;
  }

  public java.lang.String getRep_razao() {
    return rep_razao;
  }

  public void setRep_razao(java.lang.String PARAM) {
    this.rep_razao = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.lang.String getCodigo_gerente() {
    return codigo_gerente;
  }

  public void setCodigo_gerente(java.lang.String PARAM) {
    this.codigo_gerente = PARAM;
  }

  public double getValor_pcp() {
    return valor_pcp;
  }

  public void setValor_pcp(double PARAM) {
    this.valor_pcp = PARAM;
  }

  public double getValor_deb() {
    return valor_deb;
  }

  public void setValor_deb(double PARAM) {
    this.valor_deb = PARAM;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double PARAM) {
    this.saldo = PARAM;
  }

}
