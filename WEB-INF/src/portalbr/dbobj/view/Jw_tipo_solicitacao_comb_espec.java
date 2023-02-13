package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipo_solicitacao_comb_espec
  * @version 14/08/2019 16:42:06
  */
public class Jw_tipo_solicitacao_comb_espec implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_tipo;
  private java.lang.String descricao_tipo;

  public Jw_tipo_solicitacao_comb_espec() {
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

}
