package portalbr.dbobj.view;

/** DataBase Object from table .Cliente_representante_view
  * @version 03/04/2013 10:04:04
  */
public class Cliente_representante_view implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_cliente;
  private java.lang.String codigo_representante;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;

  public Cliente_representante_view() {
  }

  public int getCodigo_cliente() {
    return codigo_cliente;
  }

  public void setCodigo_cliente(int PARAM) {
    this.codigo_cliente = PARAM;
  }

  public java.lang.String getCodigo_representante() {
    return codigo_representante;
  }

  public void setCodigo_representante(java.lang.String PARAM) {
    this.codigo_representante = PARAM;
  }

  public java.lang.String getCli_nome() {
    return cli_nome;
  }

  public void setCli_nome(java.lang.String PARAM) {
    this.cli_nome = PARAM;
  }

  public java.lang.String getCli_rzao() {
    return cli_rzao;
  }

  public void setCli_rzao(java.lang.String PARAM) {
    this.cli_rzao = PARAM;
  }

}
