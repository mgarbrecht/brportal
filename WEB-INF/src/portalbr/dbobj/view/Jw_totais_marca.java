package portalbr.dbobj.view;

/** DataBase Object from table .Jw_totais_marca
  * @version 05/07/2010 07:06:10
  */
public class Jw_totais_marca implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_marca;
  private java.lang.Integer total_grupos_ativos;
  private java.lang.Integer total_clientes_ativos;
  private java.lang.Integer total_clientes_atendidos;
  private java.lang.Integer total_clientes_nao_atendidos;
  private java.lang.Integer total_cidades_ativas;
  private java.lang.Integer total_cidades_atendidas;
  private java.lang.Integer total_cidades_nao_atendidas;

  public Jw_totais_marca() {
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.Integer getTotal_grupos_ativos() {
    return total_grupos_ativos;
  }

  public void setTotal_grupos_ativos(java.lang.Integer PARAM) {
    this.total_grupos_ativos = PARAM;
  }

  public java.lang.Integer getTotal_clientes_ativos() {
    return total_clientes_ativos;
  }

  public void setTotal_clientes_ativos(java.lang.Integer PARAM) {
    this.total_clientes_ativos = PARAM;
  }

  public java.lang.Integer getTotal_clientes_atendidos() {
    return total_clientes_atendidos;
  }

  public void setTotal_clientes_atendidos(java.lang.Integer PARAM) {
    this.total_clientes_atendidos = PARAM;
  }

  public java.lang.Integer getTotal_clientes_nao_atendidos() {
    return total_clientes_nao_atendidos;
  }

  public void setTotal_clientes_nao_atendidos(java.lang.Integer PARAM) {
    this.total_clientes_nao_atendidos = PARAM;
  }

  public java.lang.Integer getTotal_cidades_ativas() {
    return total_cidades_ativas;
  }

  public void setTotal_cidades_ativas(java.lang.Integer PARAM) {
    this.total_cidades_ativas = PARAM;
  }

  public java.lang.Integer getTotal_cidades_atendidas() {
    return total_cidades_atendidas;
  }

  public void setTotal_cidades_atendidas(java.lang.Integer PARAM) {
    this.total_cidades_atendidas = PARAM;
  }

  public java.lang.Integer getTotal_cidades_nao_atendidas() {
    return total_cidades_nao_atendidas;
  }

  public void setTotal_cidades_nao_atendidas(java.lang.Integer PARAM) {
    this.total_cidades_nao_atendidas = PARAM;
  }

}
