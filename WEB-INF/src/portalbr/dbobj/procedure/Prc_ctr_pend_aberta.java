package portalbr.dbobj.procedure;

/** DataBase Object from table BRCONREC.Prc_ctr_pend_aberta
  * @version 15/05/2012 10:38:30
  */
public class Prc_ctr_pend_aberta implements java.io.Serializable, com.egen.util.jdbc.Procedure {
  private java.lang.String p_clientes;
  private double p_cli_cdgo;
  private double p_grupo_economico;
  private java.lang.String p_emp;
  private double p_dias1;
  private double p_dias2;
  private java.lang.String p_mes_1;
  private java.lang.String p_mes_2;
  private java.lang.String p_mes_3;
  private double p_vlr_em_dia_3ma;
  private double p_em_dia_3ma;
  private double p_vlr_em_dia_1mes;
  private double p_em_dia_1mes;
  private double p_vlr_em_dia_2mes;
  private double p_em_dia_2mes;
  private double p_vlr_em_dia_3mes;
  private double p_em_dia_3mes;
  private double p_vlr_atr_me30d_3ma;
  private double p_atr_me30d_3ma;
  private double p_vlr_ate_1mes;
  private double p_ate_1mes;
  private double p_vlr_ate_2mes;
  private double p_ate_2mes;
  private double p_vlr_ate_3mes;
  private double p_ate_3mes;
  private double p_vlr_atr_ma30d_3ma;
  private double p_atr_ma30d_3ma;
  private double p_vlr_acima_1mes;
  private double p_acima_1mes;
  private double p_vlr_acima_2mes;
  private double p_acima_2mes;
  private double p_vlr_acima_3mes;
  private double p_acima_3mes;
  private double p_vlr_tot_3ma;
  private double p_tot_3ma;
  private double p_vlr_tot_1mes;
  private double p_tot_1mes;
  private double p_vlr_tot_2mes;
  private double p_tot_2mes;
  private double p_vlr_tot_3mes;
  private double p_tot_3mes;
  private double p_vlr_vct_ab_3ma;
  private double p_vct_ab_3ma;
  private double p_vlr_vct_ab_1mes;
  private double p_vct_ab_1mes;
  private double p_vlr_vct_ab_2mes;
  private double p_vct_ab_2mes;
  private double p_vlr_vct_ab_3mes;
  private double p_vct_ab_3mes;
  private double p_vlr_venc_mes_corrente;
  private double p_venc_mes_corrente;
  private double p_vlr_avenc_mes_corrente;
  private double p_avenc_mes_corrente;
  private double p_vlr_pag_mes_corrente;
  private double p_pag_mes_corrente;
  private java.lang.String p_mes1;
  private double p_vlr_avenc_m1;
  private double p_vlr_ped_bloq_m1;
  private double p_vlr_ped_abe_m1;
  private double p_avenc_m1;
  private java.lang.String p_mes2;
  private double p_vlr_avenc_m2;
  private double p_vlr_ped_bloq_m2;
  private double p_vlr_ped_abe_m2;
  private double p_avenc_m2;
  private java.lang.String p_mes3;
  private double p_vlr_avenc_m3;
  private double p_vlr_ped_bloq_m3;
  private double p_vlr_ped_abe_m3;
  private double p_avenc_m3;
  private java.lang.String p_mes4;
  private double p_vlr_avenc_m4;
  private double p_vlr_ped_bloq_m4;
  private double p_vlr_ped_abe_m4;
  private double p_avenc_m4;
  private java.lang.String p_mes5;
  private double p_vlr_avenc_m5;
  private double p_vlr_ped_bloq_m5;
  private double p_vlr_ped_abe_m5;
  private double p_avenc_m5;
  private java.lang.String p_mes6;
  private double p_vlr_avenc_m6;
  private double p_vlr_ped_bloq_m6;
  private double p_vlr_ped_abe_m6;
  private double p_avenc_m6;
  private java.lang.String p_mes7;
  private double p_vlr_avenc_m7;
  private double p_vlr_ped_bloq_m7;
  private double p_vlr_ped_abe_m7;
  private double p_avenc_m7;
  private java.lang.String p_mes8;
  private double p_vlr_avenc_m8;
  private double p_vlr_ped_bloq_m8;
  private double p_vlr_ped_abe_m8;
  private double p_avenc_m8;
  private java.lang.String p_erro;

  public Prc_ctr_pend_aberta() {
  }

  public java.lang.String getP_clientes() {
    return p_clientes;
  }

  public void setP_clientes(java.lang.String PARAM) {
    this.p_clientes = PARAM;
  }

  public double getP_cli_cdgo() {
    return p_cli_cdgo;
  }

  public void setP_cli_cdgo(double PARAM) {
    this.p_cli_cdgo = PARAM;
  }

  public double getP_grupo_economico() {
    return p_grupo_economico;
  }

  public void setP_grupo_economico(double PARAM) {
    this.p_grupo_economico = PARAM;
  }

  public java.lang.String getP_emp() {
    return p_emp;
  }

  public void setP_emp(java.lang.String PARAM) {
    this.p_emp = PARAM;
  }

  public double getP_dias1() {
    return p_dias1;
  }

  public void setP_dias1(double PARAM) {
    this.p_dias1 = PARAM;
  }

  public double getP_dias2() {
    return p_dias2;
  }

  public void setP_dias2(double PARAM) {
    this.p_dias2 = PARAM;
  }

  public java.lang.String getP_mes_1() {
    return p_mes_1;
  }

  public void setP_mes_1(java.lang.String PARAM) {
    this.p_mes_1 = PARAM;
  }

  public java.lang.String getP_mes_2() {
    return p_mes_2;
  }

  public void setP_mes_2(java.lang.String PARAM) {
    this.p_mes_2 = PARAM;
  }

  public java.lang.String getP_mes_3() {
    return p_mes_3;
  }

  public void setP_mes_3(java.lang.String PARAM) {
    this.p_mes_3 = PARAM;
  }

  public double getP_vlr_em_dia_3ma() {
    return p_vlr_em_dia_3ma;
  }

  public void setP_vlr_em_dia_3ma(double PARAM) {
    this.p_vlr_em_dia_3ma = PARAM;
  }

  public double getP_em_dia_3ma() {
    return p_em_dia_3ma;
  }

  public void setP_em_dia_3ma(double PARAM) {
    this.p_em_dia_3ma = PARAM;
  }

  public double getP_vlr_em_dia_1mes() {
    return p_vlr_em_dia_1mes;
  }

  public void setP_vlr_em_dia_1mes(double PARAM) {
    this.p_vlr_em_dia_1mes = PARAM;
  }

  public double getP_em_dia_1mes() {
    return p_em_dia_1mes;
  }

  public void setP_em_dia_1mes(double PARAM) {
    this.p_em_dia_1mes = PARAM;
  }

  public double getP_vlr_em_dia_2mes() {
    return p_vlr_em_dia_2mes;
  }

  public void setP_vlr_em_dia_2mes(double PARAM) {
    this.p_vlr_em_dia_2mes = PARAM;
  }

  public double getP_em_dia_2mes() {
    return p_em_dia_2mes;
  }

  public void setP_em_dia_2mes(double PARAM) {
    this.p_em_dia_2mes = PARAM;
  }

  public double getP_vlr_em_dia_3mes() {
    return p_vlr_em_dia_3mes;
  }

  public void setP_vlr_em_dia_3mes(double PARAM) {
    this.p_vlr_em_dia_3mes = PARAM;
  }

  public double getP_em_dia_3mes() {
    return p_em_dia_3mes;
  }

  public void setP_em_dia_3mes(double PARAM) {
    this.p_em_dia_3mes = PARAM;
  }

  public double getP_vlr_atr_me30d_3ma() {
    return p_vlr_atr_me30d_3ma;
  }

  public void setP_vlr_atr_me30d_3ma(double PARAM) {
    this.p_vlr_atr_me30d_3ma = PARAM;
  }

  public double getP_atr_me30d_3ma() {
    return p_atr_me30d_3ma;
  }

  public void setP_atr_me30d_3ma(double PARAM) {
    this.p_atr_me30d_3ma = PARAM;
  }

  public double getP_vlr_ate_1mes() {
    return p_vlr_ate_1mes;
  }

  public void setP_vlr_ate_1mes(double PARAM) {
    this.p_vlr_ate_1mes = PARAM;
  }

  public double getP_ate_1mes() {
    return p_ate_1mes;
  }

  public void setP_ate_1mes(double PARAM) {
    this.p_ate_1mes = PARAM;
  }

  public double getP_vlr_ate_2mes() {
    return p_vlr_ate_2mes;
  }

  public void setP_vlr_ate_2mes(double PARAM) {
    this.p_vlr_ate_2mes = PARAM;
  }

  public double getP_ate_2mes() {
    return p_ate_2mes;
  }

  public void setP_ate_2mes(double PARAM) {
    this.p_ate_2mes = PARAM;
  }

  public double getP_vlr_ate_3mes() {
    return p_vlr_ate_3mes;
  }

  public void setP_vlr_ate_3mes(double PARAM) {
    this.p_vlr_ate_3mes = PARAM;
  }

  public double getP_ate_3mes() {
    return p_ate_3mes;
  }

  public void setP_ate_3mes(double PARAM) {
    this.p_ate_3mes = PARAM;
  }

  public double getP_vlr_atr_ma30d_3ma() {
    return p_vlr_atr_ma30d_3ma;
  }

  public void setP_vlr_atr_ma30d_3ma(double PARAM) {
    this.p_vlr_atr_ma30d_3ma = PARAM;
  }

  public double getP_atr_ma30d_3ma() {
    return p_atr_ma30d_3ma;
  }

  public void setP_atr_ma30d_3ma(double PARAM) {
    this.p_atr_ma30d_3ma = PARAM;
  }

  public double getP_vlr_acima_1mes() {
    return p_vlr_acima_1mes;
  }

  public void setP_vlr_acima_1mes(double PARAM) {
    this.p_vlr_acima_1mes = PARAM;
  }

  public double getP_acima_1mes() {
    return p_acima_1mes;
  }

  public void setP_acima_1mes(double PARAM) {
    this.p_acima_1mes = PARAM;
  }

  public double getP_vlr_acima_2mes() {
    return p_vlr_acima_2mes;
  }

  public void setP_vlr_acima_2mes(double PARAM) {
    this.p_vlr_acima_2mes = PARAM;
  }

  public double getP_acima_2mes() {
    return p_acima_2mes;
  }

  public void setP_acima_2mes(double PARAM) {
    this.p_acima_2mes = PARAM;
  }

  public double getP_vlr_acima_3mes() {
    return p_vlr_acima_3mes;
  }

  public void setP_vlr_acima_3mes(double PARAM) {
    this.p_vlr_acima_3mes = PARAM;
  }

  public double getP_acima_3mes() {
    return p_acima_3mes;
  }

  public void setP_acima_3mes(double PARAM) {
    this.p_acima_3mes = PARAM;
  }

  public double getP_vlr_tot_3ma() {
    return p_vlr_tot_3ma;
  }

  public void setP_vlr_tot_3ma(double PARAM) {
    this.p_vlr_tot_3ma = PARAM;
  }

  public double getP_tot_3ma() {
    return p_tot_3ma;
  }

  public void setP_tot_3ma(double PARAM) {
    this.p_tot_3ma = PARAM;
  }

  public double getP_vlr_tot_1mes() {
    return p_vlr_tot_1mes;
  }

  public void setP_vlr_tot_1mes(double PARAM) {
    this.p_vlr_tot_1mes = PARAM;
  }

  public double getP_tot_1mes() {
    return p_tot_1mes;
  }

  public void setP_tot_1mes(double PARAM) {
    this.p_tot_1mes = PARAM;
  }

  public double getP_vlr_tot_2mes() {
    return p_vlr_tot_2mes;
  }

  public void setP_vlr_tot_2mes(double PARAM) {
    this.p_vlr_tot_2mes = PARAM;
  }

  public double getP_tot_2mes() {
    return p_tot_2mes;
  }

  public void setP_tot_2mes(double PARAM) {
    this.p_tot_2mes = PARAM;
  }

  public double getP_vlr_tot_3mes() {
    return p_vlr_tot_3mes;
  }

  public void setP_vlr_tot_3mes(double PARAM) {
    this.p_vlr_tot_3mes = PARAM;
  }

  public double getP_tot_3mes() {
    return p_tot_3mes;
  }

  public void setP_tot_3mes(double PARAM) {
    this.p_tot_3mes = PARAM;
  }

  public double getP_vlr_vct_ab_3ma() {
    return p_vlr_vct_ab_3ma;
  }

  public void setP_vlr_vct_ab_3ma(double PARAM) {
    this.p_vlr_vct_ab_3ma = PARAM;
  }

  public double getP_vct_ab_3ma() {
    return p_vct_ab_3ma;
  }

  public void setP_vct_ab_3ma(double PARAM) {
    this.p_vct_ab_3ma = PARAM;
  }

  public double getP_vlr_vct_ab_1mes() {
    return p_vlr_vct_ab_1mes;
  }

  public void setP_vlr_vct_ab_1mes(double PARAM) {
    this.p_vlr_vct_ab_1mes = PARAM;
  }

  public double getP_vct_ab_1mes() {
    return p_vct_ab_1mes;
  }

  public void setP_vct_ab_1mes(double PARAM) {
    this.p_vct_ab_1mes = PARAM;
  }

  public double getP_vlr_vct_ab_2mes() {
    return p_vlr_vct_ab_2mes;
  }

  public void setP_vlr_vct_ab_2mes(double PARAM) {
    this.p_vlr_vct_ab_2mes = PARAM;
  }

  public double getP_vct_ab_2mes() {
    return p_vct_ab_2mes;
  }

  public void setP_vct_ab_2mes(double PARAM) {
    this.p_vct_ab_2mes = PARAM;
  }

  public double getP_vlr_vct_ab_3mes() {
    return p_vlr_vct_ab_3mes;
  }

  public void setP_vlr_vct_ab_3mes(double PARAM) {
    this.p_vlr_vct_ab_3mes = PARAM;
  }

  public double getP_vct_ab_3mes() {
    return p_vct_ab_3mes;
  }

  public void setP_vct_ab_3mes(double PARAM) {
    this.p_vct_ab_3mes = PARAM;
  }

  public double getP_vlr_venc_mes_corrente() {
    return p_vlr_venc_mes_corrente;
  }

  public void setP_vlr_venc_mes_corrente(double PARAM) {
    this.p_vlr_venc_mes_corrente = PARAM;
  }

  public double getP_venc_mes_corrente() {
    return p_venc_mes_corrente;
  }

  public void setP_venc_mes_corrente(double PARAM) {
    this.p_venc_mes_corrente = PARAM;
  }

  public double getP_vlr_avenc_mes_corrente() {
    return p_vlr_avenc_mes_corrente;
  }

  public void setP_vlr_avenc_mes_corrente(double PARAM) {
    this.p_vlr_avenc_mes_corrente = PARAM;
  }

  public double getP_avenc_mes_corrente() {
    return p_avenc_mes_corrente;
  }

  public void setP_avenc_mes_corrente(double PARAM) {
    this.p_avenc_mes_corrente = PARAM;
  }

  public double getP_vlr_pag_mes_corrente() {
    return p_vlr_pag_mes_corrente;
  }

  public void setP_vlr_pag_mes_corrente(double PARAM) {
    this.p_vlr_pag_mes_corrente = PARAM;
  }

  public double getP_pag_mes_corrente() {
    return p_pag_mes_corrente;
  }

  public void setP_pag_mes_corrente(double PARAM) {
    this.p_pag_mes_corrente = PARAM;
  }

  public java.lang.String getP_mes1() {
    return p_mes1;
  }

  public void setP_mes1(java.lang.String PARAM) {
    this.p_mes1 = PARAM;
  }

  public double getP_vlr_avenc_m1() {
    return p_vlr_avenc_m1;
  }

  public void setP_vlr_avenc_m1(double PARAM) {
    this.p_vlr_avenc_m1 = PARAM;
  }

  public double getP_vlr_ped_bloq_m1() {
    return p_vlr_ped_bloq_m1;
  }

  public void setP_vlr_ped_bloq_m1(double PARAM) {
    this.p_vlr_ped_bloq_m1 = PARAM;
  }

  public double getP_vlr_ped_abe_m1() {
    return p_vlr_ped_abe_m1;
  }

  public void setP_vlr_ped_abe_m1(double PARAM) {
    this.p_vlr_ped_abe_m1 = PARAM;
  }

  public double getP_avenc_m1() {
    return p_avenc_m1;
  }

  public void setP_avenc_m1(double PARAM) {
    this.p_avenc_m1 = PARAM;
  }

  public java.lang.String getP_mes2() {
    return p_mes2;
  }

  public void setP_mes2(java.lang.String PARAM) {
    this.p_mes2 = PARAM;
  }

  public double getP_vlr_avenc_m2() {
    return p_vlr_avenc_m2;
  }

  public void setP_vlr_avenc_m2(double PARAM) {
    this.p_vlr_avenc_m2 = PARAM;
  }

  public double getP_vlr_ped_bloq_m2() {
    return p_vlr_ped_bloq_m2;
  }

  public void setP_vlr_ped_bloq_m2(double PARAM) {
    this.p_vlr_ped_bloq_m2 = PARAM;
  }

  public double getP_vlr_ped_abe_m2() {
    return p_vlr_ped_abe_m2;
  }

  public void setP_vlr_ped_abe_m2(double PARAM) {
    this.p_vlr_ped_abe_m2 = PARAM;
  }

  public double getP_avenc_m2() {
    return p_avenc_m2;
  }

  public void setP_avenc_m2(double PARAM) {
    this.p_avenc_m2 = PARAM;
  }

  public java.lang.String getP_mes3() {
    return p_mes3;
  }

  public void setP_mes3(java.lang.String PARAM) {
    this.p_mes3 = PARAM;
  }

  public double getP_vlr_avenc_m3() {
    return p_vlr_avenc_m3;
  }

  public void setP_vlr_avenc_m3(double PARAM) {
    this.p_vlr_avenc_m3 = PARAM;
  }

  public double getP_vlr_ped_bloq_m3() {
    return p_vlr_ped_bloq_m3;
  }

  public void setP_vlr_ped_bloq_m3(double PARAM) {
    this.p_vlr_ped_bloq_m3 = PARAM;
  }

  public double getP_vlr_ped_abe_m3() {
    return p_vlr_ped_abe_m3;
  }

  public void setP_vlr_ped_abe_m3(double PARAM) {
    this.p_vlr_ped_abe_m3 = PARAM;
  }

  public double getP_avenc_m3() {
    return p_avenc_m3;
  }

  public void setP_avenc_m3(double PARAM) {
    this.p_avenc_m3 = PARAM;
  }

  public java.lang.String getP_mes4() {
    return p_mes4;
  }

  public void setP_mes4(java.lang.String PARAM) {
    this.p_mes4 = PARAM;
  }

  public double getP_vlr_avenc_m4() {
    return p_vlr_avenc_m4;
  }

  public void setP_vlr_avenc_m4(double PARAM) {
    this.p_vlr_avenc_m4 = PARAM;
  }

  public double getP_vlr_ped_bloq_m4() {
    return p_vlr_ped_bloq_m4;
  }

  public void setP_vlr_ped_bloq_m4(double PARAM) {
    this.p_vlr_ped_bloq_m4 = PARAM;
  }

  public double getP_vlr_ped_abe_m4() {
    return p_vlr_ped_abe_m4;
  }

  public void setP_vlr_ped_abe_m4(double PARAM) {
    this.p_vlr_ped_abe_m4 = PARAM;
  }

  public double getP_avenc_m4() {
    return p_avenc_m4;
  }

  public void setP_avenc_m4(double PARAM) {
    this.p_avenc_m4 = PARAM;
  }

  public java.lang.String getP_mes5() {
    return p_mes5;
  }

  public void setP_mes5(java.lang.String PARAM) {
    this.p_mes5 = PARAM;
  }

  public double getP_vlr_avenc_m5() {
    return p_vlr_avenc_m5;
  }

  public void setP_vlr_avenc_m5(double PARAM) {
    this.p_vlr_avenc_m5 = PARAM;
  }

  public double getP_vlr_ped_bloq_m5() {
    return p_vlr_ped_bloq_m5;
  }

  public void setP_vlr_ped_bloq_m5(double PARAM) {
    this.p_vlr_ped_bloq_m5 = PARAM;
  }

  public double getP_vlr_ped_abe_m5() {
    return p_vlr_ped_abe_m5;
  }

  public void setP_vlr_ped_abe_m5(double PARAM) {
    this.p_vlr_ped_abe_m5 = PARAM;
  }

  public double getP_avenc_m5() {
    return p_avenc_m5;
  }

  public void setP_avenc_m5(double PARAM) {
    this.p_avenc_m5 = PARAM;
  }

  public java.lang.String getP_mes6() {
    return p_mes6;
  }

  public void setP_mes6(java.lang.String PARAM) {
    this.p_mes6 = PARAM;
  }

  public double getP_vlr_avenc_m6() {
    return p_vlr_avenc_m6;
  }

  public void setP_vlr_avenc_m6(double PARAM) {
    this.p_vlr_avenc_m6 = PARAM;
  }

  public double getP_vlr_ped_bloq_m6() {
    return p_vlr_ped_bloq_m6;
  }

  public void setP_vlr_ped_bloq_m6(double PARAM) {
    this.p_vlr_ped_bloq_m6 = PARAM;
  }

  public double getP_vlr_ped_abe_m6() {
    return p_vlr_ped_abe_m6;
  }

  public void setP_vlr_ped_abe_m6(double PARAM) {
    this.p_vlr_ped_abe_m6 = PARAM;
  }

  public double getP_avenc_m6() {
    return p_avenc_m6;
  }

  public void setP_avenc_m6(double PARAM) {
    this.p_avenc_m6 = PARAM;
  }

  public java.lang.String getP_mes7() {
    return p_mes7;
  }

  public void setP_mes7(java.lang.String PARAM) {
    this.p_mes7 = PARAM;
  }

  public double getP_vlr_avenc_m7() {
    return p_vlr_avenc_m7;
  }

  public void setP_vlr_avenc_m7(double PARAM) {
    this.p_vlr_avenc_m7 = PARAM;
  }

  public double getP_vlr_ped_bloq_m7() {
    return p_vlr_ped_bloq_m7;
  }

  public void setP_vlr_ped_bloq_m7(double PARAM) {
    this.p_vlr_ped_bloq_m7 = PARAM;
  }

  public double getP_vlr_ped_abe_m7() {
    return p_vlr_ped_abe_m7;
  }

  public void setP_vlr_ped_abe_m7(double PARAM) {
    this.p_vlr_ped_abe_m7 = PARAM;
  }

  public double getP_avenc_m7() {
    return p_avenc_m7;
  }

  public void setP_avenc_m7(double PARAM) {
    this.p_avenc_m7 = PARAM;
  }

  public java.lang.String getP_mes8() {
    return p_mes8;
  }

  public void setP_mes8(java.lang.String PARAM) {
    this.p_mes8 = PARAM;
  }

  public double getP_vlr_avenc_m8() {
    return p_vlr_avenc_m8;
  }

  public void setP_vlr_avenc_m8(double PARAM) {
    this.p_vlr_avenc_m8 = PARAM;
  }

  public double getP_vlr_ped_bloq_m8() {
    return p_vlr_ped_bloq_m8;
  }

  public void setP_vlr_ped_bloq_m8(double PARAM) {
    this.p_vlr_ped_bloq_m8 = PARAM;
  }

  public double getP_vlr_ped_abe_m8() {
    return p_vlr_ped_abe_m8;
  }

  public void setP_vlr_ped_abe_m8(double PARAM) {
    this.p_vlr_ped_abe_m8 = PARAM;
  }

  public double getP_avenc_m8() {
    return p_avenc_m8;
  }

  public void setP_avenc_m8(double PARAM) {
    this.p_avenc_m8 = PARAM;
  }

  public java.lang.String getP_erro() {
    return p_erro;
  }

  public void setP_erro(java.lang.String PARAM) {
    this.p_erro = PARAM;
  }

}
