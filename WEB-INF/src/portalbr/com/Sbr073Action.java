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
 * Creation Date 15/05/2006 11:05:13
 * Last Modify Date 22/06/2015 14:09:31
 */

public class Sbr073Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr073ActionForm f = (Sbr073ActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr073.rdf");
      }
      //--------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("sbr073.rdf");
      g.setParametro("IND_ABE_FEC",f.getIndicador());
      g.setParametro("P_REGIONAL",f.getRegional());
      g.setParametro("DATA_FIM",f.getDt_final());
      g.setParametro("TIPO_MERCADO",f.getMercado());
      g.setParametro("DATA_INI",f.getDt_inicial());
      g.setParametro("P_MIX",f.getMix());
      if (f.getCodigo_marca().equals("")) {
        g.setParametro("P_MARCA","0");
      } else {
        g.setParametro("P_MARCA",f.getCodigo_marca());
      }
      g.gerar();
      //--------------------------------------------------------------
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
      Sbr073ActionForm f = (Sbr073ActionForm) form;
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
