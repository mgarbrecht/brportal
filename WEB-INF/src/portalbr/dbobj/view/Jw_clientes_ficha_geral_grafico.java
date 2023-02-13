package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ficha_geral_grafico
  * @version 03/04/2013 09:45:18
  */
public class Jw_clientes_ficha_geral_grafico implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ano;
  private double vlr;
  private double qtd;

  public Jw_clientes_ficha_geral_grafico() {
  }

  public java.lang.Integer getAno() {
    return ano;
  }

  public void setAno(java.lang.Integer PARAM) {
    this.ano = PARAM;
  }

  public double getVlr() {
    return vlr;
  }

  public void setVlr(double PARAM) {
    this.vlr = PARAM;
  }

  public double getQtd() {
    return qtd;
  }

  public void setQtd(double PARAM) {
    this.qtd = PARAM;
  }

}
