package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing_eventos
  * @version 21/08/2013 11:22:59
  */
public class Jw_acao_marketing_eventos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Date data_entrega;
  private int acao;
  private int seq;
  private int codigo_material;
  private java.lang.String desc_material;
  private java.lang.String situacao;
  private java.lang.String imagem;
  private java.lang.String formato;
  private java.lang.String observacao;
  private java.lang.String email;
  private java.lang.String obs_evento;
  private java.sql.Date data_transacao;
  private java.lang.String usuario_transacao;
  private int cracha_usuario;
  private int codigo_marca;
  private java.lang.String descricao_marca;
  private java.lang.String cli_cdgo;
  private java.lang.String cli_rzao;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;

  public Jw_acao_marketing_eventos() {
  }

  public java.sql.Date getData_entrega() {
    return data_entrega;
  }

  public void setData_entrega(java.sql.Date PARAM) {
    this.data_entrega = PARAM;
  }

  public int getAcao() {
    return acao;
  }

  public void setAcao(int PARAM) {
    this.acao = PARAM;
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int PARAM) {
    this.seq = PARAM;
  }

  public int getCodigo_material() {
    return codigo_material;
  }

  public void setCodigo_material(int PARAM) {
    this.codigo_material = PARAM;
  }

  public java.lang.String getDesc_material() {
    return desc_material;
  }

  public void setDesc_material(java.lang.String PARAM) {
    this.desc_material = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.String getImagem() {
    return imagem;
  }

  public void setImagem(java.lang.String PARAM) {
    this.imagem = PARAM;
  }

  public java.lang.String getFormato() {
    return formato;
  }

  public void setFormato(java.lang.String PARAM) {
    this.formato = PARAM;
  }

  public java.lang.String getObservacao() {
    return observacao;
  }

  public void setObservacao(java.lang.String PARAM) {
    this.observacao = PARAM;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
  }

  public java.lang.String getObs_evento() {
    return obs_evento;
  }

  public void setObs_evento(java.lang.String PARAM) {
    this.obs_evento = PARAM;
  }

  public java.sql.Date getData_transacao() {
    return data_transacao;
  }

  public void setData_transacao(java.sql.Date PARAM) {
    this.data_transacao = PARAM;
  }

  public java.lang.String getUsuario_transacao() {
    return usuario_transacao;
  }

  public void setUsuario_transacao(java.lang.String PARAM) {
    this.usuario_transacao = PARAM;
  }

  public int getCracha_usuario() {
    return cracha_usuario;
  }

  public void setCracha_usuario(int PARAM) {
    this.cracha_usuario = PARAM;
  }

  public int getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(int PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
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
