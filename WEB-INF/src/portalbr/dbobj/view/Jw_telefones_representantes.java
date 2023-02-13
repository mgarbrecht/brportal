package portalbr.dbobj.view;

/** DataBase Object from table .Jw_telefones_representantes
  * @version 05/07/2010 07:09:01
  */
public class Jw_telefones_representantes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String rep_cdgo;
  private java.lang.String fone;

  public Jw_telefones_representantes() {
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getFone() {
    return fone;
  }

  public void setFone(java.lang.String PARAM) {
    this.fone = PARAM;
  }

}
