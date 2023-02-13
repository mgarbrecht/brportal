package portalbr.dbobj.view;

/** DataBase Object from table .View_representante
  * @version 03/04/2013 09:05:08
  */
public class View_representante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String regional;
  private java.lang.String representante;
  private java.lang.String codigo_representante;
  private double clientes_ativos;
  private double clientes_atendidos;
  private double clientes_nao_atendidos;

  public View_representante() {
  }

  public java.lang.String getRegional() {
    return regional;
  }

  public void setRegional(java.lang.String PARAM) {
    this.regional = PARAM;
  }

  public java.lang.String getRepresentante() {
    return representante;
  }

  public void setRepresentante(java.lang.String PARAM) {
    this.representante = PARAM;
  }

  public java.lang.String getCodigo_representante() {
    return codigo_representante;
  }

  public void setCodigo_representante(java.lang.String PARAM) {
    this.codigo_representante = PARAM;
  }

  public double getClientes_ativos() {
    return clientes_ativos;
  }

  public void setClientes_ativos(double PARAM) {
    this.clientes_ativos = PARAM;
  }

  public double getClientes_atendidos() {
    return clientes_atendidos;
  }

  public void setClientes_atendidos(double PARAM) {
    this.clientes_atendidos = PARAM;
  }

  public double getClientes_nao_atendidos() {
    return clientes_nao_atendidos;
  }

  public void setClientes_nao_atendidos(double PARAM) {
    this.clientes_nao_atendidos = PARAM;
  }

}
