package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_nota_titulo
  * @version 27/05/2019 11:55:28
  */
public class Jw_t_nota_titulo implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String nota;
  private java.lang.String serie;
  private java.lang.String filial;
  private java.lang.String ped_nmro;
  private java.lang.String pedido;
  private java.lang.String esc_cgc;
  private java.lang.String cli_rzao;

  public Jw_t_nota_titulo() {
  }

  public java.lang.String getNota() {
    return nota;
  }

  public void setNota(java.lang.String PARAM) {
    this.nota = PARAM;
  }

  public java.lang.String getSerie() {
    return serie;
  }

  public void setSerie(java.lang.String PARAM) {
    this.serie = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.String getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.String PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getPedido() {
    return pedido;
  }

  public void setPedido(java.lang.String PARAM) {
    this.pedido = PARAM;
  }

  public java.lang.String getEsc_cgc() {
    return esc_cgc;
  }

  public void setEsc_cgc(java.lang.String PARAM) {
    this.esc_cgc = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

}
