package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consumo_composicao_material
  * @version 14/08/2017 09:28:25
  */
public class Jw_consumo_composicao_material implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer mat_nro;
  private java.lang.String descricao;
  private java.lang.Integer ies_codigo;
  private java.lang.Integer cor_cdgo;

  public Jw_consumo_composicao_material() {
  }

  public java.lang.Integer getMat_nro() {
    return mat_nro;
  }

  public void setMat_nro(java.lang.Integer PARAM) {
    this.mat_nro = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getIes_codigo() {
    return ies_codigo;
  }

  public void setIes_codigo(java.lang.Integer PARAM) {
    this.ies_codigo = PARAM;
  }

  public java.lang.Integer getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Integer PARAM) {
    this.cor_cdgo = PARAM;
  }

}
