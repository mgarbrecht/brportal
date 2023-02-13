package portalbr.lov;

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
 * Creation Date 20/11/2007 05:49:58
 * Last Modify Date 02/12/2009 10:17:05
 */

public class LvLinhaRefAction extends com.egen.util.struts.AbstractAction {

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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_lin_ref", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvLinhaRefActionForm f = (LvLinhaRefActionForm) form;
    StringBuilder sb = new StringBuilder();
    String linha = null;
    String marca = null;
    String parametros = null;

    if (f.getLin_cdgo().equals("")) {
      linha = "null";
    } else {
      linha = f.getLin_cdgo();
    }

    if (f.getCodigo_marca().equals("")) {
      marca = "null";
    } else {
      marca = f.getCodigo_marca();
    }

    if (f.getLin_nome().equals("")) {
      parametros = "";
    } else {
      parametros = " and upper(l.lin_nome) like ('"+f.getLin_nome().toUpperCase() + "') ";
    }

    portalbr.dbobj.view.Jw_lv_lin_ref table = new portalbr.dbobj.view.Jw_lv_lin_ref();
    sb.append(" SELECT DISTINCT ");
    sb.append("        l.lin_cdgo ");
    sb.append("      , l.lin_nome ");
    sb.append("      , '' ref_cdgo ");
    sb.append("      , '' ref_desc ");
    sb.append("   FROM ref r ");
    sb.append("      , lin l ");
    sb.append("  WHERE l.lin_cdgo     = r.lin_cdgo ");
    sb.append("    AND l.lin_cdgo     = nvl(").append(linha).append(",l.lin_cdgo) ");
    sb.append("    AND r.codigo_marca = nvl(").append(marca).append(",r.codigo_marca) ");
    sb.append(parametros);
    sb.append("  ORDER BY l.lin_cdgo ");

    Vector res_Jw_lv_lin_ref = j.select(table, sb.toString(), null);

    session.setAttribute("res_Jw_lv_lin_ref",res_Jw_lv_lin_ref);
    if (!(res_Jw_lv_lin_ref != null && res_Jw_lv_lin_ref.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_lin_ref", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvLinhaRefActionForm f = (LvLinhaRefActionForm) form;
      session.removeAttribute("res_Jw_lv_lin_ref");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_lv_lin_ref", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
