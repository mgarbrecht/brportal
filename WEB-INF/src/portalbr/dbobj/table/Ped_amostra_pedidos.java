package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_amostra_pedidos
  * @version 20/08/2013 08:00:39
  */
public class Ped_amostra_pedidos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer ped_nmro_amostra;
  private java.lang.Integer ped_nmro;
  private java.lang.String usuario_inclusao;
  private java.sql.Timestamp dthr_inclusao;
  private java.lang.String usuario_alteracao;
  private java.sql.Timestamp dthr_alteracao;
  private java.lang.String observacao;

  public Ped_amostra_pedidos() {
  }

  public java.lang.Integer getPed_nmro_amostra() {
    return ped_nmro_amostra;
  }

  public void setPed_nmro_amostra(java.lang.Integer PARAM) {
    this.ped_nmro_amostra = PARAM;
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

}
