package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_pedidos
  * @version 05/07/2010 07:06:32
  */
public class Jw_titulos_pedidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.String tip_codigo;
  private java.lang.String tit_codigo;
  private int ped_nmro;
  private java.lang.String cliente;
  private java.lang.String representante;
  private java.lang.String nf;

  public Jw_titulos_pedidos() {
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

  public java.lang.String getTit_codigo() {
    return tit_codigo;
  }

  public void setTit_codigo(java.lang.String PARAM) {
    this.tit_codigo = PARAM;
  }

  public int getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(int PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.String getRepresentante() {
    return representante;
  }

  public void setRepresentante(java.lang.String PARAM) {
    this.representante = PARAM;
  }

  public java.lang.String getNf() {
    return nf;
  }

  public void setNf(java.lang.String PARAM) {
    this.nf = PARAM;
  }

}
