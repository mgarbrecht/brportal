package portalbr.dbobj.view;

/** DataBase Object from table .Jw_permissoes
  * @version 03/04/2013 09:18:41
  */
public class Jw_permissoes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String acdi_doin_id;
  private java.lang.String usua_usuario;

  public Jw_permissoes() {
  }

  public java.lang.String getAcdi_doin_id() {
    return acdi_doin_id;
  }

  public void setAcdi_doin_id(java.lang.String PARAM) {
    this.acdi_doin_id = PARAM;
  }

  public java.lang.String getUsua_usuario() {
    return usua_usuario;
  }

  public void setUsua_usuario(java.lang.String PARAM) {
    this.usua_usuario = PARAM;
  }

}
