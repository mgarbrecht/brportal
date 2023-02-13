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
 * Creation Date 03/04/2012 14:02:05
 * Last Modify Date 09/10/2015 10:14:27
 */

public class LvTabelaPrecoMercadoExternoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LvTabelaPrecoMercadoExternoActionForm f = (LvTabelaPrecoMercadoExternoActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tabela_preco_mercado_externo", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    LvTabelaPrecoMercadoExternoActionForm f = (LvTabelaPrecoMercadoExternoActionForm) form;
    Jw_tabela_preco_mercado_externo table = new Jw_tabela_preco_mercado_externo();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"codigo_livro","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_livro())}, {"versao_tabela","=", com.egen.util.text.FormatDate.parseTimestamp(f.getVersao_tabela(), "dd/MM/yyyy HH:mm:ss")} };
    Vector res_Jw_tabela_preco_mercado_externo = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_tabela_preco_mercado_externo",res_Jw_tabela_preco_mercado_externo);
    if (res_Jw_tabela_preco_mercado_externo == null || res_Jw_tabela_preco_mercado_externo.size() == 0) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tabela_preco_mercado_externo", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      LvTabelaPrecoMercadoExternoActionForm f = (LvTabelaPrecoMercadoExternoActionForm) form;
      session.removeAttribute("res_Jw_tabela_preco_mercado_externo");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_tabela_preco_mercado_externo", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
