package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_documentos_interfaces
  * @version 03/04/2013 10:07:58
  */
public class Acessos_documentos_interfaces implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer acdi_id;
  private java.lang.Integer acdi_doin_id;
  private java.lang.Integer acdi_usua_id;
  private java.lang.String acdi_favorito;
  private java.lang.Integer acdi_dias_consulta_retroativa;

  public Acessos_documentos_interfaces() {
  }

  public java.lang.Integer getAcdi_id() {
    return acdi_id;
  }

  public void setAcdi_id(java.lang.Integer PARAM) {
    this.acdi_id = PARAM;
  }

  public java.lang.Integer getAcdi_doin_id() {
    return acdi_doin_id;
  }

  public void setAcdi_doin_id(java.lang.Integer PARAM) {
    this.acdi_doin_id = PARAM;
  }

  public java.lang.Integer getAcdi_usua_id() {
    return acdi_usua_id;
  }

  public void setAcdi_usua_id(java.lang.Integer PARAM) {
    this.acdi_usua_id = PARAM;
  }

  public java.lang.String getAcdi_favorito() {
    return acdi_favorito;
  }

  public void setAcdi_favorito(java.lang.String PARAM) {
    this.acdi_favorito = PARAM;
  }

  public java.lang.Integer getAcdi_dias_consulta_retroativa() {
    return acdi_dias_consulta_retroativa;
  }

  public void setAcdi_dias_consulta_retroativa(java.lang.Integer PARAM) {
    this.acdi_dias_consulta_retroativa = PARAM;
  }

}
