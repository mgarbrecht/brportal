package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ficha_geral
  * @version 03/04/2013 09:45:27
  */
public class Jw_clientes_ficha_geral implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ano;
  private java.lang.Double vlr_atual;
  private java.lang.Integer qtd_atual;
  private java.lang.Integer vlr_anterior;
  private java.lang.Integer qtd_anterior;

  public Jw_clientes_ficha_geral() {
  }

  public java.lang.Integer getAno() {
    return ano;
  }

  public void setAno(java.lang.Integer PARAM) {
    this.ano = PARAM;
  }

  public java.lang.Double getVlr_atual() {
    return vlr_atual;
  }

  public void setVlr_atual(java.lang.Double PARAM) {
    this.vlr_atual = PARAM;
  }

  public java.lang.Integer getQtd_atual() {
    return qtd_atual;
  }

  public void setQtd_atual(java.lang.Integer PARAM) {
    this.qtd_atual = PARAM;
  }

  public java.lang.Integer getVlr_anterior() {
    return vlr_anterior;
  }

  public void setVlr_anterior(java.lang.Integer PARAM) {
    this.vlr_anterior = PARAM;
  }

  public java.lang.Integer getQtd_anterior() {
    return qtd_anterior;
  }

  public void setQtd_anterior(java.lang.Integer PARAM) {
    this.qtd_anterior = PARAM;
  }

}
