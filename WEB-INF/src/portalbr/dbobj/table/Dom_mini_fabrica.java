package portalbr.dbobj.table;

/** DataBase Object from table EST.Dom_mini_fabrica
  * @version 27/05/2014 11:12:55
  */
public class Dom_mini_fabrica implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo;
  private java.lang.String descricao;

  public Dom_mini_fabrica() {
  }

  public java.lang.Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(java.lang.Integer PARAM) {
    this.codigo = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

}
