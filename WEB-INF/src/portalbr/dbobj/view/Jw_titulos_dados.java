package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_dados
  * @version 05/07/2010 07:06:44
  */
public class Jw_titulos_dados implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.String tip_codigo;
  private java.sql.Timestamp tit_datvenc;
  private double tit_valor;
  private double tit_vlrec;
  private int w_dias;

  public Jw_titulos_dados() {
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

  public java.lang.String getTip_codigo() {
    return tip_codigo;
  }

  public void setTip_codigo(java.lang.String PARAM) {
    this.tip_codigo = PARAM;
  }

  public java.sql.Timestamp getTit_datvenc() {
    return tit_datvenc;
  }

  public void setTit_datvenc(java.sql.Timestamp PARAM) {
    this.tit_datvenc = PARAM;
  }

  public double getTit_valor() {
    return tit_valor;
  }

  public void setTit_valor(double PARAM) {
    this.tit_valor = PARAM;
  }

  public double getTit_vlrec() {
    return tit_vlrec;
  }

  public void setTit_vlrec(double PARAM) {
    this.tit_vlrec = PARAM;
  }

  public int getW_dias() {
    return w_dias;
  }

  public void setW_dias(int PARAM) {
    this.w_dias = PARAM;
  }

}
