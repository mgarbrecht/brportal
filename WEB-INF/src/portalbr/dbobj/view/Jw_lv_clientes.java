package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_clientes
  * @version 03/04/2013 09:24:23
  */
public class Jw_lv_clientes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo;
  private java.lang.String cli_rzao;
  private java.lang.String cid_est;
  private java.lang.Integer esc_seqn;
  private java.lang.Integer cli_cdgo;

  public Jw_lv_clientes() {
  }

  public java.lang.String getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.String PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getCid_est() {
    return cid_est;
  }

  public void setCid_est(java.lang.String PARAM) {
    this.cid_est = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

}
