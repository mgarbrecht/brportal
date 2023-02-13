package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedidos_indenizados_descontos
  * @version 06/12/2019 15:28:15
  */
public class Jw_pedidos_indenizados_descontos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ped_nmro;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer cab_cdgo;
  private java.lang.String cab_desc;
  private java.lang.Integer cor_cdgo;
  private java.lang.String cor_desc;
  private java.lang.Integer quantidade;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private java.lang.Integer ite_seqn;
  private java.lang.Double ite_prco;
  private java.lang.Double desconto_comercial;
  private java.lang.Double desconto_promocional;
  private java.lang.Double ite_prco_descontos;

  public Jw_pedidos_indenizados_descontos() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
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

  public java.lang.Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(java.lang.Integer PARAM) {
    this.quantidade = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.Integer getIte_seqn() {
    return ite_seqn;
  }

  public void setIte_seqn(java.lang.Integer PARAM) {
    this.ite_seqn = PARAM;
  }

  public java.lang.Double getIte_prco() {
    return ite_prco;
  }

  public void setIte_prco(java.lang.Double PARAM) {
    this.ite_prco = PARAM;
  }

  public java.lang.Double getDesconto_comercial() {
    return desconto_comercial;
  }

  public void setDesconto_comercial(java.lang.Double PARAM) {
    this.desconto_comercial = PARAM;
  }

  public java.lang.Double getDesconto_promocional() {
    return desconto_promocional;
  }

  public void setDesconto_promocional(java.lang.Double PARAM) {
    this.desconto_promocional = PARAM;
  }

  public java.lang.Double getIte_prco_descontos() {
    return ite_prco_descontos;
  }

  public void setIte_prco_descontos(java.lang.Double PARAM) {
    this.ite_prco_descontos = PARAM;
  }

}
