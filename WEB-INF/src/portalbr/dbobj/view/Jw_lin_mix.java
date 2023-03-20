package portalbr.dbobj.view;

/** DataBase Object from table .Jw_lin_mix
  * @version 08/03/2023 15:17:38
  */
public class Jw_lin_mix implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer lin_cdgo;
  private java.lang.String lin_nome;
  private java.lang.String mix;
  private java.lang.String descricao_mix;
  private java.lang.Integer ref_grupo_posicao_fab;

  public Jw_lin_mix() {
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
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

  public java.lang.Integer getRef_grupo_posicao_fab() {
    return ref_grupo_posicao_fab;
  }

  public void setRef_grupo_posicao_fab(java.lang.Integer PARAM) {
    this.ref_grupo_posicao_fab = PARAM;
  }

}
