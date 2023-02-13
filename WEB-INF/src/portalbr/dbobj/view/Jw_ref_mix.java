package portalbr.dbobj.view;

/** DataBase Object from table .Jw_ref_mix
  * @version 19/10/2022 14:55:14
  */
public class Jw_ref_mix implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer ref_cdgo;
  private java.lang.Integer codigo_marca;
  private java.lang.String descricao_marca;
  private java.lang.String mix;
  private java.lang.String descricao_mix;

  public Jw_ref_mix() {
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Integer PARAM) {
    this.ref_cdgo = PARAM;
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

  public java.lang.String getMix() {
    return mix;
  }

  public void setMix(java.lang.String PARAM) {
    this.mix = PARAM;
  }

  public java.lang.String getDescricao_mix() {
    return descricao_mix;
  }

  public void setDescricao_mix(java.lang.String PARAM) {
    this.descricao_mix = PARAM;
  }

}
