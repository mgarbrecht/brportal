package portalbr.dbobj.view;

/** DataBase Object from table .Jw_necessidade_materiais_faturas
  * @version 19/03/2015 14:50:19
  */
public class Jw_necessidade_materiais_faturas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String fatura;
  private java.lang.Integer pares;

  public Jw_necessidade_materiais_faturas() {
  }

  public java.lang.String getFatura() {
    return fatura;
  }

  public void setFatura(java.lang.String PARAM) {
    this.fatura = PARAM;
  }

  public java.lang.Integer getPares() {
    return pares;
  }

  public void setPares(java.lang.Integer PARAM) {
    this.pares = PARAM;
  }

}
