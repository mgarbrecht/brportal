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
 * Creation Date 28/07/2015 11:36:46
 * Last Modify Date 15/05/2017 15:05:50
 */

public class FichaMarcaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichaMarcaActionForm f = (FichaMarcaActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    FichaMarcaActionForm f = (FichaMarcaActionForm) form;
    //--------------------------------------------------------------------------
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    StringBuilder sb = new StringBuilder();
    g.setRelatorio("FichaMarca.jasper");
    g.setParametro("P_MARCA", f.getMarca());
    g.setParametro("P_REGIONAL", f.getRegional());
    g.setParametro("P_DATA_INICIAL", f.getData_inicial());
    g.setParametro("P_DATA_FINAL", f.getData_final());
    if (!f.getTipo_mercado().equalsIgnoreCase("T")) {
      g.setParametro("P_TIPO_MERCADO", f.getTipo_mercado());
    }
    g.setParametro("P_QTD_MAIORES_CLIENTES", f.getQtd_maiores_clientes());
    g.setParametro("P_QTD_DESEMPENHO_REPRESENTANTE", f.getQtd_desempenho_representante());
    g.setParametro("P_QTD_MODELOS_MAIS_VENDIDOS", f.getQtd_modelos_mais_vendidos());
    g.gerar();
    //--------------------------------------------------------------------------
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FichaMarcaActionForm f = (FichaMarcaActionForm) form;
      session.removeAttribute("res_Ficha_tec");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
