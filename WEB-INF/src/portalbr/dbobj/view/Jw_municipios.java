package portalbr.dbobj.view;

/** DataBase Object from table .Jw_municipios
  * @version 18/11/2013 12:40:59
  */
public class Jw_municipios implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo;
  private java.lang.String est_unifed;
  private java.lang.String descricao;
  private java.lang.String codigo_ibge;

  public Jw_municipios() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getEst_unifed() {
    return est_unifed;
  }

  public void setEst_unifed(java.lang.String PARAM) {
    this.est_unifed = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.String getCodigo_ibge() {
    return codigo_ibge;
  }

  public void setCodigo_ibge(java.lang.String PARAM) {
    this.codigo_ibge = PARAM;
  }

}
