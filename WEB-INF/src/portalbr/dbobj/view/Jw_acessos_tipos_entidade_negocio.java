package portalbr.dbobj.view;

/** DataBase Object from table .Jw_acessos_tipos_entidade_negocio
  * @version 03/04/2013 09:52:19
  */
public class Jw_acessos_tipos_entidade_negocio implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer aten_id;
  private java.lang.Integer aten_tien_id;
  private java.lang.Integer aten_doin_id;
  private java.lang.Integer aten_dias_consulta_retroativa;
  private java.lang.String doin_nome;
  private java.lang.String doin_descricao;

  public Jw_acessos_tipos_entidade_negocio() {
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
