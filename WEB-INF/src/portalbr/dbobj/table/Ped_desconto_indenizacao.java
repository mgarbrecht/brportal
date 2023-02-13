package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ped_desconto_indenizacao
  * @version 22/11/2016 15:20:25
  */
public class Ped_desconto_indenizacao implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer ped_nmro;
  private java.lang.Integer tipo_desconto;
  private java.lang.String ped_obse;
  private java.lang.Double valor_desconto;
  private java.lang.Double percentual_desc;
  private java.lang.Integer cnd_cdgo;
  private java.lang.String situacao;
  private java.lang.Integer cnd_cdgo_ped;
  private java.lang.Integer prazo_adicional;
  private java.lang.String usuario_criacao;
  private java.sql.Timestamp data_criacao;

  public Ped_desconto_indenizacao() {
  }

  public java.lang.Integer getPed_nmro() {
    return ped_nmro;
  }

  public void setPed_nmro(java.lang.Integer PARAM) {
    this.ped_nmro = PARAM;
  }

  public java.lang.Integer getTipo_desconto() {
    return tipo_desconto;
  }

  public void setTipo_desconto(java.lang.Integer PARAM) {
    this.tipo_desconto = PARAM;
  }

  public java.lang.String getPed_obse() {
    return ped_obse;
  }

  public void setPed_obse(java.lang.String PARAM) {
    this.ped_obse = PARAM;
  }

  public java.lang.Double getValor_desconto() {
    return valor_desconto;
  }

  public void setValor_desconto(java.lang.Double PARAM) {
    this.valor_desconto = PARAM;
  }

  public java.lang.Double getPercentual_desc() {
    return percentual_desc;
  }

  public void setPercentual_desc(java.lang.Double PARAM) {
    this.percentual_desc = PARAM;
  }

  public java.lang.Integer getCnd_cdgo() {
    return cnd_cdgo;
  }

  public void setCnd_cdgo(java.lang.Integer PARAM) {
    this.cnd_cdgo = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.lang.Integer getCnd_cdgo_ped() {
    return cnd_cdgo_ped;
  }

  public void setCnd_cdgo_ped(java.lang.Integer PARAM) {
    this.cnd_cdgo_ped = PARAM;
  }

  public java.lang.Integer getPrazo_adicional() {
    return prazo_adicional;
  }

  public void setPrazo_adicional(java.lang.Integer PARAM) {
    this.prazo_adicional = PARAM;
  }

  public java.lang.String getUsuario_criacao() {
    return usuario_criacao;
  }

  public void setUsuario_criacao(java.lang.String PARAM) {
    this.usuario_criacao = PARAM;
  }

  public java.sql.Timestamp getData_criacao() {
    return data_criacao;
  }

  public void setData_criacao(java.sql.Timestamp PARAM) {
    this.data_criacao = PARAM;
  }

}
