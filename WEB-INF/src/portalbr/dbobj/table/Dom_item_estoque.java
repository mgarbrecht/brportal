package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_item_estoque
  * @version 05/08/2014 09:42:27
  */
public class Dom_item_estoque implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String descricao;
  private java.lang.String tipo;
  private java.lang.Integer ipi_codred;
  private java.lang.String unm_codigo;
  private java.lang.Integer gpo_codigo;
  private java.lang.Integer ges_codigo;
  private java.lang.String finalidade;
  private java.lang.Integer trf_cdgo;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer cab_cdgo;
  private double clf_codigo;
  private java.lang.Integer dias_antecedencia;
  private java.lang.String curva_abc;
  private java.lang.Double custo_unitario;
  private java.lang.Double valor_poi;
  private java.lang.String gera_oc;
  private java.lang.String emp_empresa;
  private java.lang.String cor;
  private java.lang.String tamanho;
  private java.lang.String forma;
  private java.sql.Timestamp dthr_inclusao;
  private java.sql.Timestamp dthr_alteracao;
  private java.lang.String usuario_inclusao;
  private java.lang.String usuario_alteracao;
  private java.lang.String composicao;
  private java.lang.Integer ccs_codigo;
  private java.lang.String status;
  private java.lang.String compra_por_remessa;
  private java.lang.Integer dimensao_chapa_eva;
  private java.lang.Double largura;
  private java.lang.Double comprimento;
  private java.lang.Double peso;
  private java.lang.Double altura;
  private java.lang.Double espessura;

  public Dom_item_estoque() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getTipo() {
    return tipo;
  }

  public void setTipo(java.lang.String PARAM) {
    this.tipo = PARAM;
  }

  public java.lang.Integer getIpi_codred() {
    return ipi_codred;
  }

  public void setIpi_codred(java.lang.Integer PARAM) {
    this.ipi_codred = PARAM;
  }

  public java.lang.String getUnm_codigo() {
    return unm_codigo;
  }

  public void setUnm_codigo(java.lang.String PARAM) {
    this.unm_codigo = PARAM;
  }

  public java.lang.Integer getGpo_codigo() {
    return gpo_codigo;
  }

  public void setGpo_codigo(java.lang.Integer PARAM) {
    this.gpo_codigo = PARAM;
  }

  public java.lang.Integer getGes_codigo() {
    return ges_codigo;
  }

  public void setGes_codigo(java.lang.Integer PARAM) {
    this.ges_codigo = PARAM;
  }

  public java.lang.String getFinalidade() {
    return finalidade;
  }

  public void setFinalidade(java.lang.String PARAM) {
    this.finalidade = PARAM;
  }

  public java.lang.Integer getTrf_cdgo() {
    return trf_cdgo;
  }

  public void setTrf_cdgo(java.lang.Integer PARAM) {
    this.trf_cdgo = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.Integer getCab_cdgo() {
    return cab_cdgo;
  }

  public void setCab_cdgo(java.lang.Integer PARAM) {
    this.cab_cdgo = PARAM;
  }

  public double getClf_codigo() {
    return clf_codigo;
  }

  public void setClf_codigo(double PARAM) {
    this.clf_codigo = PARAM;
  }

  public java.lang.Integer getDias_antecedencia() {
    return dias_antecedencia;
  }

  public void setDias_antecedencia(java.lang.Integer PARAM) {
    this.dias_antecedencia = PARAM;
  }

  public java.lang.String getCurva_abc() {
    return curva_abc;
  }

  public void setCurva_abc(java.lang.String PARAM) {
    this.curva_abc = PARAM;
  }

  public java.lang.Double getCusto_unitario() {
    return custo_unitario;
  }

  public void setCusto_unitario(java.lang.Double PARAM) {
    this.custo_unitario = PARAM;
  }

  public java.lang.Double getValor_poi() {
    return valor_poi;
  }

  public void setValor_poi(java.lang.Double PARAM) {
    this.valor_poi = PARAM;
  }

  public java.lang.String getGera_oc() {
    return gera_oc;
  }

  public void setGera_oc(java.lang.String PARAM) {
    this.gera_oc = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getCor() {
    return cor;
  }

  public void setCor(java.lang.String PARAM) {
    this.cor = PARAM;
  }

  public java.lang.String getTamanho() {
    return tamanho;
  }

  public void setTamanho(java.lang.String PARAM) {
    this.tamanho = PARAM;
  }

  public java.lang.String getForma() {
    return forma;
  }

  public void setForma(java.lang.String PARAM) {
    this.forma = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.lang.String getComposicao() {
    return composicao;
  }

  public void setComposicao(java.lang.String PARAM) {
    this.composicao = PARAM;
  }

  public java.lang.Integer getCcs_codigo() {
    return ccs_codigo;
  }

  public void setCcs_codigo(java.lang.Integer PARAM) {
    this.ccs_codigo = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getCompra_por_remessa() {
    return compra_por_remessa;
  }

  public void setCompra_por_remessa(java.lang.String PARAM) {
    this.compra_por_remessa = PARAM;
  }

  public java.lang.Integer getDimensao_chapa_eva() {
    return dimensao_chapa_eva;
  }

  public void setDimensao_chapa_eva(java.lang.Integer PARAM) {
    this.dimensao_chapa_eva = PARAM;
  }

  public java.lang.Double getLargura() {
    return largura;
  }

  public void setLargura(java.lang.Double PARAM) {
    this.largura = PARAM;
  }

  public java.lang.Double getComprimento() {
    return comprimento;
  }

  public void setComprimento(java.lang.Double PARAM) {
    this.comprimento = PARAM;
  }

  public java.lang.Double getPeso() {
    return peso;
  }

  public void setPeso(java.lang.Double PARAM) {
    this.peso = PARAM;
  }

  public java.lang.Double getAltura() {
    return altura;
  }

  public void setAltura(java.lang.Double PARAM) {
    this.altura = PARAM;
  }

  public java.lang.Double getEspessura() {
    return espessura;
  }

  public void setEspessura(java.lang.Double PARAM) {
    this.espessura = PARAM;
  }

}
