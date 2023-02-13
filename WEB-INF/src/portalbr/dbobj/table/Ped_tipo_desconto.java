package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_tipo_desconto
  * @version 15/03/2011 13:52:35
  */
public class Ped_tipo_desconto implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer tipo_cdgo;
  private java.lang.String descr_tipo;
  private java.lang.String situacao;

  public Ped_tipo_desconto() {
  }

  public java.lang.Integer getTipo_cdgo() {
    return tipo_cdgo;
  }

  public void setTipo_cdgo(java.lang.Integer PARAM) {
    this.tipo_cdgo = PARAM;
  }

  public java.lang.String getDescr_tipo() {
    return descr_tipo;
  }

  public void setDescr_tipo(java.lang.String PARAM) {
    this.descr_tipo = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

}
