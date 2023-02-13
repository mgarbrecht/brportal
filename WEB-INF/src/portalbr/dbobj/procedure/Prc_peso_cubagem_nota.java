package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_peso_cubagem_nota
  * @version 14/12/2010 08:47:19
  */
public class Prc_peso_cubagem_nota implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_emp_empresa;
  private java.lang.String p_fil_filial;
  private java.lang.String p_nfs_nmro;
  private java.lang.String p_nfs_serie;
  private double p_peso_bruto;
  private double p_peso_liquido;
  private double p_cubagem;
  private double p_volumes;

  public Prc_peso_cubagem_nota() {
  }

  public java.lang.String getP_emp_empresa() {
    return p_emp_empresa;
  }

  public void setP_emp_empresa(java.lang.String PARAM) {
    this.p_emp_empresa = PARAM;
  }

  public java.lang.String getP_fil_filial() {
    return p_fil_filial;
  }

  public void setP_fil_filial(java.lang.String PARAM) {
    this.p_fil_filial = PARAM;
  }

  public java.lang.String getP_nfs_nmro() {
    return p_nfs_nmro;
  }

  public void setP_nfs_nmro(java.lang.String PARAM) {
    this.p_nfs_nmro = PARAM;
  }

  public java.lang.String getP_nfs_serie() {
    return p_nfs_serie;
  }

  public void setP_nfs_serie(java.lang.String PARAM) {
    this.p_nfs_serie = PARAM;
  }

  public double getP_peso_bruto() {
    return p_peso_bruto;
  }

  public void setP_peso_bruto(double PARAM) {
    this.p_peso_bruto = PARAM;
  }

  public double getP_peso_liquido() {
    return p_peso_liquido;
  }

  public void setP_peso_liquido(double PARAM) {
    this.p_peso_liquido = PARAM;
  }

  public double getP_cubagem() {
    return p_cubagem;
  }

  public void setP_cubagem(double PARAM) {
    this.p_cubagem = PARAM;
  }

  public double getP_volumes() {
    return p_volumes;
  }

  public void setP_volumes(double PARAM) {
    this.p_volumes = PARAM;
  }

}
