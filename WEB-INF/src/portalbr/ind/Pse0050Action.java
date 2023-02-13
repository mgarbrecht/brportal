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
 * Creation Date 31/08/2009 14:45:37
 * Last Modify Date 25/02/2015 15:25:24
 */

public class Pse0050Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_processa_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Pse0050ActionForm f = (Pse0050ActionForm) form;
      java.util.Vector < String > v_atelier = null;
      brportal.ind.Pse0050 p = new brportal.ind.Pse0050();
      if (f.getTipo().equals("R")) {
        f.setMensagem(p.processaPreRetorno(f.getCodigo_barra(), f.getFornecedor(), f.getPro_codigo(), request));
      } else {
        f.setMensagem(p.processaPreEnvio(f.getCodigo_barra(), f.getFornecedor(), f.getPro_codigo(), request));
      }
      f.setCodigo_barra("");
      request.setAttribute("codigobarra","lido");
      //---------------------------------------------------------
      if ((f.getMensagem() + "").indexOf("ok") == -1) {
      } else {
        if (session.getAttribute("v_atelier") == null) {
          session.setAttribute("atelier_cor","c");
          v_atelier = new java.util.Vector < String > ();
          v_atelier.add("c"+f.getMensagem());
        } else {
          if (((String) session.getAttribute("atelier_cor")).equals("c")) {
            session.setAttribute("atelier_cor","b");
          } else {
            session.setAttribute("atelier_cor","c");
          }
          v_atelier = (java.util.Vector) session.getAttribute("v_atelier");
          v_atelier.add((String) session.getAttribute("atelier_cor") + f.getMensagem());
        }
        session.setAttribute("v_atelier", v_atelier);
      }
      //---------------------------------------------------------
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
      Pse0050ActionForm f = (Pse0050ActionForm) form;
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

  public ActionForward perform_resetfull_talao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.removeAttribute("v_atelier");
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

  public ActionForward perform_resetfull2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Pse0050ActionForm f = (Pse0050ActionForm) form;
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.removeAttribute("v_atelier");
      session.removeAttribute("atelier_cor");
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
