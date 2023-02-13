package portalbr.dbobj.view;

/** DataBase Object from table .Jw_comprometimentos
  * @version 03/04/2013 09:41:32
  */
public class Jw_comprometimentos implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo;
  private java.lang.String descricao;

  public Jw_comprometimentos() {
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
