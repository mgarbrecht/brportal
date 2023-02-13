package portalbr.dbobj.table;

/** DataBase Object from table CPR.Processo_fab
  * @version 05/07/2010 07:00:04
  */
public class Processo_fab implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer pro_numero;
  private java.lang.String pro_tipo;
  private java.lang.String pro_nome;
  private java.lang.String unm_cdgo;
  private java.lang.Integer codigo_ncm;
  private java.lang.String conserto;

  public Processo_fab() {
  }

  public java.lang.Integer getPro_numero() {
    return pro_numero;
  }

  public void setPro_numero(java.lang.Integer PARAM) {
    this.pro_numero = PARAM;
  }

  public java.lang.String getPro_tipo() {
    return pro_tipo;
  }

  public void setPro_tipo(java.lang.String PARAM) {
    this.pro_tipo = PARAM;
  }

  public java.lang.String getPro_nome() {
    return pro_nome;
  }

  public void setPro_nome(java.lang.String PARAM) {
    this.pro_nome = PARAM;
  }

  public java.lang.String getUnm_cdgo() {
    return unm_cdgo;
  }

  public void setUnm_cdgo(java.lang.String PARAM) {
    this.unm_cdgo = PARAM;
  }

  public java.lang.Integer getCodigo_ncm() {
    return codigo_ncm;
  }

  public void setCodigo_ncm(java.lang.Integer PARAM) {
    this.codigo_ncm = PARAM;
  }

  public java.lang.String getConserto() {
    return conserto;
  }

  public void setConserto(java.lang.String PARAM) {
    this.conserto = PARAM;
  }

}
