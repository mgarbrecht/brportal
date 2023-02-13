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
 * Creation Date 17/08/2017 09:32:57
 * Last Modify Date 17/08/2017 09:57:43
 */

public class LvConsumoComposicaoCorAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvConsumoComposicaoCorActionForm f = (LvConsumoComposicaoCorActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_cor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvConsumoComposicaoCorActionForm f = (LvConsumoComposicaoCorActionForm) form;
    Jw_consumo_composicao_cor table = new Jw_consumo_composicao_cor();
    StringBuilder sb = new StringBuilder();
    acesso.Sessao sessao = new acesso.Sessao(session);
    sb.append(" SELECT DISTINCT   ");
    sb.append("       /*+ all_rows */ ");
    sb.append("       cc.cor_cdgo ");
    sb.append("     , c.cor_desc ");
    sb.append("  FROM componente_composicao cc ");
    sb.append("     , dom_item_estoque      die ");
    sb.append("     , cor                   c ");
    sb.append(" WHERE cc.mat_nro = die.codigo ");
    sb.append("   AND c.cor_cdgo = cc.cor_cdgo ");
    if (f.getCor_cdgo() != "") {
      sb.append(" AND c.cor_cdgo = " + f.getCor_cdgo());
    }
    if (f.getCor_desc() != "") {
      sb.append(" AND c.cor_desc like ('"+f.getCor_desc().toUpperCase() + "') ");
    }
    if (f.getIes_codigo() != "") {
      sb.append("   AND cc.ies_codigo = " + f.getIes_codigo());
    }
    if (sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")) {
      sb.append(" AND EXISTS (SELECT 1 ");
      sb.append("              FROM dom_item_fornecedor dif ");
      sb.append("             WHERE dif.for_codigo = " + sessao.getChave());
      sb.append("               AND dif.ies_codigo = cc.ies_codigo) ");
    }
    sb.append(" ORDER BY cor_cdgo ");

    Vector res_Jw_consumo_composicao_cor = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_consumo_composicao_cor",res_Jw_consumo_composicao_cor);
    if (res_Jw_consumo_composicao_cor == null || res_Jw_consumo_composicao_cor.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_cor", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvConsumoComposicaoCorActionForm f = (LvConsumoComposicaoCorActionForm) form;
      session.removeAttribute("res_Jw_consumo_composicao_cor");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_cor", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
