package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Setor
  * @version 23/05/2014 10:29:36
  */
public class Setor implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String set_cdgo;
  private java.lang.String set_nome;

  public Setor() {
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
