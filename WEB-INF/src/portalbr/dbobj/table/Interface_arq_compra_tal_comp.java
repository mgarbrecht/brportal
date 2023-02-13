package portalbr.dbobj.table;

/** DataBase Object from table EDI.Interface_arq_compra_tal_comp
  * @version 17/09/2015 08:50:34
  */
public class Interface_arq_compra_tal_comp implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer interface_arq_compra_id;
  private java.lang.Integer rem_nro;
  private java.lang.Integer tal_nro;
  private java.lang.Long ies_codigo;
  private java.lang.Integer cor_material;
  private java.lang.Integer comp_cdgo;
  private java.lang.String comp_desc;
  private java.lang.Integer cor_comp;
  private java.lang.String cor_comp_desc;
  private java.lang.Double consumo;
  private java.lang.String usuario_inclusao;
  private java.sql.Timestamp dthr_inclusao;
  private java.lang.String usuario_alteracao;
  private java.sql.Timestamp dthr_alteracao;

  public Interface_arq_compra_tal_comp() {
  }

  public java.lang.Integer getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }

  public void setInterface_arq_compra_id(java.lang.Integer PARAM) {
    this.interface_arq_compra_id = PARAM;
  }

  public java.lang.Integer getRem_nro() {
    return rem_nro;
  }

  public void setRem_nro(java.lang.Integer PARAM) {
    this.rem_nro = PARAM;
  }

  public java.lang.Integer getTal_nro() {
    return tal_nro;
  }

  public void setTal_nro(java.lang.Integer PARAM) {
    this.tal_nro = PARAM;
  }

  public java.lang.Long getIes_codigo() {
    return ies_codigo;
  }

  public void setIes_codigo(java.lang.Long PARAM) {
    this.ies_codigo = PARAM;
  }

  public java.lang.Integer getCor_material() {
    return cor_material;
  }

  public void setCor_material(java.lang.Integer PARAM) {
    this.cor_material = PARAM;
  }

  public java.lang.Integer getComp_cdgo() {
    return comp_cdgo;
  }

  public void setComp_cdgo(java.lang.Integer PARAM) {
    this.comp_cdgo = PARAM;
  }

  public java.lang.String getComp_desc() {
    return comp_desc;
  }

  public void setComp_desc(java.lang.String PARAM) {
    this.comp_desc = PARAM;
  }

  public java.lang.Integer getCor_comp() {
    return cor_comp;
  }

  public void setCor_comp(java.lang.Integer PARAM) {
    this.cor_comp = PARAM;
  }

  public java.lang.String getCor_comp_desc() {
    return cor_comp_desc;
  }

  public void setCor_comp_desc(java.lang.String PARAM) {
    this.cor_comp_desc = PARAM;
  }

  public java.lang.Double getConsumo() {
    return consumo;
  }

  public void setConsumo(java.lang.Double PARAM) {
    this.consumo = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.sql.Timestamp getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Timestamp PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.sql.Timestamp getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Timestamp PARAM) {
    this.dthr_alteracao = PARAM;
  }

}
