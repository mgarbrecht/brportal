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
 * Creation Date 23/08/2006 15:45:57
 * Last Modify Date 24/01/2019 09:44:46
 */

public class AnaliseCredito_deAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_ctr_pend_aberta", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    AnaliseCredito_deActionForm f = (AnaliseCredito_deActionForm) form;
    portalbr.dbobj.procedure.Prc_ctr_pend_aberta r = new portalbr.dbobj.procedure.Prc_ctr_pend_aberta();
    r.setP_clientes(f.getP_clientes());
    r.setP_cli_cdgo(com.egen.util.text.FormatNumber.parseDouble(f.getP_cli_cdgo()));
    r.setP_grupo_economico(com.egen.util.text.FormatNumber.parseDouble(f.getP_grupo_economico()));
    r.setP_emp(f.getP_emp());
    r.setP_dias1(com.egen.util.text.FormatNumber.parseDouble(f.getP_dias1()));
    r.setP_dias2(com.egen.util.text.FormatNumber.parseDouble(f.getP_dias2()));
    r.setP_mes_1(f.getP_mes_1());
    r.setP_mes_2(f.getP_mes_2());
    r.setP_mes_3(f.getP_mes_3());
    r.setP_vlr_em_dia_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_em_dia_3ma()));
    r.setP_em_dia_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_em_dia_3ma()));
    r.setP_vlr_em_dia_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_em_dia_1mes()));
    r.setP_em_dia_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_em_dia_1mes()));
    r.setP_vlr_em_dia_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_em_dia_2mes()));
    r.setP_em_dia_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_em_dia_2mes()));
    r.setP_vlr_em_dia_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_em_dia_3mes()));
    r.setP_em_dia_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_em_dia_3mes()));
    r.setP_vlr_atr_me30d_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_atr_me30d_3ma()));
    r.setP_atr_me30d_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_atr_me30d_3ma()));
    r.setP_vlr_ate_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ate_1mes()));
    r.setP_ate_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_ate_1mes()));
    r.setP_vlr_ate_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ate_2mes()));
    r.setP_ate_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_ate_2mes()));
    r.setP_vlr_ate_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_ate_3mes()));
    r.setP_ate_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_ate_3mes()));
    r.setP_vlr_atr_ma30d_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_atr_ma30d_3ma()));
    r.setP_atr_ma30d_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_atr_ma30d_3ma()));
    r.setP_vlr_acima_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_acima_1mes()));
    r.setP_acima_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_acima_1mes()));
    r.setP_vlr_acima_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_acima_2mes()));
    r.setP_acima_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_acima_2mes()));
    r.setP_vlr_acima_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_acima_3mes()));
    r.setP_acima_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_acima_3mes()));
    r.setP_vlr_tot_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_tot_3ma()));
    r.setP_tot_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_tot_3ma()));
    r.setP_vlr_tot_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_tot_1mes()));
    r.setP_tot_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_tot_1mes()));
    r.setP_vlr_tot_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_tot_2mes()));
    r.setP_tot_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_tot_2mes()));
    r.setP_vlr_tot_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_tot_3mes()));
    r.setP_tot_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_tot_3mes()));
    r.setP_vlr_vct_ab_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_vct_ab_3ma()));
    r.setP_vct_ab_3ma(com.egen.util.text.FormatNumber.parseDouble(f.getP_vct_ab_3ma()));
    r.setP_vlr_vct_ab_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_vct_ab_1mes()));
    r.setP_vct_ab_1mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vct_ab_1mes()));
    r.setP_vlr_vct_ab_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_vct_ab_2mes()));
    r.setP_vct_ab_2mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vct_ab_2mes()));
    r.setP_vlr_vct_ab_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_vct_ab_3mes()));
    r.setP_vct_ab_3mes(com.egen.util.text.FormatNumber.parseDouble(f.getP_vct_ab_3mes()));
    r.setP_vlr_venc_mes_corrente(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_venc_mes_corrente()));
    r.setP_venc_mes_corrente(com.egen.util.text.FormatNumber.parseDouble(f.getP_venc_mes_corrente()));
    r.setP_vlr_avenc_mes_corrente(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_mes_corrente()));
    r.setP_avenc_mes_corrente(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_mes_corrente()));
    r.setP_vlr_pag_mes_corrente(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_pag_mes_corrente()));
    r.setP_pag_mes_corrente(com.egen.util.text.FormatNumber.parseDouble(f.getP_pag_mes_corrente()));
    r.setP_mes1(f.getP_mes1());
    r.setP_vlr_avenc_m1(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_m1()));
    r.setP_vlr_ped_bloq_m1(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_vlr_ped_abe_m1(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_avenc_m1(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_m1()));
    r.setP_mes2(f.getP_mes2());
    r.setP_vlr_avenc_m2(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_m2()));
    r.setP_vlr_ped_bloq_m2(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_vlr_ped_abe_m2(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_avenc_m2(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_m2()));
    r.setP_mes3(f.getP_mes3());
    r.setP_vlr_avenc_m3(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_m3()));
    r.setP_vlr_ped_bloq_m3(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_vlr_ped_abe_m3(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_avenc_m3(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_m3()));
    r.setP_mes4(f.getP_mes4());
    r.setP_vlr_avenc_m4(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_m4()));
    r.setP_vlr_ped_bloq_m4(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_vlr_ped_abe_m4(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_avenc_m4(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_m4()));
    r.setP_mes5(f.getP_mes5());
    r.setP_vlr_avenc_m5(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_m5()));
    r.setP_vlr_ped_bloq_m5(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_vlr_ped_abe_m5(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_avenc_m5(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_m5()));
    r.setP_mes6(f.getP_mes6());
    r.setP_vlr_avenc_m6(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_m6()));
    r.setP_vlr_ped_bloq_m6(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_vlr_ped_abe_m6(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_avenc_m6(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_m6()));
    r.setP_mes7(f.getP_mes7());
    r.setP_vlr_avenc_m7(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_m7()));
    r.setP_vlr_ped_bloq_m7(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_vlr_ped_abe_m7(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_avenc_m7(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_m7()));
    r.setP_mes8(f.getP_mes8());
    r.setP_vlr_avenc_m8(com.egen.util.text.FormatNumber.parseDouble(f.getP_vlr_avenc_m8()));
    r.setP_vlr_ped_bloq_m8(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_vlr_ped_abe_m8(com.egen.util.text.FormatNumber.parseDouble("0"));
    r.setP_avenc_m8(com.egen.util.text.FormatNumber.parseDouble(f.getP_avenc_m8()));
    r.setP_erro(f.getP_erro());
    try {
      r = (portalbr.dbobj.procedure.Prc_ctr_pend_aberta) j.execute(r);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    if (r != null) {
      f.setP_clientes((r.getP_clientes() != null) ? r.getP_clientes() + "":"");
      f.setP_cli_cdgo(r.getP_cli_cdgo() + "");
      f.setP_grupo_economico(r.getP_grupo_economico() + "");
      f.setP_emp((r.getP_emp() != null) ? r.getP_emp() + "":"");
      f.setP_dias1(com.egen.util.text.FormatNumber.format(r.getP_dias1(), "0"));
      f.setP_dias2(com.egen.util.text.FormatNumber.format(r.getP_dias2(), "0"));
      f.setP_mes_1((r.getP_mes_1() != null) ? r.getP_mes_1() + "":"");
      f.setP_mes_2((r.getP_mes_2() != null) ? r.getP_mes_2() + "":"");
      f.setP_mes_3((r.getP_mes_3() != null) ? r.getP_mes_3() + "":"");
      f.setP_vlr_em_dia_3ma(com.egen.util.text.FormatNumber.format(r.getP_vlr_em_dia_3ma(), "##,##0.00"));
      f.setP_em_dia_3ma(com.egen.util.text.FormatNumber.format(r.getP_em_dia_3ma(), "##,##0.00"));
      f.setP_vlr_em_dia_1mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_em_dia_1mes(), "##,##0.00"));
      f.setP_em_dia_1mes(com.egen.util.text.FormatNumber.format(r.getP_em_dia_1mes(), "##,##0.00"));
      f.setP_vlr_em_dia_2mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_em_dia_2mes(), "##,##0.00"));
      f.setP_em_dia_2mes(com.egen.util.text.FormatNumber.format(r.getP_em_dia_2mes(), "##,##0.00"));
      f.setP_vlr_em_dia_3mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_em_dia_3mes(), "##,##0.00"));
      f.setP_em_dia_3mes(com.egen.util.text.FormatNumber.format(r.getP_em_dia_3mes(), "##,##0.00"));
      f.setP_vlr_atr_me30d_3ma(com.egen.util.text.FormatNumber.format(r.getP_vlr_atr_me30d_3ma(), "##,##0.00"));
      f.setP_atr_me30d_3ma(com.egen.util.text.FormatNumber.format(r.getP_atr_me30d_3ma(), "##,##0.00"));
      f.setP_vlr_ate_1mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_ate_1mes(), "##,##0.00"));
      f.setP_ate_1mes(com.egen.util.text.FormatNumber.format(r.getP_ate_1mes(), "##,##0.00"));
      f.setP_vlr_ate_2mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_ate_2mes(), "##,##0.00"));
      f.setP_ate_2mes(com.egen.util.text.FormatNumber.format(r.getP_ate_2mes(), "##,##0.00"));
      f.setP_vlr_ate_3mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_ate_3mes(), "##,##0.00"));
      f.setP_ate_3mes(com.egen.util.text.FormatNumber.format(r.getP_ate_3mes(), "##,##0.00"));
      f.setP_vlr_atr_ma30d_3ma(com.egen.util.text.FormatNumber.format(r.getP_vlr_atr_ma30d_3ma(), "##,##0.00"));
      f.setP_atr_ma30d_3ma(com.egen.util.text.FormatNumber.format(r.getP_atr_ma30d_3ma(), "##,##0.00"));
      f.setP_vlr_acima_1mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_acima_1mes(), "##,##0.00"));
      f.setP_acima_1mes(com.egen.util.text.FormatNumber.format(r.getP_acima_1mes(), "##,##0.00"));
      f.setP_vlr_acima_2mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_acima_2mes(), "##,##0.00"));
      f.setP_acima_2mes(com.egen.util.text.FormatNumber.format(r.getP_acima_2mes(), "##,##0.00"));
      f.setP_vlr_acima_3mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_acima_3mes(), "##,##0.00"));
      f.setP_acima_3mes(com.egen.util.text.FormatNumber.format(r.getP_acima_3mes(), "##,##0.00"));
      f.setP_vlr_tot_3ma(com.egen.util.text.FormatNumber.format(r.getP_vlr_tot_3ma(), "##,##0.00"));
      f.setP_tot_3ma(com.egen.util.text.FormatNumber.format(r.getP_tot_3ma(), "##,##0.00"));
      f.setP_vlr_tot_1mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_tot_1mes(), "##,##0.00"));
      f.setP_tot_1mes(com.egen.util.text.FormatNumber.format(r.getP_tot_1mes(), "##,##0.00"));
      f.setP_vlr_tot_2mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_tot_2mes(), "##,##0.00"));
      f.setP_tot_2mes(com.egen.util.text.FormatNumber.format(r.getP_tot_2mes(), "##,##0.00"));
      f.setP_vlr_tot_3mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_tot_3mes(), "##,##0.00"));
      f.setP_tot_3mes(com.egen.util.text.FormatNumber.format(r.getP_tot_3mes(), "##,##0.00"));
      f.setP_vlr_vct_ab_3ma(com.egen.util.text.FormatNumber.format(r.getP_vlr_vct_ab_3ma(), "##,##0.00"));
      f.setP_vct_ab_3ma(com.egen.util.text.FormatNumber.format(r.getP_vct_ab_3ma(), "##,##0.00"));
      f.setP_vlr_vct_ab_1mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_vct_ab_1mes(), "##,##0.00"));
      f.setP_vct_ab_1mes(com.egen.util.text.FormatNumber.format(r.getP_vct_ab_1mes(), "##,##0.00"));
      f.setP_vlr_vct_ab_2mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_vct_ab_2mes(), "##,##0.00"));
      f.setP_vct_ab_2mes(com.egen.util.text.FormatNumber.format(r.getP_vct_ab_2mes(), "##,##0.00"));
      f.setP_vlr_vct_ab_3mes(com.egen.util.text.FormatNumber.format(r.getP_vlr_vct_ab_3mes(), "##,##0.00"));
      f.setP_vct_ab_3mes(com.egen.util.text.FormatNumber.format(r.getP_vct_ab_3mes(), "##,##0.00"));
      f.setP_vlr_venc_mes_corrente(com.egen.util.text.FormatNumber.format(r.getP_vlr_venc_mes_corrente(), "##,##0.00"));
      f.setP_venc_mes_corrente(com.egen.util.text.FormatNumber.format(r.getP_venc_mes_corrente(), "##,##0.00"));
      f.setP_vlr_avenc_mes_corrente(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_mes_corrente(), "##,##0.00"));
      f.setP_avenc_mes_corrente(com.egen.util.text.FormatNumber.format(r.getP_avenc_mes_corrente(), "##,##0.00"));
      f.setP_vlr_pag_mes_corrente(com.egen.util.text.FormatNumber.format(r.getP_vlr_pag_mes_corrente(), "##,##0.00"));
      f.setP_pag_mes_corrente(com.egen.util.text.FormatNumber.format(r.getP_pag_mes_corrente(), "##,##0.00"));
      f.setP_mes1((r.getP_mes1() != null) ? r.getP_mes1() + "":"");
      f.setP_vlr_avenc_m1(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_m1(), "##,##0.00"));
      f.setP_avenc_m1(com.egen.util.text.FormatNumber.format(r.getP_avenc_m1(), "##,##0.00"));
      f.setP_mes2((r.getP_mes2() != null) ? r.getP_mes2() + "":"");
      f.setP_vlr_avenc_m2(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_m2(), "##,##0.00"));
      f.setP_avenc_m2(com.egen.util.text.FormatNumber.format(r.getP_avenc_m2(), "##,##0.00"));
      f.setP_mes3((r.getP_mes3() != null) ? r.getP_mes3() + "":"");
      f.setP_vlr_avenc_m3(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_m3(), "##,##0.00"));
      f.setP_avenc_m3(com.egen.util.text.FormatNumber.format(r.getP_avenc_m3(), "##,##0.00"));
      f.setP_mes4((r.getP_mes4() != null) ? r.getP_mes4() + "":"");
      f.setP_vlr_avenc_m4(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_m4(), "##,##0.00"));
      f.setP_avenc_m4(com.egen.util.text.FormatNumber.format(r.getP_avenc_m4(), "##,##0.00"));
      f.setP_mes5((r.getP_mes5() != null) ? r.getP_mes5() + "":"");
      f.setP_vlr_avenc_m5(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_m5(), "##,##0.00"));
      f.setP_avenc_m5(com.egen.util.text.FormatNumber.format(r.getP_avenc_m5(), "##,##0.00"));
      f.setP_mes6((r.getP_mes6() != null) ? r.getP_mes6() + "":"");
      f.setP_vlr_avenc_m6(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_m6(), "##,##0.00"));
      f.setP_avenc_m6(com.egen.util.text.FormatNumber.format(r.getP_avenc_m6(), "##,##0.00"));
      f.setP_mes7((r.getP_mes7() != null) ? r.getP_mes7() + "":"");
      f.setP_vlr_avenc_m7(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_m7(), "##,##0.00"));
      f.setP_avenc_m7(com.egen.util.text.FormatNumber.format(r.getP_avenc_m7(), "##,##0.00"));
      f.setP_mes8((r.getP_mes8() != null) ? r.getP_mes8() + "":"");
      f.setP_vlr_avenc_m8(com.egen.util.text.FormatNumber.format(r.getP_vlr_avenc_m8(), "##,##0.00"));
      f.setP_avenc_m8(com.egen.util.text.FormatNumber.format(r.getP_avenc_m8(), "##,##0.00"));
      f.setP_erro((r.getP_erro() != null) ? r.getP_erro() + "":"");
    }
    session.setAttribute(mapping.getName(), form);
  }
}
