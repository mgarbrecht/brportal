package portalbr.dbobj.view;

/** DataBase Object from table .Jw_filial_linhas
  * @version 03/04/2013 09:28:39
  */
public class Jw_filial_linhas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cod_empresa;
  private java.lang.String cod_filial;
  private java.lang.String lin_codigo;
  private java.lang.String ref_codigo;
  private java.lang.String fil_razsoc;
  private java.lang.String mix;
  private java.lang.String ativa;

  public Jw_filial_linhas() {
  }

  public java.lang.String getCod_empresa() {
    return cod_empresa;
  }

  public void setCod_empresa(java.lang.String PARAM) {
    this.cod_empresa = PARAM;
  }

  public java.lang.String getCod_filial() {
    return cod_filial;
  }

  public void setCod_filial(java.lang.String PARAM) {
    this.cod_filial = PARAM;
  }

  public java.lang.String getLin_codigo() {
    return lin_codigo;
  }

  public void setLin_codigo(java.lang.String PARAM) {
    this.lin_codigo = PARAM;
  }

  public java.lang.String getRef_codigo() {
    return ref_codigo;
  }

  public void setRef_codigo(java.lang.String PARAM) {
    this.ref_codigo = PARAM;
  }

  public java.lang.String getFil_razsoc() {
    return fil_razsoc;
  }

  public void setFil_razsoc(java.lang.String PARAM) {
    this.fil_razsoc = PARAM;
  }

  public java.lang.String getMix() {
    return mix;
  }

  public void setMix(java.lang.String PARAM) {
    this.mix = PARAM;
  }

  public java.lang.String getAtiva() {
    return ativa;
  }

  public void setAtiva(java.lang.String PARAM) {
    this.ativa = PARAM;
  }

}
