package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Menus
  * @version 05/07/2010 07:02:26
  */
public class Menus implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer menu_id;
  private java.lang.String menu_nome;
  private java.lang.String menu_texto;
  private java.lang.Integer menu_pai_menu_id;

  public Menus() {
  }

  public java.lang.Integer getMenu_id() {
    return menu_id;
  }

  public void setMenu_id(java.lang.Integer PARAM) {
    this.menu_id = PARAM;
  }

  public java.lang.String getMenu_nome() {
    return menu_nome;
  }

  public void setMenu_nome(java.lang.String PARAM) {
    this.menu_nome = PARAM;
  }

  public java.lang.String getMenu_texto() {
    return menu_texto;
  }

  public void setMenu_texto(java.lang.String PARAM) {
    this.menu_texto = PARAM;
  }

  public java.lang.Integer getMenu_pai_menu_id() {
    return menu_pai_menu_id;
  }

  public void setMenu_pai_menu_id(java.lang.Integer PARAM) {
    this.menu_pai_menu_id = PARAM;
  }

}
