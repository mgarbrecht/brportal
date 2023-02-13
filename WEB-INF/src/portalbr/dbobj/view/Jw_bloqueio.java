package portalbr.dbobj.view;

/** DataBase Object from table .Jw_bloqueio
  * @version 24/04/2008 14:08:43
  */
public class Jw_bloqueio implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String lock_username;
  private java.lang.String lock_user;
  private java.lang.String wait_username;
  private java.lang.String wait_user;

  public Jw_bloqueio() {
  }

  public java.lang.String getLock_username() {
    return lock_username;
  }

  public void setLock_username(java.lang.String PARAM) {
    this.lock_username = PARAM;
  }

  public java.lang.String getLock_user() {
    return lock_user;
  }

  public void setLock_user(java.lang.String PARAM) {
    this.lock_user = PARAM;
  }

  public java.lang.String getWait_username() {
    return wait_username;
  }

  public void setWait_username(java.lang.String PARAM) {
    this.wait_username = PARAM;
  }

  public java.lang.String getWait_user() {
    return wait_user;
  }

  public void setWait_user(java.lang.String PARAM) {
    this.wait_user = PARAM;
  }

}
