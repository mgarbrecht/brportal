package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_impressao_direta
  * @version 09/06/2015 08:24:50
  */
public class Jw_titulos_impressao_direta implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.String tit_codigo;
  private java.lang.String tip_codigo;
  private java.lang.String prt_codigo;
  private java.lang.String chave;

  public Jw_titulos_impressao_direta() {
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

  public java.lang.String getTit_codigo() {
    return tit_codigo;
  }

  public void setTit_codigo(java.lang.String PARAM) {
    this.tit_codigo = PARAM;
  }

  public java.lang.String getTip_codigo() {
    return tip_codigo;
  }

  public void setTip_codigo(java.lang.String PARAM) {
    this.tip_codigo = PARAM;
  }

  public java.lang.String getPrt_codigo() {
    return prt_codigo;
  }

  public void setPrt_codigo(java.lang.String PARAM) {
    this.prt_codigo = PARAM;
  }

  public java.lang.String getChave() {
    return chave;
  }

  public void setChave(java.lang.String PARAM) {
    this.chave = PARAM;
  }

}
