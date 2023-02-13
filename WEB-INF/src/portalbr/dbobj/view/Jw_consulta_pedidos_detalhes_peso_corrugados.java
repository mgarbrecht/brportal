package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_pedidos_detalhes_peso_corrugados
  * @version 03/04/2013 09:33:38
  */
public class Jw_consulta_pedidos_detalhes_peso_corrugados implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo;
  private java.lang.String descricao;
  private java.lang.Double peso_corrug;
  private java.lang.Double comprimento;
  private java.lang.Double largura;
  private java.lang.Double altura;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;

  public Jw_consulta_pedidos_detalhes_peso_corrugados() {
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

  public java.lang.Double getPeso_corrug() {
    return peso_corrug;
  }

  public void setPeso_corrug(java.lang.Double PARAM) {
    this.peso_corrug = PARAM;
  }

  public java.lang.Double getComprimento() {
    return comprimento;
  }

  public void setComprimento(java.lang.Double PARAM) {
    this.comprimento = PARAM;
  }

  public java.lang.Double getLargura() {
    return largura;
  }

  public void setLargura(java.lang.Double PARAM) {
    this.largura = PARAM;
  }

  public java.lang.Double getAltura() {
    return altura;
  }

  public void setAltura(java.lang.Double PARAM) {
    this.altura = PARAM;
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

}
