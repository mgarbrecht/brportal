package portalbr.dbobj.table;

/** DataBase Object from table WBRIO.Acessos_ent_negocio_vw
  * @version 25/05/2015 09:20:35
  */
public class Acessos_ent_negocio_vw implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer usua_id;
  private java.lang.Integer doin_id;
  private java.lang.Integer dias_consulta_retroativa;

  public Acessos_ent_negocio_vw() {
  }

  public java.lang.Integer getUsua_id() {
    return usua_id;
  }

  public void setUsua_id(java.lang.Integer PARAM) {
    this.usua_id = PARAM;
  }

  public java.lang.Integer getDoin_id() {
    return doin_id;
  }

  public void setDoin_id(java.lang.Integer PARAM) {
    this.doin_id = PARAM;
  }

  public java.lang.Integer getDias_consulta_retroativa() {
    return dias_consulta_retroativa;
  }

  public void setDias_consulta_retroativa(java.lang.Integer PARAM) {
    this.dias_consulta_retroativa = PARAM;
  }

}
