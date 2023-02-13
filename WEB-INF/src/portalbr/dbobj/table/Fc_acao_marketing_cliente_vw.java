package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Fc_acao_marketing_cliente_vw
  * @version 21/08/2013 11:18:20
  */
public class Fc_acao_marketing_cliente_vw implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer cli_cdgo;
  private java.lang.String marca;
  private java.lang.String erc;
  private java.lang.String desc_tmidia;
  private java.lang.Double valor_tmidia;
  private java.lang.String obs_acao_mkt;
  private java.sql.Timestamp data_transacao;

  public Fc_acao_marketing_cliente_vw() {
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getMarca() {
    return marca;
  }

  public void setMarca(java.lang.String PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getErc() {
    return erc;
  }

  public void setErc(java.lang.String PARAM) {
    this.erc = PARAM;
  }

  public java.lang.String getDesc_tmidia() {
    return desc_tmidia;
  }

  public void setDesc_tmidia(java.lang.String PARAM) {
    this.desc_tmidia = PARAM;
  }

  public java.lang.Double getValor_tmidia() {
    return valor_tmidia;
  }

  public void setValor_tmidia(java.lang.Double PARAM) {
    this.valor_tmidia = PARAM;
  }

  public java.lang.String getObs_acao_mkt() {
    return obs_acao_mkt;
  }

  public void setObs_acao_mkt(java.lang.String PARAM) {
    this.obs_acao_mkt = PARAM;
  }

  public java.sql.Timestamp getData_transacao() {
    return data_transacao;
  }

  public void setData_transacao(java.sql.Timestamp PARAM) {
    this.data_transacao = PARAM;
  }

}
