package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_origem
  * @version 19/11/2014 09:04:31
  */
public class Jw_entrada_origem implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Timestamp dt_digitacao;
  private java.lang.String dt_cad_situacao;
  private java.lang.Integer ped_nmro;
  private java.lang.String pedido_origem;
  private java.lang.String maquina;
  private java.lang.String representante;
  private java.lang.String regional;
  private java.lang.Integer pares;

  public Jw_entrada_origem() {
  }

  public java.sql.Timestamp getDt_digitacao() {
    return dt_digitacao;
  }

  public void setDt_digitacao(java.sql.Timestamp PARAM) {
    this.dt_digitacao = PARAM;
  }

  public java.lang.String getDt_cad_situacao() {
    return dt_cad_situacao;
  }

  public void setDt_cad_situacao(java.lang.String PARAM) {
    this.dt_cad_situacao = PARAM;
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getPedido_origem() {
    return pedido_origem;
  }

  public void setPedido_origem(java.lang.String PARAM) {
    this.pedido_origem = PARAM;
  }

  public java.lang.String getMaquina() {
    return maquina;
  }

  public void setMaquina(java.lang.String PARAM) {
    this.maquina = PARAM;
  }

  public java.lang.String getRepresentante() {
    return representante;
  }

  public void setRepresentante(java.lang.String PARAM) {
    this.representante = PARAM;
  }

  public java.lang.String getRegional() {
    return regional;
  }

  public void setRegional(java.lang.String PARAM) {
    this.regional = PARAM;
  }

  public java.lang.Integer getPares() {
    return pares;
  }

  public void setPares(java.lang.Integer PARAM) {
    this.pares = PARAM;
  }

}
