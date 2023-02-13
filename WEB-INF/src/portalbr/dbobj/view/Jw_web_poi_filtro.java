package portalbr.dbobj.view;

/** DataBase Object from table .Jw_web_poi_filtro
  * @version 17/10/2012 16:07:53
  */
public class Jw_web_poi_filtro implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String lin_ref;
  private java.lang.Integer linha;
  private java.lang.String ref_codigo;
  private java.lang.String lin_nome;
  private java.lang.Integer mes;
  private java.lang.Integer ano;
  private java.lang.Integer periodos;

  public Jw_web_poi_filtro() {
  }

  public java.lang.String getLin_ref() {
    return lin_ref;
  }

  public void setLin_ref(java.lang.String PARAM) {
    this.lin_ref = PARAM;
  }

  public java.lang.Integer getLinha() {
    return linha;
  }

  public void setLinha(java.lang.Integer PARAM) {
    this.linha = PARAM;
  }

  public java.lang.String getRef_codigo() {
    return ref_codigo;
  }

  public void setRef_codigo(java.lang.String PARAM) {
    this.ref_codigo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.lang.Integer getMes() {
    return mes;
  }

  public void setMes(java.lang.Integer PARAM) {
    this.mes = PARAM;
  }

  public java.lang.Integer getAno() {
    return ano;
  }

  public void setAno(java.lang.Integer PARAM) {
    this.ano = PARAM;
  }

  public java.lang.Integer getPeriodos() {
    return periodos;
  }

  public void setPeriodos(java.lang.Integer PARAM) {
    this.periodos = PARAM;
  }

}
