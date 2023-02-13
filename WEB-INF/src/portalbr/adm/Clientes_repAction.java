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
 * Creation Date 21/12/2005 11:33:20
 * Last Modify Date 03/10/2016 15:36:56
 */

public class Clientes_repAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_representante", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    Clientes_representanteActionForm f = (Clientes_representanteActionForm) form;
    portalbr.dbobj.view.Clientes_representante table = new portalbr.dbobj.view.Clientes_representante();
    String lin_cdgo = null;
    String codigo_marca = null;
    String codigo_regional = null;
    if (!f.getLin_cdgo().equals("")) {
      lin_cdgo = f.getLin_cdgo();
    }

    if (!f.getCodigo_marca().equals("")) {
      codigo_marca = f.getCodigo_marca();
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT /*+ all_rows */ lpad(res.codigo_regional, 3, 0) || '-' || rv.nome_regional regional ");
    sb.append("      , res.codigo_regional ");
    sb.append("      , res.rep_cdgo ");
    sb.append("      , 0 clientes_ativos ");
    sb.append("      , count(distinct(cli.cli_cdgo)) clientes_atendidos ");
    sb.append("      , 0 clientes_nao_atendidos ");
    sb.append("      , nvl(sum(res.pares), 0) pares ");
    sb.append("      , nvl(sum(res.valor), 0) valor ");
    sb.append("   FROM resumo_ped res ");
    sb.append("      , cli ");
    sb.append("      , regionais_vendas rv ");
    sb.append("  WHERE res.codigo_regional >= 0 ");
    sb.append("    AND cli.cli_cdgo        = res.cli_cdgo ");
    sb.append("    AND rv.codigo_regional  = res.codigo_regional ");
    sb.append("    AND res.data_dig        >= to_date('").append(f.getDt_inicial()).append("','dd/MM/yyyy') ");
    sb.append("    AND res.data_dig        < to_date('").append(f.getDt_final()).append("','dd/MM/yyyy')+1 ");
    sb.append("    AND res.lin_cdgo        = nvl(").append(lin_cdgo).append(",res.lin_cdgo) ");
    sb.append("    AND res.codigo_marca    = nvl(").append(codigo_marca).append(",res.codigo_marca) ");
    sb.append("    AND res.codigo_regional = nvl(").append(session.getAttribute("codigo_regional")).append(",res.codigo_regional) ");
    sb.append("  GROUP BY res.codigo_regional ");
    sb.append("         , res.rep_cdgo ");
    sb.append("         , rv.nome_regional");

    Vector res_Clientes_representante = j.select(table, sb.toString(), null);

    session.setAttribute("res_Clientes_representante",res_Clientes_representante);
    if (!(res_Clientes_representante != null && res_Clientes_representante.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_representante", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Clientes_repActionForm f = (Clientes_repActionForm) form;
      session.removeAttribute("res_Clientes_regional");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Clientes_regional", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
