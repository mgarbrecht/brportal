package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_duplicata_transacoes
  * @version 16/05/2014 09:18:43
  */
public class Jw_consulta_duplicata_transacoes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String tit_codigo;
  private java.lang.String port;
  private java.lang.String trn_codigo;
  private java.lang.String transacao;
  private java.sql.Timestamp dt;
  private java.sql.Timestamp venc_ant;
  private double valor_anterior;

  public Jw_consulta_duplicata_transacoes() {
  }

  public java.lang.String getTit_codigo() {
    return tit_codigo;
  }

  public void setTit_codigo(java.lang.String PARAM) {
    this.tit_codigo = PARAM;
  }

  public java.lang.String getPort() {
    return port;
  }

  public void setPort(java.lang.String PARAM) {
    this.port = PARAM;
  }

  public java.lang.String getTrn_codigo() {
    return trn_codigo;
  }

  public void setTrn_codigo(java.lang.String PARAM) {
    this.trn_codigo = PARAM;
  }

  public java.lang.String getTransacao() {
    return transacao;
  }

  public void setTransacao(java.lang.String PARAM) {
    this.transacao = PARAM;
  }

  public java.sql.Timestamp getDt() {
    return dt;
  }

  public void setDt(java.sql.Timestamp PARAM) {
    this.dt = PARAM;
  }

  public java.sql.Timestamp getVenc_ant() {
    return venc_ant;
  }

  public void setVenc_ant(java.sql.Timestamp PARAM) {
    this.venc_ant = PARAM;
  }

  public double getValor_anterior() {
    return valor_anterior;
  }

  public void setValor_anterior(double PARAM) {
    this.valor_anterior = PARAM;
  }

}
