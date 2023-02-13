package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entrada_atual_pedidos_clientes
  * @version 10/04/2019 12:54:47
  */
public class Jw_entrada_atual_pedidos_clientes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String atualizacao;
  private java.lang.String datam;
  private java.lang.Integer pr_pp;
  private java.lang.Double vlr_pp;
  private java.lang.Integer pr_pg;
  private java.lang.Double vlr_pg;
  private java.lang.Integer tot_pares;
  private java.lang.Double tot_vlr;
  private java.lang.Integer cli_cdgo;
  private java.lang.String cli_rzao;
  private java.lang.Integer clientes;
  private java.lang.Integer total_pares_ano;
  private java.lang.Double total_valor_ano;
  private java.lang.Integer clientes_atendidos_ano;

  public Jw_entrada_atual_pedidos_clientes() {
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

  public java.lang.Integer getPr_pp() {
    return pr_pp;
  }

  public void setPr_pp(java.lang.Integer PARAM) {
    this.pr_pp = PARAM;
  }

  public java.lang.Double getVlr_pp() {
    return vlr_pp;
  }

  public void setVlr_pp(java.lang.Double PARAM) {
    this.vlr_pp = PARAM;
  }

  public java.lang.Integer getPr_pg() {
    return pr_pg;
  }

  public void setPr_pg(java.lang.Integer PARAM) {
    this.pr_pg = PARAM;
  }

  public java.lang.Double getVlr_pg() {
    return vlr_pg;
  }

  public void setVlr_pg(java.lang.Double PARAM) {
    this.vlr_pg = PARAM;
  }

  public java.lang.Integer getTot_pares() {
    return tot_pares;
  }

  public void setTot_pares(java.lang.Integer PARAM) {
    this.tot_pares = PARAM;
  }

  public java.lang.Double getTot_vlr() {
    return tot_vlr;
  }

  public void setTot_vlr(java.lang.Double PARAM) {
    this.tot_vlr = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
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
