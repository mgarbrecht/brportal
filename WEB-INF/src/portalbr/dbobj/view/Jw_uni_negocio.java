package portalbr.dbobj.view;

/** DataBase Object from table .Jw_uni_negocio
  * @version 05/07/2010 07:05:09
  */
public class Jw_uni_negocio implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo;
  private java.lang.String nome;

  public Jw_uni_negocio() {
  }

  public java.lang.String getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.String PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getNome() {
    return nome;
  }

  public void setNome(java.lang.String PARAM) {
    this.nome = PARAM;
  }

}
