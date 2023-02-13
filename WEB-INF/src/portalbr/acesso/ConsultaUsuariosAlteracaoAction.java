package portalbr.acesso;

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
 * Creation Date 16/09/2015 16:40:03
 * Last Modify Date 16/09/2015 17:00:57
 */

public class ConsultaUsuariosAlteracaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaUsuariosAlteracaoActionForm f = (ConsultaUsuariosAlteracaoActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/acesso/ConsultaUsuariosAlteracao_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_alteracao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaUsuariosAlteracaoActionForm f = (ConsultaUsuariosAlteracaoActionForm) form;
    Jw_usuarios_alteracao table = new Jw_usuarios_alteracao();
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT usua_usuario usuario ");
    sb.append("      , usua_nome nome ");
    sb.append("      , dthr_alteracao data_alteracao ");
    sb.append("      , usuario_alteracao ");
    sb.append("   FROM wbrio.usuarios ");
    sb.append("  WHERE TRUNC(dthr_alteracao) >= to_date('"+f.getDt_inicial() + "', 'dd/mm/yyyy') ");
    sb.append("    AND TRUNC(dthr_alteracao) <= to_date('"+f.getDt_final() + "', 'dd/mm/yyyy') ");
    if (f.getUsuario_alteracao() != "") {
      sb.append(" AND usuario_alteracao = '"+f.getUsuario_alteracao().toUpperCase() + "' ");
    }
    sb.append("   ORDER BY data_alteracao ");
    Vector res_Jw_usuarios_alteracao = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_usuarios_alteracao",res_Jw_usuarios_alteracao);
    if (!(res_Jw_usuarios_alteracao != null && res_Jw_usuarios_alteracao.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_alteracao", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaUsuariosAlteracaoActionForm f = (ConsultaUsuariosAlteracaoActionForm) form;
      session.removeAttribute("res_Jw_usuarios_alteracao");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios_alteracao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
