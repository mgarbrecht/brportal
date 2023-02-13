package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fornecedor
  * @version 03/04/2013 09:28:27
  */
public class Jw_fornecedor implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String for_codigo;
  private java.lang.String for_razsoc;

  public Jw_fornecedor() {
  }

  public java.lang.String getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.String PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.String getFor_razsoc() {
    return for_razsoc;
  }

  public void setFor_razsoc(java.lang.String PARAM) {
    this.for_razsoc = PARAM;
  }

}
