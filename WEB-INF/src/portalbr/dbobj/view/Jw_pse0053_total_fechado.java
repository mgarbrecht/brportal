package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_total_fechado
  * @version 10/03/2020 14:17:02
  */
public class Jw_pse0053_total_fechado implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer pro_numero;
  private java.lang.String pro_nome;
  private java.lang.Double pares;
  private java.lang.Double preco;
  private java.lang.Double total;
  private java.lang.Integer fen_seq;

  public Jw_pse0053_total_fechado() {
  }

  public java.lang.Integer getPro_numero() {
    return pro_numero;
  }

  public void setPro_numero(java.lang.Integer PARAM) {
    this.pro_numero = PARAM;
  }

  public java.lang.String getPro_nome() {
    return pro_nome;
  }

  public void setPro_nome(java.lang.String PARAM) {
    this.pro_nome = PARAM;
  }

  public java.lang.Double getPares() {
    return pares;
  }

  public void setPares(java.lang.Double PARAM) {
    this.pares = PARAM;
  }

  public java.lang.Double getPreco() {
    return preco;
  }

  public void setPreco(java.lang.Double PARAM) {
    this.preco = PARAM;
  }

  public java.lang.Double getTotal() {
    return total;
  }

  public void setTotal(java.lang.Double PARAM) {
    this.total = PARAM;
  }

  public java.lang.Integer getFen_seq() {
    return fen_seq;
  }

  public void setFen_seq(java.lang.Integer PARAM) {
    this.fen_seq = PARAM;
  }

}
