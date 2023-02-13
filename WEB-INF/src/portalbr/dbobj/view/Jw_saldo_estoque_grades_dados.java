package portalbr.dbobj.view;

/** DataBase Object from table .Jw_saldo_estoque_grades_dados
  * @version 03/04/2013 09:11:37
  */
public class Jw_saldo_estoque_grades_dados implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.String unn_codigo;
  private double les_codigo;
  private java.lang.String dsp_les_codigo;
  private double tes_codigo;
  private double tco_codigo;
  private double gde_codigo;
  private double gde_tota;
  private double caixas;
  private double quantidade;
  private java.lang.String tes_descricao;
  private java.lang.String tco_descricao;

  public Jw_saldo_estoque_grades_dados() {
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

  public java.lang.String getUnn_codigo() {
    return unn_codigo;
  }

  public void setUnn_codigo(java.lang.String PARAM) {
    this.unn_codigo = PARAM;
  }

  public double getLes_codigo() {
    return les_codigo;
  }

  public void setLes_codigo(double PARAM) {
    this.les_codigo = PARAM;
  }

  public java.lang.String getDsp_les_codigo() {
    return dsp_les_codigo;
  }

  public void setDsp_les_codigo(java.lang.String PARAM) {
    this.dsp_les_codigo = PARAM;
  }

  public double getTes_codigo() {
    return tes_codigo;
  }

  public void setTes_codigo(double PARAM) {
    this.tes_codigo = PARAM;
  }

  public double getTco_codigo() {
    return tco_codigo;
  }

  public void setTco_codigo(double PARAM) {
    this.tco_codigo = PARAM;
  }

  public double getGde_codigo() {
    return gde_codigo;
  }

  public void setGde_codigo(double PARAM) {
    this.gde_codigo = PARAM;
  }

  public double getGde_tota() {
    return gde_tota;
  }

  public void setGde_tota(double PARAM) {
    this.gde_tota = PARAM;
  }

  public double getCaixas() {
    return caixas;
  }

  public void setCaixas(double PARAM) {
    this.caixas = PARAM;
  }

  public double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(double PARAM) {
    this.quantidade = PARAM;
  }

  public java.lang.String getTes_descricao() {
    return tes_descricao;
  }

  public void setTes_descricao(java.lang.String PARAM) {
    this.tes_descricao = PARAM;
  }

  public java.lang.String getTco_descricao() {
    return tco_descricao;
  }

  public void setTco_descricao(java.lang.String PARAM) {
    this.tco_descricao = PARAM;
  }

}
