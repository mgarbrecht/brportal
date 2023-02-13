package portalbr.dbobj.view;

/** DataBase Object from table .Jw_tipo_produto
  * @version 05/07/2010 07:08:15
  */
public class Jw_tipo_produto implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String descricao_grupo;
  private int codigo_grupo;

  public Jw_tipo_produto() {
  }

  public java.lang.String getDescricao_grupo() {
    return descricao_grupo;
  }

  public void setDescricao_grupo(java.lang.String PARAM) {
    this.descricao_grupo = PARAM;
  }

  public int getCodigo_grupo() {
    return codigo_grupo;
  }

  public void setCodigo_grupo(int PARAM) {
    this.codigo_grupo = PARAM;
  }

}
