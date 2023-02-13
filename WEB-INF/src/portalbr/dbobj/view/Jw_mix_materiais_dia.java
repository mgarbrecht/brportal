package portalbr.dbobj.view;

/** DataBase Object from table .Jw_mix_materiais_dia
  * @version 01/11/2022 13:54:26
  */
public class Jw_mix_materiais_dia implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer codigo_material;
  private java.lang.String descricao_material;
  private java.lang.Integer codigo_marca;
  private java.lang.String descricao_marca;

  public Jw_mix_materiais_dia() {
  }

  public java.lang.Integer getCodigo_material() {
    return codigo_material;
  }

  public void setCodigo_material(java.lang.Integer PARAM) {
    this.codigo_material = PARAM;
  }

  public java.lang.String getDescricao_material() {
    return descricao_material;
  }

  public void setDescricao_material(java.lang.String PARAM) {
    this.descricao_material = PARAM;
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
