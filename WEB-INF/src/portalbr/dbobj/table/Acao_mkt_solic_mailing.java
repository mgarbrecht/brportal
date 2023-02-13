package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_mkt_solic_mailing
  * @version 03/04/2013 10:08:04
  */
public class Acao_mkt_solic_mailing implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int id_solicitacao;
  private java.lang.String email_retorno;
  private java.lang.String assunto;
  private java.sql.Timestamp data_envio;
  private java.lang.String nome_arquivo;
  private java.lang.String situacao;
  private java.lang.String observacoes;
  private java.sql.Timestamp data_encerramento;

  public Acao_mkt_solic_mailing() {
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

  public java.lang.String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(java.lang.String PARAM) {
    this.observacoes = PARAM;
  }

  public java.sql.Timestamp getData_encerramento() {
    return data_encerramento;
  }

  public void setData_encerramento(java.sql.Timestamp PARAM) {
    this.data_encerramento = PARAM;
  }

}
