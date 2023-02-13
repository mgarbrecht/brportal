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
 * Creation Date 04/05/2016 12:47:33
 * Last Modify Date 04/05/2016 13:07:55
 */

public class ControleClientesEspeciais_lAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ControleClientesEspeciais_lActionForm f = (ControleClientesEspeciais_lActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_controle_clientes_especiais_log", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ControleClientesEspeciais_lActionForm f = (ControleClientesEspeciais_lActionForm) form;
    Jw_controle_clientes_especiais_log table = new Jw_controle_clientes_especiais_log();
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT lo.data data_log ");
    sb.append("       ,lo.usuario ");
    sb.append("       ,lo.acao ");
    sb.append("       ,lc.nome_coluna ");
    sb.append("       ,lc.old_value ");
    sb.append("       ,lc.new_value ");
    sb.append("   FROM log_coluna lc ");
    sb.append("       ,log_operacao lo ");
    sb.append("  WHERE lc.log_operacao_seq = lo.log_operacao_seq ");
    sb.append("    AND lc.log_operacao_seq IN (SELECT e.log_operacao_seq ");
    sb.append("                                  FROM log_operacao e ");
    sb.append("                                      ,log_coluna l ");
    sb.append("                                 WHERE NVL(e.tabela, NULL) = 'PED_INF_ADICIONAIS' ");
    sb.append("                                   AND e.log_operacao_seq = l.log_operacao_seq ");
    sb.append("                                   AND l.nome_coluna = 'PED_NMRO' ");
    sb.append("                                   AND l.new_value = TO_CHAR("+f.getPed_nmro() + ")) ");
    sb.append("    AND lc.nome_coluna <> 'PED_NMRO' ");
    sb.append("  ORDER BY lo.data DESC ");
    sb.append("          ,lo.log_operacao_seq ");
    Vector res_Jw_controle_clientes_especiais_log = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_controle_clientes_especiais_log",res_Jw_controle_clientes_especiais_log);
    if (res_Jw_controle_clientes_especiais_log != null && res_Jw_controle_clientes_especiais_log.size() > 0) {
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_controle_clientes_especiais_log", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

}
