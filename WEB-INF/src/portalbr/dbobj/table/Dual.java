package portalbr.dbobj.table;

/** DataBase Object from table SYS.Dual
  * @version 03/04/2013 09:59:22
  */
public class Dual implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String dummy;

  public Dual() {
  }

  public java.lang.String getDummy() {
    return dummy;
  }

  public void setDummy(java.lang.String PARAM) {
    this.dummy = PARAM;
  }

}
