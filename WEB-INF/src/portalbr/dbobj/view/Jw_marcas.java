package portalbr.dbobj.view;

/** DataBase Object from table .Jw_marcas
  * @version 14/08/2019 14:17:42
  */
public class Jw_marcas implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_marca;
  private java.lang.String descricao_marca;

  public Jw_marcas() {
  }

  public int getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(int PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

}
