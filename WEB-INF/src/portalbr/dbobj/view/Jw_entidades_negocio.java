package portalbr.dbobj.view;

/** DataBase Object from table .Jw_entidades_negocio
  * @version 03/04/2013 09:30:46
  */
public class Jw_entidades_negocio implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer enne_id;
  private java.lang.String enne_descricao;
  private java.lang.String enne_chave;
  private java.lang.Integer enne_tien_id;
  private java.lang.Integer tien_dias_consulta_retroativa;

  public Jw_entidades_negocio() {
  }

  public java.lang.Integer getEnne_id() {
    return enne_id;
  }

  public void setEnne_id(java.lang.Integer PARAM) {
    this.enne_id = PARAM;
  }

  public java.lang.String getEnne_descricao() {
    return enne_descricao;
  }

  public void setEnne_descricao(java.lang.String PARAM) {
    this.enne_descricao = PARAM;
  }

  public java.lang.String getEnne_chave() {
    return enne_chave;
  }

  public void setEnne_chave(java.lang.String PARAM) {
    this.enne_chave = PARAM;
  }

  public java.lang.Integer getEnne_tien_id() {
    return enne_tien_id;
  }

  public void setEnne_tien_id(java.lang.Integer PARAM) {
    this.enne_tien_id = PARAM;
  }

  public java.lang.Integer getTien_dias_consulta_retroativa() {
    return tien_dias_consulta_retroativa;
  }

  public void setTien_dias_consulta_retroativa(java.lang.Integer PARAM) {
    this.tien_dias_consulta_retroativa = PARAM;
  }

}
