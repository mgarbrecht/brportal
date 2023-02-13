package portalbr.dbobj.procedure;

/** DataBase Object from table BRIO.Prc_troca_status_acao_mkt
  * @version 05/07/2010 07:00:20
  */
public class Prc_troca_status_acao_mkt implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private int p_acao_mkt;
  private java.lang.String p_status;

  public Prc_troca_status_acao_mkt() {
  }

  public int getP_acao_mkt() {
    return p_acao_mkt;
  }

  public void setP_acao_mkt(int PARAM) {
    this.p_acao_mkt = PARAM;
  }

  public java.lang.String getP_status() {
    return p_status;
  }

  public void setP_status(java.lang.String PARAM) {
    this.p_status = PARAM;
  }

}
