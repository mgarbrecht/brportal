package portalbr.dbobj.view;

/** DataBase Object from table .Jw_despachante
  * @version 22/08/2017 11:14:05
  */
public class Jw_despachante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_pessoa;
  private java.lang.String nome_pessoa;

  public Jw_despachante() {
  }

  public java.lang.Integer getCodigo_pessoa() {
    return codigo_pessoa;
  }

  public void setCodigo_pessoa(java.lang.Integer PARAM) {
    this.codigo_pessoa = PARAM;
  }

  public java.lang.String getNome_pessoa() {
    return nome_pessoa;
  }

  public void setNome_pessoa(java.lang.String PARAM) {
    this.nome_pessoa = PARAM;
  }

}
