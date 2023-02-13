package portalbr.dbobj.view;

/** DataBase Object from table .Jw_necessidade_materiais_pp
  * @version 15/03/2019 15:00:54
  */
public class Jw_necessidade_materiais_pp implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer material;
  private java.lang.String descricao;
  private java.lang.Integer cor;
  private java.lang.String descricao_cor;
  private java.lang.Integer tamanho;
  private java.lang.Integer consumo;
  private java.lang.String unidade_medida;

  public Jw_necessidade_materiais_pp() {
  }

  public java.lang.Integer getMaterial() {
    return material;
  }

  public void setMaterial(java.lang.Integer PARAM) {
    this.material = PARAM;
  }

  public java.lang.String getDescricao() {
    return descricao;
  }

  public void setDescricao(java.lang.String PARAM) {
    this.descricao = PARAM;
  }

  public java.lang.Integer getCor() {
    return cor;
  }

  public void setCor(java.lang.Integer PARAM) {
    this.cor = PARAM;
  }

  public java.lang.String getDescricao_cor() {
    return descricao_cor;
  }

  public void setDescricao_cor(java.lang.String PARAM) {
    this.descricao_cor = PARAM;
  }

  public java.lang.Integer getTamanho() {
    return tamanho;
  }

  public void setTamanho(java.lang.Integer PARAM) {
    this.tamanho = PARAM;
  }

  public java.lang.Integer getConsumo() {
    return consumo;
  }

  public void setConsumo(java.lang.Integer PARAM) {
    this.consumo = PARAM;
  }

  public java.lang.String getUnidade_medida() {
    return unidade_medida;
  }

  public void setUnidade_medida(java.lang.String PARAM) {
    this.unidade_medida = PARAM;
  }

}
