package portalbr.dbobj.view;

/** DataBase Object from table .Jw_geracao_romaneio_filtro
  * @version 25/08/2015 16:44:10
  */
public class Jw_geracao_romaneio_filtro implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String emp_empresa;
  private java.lang.String fil_filial;
  private java.lang.Integer nfs_nmro;
  private java.lang.String nfs_serie;
  private java.sql.Timestamp nfs_dtemis;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private java.lang.String cli_rzao;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.String possui_sku;
  private java.lang.String preco_final_liquido;

  public Jw_geracao_romaneio_filtro() {
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.Integer getNfs_nmro() {
    return nfs_nmro;
  }

  public void setNfs_nmro(java.lang.Integer PARAM) {
    this.nfs_nmro = PARAM;
  }

  public java.lang.String getNfs_serie() {
    return nfs_serie;
  }

  public void setNfs_serie(java.lang.String PARAM) {
    this.nfs_serie = PARAM;
  }

  public java.sql.Timestamp getNfs_dtemis() {
    return nfs_dtemis;
  }

  public void setNfs_dtemis(java.sql.Timestamp PARAM) {
    this.nfs_dtemis = PARAM;
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

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public java.lang.String getPossui_sku() {
    return possui_sku;
  }

  public void setPossui_sku(java.lang.String PARAM) {
    this.possui_sku = PARAM;
  }

  public java.lang.String getPreco_final_liquido() {
    return preco_final_liquido;
  }

  public void setPreco_final_liquido(java.lang.String PARAM) {
    this.preco_final_liquido = PARAM;
  }

}
