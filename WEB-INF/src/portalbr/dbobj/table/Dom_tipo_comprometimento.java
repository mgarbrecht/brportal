package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_tipo_comprometimento
  * @version 03/04/2013 09:59:39
  */
public class Dom_tipo_comprometimento implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int codigo;
  private java.lang.String descricao;
  private java.lang.String tipo_empenhavel;

  public Dom_tipo_comprometimento() {
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

  public java.lang.String getTipo_empenhavel() {
    return tipo_empenhavel;
  }

  public void setTipo_empenhavel(java.lang.String PARAM) {
    this.tipo_empenhavel = PARAM;
  }

}
