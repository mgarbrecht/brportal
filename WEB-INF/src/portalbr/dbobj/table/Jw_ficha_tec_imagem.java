package portalbr.dbobj.table;

/** DataBase Object from table .Jw_ficha_tec_imagem
  * @version 25/03/2008 15:33:07
  */
public class Jw_ficha_tec_imagem implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int lin_cdgo;
  private int ref_cdgo;
  private java.lang.String fit_imagem;

  public Jw_ficha_tec_imagem() {
  }

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public int getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(int PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.String getFit_imagem() {
    return fit_imagem;
  }

  public void setFit_imagem(java.lang.String PARAM) {
    this.fit_imagem = PARAM;
  }

}
