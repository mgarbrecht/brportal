package portalbr.dbobj.view;

/** DataBase Object from table .Jw_linha
  * @version 03/04/2013 09:26:18
  */
public class Jw_linha implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String lin_cdgo;
  private java.lang.String lin_nome;
  private java.lang.String status;
  private java.lang.String cod_filial;

  public Jw_linha() {
  }

  public java.lang.String getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.String PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getCod_filial() {
    return cod_filial;
  }

  public void setCod_filial(java.lang.String PARAM) {
    this.cod_filial = PARAM;
  }

}
