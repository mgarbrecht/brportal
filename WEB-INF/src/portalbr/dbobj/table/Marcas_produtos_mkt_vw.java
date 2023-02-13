package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Marcas_produtos_mkt_vw
  * @version 12/01/2011 08:34:31
  */
public class Marcas_produtos_mkt_vw implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer codigo_marca;
  private java.lang.String descricao_marca;

  public Marcas_produtos_mkt_vw() {
  }

  public java.lang.Integer getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(java.lang.Integer PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

}
