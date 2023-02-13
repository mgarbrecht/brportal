package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_detalhes_item_estoque
  * @version 03/04/2013 09:38:02
  */
public class Jw_consulta_pedidos_detalhes_item_estoque implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo;
  private java.lang.String descricao;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer codigo_embalagem;

  public Jw_consulta_pedidos_detalhes_item_estoque() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.Integer getCodigo_embalagem() {
    return codigo_embalagem;
  }

  public void setCodigo_embalagem(java.lang.Integer PARAM) {
    this.codigo_embalagem = PARAM;
  }

}
