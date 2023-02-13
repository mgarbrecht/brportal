package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acessos_entidades_negocio
  * @version 03/04/2013 09:52:29
  */
public class Jw_acessos_entidades_negocio implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer acen_id;
  private java.lang.Integer acen_enne_id;
  private java.lang.Integer acen_doin_id;
  private java.lang.Integer acen_dias_consulta_retroativa;
  private java.lang.String doin_nome;
  private java.lang.String doin_descricao;

  public Jw_acessos_entidades_negocio() {
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

  public java.lang.String getDoin_nome() {
    return doin_nome;
  }

  public void setDoin_nome(java.lang.String PARAM) {
    this.doin_nome = PARAM;
  }

  public java.lang.String getDoin_descricao() {
    return doin_descricao;
  }

  public void setDoin_descricao(java.lang.String PARAM) {
    this.doin_descricao = PARAM;
  }

}
