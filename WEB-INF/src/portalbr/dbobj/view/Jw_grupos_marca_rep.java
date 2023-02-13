package portalbr.dbobj.view;

/** DataBase Object from table .Jw_grupos_marca_rep
  * @version 03/04/2013 09:26:59
  */
public class Jw_grupos_marca_rep implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String cod_marca;
  private java.lang.String marca;
  private java.lang.String cod_regional;
  private java.lang.String regional;
  private java.lang.String cod_rep;
  private java.lang.String rep;
  private java.lang.String grupos_ativos;

  public Jw_grupos_marca_rep() {
  }

  public java.lang.String getCod_marca() {
    return cod_marca;
  }

  public void setCod_marca(java.lang.String PARAM) {
    this.cod_marca = PARAM;
  }

  public java.lang.String getMarca() {
    return marca;
  }

  public void setMarca(java.lang.String PARAM) {
    this.marca = PARAM;
  }

  public java.lang.String getCod_regional() {
    return cod_regional;
  }

  public void setCod_regional(java.lang.String PARAM) {
    this.cod_regional = PARAM;
  }

  public java.lang.String getRegional() {
    return regional;
  }

  public void setRegional(java.lang.String PARAM) {
    this.regional = PARAM;
  }

  public java.lang.String getCod_rep() {
    return cod_rep;
  }

  public void setCod_rep(java.lang.String PARAM) {
    this.cod_rep = PARAM;
  }

  public java.lang.String getRep() {
    return rep;
  }

  public void setRep(java.lang.String PARAM) {
    this.rep = PARAM;
  }

  public java.lang.String getGrupos_ativos() {
    return grupos_ativos;
  }

  public void setGrupos_ativos(java.lang.String PARAM) {
    this.grupos_ativos = PARAM;
  }

}
