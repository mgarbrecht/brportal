package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pedido_regional_representante
  * @version 03/04/2013 09:19:44
  */
public class Jw_pedido_regional_representante implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String rep_cdgo;
  private java.lang.String codigo_regional;
  private java.lang.String ped_nmro;
  private java.lang.String ped_nped;
  private java.lang.String ped_sequencial_maquina;

  public Jw_pedido_regional_representante() {
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.String getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(java.lang.String PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.String PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.String getPed_nped() {
    return ped_nped;
  }

  public void setPed_nped(java.lang.String PARAM) {
    this.ped_nped = PARAM;
  }

  public java.lang.String getPed_sequencial_maquina() {
    return ped_sequencial_maquina;
  }

  public void setPed_sequencial_maquina(java.lang.String PARAM) {
    this.ped_sequencial_maquina = PARAM;
  }

}
