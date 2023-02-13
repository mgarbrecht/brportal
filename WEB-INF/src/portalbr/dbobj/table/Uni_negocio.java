package portalbr.dbobj.table;

/** DataBase Object from table TCONTAB.Uni_negocio
  * @version 03/04/2013 09:06:20
  */
public class Uni_negocio implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.String unn_codigo;
  private java.lang.String unn_descri;
  private java.lang.String situacao;

  public Uni_negocio() {
  }

  public java.lang.String getUnn_codigo() {
    return unn_codigo;
  }

  public void setUnn_codigo(java.lang.String PARAM) {
    this.unn_codigo = PARAM;
  }

  public java.lang.String getUnn_descri() {
    return unn_descri;
  }

  public void setUnn_descri(java.lang.String PARAM) {
    this.unn_descri = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

}
