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
 * Creation Date 16/06/2010 11:11:56
 * Last Modify Date 22/06/2015 13:11:57
 */

public class Sbr0026Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr0026ActionForm f = (Sbr0026ActionForm) form;
      select_action(null, mapping, form, request, response);
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    Sbr0026ActionForm f = (Sbr0026ActionForm) form;
    session.setAttribute(mapping.getName(), form);
    String rep_cdgo = null;
    String tipo = "";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        rep_cdgo = ent.getChave() + "";
      }
    }
    //------------------------------------------
    util.file.GeraPDF g = new util.file.GeraPDF(request);
    g.setRelatorio("sbr0026.rdf");

    if (rep_cdgo != null) {
      g.setParametro("P_REP_CDGO", rep_cdgo);
    }
    if ((f.getLin_cdgo() != "")) {
      g.setParametro("P_LINHA", f.getLin_cdgo());
    } else {
      g.setParametro("P_LINHA", "");
    }
    if ((f.getCodigo_marca() != "")) {
      g.setParametro("P_MARCA", f.getCodigo_marca());
    } else {
      g.setParametro("P_MARCA", "");
    }
    if ((f.getPed_tipo() != "")) {
      g.setParametro("P_TIPO", f.getPed_tipo());
    } else {
      g.setParametro("P_TIPO", "");
    }

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception("Query não disponível! Relatório utilizado: sbr0026.rdf");
    }
    //------------------------------------------
    g.gerar();
    //------------------------------------------

    if ((f.getAbre_automaticamente() + "").equals("checked")) {
      request.setAttribute("abre_automaticamente","S");
    } else {
      request.setAttribute("abre_automaticamente","N");
    }

  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr0026ActionForm f = (Sbr0026ActionForm) form;
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
