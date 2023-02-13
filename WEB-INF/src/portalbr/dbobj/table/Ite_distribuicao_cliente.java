package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ite_distribuicao_cliente
  * @version 08/01/2016 09:47:07
  */
public class Ite_distribuicao_cliente implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer ped_nmro;
  private java.lang.Integer ite_seqn;
  private java.lang.String cliente;
  private java.lang.Integer qtd_caixas;

  public Ite_distribuicao_cliente() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.Integer getIte_seqn() {
    return ite_seqn;
  }

  public void setIte_seqn(java.lang.Integer PARAM) {
    this.ite_seqn = PARAM;
  }

  public java.lang.String getCliente() {
    return cliente;
  }

  public void setCliente(java.lang.String PARAM) {
    this.cliente = PARAM;
  }

  public java.lang.Integer getQtd_caixas() {
    return qtd_caixas;
  }

  public void setQtd_caixas(java.lang.Integer PARAM) {
    this.qtd_caixas = PARAM;
  }

}
