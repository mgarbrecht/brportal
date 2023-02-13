package portalbr.dbobj.table;

/** DataBase Object from table FRETES.Conhecimentos_frt_ocorrencias
  * @version 03/04/2013 10:01:05
  */
public class Conhecimentos_frt_ocorrencias implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Long id;
  private java.lang.Integer fen_for_codigo;
  private java.lang.Integer fen_seq;
  private java.lang.String numero;
  private java.lang.String emp_empresa;
  private java.lang.String filial;
  private java.lang.Integer nfs_nmro;
  private java.lang.String nfs_serie;
  private java.lang.Integer mot_codigo;
  private java.lang.String observacao;
  private java.lang.String usuario_cad;
  private java.sql.Date data_cad;
  private java.sql.Date data_ocorrencia;

  public Conhecimentos_frt_ocorrencias() {
  }

  public java.lang.Long getId() {
    return id;
  }

  public void setId(java.lang.Long PARAM) {
    this.id = PARAM;
  }

  public java.lang.Integer getFen_for_codigo() {
    return fen_for_codigo;
  }

  public void setFen_for_codigo(java.lang.Integer PARAM) {
    this.fen_for_codigo = PARAM;
  }

  public java.lang.Integer getFen_seq() {
    return fen_seq;
  }

  public void setFen_seq(java.lang.Integer PARAM) {
    this.fen_seq = PARAM;
  }

  public java.lang.String getNumero() {
    return numero;
  }

  public void setNumero(java.lang.String PARAM) {
    this.numero = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
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

  public java.lang.Integer getMot_codigo() {
    return mot_codigo;
  }

  public void setMot_codigo(java.lang.Integer PARAM) {
    this.mot_codigo = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.lang.String getUsuario_cad() {
    return usuario_cad;
  }

  public void setUsuario_cad(java.lang.String PARAM) {
    this.usuario_cad = PARAM;
  }

  public java.sql.Date getData_cad() {
    return data_cad;
  }

  public void setData_cad(java.sql.Date PARAM) {
    this.data_cad = PARAM;
  }

  public java.sql.Date getData_ocorrencia() {
    return data_ocorrencia;
  }

  public void setData_ocorrencia(java.sql.Date PARAM) {
    this.data_ocorrencia = PARAM;
  }

}
