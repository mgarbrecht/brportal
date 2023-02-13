package portalbr.dbobj.view;

/** DataBase Object from table .Jw_produtos
  * @version 03/04/2013 09:15:35
  */
public class Jw_produtos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.String preco;
  private java.lang.String ref_desc;
  private java.lang.Integer codigo_grupo;
  private java.lang.String descricao_grupo;
  private java.lang.String fit_imagem;
  private java.lang.String descricao_marca;

  public Jw_produtos() {
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

  public java.lang.String getPreco() {
    return preco;
  }

  public void setPreco(java.lang.String PARAM) {
    this.preco = PARAM;
  }

  public java.lang.String getRef_desc() {
    return ref_desc;
  }

  public void setRef_desc(java.lang.String PARAM) {
    this.ref_desc = PARAM;
  }

  public java.lang.Integer getCodigo_grupo() {
    return codigo_grupo;
  }

  public void setCodigo_grupo(java.lang.Integer PARAM) {
    this.codigo_grupo = PARAM;
  }

  public java.lang.String getDescricao_grupo() {
    return descricao_grupo;
  }

  public void setDescricao_grupo(java.lang.String PARAM) {
    this.descricao_grupo = PARAM;
  }

  public java.lang.String getFit_imagem() {
    return fit_imagem;
  }

  public void setFit_imagem(java.lang.String PARAM) {
    this.fit_imagem = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

}
