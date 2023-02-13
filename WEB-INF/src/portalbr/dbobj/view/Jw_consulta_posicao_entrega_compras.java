package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_posicao_entrega_compras
  * @version 07/05/2015 13:00:08
  */
public class Jw_consulta_posicao_entrega_compras implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String fil_filial;
  private java.lang.String for_codigo;
  private java.lang.String fornecedor;
  private java.sql.Timestamp data_compra;
  private java.lang.String ies_codigo;
  private java.lang.String descricao_item;
  private java.lang.String cor_cdgo;
  private java.lang.String cor_desc;
  private java.sql.Timestamp data_entrega;
  private double quant_comprada;
  private double quant_recebida;
  private java.lang.Integer oco_numero;
  private double saldo;

  public Jw_consulta_posicao_entrega_compras() {
  }

  public java.lang.String getFil_filial() {
    return fil_filial;
  }

  public void setFil_filial(java.lang.String PARAM) {
    this.fil_filial = PARAM;
  }

  public java.lang.String getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.String PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.String getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(java.lang.String PARAM) {
    this.fornecedor = PARAM;
  }

  public java.sql.Timestamp getData_compra() {
    return data_compra;
  }

  public void setData_compra(java.sql.Timestamp PARAM) {
    this.data_compra = PARAM;
  }

  public java.lang.String getIes_codigo() {
    return ies_codigo;
  }

  public void setIes_codigo(java.lang.String PARAM) {
    this.ies_codigo = PARAM;
  }

  public java.lang.String getDescricao_item() {
    return descricao_item;
  }

  public void setDescricao_item(java.lang.String PARAM) {
    this.descricao_item = PARAM;
  }

  public java.lang.String getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.String PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getCor_desc() {
    return cor_desc;
  }

  public void setCor_desc(java.lang.String PARAM) {
    this.cor_desc = PARAM;
  }

  public java.sql.Timestamp getData_entrega() {
    return data_entrega;
  }

  public void setData_entrega(java.sql.Timestamp PARAM) {
    this.data_entrega = PARAM;
  }

  public double getQuant_comprada() {
    return quant_comprada;
  }

  public void setQuant_comprada(double PARAM) {
    this.quant_comprada = PARAM;
  }

  public double getQuant_recebida() {
    return quant_recebida;
  }

  public void setQuant_recebida(double PARAM) {
    this.quant_recebida = PARAM;
  }

  public java.lang.Integer getOco_numero() {
    return oco_numero;
  }

  public void setOco_numero(java.lang.Integer PARAM) {
    this.oco_numero = PARAM;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double PARAM) {
    this.saldo = PARAM;
  }

}
