package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_atual_pedidos_filtro_estilos
  * @version 21/01/2019 15:10:02
  */
public class Jw_entrada_atual_pedidos_filtro_estilos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer id_tipo_estilos;
  private java.lang.String descricao_estilos;
  private java.lang.Integer total;

  public Jw_entrada_atual_pedidos_filtro_estilos() {
  }

  public java.lang.Integer getId_tipo_estilos() {
    return id_tipo_estilos;
  }

  public void setId_tipo_estilos(java.lang.Integer PARAM) {
    this.id_tipo_estilos = PARAM;
  }

  public java.lang.String getDescricao_estilos() {
    return descricao_estilos;
  }

  public void setDescricao_estilos(java.lang.String PARAM) {
    this.descricao_estilos = PARAM;
  }

  public java.lang.Integer getTotal() {
    return total;
  }

  public void setTotal(java.lang.Integer PARAM) {
    this.total = PARAM;
  }

}
