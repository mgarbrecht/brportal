package portalbr.dbobj.view;

/** DataBase Object from table .Jw_categorias
  * @version 03/04/2013 09:50:17
  */
public class Jw_categorias implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_grupo;
  private java.lang.String descricao;
  private java.lang.Integer numero;

  public Jw_categorias() {
  }

  public java.lang.Integer getCodigo_grupo() {
    return codigo_grupo;
  }

  public void setCodigo_grupo(java.lang.Integer PARAM) {
    this.codigo_grupo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getNumero() {
    return numero;
  }

  public void setNumero(java.lang.Integer PARAM) {
    this.numero = PARAM;
  }

}
