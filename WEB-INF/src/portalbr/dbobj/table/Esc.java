package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Esc
  * @version 21/08/2013 11:17:35
  */
public class Esc implements java.io.Serializable, com.egen.util.jdbc.Table {
  private java.lang.Integer cli_cdgo;
  private java.lang.Integer esc_seqn;
  private java.lang.String reg_cdgo;
  private java.lang.String rep_cdgo;
  private java.lang.Double esc_icms;
  private java.lang.Integer esc_cgc;
  private java.lang.String esc_insm;
  private java.lang.String esc_inse;
  private java.lang.String esc_mald;
  private java.lang.String prt_codigo;
  private java.lang.Integer tra_cdgo;
  private java.lang.String esc_indic_prote;
  private java.lang.Integer esc_num_dias_prote;
  private java.lang.String rep_projetado;
  private java.lang.String emp_empresa;
  private java.lang.String esc_cli_tem_cd;
  private java.lang.String esc_situacao;
  private java.lang.String esc_observacao;
  private java.lang.Integer esc_ean;
  private java.lang.String est_unifed;
  private java.lang.String moe_codigo;
  private java.lang.Integer idio_codigo_idioma;
  private java.lang.String esc_email;
  private java.lang.Integer codigo_motivo;
  private java.lang.Integer tra_consig;
  private java.sql.Date data_primeira_compra;
  private java.lang.Double valor_primeira_compra;
  private java.sql.Date data_ultima_compra;
  private java.lang.Double valor_ultima_compra;
  private java.sql.Date data_ultima_alteracao;
  private java.sql.Date data_log_afv;
  private java.lang.Integer tra_cdgo_internar;

  public Esc() {
  }

  public java.lang.Integer getCli_cdgo() {
    return cli_cdgo;
  }

  public void setCli_cdgo(java.lang.Integer PARAM) {
    this.cli_cdgo = PARAM;
  }

  public java.lang.Integer getEsc_seqn() {
    return esc_seqn;
  }

  public void setEsc_seqn(java.lang.Integer PARAM) {
    this.esc_seqn = PARAM;
  }

  public java.lang.String getReg_cdgo() {
    return reg_cdgo;
  }

  public void setReg_cdgo(java.lang.String PARAM) {
    this.reg_cdgo = PARAM;
  }

  public java.lang.String getRep_cdgo() {
    return rep_cdgo;
  }

  public void setRep_cdgo(java.lang.String PARAM) {
    this.rep_cdgo = PARAM;
  }

  public java.lang.Double getEsc_icms() {
    return esc_icms;
  }

  public void setEsc_icms(java.lang.Double PARAM) {
    this.esc_icms = PARAM;
  }

  public java.lang.Integer getEsc_cgc() {
    return esc_cgc;
  }

  public void setEsc_cgc(java.lang.Integer PARAM) {
    this.esc_cgc = PARAM;
  }

  public java.lang.String getEsc_insm() {
    return esc_insm;
  }

  public void setEsc_insm(java.lang.String PARAM) {
    this.esc_insm = PARAM;
  }

  public java.lang.String getEsc_inse() {
    return esc_inse;
  }

  public void setEsc_inse(java.lang.String PARAM) {
    this.esc_inse = PARAM;
  }

  public java.lang.String getEsc_mald() {
    return esc_mald;
  }

  public void setEsc_mald(java.lang.String PARAM) {
    this.esc_mald = PARAM;
  }

  public java.lang.String getPrt_codigo() {
    return prt_codigo;
  }

  public void setPrt_codigo(java.lang.String PARAM) {
    this.prt_codigo = PARAM;
  }

  public java.lang.Integer getTra_cdgo() {
    return tra_cdgo;
  }

  public void setTra_cdgo(java.lang.Integer PARAM) {
    this.tra_cdgo = PARAM;
  }

  public java.lang.String getEsc_indic_prote() {
    return esc_indic_prote;
  }

  public void setEsc_indic_prote(java.lang.String PARAM) {
    this.esc_indic_prote = PARAM;
  }

  public java.lang.Integer getEsc_num_dias_prote() {
    return esc_num_dias_prote;
  }

  public void setEsc_num_dias_prote(java.lang.Integer PARAM) {
    this.esc_num_dias_prote = PARAM;
  }

  public java.lang.String getRep_projetado() {
    return rep_projetado;
  }

  public void setRep_projetado(java.lang.String PARAM) {
    this.rep_projetado = PARAM;
  }

  public java.lang.String getEmp_empresa() {
    return emp_empresa;
  }

  public void setEmp_empresa(java.lang.String PARAM) {
    this.emp_empresa = PARAM;
  }

  public java.lang.String getEsc_cli_tem_cd() {
    return esc_cli_tem_cd;
  }

  public void setEsc_cli_tem_cd(java.lang.String PARAM) {
    this.esc_cli_tem_cd = PARAM;
  }

  public java.lang.String getEsc_situacao() {
    return esc_situacao;
  }

  public void setEsc_situacao(java.lang.String PARAM) {
    this.esc_situacao = PARAM;
  }

  public java.lang.String getEsc_observacao() {
    return esc_observacao;
  }

  public void setEsc_observacao(java.lang.String PARAM) {
    this.esc_observacao = PARAM;
  }

  public java.lang.Integer getEsc_ean() {
    return esc_ean;
  }

  public void setEsc_ean(java.lang.Integer PARAM) {
    this.esc_ean = PARAM;
  }

  public java.lang.String getEst_unifed() {
    return est_unifed;
  }

  public void setEst_unifed(java.lang.String PARAM) {
    this.est_unifed = PARAM;
  }

  public java.lang.String getMoe_codigo() {
    return moe_codigo;
  }

  public void setMoe_codigo(java.lang.String PARAM) {
    this.moe_codigo = PARAM;
  }

  public java.lang.Integer getIdio_codigo_idioma() {
    return idio_codigo_idioma;
  }

  public void setIdio_codigo_idioma(java.lang.Integer PARAM) {
    this.idio_codigo_idioma = PARAM;
  }

  public java.lang.String getEsc_email() {
    return esc_email;
  }

  public void setEsc_email(java.lang.String PARAM) {
    this.esc_email = PARAM;
  }

  public java.lang.Integer getCodigo_motivo() {
    return codigo_motivo;
  }

  public void setCodigo_motivo(java.lang.Integer PARAM) {
    this.codigo_motivo = PARAM;
  }

  public java.lang.Integer getTra_consig() {
    return tra_consig;
  }

  public void setTra_consig(java.lang.Integer PARAM) {
    this.tra_consig = PARAM;
  }

  public java.sql.Date getData_primeira_compra() {
    return data_primeira_compra;
  }

  public void setData_primeira_compra(java.sql.Date PARAM) {
    this.data_primeira_compra = PARAM;
  }

  public java.lang.Double getValor_primeira_compra() {
    return valor_primeira_compra;
  }

  public void setValor_primeira_compra(java.lang.Double PARAM) {
    this.valor_primeira_compra = PARAM;
  }

  public java.sql.Date getData_ultima_compra() {
    return data_ultima_compra;
  }

  public void setData_ultima_compra(java.sql.Date PARAM) {
    this.data_ultima_compra = PARAM;
  }

  public java.lang.Double getValor_ultima_compra() {
    return valor_ultima_compra;
  }

  public void setValor_ultima_compra(java.lang.Double PARAM) {
    this.valor_ultima_compra = PARAM;
  }

  public java.sql.Date getData_ultima_alteracao() {
    return data_ultima_alteracao;
  }

  public void setData_ultima_alteracao(java.sql.Date PARAM) {
    this.data_ultima_alteracao = PARAM;
  }

  public java.sql.Date getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Date PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.lang.Integer getTra_cdgo_internar() {
    return tra_cdgo_internar;
  }

  public void setTra_cdgo_internar(java.lang.Integer PARAM) {
    this.tra_cdgo_internar = PARAM;
  }

}
