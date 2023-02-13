package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_calc_frete_adic
  * @version 20/05/2013 09:25:47
  */
public class Prc_calc_frete_adic implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.Integer p_pedido;
  private int p_retorno;

  public Prc_calc_frete_adic() {
  }

  public java.lang.Integer getP_pedido() {
    return p_pedido;
  }

  public void setP_pedido(java.lang.Integer PARAM) {
    this.p_pedido = PARAM;
  }

  public int getP_retorno() {
    return p_retorno;
  }

  public void setP_retorno(int PARAM) {
    this.p_retorno = PARAM;
  }

}
