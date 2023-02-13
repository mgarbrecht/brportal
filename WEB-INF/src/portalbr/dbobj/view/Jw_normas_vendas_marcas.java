package portalbr.dbobj.view;

/** DataBase Object from table .Jw_normas_vendas_marcas
  * @version 08/05/2009 09:10:54
  */
public class Jw_normas_vendas_marcas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_marca;
  private java.lang.String descricao_marca;

  public Jw_normas_vendas_marcas() {
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

}
