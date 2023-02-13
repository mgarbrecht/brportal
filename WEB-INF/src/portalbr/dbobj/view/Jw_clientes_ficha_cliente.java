package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_ficha_cliente
  * @version 03/04/2013 09:45:38
  */
public class Jw_clientes_ficha_cliente implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer gre_grupo;
  private java.lang.String gre_descricao;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private java.lang.String cli_rzao;
  private java.lang.String cnpj;
  private java.lang.String cidade;

  public Jw_clientes_ficha_cliente() {
  }

  public java.lang.Integer getGre_grupo() {
    return gre_grupo;
  }

  public void setGre_grupo(java.lang.Integer PARAM) {
    this.gre_grupo = PARAM;
  }

  public java.lang.String getGre_descricao() {
    return gre_descricao;
  }

  public void setGre_descricao(java.lang.String PARAM) {
    this.gre_descricao = PARAM;
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

  public java.lang.String getCnpj() {
    return cnpj;
  }

  public void setCnpj(java.lang.String PARAM) {
    this.cnpj = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

}
