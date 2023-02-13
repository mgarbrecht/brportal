package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Fornecedor_parametros_edi
  * @version 29/07/2015 10:54:56
  */
public class Fornecedor_parametros_edi implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer for_codigo;
  private java.lang.String caminho_edi_ordem_compra;
  private java.lang.String caminho_edi_nf;
  private java.lang.String envia_talao;
  private java.lang.Integer fen_seq_esc_seqn;
  private java.lang.String cliente_fornecedor_transp;

  public Fornecedor_parametros_edi() {
  }

  public java.lang.Integer getFor_codigo() {
    return for_codigo;
  }

  public void setFor_codigo(java.lang.Integer PARAM) {
    this.for_codigo = PARAM;
  }

  public java.lang.String getCaminho_edi_ordem_compra() {
    return caminho_edi_ordem_compra;
  }

  public void setCaminho_edi_ordem_compra(java.lang.String PARAM) {
    this.caminho_edi_ordem_compra = PARAM;
  }

  public java.lang.String getCaminho_edi_nf() {
    return caminho_edi_nf;
  }

  public void setCaminho_edi_nf(java.lang.String PARAM) {
    this.caminho_edi_nf = PARAM;
  }

  public java.lang.String getEnvia_talao() {
    return envia_talao;
  }

  public void setEnvia_talao(java.lang.String PARAM) {
    this.envia_talao = PARAM;
  }

  public java.lang.Integer getFen_seq_esc_seqn() {
    return fen_seq_esc_seqn;
  }

  public void setFen_seq_esc_seqn(java.lang.Integer PARAM) {
    this.fen_seq_esc_seqn = PARAM;
  }

  public java.lang.String getCliente_fornecedor_transp() {
    return cliente_fornecedor_transp;
  }

  public void setCliente_fornecedor_transp(java.lang.String PARAM) {
    this.cliente_fornecedor_transp = PARAM;
  }

}
