package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Cabedal
  * @version 03/04/2013 10:06:37
  */
public class Cabedal implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer cab_cdgo;
  private java.lang.String cab_desc;
  private java.lang.String cab_nomesp;
  private java.lang.String cab_sintic;
  private java.lang.Integer tip_mat_cdgo;
  private java.lang.String cab_nome_ingles;
  private java.sql.Timestamp cab_data_alteracao;

  public Cabedal() {
  }

  public java.lang.Integer getCab_cdgo() {
    return cab_cdgo;
  }

  public void setCab_cdgo(java.lang.Integer PARAM) {
    this.cab_cdgo = PARAM;
  }

  public java.lang.String getCab_desc() {
    return cab_desc;
  }

  public void setCab_desc(java.lang.String PARAM) {
    this.cab_desc = PARAM;
  }

  public java.lang.String getCab_nomesp() {
    return cab_nomesp;
  }

  public void setCab_nomesp(java.lang.String PARAM) {
    this.cab_nomesp = PARAM;
  }

  public java.lang.String getCab_sintic() {
    return cab_sintic;
  }

  public void setCab_sintic(java.lang.String PARAM) {
    this.cab_sintic = PARAM;
  }

  public java.lang.Integer getTip_mat_cdgo() {
    return tip_mat_cdgo;
  }

  public void setTip_mat_cdgo(java.lang.Integer PARAM) {
    this.tip_mat_cdgo = PARAM;
  }

  public java.lang.String getCab_nome_ingles() {
    return cab_nome_ingles;
  }

  public void setCab_nome_ingles(java.lang.String PARAM) {
    this.cab_nome_ingles = PARAM;
  }

  public java.sql.Timestamp getCab_data_alteracao() {
    return cab_data_alteracao;
  }

  public void setCab_data_alteracao(java.sql.Timestamp PARAM) {
    this.cab_data_alteracao = PARAM;
  }

}
