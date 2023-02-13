package portalbr.dbobj.view;

/** DataBase Object from table .Jw_analise_clientes
  * @version 03/04/2013 09:51:04
  */
public class Jw_analise_clientes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_regional;
  private java.lang.String codigo_representante;
  private java.lang.String cli_cdgo;
  private java.lang.String esc_seqn;

  public Jw_analise_clientes() {
  }

  public java.lang.String getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.String PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getCodigo_representante() {
    return codigo_representante;
  }

  public void setCodigo_representante(java.lang.String PARAM) {
    this.codigo_representante = PARAM;
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.String PARAM) {
    this.esc_seqn = PARAM;
  }

}
