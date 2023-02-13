package portalbr.dbobj.view;

/** DataBase Object from table .Jw_status_pedidos
  * @version 03/06/2019 14:30:08
  */
public class Jw_status_pedidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String status;
  private java.lang.String descricao;

  public Jw_status_pedidos() {
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

}
