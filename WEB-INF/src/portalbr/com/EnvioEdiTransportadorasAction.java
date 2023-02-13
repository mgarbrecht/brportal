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
 * Creation Date 01/06/2011 15:19:44
 * Last Modify Date 01/06/2011 16:43:42
 */

public class EnvioEdiTransportadorasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_execute_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      EnvioEdiTransportadorasActionForm f = (EnvioEdiTransportadorasActionForm) form;
      try {
        execute_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_envio_arquivos_edi", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void execute_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    EnvioEdiTransportadorasActionForm f = (EnvioEdiTransportadorasActionForm) form;
    session.removeAttribute("ok");
    session.removeAttribute("erro");
    Prc_envio_arquivos_edi r = new Prc_envio_arquivos_edi();
    r.setP_tipo(f.getTipo());
    r.setP_filial(f.getFil_filial());
    r.setP_data(com.egen.util.text.FormatDate.parseDate(f.getData_retroativa(), "dd/MM/yyyy"));
    r = (Prc_envio_arquivos_edi) j.execute(r);
    if (r != null) {
      if (r.getP_erro() != null) {
        f.setP_erro(r.getP_erro());
        session.setAttribute("erro","s");
      } else {
        session.setAttribute("ok","ok");
        session.setAttribute("erro","s");
        f.setP_erro("Processo concluído com sucesso!");
      }
    }
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      EnvioEdiTransportadorasActionForm f = (EnvioEdiTransportadorasActionForm) form;
      session.removeAttribute("res_Parametros");
      form.reset(mapping, request);
      session.removeAttribute("ok");
      session.removeAttribute("erro");
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
