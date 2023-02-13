package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_atual_pedidos_estilos
  * @version 10/04/2019 12:56:51
  */
public class Jw_entrada_atual_pedidos_estilos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String atualizacao;
  private java.lang.String datam;
  private double pr_pp;
  private double vlr_pp;
  private double pr_pg;
  private double vlr_pg;
  private double tot_pares;
  private double tot_vlr;
  private java.lang.Integer id_tipo_estilos;
  private java.lang.String descricao_estilos;
  private java.lang.Integer clientes;
  private java.lang.Integer total_pares_ano;
  private java.lang.Double total_valor_ano;
  private java.lang.Integer clientes_atendidos_ano;

  public Jw_entrada_atual_pedidos_estilos() {
  }

  public java.lang.String getAtualizacao() {
    return atualizacao;
  }

  public void setAtualizacao(java.lang.String PARAM) {
    this.atualizacao = PARAM;
  }

  public java.lang.String getDatam() {
    return datam;
  }

  public void setDatam(java.lang.String PARAM) {
    this.datam = PARAM;
  }

  public double getPr_pp() {
    return pr_pp;
  }

  public void setPr_pp(double PARAM) {
    this.pr_pp = PARAM;
  }

  public double getVlr_pp() {
    return vlr_pp;
  }

  public void setVlr_pp(double PARAM) {
    this.vlr_pp = PARAM;
  }

  public double getPr_pg() {
    return pr_pg;
  }

  public void setPr_pg(double PARAM) {
    this.pr_pg = PARAM;
  }

  public double getVlr_pg() {
    return vlr_pg;
  }

  public void setVlr_pg(double PARAM) {
    this.vlr_pg = PARAM;
  }

  public double getTot_pares() {
    return tot_pares;
  }

  public void setTot_pares(double PARAM) {
    this.tot_pares = PARAM;
  }

  public double getTot_vlr() {
    return tot_vlr;
  }

  public void setTot_vlr(double PARAM) {
    this.tot_vlr = PARAM;
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

  public java.lang.Integer getClientes() {
    return clientes;
  }

  public void setClientes(java.lang.Integer PARAM) {
    this.clientes = PARAM;
  }

  public java.lang.Integer getTotal_pares_ano() {
    return total_pares_ano;
  }

  public void setTotal_pares_ano(java.lang.Integer PARAM) {
    this.total_pares_ano = PARAM;
  }

  public java.lang.Double getTotal_valor_ano() {
    return total_valor_ano;
  }

  public void setTotal_valor_ano(java.lang.Double PARAM) {
    this.total_valor_ano = PARAM;
  }

  public java.lang.Integer getClientes_atendidos_ano() {
    return clientes_atendidos_ano;
  }

  public void setClientes_atendidos_ano(java.lang.Integer PARAM) {
    this.clientes_atendidos_ano = PARAM;
  }

}
