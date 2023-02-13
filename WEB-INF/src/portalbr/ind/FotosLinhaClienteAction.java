package portalbr.ind;

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
 * Creation Date 03/03/2006 10:11:03
 * Last Modify Date 18/12/2014 08:46:50
 */

public class FotosLinhaClienteAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FotosLinhaClienteActionForm f = (FotosLinhaClienteActionForm) form;
      try {
        tg_select_action(mapping, form, request, response);
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_tec_imagem", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FotosLinhaClienteActionForm f = (FotosLinhaClienteActionForm) form;
    portalbr.dbobj.view.Jw_ficha_tec_imagem table = new portalbr.dbobj.view.Jw_ficha_tec_imagem();
    String[][] select = null;
    String[] order = {"lin_cdgo"};
    Object[] parametros = {f.getLinha()};

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT DISTINCT ");
    sb.append("        lin.lin_cdgo ");
    sb.append("      , ref.ref_cdgo ");
    sb.append("      , replace(fct_retorna_fit_imagem(lin.lin_cdgo, ref.ref_cdgo), 'gif', 'jpg') fit_imagem ");
    sb.append("   FROM lin ");
    sb.append("      , ref ");
    sb.append("      , ficha_tec ft ");
    sb.append("  WHERE ref.lin_cdgo = lin.lin_cdgo ");
    sb.append("    AND ft.lin_cdgo (+)  = ref.lin_cdgo ");
    sb.append("    AND ft.ref_cdgo (+)  = ref.ref_cdgo ");
    sb.append("    AND ref.codigo_marca in (SELECT codigo_marca FROM marcas_produtos WHERE status = 'A') ");
    sb.append("    AND ref.ref_status = 'A' ");
    sb.append("    AND ref.ref_tipo = 'PG' ");
    sb.append("    AND ref.lin_cdgo = ? ");
    sb.append("  ORDER BY lin.lin_cdgo ");
    sb.append("         , ref.ref_cdgo ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_ficha_tec_imagem = j.select(table, sb.toString(), parametros);

    session.setAttribute("res_Jw_ficha_tec_imagem",res_Jw_ficha_tec_imagem);
    if (!(res_Jw_ficha_tec_imagem != null && res_Jw_ficha_tec_imagem.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_tec_imagem", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      FotosLinhaClienteActionForm f = (FotosLinhaClienteActionForm) form;
      if (f.getLinha().equals("")) {
        throw new Exception(java.util.ResourceBundle.getBundle("IndustrialResources").getString("FotosLinhaCliente.selecionar.linha"));
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FotosLinhaClienteActionForm f = (FotosLinhaClienteActionForm) form;
      session.removeAttribute("res_Jw_ficha_tec_imagem");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_tec_imagem", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
