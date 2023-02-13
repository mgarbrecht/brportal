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
 * Creation Date 12/05/2006 14:39:23
 * Last Modify Date 25/01/2017 10:54:36
 */

public class Sbr060Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr060ActionForm f = (Sbr060ActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr060.rdf");
      }
      //--------------------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("sbr060.rdf");
      g.setParametro("P_TIPO_MERCADO", f.getPf_tipo_mercado());
      g.setParametro("P_QTD_LINHAS", f.getPf_qtd_linhas());
      g.setParametro("P_PED_DADG_INI", f.getPf_ped_dadg_ini());
      g.setParametro("P_PED_DADG_FIM", f.getPf_ped_dadg_fim());
      g.setParametro("P_MARCA_INI", f.getPf_marca_ini());
      g.setParametro("P_MARCA_FIM", f.getPf_marca_fim());
      g.setParametro("UNID_NEGOCIO", f.getPf_1());
      g.setParametro("P_ATIVO", f.getPf_2());
      if (f.getReg().equals("")) {
        g.setParametro("P_REGIONAL", f.getRegional());
      } else {
        g.setParametro("P_REGIONAL", f.getReg());
      }
      g.gerar();
      //--------------------------------------------------------------------------
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
      Sbr060ActionForm f = (Sbr060ActionForm) form;
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
