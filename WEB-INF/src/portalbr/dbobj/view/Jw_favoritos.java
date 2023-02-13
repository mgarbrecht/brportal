package portalbr.dbobj.view;

/** DataBase Object from table .Jw_favoritos
  * @version 16/05/2014 09:25:15
  */
public class Jw_favoritos implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String menu_nome;
  private java.lang.String acdi_usua_id;
  private java.lang.String itme_id;
  private java.lang.String itme_texto;
  private java.lang.String link;

  public Jw_favoritos() {
  }

  public java.lang.String getMenu_nome() {
    return menu_nome;
  }

  public void setMenu_nome(java.lang.String PARAM) {
    this.menu_nome = PARAM;
  }

  public java.lang.String getAcdi_usua_id() {
    return acdi_usua_id;
  }

  public void setAcdi_usua_id(java.lang.String PARAM) {
    this.acdi_usua_id = PARAM;
  }

  public java.lang.String getItme_id() {
    return itme_id;
  }

  public void setItme_id(java.lang.String PARAM) {
    this.itme_id = PARAM;
  }

  public java.lang.String getItme_texto() {
    return itme_texto;
  }

  public void setItme_texto(java.lang.String PARAM) {
    this.itme_texto = PARAM;
  }

  public java.lang.String getLink() {
    return link;
  }

  public void setLink(java.lang.String PARAM) {
    this.link = PARAM;
  }

}
