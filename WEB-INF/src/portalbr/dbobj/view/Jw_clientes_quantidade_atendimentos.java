package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_quantidade_atendimentos
  * @version 10/12/2020 13:52:09
  */
public class Jw_clientes_quantidade_atendimentos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer atendimentos;
  private java.lang.Integer clientes;

  public Jw_clientes_quantidade_atendimentos() {
  }

  public java.lang.Integer getAtendimentos() {
    return atendimentos;
  }

  public void setAtendimentos(java.lang.Integer PARAM) {
    this.atendimentos = PARAM;
  }

  public java.lang.Integer getClientes() {
    return clientes;
  }

  public void setClientes(java.lang.Integer PARAM) {
    this.clientes = PARAM;
  }

}
