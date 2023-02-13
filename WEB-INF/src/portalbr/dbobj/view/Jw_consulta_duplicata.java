package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_duplicata
  * @version 17/10/2018 13:16:42
  */
public class Jw_consulta_duplicata implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String status;
  private java.sql.Timestamp dt_emissao;
  private java.sql.Timestamp dt_venc;
  private double cli_cdgo;
  private double esc_seqn;
  private java.lang.String cliente_desc;
  private java.sql.Timestamp dt_pagamento;
  private java.sql.Timestamp triplic;
  private java.sql.Timestamp anuencia;
  private java.sql.Timestamp ins_prot;
  private java.lang.String carteira;
  private java.lang.String banc;
  private java.lang.String agencia_cobranca;
  private java.lang.String agencia_cedente;
  private java.lang.String nr_banco;
  private double desc_pontualidade;
  private double desc_antecipacao;
  private double juros;
  private double correcao;
  private double valor_receb;
  private double valor_abatim;
  private double desconto;
  private double cartorio;
  private double desban;
  private double saldo;
  private java.lang.String empresa;
  private java.lang.String filial;
  private java.lang.String tip_codigo;
  private java.lang.String titulo;
  private java.lang.String rep_codigo;
  private java.sql.Timestamp rec_prot;
  private double valor;
  private java.lang.String cliente;
  private java.lang.String ped_nmro;
  private java.lang.String nf;
  private java.lang.String rep;
  private double encargos;
  private double valor_vendor;
  private java.lang.String prt_codigo;
  private java.lang.String vendor;
  private java.lang.String esc_cgc;

  public Jw_consulta_duplicata() {
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.sql.Timestamp getDt_emissao() {
    return dt_emissao;
  }

  public void setDt_emissao(java.sql.Timestamp PARAM) {
    this.dt_emissao = PARAM;
  }

  public java.sql.Timestamp getDt_venc() {
    return dt_venc;
  }

  public void setDt_venc(java.sql.Timestamp PARAM) {
    this.dt_venc = PARAM;
  }

  public double getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(double PARAM) {
    this.cli_cdgo = PARAM;
  }

  public double getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(double PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.String getCliente_desc() {
    return cliente_desc;
  }

  public void setCliente_desc(java.lang.String PARAM) {
    this.cliente_desc = PARAM;
  }

  public java.sql.Timestamp getDt_pagamento() {
    return dt_pagamento;
  }

  public void setDt_pagamento(java.sql.Timestamp PARAM) {
    this.dt_pagamento = PARAM;
  }

  public java.sql.Timestamp getTriplic() {
    return triplic;
  }

  public void setTriplic(java.sql.Timestamp PARAM) {
    this.triplic = PARAM;
  }

  public java.sql.Timestamp getAnuencia() {
    return anuencia;
  }

  public void setAnuencia(java.sql.Timestamp PARAM) {
    this.anuencia = PARAM;
  }

  public java.sql.Timestamp getIns_prot() {
    return ins_prot;
  }

  public void setIns_prot(java.sql.Timestamp PARAM) {
    this.ins_prot = PARAM;
  }

  public java.lang.String getCarteira() {
    return carteira;
  }

  public void setCarteira(java.lang.String PARAM) {
    this.carteira = PARAM;
  }

  public java.lang.String getBanc() {
    return banc;
  }

  public void setBanc(java.lang.String PARAM) {
    this.banc = PARAM;
  }

  public java.lang.String getAgencia_cobranca() {
    return agencia_cobranca;
  }

  public void setAgencia_cobranca(java.lang.String PARAM) {
    this.agencia_cobranca = PARAM;
  }

  public java.lang.String getAgencia_cedente() {
    return agencia_cedente;
  }

  public void setAgencia_cedente(java.lang.String PARAM) {
    this.agencia_cedente = PARAM;
  }

  public java.lang.String getNr_banco() {
    return nr_banco;
  }

  public void setNr_banco(java.lang.String PARAM) {
    this.nr_banco = PARAM;
  }

  public double getDesc_pontualidade() {
    return desc_pontualidade;
  }

  public void setDesc_pontualidade(double PARAM) {
    this.desc_pontualidade = PARAM;
  }

  public double getDesc_antecipacao() {
    return desc_antecipacao;
  }

  public void setDesc_antecipacao(double PARAM) {
    this.desc_antecipacao = PARAM;
  }

  public double getJuros() {
    return juros;
  }

  public void setJuros(double PARAM) {
    this.juros = PARAM;
  }

  public double getCorrecao() {
    return correcao;
  }

  public void setCorrecao(double PARAM) {
    this.correcao = PARAM;
  }

  public double getValor_receb() {
    return valor_receb;
  }

  public void setValor_receb(double PARAM) {
    this.valor_receb = PARAM;
  }

  public double getValor_abatim() {
    return valor_abatim;
  }

  public void setValor_abatim(double PARAM) {
    this.valor_abatim = PARAM;
  }

  public double getDesconto() {
    return desconto;
  }

  public void setDesconto(double PARAM) {
    this.desconto = PARAM;
  }

  public double getCartorio() {
    return cartorio;
  }

  public void setCartorio(double PARAM) {
    this.cartorio = PARAM;
  }

  public double getDesban() {
    return desban;
  }

  public void setDesban(double PARAM) {
    this.desban = PARAM;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double PARAM) {
    this.saldo = PARAM;
  }

  public java.lang.String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(java.lang.String PARAM) {
    this.empresa = PARAM;
  }

  public java.lang.String getFilial() {
    return filial;
  }

  public void setFilial(java.lang.String PARAM) {
    this.filial = PARAM;
  }

  public java.lang.String getTip_codigo() {
    return tip_codigo;
  }

  public void setTip_codigo(java.lang.String PARAM) {
    this.tip_codigo = PARAM;
  }

  public java.lang.String getTitulo() {
    return titulo;
  }

  public void setTitulo(java.lang.String PARAM) {
    this.titulo = PARAM;
  }

  public java.lang.String getRep_codigo() {
    return rep_codigo;
  }

  public void setRep_codigo(java.lang.String PARAM) {
    this.rep_codigo = PARAM;
  }

  public java.sql.Timestamp getRec_prot() {
    return rec_prot;
  }

  public void setRec_prot(java.sql.Timestamp PARAM) {
    this.rec_prot = PARAM;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double PARAM) {
    this.valor = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.String getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.String PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getNf() {
    return nf;
  }

  public void setNf(java.lang.String PARAM) {
    this.nf = PARAM;
  }

  public java.lang.String getRep() {
    return rep;
  }

  public void setRep(java.lang.String PARAM) {
    this.rep = PARAM;
  }

  public double getEncargos() {
    return encargos;
  }

  public void setEncargos(double PARAM) {
    this.encargos = PARAM;
  }

  public double getValor_vendor() {
    return valor_vendor;
  }

  public void setValor_vendor(double PARAM) {
    this.valor_vendor = PARAM;
  }

  public java.lang.String getPrt_codigo() {
    return prt_codigo;
  }

  public void setPrt_codigo(java.lang.String PARAM) {
    this.prt_codigo = PARAM;
  }

  public java.lang.String getVendor() {
    return vendor;
  }

  public void setVendor(java.lang.String PARAM) {
    this.vendor = PARAM;
  }

  public java.lang.String getEsc_cgc() {
    return esc_cgc;
  }

  public void setEsc_cgc(java.lang.String PARAM) {
    this.esc_cgc = PARAM;
  }

}
