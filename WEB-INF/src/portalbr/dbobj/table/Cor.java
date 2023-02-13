package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cor
  * @version 03/04/2013 10:00:43
  */
public class Cor implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int cor_cdgo;
  private java.lang.String cor_desc;
  private java.lang.String cor_nomesp;
  private java.lang.String cor_nome_ingles;

  public Cor() {
  }

  public int getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(int PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getCor_desc() {
    return cor_desc;
  }

  public void setCor_desc(java.lang.String PARAM) {
    this.cor_desc = PARAM;
  }

  public java.lang.String getCor_nomesp() {
    return cor_nomesp;
  }

  public void setCor_nomesp(java.lang.String PARAM) {
    this.cor_nomesp = PARAM;
  }

  public java.lang.String getCor_nome_ingles() {
    return cor_nome_ingles;
  }

  public void setCor_nome_ingles(java.lang.String PARAM) {
    this.cor_nome_ingles = PARAM;
  }

}
