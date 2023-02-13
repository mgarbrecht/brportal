package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_situacao_importacao
  * @version 23/01/2017 09:36:48
  */
public class Jw_consulta_situacao_importacao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String tipo;
  private java.lang.Integer pares;
  private double valor;

  public Jw_consulta_situacao_importacao() {
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.lang.Integer getPares() {
    return pares;
  }

  public void setPares(java.lang.Integer PARAM) {
    this.pares = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

}
