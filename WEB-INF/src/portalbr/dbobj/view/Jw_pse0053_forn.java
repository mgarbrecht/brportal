package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pse0053_forn
  * @version 03/04/2013 09:14:50
  */
public class Jw_pse0053_forn implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String fil_filial;
  private int for_codigo;
  private int pro_numero;

  public Jw_pse0053_forn() {
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public int getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(int PARAM) {
    this.for_codigo = PARAM;
  }

  public int getPro_numero() {
    return pro_numero;
  }

  public void setPro_numero(int PARAM) {
    this.pro_numero = PARAM;
  }

}
