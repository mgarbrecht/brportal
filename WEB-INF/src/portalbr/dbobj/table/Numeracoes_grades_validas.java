package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Numeracoes_grades_validas
  * @version 06/02/2012 11:14:49
  */
public class Numeracoes_grades_validas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer numeracao_inicial;
  private java.lang.Integer numeracao_final;

  public Numeracoes_grades_validas() {
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getNumeracao_inicial() {
    return numeracao_inicial;
  }

  public void setNumeracao_inicial(java.lang.Integer PARAM) {
    this.numeracao_inicial = PARAM;
  }

  public java.lang.Integer getNumeracao_final() {
    return numeracao_final;
  }

  public void setNumeracao_final(java.lang.Integer PARAM) {
    this.numeracao_final = PARAM;
  }

}
