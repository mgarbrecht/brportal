package portalbr.dbobj.view;

/** DataBase Object from table .Jw_abastecimento_materiais_fornec
  * @version 22/08/2013 09:51:26
  */
public class Jw_abastecimento_materiais_fornec implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Long fornecedor_codigo;
  private java.lang.Integer fen_seq;
  private java.lang.Long ies_codigo;
  private java.lang.Integer cor_cdgo;
  private java.lang.String tai_codigo;
  private java.lang.Integer cod_min_fabr;
  private java.lang.Double quantidade_transito;
  private java.lang.Double quantidade_produzida;
  private java.lang.Double quantidade_atraso;
  private java.sql.Date data_entrega;
  private java.sql.Timestamp data_atualizacao;
  private java.lang.Integer id;

  public Jw_abastecimento_materiais_fornec() {
  }

  public java.lang.Long getFornecedor_codigo() {
    return fornecedor_codigo;
  }

  public void setFornecedor_codigo(java.lang.Long PARAM) {
    this.fornecedor_codigo = PARAM;
  }

  public java.lang.Integer getFen_seq() {
    return fen_seq;
  }

  public void setFen_seq(java.lang.Integer PARAM) {
    this.fen_seq = PARAM;
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
