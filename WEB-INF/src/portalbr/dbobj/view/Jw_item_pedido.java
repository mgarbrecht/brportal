package portalbr.dbobj.view;

/** DataBase Object from table .Jw_item_pedido
  * @version 04/03/2019 17:00:14
  */
public class Jw_item_pedido implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String linha;
  private java.lang.String referencia;
  private java.lang.String cabedal;
  private java.lang.String cor;
  private int sequencial;
  private int codigo_linha;
  private int codigo_referencia;
  private int codigo_cabedal;
  private int codigo_cor;
  private int ped_nmro;
  private java.lang.String descricao_item;

  public Jw_item_pedido() {
  }

  public java.lang.String getLinha() {
    return linha;
  }

  public void setLinha(java.lang.String PARAM) {
    this.linha = PARAM;
  }

  public java.lang.String getReferencia() {
    return referencia;
  }

  public void setReferencia(java.lang.String PARAM) {
    this.referencia = PARAM;
  }

  public java.lang.String getCabedal() {
    return cabedal;
  }

  public void setCabedal(java.lang.String PARAM) {
    this.cabedal = PARAM;
  }

  public java.lang.String getCor() {
    return cor;
  }

  public void setCor(java.lang.String PARAM) {
    this.cor = PARAM;
  }

  public int getSequencial() {
    return sequencial;
  }

  public void setSequencial(int PARAM) {
    this.sequencial = PARAM;
  }

  public int getCodigo_linha() {
    return codigo_linha;
  }

  public void setCodigo_linha(int PARAM) {
    this.codigo_linha = PARAM;
  }

  public int getCodigo_referencia() {
    return codigo_referencia;
  }

  public void setCodigo_referencia(int PARAM) {
    this.codigo_referencia = PARAM;
  }

  public int getCodigo_cabedal() {
    return codigo_cabedal;
  }

  public void setCodigo_cabedal(int PARAM) {
    this.codigo_cabedal = PARAM;
  }

  public int getCodigo_cor() {
    return codigo_cor;
  }

  public void setCodigo_cor(int PARAM) {
    this.codigo_cor = PARAM;
  }

  public int getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(int PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getDescricao_item() {
    return descricao_item;
  }

  public void setDescricao_item(java.lang.String PARAM) {
    this.descricao_item = PARAM;
  }

}
