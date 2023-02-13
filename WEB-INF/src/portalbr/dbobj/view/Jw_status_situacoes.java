package portalbr.dbobj.view;

/** DataBase Object from table .Jw_status_situacoes
  * @version 16/07/2019 08:49:16
  */
public class Jw_status_situacoes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String status_situacoes;
  private java.lang.String ped_stat;
  private java.lang.Integer ite_situ;

  public Jw_status_situacoes() {
  }

  public java.lang.String getStatus_situacoes() {
    return status_situacoes;
  }

  public void setStatus_situacoes(java.lang.String PARAM) {
    this.status_situacoes = PARAM;
  }

  public java.lang.String getPed_stat() {
    return ped_stat;
  }

  public void setPed_stat(java.lang.String PARAM) {
    this.ped_stat = PARAM;
  }

  public java.lang.Integer getIte_situ() {
    return ite_situ;
  }

  public void setIte_situ(java.lang.Integer PARAM) {
    this.ite_situ = PARAM;
  }

}
