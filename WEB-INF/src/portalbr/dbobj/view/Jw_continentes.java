package portalbr.dbobj.view;

/** DataBase Object from table .Jw_continentes
  * @version 14/09/2018 17:14:56
  */
public class Jw_continentes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String con_codigo;
  private java.lang.String con_descricao;

  public Jw_continentes() {
  }

  public java.lang.String getCon_codigo() {
    return con_codigo;
  }

  public void setCon_codigo(java.lang.String PARAM) {
    this.con_codigo = PARAM;
  }

  public java.lang.String getCon_descricao() {
    return con_descricao;
  }

  public void setCon_descricao(java.lang.String PARAM) {
    this.con_descricao = PARAM;
  }

}
