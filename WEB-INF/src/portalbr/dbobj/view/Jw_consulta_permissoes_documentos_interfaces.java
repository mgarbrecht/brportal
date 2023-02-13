package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_permissoes_documentos_interfaces
  * @version 15/08/2016 12:13:45
  */
public class Jw_consulta_permissoes_documentos_interfaces implements java.io.Serializable, com.egen.util.jdbc.View {
  private double doin_id;
  private java.lang.String doin_nome;
  private java.lang.String quebra;
  private java.lang.String descricao;

  public Jw_consulta_permissoes_documentos_interfaces() {
  }

  public double getDoin_id() {
    return doin_id;
  }

  public void setDoin_id(double PARAM) {
    this.doin_id = PARAM;
  }

  public java.lang.String getDoin_nome() {
    return doin_nome;
  }

  public void setDoin_nome(java.lang.String PARAM) {
    this.doin_nome = PARAM;
  }

  public java.lang.String getQuebra() {
    return quebra;
  }

  public void setQuebra(java.lang.String PARAM) {
    this.quebra = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

}
