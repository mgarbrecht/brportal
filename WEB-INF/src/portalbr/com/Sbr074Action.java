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
 * Last Modify Date 22/06/2015 14:09:17
 */

public class Sbr074Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr074ActionForm f = (Sbr074ActionForm) form;
      String codigo_regional = "";
      String codigo_representante = "";
      String tipo = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("REGIONAL DE VENDA")) {
          codigo_regional = ent.getChave() + "";
        }
        if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
          codigo_representante = ent.getChave() + "";
        }
      }
      if (u.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: sbr074.rdf");
      }
      //-----------------------------------------------------------------
      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio("sbr074.rdf");
      g.setParametro("IND_ABE_FEC", f.getIndicador());
      if (codigo_representante.equals("")) {
        g.setParametro("P_REGIONAL", f.getRegional());
      }
      g.setParametro("DATA_FIM", f.getDt_final());
      g.setParametro("TIPO_MERCADO", f.getMercado());
      g.setParametro("DATA_INI", f.getDt_inicial());
      g.setParametro("P_REP", f.getRep_cdgo());
      if (f.getCodigo_marca().equals("") || f.getCodigo_marca() == null) {
        g.setParametro("P_MARCA", "0");
      } else {
        g.setParametro("P_MARCA", f.getCodigo_marca());
      }
      g.setParametro("P_MIX", f.getMix());
      g.gerar();
      //-----------------------------------------------------------------
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
      Sbr074ActionForm f = (Sbr074ActionForm) form;
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
