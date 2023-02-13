package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cor_compo
  * @version 03/04/2013 09:31:59
  */
public class Jw_cor_compo implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer cor_cdgo;
  private java.lang.String cor_desc;

  public Jw_cor_compo() {
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
