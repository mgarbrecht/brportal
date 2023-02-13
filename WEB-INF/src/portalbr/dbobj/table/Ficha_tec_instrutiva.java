package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Ficha_tec_instrutiva
  * @version 03/04/2013 09:57:03
  */
public class Ficha_tec_instrutiva implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Double id_nro;
  private java.sql.Date data;
  private java.lang.String projeto_cdgo;
  private java.lang.String fma_cdgo;
  private java.lang.String base;
  private java.lang.Integer codigo_colecao;
  private java.lang.Double gde_cdgo;
  private java.lang.Double lin_cdgo;
  private java.lang.String projeto_desc;
  private java.lang.String forma_desc;
  private java.lang.String grade_desc;
  private java.lang.String linha_desc;
  private java.lang.Double ref_cdgo;
  private java.lang.String ref_desc;
  private java.lang.String padrao;
  private java.lang.String codigo_desc;
  private java.lang.Double cod_mini_fab;
  private java.lang.String cod_mini_fab_desc;
  private java.lang.String tecnico_resp;
  private java.lang.String tecnico_pre;
  private java.sql.Date data_entrega_amostra;
  private java.sql.Date dthr_inclusao;
  private java.sql.Date dthr_alteracao;
  private java.lang.String usuario_inclusao;
  private java.lang.String usuario_alteracao;
  private java.lang.String status;

  public Ficha_tec_instrutiva() {
  }

  public java.lang.Double getId_nro() {
    return id_nro;
  }

  public void setId_nro(java.lang.Double PARAM) {
    this.id_nro = PARAM;
  }

  public java.sql.Date getData() {
    return data;
  }

  public void setData(java.sql.Date PARAM) {
    this.data = PARAM;
  }

  public java.lang.String getProjeto_cdgo() {
    return projeto_cdgo;
  }

  public void setProjeto_cdgo(java.lang.String PARAM) {
    this.projeto_cdgo = PARAM;
  }

  public java.lang.String getFma_cdgo() {
    return fma_cdgo;
  }

  public void setFma_cdgo(java.lang.String PARAM) {
    this.fma_cdgo = PARAM;
  }

  public java.lang.String getBase() {
    return base;
  }

  public void setBase(java.lang.String PARAM) {
    this.base = PARAM;
  }

  public java.lang.Integer getCodigo_colecao() {
    return codigo_colecao;
  }

  public void setCodigo_colecao(java.lang.Integer PARAM) {
    this.codigo_colecao = PARAM;
  }

  public java.lang.Double getGde_cdgo() {
    return gde_cdgo;
  }

  public void setGde_cdgo(java.lang.Double PARAM) {
    this.gde_cdgo = PARAM;
  }

  public java.lang.Double getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(java.lang.Double PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getProjeto_desc() {
    return projeto_desc;
  }

  public void setProjeto_desc(java.lang.String PARAM) {
    this.projeto_desc = PARAM;
  }

  public java.lang.String getForma_desc() {
    return forma_desc;
  }

  public void setForma_desc(java.lang.String PARAM) {
    this.forma_desc = PARAM;
  }

  public java.lang.String getGrade_desc() {
    return grade_desc;
  }

  public void setGrade_desc(java.lang.String PARAM) {
    this.grade_desc = PARAM;
  }

  public java.lang.String getLinha_desc() {
    return linha_desc;
  }

  public void setLinha_desc(java.lang.String PARAM) {
    this.linha_desc = PARAM;
  }

  public java.lang.Double getRef_cdgo() {
    return ref_cdgo;
  }

  public void setRef_cdgo(java.lang.Double PARAM) {
    this.ref_cdgo = PARAM;
  }

  public java.lang.String getRef_desc() {
    return ref_desc;
  }

  public void setRef_desc(java.lang.String PARAM) {
    this.ref_desc = PARAM;
  }

  public java.lang.String getPadrao() {
    return padrao;
  }

  public void setPadrao(java.lang.String PARAM) {
    this.padrao = PARAM;
  }

  public java.lang.String getCodigo_desc() {
    return codigo_desc;
  }

  public void setCodigo_desc(java.lang.String PARAM) {
    this.codigo_desc = PARAM;
  }

  public java.lang.Double getCod_mini_fab() {
    return cod_mini_fab;
  }

  public void setCod_mini_fab(java.lang.Double PARAM) {
    this.cod_mini_fab = PARAM;
  }

  public java.lang.String getCod_mini_fab_desc() {
    return cod_mini_fab_desc;
  }

  public void setCod_mini_fab_desc(java.lang.String PARAM) {
    this.cod_mini_fab_desc = PARAM;
  }

  public java.lang.String getTecnico_resp() {
    return tecnico_resp;
  }

  public void setTecnico_resp(java.lang.String PARAM) {
    this.tecnico_resp = PARAM;
  }

  public java.lang.String getTecnico_pre() {
    return tecnico_pre;
  }

  public void setTecnico_pre(java.lang.String PARAM) {
    this.tecnico_pre = PARAM;
  }

  public java.sql.Date getData_entrega_amostra() {
    return data_entrega_amostra;
  }

  public void setData_entrega_amostra(java.sql.Date PARAM) {
    this.data_entrega_amostra = PARAM;
  }

  public java.sql.Date getDthr_inclusao() {
    return dthr_inclusao;
  }

  public void setDthr_inclusao(java.sql.Date PARAM) {
    this.dthr_inclusao = PARAM;
  }

  public java.sql.Date getDthr_alteracao() {
    return dthr_alteracao;
  }

  public void setDthr_alteracao(java.sql.Date PARAM) {
    this.dthr_alteracao = PARAM;
  }

  public java.lang.String getUsuario_inclusao() {
    return usuario_inclusao;
  }

  public void setUsuario_inclusao(java.lang.String PARAM) {
    this.usuario_inclusao = PARAM;
  }

  public java.lang.String getUsuario_alteracao() {
    return usuario_alteracao;
  }

  public void setUsuario_alteracao(java.lang.String PARAM) {
    this.usuario_alteracao = PARAM;
  }

  public java.lang.String getStatus() {
    return status;
  }

  public void setStatus(java.lang.String PARAM) {
    this.status = PARAM;
  }

}
