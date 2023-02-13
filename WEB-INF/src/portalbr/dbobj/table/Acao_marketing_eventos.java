package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Acao_marketing_eventos
  * @version 03/04/2013 10:08:41
  */
public class Acao_marketing_eventos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int seq_acao_mkt;
  private int seq_evento;
  private java.lang.String email;
  private java.lang.String obs_evento;
  private java.sql.Date data_transacao;
  private java.lang.String usuario_transacao;
  private java.lang.String email2;
  private java.lang.String obs_evento2;
  private java.lang.String email3;
  private java.lang.String obs_evento3;
  private int cracha_usuario;

  public Acao_marketing_eventos() {
  }

  public int getSeq_acao_mkt() {
    return seq_acao_mkt;
  }

  public void setSeq_acao_mkt(int PARAM) {
    this.seq_acao_mkt = PARAM;
  }

  public int getSeq_evento() {
    return seq_evento;
  }

  public void setSeq_evento(int PARAM) {
    this.seq_evento = PARAM;
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

  public java.lang.String getEmail2() {
    return email2;
  }

  public void setEmail2(java.lang.String PARAM) {
    this.email2 = PARAM;
  }

  public java.lang.String getObs_evento2() {
    return obs_evento2;
  }

  public void setObs_evento2(java.lang.String PARAM) {
    this.obs_evento2 = PARAM;
  }

  public java.lang.String getEmail3() {
    return email3;
  }

  public void setEmail3(java.lang.String PARAM) {
    this.email3 = PARAM;
  }

  public java.lang.String getObs_evento3() {
    return obs_evento3;
  }

  public void setObs_evento3(java.lang.String PARAM) {
    this.obs_evento3 = PARAM;
  }

  public int getCracha_usuario() {
    return cracha_usuario;
  }

  public void setCracha_usuario(int PARAM) {
    this.cracha_usuario = PARAM;
  }

}
