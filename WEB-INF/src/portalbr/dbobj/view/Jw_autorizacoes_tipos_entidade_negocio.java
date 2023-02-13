package portalbr.dbobj.view;

/** DataBase Object from table .Jw_autorizacoes_tipos_entidade_negocio
  * @version 03/04/2013 09:50:29
  */
public class Jw_autorizacoes_tipos_entidade_negocio implements java.io.Serializable, com.egen.util.jdbc.View {
  private int tien_id;
  private java.lang.String tien_tipo;
  private int doin_id;
  private java.lang.String doin_nome;
  private java.lang.String doin_descricao;
  private int aten_dias_consulta_retroativa;

  public Jw_autorizacoes_tipos_entidade_negocio() {
  }

  public int getTien_id() {
    return tien_id;
  }

  public void setTien_id(int PARAM) {
    this.tien_id = PARAM;
  }

  public java.lang.String getTien_tipo() {
    return tien_tipo;
  }

  public void setTien_tipo(java.lang.String PARAM) {
    this.tien_tipo = PARAM;
  }

  public int getDoin_id() {
    return doin_id;
  }

  public void setDoin_id(int PARAM) {
    this.doin_id = PARAM;
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

  public int getAten_dias_consulta_retroativa() {
    return aten_dias_consulta_retroativa;
  }

  public void setAten_dias_consulta_retroativa(int PARAM) {
    this.aten_dias_consulta_retroativa = PARAM;
  }

}
