package portalbr.dbobj.table;

/** DataBase Object from table BRIO.Lin
  * @version 03/04/2013 10:35:51
  */
public class Lin implements java.io.Serializable, com.egen.util.jdbc.Table {
  private int lin_cdgo;
  private java.lang.String lin_nome;
  private int lin_partal;
  private int lin_parrem;
  private int lin_minimo;
  private int lin_platal;
  private int lin_plarem;
  private java.lang.String lin_nometi;
  private java.lang.String lin_nomesp;
  private java.lang.String unid_negocio;
  private java.lang.String situacao;
  private java.sql.Timestamp data_log_afv;
  private java.lang.String lin_gera_lote;
  private int lin_toler_menos_lote;
  private int lin_toler_mais_lote;
  private int lin_prs_lote;
  private int lin_prs_tal_lote;
  private java.lang.String lin_cabedal;
  private int lin_dias_almoxarifado;
  private int lin_dias_costura;
  private int lin_dias_montagem;
  private int lin_dias_expedicao;
  private int codigo_mini_fabs;
  private double investimento;
  private double p_equilibrio;
  private java.lang.String ind_aberto_fechado;
  private java.lang.String ind_grupo;
  private java.sql.Timestamp dt_embarque;
  private java.lang.String musical_solido;
  private java.lang.String projeto_cdgo;

  public Lin() {
  }

  public int getLin_cdgo() {
    return lin_cdgo;
  }

  public void setLin_cdgo(int PARAM) {
    this.lin_cdgo = PARAM;
  }

  public java.lang.String getLin_nome() {
    return lin_nome;
  }

  public void setLin_nome(java.lang.String PARAM) {
    this.lin_nome = PARAM;
  }

  public int getLin_partal() {
    return lin_partal;
  }

  public void setLin_partal(int PARAM) {
    this.lin_partal = PARAM;
  }

  public int getLin_parrem() {
    return lin_parrem;
  }

  public void setLin_parrem(int PARAM) {
    this.lin_parrem = PARAM;
  }

  public int getLin_minimo() {
    return lin_minimo;
  }

  public void setLin_minimo(int PARAM) {
    this.lin_minimo = PARAM;
  }

  public int getLin_platal() {
    return lin_platal;
  }

  public void setLin_platal(int PARAM) {
    this.lin_platal = PARAM;
  }

  public int getLin_plarem() {
    return lin_plarem;
  }

  public void setLin_plarem(int PARAM) {
    this.lin_plarem = PARAM;
  }

  public java.lang.String getLin_nometi() {
    return lin_nometi;
  }

  public void setLin_nometi(java.lang.String PARAM) {
    this.lin_nometi = PARAM;
  }

  public java.lang.String getLin_nomesp() {
    return lin_nomesp;
  }

  public void setLin_nomesp(java.lang.String PARAM) {
    this.lin_nomesp = PARAM;
  }

  public java.lang.String getUnid_negocio() {
    return unid_negocio;
  }

  public void setUnid_negocio(java.lang.String PARAM) {
    this.unid_negocio = PARAM;
  }

  public java.lang.String getSituacao() {
    return situacao;
  }

  public void setSituacao(java.lang.String PARAM) {
    this.situacao = PARAM;
  }

  public java.sql.Timestamp getData_log_afv() {
    return data_log_afv;
  }

  public void setData_log_afv(java.sql.Timestamp PARAM) {
    this.data_log_afv = PARAM;
  }

  public java.lang.String getLin_gera_lote() {
    return lin_gera_lote;
  }

  public void setLin_gera_lote(java.lang.String PARAM) {
    this.lin_gera_lote = PARAM;
  }

  public int getLin_toler_menos_lote() {
    return lin_toler_menos_lote;
  }

  public void setLin_toler_menos_lote(int PARAM) {
    this.lin_toler_menos_lote = PARAM;
  }

  public int getLin_toler_mais_lote() {
    return lin_toler_mais_lote;
  }

  public void setLin_toler_mais_lote(int PARAM) {
    this.lin_toler_mais_lote = PARAM;
  }

  public int getLin_prs_lote() {
    return lin_prs_lote;
  }

  public void setLin_prs_lote(int PARAM) {
    this.lin_prs_lote = PARAM;
  }

  public int getLin_prs_tal_lote() {
    return lin_prs_tal_lote;
  }

  public void setLin_prs_tal_lote(int PARAM) {
    this.lin_prs_tal_lote = PARAM;
  }

  public java.lang.String getLin_cabedal() {
    return lin_cabedal;
  }

  public void setLin_cabedal(java.lang.String PARAM) {
    this.lin_cabedal = PARAM;
  }

  public int getLin_dias_almoxarifado() {
    return lin_dias_almoxarifado;
  }

  public void setLin_dias_almoxarifado(int PARAM) {
    this.lin_dias_almoxarifado = PARAM;
  }

  public int getLin_dias_costura() {
    return lin_dias_costura;
  }

  public void setLin_dias_costura(int PARAM) {
    this.lin_dias_costura = PARAM;
  }

  public int getLin_dias_montagem() {
    return lin_dias_montagem;
  }

  public void setLin_dias_montagem(int PARAM) {
    this.lin_dias_montagem = PARAM;
  }

  public int getLin_dias_expedicao() {
    return lin_dias_expedicao;
  }

  public void setLin_dias_expedicao(int PARAM) {
    this.lin_dias_expedicao = PARAM;
  }

  public int getCodigo_mini_fabs() {
    return codigo_mini_fabs;
  }

  public void setCodigo_mini_fabs(int PARAM) {
    this.codigo_mini_fabs = PARAM;
  }

  public double getInvestimento() {
    return investimento;
  }

  public void setInvestimento(double PARAM) {
    this.investimento = PARAM;
  }

  public double getP_equilibrio() {
    return p_equilibrio;
  }

  public void setP_equilibrio(double PARAM) {
    this.p_equilibrio = PARAM;
  }

  public java.lang.String getInd_aberto_fechado() {
    return ind_aberto_fechado;
  }

  public void setInd_aberto_fechado(java.lang.String PARAM) {
    this.ind_aberto_fechado = PARAM;
  }

  public java.lang.String getInd_grupo() {
    return ind_grupo;
  }

  public void setInd_grupo(java.lang.String PARAM) {
    this.ind_grupo = PARAM;
  }

  public java.sql.Timestamp getDt_embarque() {
    return dt_embarque;
  }

  public void setDt_embarque(java.sql.Timestamp PARAM) {
    this.dt_embarque = PARAM;
  }

  public java.lang.String getMusical_solido() {
    return musical_solido;
  }

  public void setMusical_solido(java.lang.String PARAM) {
    this.musical_solido = PARAM;
  }

  public java.lang.String getProjeto_cdgo() {
    return projeto_cdgo;
  }

  public void setProjeto_cdgo(java.lang.String PARAM) {
    this.projeto_cdgo = PARAM;
  }

}
