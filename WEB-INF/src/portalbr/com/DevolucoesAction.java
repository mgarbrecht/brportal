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
 * Creation Date 07/12/2007 12:55:56
 * Last Modify Date 22/06/2015 13:34:40
 */

public class DevolucoesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DevolucoesActionForm f = (DevolucoesActionForm) form;
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: dev0829.rdf");
      }
      //--------------------------------------------------------------------------
      String codigo_analista = "";
      String codigo_regional = "";
      String tipo = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("ANALISTA REGIONAL")) {
          codigo_analista = ent.getChave() + "";
        }
        if (tipo.equals("REGIONAL DE VENDA")) {
          codigo_regional = ent.getChave() + "";
        }
      }

      if (tipo.equals("REGIONAL DE VENDA")) {
        com.egen.util.jdbc.JdbcUtil j = null;
        try {
          j = new com.egen.util.jdbc.JdbcUtil();
          portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
          String[][] select = null;
          Object[][] where = {{"codigo_regional","=",codigo_regional} };
          Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
          if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
            portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
            codigo_analista = r.getCodigo_gerente();
          }
        }
        finally {
          if (j != null) {
            j.close();
            j = null;
          }
        }
      }

      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("dev0829.rdf");
      g.setParametro("P_GERENTE", codigo_analista);
      g.setParametro("P_REGIONAL", f.getRegional());
      g.setParametro("P_REPRESENTANTE", f.getRep_cdgo());
      g.setParametro("P_UNN_CODIGO", f.getUnn_codigo());
      g.setParametro("P_MARCA", f.getMarca());
      //-----------------------------------------------------------
      g.gerar();
      //-----------------------------------------------------------
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
      DevolucoesActionForm f = (DevolucoesActionForm) form;
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
