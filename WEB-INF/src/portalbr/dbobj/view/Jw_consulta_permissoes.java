package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_permissoes
  * @version 03/04/2013 09:32:42
  */
public class Jw_consulta_permissoes implements java.io.Serializable, com.egen.util.jdbc.View {
  private int doin_id;
  private java.lang.String doin_nome;
  private java.lang.String doin_descricao;
  private int dias_consulta_retroativa;

  public Jw_consulta_permissoes() {
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

  public int getDias_consulta_retroativa() {
    return dias_consulta_retroativa;
  }

  public void setDias_consulta_retroativa(int PARAM) {
    this.dias_consulta_retroativa = PARAM;
  }

}
