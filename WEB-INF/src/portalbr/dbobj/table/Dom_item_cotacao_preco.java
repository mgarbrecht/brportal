package portalbr.dbobj.table;

/** DataBase Object from table CPR.Dom_item_cotacao_preco
  * @version 03/04/2013 10:00:06
  */
public class Dom_item_cotacao_preco implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int cpr_numero;
  private int sequencia;
  private int for_codigo;
  private int fen_seq;
  private int cpg_codigo;
  private double preco_unitario;
  private double quant_cotada;
  private int situacao;
  private int prazo_entrega;
  private double custo_financeiro;
  private double percentual_ipi;
  private double percentual_icms;
  private double percentual_frete;
  private int ies_codigo;
  private int cor_cdgo;
  private java.lang.String tai_codigo;
  private java.lang.String item_descricao;
  private int seleciona;
  private java.lang.String usuario_libera;
  private java.sql.Timestamp data_libera;
  private java.lang.String unm_codigo;
  private int sco_numero;
  private int iso_sequencia;
  private double preco_final;
  private java.lang.String observacoes;
  private java.lang.String sel_gerente;
  private int tco_codigo;
  private int tra_codigo;
  private java.lang.String forma_pgto;
  private java.lang.String moe_codigo;
  private int poi_grupo;
  private int codigo_depto;
  private java.lang.String ccta_codigo;
  private java.lang.Double japr_codigo;
  private java.lang.String descricao_justificativa;
  private java.lang.String sel_diretor;
  private java.lang.Double irrf;
  private java.lang.Double inss;
  private java.lang.Double issqn;
  private java.lang.Double csrf;
  private java.lang.Double pis;
  private java.lang.Double cofins;
  private java.lang.Double csll;

  public Dom_item_cotacao_preco() {
  }

  public int getCpr_numero() {
    return cpr_numero;
  }

  public void setCpr_numero(int PARAM) {
    this.cpr_numero = PARAM;
  }

  public int getSequencia() {
    return sequencia;
  }

  public void setSequencia(int PARAM) {
    this.sequencia = PARAM;
  }

  public int getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(int PARAM) {
    this.for_codigo = PARAM;
  }

  public int getFen_seq() {
    return fen_seq;
  }

  public void setFen_seq(int PARAM) {
    this.fen_seq = PARAM;
  }

  public int getCpg_codigo() {
    return cpg_codigo;
  }

  public void setCpg_codigo(int PARAM) {
    this.cpg_codigo = PARAM;
  }

  public double getPreco_unitario() {
    return preco_unitario;
  }

  public void setPreco_unitario(double PARAM) {
    this.preco_unitario = PARAM;
  }

  public double getQuant_cotada() {
    return quant_cotada;
  }

  public void setQuant_cotada(double PARAM) {
    this.quant_cotada = PARAM;
  }

  public int getSituacao() {
    return situacao;
  }

  public void setSituacao(int PARAM) {
    this.situacao = PARAM;
  }

  public int getPrazo_entrega() {
    return prazo_entrega;
  }

  public void setPrazo_entrega(int PARAM) {
    this.prazo_entrega = PARAM;
  }

  public double getCusto_financeiro() {
    return custo_financeiro;
  }

  public void setCusto_financeiro(double PARAM) {
    this.custo_financeiro = PARAM;
  }

  public double getPercentual_ipi() {
    return percentual_ipi;
  }

  public void setPercentual_ipi(double PARAM) {
    this.percentual_ipi = PARAM;
  }

  public double getPercentual_icms() {
    return percentual_icms;
  }

  public void setPercentual_icms(double PARAM) {
    this.percentual_icms = PARAM;
  }

  public double getPercentual_frete() {
    return percentual_frete;
  }

  public void setPercentual_frete(double PARAM) {
    this.percentual_frete = PARAM;
  }

  public int getIes_codigo() {
    return ies_codigo;
  }

  public void setIes_codigo(int PARAM) {
    this.ies_codigo = PARAM;
  }

  public int getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(int PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getTai_codigo() {
    return tai_codigo;
  }

  public void setTai_codigo(java.lang.String PARAM) {
    this.tai_codigo = PARAM;
  }

  public java.lang.String getItem_descricao() {
    return item_descricao;
  }

  public void setItem_descricao(java.lang.String PARAM) {
    this.item_descricao = PARAM;
  }

  public int getSeleciona() {
    return seleciona;
  }

  public void setSeleciona(int PARAM) {
    this.seleciona = PARAM;
  }

  public java.lang.String getUsuario_libera() {
    return usuario_libera;
  }

  public void setUsuario_libera(java.lang.String PARAM) {
    this.usuario_libera = PARAM;
  }

  public java.sql.Timestamp getData_libera() {
    return data_libera;
  }

  public void setData_libera(java.sql.Timestamp PARAM) {
    this.data_libera = PARAM;
  }

  public java.lang.String getUnm_codigo() {
    return unm_codigo;
  }

  public void setUnm_codigo(java.lang.String PARAM) {
    this.unm_codigo = PARAM;
  }

  public int getSco_numero() {
    return sco_numero;
  }

  public void setSco_numero(int PARAM) {
    this.sco_numero = PARAM;
  }

  public int getIso_sequencia() {
    return iso_sequencia;
  }

  public void setIso_sequencia(int PARAM) {
    this.iso_sequencia = PARAM;
  }

  public double getPreco_final() {
    return preco_final;
  }

  public void setPreco_final(double PARAM) {
    this.preco_final = PARAM;
  }

  public java.lang.String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(java.lang.String PARAM) {
    this.observacoes = PARAM;
  }

  public java.lang.String getSel_gerente() {
    return sel_gerente;
  }

  public void setSel_gerente(java.lang.String PARAM) {
    this.sel_gerente = PARAM;
  }

  public int getTco_codigo() {
    return tco_codigo;
  }

  public void setTco_codigo(int PARAM) {
    this.tco_codigo = PARAM;
  }

  public int getTra_codigo() {
    return tra_codigo;
  }

  public void setTra_codigo(int PARAM) {
    this.tra_codigo = PARAM;
  }

  public java.lang.String getForma_pgto() {
    return forma_pgto;
  }

  public void setForma_pgto(java.lang.String PARAM) {
    this.forma_pgto = PARAM;
  }

  public java.lang.String getMoe_codigo() {
    return moe_codigo;
  }

  public void setMoe_codigo(java.lang.String PARAM) {
    this.moe_codigo = PARAM;
  }

  public int getPoi_grupo() {
    return poi_grupo;
  }

  public void setPoi_grupo(int PARAM) {
    this.poi_grupo = PARAM;
  }

  public int getCodigo_depto() {
    return codigo_depto;
  }

  public void setCodigo_depto(int PARAM) {
    this.codigo_depto = PARAM;
  }

  public java.lang.String getCcta_codigo() {
    return ccta_codigo;
  }

  public void setCcta_codigo(java.lang.String PARAM) {
    this.ccta_codigo = PARAM;
  }

  public java.lang.Double getJapr_codigo() {
    return japr_codigo;
  }

  public void setJapr_codigo(java.lang.Double PARAM) {
    this.japr_codigo = PARAM;
  }

  public java.lang.String getDescricao_justificativa() {
    return descricao_justificativa;
  }

  public void setDescricao_justificativa(java.lang.String PARAM) {
    this.descricao_justificativa = PARAM;
  }

  public java.lang.String getSel_diretor() {
    return sel_diretor;
  }

  public void setSel_diretor(java.lang.String PARAM) {
    this.sel_diretor = PARAM;
  }

  public java.lang.Double getIrrf() {
    return irrf;
  }

  public void setIrrf(java.lang.Double PARAM) {
    this.irrf = PARAM;
  }

  public java.lang.Double getInss() {
    return inss;
  }

  public void setInss(java.lang.Double PARAM) {
    this.inss = PARAM;
  }

  public java.lang.Double getIssqn() {
    return issqn;
  }

  public void setIssqn(java.lang.Double PARAM) {
    this.issqn = PARAM;
  }

  public java.lang.Double getCsrf() {
    return csrf;
  }

  public void setCsrf(java.lang.Double PARAM) {
    this.csrf = PARAM;
  }

  public java.lang.Double getPis() {
    return pis;
  }

  public void setPis(java.lang.Double PARAM) {
    this.pis = PARAM;
  }

  public java.lang.Double getCofins() {
    return cofins;
  }

  public void setCofins(java.lang.Double PARAM) {
    this.cofins = PARAM;
  }

  public java.lang.Double getCsll() {
    return csll;
  }

  public void setCsll(java.lang.Double PARAM) {
    this.csll = PARAM;
  }

}
