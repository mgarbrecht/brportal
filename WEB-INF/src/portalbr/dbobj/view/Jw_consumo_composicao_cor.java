package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consumo_composicao_cor
  * @version 17/08/2017 09:32:10
  */
public class Jw_consumo_composicao_cor implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer cor_cdgo;
  private java.lang.String cor_desc;

  public Jw_consumo_composicao_cor() {
  }

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getCor_desc() {
    return cor_desc;
  }

  public void setCor_desc(java.lang.String PARAM) {
    this.cor_desc = PARAM;
  }

}
