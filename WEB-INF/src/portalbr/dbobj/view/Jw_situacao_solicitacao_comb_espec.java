package portalbr.dbobj.view;

/** DataBase Object from table .Jw_situacao_solicitacao_comb_espec
  * @version 07/11/2022 14:24:44
  */
public class Jw_situacao_solicitacao_comb_espec implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo_situacao;
  private java.lang.String descricao_situacao;
  private java.lang.String rv_high_value;

  public Jw_situacao_solicitacao_comb_espec() {
  }

  public java.lang.String getCodigo_situacao() {
    return codigo_situacao;
  }

  public void setCodigo_situacao(java.lang.String PARAM) {
    this.codigo_situacao = PARAM;
  }

  public java.lang.String getDescricao_situacao() {
    return descricao_situacao;
  }

  public void setDescricao_situacao(java.lang.String PARAM) {
    this.descricao_situacao = PARAM;
  }

  public java.lang.String getRv_high_value() {
    return rv_high_value;
  }

  public void setRv_high_value(java.lang.String PARAM) {
    this.rv_high_value = PARAM;
  }

}
