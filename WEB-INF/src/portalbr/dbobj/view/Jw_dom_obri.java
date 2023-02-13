package portalbr.dbobj.view;

/** DataBase Object from table .Jw_dom_obri
  * @version 23/07/2018 15:39:01
  */
public class Jw_dom_obri implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String obrigacao;
  private java.lang.String fornecedor;
  private java.lang.String sequencia;
  private double pago_sem_desc;
  private int nota;
  private java.lang.String cnpj;
  private java.sql.Date data_vencimento;
  private java.sql.Date data_pagamento;
  private java.lang.String status;
  private java.lang.String fil_razsoc;
  private double valor_obrigacao;
  private java.sql.Date data_emissao;
  private double saldo_pagar;
  private java.lang.String tipo;
  private java.lang.String fil_cnpj;
  private java.lang.String cd_tipo;
  private int qtd;

  public Jw_dom_obri() {
  }

  public java.lang.String getObrigacao() {
    return obrigacao;
  }

  public void setObrigacao(java.lang.String PARAM) {
    this.obrigacao = PARAM;
  }

  public java.lang.String getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(java.lang.String PARAM) {
    this.fornecedor = PARAM;
  }

  public java.lang.String getSequencia() {
    return sequencia;
  }

  public void setSequencia(java.lang.String PARAM) {
    this.sequencia = PARAM;
  }

  public double getPago_sem_desc() {
    return pago_sem_desc;
  }

  public void setPago_sem_desc(double PARAM) {
    this.pago_sem_desc = PARAM;
  }

  public int getNota() {
    return nota;
  }

  public void setNota(int PARAM) {
    this.nota = PARAM;
  }

  public java.lang.String getCnpj() {
    return cnpj;
  }

  public void setCnpj(java.lang.String PARAM) {
    this.cnpj = PARAM;
  }

  public java.sql.Date getData_vencimento() {
    return data_vencimento;
  }

  public void setData_vencimento(java.sql.Date PARAM) {
    this.data_vencimento = PARAM;
  }

  public java.sql.Date getData_pagamento() {
    return data_pagamento;
  }

  public void setData_pagamento(java.sql.Date PARAM) {
    this.data_pagamento = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getFil_razsoc() {
    return fil_razsoc;
  }

  public void setFil_razsoc(java.lang.String PARAM) {
    this.fil_razsoc = PARAM;
  }

  public double getValor_obrigacao() {
    return valor_obrigacao;
  }

  public void setValor_obrigacao(double PARAM) {
    this.valor_obrigacao = PARAM;
  }

  public java.sql.Date getData_emissao() {
    return data_emissao;
  }

  public void setData_emissao(java.sql.Date PARAM) {
    this.data_emissao = PARAM;
  }

  public double getSaldo_pagar() {
    return saldo_pagar;
  }

  public void setSaldo_pagar(double PARAM) {
    this.saldo_pagar = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.lang.String getFil_cnpj() {
    return fil_cnpj;
  }

  public void setFil_cnpj(java.lang.String PARAM) {
    this.fil_cnpj = PARAM;
  }

  public java.lang.String getCd_tipo() {
    return cd_tipo;
  }

  public void setCd_tipo(java.lang.String PARAM) {
    this.cd_tipo = PARAM;
  }

  public int getQtd() {
    return qtd;
  }

  public void setQtd(int PARAM) {
    this.qtd = PARAM;
  }

}
