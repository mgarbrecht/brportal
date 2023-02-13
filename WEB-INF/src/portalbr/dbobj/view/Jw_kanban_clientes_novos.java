package portalbr.dbobj.view;

/** DataBase Object from table .Jw_kanban_clientes_novos
  * @version 03/04/2013 09:26:50
  */
public class Jw_kanban_clientes_novos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cnpj;
  private java.lang.Integer codigo_regional;
  private java.lang.String sigla_regional;
  private java.lang.String situacao;

  public Jw_kanban_clientes_novos() {
  }

  public java.lang.String getCnpj() {
    return cnpj;
  }

  public void setCnpj(java.lang.String PARAM) {
    this.cnpj = PARAM;
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getSigla_regional() {
    return sigla_regional;
  }

  public void setSigla_regional(java.lang.String PARAM) {
    this.sigla_regional = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

}
