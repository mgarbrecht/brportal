package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ficha_tec_instrutiva_itens
  * @version 03/04/2013 09:56:54
  */
public class Ficha_tec_instrutiva_itens implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Double id_nro;
  private java.lang.Double id_nro_seq;
  private java.lang.Double cmp_cdgo;
  private java.lang.String cmp_desc;
  private java.lang.Double codigo_peca;
  private java.lang.String descricao_peca;
  private java.lang.Double mat_nro;
  private java.lang.String mat_nro_desc;
  private java.lang.Double cor_cdgo;
  private java.lang.String cor_desc;
  private java.lang.Integer cod_peca;
  private java.lang.String status;

  public Ficha_tec_instrutiva_itens() {
  }

  public java.lang.Double getId_nro() {
    return id_nro;
  }

  public void setId_nro(java.lang.Double PARAM) {
    this.id_nro = PARAM;
  }

  public java.lang.Double getId_nro_seq() {
    return id_nro_seq;
  }

  public void setId_nro_seq(java.lang.Double PARAM) {
    this.id_nro_seq = PARAM;
  }

  public java.lang.Double getCmp_cdgo() {
    return cmp_cdgo;
  }

  public void setCmp_cdgo(java.lang.Double PARAM) {
    this.cmp_cdgo = PARAM;
  }

  public java.lang.String getCmp_desc() {
    return cmp_desc;
  }

  public void setCmp_desc(java.lang.String PARAM) {
    this.cmp_desc = PARAM;
  }

  public java.lang.Double getCodigo_peca() {
    return codigo_peca;
  }

  public void setCodigo_peca(java.lang.Double PARAM) {
    this.codigo_peca = PARAM;
  }

  public java.lang.String getDescricao_peca() {
    return descricao_peca;
  }

  public void setDescricao_peca(java.lang.String PARAM) {
    this.descricao_peca = PARAM;
  }

  public java.lang.Double getMat_nro() {
    return mat_nro;
  }

  public void setMat_nro(java.lang.Double PARAM) {
    this.mat_nro = PARAM;
  }

  public java.lang.String getMat_nro_desc() {
    return mat_nro_desc;
  }

  public void setMat_nro_desc(java.lang.String PARAM) {
    this.mat_nro_desc = PARAM;
  }

  public java.lang.Double getCor_cdgo() {
    return cor_cdgo;
  }

  public void setCor_cdgo(java.lang.Double PARAM) {
    this.cor_cdgo = PARAM;
  }

  public java.lang.String getCor_desc() {
    return cor_desc;
  }

  public void setCor_desc(java.lang.String PARAM) {
    this.cor_desc = PARAM;
  }

  public java.lang.Integer getCod_peca() {
    return cod_peca;
  }

  public void setCod_peca(java.lang.Integer PARAM) {
    this.cod_peca = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

}
