package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Entidades_negocio
  * @version 03/04/2013 09:58:18
  */
public class Entidades_negocio implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer enne_id;
  private java.lang.String enne_descricao;
  private java.lang.String enne_chave;
  private java.lang.Integer enne_tien_id;

  public Entidades_negocio() {
  }

  public java.lang.Integer getEnne_id() {
    return enne_id;
  }

  public void setEnne_id(java.lang.Integer PARAM) {
    this.enne_id = PARAM;
  }

  public java.lang.String getEnne_descricao() {
    return enne_descricao;
  }

  public void setEnne_descricao(java.lang.String PARAM) {
    this.enne_descricao = PARAM;
  }

  public java.lang.String getEnne_chave() {
    return enne_chave;
  }

  public void setEnne_chave(java.lang.String PARAM) {
    this.enne_chave = PARAM;
  }

  public java.lang.Integer getEnne_tien_id() {
    return enne_tien_id;
  }

  public void setEnne_tien_id(java.lang.Integer PARAM) {
    this.enne_tien_id = PARAM;
  }

}
