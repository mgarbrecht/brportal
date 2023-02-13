package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/08/2006 16:04:41
 * Last Modify Date 06/05/2022 11:11:44
 */

public class AnaliseCredito_dActionForm extends org.apache.struts.action.ActionForm
{
  public String p_clientes;
  public String p_cli_cdgo;
  public String cli_rzao;
  public String p_grupo_economico;
  public String p_meses_atras;
  public String p_emp;
  public String emp_razsoc;
  public String p_pri_compra;
  public String p_vlr_pri_compra;
  public String p_ult_compra;
  public String p_vlr_ult_compra;
  public String p_mai_compra;
  public String p_vlr_mai_compra;
  public String p_qtd_12;
  public String p_vlr_12;
  public String p_qtd_6;
  public String p_vlr_6;
  public String p_qtd_02;
  public String p_vlr_02;
  public String p_perc_02;
  public String p_qtd_36;
  public String p_vlr_36;
  public String p_perc_36;
  public String p_qtd_720;
  public String p_vlr_720;
  public String p_perc_720;
  public String p_qtd_2130;
  public String p_vlr_2130;
  public String p_perc_2130;
  public String p_qtd_a30;
  public String p_vlr_a30;
  public String p_perc_a30;
  public String p_qtd_car;
  public String p_vlr_car;
  public String p_perc_car;
  public String p_qtd_dev;
  public String p_vlr_dev;
  public String p_perc_dev;
  public String p_qtd_pro;
  public String p_vlr_pro;
  public String p_perc_pro;
  public String p_qtd_neg_ok;
  public String p_vlr_neg_ok;
  public String p_perc_neg_ok;
  public String p_qtd_neg_enc;
  public String p_vlr_neg_enc;
  public String p_perc_neg_enc;
  public String p_qtd_neg_abe;
  public String p_vlr_neg_abe;
  public String p_qtd_chd_liq;
  public String p_vlr_chd_liq;
  public String p_qtd_chd_abe;
  public String p_vlr_chd_abe;
  public String p_qtd_pro_abe;
  public String p_vlr_pro_abe;
  public String p_qtd_dis_abe;
  public String p_vlr_dis_abe;
  public String p_qtd_fora_pend;
  public String p_vlr_fora_pend;
  public String p_qtd_tit_abe;
  public String p_vlr_tit_abe;
  public String p_qtd_ap_ate;
  public String p_vlr_ap_ate;
  public String p_qtd_ap_apo;
  public String p_vlr_ap_apo;
  public String p_qtd_ve_ate;
  public String p_vlr_ve_ate;
  public String p_qtd_ve_apo;
  public String p_vlr_ve_apo;
  public String p_qtd_tot_ave;
  public String p_vlr_tot_ave;
  public String p_qtd_tot_ven;
  public String p_vlr_tot_ven;
  public String p_perc_ven;
  public String p_qtd_tot_ger;
  public String p_vlr_tot_ger;
  public String p_qtd_ped_abe_nlib;
  public String p_vlr_ped_abe_nlib;
  public String p_qtd_ped_abe_lib;
  public String p_vlr_ped_abe_lib;
  public String p_limite;
  public String p_saldo;
  public String p_erro;
  public String ate20_1;
  public String ate20_2;
  public String ate20_3;
  public String ate20_4;
  public String gre_descricao;
  public String cli_cdgo;
  public String emp_empresa;
  public String gre_grupo;
  public String ddn_qtde;
  public String ddn_valor;
  private boolean valida = false;
  public AnaliseCredito_dActionForm() {
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
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Cli db_object = new portalbr.dbobj.table.Cli();
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Cli) results.elementAt(0);
          fieldRelationValue = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    cli_rzao = fieldRelationValue;
    return cli_rzao;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
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
    * P_MESES_ATRAS: Método Gets para este campo
    */
  public String getP_meses_atras() {
    return p_meses_atras;
  }
  /**
    * P_MESES_ATRAS: Método Sets pára este campo.
    */
  public void setP_meses_atras(String PARAM) {
    p_meses_atras = PARAM;
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
    * EMP_RAZSOC: Método Gets para este campo
    */
  public String getEmp_razsoc() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (emp_empresa != null && emp_empresa.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Empresa db_object = new portalbr.dbobj.table.Empresa();
        Object[][] where = { {"emp_empresa","like",emp_empresa} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Empresa) results.elementAt(0);
          fieldRelationValue = (db_object.getEmp_razsoc() != null) ? db_object.getEmp_razsoc() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    emp_razsoc = fieldRelationValue;
    return emp_razsoc;
  }
  /**
    * EMP_RAZSOC: Método Sets pára este campo.
    */
  public void setEmp_razsoc(String PARAM) {
    emp_razsoc = PARAM;
  }
  /**
    * P_PRI_COMPRA: Método Gets para este campo
    */
  public String getP_pri_compra() {
    return p_pri_compra;
  }
  /**
    * P_PRI_COMPRA: Método Sets pára este campo.
    */
  public void setP_pri_compra(String PARAM) {
    p_pri_compra = PARAM;
  }
  /**
    * P_VLR_PRI_COMPRA: Método Gets para este campo
    */
  public String getP_vlr_pri_compra() {
    return p_vlr_pri_compra;
  }
  /**
    * P_VLR_PRI_COMPRA: Método Sets pára este campo.
    */
  public void setP_vlr_pri_compra(String PARAM) {
    p_vlr_pri_compra = PARAM;
  }
  /**
    * P_ULT_COMPRA: Método Gets para este campo
    */
  public String getP_ult_compra() {
    return p_ult_compra;
  }
  /**
    * P_ULT_COMPRA: Método Sets pára este campo.
    */
  public void setP_ult_compra(String PARAM) {
    p_ult_compra = PARAM;
  }
  /**
    * P_VLR_ULT_COMPRA: Método Gets para este campo
    */
  public String getP_vlr_ult_compra() {
    return p_vlr_ult_compra;
  }
  /**
    * P_VLR_ULT_COMPRA: Método Sets pára este campo.
    */
  public void setP_vlr_ult_compra(String PARAM) {
    p_vlr_ult_compra = PARAM;
  }
  /**
    * P_MAI_COMPRA: Método Gets para este campo
    */
  public String getP_mai_compra() {
    return p_mai_compra;
  }
  /**
    * P_MAI_COMPRA: Método Sets pára este campo.
    */
  public void setP_mai_compra(String PARAM) {
    p_mai_compra = PARAM;
  }
  /**
    * P_VLR_MAI_COMPRA: Método Gets para este campo
    */
  public String getP_vlr_mai_compra() {
    return p_vlr_mai_compra;
  }
  /**
    * P_VLR_MAI_COMPRA: Método Sets pára este campo.
    */
  public void setP_vlr_mai_compra(String PARAM) {
    p_vlr_mai_compra = PARAM;
  }
  /**
    * P_QTD_12: Método Gets para este campo
    */
  public String getP_qtd_12() {
    return p_qtd_12;
  }
  /**
    * P_QTD_12: Método Sets pára este campo.
    */
  public void setP_qtd_12(String PARAM) {
    p_qtd_12 = PARAM;
  }
  /**
    * P_VLR_12: Método Gets para este campo
    */
  public String getP_vlr_12() {
    return p_vlr_12;
  }
  /**
    * P_VLR_12: Método Sets pára este campo.
    */
  public void setP_vlr_12(String PARAM) {
    p_vlr_12 = PARAM;
  }
  /**
    * P_QTD_6: Método Gets para este campo
    */
  public String getP_qtd_6() {
    return p_qtd_6;
  }
  /**
    * P_QTD_6: Método Sets pára este campo.
    */
  public void setP_qtd_6(String PARAM) {
    p_qtd_6 = PARAM;
  }
  /**
    * P_VLR_6: Método Gets para este campo
    */
  public String getP_vlr_6() {
    return p_vlr_6;
  }
  /**
    * P_VLR_6: Método Sets pára este campo.
    */
  public void setP_vlr_6(String PARAM) {
    p_vlr_6 = PARAM;
  }
  /**
    * P_QTD_02: Método Gets para este campo
    */
  public String getP_qtd_02() {
    return p_qtd_02;
  }
  /**
    * P_QTD_02: Método Sets pára este campo.
    */
  public void setP_qtd_02(String PARAM) {
    p_qtd_02 = PARAM;
  }
  /**
    * P_VLR_02: Método Gets para este campo
    */
  public String getP_vlr_02() {
    return p_vlr_02;
  }
  /**
    * P_VLR_02: Método Sets pára este campo.
    */
  public void setP_vlr_02(String PARAM) {
    p_vlr_02 = PARAM;
  }
  /**
    * P_PERC_02: Método Gets para este campo
    */
  public String getP_perc_02() {
    return p_perc_02;
  }
  /**
    * P_PERC_02: Método Sets pára este campo.
    */
  public void setP_perc_02(String PARAM) {
    p_perc_02 = PARAM;
  }
  /**
    * P_QTD_36: Método Gets para este campo
    */
  public String getP_qtd_36() {
    return p_qtd_36;
  }
  /**
    * P_QTD_36: Método Sets pára este campo.
    */
  public void setP_qtd_36(String PARAM) {
    p_qtd_36 = PARAM;
  }
  /**
    * P_VLR_36: Método Gets para este campo
    */
  public String getP_vlr_36() {
    return p_vlr_36;
  }
  /**
    * P_VLR_36: Método Sets pára este campo.
    */
  public void setP_vlr_36(String PARAM) {
    p_vlr_36 = PARAM;
  }
  /**
    * P_PERC_36: Método Gets para este campo
    */
  public String getP_perc_36() {
    return p_perc_36;
  }
  /**
    * P_PERC_36: Método Sets pára este campo.
    */
  public void setP_perc_36(String PARAM) {
    p_perc_36 = PARAM;
  }
  /**
    * P_QTD_720: Método Gets para este campo
    */
  public String getP_qtd_720() {
    return p_qtd_720;
  }
  /**
    * P_QTD_720: Método Sets pára este campo.
    */
  public void setP_qtd_720(String PARAM) {
    p_qtd_720 = PARAM;
  }
  /**
    * P_VLR_720: Método Gets para este campo
    */
  public String getP_vlr_720() {
    return p_vlr_720;
  }
  /**
    * P_VLR_720: Método Sets pára este campo.
    */
  public void setP_vlr_720(String PARAM) {
    p_vlr_720 = PARAM;
  }
  /**
    * P_PERC_720: Método Gets para este campo
    */
  public String getP_perc_720() {
    return p_perc_720;
  }
  /**
    * P_PERC_720: Método Sets pára este campo.
    */
  public void setP_perc_720(String PARAM) {
    p_perc_720 = PARAM;
  }
  /**
    * P_QTD_2130: Método Gets para este campo
    */
  public String getP_qtd_2130() {
    return p_qtd_2130;
  }
  /**
    * P_QTD_2130: Método Sets pára este campo.
    */
  public void setP_qtd_2130(String PARAM) {
    p_qtd_2130 = PARAM;
  }
  /**
    * P_VLR_2130: Método Gets para este campo
    */
  public String getP_vlr_2130() {
    return p_vlr_2130;
  }
  /**
    * P_VLR_2130: Método Sets pára este campo.
    */
  public void setP_vlr_2130(String PARAM) {
    p_vlr_2130 = PARAM;
  }
  /**
    * P_PERC_2130: Método Gets para este campo
    */
  public String getP_perc_2130() {
    return p_perc_2130;
  }
  /**
    * P_PERC_2130: Método Sets pára este campo.
    */
  public void setP_perc_2130(String PARAM) {
    p_perc_2130 = PARAM;
  }
  /**
    * P_QTD_A30: Método Gets para este campo
    */
  public String getP_qtd_a30() {
    return p_qtd_a30;
  }
  /**
    * P_QTD_A30: Método Sets pára este campo.
    */
  public void setP_qtd_a30(String PARAM) {
    p_qtd_a30 = PARAM;
  }
  /**
    * P_VLR_A30: Método Gets para este campo
    */
  public String getP_vlr_a30() {
    return p_vlr_a30;
  }
  /**
    * P_VLR_A30: Método Sets pára este campo.
    */
  public void setP_vlr_a30(String PARAM) {
    p_vlr_a30 = PARAM;
  }
  /**
    * P_PERC_A30: Método Gets para este campo
    */
  public String getP_perc_a30() {
    return p_perc_a30;
  }
  /**
    * P_PERC_A30: Método Sets pára este campo.
    */
  public void setP_perc_a30(String PARAM) {
    p_perc_a30 = PARAM;
  }
  /**
    * P_QTD_CAR: Método Gets para este campo
    */
  public String getP_qtd_car() {
    return p_qtd_car;
  }
  /**
    * P_QTD_CAR: Método Sets pára este campo.
    */
  public void setP_qtd_car(String PARAM) {
    p_qtd_car = PARAM;
  }
  /**
    * P_VLR_CAR: Método Gets para este campo
    */
  public String getP_vlr_car() {
    return p_vlr_car;
  }
  /**
    * P_VLR_CAR: Método Sets pára este campo.
    */
  public void setP_vlr_car(String PARAM) {
    p_vlr_car = PARAM;
  }
  /**
    * P_PERC_CAR: Método Gets para este campo
    */
  public String getP_perc_car() {
    return p_perc_car;
  }
  /**
    * P_PERC_CAR: Método Sets pára este campo.
    */
  public void setP_perc_car(String PARAM) {
    p_perc_car = PARAM;
  }
  /**
    * P_QTD_DEV: Método Gets para este campo
    */
  public String getP_qtd_dev() {
    return p_qtd_dev;
  }
  /**
    * P_QTD_DEV: Método Sets pára este campo.
    */
  public void setP_qtd_dev(String PARAM) {
    p_qtd_dev = PARAM;
  }
  /**
    * P_VLR_DEV: Método Gets para este campo
    */
  public String getP_vlr_dev() {
    return p_vlr_dev;
  }
  /**
    * P_VLR_DEV: Método Sets pára este campo.
    */
  public void setP_vlr_dev(String PARAM) {
    p_vlr_dev = PARAM;
  }
  /**
    * P_PERC_DEV: Método Gets para este campo
    */
  public String getP_perc_dev() {
    return p_perc_dev;
  }
  /**
    * P_PERC_DEV: Método Sets pára este campo.
    */
  public void setP_perc_dev(String PARAM) {
    p_perc_dev = PARAM;
  }
  /**
    * P_QTD_PRO: Método Gets para este campo
    */
  public String getP_qtd_pro() {
    return p_qtd_pro;
  }
  /**
    * P_QTD_PRO: Método Sets pára este campo.
    */
  public void setP_qtd_pro(String PARAM) {
    p_qtd_pro = PARAM;
  }
  /**
    * P_VLR_PRO: Método Gets para este campo
    */
  public String getP_vlr_pro() {
    return p_vlr_pro;
  }
  /**
    * P_VLR_PRO: Método Sets pára este campo.
    */
  public void setP_vlr_pro(String PARAM) {
    p_vlr_pro = PARAM;
  }
  /**
    * P_PERC_PRO: Método Gets para este campo
    */
  public String getP_perc_pro() {
    return p_perc_pro;
  }
  /**
    * P_PERC_PRO: Método Sets pára este campo.
    */
  public void setP_perc_pro(String PARAM) {
    p_perc_pro = PARAM;
  }
  /**
    * P_QTD_NEG_OK: Método Gets para este campo
    */
  public String getP_qtd_neg_ok() {
    return p_qtd_neg_ok;
  }
  /**
    * P_QTD_NEG_OK: Método Sets pára este campo.
    */
  public void setP_qtd_neg_ok(String PARAM) {
    p_qtd_neg_ok = PARAM;
  }
  /**
    * P_VLR_NEG_OK: Método Gets para este campo
    */
  public String getP_vlr_neg_ok() {
    return p_vlr_neg_ok;
  }
  /**
    * P_VLR_NEG_OK: Método Sets pára este campo.
    */
  public void setP_vlr_neg_ok(String PARAM) {
    p_vlr_neg_ok = PARAM;
  }
  /**
    * P_PERC_NEG_OK: Método Gets para este campo
    */
  public String getP_perc_neg_ok() {
    return p_perc_neg_ok;
  }
  /**
    * P_PERC_NEG_OK: Método Sets pára este campo.
    */
  public void setP_perc_neg_ok(String PARAM) {
    p_perc_neg_ok = PARAM;
  }
  /**
    * P_QTD_NEG_ENC: Método Gets para este campo
    */
  public String getP_qtd_neg_enc() {
    return p_qtd_neg_enc;
  }
  /**
    * P_QTD_NEG_ENC: Método Sets pára este campo.
    */
  public void setP_qtd_neg_enc(String PARAM) {
    p_qtd_neg_enc = PARAM;
  }
  /**
    * P_VLR_NEG_ENC: Método Gets para este campo
    */
  public String getP_vlr_neg_enc() {
    return p_vlr_neg_enc;
  }
  /**
    * P_VLR_NEG_ENC: Método Sets pára este campo.
    */
  public void setP_vlr_neg_enc(String PARAM) {
    p_vlr_neg_enc = PARAM;
  }
  /**
    * P_PERC_NEG_ENC: Método Gets para este campo
    */
  public String getP_perc_neg_enc() {
    return p_perc_neg_enc;
  }
  /**
    * P_PERC_NEG_ENC: Método Sets pára este campo.
    */
  public void setP_perc_neg_enc(String PARAM) {
    p_perc_neg_enc = PARAM;
  }
  /**
    * P_QTD_NEG_ABE: Método Gets para este campo
    */
  public String getP_qtd_neg_abe() {
    return p_qtd_neg_abe;
  }
  /**
    * P_QTD_NEG_ABE: Método Sets pára este campo.
    */
  public void setP_qtd_neg_abe(String PARAM) {
    p_qtd_neg_abe = PARAM;
  }
  /**
    * P_VLR_NEG_ABE: Método Gets para este campo
    */
  public String getP_vlr_neg_abe() {
    return p_vlr_neg_abe;
  }
  /**
    * P_VLR_NEG_ABE: Método Sets pára este campo.
    */
  public void setP_vlr_neg_abe(String PARAM) {
    p_vlr_neg_abe = PARAM;
  }
  /**
    * P_QTD_CHD_LIQ: Método Gets para este campo
    */
  public String getP_qtd_chd_liq() {
    return p_qtd_chd_liq;
  }
  /**
    * P_QTD_CHD_LIQ: Método Sets pára este campo.
    */
  public void setP_qtd_chd_liq(String PARAM) {
    p_qtd_chd_liq = PARAM;
  }
  /**
    * P_VLR_CHD_LIQ: Método Gets para este campo
    */
  public String getP_vlr_chd_liq() {
    return p_vlr_chd_liq;
  }
  /**
    * P_VLR_CHD_LIQ: Método Sets pára este campo.
    */
  public void setP_vlr_chd_liq(String PARAM) {
    p_vlr_chd_liq = PARAM;
  }
  /**
    * P_QTD_CHD_ABE: Método Gets para este campo
    */
  public String getP_qtd_chd_abe() {
    return p_qtd_chd_abe;
  }
  /**
    * P_QTD_CHD_ABE: Método Sets pára este campo.
    */
  public void setP_qtd_chd_abe(String PARAM) {
    p_qtd_chd_abe = PARAM;
  }
  /**
    * P_VLR_CHD_ABE: Método Gets para este campo
    */
  public String getP_vlr_chd_abe() {
    return p_vlr_chd_abe;
  }
  /**
    * P_VLR_CHD_ABE: Método Sets pára este campo.
    */
  public void setP_vlr_chd_abe(String PARAM) {
    p_vlr_chd_abe = PARAM;
  }
  /**
    * P_QTD_PRO_ABE: Método Gets para este campo
    */
  public String getP_qtd_pro_abe() {
    return p_qtd_pro_abe;
  }
  /**
    * P_QTD_PRO_ABE: Método Sets pára este campo.
    */
  public void setP_qtd_pro_abe(String PARAM) {
    p_qtd_pro_abe = PARAM;
  }
  /**
    * P_VLR_PRO_ABE: Método Gets para este campo
    */
  public String getP_vlr_pro_abe() {
    return p_vlr_pro_abe;
  }
  /**
    * P_VLR_PRO_ABE: Método Sets pára este campo.
    */
  public void setP_vlr_pro_abe(String PARAM) {
    p_vlr_pro_abe = PARAM;
  }
  /**
    * P_QTD_DIS_ABE: Método Gets para este campo
    */
  public String getP_qtd_dis_abe() {
    return p_qtd_dis_abe;
  }
  /**
    * P_QTD_DIS_ABE: Método Sets pára este campo.
    */
  public void setP_qtd_dis_abe(String PARAM) {
    p_qtd_dis_abe = PARAM;
  }
  /**
    * P_VLR_DIS_ABE: Método Gets para este campo
    */
  public String getP_vlr_dis_abe() {
    return p_vlr_dis_abe;
  }
  /**
    * P_VLR_DIS_ABE: Método Sets pára este campo.
    */
  public void setP_vlr_dis_abe(String PARAM) {
    p_vlr_dis_abe = PARAM;
  }
  /**
    * P_QTD_FORA_PEND: Método Gets para este campo
    */
  public String getP_qtd_fora_pend() {
    return p_qtd_fora_pend;
  }
  /**
    * P_QTD_FORA_PEND: Método Sets pára este campo.
    */
  public void setP_qtd_fora_pend(String PARAM) {
    p_qtd_fora_pend = PARAM;
  }
  /**
    * P_VLR_FORA_PEND: Método Gets para este campo
    */
  public String getP_vlr_fora_pend() {
    return p_vlr_fora_pend;
  }
  /**
    * P_VLR_FORA_PEND: Método Sets pára este campo.
    */
  public void setP_vlr_fora_pend(String PARAM) {
    p_vlr_fora_pend = PARAM;
  }
  /**
    * P_QTD_TIT_ABE: Método Gets para este campo
    */
  public String getP_qtd_tit_abe() {
    return p_qtd_tit_abe;
  }
  /**
    * P_QTD_TIT_ABE: Método Sets pára este campo.
    */
  public void setP_qtd_tit_abe(String PARAM) {
    p_qtd_tit_abe = PARAM;
  }
  /**
    * P_VLR_TIT_ABE: Método Gets para este campo
    */
  public String getP_vlr_tit_abe() {
    return p_vlr_tit_abe;
  }
  /**
    * P_VLR_TIT_ABE: Método Sets pára este campo.
    */
  public void setP_vlr_tit_abe(String PARAM) {
    p_vlr_tit_abe = PARAM;
  }
  /**
    * P_QTD_AP_ATE: Método Gets para este campo
    */
  public String getP_qtd_ap_ate() {
    return p_qtd_ap_ate;
  }
  /**
    * P_QTD_AP_ATE: Método Sets pára este campo.
    */
  public void setP_qtd_ap_ate(String PARAM) {
    p_qtd_ap_ate = PARAM;
  }
  /**
    * P_VLR_AP_ATE: Método Gets para este campo
    */
  public String getP_vlr_ap_ate() {
    return p_vlr_ap_ate;
  }
  /**
    * P_VLR_AP_ATE: Método Sets pára este campo.
    */
  public void setP_vlr_ap_ate(String PARAM) {
    p_vlr_ap_ate = PARAM;
  }
  /**
    * P_QTD_AP_APO: Método Gets para este campo
    */
  public String getP_qtd_ap_apo() {
    return p_qtd_ap_apo;
  }
  /**
    * P_QTD_AP_APO: Método Sets pára este campo.
    */
  public void setP_qtd_ap_apo(String PARAM) {
    p_qtd_ap_apo = PARAM;
  }
  /**
    * P_VLR_AP_APO: Método Gets para este campo
    */
  public String getP_vlr_ap_apo() {
    return p_vlr_ap_apo;
  }
  /**
    * P_VLR_AP_APO: Método Sets pára este campo.
    */
  public void setP_vlr_ap_apo(String PARAM) {
    p_vlr_ap_apo = PARAM;
  }
  /**
    * P_QTD_VE_ATE: Método Gets para este campo
    */
  public String getP_qtd_ve_ate() {
    return p_qtd_ve_ate;
  }
  /**
    * P_QTD_VE_ATE: Método Sets pára este campo.
    */
  public void setP_qtd_ve_ate(String PARAM) {
    p_qtd_ve_ate = PARAM;
  }
  /**
    * P_VLR_VE_ATE: Método Gets para este campo
    */
  public String getP_vlr_ve_ate() {
    return p_vlr_ve_ate;
  }
  /**
    * P_VLR_VE_ATE: Método Sets pára este campo.
    */
  public void setP_vlr_ve_ate(String PARAM) {
    p_vlr_ve_ate = PARAM;
  }
  /**
    * P_QTD_VE_APO: Método Gets para este campo
    */
  public String getP_qtd_ve_apo() {
    return p_qtd_ve_apo;
  }
  /**
    * P_QTD_VE_APO: Método Sets pára este campo.
    */
  public void setP_qtd_ve_apo(String PARAM) {
    p_qtd_ve_apo = PARAM;
  }
  /**
    * P_VLR_VE_APO: Método Gets para este campo
    */
  public String getP_vlr_ve_apo() {
    return p_vlr_ve_apo;
  }
  /**
    * P_VLR_VE_APO: Método Sets pára este campo.
    */
  public void setP_vlr_ve_apo(String PARAM) {
    p_vlr_ve_apo = PARAM;
  }
  /**
    * P_QTD_TOT_AVE: Método Gets para este campo
    */
  public String getP_qtd_tot_ave() {
    return p_qtd_tot_ave;
  }
  /**
    * P_QTD_TOT_AVE: Método Sets pára este campo.
    */
  public void setP_qtd_tot_ave(String PARAM) {
    p_qtd_tot_ave = PARAM;
  }
  /**
    * P_VLR_TOT_AVE: Método Gets para este campo
    */
  public String getP_vlr_tot_ave() {
    return p_vlr_tot_ave;
  }
  /**
    * P_VLR_TOT_AVE: Método Sets pára este campo.
    */
  public void setP_vlr_tot_ave(String PARAM) {
    p_vlr_tot_ave = PARAM;
  }
  /**
    * P_QTD_TOT_VEN: Método Gets para este campo
    */
  public String getP_qtd_tot_ven() {
    return p_qtd_tot_ven;
  }
  /**
    * P_QTD_TOT_VEN: Método Sets pára este campo.
    */
  public void setP_qtd_tot_ven(String PARAM) {
    p_qtd_tot_ven = PARAM;
  }
  /**
    * P_VLR_TOT_VEN: Método Gets para este campo
    */
  public String getP_vlr_tot_ven() {
    return p_vlr_tot_ven;
  }
  /**
    * P_VLR_TOT_VEN: Método Sets pára este campo.
    */
  public void setP_vlr_tot_ven(String PARAM) {
    p_vlr_tot_ven = PARAM;
  }
  /**
    * P_PERC_VEN: Método Gets para este campo
    */
  public String getP_perc_ven() {
    return p_perc_ven;
  }
  /**
    * P_PERC_VEN: Método Sets pára este campo.
    */
  public void setP_perc_ven(String PARAM) {
    p_perc_ven = PARAM;
  }
  /**
    * P_QTD_TOT_GER: Método Gets para este campo
    */
  public String getP_qtd_tot_ger() {
    return p_qtd_tot_ger;
  }
  /**
    * P_QTD_TOT_GER: Método Sets pára este campo.
    */
  public void setP_qtd_tot_ger(String PARAM) {
    p_qtd_tot_ger = PARAM;
  }
  /**
    * P_VLR_TOT_GER: Método Gets para este campo
    */
  public String getP_vlr_tot_ger() {
    return p_vlr_tot_ger;
  }
  /**
    * P_VLR_TOT_GER: Método Sets pára este campo.
    */
  public void setP_vlr_tot_ger(String PARAM) {
    p_vlr_tot_ger = PARAM;
  }
  /**
    * P_QTD_PED_ABE_NLIB: Método Gets para este campo
    */
  public String getP_qtd_ped_abe_nlib() {
    return p_qtd_ped_abe_nlib;
  }
  /**
    * P_QTD_PED_ABE_NLIB: Método Sets pára este campo.
    */
  public void setP_qtd_ped_abe_nlib(String PARAM) {
    p_qtd_ped_abe_nlib = PARAM;
  }
  /**
    * P_VLR_PED_ABE_NLIB: Método Gets para este campo
    */
  public String getP_vlr_ped_abe_nlib() {
    return p_vlr_ped_abe_nlib;
  }
  /**
    * P_VLR_PED_ABE_NLIB: Método Sets pára este campo.
    */
  public void setP_vlr_ped_abe_nlib(String PARAM) {
    p_vlr_ped_abe_nlib = PARAM;
  }
  /**
    * P_QTD_PED_ABE_LIB: Método Gets para este campo
    */
  public String getP_qtd_ped_abe_lib() {
    return p_qtd_ped_abe_lib;
  }
  /**
    * P_QTD_PED_ABE_LIB: Método Sets pára este campo.
    */
  public void setP_qtd_ped_abe_lib(String PARAM) {
    p_qtd_ped_abe_lib = PARAM;
  }
  /**
    * P_VLR_PED_ABE_LIB: Método Gets para este campo
    */
  public String getP_vlr_ped_abe_lib() {
    return p_vlr_ped_abe_lib;
  }
  /**
    * P_VLR_PED_ABE_LIB: Método Sets pára este campo.
    */
  public void setP_vlr_ped_abe_lib(String PARAM) {
    p_vlr_ped_abe_lib = PARAM;
  }
  /**
    * P_LIMITE: Método Gets para este campo
    */
  public String getP_limite() {
    return p_limite;
  }
  /**
    * P_LIMITE: Método Sets pára este campo.
    */
  public void setP_limite(String PARAM) {
    p_limite = PARAM;
  }
  /**
    * P_SALDO: Método Gets para este campo
    */
  public String getP_saldo() {
    return p_saldo;
  }
  /**
    * P_SALDO: Método Sets pára este campo.
    */
  public void setP_saldo(String PARAM) {
    p_saldo = PARAM;
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
    * ATE20_1: Método Gets para este campo
    */
  public String getAte20_1() {
    return ate20_1;
  }
  /**
    * ATE20_1: Método Sets pára este campo.
    */
  public void setAte20_1(String PARAM) {
    ate20_1 = PARAM;
  }
  /**
    * ATE20_2: Método Gets para este campo
    */
  public String getAte20_2() {
    return ate20_2;
  }
  /**
    * ATE20_2: Método Sets pára este campo.
    */
  public void setAte20_2(String PARAM) {
    ate20_2 = PARAM;
  }
  /**
    * ATE20_3: Método Gets para este campo
    */
  public String getAte20_3() {
    return ate20_3;
  }
  /**
    * ATE20_3: Método Sets pára este campo.
    */
  public void setAte20_3(String PARAM) {
    ate20_3 = PARAM;
  }
  /**
    * ATE20_4: Método Gets para este campo
    */
  public String getAte20_4() {
    return ate20_4;
  }
  /**
    * ATE20_4: Método Sets pára este campo.
    */
  public void setAte20_4(String PARAM) {
    ate20_4 = PARAM;
  }
  /**
    * GRE_DESCRICAO: Método Gets para este campo
    */
  public String getGre_descricao() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (gre_grupo != null && gre_grupo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Grupo_economico db_object = new portalbr.dbobj.table.Grupo_economico();
        Object[][] where = { {"gre_grupo","=",com.egen.util.text.FormatNumber.toInt(gre_grupo)} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Grupo_economico) results.elementAt(0);
          fieldRelationValue = (db_object.getGre_descricao() != null) ? db_object.getGre_descricao() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    gre_descricao = fieldRelationValue;
    return gre_descricao;
  }
  /**
    * GRE_DESCRICAO: Método Sets pára este campo.
    */
  public void setGre_descricao(String PARAM) {
    gre_descricao = PARAM;
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * EMP_EMPRESA: Método Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Método Sets pára este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * GRE_GRUPO: Método Gets para este campo
    */
  public String getGre_grupo() {
    return gre_grupo;
  }
  /**
    * GRE_GRUPO: Método Sets pára este campo.
    */
  public void setGre_grupo(String PARAM) {
    gre_grupo = PARAM;
  }
  /**
    * DDN_QTDE: Método Gets para este campo
    */
  public String getDdn_qtde() {
    return ddn_qtde;
  }
  /**
    * DDN_QTDE: Método Sets pára este campo.
    */
  public void setDdn_qtde(String PARAM) {
    ddn_qtde = PARAM;
  }
  /**
    * DDN_VALOR: Método Gets para este campo
    */
  public String getDdn_valor() {
    return ddn_valor;
  }
  /**
    * DDN_VALOR: Método Sets pára este campo.
    */
  public void setDdn_valor(String PARAM) {
    ddn_valor = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    p_clientes = null;
    p_cli_cdgo = null;
    cli_rzao = null;
    p_grupo_economico = null;
    p_meses_atras = null;
    p_emp = null;
    emp_razsoc = null;
    p_pri_compra = null;
    p_vlr_pri_compra = null;
    p_ult_compra = null;
    p_vlr_ult_compra = null;
    p_mai_compra = null;
    p_vlr_mai_compra = null;
    p_qtd_12 = null;
    p_vlr_12 = null;
    p_qtd_6 = null;
    p_vlr_6 = null;
    p_qtd_02 = null;
    p_vlr_02 = null;
    p_perc_02 = null;
    p_qtd_36 = null;
    p_vlr_36 = null;
    p_perc_36 = null;
    p_qtd_720 = null;
    p_vlr_720 = null;
    p_perc_720 = null;
    p_qtd_2130 = null;
    p_vlr_2130 = null;
    p_perc_2130 = null;
    p_qtd_a30 = null;
    p_vlr_a30 = null;
    p_perc_a30 = null;
    p_qtd_car = null;
    p_vlr_car = null;
    p_perc_car = null;
    p_qtd_dev = null;
    p_vlr_dev = null;
    p_perc_dev = null;
    p_qtd_pro = null;
    p_vlr_pro = null;
    p_perc_pro = null;
    p_qtd_neg_ok = null;
    p_vlr_neg_ok = null;
    p_perc_neg_ok = null;
    p_qtd_neg_enc = null;
    p_vlr_neg_enc = null;
    p_perc_neg_enc = null;
    p_qtd_neg_abe = null;
    p_vlr_neg_abe = null;
    p_qtd_chd_liq = null;
    p_vlr_chd_liq = null;
    p_qtd_chd_abe = null;
    p_vlr_chd_abe = null;
    p_qtd_pro_abe = null;
    p_vlr_pro_abe = null;
    p_qtd_dis_abe = null;
    p_vlr_dis_abe = null;
    p_qtd_fora_pend = null;
    p_vlr_fora_pend = null;
    p_qtd_tit_abe = null;
    p_vlr_tit_abe = null;
    p_qtd_ap_ate = null;
    p_vlr_ap_ate = null;
    p_qtd_ap_apo = null;
    p_vlr_ap_apo = null;
    p_qtd_ve_ate = null;
    p_vlr_ve_ate = null;
    p_qtd_ve_apo = null;
    p_vlr_ve_apo = null;
    p_qtd_tot_ave = null;
    p_vlr_tot_ave = null;
    p_qtd_tot_ven = null;
    p_vlr_tot_ven = null;
    p_perc_ven = null;
    p_qtd_tot_ger = null;
    p_vlr_tot_ger = null;
    p_qtd_ped_abe_nlib = null;
    p_vlr_ped_abe_nlib = null;
    p_qtd_ped_abe_lib = null;
    p_vlr_ped_abe_lib = null;
    p_limite = null;
    p_saldo = null;
    p_erro = null;
    ate20_1 = null;
    ate20_2 = null;
    ate20_3 = null;
    ate20_4 = null;
    gre_descricao = null;
    cli_cdgo = null;
    emp_empresa = null;
    gre_grupo = null;
    ddn_qtde = null;
    ddn_valor = null;
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
