package portalbr.dbobj.view;

/** DataBase Object from table .Jw_analise_credito_dados
  * @version 16/02/2016 11:12:15
  */
public class Jw_analise_credito_dados implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer cli_codigo;
  private java.lang.Integer esc_seqn;
  private java.lang.Integer ddn_qtde;
  private java.lang.Double ddn_valor;

  public Jw_analise_credito_dados() {
  }

  public java.lang.Integer getCli_codigo() {
    return cli_codigo;
  }

  public void setCli_codigo(java.lang.Integer PARAM) {
    this.cli_codigo = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.Integer getDdn_qtde() {
    return ddn_qtde;
  }

  public void setDdn_qtde(java.lang.Integer PARAM) {
    this.ddn_qtde = PARAM;
  }

  public java.lang.Double getDdn_valor() {
    return ddn_valor;
  }

  public void setDdn_valor(java.lang.Double PARAM) {
    this.ddn_valor = PARAM;
  }

}
