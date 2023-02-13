package portalbr.dbobj.view;

/** DataBase Object from table .Jw_especie_pedido
  * @version 31/07/2013 11:59:53
  */
public class Jw_especie_pedido implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo;
  private java.lang.String descricao;
  private int ordem;

  public Jw_especie_pedido() {
  }

  public java.lang.String getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.String PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public int getOrdem() {
    return ordem;
  }

  public void setOrdem(int PARAM) {
    this.ordem = PARAM;
  }

}
