package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ficha_embalagem
  * @version 03/04/2013 09:28:59
  */
public class Jw_ficha_embalagem implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer lin_cdgo;
  private java.lang.String lin_nome;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer codigo_corrugado;
  private java.lang.String descricao_corrugado;
  private java.lang.Integer mat_nro;
  private java.lang.String descricao;
  private java.lang.Double altura;
  private java.lang.Double largura;
  private java.lang.Double comprimento;
  private java.lang.Integer qt_par_corrug;
  private java.lang.Integer cod_cx_ind;
  private java.lang.String cod_cx_ind_desc;

  public Jw_ficha_embalagem() {
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.Integer getCodigo_corrugado() {
    return codigo_corrugado;
  }

  public void setCodigo_corrugado(java.lang.Integer PARAM) {
    this.codigo_corrugado = PARAM;
  }

  public java.lang.String getDescricao_corrugado() {
    return descricao_corrugado;
  }

  public void setDescricao_corrugado(java.lang.String PARAM) {
    this.descricao_corrugado = PARAM;
  }

  public java.lang.Integer getMat_nro() {
    return mat_nro;
  }

  public void setMat_nro(java.lang.Integer PARAM) {
    this.mat_nro = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Double getAltura() {
    return altura;
  }

  public void setAltura(java.lang.Double PARAM) {
    this.altura = PARAM;
  }

  public java.lang.Double getLargura() {
    return largura;
  }

  public void setLargura(java.lang.Double PARAM) {
    this.largura = PARAM;
  }

  public java.lang.Double getComprimento() {
    return comprimento;
  }

  public void setComprimento(java.lang.Double PARAM) {
    this.comprimento = PARAM;
  }

  public java.lang.Integer getQt_par_corrug() {
    return qt_par_corrug;
  }

  public void setQt_par_corrug(java.lang.Integer PARAM) {
    this.qt_par_corrug = PARAM;
  }

  public java.lang.Integer getCod_cx_ind() {
    return cod_cx_ind;
  }

  public void setCod_cx_ind(java.lang.Integer PARAM) {
    this.cod_cx_ind = PARAM;
  }

  public java.lang.String getCod_cx_ind_desc() {
    return cod_cx_ind_desc;
  }

  public void setCod_cx_ind_desc(java.lang.String PARAM) {
    this.cod_cx_ind_desc = PARAM;
  }

}
