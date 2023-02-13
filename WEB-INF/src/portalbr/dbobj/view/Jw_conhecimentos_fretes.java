package portalbr.dbobj.view;

/** DataBase Object from table .Jw_conhecimentos_fretes
  * @version 25/01/2017 15:26:51
  */
public class Jw_conhecimentos_fretes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.Integer nfs_nmro;
  private java.lang.String nfs_serie;
  private java.sql.Date data_ocorrencia;
  private java.lang.Integer mot_codigo;
  private java.lang.String descricao;

  public Jw_conhecimentos_fretes() {
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

  public java.lang.Integer getNfs_nmro() {
    return nfs_nmro;
  }

  public void setNfs_nmro(java.lang.Integer PARAM) {
    this.nfs_nmro = PARAM;
  }

  public java.lang.String getNfs_serie() {
    return nfs_serie;
  }

  public void setNfs_serie(java.lang.String PARAM) {
    this.nfs_serie = PARAM;
  }

  public java.sql.Date getData_ocorrencia() {
    return data_ocorrencia;
  }

  public void setData_ocorrencia(java.sql.Date PARAM) {
    this.data_ocorrencia = PARAM;
  }

  public java.lang.Integer getMot_codigo() {
    return mot_codigo;
  }

  public void setMot_codigo(java.lang.Integer PARAM) {
    this.mot_codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

}
