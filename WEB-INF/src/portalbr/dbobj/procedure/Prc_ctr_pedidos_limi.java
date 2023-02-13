package portalbr.dbobj.procedure;

/** DataBase Object from table BRCONREC.Prc_ctr_pedidos_limi
  * @version 05/07/2010 07:01:13
  */
public class Prc_ctr_pedidos_limi implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private double p_cli;
  private java.lang.String p_emp_empresa;
  private double p_qtd_ped_abe_nlib;
  private double p_vlr_ped_abe_nlib;
  private double p_qtd_ped_abe_lib;
  private double p_vlr_ped_abe_lib;
  private double p_limite;
  private double p_saldo;
  private java.lang.String p_erro;

  public Prc_ctr_pedidos_limi() {
  }

  public double getP_cli() {
    return p_cli;
  }

  public void setP_cli(double PARAM) {
    this.p_cli = PARAM;
  }

  public java.lang.String getP_emp_empresa() {
    return p_emp_empresa;
  }

  public void setP_emp_empresa(java.lang.String PARAM) {
    this.p_emp_empresa = PARAM;
  }

  public double getP_qtd_ped_abe_nlib() {
    return p_qtd_ped_abe_nlib;
  }

  public void setP_qtd_ped_abe_nlib(double PARAM) {
    this.p_qtd_ped_abe_nlib = PARAM;
  }

  public double getP_vlr_ped_abe_nlib() {
    return p_vlr_ped_abe_nlib;
  }

  public void setP_vlr_ped_abe_nlib(double PARAM) {
    this.p_vlr_ped_abe_nlib = PARAM;
  }

  public double getP_qtd_ped_abe_lib() {
    return p_qtd_ped_abe_lib;
  }

  public void setP_qtd_ped_abe_lib(double PARAM) {
    this.p_qtd_ped_abe_lib = PARAM;
  }

  public double getP_vlr_ped_abe_lib() {
    return p_vlr_ped_abe_lib;
  }

  public void setP_vlr_ped_abe_lib(double PARAM) {
    this.p_vlr_ped_abe_lib = PARAM;
  }

  public double getP_limite() {
    return p_limite;
  }

  public void setP_limite(double PARAM) {
    this.p_limite = PARAM;
  }

  public double getP_saldo() {
    return p_saldo;
  }

  public void setP_saldo(double PARAM) {
    this.p_saldo = PARAM;
  }

  public java.lang.String getP_erro() {
    return p_erro;
  }

  public void setP_erro(java.lang.String PARAM) {
    this.p_erro = PARAM;
  }

}
