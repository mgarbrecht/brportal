package portalbr.dbobj.view;

/** DataBase Object from table .Jw_necessidade_materiais
  * @version 02/04/2015 13:10:28
  */
public class Jw_necessidade_materiais implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ies_codigo;
  private java.lang.String descricao;
  private java.lang.Integer cor_cdgo;
  private java.lang.String cor_desc;
  private java.lang.String tai_codigo;
  private java.lang.String fil_filial;
  private java.lang.String ped_invoice;
  private java.lang.Double consumo;
  private java.lang.String unm_codigo;

  public Jw_necessidade_materiais() {
  }

  public java.lang.Integer getIes_codigo() {
    return ies_codigo;
  }

  public void setIes_codigo(java.lang.Integer PARAM) {
    this.ies_codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getCor_desc() {
    return cor_desc;
  }

  public void setCor_desc(java.lang.String PARAM) {
    this.cor_desc = PARAM;
  }

  public java.lang.String getTai_codigo() {
    return tai_codigo;
  }

  public void setTai_codigo(java.lang.String PARAM) {
    this.tai_codigo = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getPed_invoice() {
    return ped_invoice;
  }

  public void setPed_invoice(java.lang.String PARAM) {
    this.ped_invoice = PARAM;
  }

  public java.lang.Double getConsumo() {
    return consumo;
  }

  public void setConsumo(java.lang.Double PARAM) {
    this.consumo = PARAM;
  }

  public java.lang.String getUnm_codigo() {
    return unm_codigo;
  }

  public void setUnm_codigo(java.lang.String PARAM) {
    this.unm_codigo = PARAM;
  }

}
