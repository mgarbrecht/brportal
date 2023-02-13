package portalbr.dbobj.table;

/** DataBase Object from table FAT.Observacoes_nat_oper_pedido
  * @version 30/05/2019 14:33:49
  */
public class Observacoes_nat_oper_pedido implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.sql.Timestamp data_faturamento;
  private java.lang.Integer numero;
  private java.lang.Integer natoper_codigo;
  private java.lang.Integer ped_nmro;
  private java.sql.Timestamp data_cad;
  private java.lang.String usuario_cad;
  private java.lang.String texto;
  private java.lang.Integer obs_cdgo;

  public Observacoes_nat_oper_pedido() {
  }

  public java.sql.Timestamp getData_faturamento() {
    return data_faturamento;
  }

  public void setData_faturamento(java.sql.Timestamp PARAM) {
    this.data_faturamento = PARAM;
  }

  public java.lang.Integer getNumero() {
    return numero;
  }

  public void setNumero(java.lang.Integer PARAM) {
    this.numero = PARAM;
  }

  public java.lang.Integer getNatoper_codigo() {
    return natoper_codigo;
  }

  public void setNatoper_codigo(java.lang.Integer PARAM) {
    this.natoper_codigo = PARAM;
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.sql.Timestamp getData_cad() {
    return data_cad;
  }

  public void setData_cad(java.sql.Timestamp PARAM) {
    this.data_cad = PARAM;
  }

  public java.lang.String getUsuario_cad() {
    return usuario_cad;
  }

  public void setUsuario_cad(java.lang.String PARAM) {
    this.usuario_cad = PARAM;
  }

  public java.lang.String getTexto() {
    return texto;
  }

  public void setTexto(java.lang.String PARAM) {
    this.texto = PARAM;
  }

  public java.lang.Integer getObs_cdgo() {
    return obs_cdgo;
  }

  public void setObs_cdgo(java.lang.Integer PARAM) {
    this.obs_cdgo = PARAM;
  }

}
