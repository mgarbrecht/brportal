package portalbr.dbobj.procedure;

/** DataBase Object from table LOJA.Set_session_module
  * @version 15/07/2010 13:38:45
  */
public class Set_session_module implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String modulo;
  private java.lang.String action;

  public Set_session_module() {
  }

  public java.lang.String getModulo() {
    return modulo;
  }

  public void setModulo(java.lang.String PARAM) {
    this.modulo = PARAM;
  }

  public java.lang.String getAction() {
    return action;
  }

  public void setAction(java.lang.String PARAM) {
    this.action = PARAM;
  }

}
