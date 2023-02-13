package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_grupos_economicos
  * @version 31/10/2019 16:40:31
  */
public class Jw_clientes_grupos_economicos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String gre_grupo;
  private java.lang.String gre_descricao;
  private java.lang.String cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;
  private java.lang.String cli_situ;
  private java.lang.String status;
  private java.lang.String situacao;
  private java.lang.Integer codigo_sequencial;
  private java.lang.String cidade;

  public Jw_clientes_grupos_economicos() {
  }

  public java.lang.String getGre_grupo() {
    return gre_grupo;
  }

  public void setGre_grupo(java.lang.String PARAM) {
    this.gre_grupo = PARAM;
  }

  public java.lang.String getGre_descricao() {
    return gre_descricao;
  }

  public void setGre_descricao(java.lang.String PARAM) {
    this.gre_descricao = PARAM;
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_nome() {
    return cli_nome;
  }

  public void setCli_nome(java.lang.String PARAM) {
    this.cli_nome = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getCli_situ() {
    return cli_situ;
  }

  public void setCli_situ(java.lang.String PARAM) {
    this.cli_situ = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.Integer getCodigo_sequencial() {
    return codigo_sequencial;
  }

  public void setCodigo_sequencial(java.lang.Integer PARAM) {
    this.codigo_sequencial = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

}
