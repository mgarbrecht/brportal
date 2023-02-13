package portalbr.dbobj.view;

/** DataBase Object from table .Jw_saldo_estoque_grade_tipo_estoque
  * @version 22/06/2015 10:34:11
  */
public class Jw_saldo_estoque_grade_tipo_estoque implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo;
  private java.lang.String descricao;

  public Jw_saldo_estoque_grade_tipo_estoque() {
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
