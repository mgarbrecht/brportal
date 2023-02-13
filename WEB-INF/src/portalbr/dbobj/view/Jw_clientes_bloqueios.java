package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_bloqueios
  * @version 16/05/2014 08:52:49
  */
public class Jw_clientes_bloqueios implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cli_cdgo;
  private java.lang.String codigo_bloqueio;
  private java.lang.String descricao_bloqueio;
  private java.sql.Timestamp data_inclusao;

  public Jw_clientes_bloqueios() {
  }

  public java.lang.String getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.String PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.String getCodigo_bloqueio() {
    return codigo_bloqueio;
  }

  public void setCodigo_bloqueio(java.lang.String PARAM) {
    this.codigo_bloqueio = PARAM;
  }

  public java.lang.String getDescricao_bloqueio() {
    return descricao_bloqueio;
  }

  public void setDescricao_bloqueio(java.lang.String PARAM) {
    this.descricao_bloqueio = PARAM;
  }

  public java.sql.Timestamp getData_inclusao() {
    return data_inclusao;
  }

  public void setData_inclusao(java.sql.Timestamp PARAM) {
    this.data_inclusao = PARAM;
  }

}
