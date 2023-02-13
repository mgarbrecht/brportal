package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Pecas
  * @version 20/12/2010 11:01:43
  */
public class Pecas implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo;
  private java.lang.String descricao;
  private java.lang.Double conver;
  private java.lang.Integer cmp_cdgo;
  private java.lang.String grupo_sola;
  private java.lang.String set_cdgo;

  public Pecas() {
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

  public java.lang.Double getConver() {
    return conver;
  }

  public void setConver(java.lang.Double PARAM) {
    this.conver = PARAM;
  }

  public java.lang.Integer getCmp_cdgo() {
    return cmp_cdgo;
  }

  public void setCmp_cdgo(java.lang.Integer PARAM) {
    this.cmp_cdgo = PARAM;
  }

  public java.lang.String getGrupo_sola() {
    return grupo_sola;
  }

  public void setGrupo_sola(java.lang.String PARAM) {
    this.grupo_sola = PARAM;
  }

  public java.lang.String getSet_cdgo() {
    return set_cdgo;
  }

  public void setSet_cdgo(java.lang.String PARAM) {
    this.set_cdgo = PARAM;
  }

}
