package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacao_acao_marketing
  * @version 05/04/2013 10:53:39
  */
public class Jw_situacao_acao_marketing implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String sigla_uf;
  private java.lang.Integer codigo_marca;
  private java.lang.String descricao_marca;
  private java.lang.Integer acao;
  private java.sql.Date data_transacao;
  private java.lang.Integer cdgo_tmidia;
  private java.lang.String desc_tmidia;
  private java.lang.Integer codigo_situacao;
  private java.lang.String descricao_situacao;
  private java.lang.String estagios_marcados;
  private java.lang.Integer cli_cdgo;
  private java.lang.String cli_rzao;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;

  public Jw_situacao_acao_marketing() {
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

  public java.lang.String getSigla_uf() {
    return sigla_uf;
  }

  public void setSigla_uf(java.lang.String PARAM) {
    this.sigla_uf = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

  public java.lang.Integer getAcao() {
    return acao;
  }

  public void setAcao(java.lang.Integer PARAM) {
    this.acao = PARAM;
  }

  public java.sql.Date getData_transacao() {
    return data_transacao;
  }

  public void setData_transacao(java.sql.Date PARAM) {
    this.data_transacao = PARAM;
  }

  public java.lang.Integer getCdgo_tmidia() {
    return cdgo_tmidia;
  }

  public void setCdgo_tmidia(java.lang.Integer PARAM) {
    this.cdgo_tmidia = PARAM;
  }

  public java.lang.String getDesc_tmidia() {
    return desc_tmidia;
  }

  public void setDesc_tmidia(java.lang.String PARAM) {
    this.desc_tmidia = PARAM;
  }

  public java.lang.Integer getCodigo_situacao() {
    return codigo_situacao;
  }

  public void setCodigo_situacao(java.lang.Integer PARAM) {
    this.codigo_situacao = PARAM;
  }

  public java.lang.String getDescricao_situacao() {
    return descricao_situacao;
  }

  public void setDescricao_situacao(java.lang.String PARAM) {
    this.descricao_situacao = PARAM;
  }

  public java.lang.String getEstagios_marcados() {
    return estagios_marcados;
  }

  public void setEstagios_marcados(java.lang.String PARAM) {
    this.estagios_marcados = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
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

}
