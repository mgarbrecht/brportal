package portalbr.dbobj.view;

import java.lang.reflect.*;

/*** DataBase Object from view Saldo_estoque_grades_dados
     Version: 2.7 -  Date: 24/02/2006 09:52:00 */
public class Saldo_estoque_grades_dados implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String Emp_empresa;
  private java.lang.String Fil_filial;
  private java.lang.String Unn_codigo;
  private double Les_codigo;
  private java.lang.String Dsp_les_codigo;
  private double Tes_codigo;
  private double Tco_codigo;
  private double Gde_codigo;
  private double Gde_tota;
  private double Caixas;
  private double Quantidade;

  public Saldo_estoque_grades_dados() {
  }

  public java.lang.String getEmp_empresa() {
    return Emp_empresa;
  }

  public void setEmp_empresa(java.lang.String EMP_EMPRESA) {
    Emp_empresa = EMP_EMPRESA;
  }

  public java.lang.String getFil_filial() {
    return Fil_filial;
  }

  public void setFil_filial(java.lang.String FIL_FILIAL) {
    Fil_filial = FIL_FILIAL;
  }

  public java.lang.String getUnn_codigo() {
    return Unn_codigo;
  }

  public void setUnn_codigo(java.lang.String UNN_CODIGO) {
    Unn_codigo = UNN_CODIGO;
  }

  public double getLes_codigo() {
    return Les_codigo;
  }

  public void setLes_codigo(double LES_CODIGO) {
    Les_codigo = LES_CODIGO;
  }

  public java.lang.String getDsp_les_codigo() {
    return Dsp_les_codigo;
  }

  public void setDsp_les_codigo(java.lang.String DSP_LES_CODIGO) {
    Dsp_les_codigo = DSP_LES_CODIGO;
  }

  public double getTes_codigo() {
    return Tes_codigo;
  }

  public void setTes_codigo(double TES_CODIGO) {
    Tes_codigo = TES_CODIGO;
  }

  public double getTco_codigo() {
    return Tco_codigo;
  }

  public void setTco_codigo(double TCO_CODIGO) {
    Tco_codigo = TCO_CODIGO;
  }

  public double getGde_codigo() {
    return Gde_codigo;
  }

  public void setGde_codigo(double GDE_CODIGO) {
    Gde_codigo = GDE_CODIGO;
  }

  public double getGde_tota() {
    return Gde_tota;
  }

  public void setGde_tota(double GDE_TOTA) {
    Gde_tota = GDE_TOTA;
  }

  public double getCaixas() {
    return Caixas;
  }

  public void setCaixas(double CAIXAS) {
    Caixas = CAIXAS;
  }

  public double getQuantidade() {
    return Quantidade;
  }

  public void setQuantidade(double QUANTIDADE) {
    Quantidade = QUANTIDADE;
  }

}
