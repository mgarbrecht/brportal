package portalbr.dbobj.view;

/** DataBase Object from table .Clientes_regional
  * @version 13/02/2020 14:10:27
  */
public class Clientes_regional implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String regional;
  private java.lang.Integer codigo_regional;
  private java.sql.Date mes;
  private java.lang.Integer grupos_ativos;
  private java.lang.Integer grupos_atendidos;
  private java.lang.Integer grupos_nao_atendidos;
  private java.lang.Integer clientes_ativos;
  private java.lang.Integer clientes_atendidos;
  private java.lang.Integer clientes_atendidos_recolocacao;
  private java.lang.Integer clientes_nao_atendidos;
  private java.lang.Integer cidades_ativas;
  private java.lang.Integer cidades_atendidas;
  private java.lang.Integer cidades_nao_atendidas;
  private java.lang.Integer pares;
  private java.lang.Double valor;

  public Clientes_regional() {
  }

  public java.lang.String getRegional() {
    return regional;
  }

  public void setRegional(java.lang.String PARAM) {
    this.regional = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.sql.Date getMes() {
    return mes;
  }

  public void setMes(java.sql.Date PARAM) {
    this.mes = PARAM;
  }

  public java.lang.Integer getGrupos_ativos() {
    return grupos_ativos;
  }

  public void setGrupos_ativos(java.lang.Integer PARAM) {
    this.grupos_ativos = PARAM;
  }

  public java.lang.Integer getGrupos_atendidos() {
    return grupos_atendidos;
  }

  public void setGrupos_atendidos(java.lang.Integer PARAM) {
    this.grupos_atendidos = PARAM;
  }

  public java.lang.Integer getGrupos_nao_atendidos() {
    return grupos_nao_atendidos;
  }

  public void setGrupos_nao_atendidos(java.lang.Integer PARAM) {
    this.grupos_nao_atendidos = PARAM;
  }

  public java.lang.Integer getClientes_ativos() {
    return clientes_ativos;
  }

  public void setClientes_ativos(java.lang.Integer PARAM) {
    this.clientes_ativos = PARAM;
  }

  public java.lang.Integer getClientes_atendidos() {
    return clientes_atendidos;
  }

  public void setClientes_atendidos(java.lang.Integer PARAM) {
    this.clientes_atendidos = PARAM;
  }

  public java.lang.Integer getClientes_atendidos_recolocacao() {
    return clientes_atendidos_recolocacao;
  }

  public void setClientes_atendidos_recolocacao(java.lang.Integer PARAM) {
    this.clientes_atendidos_recolocacao = PARAM;
  }

  public java.lang.Integer getClientes_nao_atendidos() {
    return clientes_nao_atendidos;
  }

  public void setClientes_nao_atendidos(java.lang.Integer PARAM) {
    this.clientes_nao_atendidos = PARAM;
  }

  public java.lang.Integer getCidades_ativas() {
    return cidades_ativas;
  }

  public void setCidades_ativas(java.lang.Integer PARAM) {
    this.cidades_ativas = PARAM;
  }

  public java.lang.Integer getCidades_atendidas() {
    return cidades_atendidas;
  }

  public void setCidades_atendidas(java.lang.Integer PARAM) {
    this.cidades_atendidas = PARAM;
  }

  public java.lang.Integer getCidades_nao_atendidas() {
    return cidades_nao_atendidas;
  }

  public void setCidades_nao_atendidas(java.lang.Integer PARAM) {
    this.cidades_nao_atendidas = PARAM;
  }

  public java.lang.Integer getPares() {
    return pares;
  }

  public void setPares(java.lang.Integer PARAM) {
    this.pares = PARAM;
  }

  public java.lang.Double getValor() {
    return valor;
  }

  public void setValor(java.lang.Double PARAM) {
    this.valor = PARAM;
  }

}
