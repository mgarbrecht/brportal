package portalbr.dbobj.view;

/** DataBase Object from table .Jw_subtipo_solicitacao_comb_espec
  * @version 15/08/2019 08:33:34
  */
public class Jw_subtipo_solicitacao_comb_espec implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_tipo;
  private java.lang.String descricao_tipo;
  private java.lang.String codigo_subtipo;
  private java.lang.String descricao_subtipo;

  public Jw_subtipo_solicitacao_comb_espec() {
  }

  public java.lang.String getCodigo_tipo() {
    return codigo_tipo;
  }

  public void setCodigo_tipo(java.lang.String PARAM) {
    this.codigo_tipo = PARAM;
  }

  public java.lang.String getDescricao_tipo() {
    return descricao_tipo;
  }

  public void setDescricao_tipo(java.lang.String PARAM) {
    this.descricao_tipo = PARAM;
  }

  public java.lang.String getCodigo_subtipo() {
    return codigo_subtipo;
  }

  public void setCodigo_subtipo(java.lang.String PARAM) {
    this.codigo_subtipo = PARAM;
  }

  public java.lang.String getDescricao_subtipo() {
    return descricao_subtipo;
  }

  public void setDescricao_subtipo(java.lang.String PARAM) {
    this.descricao_subtipo = PARAM;
  }

}
