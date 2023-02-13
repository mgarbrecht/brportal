package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Links_dinamicos
  * @version 07/02/2014 09:13:44
  */
public class Links_dinamicos implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int lidi_id;
  private java.lang.String lidi_titulo;
  private java.lang.String lidi_descricao;
  private java.lang.String lidi_caminho;
  private java.lang.Integer lidi_marca;
  private java.lang.String lidi_tipo;
  private java.lang.Integer lidi_tien_id;
  private java.lang.Integer lidi_enne_id;

  public Links_dinamicos() {
  }

  public int getLidi_id() {
    return lidi_id;
  }

  public void setLidi_id(int PARAM) {
    this.lidi_id = PARAM;
  }

  public java.lang.String getLidi_titulo() {
    return lidi_titulo;
  }

  public void setLidi_titulo(java.lang.String PARAM) {
    this.lidi_titulo = PARAM;
  }

  public java.lang.String getLidi_descricao() {
    return lidi_descricao;
  }

  public void setLidi_descricao(java.lang.String PARAM) {
    this.lidi_descricao = PARAM;
  }

  public java.lang.String getLidi_caminho() {
    return lidi_caminho;
  }

  public void setLidi_caminho(java.lang.String PARAM) {
    this.lidi_caminho = PARAM;
  }

  public java.lang.Integer getLidi_marca() {
    return lidi_marca;
  }

  public void setLidi_marca(java.lang.Integer PARAM) {
    this.lidi_marca = PARAM;
  }

  public java.lang.String getLidi_tipo() {
    return lidi_tipo;
  }

  public void setLidi_tipo(java.lang.String PARAM) {
    this.lidi_tipo = PARAM;
  }

  public java.lang.Integer getLidi_tien_id() {
    return lidi_tien_id;
  }

  public void setLidi_tien_id(java.lang.Integer PARAM) {
    this.lidi_tien_id = PARAM;
  }

  public java.lang.Integer getLidi_enne_id() {
    return lidi_enne_id;
  }

  public void setLidi_enne_id(java.lang.Integer PARAM) {
    this.lidi_enne_id = PARAM;
  }

}
