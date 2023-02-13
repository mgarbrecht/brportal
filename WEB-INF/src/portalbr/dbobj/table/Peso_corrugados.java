package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Peso_corrugados
  * @version 05/08/2014 11:47:30
  */
public class Peso_corrugados implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private int codigo_corrug;
  private java.lang.Integer qt_par_corrug;
  private java.lang.Double peso_corrug;
  private java.lang.String ativo;
  private java.lang.Double altura;
  private java.lang.Double largura;
  private java.lang.Double comprimento;
  private java.lang.Double peso_embalagem;
  private java.lang.Double peso_adicional;
  private java.lang.String tipo_mercado;
  private java.sql.Date data_log_afv;

  public Peso_corrugados() {
  }

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
  }

  public int getCodigo_corrug() {
    return codigo_corrug;
  }

  public void setCodigo_corrug(int PARAM) {
    this.codigo_corrug = PARAM;
  }

  public java.lang.Integer getQt_par_corrug() {
    return qt_par_corrug;
  }

  public void setQt_par_corrug(java.lang.Integer PARAM) {
    this.qt_par_corrug = PARAM;
  }

  public java.lang.Double getPeso_corrug() {
    return peso_corrug;
  }

  public void setPeso_corrug(java.lang.Double PARAM) {
    this.peso_corrug = PARAM;
  }

  public java.lang.String getAtivo() {
    return ativo;
  }

  public void setAtivo(java.lang.String PARAM) {
    this.ativo = PARAM;
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

  public java.lang.Double getPeso_embalagem() {
    return peso_embalagem;
  }

  public void setPeso_embalagem(java.lang.Double PARAM) {
    this.peso_embalagem = PARAM;
  }

  public java.lang.Double getPeso_adicional() {
    return peso_adicional;
  }

  public void setPeso_adicional(java.lang.Double PARAM) {
    this.peso_adicional = PARAM;
  }

  public java.lang.String getTipo_mercado() {
    return tipo_mercado;
  }

  public void setTipo_mercado(java.lang.String PARAM) {
    this.tipo_mercado = PARAM;
  }

  public java.sql.Date getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Date PARAM) {
    this.data_log_afv = PARAM;
  }

}
