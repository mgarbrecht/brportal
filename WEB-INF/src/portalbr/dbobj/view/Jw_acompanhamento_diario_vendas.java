package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acompanhamento_diario_vendas
  * @version 03/05/2016 16:01:57
  */
public class Jw_acompanhamento_diario_vendas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String periodo;
  private java.lang.String periodo_ano_anterior;
  private java.lang.Integer codigo_regional;
  private java.lang.String nome_regional;
  private java.lang.Integer codigo_marca;
  private java.lang.String descricao_marca;
  private java.lang.String rep_cdgo;
  private java.lang.String rep_rzao;
  private java.lang.Integer pares_previsto_ano;
  private java.lang.Integer pares_realizado_ano;
  private java.lang.Double reais_previsto_ano;
  private java.lang.Double reais_realizado_ano;
  private java.lang.Integer pares_realizado_ant;
  private java.lang.Double reais_realizado_ant;
  private java.lang.Integer cli_atend_ano;
  private java.lang.Integer cli_atend_ant;
  private java.lang.Integer dif_cli_atend;
  private java.lang.Double valor_meta;
  private java.lang.Double valor_ano_ant;
  private java.lang.Integer cli_atend_regional_ano;
  private java.lang.Integer cli_atend_regional_ant;
  private java.lang.Integer dif_cli_regional_atend;
  private java.lang.Double dif_pares_ano;
  private java.lang.Double dif_reais_ano;
  private java.lang.Double dif_pares_realizado;
  private java.lang.Double dif_reais_realizado;
  private java.lang.Double dif_clientes_atendidos;

  public Jw_acompanhamento_diario_vendas() {
  }

  public java.lang.String getPeriodo() {
    return periodo;
  }

  public void setPeriodo(java.lang.String PARAM) {
    this.periodo = PARAM;
  }

  public java.lang.String getPeriodo_ano_anterior() {
    return periodo_ano_anterior;
  }

  public void setPeriodo_ano_anterior(java.lang.String PARAM) {
    this.periodo_ano_anterior = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
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

  public java.lang.Integer getPares_previsto_ano() {
    return pares_previsto_ano;
  }

  public void setPares_previsto_ano(java.lang.Integer PARAM) {
    this.pares_previsto_ano = PARAM;
  }

  public java.lang.Integer getPares_realizado_ano() {
    return pares_realizado_ano;
  }

  public void setPares_realizado_ano(java.lang.Integer PARAM) {
    this.pares_realizado_ano = PARAM;
  }

  public java.lang.Double getReais_previsto_ano() {
    return reais_previsto_ano;
  }

  public void setReais_previsto_ano(java.lang.Double PARAM) {
    this.reais_previsto_ano = PARAM;
  }

  public java.lang.Double getReais_realizado_ano() {
    return reais_realizado_ano;
  }

  public void setReais_realizado_ano(java.lang.Double PARAM) {
    this.reais_realizado_ano = PARAM;
  }

  public java.lang.Integer getPares_realizado_ant() {
    return pares_realizado_ant;
  }

  public void setPares_realizado_ant(java.lang.Integer PARAM) {
    this.pares_realizado_ant = PARAM;
  }

  public java.lang.Double getReais_realizado_ant() {
    return reais_realizado_ant;
  }

  public void setReais_realizado_ant(java.lang.Double PARAM) {
    this.reais_realizado_ant = PARAM;
  }

  public java.lang.Integer getCli_atend_ano() {
    return cli_atend_ano;
  }

  public void setCli_atend_ano(java.lang.Integer PARAM) {
    this.cli_atend_ano = PARAM;
  }

  public java.lang.Integer getCli_atend_ant() {
    return cli_atend_ant;
  }

  public void setCli_atend_ant(java.lang.Integer PARAM) {
    this.cli_atend_ant = PARAM;
  }

  public java.lang.Integer getDif_cli_atend() {
    return dif_cli_atend;
  }

  public void setDif_cli_atend(java.lang.Integer PARAM) {
    this.dif_cli_atend = PARAM;
  }

  public java.lang.Double getValor_meta() {
    return valor_meta;
  }

  public void setValor_meta(java.lang.Double PARAM) {
    this.valor_meta = PARAM;
  }

  public java.lang.Double getValor_ano_ant() {
    return valor_ano_ant;
  }

  public void setValor_ano_ant(java.lang.Double PARAM) {
    this.valor_ano_ant = PARAM;
  }

  public java.lang.Integer getCli_atend_regional_ano() {
    return cli_atend_regional_ano;
  }

  public void setCli_atend_regional_ano(java.lang.Integer PARAM) {
    this.cli_atend_regional_ano = PARAM;
  }

  public java.lang.Integer getCli_atend_regional_ant() {
    return cli_atend_regional_ant;
  }

  public void setCli_atend_regional_ant(java.lang.Integer PARAM) {
    this.cli_atend_regional_ant = PARAM;
  }

  public java.lang.Integer getDif_cli_regional_atend() {
    return dif_cli_regional_atend;
  }

  public void setDif_cli_regional_atend(java.lang.Integer PARAM) {
    this.dif_cli_regional_atend = PARAM;
  }

  public java.lang.Double getDif_pares_ano() {
    return dif_pares_ano;
  }

  public void setDif_pares_ano(java.lang.Double PARAM) {
    this.dif_pares_ano = PARAM;
  }

  public java.lang.Double getDif_reais_ano() {
    return dif_reais_ano;
  }

  public void setDif_reais_ano(java.lang.Double PARAM) {
    this.dif_reais_ano = PARAM;
  }

  public java.lang.Double getDif_pares_realizado() {
    return dif_pares_realizado;
  }

  public void setDif_pares_realizado(java.lang.Double PARAM) {
    this.dif_pares_realizado = PARAM;
  }

  public java.lang.Double getDif_reais_realizado() {
    return dif_reais_realizado;
  }

  public void setDif_reais_realizado(java.lang.Double PARAM) {
    this.dif_reais_realizado = PARAM;
  }

  public java.lang.Double getDif_clientes_atendidos() {
    return dif_clientes_atendidos;
  }

  public void setDif_clientes_atendidos(java.lang.Double PARAM) {
    this.dif_clientes_atendidos = PARAM;
  }

}
