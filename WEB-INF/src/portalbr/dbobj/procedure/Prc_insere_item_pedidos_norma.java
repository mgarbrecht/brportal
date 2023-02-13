package portalbr.dbobj.procedure;

/** DataBase Object from table WBRIO.Prc_insere_item_pedidos_norma
  * @version 05/10/2010 14:44:54
  */
public class Prc_insere_item_pedidos_norma implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_numero_pedido;
  private java.lang.String p_controle;

  public Prc_insere_item_pedidos_norma() {
  }

  public java.lang.String getP_numero_pedido() {
    return p_numero_pedido;
  }

  public void setP_numero_pedido(java.lang.String PARAM) {
    this.p_numero_pedido = PARAM;
  }

  public java.lang.String getP_controle() {
    return p_controle;
  }

  public void setP_controle(java.lang.String PARAM) {
    this.p_controle = PARAM;
  }

}
