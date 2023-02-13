package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipos_usuarios
  * @version 07/02/2014 09:30:09
  */
public class Jw_tipos_usuarios implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String codigo;
  private java.lang.String descricao;
  private int tipo;

  public Jw_tipos_usuarios() {
  }

  public java.lang.String getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.String PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int PARAM) {
    this.tipo = PARAM;
  }

}
