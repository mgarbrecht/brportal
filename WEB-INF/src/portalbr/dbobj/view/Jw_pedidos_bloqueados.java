package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedidos_bloqueados
  * @version 03/04/2013 09:19:32
  */
public class Jw_pedidos_bloqueados implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String representante;
  private java.sql.Timestamp entrega;
  private java.lang.String digitacao;
  private java.lang.String cli_cdgo;
  private java.lang.String cli_rzao;
  private java.lang.String ped_nmro;
  private java.lang.String tipo;
  private java.lang.String ped_nped;

  public Jw_pedidos_bloqueados() {
  }

  public java.lang.String getRepresentante() {
    return representante;
  }

  public void setRepresentante(java.lang.String PARAM) {
    this.representante = PARAM;
  }

  public java.sql.Timestamp getEntrega() {
    return entrega;
  }

  public void setEntrega(java.sql.Timestamp PARAM) {
    this.entrega = PARAM;
  }

  public java.lang.String getDigitacao() {
    return digitacao;
  }

  public void setDigitacao(java.lang.String PARAM) {
    this.digitacao = PARAM;
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.String PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.lang.String getPed_nped() {
    return ped_nped;
  }

  public void setPed_nped(java.lang.String PARAM) {
    this.ped_nped = PARAM;
  }

}
