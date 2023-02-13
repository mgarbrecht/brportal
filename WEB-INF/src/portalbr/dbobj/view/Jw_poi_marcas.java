package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_marcas
  * @version 03/04/2013 09:16:42
  */
public class Jw_poi_marcas implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String descr_marca;
  private java.lang.Integer cod_marca;

  public Jw_poi_marcas() {
  }

  public java.lang.String getDescr_marca() {
    return descr_marca;
  }

  public void setDescr_marca(java.lang.String PARAM) {
    this.descr_marca = PARAM;
  }

  public java.lang.Integer getCod_marca() {
    return cod_marca;
  }

  public void setCod_marca(java.lang.Integer PARAM) {
    this.cod_marca = PARAM;
  }

}
