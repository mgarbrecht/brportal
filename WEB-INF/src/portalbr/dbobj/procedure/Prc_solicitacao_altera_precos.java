package portalbr.dbobj.procedure;

/** DataBase Object from table BRIO.Prc_solicitacao_altera_precos
  * @version 05/07/2010 07:00:28
  */
public class Prc_solicitacao_altera_precos implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_nmro_solicitacao;
  private java.lang.String p_libera;

  public Prc_solicitacao_altera_precos() {
  }

  public java.lang.String getP_nmro_solicitacao() {
    return p_nmro_solicitacao;
  }

  public void setP_nmro_solicitacao(java.lang.String PARAM) {
    this.p_nmro_solicitacao = PARAM;
  }

  public java.lang.String getP_libera() {
    return p_libera;
  }

  public void setP_libera(java.lang.String PARAM) {
    this.p_libera = PARAM;
  }

}
