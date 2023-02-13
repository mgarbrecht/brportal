package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing
  * @version 03/04/2013 09:53:42
  */
public class Jw_acao_marketing implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.sql.Date data_entrega;
  private java.sql.Date data_entrada;
  private java.lang.String competencia;
  private int acao;
  private int codigo_material;
  private java.lang.String desc_material;
  private java.lang.String situacao;
  private java.lang.String imagem;
  private java.lang.String formato;
  private java.lang.String observacao;
  private java.lang.String cracha_usuario;
  private int codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.String email;
  private int codigo_marca;
  private java.lang.String descricao_marca;

  public Jw_acao_marketing() {
  }

  public java.sql.Date getData_entrega() {
    return data_entrega;
  }

  public void setData_entrega(java.sql.Date PARAM) {
    this.data_entrega = PARAM;
  }

  public java.sql.Date getData_entrada() {
    return data_entrada;
  }

  public void setData_entrada(java.sql.Date PARAM) {
    this.data_entrada = PARAM;
  }

  public java.lang.String getCompetencia() {
    return competencia;
  }

  public void setCompetencia(java.lang.String PARAM) {
    this.competencia = PARAM;
  }

  public int getAcao() {
    return acao;
  }

  public void setAcao(int PARAM) {
    this.acao = PARAM;
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

  public java.lang.String getCracha_usuario() {
    return cracha_usuario;
  }

  public void setCracha_usuario(java.lang.String PARAM) {
    this.cracha_usuario = PARAM;
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
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

}
