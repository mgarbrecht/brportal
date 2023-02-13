package portalbr.dbobj.view;

/** DataBase Object from table .Jw_fluxo
  * @version 24/03/2020 15:23:57
  */
public class Jw_fluxo implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer quantidade_meses;
  private java.lang.String descricao_quantidade_meses;
  private java.lang.Integer clientes;

  public Jw_fluxo() {
  }

  public java.lang.Integer getQuantidade_meses() {
    return quantidade_meses;
  }

  public void setQuantidade_meses(java.lang.Integer PARAM) {
    this.quantidade_meses = PARAM;
  }

  public java.lang.String getDescricao_quantidade_meses() {
    return descricao_quantidade_meses;
  }

  public void setDescricao_quantidade_meses(java.lang.String PARAM) {
    this.descricao_quantidade_meses = PARAM;
  }

  public java.lang.Integer getClientes() {
    return clientes;
  }

  public void setClientes(java.lang.Integer PARAM) {
    this.clientes = PARAM;
  }

}
