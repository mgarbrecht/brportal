package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_cliente_devolucoes_transportadoras
  * @version 03/04/2013 09:29:56
  */
public class Jw_ficha_cliente_devolucoes_transportadoras implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer gre_grupo;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private int pares;
  private double valor;

  public Jw_ficha_cliente_devolucoes_transportadoras() {
  }

  public java.lang.Integer getGre_grupo() {
    return gre_grupo;
  }

  public void setGre_grupo(java.lang.Integer PARAM) {
    this.gre_grupo = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public int getPares() {
    return pares;
  }

  public void setPares(int PARAM) {
    this.pares = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

}
