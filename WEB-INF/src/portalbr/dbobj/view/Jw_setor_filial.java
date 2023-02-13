package portalbr.dbobj.view;

/** DataBase Object from table .Jw_setor_filial
  * @version 23/05/2014 10:37:10
  */
public class Jw_setor_filial implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String fil_filial;
  private java.lang.String set_cdgo;
  private java.lang.String set_nome;

  public Jw_setor_filial() {
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getSet_cdgo() {
    return set_cdgo;
  }

  public void setSet_cdgo(java.lang.String PARAM) {
    this.set_cdgo = PARAM;
  }

  public java.lang.String getSet_nome() {
    return set_nome;
  }

  public void setSet_nome(java.lang.String PARAM) {
    this.set_nome = PARAM;
  }

}
