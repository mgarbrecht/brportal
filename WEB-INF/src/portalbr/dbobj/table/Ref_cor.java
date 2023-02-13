package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ref_cor
  * @version 05/08/2014 12:00:33
  */
public class Ref_cor implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int lin_cdgo;
  private int ref_cdgo;
  private int cab_cdgo;
  private int cor_cdgo;
  private double rfc_ratplv;
  private java.lang.String rfc_status;
  private java.lang.String observacao;
  private int min_pares_me;
  private java.lang.String barra_ok;
  private java.sql.Timestamp data_log_afv;

  public Ref_cor() {
  }

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public int getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(int PARAM) {
    this.ref_cdgo = PARAM;
  }

  public int getCab_cdgo() {
    return cab_cdgo;
  }

  public void setCab_cdgo(int PARAM) {
    this.cab_cdgo = PARAM;
  }

  public int getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(int PARAM) {
    this.cor_cdgo = PARAM;
  }

  public double getRfc_ratplv() {
    return rfc_ratplv;
  }

  public void setRfc_ratplv(double PARAM) {
    this.rfc_ratplv = PARAM;
  }

  public java.lang.String getRfc_status() {
    return rfc_status;
  }

  public void setRfc_status(java.lang.String PARAM) {
    this.rfc_status = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public int getMin_pares_me() {
    return min_pares_me;
  }

  public void setMin_pares_me(int PARAM) {
    this.min_pares_me = PARAM;
  }

  public java.lang.String getBarra_ok() {
    return barra_ok;
  }

  public void setBarra_ok(java.lang.String PARAM) {
    this.barra_ok = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

}
