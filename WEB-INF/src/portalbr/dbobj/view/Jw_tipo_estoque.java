package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipo_estoque
  * @version 19/09/2014 12:01:37
  */
public class Jw_tipo_estoque implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo;
  private java.lang.String descricao;

  public Jw_tipo_estoque() {
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

}
