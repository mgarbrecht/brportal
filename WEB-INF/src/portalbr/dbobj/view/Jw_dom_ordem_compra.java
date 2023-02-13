package portalbr.dbobj.view;

/** DataBase Object from table .Jw_dom_ordem_compra
  * @version 21/01/2016 14:40:39
  */
public class Jw_dom_ordem_compra implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer numero;
  private java.sql.Date data_compra;
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.String unn_codigo;
  private java.lang.Integer forn_codigo;
  private java.lang.Integer fen_seq;
  private java.lang.Integer cpg_codigo;
  private java.lang.Integer com_codigo;
  private java.lang.Integer situacao;
  private java.lang.Integer tra_cdgo;
  private java.lang.String forn_razsoc;

  public Jw_dom_ordem_compra() {
  }

  public java.lang.Integer getNumero() {
    return numero;
  }

  public void setNumero(java.lang.Integer PARAM) {
    this.numero = PARAM;
  }

  public java.sql.Date getData_compra() {
    return data_compra;
  }

  public void setData_compra(java.sql.Date PARAM) {
    this.data_compra = PARAM;
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

  public java.lang.Integer getForn_codigo() {
    return forn_codigo;
  }

  public void setForn_codigo(java.lang.Integer PARAM) {
    this.forn_codigo = PARAM;
  }

  public java.lang.Integer getFen_seq() {
    return fen_seq;
  }

  public void setFen_seq(java.lang.Integer PARAM) {
    this.fen_seq = PARAM;
  }

  public java.lang.Integer getCpg_codigo() {
    return cpg_codigo;
  }

  public void setCpg_codigo(java.lang.Integer PARAM) {
    this.cpg_codigo = PARAM;
  }

  public java.lang.Integer getCom_codigo() {
    return com_codigo;
  }

  public void setCom_codigo(java.lang.Integer PARAM) {
    this.com_codigo = PARAM;
  }

  public java.lang.Integer getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.Integer PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.Integer getTra_cdgo() {
    return tra_cdgo;
  }

  public void setTra_cdgo(java.lang.Integer PARAM) {
    this.tra_cdgo = PARAM;
  }

  public java.lang.String getForn_razsoc() {
    return forn_razsoc;
  }

  public void setForn_razsoc(java.lang.String PARAM) {
    this.forn_razsoc = PARAM;
  }

}
