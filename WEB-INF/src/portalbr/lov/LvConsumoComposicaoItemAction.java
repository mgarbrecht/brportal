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
 * Creation Date 14/08/2017 09:24:37
 * Last Modify Date 14/08/2017 11:35:51
 */

public class LvConsumoComposicaoItemAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvConsumoComposicaoItemActionForm f = (LvConsumoComposicaoItemActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_item_lov", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    acesso.Sessao sessao = new acesso.Sessao(session);
    LvConsumoComposicaoItemActionForm f = (LvConsumoComposicaoItemActionForm) form;
    Jw_consumo_composicao_item_lov table = new Jw_consumo_composicao_item_lov();
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT /*+ all_rows */ ");
    sb.append("        codigo ");
    sb.append("      , descricao ");
    sb.append("   FROM dom_item_estoque ");
    sb.append("  WHERE 1=1 ");
    if (sessao.getTipoEntidadeNegocio().equals("FORNECEDOR")) {
      sb.append(" AND EXISTS (SELECT 1 ");
      sb.append("              FROM dom_item_fornecedor dif ");
      sb.append("             WHERE dif.for_codigo = " + sessao.getChave());
      sb.append("               AND dif.ies_codigo = codigo) ");
    }
    if (f.getCodigo() != "") {
      sb.append(" AND codigo = " + f.getCodigo());
    }
    if (f.getDescricao() != "") {
      sb.append(" AND descricao like ('"+f.getDescricao().toUpperCase() + "') ");
    }
    sb.append("  ORDER BY codigo ");


    Vector res_Jw_consumo_composicao_item_lov = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_consumo_composicao_item_lov",res_Jw_consumo_composicao_item_lov);
    if (res_Jw_consumo_composicao_item_lov == null || res_Jw_consumo_composicao_item_lov.size() == 0) {
      throw new Exception("Nenhum registro encontrado!");
    }
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvConsumoComposicaoItemActionForm f = (LvConsumoComposicaoItemActionForm) form;
      session.removeAttribute("res_Jw_consumo_composicao_item_lov");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consumo_composicao_item_lov", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
