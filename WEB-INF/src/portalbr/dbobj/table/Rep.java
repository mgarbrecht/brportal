package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Rep
  * @version 22/11/2012 08:08:57
  */
public class Rep implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.String rep_nome;
  private java.sql.Timestamp rep_incl;
  private java.lang.String rep_situ;
  private double rep_saldo;
  private java.lang.String cta_conta;
  private int rep_cddis;
  private double rep_limite_cliente_novo;
  private double rep_limite_cliente_velho;
  private int rep_prazo_recolocacao;
  private int codigo_atendente;
  private int codigo_tipo_contrato;
  private int codigo_gerente;
  private java.lang.String rep_tipo_marca;
  private java.lang.String rep_endereco_eletronico;
  private java.lang.String rep_numero_renpac;
  private java.lang.String rep_usuario_internet;
  private int rep_gerente_antigo;
  private int codigo_gerente_allegro;
  private int codigo_gerente_vizzano;
  private int codigo_regional;
  private java.lang.String rep_tipo_negocio;
  private java.lang.String rep_tipo_mercado;
  private java.lang.String rep_observacao;
  private int codigo_gerente_riva_bianca;
  private java.sql.Timestamp data_primeira_venda;
  private double valor_primeira_venda;
  private java.sql.Timestamp data_ultima_venda;
  private double valor_ultima_venda;
  private java.sql.Timestamp data_log_afv;
  private java.lang.String gera_arquivo_afv;
  private java.lang.String rep_mail;

  public Rep() {
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public java.lang.String getRep_nome() {
    return rep_nome;
  }

  public void setRep_nome(java.lang.String PARAM) {
    this.rep_nome = PARAM;
  }

  public java.sql.Timestamp getRep_incl() {
    return rep_incl;
  }

  public void setRep_incl(java.sql.Timestamp PARAM) {
    this.rep_incl = PARAM;
  }

  public java.lang.String getRep_situ() {
    return rep_situ;
  }

  public void setRep_situ(java.lang.String PARAM) {
    this.rep_situ = PARAM;
  }

  public double getRep_saldo() {
    return rep_saldo;
  }

  public void setRep_saldo(double PARAM) {
    this.rep_saldo = PARAM;
  }

  public java.lang.String getCta_conta() {
    return cta_conta;
  }

  public void setCta_conta(java.lang.String PARAM) {
    this.cta_conta = PARAM;
  }

  public int getRep_cddis() {
    return rep_cddis;
  }

  public void setRep_cddis(int PARAM) {
    this.rep_cddis = PARAM;
  }

  public double getRep_limite_cliente_novo() {
    return rep_limite_cliente_novo;
  }

  public void setRep_limite_cliente_novo(double PARAM) {
    this.rep_limite_cliente_novo = PARAM;
  }

  public double getRep_limite_cliente_velho() {
    return rep_limite_cliente_velho;
  }

  public void setRep_limite_cliente_velho(double PARAM) {
    this.rep_limite_cliente_velho = PARAM;
  }

  public int getRep_prazo_recolocacao() {
    return rep_prazo_recolocacao;
  }

  public void setRep_prazo_recolocacao(int PARAM) {
    this.rep_prazo_recolocacao = PARAM;
  }

  public int getCodigo_atendente() {
    return codigo_atendente;
  }

  public void setCodigo_atendente(int PARAM) {
    this.codigo_atendente = PARAM;
  }

  public int getCodigo_tipo_contrato() {
    return codigo_tipo_contrato;
  }

  public void setCodigo_tipo_contrato(int PARAM) {
    this.codigo_tipo_contrato = PARAM;
  }

  public int getCodigo_gerente() {
    return codigo_gerente;
  }

  public void setCodigo_gerente(int PARAM) {
    this.codigo_gerente = PARAM;
  }

  public java.lang.String getRep_tipo_marca() {
    return rep_tipo_marca;
  }

  public void setRep_tipo_marca(java.lang.String PARAM) {
    this.rep_tipo_marca = PARAM;
  }

  public java.lang.String getRep_endereco_eletronico() {
    return rep_endereco_eletronico;
  }

  public void setRep_endereco_eletronico(java.lang.String PARAM) {
    this.rep_endereco_eletronico = PARAM;
  }

  public java.lang.String getRep_numero_renpac() {
    return rep_numero_renpac;
  }

  public void setRep_numero_renpac(java.lang.String PARAM) {
    this.rep_numero_renpac = PARAM;
  }

  public java.lang.String getRep_usuario_internet() {
    return rep_usuario_internet;
  }

  public void setRep_usuario_internet(java.lang.String PARAM) {
    this.rep_usuario_internet = PARAM;
  }

  public int getRep_gerente_antigo() {
    return rep_gerente_antigo;
  }

  public void setRep_gerente_antigo(int PARAM) {
    this.rep_gerente_antigo = PARAM;
  }

  public int getCodigo_gerente_allegro() {
    return codigo_gerente_allegro;
  }

  public void setCodigo_gerente_allegro(int PARAM) {
    this.codigo_gerente_allegro = PARAM;
  }

  public int getCodigo_gerente_vizzano() {
    return codigo_gerente_vizzano;
  }

  public void setCodigo_gerente_vizzano(int PARAM) {
    this.codigo_gerente_vizzano = PARAM;
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getRep_tipo_negocio() {
    return rep_tipo_negocio;
  }

  public void setRep_tipo_negocio(java.lang.String PARAM) {
    this.rep_tipo_negocio = PARAM;
  }

  public java.lang.String getRep_tipo_mercado() {
    return rep_tipo_mercado;
  }

  public void setRep_tipo_mercado(java.lang.String PARAM) {
    this.rep_tipo_mercado = PARAM;
  }

  public java.lang.String getRep_observacao() {
    return rep_observacao;
  }

  public void setRep_observacao(java.lang.String PARAM) {
    this.rep_observacao = PARAM;
  }

  public int getCodigo_gerente_riva_bianca() {
    return codigo_gerente_riva_bianca;
  }

  public void setCodigo_gerente_riva_bianca(int PARAM) {
    this.codigo_gerente_riva_bianca = PARAM;
  }

  public java.sql.Timestamp getData_primeira_venda() {
    return data_primeira_venda;
  }

  public void setData_primeira_venda(java.sql.Timestamp PARAM) {
    this.data_primeira_venda = PARAM;
  }

  public double getValor_primeira_venda() {
    return valor_primeira_venda;
  }

  public void setValor_primeira_venda(double PARAM) {
    this.valor_primeira_venda = PARAM;
  }

  public java.sql.Timestamp getData_ultima_venda() {
    return data_ultima_venda;
  }

  public void setData_ultima_venda(java.sql.Timestamp PARAM) {
    this.data_ultima_venda = PARAM;
  }

  public double getValor_ultima_venda() {
    return valor_ultima_venda;
  }

  public void setValor_ultima_venda(double PARAM) {
    this.valor_ultima_venda = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.lang.String getGera_arquivo_afv() {
    return gera_arquivo_afv;
  }

  public void setGera_arquivo_afv(java.lang.String PARAM) {
    this.gera_arquivo_afv = PARAM;
  }

  public java.lang.String getRep_mail() {
    return rep_mail;
  }

  public void setRep_mail(java.lang.String PARAM) {
    this.rep_mail = PARAM;
  }

}
