package portalbr.dbobj.view;

/** DataBase Object from table .Jw_regional_analista
  * @version 03/04/2013 09:13:31
  */
public class Jw_regional_analista implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_gerente;
  private java.lang.String codigo_regional;

  public Jw_regional_analista() {
  }

  public java.lang.String getCodigo_gerente() {
    return codigo_gerente;
  }

  public void setCodigo_gerente(java.lang.String PARAM) {
    this.codigo_gerente = PARAM;
  }

  public java.lang.String getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.String PARAM) {
    this.codigo_regional = PARAM;
  }

}
