package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/08/2006 15:45:57
 * Last Modify Date 24/01/2019 09:44:46
 */

public class AnaliseCredito_deActionForm extends org.apache.struts.action.ActionForm
{
  public String p_clientes;
  public String p_cli_cdgo;
  public String p_grupo_economico;
  public String p_emp;
  public String p_dias1;
  public String p_dias2;
  public String p_mes_1;
  public String p_mes_2;
  public String p_mes_3;
  public String p_vlr_em_dia_3ma;
  public String p_em_dia_3ma;
  public String p_vlr_em_dia_1mes;
  public String p_em_dia_1mes;
  public String p_vlr_em_dia_2mes;
  public String p_em_dia_2mes;
  public String p_vlr_em_dia_3mes;
  public String p_em_dia_3mes;
  public String p_vlr_atr_me30d_3ma;
  public String p_atr_me30d_3ma;
  public String p_vlr_ate_1mes;
  public String p_ate_1mes;
  public String p_vlr_ate_2mes;
  public String p_ate_2mes;
  public String p_vlr_ate_3mes;
  public String p_ate_3mes;
  public String p_vlr_atr_ma30d_3ma;
  public String p_atr_ma30d_3ma;
  public String p_vlr_acima_1mes;
  public String p_acima_1mes;
  public String p_vlr_acima_2mes;
  public String p_acima_2mes;
  public String p_vlr_acima_3mes;
  public String p_acima_3mes;
  public String p_vlr_tot_3ma;
  public String p_tot_3ma;
  public String p_vlr_tot_1mes;
  public String p_tot_1mes;
  public String p_vlr_tot_2mes;
  public String p_tot_2mes;
  public String p_vlr_tot_3mes;
  public String p_tot_3mes;
  public String p_vlr_vct_ab_3ma;
  public String p_vct_ab_3ma;
  public String p_vlr_vct_ab_1mes;
  public String p_vct_ab_1mes;
  public String p_vlr_vct_ab_2mes;
  public String p_vct_ab_2mes;
  public String p_vlr_vct_ab_3mes;
  public String p_vct_ab_3mes;
  public String p_vlr_venc_mes_corrente;
  public String p_venc_mes_corrente;
  public String p_vlr_avenc_mes_corrente;
  public String p_avenc_mes_corrente;
  public String p_vlr_pag_mes_corrente;
  public String p_pag_mes_corrente;
  public String p_mes1;
  public String p_vlr_avenc_m1;
  public String p_avenc_m1;
  public String p_mes2;
  public String p_vlr_avenc_m2;
  public String p_avenc_m2;
  public String p_mes3;
  public String p_vlr_avenc_m3;
  public String p_avenc_m3;
  public String p_mes4;
  public String p_vlr_avenc_m4;
  public String p_avenc_m4;
  public String p_mes5;
  public String p_vlr_avenc_m5;
  public String p_avenc_m5;
  public String p_mes6;
  public String p_vlr_avenc_m6;
  public String p_avenc_m6;
  public String p_mes7;
  public String p_vlr_avenc_m7;
  public String p_avenc_m7;
  public String p_mes8;
  public String p_vlr_avenc_m8;
  public String p_avenc_m8;
  public String p_erro;
  private boolean valida = false;
  public AnaliseCredito_deActionForm() {
  }
  /**
    * P_CLIENTES: Método Gets para este campo
    */
  public String getP_clientes() {
    return p_clientes;
  }
  /**
    * P_CLIENTES: Método Sets pára este campo.
    */
  public void setP_clientes(String PARAM) {
    p_clientes = PARAM;
  }
  /**
    * P_CLI_CDGO: Método Gets para este campo
    */
  public String getP_cli_cdgo() {
    return p_cli_cdgo;
  }
  /**
    * P_CLI_CDGO: Método Sets pára este campo.
    */
  public void setP_cli_cdgo(String PARAM) {
    p_cli_cdgo = PARAM;
  }
  /**
    * P_GRUPO_ECONOMICO: Método Gets para este campo
    */
  public String getP_grupo_economico() {
    return p_grupo_economico;
  }
  /**
    * P_GRUPO_ECONOMICO: Método Sets pára este campo.
    */
  public void setP_grupo_economico(String PARAM) {
    p_grupo_economico = PARAM;
  }
  /**
    * P_EMP: Método Gets para este campo
    */
  public String getP_emp() {
    return p_emp;
  }
  /**
    * P_EMP: Método Sets pára este campo.
    */
  public void setP_emp(String PARAM) {
    p_emp = PARAM;
  }
  /**
    * P_DIAS1: Método Gets para este campo
    */
  public String getP_dias1() {
    return p_dias1;
  }
  /**
    * P_DIAS1: Método Sets pára este campo.
    */
  public void setP_dias1(String PARAM) {
    p_dias1 = PARAM;
  }
  /**
    * P_DIAS2: Método Gets para este campo
    */
  public String getP_dias2() {
    return p_dias2;
  }
  /**
    * P_DIAS2: Método Sets pára este campo.
    */
  public void setP_dias2(String PARAM) {
    p_dias2 = PARAM;
  }
  /**
    * P_MES_1: Método Gets para este campo
    */
  public String getP_mes_1() {
    return p_mes_1;
  }
  /**
    * P_MES_1: Método Sets pára este campo.
    */
  public void setP_mes_1(String PARAM) {
    p_mes_1 = PARAM;
  }
  /**
    * P_MES_2: Método Gets para este campo
    */
  public String getP_mes_2() {
    return p_mes_2;
  }
  /**
    * P_MES_2: Método Sets pára este campo.
    */
  public void setP_mes_2(String PARAM) {
    p_mes_2 = PARAM;
  }
  /**
    * P_MES_3: Método Gets para este campo
    */
  public String getP_mes_3() {
    return p_mes_3;
  }
  /**
    * P_MES_3: Método Sets pára este campo.
    */
  public void setP_mes_3(String PARAM) {
    p_mes_3 = PARAM;
  }
  /**
    * P_VLR_EM_DIA_3MA: Método Gets para este campo
    */
  public String getP_vlr_em_dia_3ma() {
    return p_vlr_em_dia_3ma;
  }
  /**
    * P_VLR_EM_DIA_3MA: Método Sets pára este campo.
    */
  public void setP_vlr_em_dia_3ma(String PARAM) {
    p_vlr_em_dia_3ma = PARAM;
  }
  /**
    * P_EM_DIA_3MA: Método Gets para este campo
    */
  public String getP_em_dia_3ma() {
    return p_em_dia_3ma;
  }
  /**
    * P_EM_DIA_3MA: Método Sets pára este campo.
    */
  public void setP_em_dia_3ma(String PARAM) {
    p_em_dia_3ma = PARAM;
  }
  /**
    * P_VLR_EM_DIA_1MES: Método Gets para este campo
    */
  public String getP_vlr_em_dia_1mes() {
    return p_vlr_em_dia_1mes;
  }
  /**
    * P_VLR_EM_DIA_1MES: Método Sets pára este campo.
    */
  public void setP_vlr_em_dia_1mes(String PARAM) {
    p_vlr_em_dia_1mes = PARAM;
  }
  /**
    * P_EM_DIA_1MES: Método Gets para este campo
    */
  public String getP_em_dia_1mes() {
    return p_em_dia_1mes;
  }
  /**
    * P_EM_DIA_1MES: Método Sets pára este campo.
    */
  public void setP_em_dia_1mes(String PARAM) {
    p_em_dia_1mes = PARAM;
  }
  /**
    * P_VLR_EM_DIA_2MES: Método Gets para este campo
    */
  public String getP_vlr_em_dia_2mes() {
    return p_vlr_em_dia_2mes;
  }
  /**
    * P_VLR_EM_DIA_2MES: Método Sets pára este campo.
    */
  public void setP_vlr_em_dia_2mes(String PARAM) {
    p_vlr_em_dia_2mes = PARAM;
  }
  /**
    * P_EM_DIA_2MES: Método Gets para este campo
    */
  public String getP_em_dia_2mes() {
    return p_em_dia_2mes;
  }
  /**
    * P_EM_DIA_2MES: Método Sets pára este campo.
    */
  public void setP_em_dia_2mes(String PARAM) {
    p_em_dia_2mes = PARAM;
  }
  /**
    * P_VLR_EM_DIA_3MES: Método Gets para este campo
    */
  public String getP_vlr_em_dia_3mes() {
    return p_vlr_em_dia_3mes;
  }
  /**
    * P_VLR_EM_DIA_3MES: Método Sets pára este campo.
    */
  public void setP_vlr_em_dia_3mes(String PARAM) {
    p_vlr_em_dia_3mes = PARAM;
  }
  /**
    * P_EM_DIA_3MES: Método Gets para este campo
    */
  public String getP_em_dia_3mes() {
    return p_em_dia_3mes;
  }
  /**
    * P_EM_DIA_3MES: Método Sets pára este campo.
    */
  public void setP_em_dia_3mes(String PARAM) {
    p_em_dia_3mes = PARAM;
  }
  /**
    * P_VLR_ATR_ME30D_3MA: Método Gets para este campo
    */
  public String getP_vlr_atr_me30d_3ma() {
    return p_vlr_atr_me30d_3ma;
  }
  /**
    * P_VLR_ATR_ME30D_3MA: Método Sets pára este campo.
    */
  public void setP_vlr_atr_me30d_3ma(String PARAM) {
    p_vlr_atr_me30d_3ma = PARAM;
  }
  /**
    * P_ATR_ME30D_3MA: Método Gets para este campo
    */
  public String getP_atr_me30d_3ma() {
    return p_atr_me30d_3ma;
  }
  /**
    * P_ATR_ME30D_3MA: Método Sets pára este campo.
    */
  public void setP_atr_me30d_3ma(String PARAM) {
    p_atr_me30d_3ma = PARAM;
  }
  /**
    * P_VLR_ATE_1MES: Método Gets para este campo
    */
  public String getP_vlr_ate_1mes() {
    return p_vlr_ate_1mes;
  }
  /**
    * P_VLR_ATE_1MES: Método Sets pára este campo.
    */
  public void setP_vlr_ate_1mes(String PARAM) {
    p_vlr_ate_1mes = PARAM;
  }
  /**
    * P_ATE_1MES: Método Gets para este campo
    */
  public String getP_ate_1mes() {
    return p_ate_1mes;
  }
  /**
    * P_ATE_1MES: Método Sets pára este campo.
    */
  public void setP_ate_1mes(String PARAM) {
    p_ate_1mes = PARAM;
  }
  /**
    * P_VLR_ATE_2MES: Método Gets para este campo
    */
  public String getP_vlr_ate_2mes() {
    return p_vlr_ate_2mes;
  }
  /**
    * P_VLR_ATE_2MES: Método Sets pára este campo.
    */
  public void setP_vlr_ate_2mes(String PARAM) {
    p_vlr_ate_2mes = PARAM;
  }
  /**
    * P_ATE_2MES: Método Gets para este campo
    */
  public String getP_ate_2mes() {
    return p_ate_2mes;
  }
  /**
    * P_ATE_2MES: Método Sets pára este campo.
    */
  public void setP_ate_2mes(String PARAM) {
    p_ate_2mes = PARAM;
  }
  /**
    * P_VLR_ATE_3MES: Método Gets para este campo
    */
  public String getP_vlr_ate_3mes() {
    return p_vlr_ate_3mes;
  }
  /**
    * P_VLR_ATE_3MES: Método Sets pára este campo.
    */
  public void setP_vlr_ate_3mes(String PARAM) {
    p_vlr_ate_3mes = PARAM;
  }
  /**
    * P_ATE_3MES: Método Gets para este campo
    */
  public String getP_ate_3mes() {
    return p_ate_3mes;
  }
  /**
    * P_ATE_3MES: Método Sets pára este campo.
    */
  public void setP_ate_3mes(String PARAM) {
    p_ate_3mes = PARAM;
  }
  /**
    * P_VLR_ATR_MA30D_3MA: Método Gets para este campo
    */
  public String getP_vlr_atr_ma30d_3ma() {
    return p_vlr_atr_ma30d_3ma;
  }
  /**
    * P_VLR_ATR_MA30D_3MA: Método Sets pára este campo.
    */
  public void setP_vlr_atr_ma30d_3ma(String PARAM) {
    p_vlr_atr_ma30d_3ma = PARAM;
  }
  /**
    * P_ATR_MA30D_3MA: Método Gets para este campo
    */
  public String getP_atr_ma30d_3ma() {
    return p_atr_ma30d_3ma;
  }
  /**
    * P_ATR_MA30D_3MA: Método Sets pára este campo.
    */
  public void setP_atr_ma30d_3ma(String PARAM) {
    p_atr_ma30d_3ma = PARAM;
  }
  /**
    * P_VLR_ACIMA_1MES: Método Gets para este campo
    */
  public String getP_vlr_acima_1mes() {
    return p_vlr_acima_1mes;
  }
  /**
    * P_VLR_ACIMA_1MES: Método Sets pára este campo.
    */
  public void setP_vlr_acima_1mes(String PARAM) {
    p_vlr_acima_1mes = PARAM;
  }
  /**
    * P_ACIMA_1MES: Método Gets para este campo
    */
  public String getP_acima_1mes() {
    return p_acima_1mes;
  }
  /**
    * P_ACIMA_1MES: Método Sets pára este campo.
    */
  public void setP_acima_1mes(String PARAM) {
    p_acima_1mes = PARAM;
  }
  /**
    * P_VLR_ACIMA_2MES: Método Gets para este campo
    */
  public String getP_vlr_acima_2mes() {
    return p_vlr_acima_2mes;
  }
  /**
    * P_VLR_ACIMA_2MES: Método Sets pára este campo.
    */
  public void setP_vlr_acima_2mes(String PARAM) {
    p_vlr_acima_2mes = PARAM;
  }
  /**
    * P_ACIMA_2MES: Método Gets para este campo
    */
  public String getP_acima_2mes() {
    return p_acima_2mes;
  }
  /**
    * P_ACIMA_2MES: Método Sets pára este campo.
    */
  public void setP_acima_2mes(String PARAM) {
    p_acima_2mes = PARAM;
  }
  /**
    * P_VLR_ACIMA_3MES: Método Gets para este campo
    */
  public String getP_vlr_acima_3mes() {
    return p_vlr_acima_3mes;
  }
  /**
    * P_VLR_ACIMA_3MES: Método Sets pára este campo.
    */
  public void setP_vlr_acima_3mes(String PARAM) {
    p_vlr_acima_3mes = PARAM;
  }
  /**
    * P_ACIMA_3MES: Método Gets para este campo
    */
  public String getP_acima_3mes() {
    return p_acima_3mes;
  }
  /**
    * P_ACIMA_3MES: Método Sets pára este campo.
    */
  public void setP_acima_3mes(String PARAM) {
    p_acima_3mes = PARAM;
  }
  /**
    * P_VLR_TOT_3MA: Método Gets para este campo
    */
  public String getP_vlr_tot_3ma() {
    return p_vlr_tot_3ma;
  }
  /**
    * P_VLR_TOT_3MA: Método Sets pára este campo.
    */
  public void setP_vlr_tot_3ma(String PARAM) {
    p_vlr_tot_3ma = PARAM;
  }
  /**
    * P_TOT_3MA: Método Gets para este campo
    */
  public String getP_tot_3ma() {
    return p_tot_3ma;
  }
  /**
    * P_TOT_3MA: Método Sets pára este campo.
    */
  public void setP_tot_3ma(String PARAM) {
    p_tot_3ma = PARAM;
  }
  /**
    * P_VLR_TOT_1MES: Método Gets para este campo
    */
  public String getP_vlr_tot_1mes() {
    return p_vlr_tot_1mes;
  }
  /**
    * P_VLR_TOT_1MES: Método Sets pára este campo.
    */
  public void setP_vlr_tot_1mes(String PARAM) {
    p_vlr_tot_1mes = PARAM;
  }
  /**
    * P_TOT_1MES: Método Gets para este campo
    */
  public String getP_tot_1mes() {
    return p_tot_1mes;
  }
  /**
    * P_TOT_1MES: Método Sets pára este campo.
    */
  public void setP_tot_1mes(String PARAM) {
    p_tot_1mes = PARAM;
  }
  /**
    * P_VLR_TOT_2MES: Método Gets para este campo
    */
  public String getP_vlr_tot_2mes() {
    return p_vlr_tot_2mes;
  }
  /**
    * P_VLR_TOT_2MES: Método Sets pára este campo.
    */
  public void setP_vlr_tot_2mes(String PARAM) {
    p_vlr_tot_2mes = PARAM;
  }
  /**
    * P_TOT_2MES: Método Gets para este campo
    */
  public String getP_tot_2mes() {
    return p_tot_2mes;
  }
  /**
    * P_TOT_2MES: Método Sets pára este campo.
    */
  public void setP_tot_2mes(String PARAM) {
    p_tot_2mes = PARAM;
  }
  /**
    * P_VLR_TOT_3MES: Método Gets para este campo
    */
  public String getP_vlr_tot_3mes() {
    return p_vlr_tot_3mes;
  }
  /**
    * P_VLR_TOT_3MES: Método Sets pára este campo.
    */
  public void setP_vlr_tot_3mes(String PARAM) {
    p_vlr_tot_3mes = PARAM;
  }
  /**
    * P_TOT_3MES: Método Gets para este campo
    */
  public String getP_tot_3mes() {
    return p_tot_3mes;
  }
  /**
    * P_TOT_3MES: Método Sets pára este campo.
    */
  public void setP_tot_3mes(String PARAM) {
    p_tot_3mes = PARAM;
  }
  /**
    * P_VLR_VCT_AB_3MA: Método Gets para este campo
    */
  public String getP_vlr_vct_ab_3ma() {
    return p_vlr_vct_ab_3ma;
  }
  /**
    * P_VLR_VCT_AB_3MA: Método Sets pára este campo.
    */
  public void setP_vlr_vct_ab_3ma(String PARAM) {
    p_vlr_vct_ab_3ma = PARAM;
  }
  /**
    * P_VCT_AB_3MA: Método Gets para este campo
    */
  public String getP_vct_ab_3ma() {
    return p_vct_ab_3ma;
  }
  /**
    * P_VCT_AB_3MA: Método Sets pára este campo.
    */
  public void setP_vct_ab_3ma(String PARAM) {
    p_vct_ab_3ma = PARAM;
  }
  /**
    * P_VLR_VCT_AB_1MES: Método Gets para este campo
    */
  public String getP_vlr_vct_ab_1mes() {
    return p_vlr_vct_ab_1mes;
  }
  /**
    * P_VLR_VCT_AB_1MES: Método Sets pára este campo.
    */
  public void setP_vlr_vct_ab_1mes(String PARAM) {
    p_vlr_vct_ab_1mes = PARAM;
  }
  /**
    * P_VCT_AB_1MES: Método Gets para este campo
    */
  public String getP_vct_ab_1mes() {
    return p_vct_ab_1mes;
  }
  /**
    * P_VCT_AB_1MES: Método Sets pára este campo.
    */
  public void setP_vct_ab_1mes(String PARAM) {
    p_vct_ab_1mes = PARAM;
  }
  /**
    * P_VLR_VCT_AB_2MES: Método Gets para este campo
    */
  public String getP_vlr_vct_ab_2mes() {
    return p_vlr_vct_ab_2mes;
  }
  /**
    * P_VLR_VCT_AB_2MES: Método Sets pára este campo.
    */
  public void setP_vlr_vct_ab_2mes(String PARAM) {
    p_vlr_vct_ab_2mes = PARAM;
  }
  /**
    * P_VCT_AB_2MES: Método Gets para este campo
    */
  public String getP_vct_ab_2mes() {
    return p_vct_ab_2mes;
  }
  /**
    * P_VCT_AB_2MES: Método Sets pára este campo.
    */
  public void setP_vct_ab_2mes(String PARAM) {
    p_vct_ab_2mes = PARAM;
  }
  /**
    * P_VLR_VCT_AB_3MES: Método Gets para este campo
    */
  public String getP_vlr_vct_ab_3mes() {
    return p_vlr_vct_ab_3mes;
  }
  /**
    * P_VLR_VCT_AB_3MES: Método Sets pára este campo.
    */
  public void setP_vlr_vct_ab_3mes(String PARAM) {
    p_vlr_vct_ab_3mes = PARAM;
  }
  /**
    * P_VCT_AB_3MES: Método Gets para este campo
    */
  public String getP_vct_ab_3mes() {
    return p_vct_ab_3mes;
  }
  /**
    * P_VCT_AB_3MES: Método Sets pára este campo.
    */
  public void setP_vct_ab_3mes(String PARAM) {
    p_vct_ab_3mes = PARAM;
  }
  /**
    * P_VLR_VENC_MES_CORRENTE: Método Gets para este campo
    */
  public String getP_vlr_venc_mes_corrente() {
    return p_vlr_venc_mes_corrente;
  }
  /**
    * P_VLR_VENC_MES_CORRENTE: Método Sets pára este campo.
    */
  public void setP_vlr_venc_mes_corrente(String PARAM) {
    p_vlr_venc_mes_corrente = PARAM;
  }
  /**
    * P_VENC_MES_CORRENTE: Método Gets para este campo
    */
  public String getP_venc_mes_corrente() {
    return p_venc_mes_corrente;
  }
  /**
    * P_VENC_MES_CORRENTE: Método Sets pára este campo.
    */
  public void setP_venc_mes_corrente(String PARAM) {
    p_venc_mes_corrente = PARAM;
  }
  /**
    * P_VLR_AVENC_MES_CORRENTE: Método Gets para este campo
    */
  public String getP_vlr_avenc_mes_corrente() {
    return p_vlr_avenc_mes_corrente;
  }
  /**
    * P_VLR_AVENC_MES_CORRENTE: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_mes_corrente(String PARAM) {
    p_vlr_avenc_mes_corrente = PARAM;
  }
  /**
    * P_AVENC_MES_CORRENTE: Método Gets para este campo
    */
  public String getP_avenc_mes_corrente() {
    return p_avenc_mes_corrente;
  }
  /**
    * P_AVENC_MES_CORRENTE: Método Sets pára este campo.
    */
  public void setP_avenc_mes_corrente(String PARAM) {
    p_avenc_mes_corrente = PARAM;
  }
  /**
    * P_VLR_PAG_MES_CORRENTE: Método Gets para este campo
    */
  public String getP_vlr_pag_mes_corrente() {
    return p_vlr_pag_mes_corrente;
  }
  /**
    * P_VLR_PAG_MES_CORRENTE: Método Sets pára este campo.
    */
  public void setP_vlr_pag_mes_corrente(String PARAM) {
    p_vlr_pag_mes_corrente = PARAM;
  }
  /**
    * P_PAG_MES_CORRENTE: Método Gets para este campo
    */
  public String getP_pag_mes_corrente() {
    return p_pag_mes_corrente;
  }
  /**
    * P_PAG_MES_CORRENTE: Método Sets pára este campo.
    */
  public void setP_pag_mes_corrente(String PARAM) {
    p_pag_mes_corrente = PARAM;
  }
  /**
    * P_MES1: Método Gets para este campo
    */
  public String getP_mes1() {
    return p_mes1;
  }
  /**
    * P_MES1: Método Sets pára este campo.
    */
  public void setP_mes1(String PARAM) {
    p_mes1 = PARAM;
  }
  /**
    * P_VLR_AVENC_M1: Método Gets para este campo
    */
  public String getP_vlr_avenc_m1() {
    return p_vlr_avenc_m1;
  }
  /**
    * P_VLR_AVENC_M1: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_m1(String PARAM) {
    p_vlr_avenc_m1 = PARAM;
  }
  /**
    * P_AVENC_M1: Método Gets para este campo
    */
  public String getP_avenc_m1() {
    return p_avenc_m1;
  }
  /**
    * P_AVENC_M1: Método Sets pára este campo.
    */
  public void setP_avenc_m1(String PARAM) {
    p_avenc_m1 = PARAM;
  }
  /**
    * P_MES2: Método Gets para este campo
    */
  public String getP_mes2() {
    return p_mes2;
  }
  /**
    * P_MES2: Método Sets pára este campo.
    */
  public void setP_mes2(String PARAM) {
    p_mes2 = PARAM;
  }
  /**
    * P_VLR_AVENC_M2: Método Gets para este campo
    */
  public String getP_vlr_avenc_m2() {
    return p_vlr_avenc_m2;
  }
  /**
    * P_VLR_AVENC_M2: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_m2(String PARAM) {
    p_vlr_avenc_m2 = PARAM;
  }
  /**
    * P_AVENC_M2: Método Gets para este campo
    */
  public String getP_avenc_m2() {
    return p_avenc_m2;
  }
  /**
    * P_AVENC_M2: Método Sets pára este campo.
    */
  public void setP_avenc_m2(String PARAM) {
    p_avenc_m2 = PARAM;
  }
  /**
    * P_MES3: Método Gets para este campo
    */
  public String getP_mes3() {
    return p_mes3;
  }
  /**
    * P_MES3: Método Sets pára este campo.
    */
  public void setP_mes3(String PARAM) {
    p_mes3 = PARAM;
  }
  /**
    * P_VLR_AVENC_M3: Método Gets para este campo
    */
  public String getP_vlr_avenc_m3() {
    return p_vlr_avenc_m3;
  }
  /**
    * P_VLR_AVENC_M3: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_m3(String PARAM) {
    p_vlr_avenc_m3 = PARAM;
  }
  /**
    * P_AVENC_M3: Método Gets para este campo
    */
  public String getP_avenc_m3() {
    return p_avenc_m3;
  }
  /**
    * P_AVENC_M3: Método Sets pára este campo.
    */
  public void setP_avenc_m3(String PARAM) {
    p_avenc_m3 = PARAM;
  }
  /**
    * P_MES4: Método Gets para este campo
    */
  public String getP_mes4() {
    return p_mes4;
  }
  /**
    * P_MES4: Método Sets pára este campo.
    */
  public void setP_mes4(String PARAM) {
    p_mes4 = PARAM;
  }
  /**
    * P_VLR_AVENC_M4: Método Gets para este campo
    */
  public String getP_vlr_avenc_m4() {
    return p_vlr_avenc_m4;
  }
  /**
    * P_VLR_AVENC_M4: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_m4(String PARAM) {
    p_vlr_avenc_m4 = PARAM;
  }
  /**
    * P_AVENC_M4: Método Gets para este campo
    */
  public String getP_avenc_m4() {
    return p_avenc_m4;
  }
  /**
    * P_AVENC_M4: Método Sets pára este campo.
    */
  public void setP_avenc_m4(String PARAM) {
    p_avenc_m4 = PARAM;
  }
  /**
    * P_MES5: Método Gets para este campo
    */
  public String getP_mes5() {
    return p_mes5;
  }
  /**
    * P_MES5: Método Sets pára este campo.
    */
  public void setP_mes5(String PARAM) {
    p_mes5 = PARAM;
  }
  /**
    * P_VLR_AVENC_M5: Método Gets para este campo
    */
  public String getP_vlr_avenc_m5() {
    return p_vlr_avenc_m5;
  }
  /**
    * P_VLR_AVENC_M5: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_m5(String PARAM) {
    p_vlr_avenc_m5 = PARAM;
  }
  /**
    * P_AVENC_M5: Método Gets para este campo
    */
  public String getP_avenc_m5() {
    return p_avenc_m5;
  }
  /**
    * P_AVENC_M5: Método Sets pára este campo.
    */
  public void setP_avenc_m5(String PARAM) {
    p_avenc_m5 = PARAM;
  }
  /**
    * P_MES6: Método Gets para este campo
    */
  public String getP_mes6() {
    return p_mes6;
  }
  /**
    * P_MES6: Método Sets pára este campo.
    */
  public void setP_mes6(String PARAM) {
    p_mes6 = PARAM;
  }
  /**
    * P_VLR_AVENC_M6: Método Gets para este campo
    */
  public String getP_vlr_avenc_m6() {
    return p_vlr_avenc_m6;
  }
  /**
    * P_VLR_AVENC_M6: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_m6(String PARAM) {
    p_vlr_avenc_m6 = PARAM;
  }
  /**
    * P_AVENC_M6: Método Gets para este campo
    */
  public String getP_avenc_m6() {
    return p_avenc_m6;
  }
  /**
    * P_AVENC_M6: Método Sets pára este campo.
    */
  public void setP_avenc_m6(String PARAM) {
    p_avenc_m6 = PARAM;
  }
  /**
    * P_MES7: Método Gets para este campo
    */
  public String getP_mes7() {
    return p_mes7;
  }
  /**
    * P_MES7: Método Sets pára este campo.
    */
  public void setP_mes7(String PARAM) {
    p_mes7 = PARAM;
  }
  /**
    * P_VLR_AVENC_M7: Método Gets para este campo
    */
  public String getP_vlr_avenc_m7() {
    return p_vlr_avenc_m7;
  }
  /**
    * P_VLR_AVENC_M7: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_m7(String PARAM) {
    p_vlr_avenc_m7 = PARAM;
  }
  /**
    * P_AVENC_M7: Método Gets para este campo
    */
  public String getP_avenc_m7() {
    return p_avenc_m7;
  }
  /**
    * P_AVENC_M7: Método Sets pára este campo.
    */
  public void setP_avenc_m7(String PARAM) {
    p_avenc_m7 = PARAM;
  }
  /**
    * P_MES8: Método Gets para este campo
    */
  public String getP_mes8() {
    return p_mes8;
  }
  /**
    * P_MES8: Método Sets pára este campo.
    */
  public void setP_mes8(String PARAM) {
    p_mes8 = PARAM;
  }
  /**
    * P_VLR_AVENC_M8: Método Gets para este campo
    */
  public String getP_vlr_avenc_m8() {
    return p_vlr_avenc_m8;
  }
  /**
    * P_VLR_AVENC_M8: Método Sets pára este campo.
    */
  public void setP_vlr_avenc_m8(String PARAM) {
    p_vlr_avenc_m8 = PARAM;
  }
  /**
    * P_AVENC_M8: Método Gets para este campo
    */
  public String getP_avenc_m8() {
    return p_avenc_m8;
  }
  /**
    * P_AVENC_M8: Método Sets pára este campo.
    */
  public void setP_avenc_m8(String PARAM) {
    p_avenc_m8 = PARAM;
  }
  /**
    * P_ERRO: Método Gets para este campo
    */
  public String getP_erro() {
    return p_erro;
  }
  /**
    * P_ERRO: Método Sets pára este campo.
    */
  public void setP_erro(String PARAM) {
    p_erro = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    p_clientes = null;
    p_cli_cdgo = null;
    p_grupo_economico = null;
    p_emp = null;
    p_dias1 = null;
    p_dias2 = null;
    p_mes_1 = null;
    p_mes_2 = null;
    p_mes_3 = null;
    p_vlr_em_dia_3ma = null;
    p_em_dia_3ma = null;
    p_vlr_em_dia_1mes = null;
    p_em_dia_1mes = null;
    p_vlr_em_dia_2mes = null;
    p_em_dia_2mes = null;
    p_vlr_em_dia_3mes = null;
    p_em_dia_3mes = null;
    p_vlr_atr_me30d_3ma = null;
    p_atr_me30d_3ma = null;
    p_vlr_ate_1mes = null;
    p_ate_1mes = null;
    p_vlr_ate_2mes = null;
    p_ate_2mes = null;
    p_vlr_ate_3mes = null;
    p_ate_3mes = null;
    p_vlr_atr_ma30d_3ma = null;
    p_atr_ma30d_3ma = null;
    p_vlr_acima_1mes = null;
    p_acima_1mes = null;
    p_vlr_acima_2mes = null;
    p_acima_2mes = null;
    p_vlr_acima_3mes = null;
    p_acima_3mes = null;
    p_vlr_tot_3ma = null;
    p_tot_3ma = null;
    p_vlr_tot_1mes = null;
    p_tot_1mes = null;
    p_vlr_tot_2mes = null;
    p_tot_2mes = null;
    p_vlr_tot_3mes = null;
    p_tot_3mes = null;
    p_vlr_vct_ab_3ma = null;
    p_vct_ab_3ma = null;
    p_vlr_vct_ab_1mes = null;
    p_vct_ab_1mes = null;
    p_vlr_vct_ab_2mes = null;
    p_vct_ab_2mes = null;
    p_vlr_vct_ab_3mes = null;
    p_vct_ab_3mes = null;
    p_vlr_venc_mes_corrente = null;
    p_venc_mes_corrente = null;
    p_vlr_avenc_mes_corrente = null;
    p_avenc_mes_corrente = null;
    p_vlr_pag_mes_corrente = null;
    p_pag_mes_corrente = null;
    p_mes1 = null;
    p_vlr_avenc_m1 = null;
    p_avenc_m1 = null;
    p_mes2 = null;
    p_vlr_avenc_m2 = null;
    p_avenc_m2 = null;
    p_mes3 = null;
    p_vlr_avenc_m3 = null;
    p_avenc_m3 = null;
    p_mes4 = null;
    p_vlr_avenc_m4 = null;
    p_avenc_m4 = null;
    p_mes5 = null;
    p_vlr_avenc_m5 = null;
    p_avenc_m5 = null;
    p_mes6 = null;
    p_vlr_avenc_m6 = null;
    p_avenc_m6 = null;
    p_mes7 = null;
    p_vlr_avenc_m7 = null;
    p_avenc_m7 = null;
    p_mes8 = null;
    p_vlr_avenc_m8 = null;
    p_avenc_m8 = null;
    p_erro = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
