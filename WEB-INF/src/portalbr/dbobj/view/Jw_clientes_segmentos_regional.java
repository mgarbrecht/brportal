package portalbr.dbobj.view;

/** DataBase Object from table .Jw_clientes_segmentos_regional
  * @version 03/04/2013 09:42:37
  */
public class Jw_clientes_segmentos_regional implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_regional;
  private java.lang.String nome;
  private java.lang.String situacao;
  private int pequenos;
  private int medios;
  private int grandes;
  private int todos;

  public Jw_clientes_segmentos_regional() {
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public int getPequenos() {
    return pequenos;
  }

  public void setPequenos(int PARAM) {
    this.pequenos = PARAM;
  }

  public int getMedios() {
    return medios;
  }

  public void setMedios(int PARAM) {
    this.medios = PARAM;
  }

  public int getGrandes() {
    return grandes;
  }

  public void setGrandes(int PARAM) {
    this.grandes = PARAM;
  }

  public int getTodos() {
    return todos;
  }

  public void setTodos(int PARAM) {
    this.todos = PARAM;
  }

}
