package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Itens_menus
  * @version 03/04/2013 09:55:09
  */
public class Itens_menus implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer itme_id;
  private java.lang.String itme_nome;
  private java.lang.String itme_texto;
  private java.lang.String itme_comando;
  private java.lang.Integer itme_menu_id;
  private java.lang.Integer itme_doin_id;

  public Itens_menus() {
  }

  public java.lang.Integer getItme_id() {
    return itme_id;
  }

  public void setItme_id(java.lang.Integer PARAM) {
    this.itme_id = PARAM;
  }

  public java.lang.String getItme_nome() {
    return itme_nome;
  }

  public void setItme_nome(java.lang.String PARAM) {
    this.itme_nome = PARAM;
  }

  public java.lang.String getItme_texto() {
    return itme_texto;
  }

  public void setItme_texto(java.lang.String PARAM) {
    this.itme_texto = PARAM;
  }

  public java.lang.String getItme_comando() {
    return itme_comando;
  }

  public void setItme_comando(java.lang.String PARAM) {
    this.itme_comando = PARAM;
  }

  public java.lang.Integer getItme_menu_id() {
    return itme_menu_id;
  }

  public void setItme_menu_id(java.lang.Integer PARAM) {
    this.itme_menu_id = PARAM;
  }

  public java.lang.Integer getItme_doin_id() {
    return itme_doin_id;
  }

  public void setItme_doin_id(java.lang.Integer PARAM) {
    this.itme_doin_id = PARAM;
  }

}
