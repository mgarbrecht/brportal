package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Componente_detalhe
  * @version 03/04/2013 10:01:30
  */
public class Componente_detalhe implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer cmp_cdgo;
  private java.lang.String cmp_desc;
  private java.lang.String imprime_talao;

  public Componente_detalhe() {
  }

  public java.lang.Integer getCmp_cdgo() {
    return cmp_cdgo;
  }

  public void setCmp_cdgo(java.lang.Integer PARAM) {
    this.cmp_cdgo = PARAM;
  }

  public java.lang.String getCmp_desc() {
    return cmp_desc;
  }

  public void setCmp_desc(java.lang.String PARAM) {
    this.cmp_desc = PARAM;
  }

  public java.lang.String getImprime_talao() {
    return imprime_talao;
  }

  public void setImprime_talao(java.lang.String PARAM) {
    this.imprime_talao = PARAM;
  }

}
