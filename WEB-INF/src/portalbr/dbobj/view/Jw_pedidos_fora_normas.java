package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedidos_fora_normas
  * @version 03/04/2013 09:19:22
  */
public class Jw_pedidos_fora_normas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String ped_nmro;
  private java.lang.String ped_rep;
  private java.lang.String ped_stat;
  private java.lang.String ped_stat_real;
  private java.sql.Timestamp ped_data;
  private java.sql.Timestamp ped_det;
  private java.sql.Timestamp ped_emb;
  private java.lang.String rep_codigo;
  private java.lang.String cod_lin;
  private java.lang.String nome_lin;

  public Jw_pedidos_fora_normas() {
  }

  public java.lang.String getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.String PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getPed_rep() {
    return ped_rep;
  }

  public void setPed_rep(java.lang.String PARAM) {
    this.ped_rep = PARAM;
  }

  public java.lang.String getPed_stat() {
    return ped_stat;
  }

  public void setPed_stat(java.lang.String PARAM) {
    this.ped_stat = PARAM;
  }

  public java.lang.String getPed_stat_real() {
    return ped_stat_real;
  }

  public void setPed_stat_real(java.lang.String PARAM) {
    this.ped_stat_real = PARAM;
  }

  public java.sql.Timestamp getPed_data() {
    return ped_data;
  }

  public void setPed_data(java.sql.Timestamp PARAM) {
    this.ped_data = PARAM;
  }

  public java.sql.Timestamp getPed_det() {
    return ped_det;
  }

  public void setPed_det(java.sql.Timestamp PARAM) {
    this.ped_det = PARAM;
  }

  public java.sql.Timestamp getPed_emb() {
    return ped_emb;
  }

  public void setPed_emb(java.sql.Timestamp PARAM) {
    this.ped_emb = PARAM;
  }

  public java.lang.String getRep_codigo() {
    return rep_codigo;
  }

  public void setRep_codigo(java.lang.String PARAM) {
    this.rep_codigo = PARAM;
  }

  public java.lang.String getCod_lin() {
    return cod_lin;
  }

  public void setCod_lin(java.lang.String PARAM) {
    this.cod_lin = PARAM;
  }

  public java.lang.String getNome_lin() {
    return nome_lin;
  }

  public void setNome_lin(java.lang.String PARAM) {
    this.nome_lin = PARAM;
  }

}
