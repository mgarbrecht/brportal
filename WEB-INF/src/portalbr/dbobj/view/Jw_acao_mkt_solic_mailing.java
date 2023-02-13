package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_mkt_solic_mailing
  * @version 03/04/2013 09:52:40
  */
public class Jw_acao_mkt_solic_mailing implements java.io.Serializable, com.egen.util.jdbc.View {
  private int id_solicitacao;
  private java.lang.String email_retorno;
  private java.lang.String assunto;
  private java.sql.Timestamp data_envio;
  private java.lang.String nome_arquivo;
  private java.lang.String situacao;
  private java.lang.String situacao_desc;
  private java.lang.String observacoes;

  public Jw_acao_mkt_solic_mailing() {
  }

  public int getId_solicitacao() {
    return id_solicitacao;
  }

  public void setId_solicitacao(int PARAM) {
    this.id_solicitacao = PARAM;
  }

  public java.lang.String getEmail_retorno() {
    return email_retorno;
  }

  public void setEmail_retorno(java.lang.String PARAM) {
    this.email_retorno = PARAM;
  }

  public java.lang.String getAssunto() {
    return assunto;
  }

  public void setAssunto(java.lang.String PARAM) {
    this.assunto = PARAM;
  }

  public java.sql.Timestamp getData_envio() {
    return data_envio;
  }

  public void setData_envio(java.sql.Timestamp PARAM) {
    this.data_envio = PARAM;
  }

  public java.lang.String getNome_arquivo() {
    return nome_arquivo;
  }

  public void setNome_arquivo(java.lang.String PARAM) {
    this.nome_arquivo = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.String getSituacao_desc() {
    return situacao_desc;
  }

  public void setSituacao_desc(java.lang.String PARAM) {
    this.situacao_desc = PARAM;
  }

  public java.lang.String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(java.lang.String PARAM) {
    this.observacoes = PARAM;
  }

}
