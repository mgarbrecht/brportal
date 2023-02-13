package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing_eventos_i
  * @version 03/04/2013 09:53:22
  */
public class Jw_acao_marketing_eventos_i implements java.io.Serializable, com.egen.util.jdbc.View {
  private int seq_acao_mkt;
  private java.lang.String email_origem;
  private java.lang.String email;
  private java.lang.Integer cracha_usuario;

  public Jw_acao_marketing_eventos_i() {
  }

  public int getSeq_acao_mkt() {
    return seq_acao_mkt;
  }

  public void setSeq_acao_mkt(int PARAM) {
    this.seq_acao_mkt = PARAM;
  }

  public java.lang.String getEmail_origem() {
    return email_origem;
  }

  public void setEmail_origem(java.lang.String PARAM) {
    this.email_origem = PARAM;
  }

  public java.lang.String getEmail() {
    return email;
  }

  public void setEmail(java.lang.String PARAM) {
    this.email = PARAM;
  }

  public java.lang.Integer getCracha_usuario() {
    return cracha_usuario;
  }

  public void setCracha_usuario(java.lang.Integer PARAM) {
    this.cracha_usuario = PARAM;
  }

}
