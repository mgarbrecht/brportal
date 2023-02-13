package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_envia_email_troca_senha
  * @version 09/02/2011 06:52:47
  */
public class Prc_envia_email_troca_senha implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_usua_id;
  private java.lang.String p_senha;

  public Prc_envia_email_troca_senha() {
  }

  public java.lang.String getP_usua_id() {
    return p_usua_id;
  }

  public void setP_usua_id(java.lang.String PARAM) {
    this.p_usua_id = PARAM;
  }

  public java.lang.String getP_senha() {
    return p_senha;
  }

  public void setP_senha(java.lang.String PARAM) {
    this.p_senha = PARAM;
  }

}
