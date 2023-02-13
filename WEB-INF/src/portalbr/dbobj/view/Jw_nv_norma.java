package portalbr.dbobj.view;

/** DataBase Object from table .Jw_nv_norma
  * @version 03/04/2013 09:20:30
  */
public class Jw_nv_norma implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.Integer id_norma_venda;
  private java.lang.Integer codigo_marca;
  private java.lang.String descricao_marca;
  private java.lang.String submarca_cdgo;
  private java.lang.Integer lin_cdgo;
  private java.lang.Integer item_id;
  private java.lang.String desc_item;
  private java.lang.Integer id_material;
  private java.lang.String material;

  public Jw_nv_norma() {
  }

  public java.lang.Integer getId_norma_venda() {
    return id_norma_venda;
  }

  public void setId_norma_venda(java.lang.Integer PARAM) {
    this.id_norma_venda = PARAM;
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

  public java.lang.String getSubmarca_cdgo() {
    return submarca_cdgo;
  }

  public void setSubmarca_cdgo(java.lang.String PARAM) {
    this.submarca_cdgo = PARAM;
  }

  public java.lang.Integer getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Integer PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.Integer getItem_id() {
    return item_id;
  }

  public void setItem_id(java.lang.Integer PARAM) {
    this.item_id = PARAM;
  }

  public java.lang.String getDesc_item() {
    return desc_item;
  }

  public void setDesc_item(java.lang.String PARAM) {
    this.desc_item = PARAM;
  }

  public java.lang.Integer getId_material() {
    return id_material;
  }

  public void setId_material(java.lang.Integer PARAM) {
    this.id_material = PARAM;
  }

  public java.lang.String getMaterial() {
    return material;
  }

  public void setMaterial(java.lang.String PARAM) {
    this.material = PARAM;
  }

}
