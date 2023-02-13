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
 * Creation Date 29/04/2015 09:28:47
 * Last Modify Date 07/05/2015 10:52:57
 */

public class VerificacaoCaixasIndividuaisCorrugadosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_execute_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    VerificacaoCaixasIndividuaisCorrugadosActionForm f = (VerificacaoCaixasIndividuaisCorrugadosActionForm) form;
    try {
      util.consultas.ind.VerifCaixasIndCorrugados v = new util.consultas.ind.VerifCaixasIndCorrugados(request);
      v.executa(f.getRotulo());
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      f.setRotulo("");
    }
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      VerificacaoCaixasIndividuaisCorrugadosActionForm f = (VerificacaoCaixasIndividuaisCorrugadosActionForm) form;
      form.reset(mapping, request);
      session.removeAttribute("res_Jw_verif_caixas_corrugados");
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
