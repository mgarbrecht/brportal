package portalbr.dbobj.view;

/** DataBase Object from table .Jw_preco_venda_pedido
  * @version 21/09/2016 12:09:14
  */
public class Jw_preco_venda_pedido implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer ped_nmro;
  private java.lang.Integer cli_cdgo;
  private int esc_seqn;
  private java.lang.String cli_rzao;
  private java.sql.Timestamp ped_daem;
  private int ite_seqn;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer cab_cdgo;
  private java.lang.Integer cor_cdgo;
  private java.lang.Double ite_preco_venda;
  private java.lang.String ped_ped_cliente;
  private java.lang.String rep_cdgo;
  private java.lang.Integer codigo_regional;

  public Jw_preco_venda_pedido() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public int getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(int PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.sql.Timestamp getPed_daem() {
    return ped_daem;
  }

  public void setPed_daem(java.sql.Timestamp PARAM) {
    this.ped_daem = PARAM;
  }

  public int getIte_seqn() {
    return ite_seqn;
  }

  public void setIte_seqn(int PARAM) {
    this.ite_seqn = PARAM;
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

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.Double getIte_preco_venda() {
    return ite_preco_venda;
  }

  public void setIte_preco_venda(java.lang.Double PARAM) {
    this.ite_preco_venda = PARAM;
  }

  public java.lang.String getPed_ped_cliente() {
    return ped_ped_cliente;
  }

  public void setPed_ped_cliente(java.lang.String PARAM) {
    this.ped_ped_cliente = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

}
