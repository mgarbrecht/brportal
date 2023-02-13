package portalbr.dbobj.table;

/** DataBase Object from table CPR.Atelier_pre_envio
  * @version 02/07/2015 08:41:00
  */
public class Atelier_pre_envio implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer for_codigo;
  private java.lang.Integer fen_seq;
  private java.lang.Integer ref_cdgo;
  private java.lang.Double lin_cdgo;
  private java.lang.Integer pro_numero;
  private java.lang.Integer tal_pares;
  private java.sql.Timestamp data_pre_envio;
  private java.lang.Integer rem_nro;
  private java.lang.Integer tal_nro;
  private java.lang.String status;
  private java.lang.String status_retorno;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;

  public Atelier_pre_envio() {
  }

  public java.lang.Integer getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.Integer PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.Integer getFen_seq() {
    return fen_seq;
  }

  public void setFen_seq(java.lang.Integer PARAM) {
    this.fen_seq = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.Double getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Double PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getPro_numero() {
    return pro_numero;
  }

  public void setPro_numero(java.lang.Integer PARAM) {
    this.pro_numero = PARAM;
  }

  public java.lang.Integer getTal_pares() {
    return tal_pares;
  }

  public void setTal_pares(java.lang.Integer PARAM) {
    this.tal_pares = PARAM;
  }

  public java.sql.Timestamp getData_pre_envio() {
    return data_pre_envio;
  }

  public void setData_pre_envio(java.sql.Timestamp PARAM) {
    this.data_pre_envio = PARAM;
  }

  public java.lang.Integer getRem_nro() {
    return rem_nro;
  }

  public void setRem_nro(java.lang.Integer PARAM) {
    this.rem_nro = PARAM;
  }

  public java.lang.Integer getTal_nro() {
    return tal_nro;
  }

  public void setTal_nro(java.lang.Integer PARAM) {
    this.tal_nro = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getStatus_retorno() {
    return status_retorno;
  }

  public void setStatus_retorno(java.lang.String PARAM) {
    this.status_retorno = PARAM;
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
