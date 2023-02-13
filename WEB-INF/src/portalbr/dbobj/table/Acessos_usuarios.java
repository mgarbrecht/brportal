package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_usuarios
  * @version 03/04/2013 10:07:35
  */
public class Acessos_usuarios implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer acus_id;
  private java.lang.Integer acus_usua_id;
  private java.lang.Integer acus_doin_id;
  private java.lang.String acus_negar_acesso;
  private java.lang.Integer acus_dias_consulta_retroativa;

  public Acessos_usuarios() {
  }

  public java.lang.Integer getAcus_id() {
    return acus_id;
  }

  public void setAcus_id(java.lang.Integer PARAM) {
    this.acus_id = PARAM;
  }

  public java.lang.Integer getAcus_usua_id() {
    return acus_usua_id;
  }

  public void setAcus_usua_id(java.lang.Integer PARAM) {
    this.acus_usua_id = PARAM;
  }

  public java.lang.Integer getAcus_doin_id() {
    return acus_doin_id;
  }

  public void setAcus_doin_id(java.lang.Integer PARAM) {
    this.acus_doin_id = PARAM;
  }

  public java.lang.String getAcus_negar_acesso() {
    return acus_negar_acesso;
  }

  public void setAcus_negar_acesso(java.lang.String PARAM) {
    this.acus_negar_acesso = PARAM;
  }

  public java.lang.Integer getAcus_dias_consulta_retroativa() {
    return acus_dias_consulta_retroativa;
  }

  public void setAcus_dias_consulta_retroativa(java.lang.Integer PARAM) {
    this.acus_dias_consulta_retroativa = PARAM;
  }

}
