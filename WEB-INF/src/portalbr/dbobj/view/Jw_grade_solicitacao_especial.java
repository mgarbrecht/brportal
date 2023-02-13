package portalbr.dbobj.view;

/** DataBase Object from table .Jw_grade_solicitacao_especial
  * @version 03/04/2013 09:27:29
  */
public class Jw_grade_solicitacao_especial implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer numeracao;
  private java.lang.Integer pares;
  private java.lang.Integer lin_cdgo;

  public Jw_grade_solicitacao_especial() {
  }

  public java.lang.Integer getNumeracao() {
    return numeracao;
  }

  public void setNumeracao(java.lang.Integer PARAM) {
    this.numeracao = PARAM;
  }

  public java.lang.Integer getPares() {
    return pares;
  }

  public void setPares(java.lang.Integer PARAM) {
    this.pares = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

}
