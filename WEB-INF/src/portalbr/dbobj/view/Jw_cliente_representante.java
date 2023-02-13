package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cliente_representante
  * @version 03/04/2013 09:48:52
  */
public class Jw_cliente_representante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_cliente;
  private java.lang.String cli_rzao;
  private java.lang.String cli_nome;
  private java.lang.String esc_seqn;
  private java.lang.String codigo_representante;
  private java.lang.String rep_rzao;
  private java.lang.String rep_nome;

  public Jw_cliente_representante() {
  }

  public java.lang.String getCodigo_cliente() {
    return codigo_cliente;
  }

  public void setCodigo_cliente(java.lang.String PARAM) {
    this.codigo_cliente = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

  public java.lang.String getCli_nome() {
    return cli_nome;
  }

  public void setCli_nome(java.lang.String PARAM) {
    this.cli_nome = PARAM;
  }

  public java.lang.String getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.String PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.String getCodigo_representante() {
    return codigo_representante;
  }

  public void setCodigo_representante(java.lang.String PARAM) {
    this.codigo_representante = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public java.lang.String getRep_nome() {
    return rep_nome;
  }

  public void setRep_nome(java.lang.String PARAM) {
    this.rep_nome = PARAM;
  }

}
