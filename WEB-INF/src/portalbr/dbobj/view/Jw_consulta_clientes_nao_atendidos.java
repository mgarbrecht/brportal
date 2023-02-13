package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_clientes_nao_atendidos
  * @version 03/04/2013 09:40:19
  */
public class Jw_consulta_clientes_nao_atendidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private int cli_cdgo;
  private int esc_seqn;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;
  private java.lang.String cnpj;
  private java.lang.String cidade;
  private java.lang.String uf;
  private java.lang.String endereco;
  private java.sql.Timestamp cli_dult;
  private double limite_credito;
  private java.lang.String fone;
  private java.lang.String esc_email;
  private java.lang.String grupo_economico;

  public Jw_consulta_clientes_nao_atendidos() {
  }

  public int getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(int PARAM) {
    this.cli_cdgo = PARAM;
  }

  public int getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(int PARAM) {
    this.esc_seqn = PARAM;
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

  public java.lang.String getUf() {
    return uf;
  }

  public void setUf(java.lang.String PARAM) {
    this.uf = PARAM;
  }

  public java.lang.String getEndereco() {
    return endereco;
  }

  public void setEndereco(java.lang.String PARAM) {
    this.endereco = PARAM;
  }

  public java.sql.Timestamp getCli_dult() {
    return cli_dult;
  }

  public void setCli_dult(java.sql.Timestamp PARAM) {
    this.cli_dult = PARAM;
  }

  public double getLimite_credito() {
    return limite_credito;
  }

  public void setLimite_credito(double PARAM) {
    this.limite_credito = PARAM;
  }

  public java.lang.String getFone() {
    return fone;
  }

  public void setFone(java.lang.String PARAM) {
    this.fone = PARAM;
  }

  public java.lang.String getEsc_email() {
    return esc_email;
  }

  public void setEsc_email(java.lang.String PARAM) {
    this.esc_email = PARAM;
  }

  public java.lang.String getGrupo_economico() {
    return grupo_economico;
  }

  public void setGrupo_economico(java.lang.String PARAM) {
    this.grupo_economico = PARAM;
  }

}
