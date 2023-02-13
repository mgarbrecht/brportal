package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acessos_usuarios
  * @version 03/04/2013 09:52:09
  */
public class Jw_acessos_usuarios implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer acus_id;
  private java.lang.Integer acus_usua_id;
  private java.lang.Integer acus_doin_id;
  private java.lang.String acus_negar_acesso;
  private java.lang.Integer acus_dias_consulta_retroativa;
  private java.lang.String doin_nome;
  private java.lang.String doin_descricao;

  public Jw_acessos_usuarios() {
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
