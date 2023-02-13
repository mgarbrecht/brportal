package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacao_pedidos
  * @version 05/07/2016 13:02:03
  */
public class Jw_situacao_pedidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo;
  private java.lang.String descricao;

  public Jw_situacao_pedidos() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

}
