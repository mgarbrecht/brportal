package portalbr.dbobj.view;

/** DataBase Object from table .Jw_gerente_regional
  * @version 03/04/2013 09:27:40
  */
public class Jw_gerente_regional implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String gerente;
  private java.lang.String regional;
  private java.lang.String codigo_gerente;
  private java.lang.String codigo_regional;
  private java.lang.String rep_cdgo;

  public Jw_gerente_regional() {
  }

  public java.lang.String getGerente() {
    return gerente;
  }

  public void setGerente(java.lang.String PARAM) {
    this.gerente = PARAM;
  }

  public java.lang.String getRegional() {
    return regional;
  }

  public void setRegional(java.lang.String PARAM) {
    this.regional = PARAM;
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

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

}
