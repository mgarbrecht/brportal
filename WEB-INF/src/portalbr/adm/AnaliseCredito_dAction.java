package portalbr.adm;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/08/2006 16:04:41
 * Last Modify Date 06/05/2022 11:11:44
 */

public class AnaliseCredito_dAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_execute_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      execute_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_ctr_his_pgtos_an", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void execute_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AnaliseCredito_dActionForm f = (AnaliseCredito_dActionForm) form;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    Double ddn_valor = 0.0;
    try {
      portalbr.dbobj.procedure.Prc_ctr_his_pgtos_an r = new portalbr.dbobj.procedure.Prc_ctr_his_pgtos_an();
      r.setP_clientes(f.getP_clientes());
      r.setP_cli_cdgo(com.egen.util.text.FormatNumber.parseDouble(f.getP_cli_cdgo()));
      r.setP_grupo_economico(com.egen.util.text.FormatNumber.parseDouble(f.getP_grupo_economico()));
      r.setP_meses_atras(com.egen.util.text.FormatNumber.parseDouble(f.getP_meses_atras()));
      r.setP_emp(f.getP_emp());
      r.setP_pri_compra(f.getP_pri_compra());
      r.setP_vlr_pri_compra(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_pri_compra()));
      r.setP_ult_compra(f.getP_ult_compra());
      r.setP_vlr_ult_compra(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ult_compra()));
      r.setP_mai_compra(f.getP_mai_compra());
      r.setP_vlr_mai_compra(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_mai_compra()));
      r.setP_qtd_12(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_12()));
      r.setP_vlr_12(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_12()));
      r.setP_qtd_6(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_6()));
      r.setP_vlr_6(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_6()));
      r.setP_qtd_02(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_02()));
      r.setP_vlr_02(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_02()));
      r.setP_perc_02(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_02()));
      r.setP_qtd_36(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_36()));
      r.setP_vlr_36(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_36()));
      r.setP_perc_36(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_36()));
      r.setP_qtd_720(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_720()));
      r.setP_vlr_720(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_720()));
      r.setP_perc_720(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_720()));
      r.setP_qtd_2130(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_2130()));
      r.setP_vlr_2130(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_2130()));
      r.setP_perc_2130(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_2130()));
      r.setP_qtd_a30(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_a30()));
      r.setP_vlr_a30(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_a30()));
      r.setP_perc_a30(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_a30()));
      r.setP_qtd_car(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_car()));
      r.setP_vlr_car(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_car()));
      r.setP_perc_car(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_car()));
      r.setP_qtd_dev(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_dev()));
      r.setP_vlr_dev(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_dev()));
      r.setP_perc_dev(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_dev()));
      r.setP_qtd_pro(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_pro()));
      r.setP_vlr_pro(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_pro()));
      r.setP_perc_pro(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_pro()));
      r.setP_qtd_neg_ok(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_neg_ok()));
      r.setP_vlr_neg_ok(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_neg_ok()));
      r.setP_perc_neg_ok(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_neg_ok()));
      r.setP_qtd_neg_enc(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_neg_enc()));
      r.setP_vlr_neg_enc(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_neg_enc()));
      r.setP_perc_neg_enc(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_neg_enc()));
      r.setP_qtd_neg_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_neg_abe()));
      r.setP_vlr_neg_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_neg_abe()));
      r.setP_qtd_chd_liq(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_chd_liq()));
      r.setP_vlr_chd_liq(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_chd_liq()));
      r.setP_qtd_chd_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_chd_abe()));
      r.setP_vlr_chd_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_chd_abe()));
      r.setP_qtd_pro_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_pro_abe()));
      r.setP_vlr_pro_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_pro_abe()));
      r.setP_qtd_dis_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_dis_abe()));
      r.setP_vlr_dis_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_dis_abe()));
      r.setP_qtd_fora_pend(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_fora_pend()));
      r.setP_vlr_fora_pend(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_fora_pend()));
      r.setP_qtd_tit_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_tit_abe()));
      r.setP_vlr_tit_abe(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_tit_abe()));
      r.setP_qtd_ap_ate(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_ap_ate()));
      r.setP_vlr_ap_ate(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ap_ate()));
      r.setP_qtd_ap_apo(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_ap_apo()));
      r.setP_vlr_ap_apo(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ap_apo()));
      r.setP_qtd_ve_ate(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_ve_ate()));
      r.setP_vlr_ve_ate(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ve_ate()));
      r.setP_qtd_ve_apo(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_ve_apo()));
      r.setP_vlr_ve_apo(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ve_apo()));
      r.setP_qtd_tot_ave(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_tot_ave()));
      r.setP_vlr_tot_ave(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_tot_ave()));
      r.setP_qtd_tot_ven(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_tot_ven()));
      r.setP_vlr_tot_ven(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_tot_ven()));
      r.setP_perc_ven(com.egen.util.text.FormatNumber.parseDouble(f.getP_perc_ven()));
      r.setP_qtd_tot_ger(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_tot_ger()));
      r.setP_vlr_tot_ger(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_tot_ger()));
      r.setP_qtd_ped_abe_nlib(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_ped_abe_nlib()));
      r.setP_vlr_ped_abe_nlib(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ped_abe_nlib()));
      r.setP_qtd_ped_abe_lib(com.egen.util.text.FormatNumber.parseDouble(f.getP_qtd_ped_abe_lib()));
      r.setP_vlr_ped_abe_lib(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ped_abe_lib()));
      r.setP_limite(com.egen.util.text.FormatNumber.parseDouble(f.getP_limite()));
      r.setP_qtd_fis_abe(0d);
      r.setP_vlr_fis_abe(0d);
      r.setP_saldo(com.egen.util.text.FormatNumber.parseDouble(f.getP_saldo()));
      r.setP_erro(f.getP_erro());


      // ----- Dados -----
      Jw_analise_credito_dados table = new Jw_analise_credito_dados();
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT 0 cli_codigo ");
      sb.append("      , 0 esc_seqn ");
      sb.append("      , COUNT(*) ddn_qtde ");
      sb.append("      , sum(NVL(SUM(fnc_ctr_saldo_titulo(t.emp_empresa, t.fil_filial, t.tip_codigo, t.tit_codigo, t.sit_codigo_situacao_titulo, t.tit_vlpcp, t.tit_vldeb)), 0)) ddn_valor ");
      sb.append("   FROM titulos t ");
      sb.append("  WHERE t.tip_codigo = 'DDN' ");
      sb.append("    AND t.tit_status = 'A' ");
      if (f.getCli_cdgo() != null) {
        sb.append(" AND t.cli_codigo = " + f.getCli_cdgo());
      }
      if (f.getGre_grupo() != null) {
        sb.append("    AND t.cli_codigo IN (SELECT gre.cli_cdgo ");
        sb.append("                           FROM grupo_economico gre ");
        sb.append("                          WHERE gre.gre_grupo = " + f.getGre_grupo());
        sb.append("                            AND gre.status = 'A') ");
      }
      sb.append("  GROUP BY t.cli_codigo ");
      sb.append("         , t.esc_seqn ");

      int ddnQtde = 0;
      double ddnValor = 0d;

      Vector res_Jw_analise_credito_dados = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_analise_credito_dados",res_Jw_analise_credito_dados);
      if (res_Jw_analise_credito_dados != null && res_Jw_analise_credito_dados.size() > 0) {
        Jw_analise_credito_dados rd = (Jw_analise_credito_dados) res_Jw_analise_credito_dados.elementAt(0);
        f.setDdn_qtde((rd.getDdn_qtde() != null) ? rd.getDdn_qtde() + "":"0");
        ddnQtde = (rd.getDdn_qtde() != null ? rd.getDdn_qtde() : 0);
        f.setDdn_valor((rd.getDdn_valor() != null) ? com.egen.util.text.FormatNumber.format(rd.getDdn_valor(), "##,##0.00") : com.egen.util.text.FormatNumber.format(0d, "##,##0.00"));
        ddnValor = (rd.getDdn_valor() != null ? rd.getDdn_valor() : 0d);
        ddn_valor = rd.getDdn_valor() != null ? rd.getDdn_valor() : 0.0;
      } else {
        f.setDdn_qtde("0");
        f.setDdn_valor(com.egen.util.text.FormatNumber.format(0d, "##,##0.00"));
      }

      // -----------------
      r = (portalbr.dbobj.procedure.Prc_ctr_his_pgtos_an) j.execute(r);
      if (r != null) {
        f.setP_clientes((r.getP_clientes() != null) ? r.getP_clientes() + "":"");
        f.setP_cli_cdgo(com.egen.util.text.FormatNumber.format(r.getP_cli_cdgo(), "0"));
        f.setP_grupo_economico(com.egen.util.text.FormatNumber.format(r.getP_grupo_economico(), "0"));
        f.setP_meses_atras(com.egen.util.text.FormatNumber.format(r.getP_meses_atras(), "0"));
        f.setP_emp((r.getP_emp() != null) ? r.getP_emp() + "":"");
        f.setP_pri_compra((r.getP_pri_compra() != null) ? r.getP_pri_compra() + "":"");
        f.setP_vlr_pri_compra(com.egen.util.text.FormatNumber.format(r.getP_vlr_pri_compra(), "##,##0.00"));
        f.setP_ult_compra((r.getP_ult_compra() != null) ? r.getP_ult_compra() + "":"");
        f.setP_vlr_ult_compra(com.egen.util.text.FormatNumber.format(r.getP_vlr_ult_compra(), "##,##0.00"));
        f.setP_mai_compra((r.getP_mai_compra() != null) ? r.getP_mai_compra() + "":"");
        f.setP_vlr_mai_compra(com.egen.util.text.FormatNumber.format(r.getP_vlr_mai_compra(), "##,##0.00"));
        f.setP_qtd_12(com.egen.util.text.FormatNumber.format(r.getP_qtd_12(), "0"));
        f.setP_vlr_12(com.egen.util.text.FormatNumber.format(r.getP_vlr_12(), "##,##0.00"));
        f.setP_qtd_6(com.egen.util.text.FormatNumber.format(r.getP_qtd_6(), "0"));
        f.setP_vlr_6(com.egen.util.text.FormatNumber.format(r.getP_vlr_6(), "##,##0.00"));
        f.setP_qtd_02(com.egen.util.text.FormatNumber.format(r.getP_qtd_02(), "0"));
        f.setP_vlr_02(com.egen.util.text.FormatNumber.format(r.getP_vlr_02(), "##,##0.00"));
        f.setP_perc_02(com.egen.util.text.FormatNumber.format(r.getP_perc_02(), "##,##0.00"));
        f.setP_qtd_36(com.egen.util.text.FormatNumber.format(r.getP_qtd_36(), "0"));
        f.setP_vlr_36(com.egen.util.text.FormatNumber.format(r.getP_vlr_36(), "##,##0.00"));
        f.setP_perc_36(com.egen.util.text.FormatNumber.format(r.getP_perc_36(), "##,##0.00"));
        f.setP_qtd_720(com.egen.util.text.FormatNumber.format(r.getP_qtd_720(), "0"));
        f.setP_vlr_720(com.egen.util.text.FormatNumber.format(r.getP_vlr_720(), "##,##0.00"));
        f.setP_perc_720(com.egen.util.text.FormatNumber.format(r.getP_perc_720(), "##,##0.00"));
        f.setP_qtd_2130(com.egen.util.text.FormatNumber.format(r.getP_qtd_2130(), "0"));
        f.setP_vlr_2130(com.egen.util.text.FormatNumber.format(r.getP_vlr_2130(), "##,##0.00"));
        f.setP_perc_2130(com.egen.util.text.FormatNumber.format(r.getP_perc_2130(), "##,##0.00"));
        f.setP_qtd_a30(com.egen.util.text.FormatNumber.format(r.getP_qtd_a30(), "0"));
        f.setP_vlr_a30(com.egen.util.text.FormatNumber.format(r.getP_vlr_a30(), "##,##0.00"));
        f.setP_perc_a30(com.egen.util.text.FormatNumber.format(r.getP_perc_a30(), "##,##0.00"));
        f.setP_qtd_car(com.egen.util.text.FormatNumber.format(r.getP_qtd_car(), "0"));
        f.setP_vlr_car(com.egen.util.text.FormatNumber.format(r.getP_vlr_car(), "##,##0.00"));
        f.setP_perc_car(com.egen.util.text.FormatNumber.format(r.getP_perc_car(), "##,##0.00"));
        f.setP_qtd_dev(com.egen.util.text.FormatNumber.format(r.getP_qtd_dev(), "0"));
        f.setP_vlr_dev(com.egen.util.text.FormatNumber.format(r.getP_vlr_dev(), "##,##0.00"));
        f.setP_perc_dev(com.egen.util.text.FormatNumber.format(r.getP_perc_dev(), "##,##0.00"));
        f.setP_qtd_pro(com.egen.util.text.FormatNumber.format(r.getP_qtd_pro(), "0"));
        f.setP_vlr_pro(com.egen.util.text.FormatNumber.format(r.getP_vlr_pro(), "##,##0.00"));
        f.setP_perc_pro(com.egen.util.text.FormatNumber.format(r.getP_perc_pro(), "##,##0.00"));
        f.setP_qtd_neg_ok(com.egen.util.text.FormatNumber.format(r.getP_qtd_neg_ok(), "0"));
        f.setP_vlr_neg_ok(com.egen.util.text.FormatNumber.format(r.getP_vlr_neg_ok(), "##,##0.00"));
        f.setP_perc_neg_ok(com.egen.util.text.FormatNumber.format(r.getP_perc_neg_ok(), "##,##0.00"));
        f.setP_qtd_neg_enc(com.egen.util.text.FormatNumber.format(r.getP_qtd_neg_enc(), "0"));
        f.setP_vlr_neg_enc(com.egen.util.text.FormatNumber.format(r.getP_vlr_neg_enc(), "##,##0.00"));
        f.setP_perc_neg_enc(com.egen.util.text.FormatNumber.format(r.getP_perc_neg_enc(), "##,##0.00"));
        f.setP_qtd_neg_abe(com.egen.util.text.FormatNumber.format(r.getP_qtd_neg_abe(), "0"));
        f.setP_vlr_neg_abe(com.egen.util.text.FormatNumber.format(r.getP_vlr_neg_abe(), "##,##0.00"));
        f.setP_qtd_chd_liq(com.egen.util.text.FormatNumber.format(r.getP_qtd_chd_liq(), "0"));
        f.setP_vlr_chd_liq(com.egen.util.text.FormatNumber.format(r.getP_vlr_chd_liq(), "##,##0.00"));
        f.setP_qtd_chd_abe(com.egen.util.text.FormatNumber.format(r.getP_qtd_chd_abe(), "0"));
        f.setP_vlr_chd_abe(com.egen.util.text.FormatNumber.format(r.getP_vlr_chd_abe(), "##,##0.00"));
        f.setP_qtd_pro_abe(com.egen.util.text.FormatNumber.format(r.getP_qtd_pro_abe(), "0"));
        f.setP_vlr_pro_abe(com.egen.util.text.FormatNumber.format(r.getP_vlr_pro_abe(), "##,##0.00"));
        f.setP_qtd_dis_abe(com.egen.util.text.FormatNumber.format(r.getP_qtd_dis_abe(), "0"));
        f.setP_vlr_dis_abe(com.egen.util.text.FormatNumber.format(r.getP_vlr_dis_abe(), "##,##0.00"));
        f.setP_qtd_fora_pend(com.egen.util.text.FormatNumber.format(r.getP_qtd_fora_pend(), "0"));
        f.setP_vlr_fora_pend(com.egen.util.text.FormatNumber.format(r.getP_vlr_fora_pend(), "##,##0.00"));
        f.setP_qtd_tit_abe(com.egen.util.text.FormatNumber.format(r.getP_qtd_tit_abe(), "0"));
        f.setP_vlr_tit_abe(com.egen.util.text.FormatNumber.format(r.getP_vlr_tit_abe(), "##,##0.00"));
        f.setP_qtd_ap_ate(com.egen.util.text.FormatNumber.format(r.getP_qtd_ap_ate(), "0"));
        f.setP_vlr_ap_ate(com.egen.util.text.FormatNumber.format(r.getP_vlr_ap_ate(), "##,##0.00"));
        f.setP_qtd_ap_apo(com.egen.util.text.FormatNumber.format(r.getP_qtd_ap_apo(), "0"));
        f.setP_vlr_ap_apo(com.egen.util.text.FormatNumber.format(r.getP_vlr_ap_apo(), "##,##0.00"));
        f.setP_qtd_ve_ate(com.egen.util.text.FormatNumber.format(r.getP_qtd_ve_ate(), "0"));
        f.setP_vlr_ve_ate(com.egen.util.text.FormatNumber.format(r.getP_vlr_ve_ate(), "##,##0.00"));
        f.setP_qtd_ve_apo(com.egen.util.text.FormatNumber.format(r.getP_qtd_ve_apo(), "0"));
        f.setP_vlr_ve_apo(com.egen.util.text.FormatNumber.format(r.getP_vlr_ve_apo(), "##,##0.00"));
        f.setP_qtd_tot_ave(com.egen.util.text.FormatNumber.format(r.getP_qtd_tot_ave(), "0"));
        f.setP_vlr_tot_ave(com.egen.util.text.FormatNumber.format(r.getP_vlr_tot_ave(), "##,##0.00"));
        f.setP_qtd_tot_ven(com.egen.util.text.FormatNumber.format(r.getP_qtd_tot_ven(), "0"));
        f.setP_vlr_tot_ven(com.egen.util.text.FormatNumber.format(r.getP_vlr_tot_ven(), "##,##0.00"));
        f.setP_perc_ven(com.egen.util.text.FormatNumber.format(r.getP_perc_ven(), "##,##0.00"));
        f.setP_qtd_tot_ger(com.egen.util.text.FormatNumber.format(r.getP_qtd_tot_ger() + ddnQtde, "0"));
        f.setP_vlr_tot_ger(com.egen.util.text.FormatNumber.format(r.getP_vlr_tot_ger() + ddnValor, "##,##0.00"));
        f.setP_qtd_ped_abe_nlib(com.egen.util.text.FormatNumber.format(r.getP_qtd_ped_abe_nlib(), "0"));
        f.setP_vlr_ped_abe_nlib(com.egen.util.text.FormatNumber.format(r.getP_vlr_ped_abe_nlib(), "##,##0.00"));
        f.setP_qtd_ped_abe_lib(com.egen.util.text.FormatNumber.format(r.getP_qtd_ped_abe_lib(), "0"));
        f.setP_vlr_ped_abe_lib(com.egen.util.text.FormatNumber.format(r.getP_vlr_ped_abe_lib(), "##,##0.00"));
        f.setP_limite(com.egen.util.text.FormatNumber.format(r.getP_limite(), "##,##0.00"));
        //		f.setP_saldo(com.egen.util.text.FormatNumber.format((r.getP_saldo()-ddn_valor), "##,##0.00"));
        f.setP_saldo(com.egen.util.text.FormatNumber.format((r.getP_saldo()), "##,##0.00"));
        f.setP_erro((r.getP_erro() != null) ? r.getP_erro() + "":"");
        //------------------
        pstm = j.getConn().prepareStatement(" SELECT distinct cli_nro_dias_atraso_credito FROM cli WHERE cli_cdgo = ? ");
        if (f.getP_clientes() != "") {
          pstm.setString(1, f.getP_clientes().substring(1, f.getP_clientes().indexOf("'",1)));
        } else {
          pstm.setString(1, Integer.parseInt(com.egen.util.text.FormatNumber.format(Double.parseDouble(f.getP_cli_cdgo()), "0")) + "");
        }
        rset = pstm.executeQuery();
        if (rset.next()) {
          f.setAte20_1(rset.getString(1));
          f.setAte20_2(rset.getString(1));
          f.setAte20_3(rset.getString(1));
          f.setAte20_4(rset.getString(1));
        }
        //-------------------
      }

    }
    finally {
      if (rset != null) {
        rset.close();
      }
      if (pstm != null) {
        pstm.close();
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/adm/AnaliseCreditoForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_ctr_his_pgtos_an", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {

    }
    return actionForward;
  }
}
