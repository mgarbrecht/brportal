package portalbr.adm;

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
 * Creation Date 24/01/2007 16:02:39
 * Last Modify Date 22/06/2015 15:26:16
 */

public class PendenciasClientesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PendenciasClientesActionForm f = (PendenciasClientesActionForm) form;
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

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PendenciasClientesActionForm f = (PendenciasClientesActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: ctr5023.rdf");
      }
      if (f.getCli_cdgo().equals("") && f.getRep_cdgo().equals("")) {
        throw new Exception("Informe o Cliente ou o Representante!");
      }
      java.util.Date data = new java.util.Date();
      java.text.SimpleDateFormat fDataAtual = new java.text.SimpleDateFormat("dd/MM/yyyy");
      String data_atual = fDataAtual.format(data);
      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("ctr5023.rdf");
      g.setParametro("P_NRO_DIAS", f.getNr_dias());
      g.setParametro("P_REP_COBRADOR", f.getRep_cdgo());
      g.setParametro("P_DATA_GERACAO", data_atual);
      g.setParametro("P_CLIENTE", f.getCli_cdgo());
      g.gerar();
      //--------------------------------------------------------------------------
      request.setAttribute("mostra_pdf","S");
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
