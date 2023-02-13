package portalbr.dbobj.view;

/** DataBase Object from table .Jw_abastecimento_materiais
  * @version 22/08/2013 10:50:06
  */
public class Jw_abastecimento_materiais implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Long fornecedor_codigo;
  private java.lang.Integer fen_seq;
  private java.lang.Long codigo;
  private java.lang.String descricao;
  private java.lang.String unm_codigo;
  private java.lang.Integer cor_cdgo;
  private java.lang.String cor_desc;
  private java.lang.Double saldo;

  public Jw_abastecimento_materiais() {
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

  public java.lang.Long getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Long PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getUnm_codigo() {
    return unm_codigo;
  }

  public void setUnm_codigo(java.lang.String PARAM) {
    this.unm_codigo = PARAM;
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

  public java.lang.Double getSaldo() {
    return saldo;
  }

  public void setSaldo(java.lang.Double PARAM) {
    this.saldo = PARAM;
  }

}
