package portalbr.dbobj.view;

/** DataBase Object from table .Jw_web_poi
  * @version 16/10/2012 10:05:49
  */
public class Jw_web_poi implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String lin_ref;
  private java.lang.String linha;
  private java.lang.String ref_codigo;
  private java.lang.String lin_nome;
  private java.lang.String mes_ano_venda;
  private double total_pares_venda;
  private double capacidade;
  private double vendas;
  private double disponivel;
  private double pares_ret_credito;
  private java.lang.String periodo;
  private java.sql.Date data_inicial;
  private java.sql.Date data_final;

  public Jw_web_poi() {
  }

  public java.lang.String getLin_ref() {
    return lin_ref;
  }

  public void setLin_ref(java.lang.String PARAM) {
    this.lin_ref = PARAM;
  }

  public java.lang.String getLinha() {
    return linha;
  }

  public void setLinha(java.lang.String PARAM) {
    this.linha = PARAM;
  }

  public java.lang.String getRef_codigo() {
    return ref_codigo;
  }

  public void setRef_codigo(java.lang.String PARAM) {
    this.ref_codigo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.lang.String getMes_ano_venda() {
    return mes_ano_venda;
  }

  public void setMes_ano_venda(java.lang.String PARAM) {
    this.mes_ano_venda = PARAM;
  }

  public double getTotal_pares_venda() {
    return total_pares_venda;
  }

  public void setTotal_pares_venda(double PARAM) {
    this.total_pares_venda = PARAM;
  }

  public double getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(double PARAM) {
    this.capacidade = PARAM;
  }

  public double getVendas() {
    return vendas;
  }

  public void setVendas(double PARAM) {
    this.vendas = PARAM;
  }

  public double getDisponivel() {
    return disponivel;
  }

  public void setDisponivel(double PARAM) {
    this.disponivel = PARAM;
  }

  public double getPares_ret_credito() {
    return pares_ret_credito;
  }

  public void setPares_ret_credito(double PARAM) {
    this.pares_ret_credito = PARAM;
  }

  public java.lang.String getPeriodo() {
    return periodo;
  }

  public void setPeriodo(java.lang.String PARAM) {
    this.periodo = PARAM;
  }

  public java.sql.Date getData_inicial() {
    return data_inicial;
  }

  public void setData_inicial(java.sql.Date PARAM) {
    this.data_inicial = PARAM;
  }

  public java.sql.Date getData_final() {
    return data_final;
  }

  public void setData_final(java.sql.Date PARAM) {
    this.data_final = PARAM;
  }

}
