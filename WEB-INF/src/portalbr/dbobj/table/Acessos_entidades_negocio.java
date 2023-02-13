package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_entidades_negocio
  * @version 03/04/2013 10:07:48
  */
public class Acessos_entidades_negocio implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer acen_id;
  private java.lang.Integer acen_enne_id;
  private java.lang.Integer acen_doin_id;
  private java.lang.Integer acen_dias_consulta_retroativa;

  public Acessos_entidades_negocio() {
  }

  public java.lang.Integer getAcen_id() {
    return acen_id;
  }

  public void setAcen_id(java.lang.Integer PARAM) {
    this.acen_id = PARAM;
  }

  public java.lang.Integer getAcen_enne_id() {
    return acen_enne_id;
  }

  public void setAcen_enne_id(java.lang.Integer PARAM) {
    this.acen_enne_id = PARAM;
  }

  public java.lang.Integer getAcen_doin_id() {
    return acen_doin_id;
  }

  public void setAcen_doin_id(java.lang.Integer PARAM) {
    this.acen_doin_id = PARAM;
  }

  public java.lang.Integer getAcen_dias_consulta_retroativa() {
    return acen_dias_consulta_retroativa;
  }

  public void setAcen_dias_consulta_retroativa(java.lang.Integer PARAM) {
    this.acen_dias_consulta_retroativa = PARAM;
  }

}
