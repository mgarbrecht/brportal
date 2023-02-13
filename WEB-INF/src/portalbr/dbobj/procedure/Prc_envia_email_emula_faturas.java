package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_envia_email_emula_faturas
  * @version 07/10/2010 07:05:00
  */
public class Prc_envia_email_emula_faturas implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_numero_pedido;

  public Prc_envia_email_emula_faturas() {
  }

  public java.lang.String getP_numero_pedido() {
    return p_numero_pedido;
  }

  public void setP_numero_pedido(java.lang.String PARAM) {
    this.p_numero_pedido = PARAM;
  }

}
