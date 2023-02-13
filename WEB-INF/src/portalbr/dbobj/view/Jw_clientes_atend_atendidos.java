package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_atend_atendidos
  * @version 11/02/2014 07:58:24
  */
public class Jw_clientes_atend_atendidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer clientes;
  private java.lang.Integer grupos;
  private java.lang.Integer cidades;

  public Jw_clientes_atend_atendidos() {
  }

  public java.lang.Integer getClientes() {
    return clientes;
  }

  public void setClientes(java.lang.Integer PARAM) {
    this.clientes = PARAM;
  }

  public java.lang.Integer getGrupos() {
    return grupos;
  }

  public void setGrupos(java.lang.Integer PARAM) {
    this.grupos = PARAM;
  }

  public java.lang.Integer getCidades() {
    return cidades;
  }

  public void setCidades(java.lang.Integer PARAM) {
    this.cidades = PARAM;
  }

}
