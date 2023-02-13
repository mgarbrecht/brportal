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
 * Creation Date 09/10/2006 15:00:16
 * Last Modify Date 22/06/2015 14:12:12
 */

public class QuantidadePorNCMAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      QuantidadePorNCMActionForm f = (QuantidadePorNCMActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: exp0560.rdf");
      }
      //---------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("exp0560.rdf");
      g.setParametro("P_EMPRESA_FATURA", f.getP_empresa_fatura());
      g.setParametro("P_ANO_FATURA", f.getP_ano_fatura());
      g.setParametro("P_NUMERO_FATURA", f.getP_numero_fatura());
      g.gerar();
      //---------------------------------------------------------------------
      if ((f.getAbre_automaticamente() + "").equals("checked")) {
        request.setAttribute("abre_automaticamente","S");
      } else {
        request.setAttribute("abre_automaticamente","N");
      }
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      QuantidadePorNCMActionForm f = (QuantidadePorNCMActionForm) form;
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
