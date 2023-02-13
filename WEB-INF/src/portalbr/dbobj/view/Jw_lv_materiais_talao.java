package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lv_materiais_talao
  * @version 20/01/2016 12:30:01
  */
public class Jw_lv_materiais_talao implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String ies_codigo;
  private java.lang.String ies_descricao;

  public Jw_lv_materiais_talao() {
  }

  public java.lang.String getIes_codigo() {
    return ies_codigo;
  }

  public void setIes_codigo(java.lang.String PARAM) {
    this.ies_codigo = PARAM;
  }

  public java.lang.String getIes_descricao() {
    return ies_descricao;
  }

  public void setIes_descricao(java.lang.String PARAM) {
    this.ies_descricao = PARAM;
  }

}
