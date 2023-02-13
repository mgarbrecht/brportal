package portalbr.dbobj.view;

/** DataBase Object from table .Jw_listas_selecionadas
  * @version 03/04/2013 09:25:26
  */
public class Jw_listas_selecionadas implements java.io.Serializable, com.egen.util.jdbc.View {
  private int id_lista;
  private java.lang.String nome_lista;
  private java.lang.String selecionado;

  public Jw_listas_selecionadas() {
  }

  public int getId_lista() {
    return id_lista;
  }

  public void setId_lista(int PARAM) {
    this.id_lista = PARAM;
  }

  public java.lang.String getNome_lista() {
    return nome_lista;
  }

  public void setNome_lista(java.lang.String PARAM) {
    this.nome_lista = PARAM;
  }

  public java.lang.String getSelecionado() {
    return selecionado;
  }

  public void setSelecionado(java.lang.String PARAM) {
    this.selecionado = PARAM;
  }

}
