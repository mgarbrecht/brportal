package portalbr.dbobj.view;

/** DataBase Object from table .Jw_cid_atend_reg
  * @version 16/05/2014 08:36:45
  */
public class Jw_cid_atend_reg implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_regional;
  private java.lang.String cidade;

  public Jw_cid_atend_reg() {
  }

  public java.lang.Integer getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.Integer PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getCidade() {
    return cidade;
  }

  public void setCidade(java.lang.String PARAM) {
    this.cidade = PARAM;
  }

}
