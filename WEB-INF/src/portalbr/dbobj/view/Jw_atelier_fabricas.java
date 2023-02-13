package portalbr.dbobj.view;

/** DataBase Object from table .Jw_atelier_fabricas
  * @version 28/05/2014 13:19:22
  */
public class Jw_atelier_fabricas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer for_codigo;
  private java.lang.String for_razsoc;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.Integer mfa_codigo;

  public Jw_atelier_fabricas() {
  }

  public java.lang.Integer getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.Integer PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.String getFor_razsoc() {
    return for_razsoc;
  }

  public void setFor_razsoc(java.lang.String PARAM) {
    this.for_razsoc = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.Integer getMfa_codigo() {
    return mfa_codigo;
  }

  public void setMfa_codigo(java.lang.Integer PARAM) {
    this.mfa_codigo = PARAM;
  }

}
