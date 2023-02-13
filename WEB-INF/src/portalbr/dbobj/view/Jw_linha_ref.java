package portalbr.dbobj.view;

/** DataBase Object from table .Jw_linha_ref
  * @version 03/04/2013 09:26:09
  */
public class Jw_linha_ref implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String referencia;
  private java.lang.String lin_cdgo;
  private java.lang.String ref_cdgo;
  private java.lang.String descricao;
  private java.lang.String status;
  private java.lang.String cod_filial;

  public Jw_linha_ref() {
  }

  public java.lang.String getReferencia() {
    return referencia;
  }

  public void setReferencia(java.lang.String PARAM) {
    this.referencia = PARAM;
  }

  public java.lang.String getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.String PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.String PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
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
