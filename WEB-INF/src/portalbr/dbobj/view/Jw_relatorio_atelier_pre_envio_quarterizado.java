package portalbr.dbobj.view;

/** DataBase Object from table .Jw_relatorio_atelier_pre_envio_quarterizado
  * @version 15/01/2015 16:49:38
  */
public class Jw_relatorio_atelier_pre_envio_quarterizado implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer fornecedor_codigo;
  private java.lang.Integer fornecedor_codigo_quarterizado;
  private java.lang.Integer fen_seq_quarterizado;
  private java.lang.String fornecedor_razsoc;
  private java.lang.Integer pro_numero;
  private java.lang.String pro_nome;
  private java.sql.Timestamp data_envio;
  private java.sql.Timestamp data_retorno;
  private java.lang.Integer rem_nro;
  private java.lang.Integer tal_nro;
  private java.lang.String status;
  private java.lang.String status_descricao;
  private java.lang.String usuario_inclusao;
  private java.lang.String usuario_alteracao;
  private java.sql.Timestamp data_ordenacao;
  private java.lang.Integer tal_pares;
  private java.lang.Integer tal_parbom;
  private java.lang.Integer tal_parrej;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer cab_cdgo;
  private java.lang.String cab_desc;
  private java.lang.Integer cor_cdgo;
  private java.lang.String cor_desc;
  private java.sql.Timestamp data_corte;
  private java.sql.Timestamp data_cost;
  private java.sql.Timestamp data_mont;

  public Jw_relatorio_atelier_pre_envio_quarterizado() {
  }

  public java.lang.Integer getFornecedor_codigo() {
    return fornecedor_codigo;
  }

  public void setFornecedor_codigo(java.lang.Integer PARAM) {
    this.fornecedor_codigo = PARAM;
  }

  public java.lang.Integer getFornecedor_codigo_quarterizado() {
    return fornecedor_codigo_quarterizado;
  }

  public void setFornecedor_codigo_quarterizado(java.lang.Integer PARAM) {
    this.fornecedor_codigo_quarterizado = PARAM;
  }

  public java.lang.Integer getFen_seq_quarterizado() {
    return fen_seq_quarterizado;
  }

  public void setFen_seq_quarterizado(java.lang.Integer PARAM) {
    this.fen_seq_quarterizado = PARAM;
  }

  public java.lang.String getFornecedor_razsoc() {
    return fornecedor_razsoc;
  }

  public void setFornecedor_razsoc(java.lang.String PARAM) {
    this.fornecedor_razsoc = PARAM;
  }

  public java.lang.Integer getPro_numero() {
    return pro_numero;
  }

  public void setPro_numero(java.lang.Integer PARAM) {
    this.pro_numero = PARAM;
  }

  public java.lang.String getPro_nome() {
    return pro_nome;
  }

  public void setPro_nome(java.lang.String PARAM) {
    this.pro_nome = PARAM;
  }

  public java.sql.Timestamp getData_envio() {
    return data_envio;
  }

  public void setData_envio(java.sql.Timestamp PARAM) {
    this.data_envio = PARAM;
  }

  public java.sql.Timestamp getData_retorno() {
    return data_retorno;
  }

  public void setData_retorno(java.sql.Timestamp PARAM) {
    this.data_retorno = PARAM;
  }

  public java.lang.Integer getRem_nro() {
    return rem_nro;
  }

  public void setRem_nro(java.lang.Integer PARAM) {
    this.rem_nro = PARAM;
  }

  public java.lang.Integer getTal_nro() {
    return tal_nro;
  }

  public void setTal_nro(java.lang.Integer PARAM) {
    this.tal_nro = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

  public java.lang.String getStatus_descricao() {
    return status_descricao;
  }

  public void setStatus_descricao(java.lang.String PARAM) {
    this.status_descricao = PARAM;
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

  public java.sql.Timestamp getData_ordenacao() {
    return data_ordenacao;
  }

  public void setData_ordenacao(java.sql.Timestamp PARAM) {
    this.data_ordenacao = PARAM;
  }

  public java.lang.Integer getTal_pares() {
    return tal_pares;
  }

  public void setTal_pares(java.lang.Integer PARAM) {
    this.tal_pares = PARAM;
  }

  public java.lang.Integer getTal_parbom() {
    return tal_parbom;
  }

  public void setTal_parbom(java.lang.Integer PARAM) {
    this.tal_parbom = PARAM;
  }

  public java.lang.Integer getTal_parrej() {
    return tal_parrej;
  }

  public void setTal_parrej(java.lang.Integer PARAM) {
    this.tal_parrej = PARAM;
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

  public java.lang.String getCab_desc() {
    return cab_desc;
  }

  public void setCab_desc(java.lang.String PARAM) {
    this.cab_desc = PARAM;
  }

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getCor_desc() {
    return cor_desc;
  }

  public void setCor_desc(java.lang.String PARAM) {
    this.cor_desc = PARAM;
  }

  public java.sql.Timestamp getData_corte() {
    return data_corte;
  }

  public void setData_corte(java.sql.Timestamp PARAM) {
    this.data_corte = PARAM;
  }

  public java.sql.Timestamp getData_cost() {
    return data_cost;
  }

  public void setData_cost(java.sql.Timestamp PARAM) {
    this.data_cost = PARAM;
  }

  public java.sql.Timestamp getData_mont() {
    return data_mont;
  }

  public void setData_mont(java.sql.Timestamp PARAM) {
    this.data_mont = PARAM;
  }

}
