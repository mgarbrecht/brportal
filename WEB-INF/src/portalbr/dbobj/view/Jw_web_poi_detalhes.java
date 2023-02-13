package portalbr.dbobj.view;

/** DataBase Object from table .Jw_web_poi_detalhes
  * @version 05/07/2010 07:04:00
  */
public class Jw_web_poi_detalhes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String lin_nome;
  private java.lang.String fil;
  private java.lang.String pe;
  private java.lang.String dt;
  private java.lang.String dtf;
  private double capacidade;
  private double vendido;
  private java.lang.String situacao;
  private double bloq;

  public Jw_web_poi_detalhes() {
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public java.lang.String getFil() {
    return fil;
  }

  public void setFil(java.lang.String PARAM) {
    this.fil = PARAM;
  }

  public java.lang.String getPe() {
    return pe;
  }

  public void setPe(java.lang.String PARAM) {
    this.pe = PARAM;
  }

  public java.lang.String getDt() {
    return dt;
  }

  public void setDt(java.lang.String PARAM) {
    this.dt = PARAM;
  }

  public java.lang.String getDtf() {
    return dtf;
  }

  public void setDtf(java.lang.String PARAM) {
    this.dtf = PARAM;
  }

  public double getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(double PARAM) {
    this.capacidade = PARAM;
  }

  public double getVendido() {
    return vendido;
  }

  public void setVendido(double PARAM) {
    this.vendido = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public double getBloq() {
    return bloq;
  }

  public void setBloq(double PARAM) {
    this.bloq = PARAM;
  }

}
