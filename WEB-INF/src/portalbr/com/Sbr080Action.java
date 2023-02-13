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
 * Creation Date 15/05/2006 10:19:08
 * Last Modify Date 22/06/2015 14:09:04
 */

public class Sbr080Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr080ActionForm f = (Sbr080ActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr080.rdf");
      }
      //-------------------------------------------------------------------------------
      // Se o usuário for administrador, obriga informar a regional ou o representante
      //-------------------------------------------------------------------------------
      if (f.getReg().equals("") && f.getRep().equals("")) {
        if (f.getRep_cdgo().equals("") && f.getRegional().equals("")) {
          throw new Exception("A regional ou o representante devem ser informados!");
        }
      }
      //-------------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("sbr080.rdf");
      g.setParametro("P_DATA_FIM", f.getDt_final());
      g.setParametro("P_DATA_INI", f.getDt_inicial());
      g.setParametro("P_MARCA_INI", f.getMarca_inicial());
      g.setParametro("P_MARCA_FIM", f.getMarca_final());
      if ((!(f.getRep_cdgo().equals("")))) {
        g.setParametro("P_REPRESENTANTE", f.getRep_cdgo());
      } else {
        g.setParametro("P_REPRESENTANTE", "0");
      }
      if ((!(f.getRegional().equals("")))) {
        g.setParametro("P_REGIONAL", f.getRegional());
      } else {
        g.setParametro("P_REGIONAL", "0");
      }
      g.gerar();
      //-------------------------------------------------------------------------------
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
      Sbr080ActionForm f = (Sbr080ActionForm) form;
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
