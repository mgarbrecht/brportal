package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipo_pedido
  * @version 04/06/2019 08:18:56
  */
public class Jw_tipo_pedido implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String tipo_pedido;
  private java.lang.String descricao_tipo_pedido;
  private int ordem;

  public Jw_tipo_pedido() {
  }

  public java.lang.String getTipo_pedido() {
    return tipo_pedido;
  }

  public void setTipo_pedido(java.lang.String PARAM) {
    this.tipo_pedido = PARAM;
  }

  public java.lang.String getDescricao_tipo_pedido() {
    return descricao_tipo_pedido;
  }

  public void setDescricao_tipo_pedido(java.lang.String PARAM) {
    this.descricao_tipo_pedido = PARAM;
  }

  public int getOrdem() {
    return ordem;
  }

  public void setOrdem(int PARAM) {
    this.ordem = PARAM;
  }

}
