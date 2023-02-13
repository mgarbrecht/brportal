package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_notas_fiscais_linhas
  * @version 03/04/2013 09:38:43
  */
public class Jw_consulta_notas_fiscais_linhas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer linha;
  private java.lang.Integer nfs_nmro;
  private java.lang.String fil_filial;
  private java.lang.String emp_empresa;
  private java.lang.String nfs_serie;

  public Jw_consulta_notas_fiscais_linhas() {
  }

  public java.lang.Integer getLinha() {
    return linha;
  }

  public void setLinha(java.lang.Integer PARAM) {
    this.linha = PARAM;
  }

  public java.lang.Integer getNfs_nmro() {
    return nfs_nmro;
  }

  public void setNfs_nmro(java.lang.Integer PARAM) {
    this.nfs_nmro = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getNfs_serie() {
    return nfs_serie;
  }

  public void setNfs_serie(java.lang.String PARAM) {
    this.nfs_serie = PARAM;
  }

}
