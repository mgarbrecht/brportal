package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Informacoes_cliente
  * @version 21/08/2013 11:21:33
  */
public class Informacoes_cliente implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int sequencia;
  private java.sql.Timestamp data_informacao;
  private java.lang.String usuario;
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private java.lang.String informacoes;
  private java.lang.Integer gre_cdgo;

  public Informacoes_cliente() {
  }

  public int getSequencia() {
    return sequencia;
  }

  public void setSequencia(int PARAM) {
    this.sequencia = PARAM;
  }

  public java.sql.Timestamp getData_informacao() {
    return data_informacao;
  }

  public void setData_informacao(java.sql.Timestamp PARAM) {
    this.data_informacao = PARAM;
  }

  public java.lang.String getUsuario() {
    return usuario;
  }

  public void setUsuario(java.lang.String PARAM) {
    this.usuario = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.String getInformacoes() {
    return informacoes;
  }

  public void setInformacoes(java.lang.String PARAM) {
    this.informacoes = PARAM;
  }

  public java.lang.Integer getGre_cdgo() {
    return gre_cdgo;
  }

  public void setGre_cdgo(java.lang.Integer PARAM) {
    this.gre_cdgo = PARAM;
  }

}
