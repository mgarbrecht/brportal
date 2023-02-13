package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acao_marketing_i
  * @version 25/05/2010 12:56:37
  */
public class Jw_acao_marketing_i implements java.io.Serializable, com.egen.util.jdbc.View {
  private int seq_acao_mkt;
  private java.lang.String email;
  private java.lang.Integer cracha_usuario;

  public Jw_acao_marketing_i() {
  }

  public int getSeq_acao_mkt() {
    return seq_acao_mkt;
  }

  public void setSeq_acao_mkt(int PARAM) {
    this.seq_acao_mkt = PARAM;
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
