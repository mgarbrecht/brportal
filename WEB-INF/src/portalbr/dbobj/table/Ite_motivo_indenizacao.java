package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ite_motivo_indenizacao
  * @version 16/12/2019 14:47:21
  */
public class Ite_motivo_indenizacao implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer ped_nmro;
  private java.lang.Integer ite_seqn;
  private java.lang.Integer quantidade_pares;
  private java.lang.Integer moco_codigo;
  private java.lang.String observacao;
  private java.lang.String usuario_criacao;
  private java.sql.Timestamp data_criacao;
  private java.lang.Integer ped_nmro_indenizado;

  public Ite_motivo_indenizacao() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.Integer getIte_seqn() {
    return ite_seqn;
  }

  public void setIte_seqn(java.lang.Integer PARAM) {
    this.ite_seqn = PARAM;
  }

  public java.lang.Integer getQuantidade_pares() {
    return quantidade_pares;
  }

  public void setQuantidade_pares(java.lang.Integer PARAM) {
    this.quantidade_pares = PARAM;
  }

  public java.lang.Integer getMoco_codigo() {
    return moco_codigo;
  }

  public void setMoco_codigo(java.lang.Integer PARAM) {
    this.moco_codigo = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.lang.String getUsuario_criacao() {
    return usuario_criacao;
  }

  public void setUsuario_criacao(java.lang.String PARAM) {
    this.usuario_criacao = PARAM;
  }

  public java.sql.Timestamp getData_criacao() {
    return data_criacao;
  }

  public void setData_criacao(java.sql.Timestamp PARAM) {
    this.data_criacao = PARAM;
  }

  public java.lang.Integer getPed_nmro_indenizado() {
    return ped_nmro_indenizado;
  }

  public void setPed_nmro_indenizado(java.lang.Integer PARAM) {
    this.ped_nmro_indenizado = PARAM;
  }

}
