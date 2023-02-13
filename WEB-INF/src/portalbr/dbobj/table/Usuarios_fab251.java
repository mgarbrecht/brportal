package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Usuarios_fab251
  * @version 03/04/2013 09:05:55
  */
public class Usuarios_fab251 implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String cod_usuario;
  private java.sql.Timestamp dthr_inclusao;
  private java.sql.Timestamp dthr_alteracao;
  private java.lang.String usuario_inclusao;
  private java.lang.String usuario_alteracao;
  private java.lang.String status;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;

  public Usuarios_fab251() {
  }

  public java.lang.String getCod_usuario() {
    return cod_usuario;
  }

  public void setCod_usuario(java.lang.String PARAM) {
    this.cod_usuario = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
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

}
