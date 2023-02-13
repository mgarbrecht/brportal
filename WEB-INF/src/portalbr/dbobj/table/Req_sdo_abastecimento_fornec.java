package portalbr.dbobj.table;

/** DataBase Object from table EST.Req_sdo_abastecimento_fornec
  * @version 13/08/2013 16:34:17
  */
public class Req_sdo_abastecimento_fornec implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Long ies_codigo;
  private java.lang.Integer cor_cdgo;
  private java.lang.String tai_codigo;
  private java.lang.Integer cod_min_fabr;
  private java.lang.Long for_codigo;
  private java.lang.Integer fen_seq;
  private java.lang.Double quantidade_transito;
  private java.lang.Double quantidade_produzida;
  private java.lang.Double quantidade_atraso;
  private java.sql.Date data_entrega;
  private java.lang.Double sdo_req;
  private java.sql.Timestamp data_atualizacao;
  private java.lang.Integer id;

  public Req_sdo_abastecimento_fornec() {
  }

  public java.lang.Long getIes_codigo() {
    return ies_codigo;
  }

  public void setIes_codigo(java.lang.Long PARAM) {
    this.ies_codigo = PARAM;
  }

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getTai_codigo() {
    return tai_codigo;
  }

  public void setTai_codigo(java.lang.String PARAM) {
    this.tai_codigo = PARAM;
  }

  public java.lang.Integer getCod_min_fabr() {
    return cod_min_fabr;
  }

  public void setCod_min_fabr(java.lang.Integer PARAM) {
    this.cod_min_fabr = PARAM;
  }

  public java.lang.Long getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.Long PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.Integer getFen_seq() {
    return fen_seq;
  }

  public void setFen_seq(java.lang.Integer PARAM) {
    this.fen_seq = PARAM;
  }

  public java.lang.Double getQuantidade_transito() {
    return quantidade_transito;
  }

  public void setQuantidade_transito(java.lang.Double PARAM) {
    this.quantidade_transito = PARAM;
  }

  public java.lang.Double getQuantidade_produzida() {
    return quantidade_produzida;
  }

  public void setQuantidade_produzida(java.lang.Double PARAM) {
    this.quantidade_produzida = PARAM;
  }

  public java.lang.Double getQuantidade_atraso() {
    return quantidade_atraso;
  }

  public void setQuantidade_atraso(java.lang.Double PARAM) {
    this.quantidade_atraso = PARAM;
  }

  public java.sql.Date getData_entrega() {
    return data_entrega;
  }

  public void setData_entrega(java.sql.Date PARAM) {
    this.data_entrega = PARAM;
  }

  public java.lang.Double getSdo_req() {
    return sdo_req;
  }

  public void setSdo_req(java.lang.Double PARAM) {
    this.sdo_req = PARAM;
  }

  public java.sql.Timestamp getData_atualizacao() {
    return data_atualizacao;
  }

  public void setData_atualizacao(java.sql.Timestamp PARAM) {
    this.data_atualizacao = PARAM;
  }

  public java.lang.Integer getId() {
    return id;
  }

  public void setId(java.lang.Integer PARAM) {
    this.id = PARAM;
  }

}
