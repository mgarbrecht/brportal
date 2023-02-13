package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lock
  * @version 24/04/2008 14:05:37
  */
public class Jw_lock implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String username;
  private java.lang.String osuser;

  public Jw_lock() {
  }

  public java.lang.String getUsername() {
    return username;
  }

  public void setUsername(java.lang.String PARAM) {
    this.username = PARAM;
  }

  public java.lang.String getOsuser() {
    return osuser;
  }

  public void setOsuser(java.lang.String PARAM) {
    this.osuser = PARAM;
  }

}
