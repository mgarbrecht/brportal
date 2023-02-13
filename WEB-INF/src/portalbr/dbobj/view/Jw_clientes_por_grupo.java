package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_por_grupo
  * @version 03/04/2013 09:42:56
  */
public class Jw_clientes_por_grupo implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_cdgo;
  private java.lang.String cli_nome;
  private java.lang.String cli_rzao;
  private java.lang.String data_ultima_compra;

  public Jw_clientes_por_grupo() {
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
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

  public java.lang.String getData_ultima_compra() {
    return data_ultima_compra;
  }

  public void setData_ultima_compra(java.lang.String PARAM) {
    this.data_ultima_compra = PARAM;
  }

}
