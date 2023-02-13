package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipoestoque
  * @version 05/07/2010 07:08:04
  */
public class Jw_tipoestoque implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo;
  private java.lang.String descricao;

  public Jw_tipoestoque() {
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
