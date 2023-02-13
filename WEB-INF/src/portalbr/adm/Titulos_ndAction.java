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
 * Creation Date 27/03/2006 15:53:57
 * Last Modify Date 16/09/2009 15:58:51
 */

public class Titulos_ndAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_titulos_dados", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    String w_emp = null;
    String w_fil = null;
    String w_tip = null;
    String w_vnc = null;
    double w_valor = 0;
    double w_vlrec = 0;
    double w_protesto = 0;
    double w_diaria = 0;
    double w_juros = 0;
    double w_total = 0;
    int w_dias = 0;

    Titulos_ndActionForm f = (Titulos_ndActionForm) form;
    portalbr.dbobj.view.Jw_titulos_dados table = new portalbr.dbobj.view.Jw_titulos_dados();
    StringBuilder query1 = new StringBuilder();
    query1.append(" SELECT emp_empresa ");
    query1.append("      , fil_filial ");
    query1.append("      , tip_codigo ");
    query1.append("      , tit_datvenc ");
    query1.append("      , tit_valor ");
    query1.append("      , tit_vlrec ");
    query1.append("      , trunc(to_date('").append(f.getDt_calculo()).append("','dd/mm/yyyy')) - tit_datvenc w_dias ");
    query1.append("   FROM titulos ");
    query1.append("  WHERE tit_codigo = '").append(f.getTitulo()).append("'");
    query1.append("    AND cli_codigo > 0 ");

    Vector res_Jw_titulos_dados = j.select(table, query1.toString(), null);

    if (res_Jw_titulos_dados != null && res_Jw_titulos_dados.size() > 0) {
      portalbr.dbobj.view.Jw_titulos_dados r = (portalbr.dbobj.view.Jw_titulos_dados) res_Jw_titulos_dados.elementAt(0);
      w_emp = ((r.getEmp_empresa() != null) ? r.getEmp_empresa() + "":"");
      w_fil = ((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
      w_tip = ((r.getTip_codigo() != null) ? r.getTip_codigo() + "":"");
      w_vnc = (com.egen.util.text.FormatDate.format(r.getTit_datvenc(), "dd/MM/yyyy"));
      w_valor = (r.getTit_valor());
      w_vlrec = (r.getTit_vlrec());
      w_dias = (r.getW_dias());
      f.setTip_codigo(w_tip);
      f.setTit_datvenc(w_vnc);
      f.setTit_valor((w_valor - w_vlrec) + "");
    }

    portalbr.dbobj.view.Jw_protestos table_protestos = new portalbr.dbobj.view.Jw_protestos();
    StringBuilder query2 = new StringBuilder();
    query2.append(" SELECT nvl(mov_valor,0) mv ");
    query2.append("   FROM mov_receber ");
    query2.append("  WHERE emp_empresa = '").append(w_emp).append("'");
    query2.append("    AND fil_filial  = '").append(w_fil).append("'");
    query2.append("    AND tip_codigo  = '").append(w_tip).append("'");
    query2.append("    AND tit_codigo  = '").append(f.getTitulo()).append("'");
    query2.append("    AND trn_codigo  = 'PRO' ");
    query2.append("    AND sequencia   > 0 ");


    Vector res_Jw_protestos = j.select(table_protestos, query2.toString(), null);
    if (res_Jw_protestos != null && res_Jw_protestos.size() > 0) {
      portalbr.dbobj.view.Jw_protestos r_protestos = (portalbr.dbobj.view.Jw_protestos) res_Jw_protestos.elementAt(0);
      w_protesto = (r_protestos.getMv());
    }

    w_diaria = (Double.parseDouble(f.getJuros()) / Double.parseDouble("30")) / Double.parseDouble("100");
    w_juros = ((w_valor - w_vlrec) * w_diaria) * w_dias;
    w_total = (w_valor - w_vlrec) + w_juros + w_protesto;

    f.setW_dias(w_dias + "");
    f.setJuros(w_juros + "");
    f.setW_protesto(w_protesto + "");
    f.setTotal(w_total + "");

    if (!(res_Jw_titulos_dados != null && res_Jw_titulos_dados.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_titulos_dados", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

}
