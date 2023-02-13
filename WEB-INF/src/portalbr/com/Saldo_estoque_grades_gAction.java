package portalbr.com;

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
 * Creation Date 24/02/2006 12:15:49
 * Last Modify Date 24/01/2017 08:53:32
 */

public class Saldo_estoque_grades_gAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_saldo_estoque_grades_g", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Saldo_estoque_grades_gActionForm f = (Saldo_estoque_grades_gActionForm) form;
    portalbr.dbobj.view.Jw_saldo_estoque_grades_g table = new portalbr.dbobj.view.Jw_saldo_estoque_grades_g();

    StringBuilder query = new StringBuilder();
    if (f.getGde_codigo().equals("99") || f.getGde_codigo().equals("90")) {
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        tai_codigo numero ");
      query.append("      , sum(qtde_atual) quantidade ");
      query.append("   FROM dom_local_item_estoque_gre ");
      query.append("  WHERE emp_empresa = '").append(f.getEmp_empresa()).append("'");
      query.append("    AND fil_filial  = '").append(f.getFil_filial()).append("'");
      query.append("    AND unn_codigo  = ").append(f.getUnn_codigo());
      query.append("    AND les_codigo  = ").append(f.getLes_codigo());
      query.append("    AND tes_codigo  = ").append(f.getTes_codigo());
      query.append("    AND tco_codigo  = ").append(f.getTco_codigo());
      query.append("    AND gde_cdgo    = ").append(f.getGde_codigo());
      query.append("    AND ies_codigo  = fct_ies_codigo(").append(f.getLin_cdgo()).append(",");
      query.append("                                     ").append(f.getRef_cdgo()).append(",");
      query.append("                                     ").append(f.getCab_cdgo()).append(" ) ");
      query.append("    AND cor_cdgo    = ").append(f.getCor_cdgo());
      query.append("  GROUP BY tai_codigo ");
      query.append(" HAVING sum(qtde_atual) > 0 ");
      query.append(" ORDER BY TO_NUMBER(regexp_substr(tai_codigo, '[[:digit:]]+', 1, 1)) ");
    } else {
      query.append(" SELECT /*+ all_rows */ ");
      query.append("        qtd_nume numero ");
      query.append("      , qtd_pars quantidade ");
      query.append("   FROM qtd ");
      query.append("  WHERE gde_cdgo = ").append(f.getGde_codigo());
      query.append("    AND gde_cdgo > 0 ");
      query.append("  ORDER BY TO_NUMBER(regexp_substr(qtd_nume, '[[:digit:]]+', 1, 1)) ");
    }

    Vector res_Jw_saldo_estoque_grades_g = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_saldo_estoque_grades_g",res_Jw_saldo_estoque_grades_g);
    if (!(res_Jw_saldo_estoque_grades_g != null && res_Jw_saldo_estoque_grades_g.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_saldo_estoque_grades_g", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Saldo_estoque_grades_gActionForm f = (Saldo_estoque_grades_gActionForm) form;
      session.removeAttribute("res_Jw_saldo_estoque_grades_g");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_saldo_estoque_grades_g", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
