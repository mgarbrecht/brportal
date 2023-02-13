package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_tipos_entidade_negocio
  * @version 03/04/2013 10:07:42
  */
public class Acessos_tipos_entidade_negocio implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer aten_id;
  private java.lang.Integer aten_tien_id;
  private java.lang.Integer aten_doin_id;
  private java.lang.Integer aten_dias_consulta_retroativa;

  public Acessos_tipos_entidade_negocio() {
  }

  public java.lang.Integer getAten_id() {
    return aten_id;
  }

  public void setAten_id(java.lang.Integer PARAM) {
    this.aten_id = PARAM;
  }

  public java.lang.Integer getAten_tien_id() {
    return aten_tien_id;
  }

  public void setAten_tien_id(java.lang.Integer PARAM) {
    this.aten_tien_id = PARAM;
  }

  public java.lang.Integer getAten_doin_id() {
    return aten_doin_id;
  }

  public void setAten_doin_id(java.lang.Integer PARAM) {
    this.aten_doin_id = PARAM;
  }

  public java.lang.Integer getAten_dias_consulta_retroativa() {
    return aten_dias_consulta_retroativa;
  }

  public void setAten_dias_consulta_retroativa(java.lang.Integer PARAM) {
    this.aten_dias_consulta_retroativa = PARAM;
  }

}
