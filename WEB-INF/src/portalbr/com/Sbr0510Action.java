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
 * Creation Date 10/10/2017 17:25:07
 * Last Modify Date 28/01/2019 13:49:07
 */

public class Sbr0510Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr0510ActionForm f = (Sbr0510ActionForm) form;
      util.consultas.com.Sbr0510 sbr0510 = new util.consultas.com.Sbr0510();
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      String arquivo = null;

      if ((f.getPed_nmro() + "").equals("") && (f.getLin_cdgo() + "").equals("")) {
        throw new Exception("Informe o pedido ou a linha!");
      }

      arquivo = sbr0510.geraExcel(request , f.getPed_nmro(), f.getLin_cdgo(), f.getRef_cdgo(), f.getCab_cdgo(), f.getAbrir_numeracao().equalsIgnoreCase("S"), usuario.mostraQuery());

      if (request.getAttribute("query") != null) {
        throw new Exception((String) request.getAttribute("query"));
      }
      if (arquivo.equals("")) {
        throw new Exception("Nenhum registro encontrado!");
      }
      request.setAttribute("abre_automaticamente","N");
      request.setAttribute("arquivo", arquivo);

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
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr0510ActionForm f = (Sbr0510ActionForm) form;
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

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr0510ActionForm f = (Sbr0510ActionForm) form;
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
