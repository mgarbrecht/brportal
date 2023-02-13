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
 * Creation Date 30/11/2007 05:31:44
 * Last Modify Date 22/01/2018 14:15:28
 */

public class Sbr0377Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Sbr0377ActionForm f = (Sbr0377ActionForm) form;
      //--------------------------------------------------------------------------
      String relatorio = null;
      if (f.getTipo_relatorio().equals("m")) {
        relatorio = "sbr0377_01.rdf";
      } else {
        relatorio = "sbr0377_02.rdf";
      }


      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: " + relatorio);
      }

      util.file.GeraPDF g = new util.file.GeraPDF(request);
      g.setRelatorio(relatorio);
      g.setParametro("P_EMPRESA", f.getEmp_empresa());
      g.setParametro("P_APENAS_PG", f.getCk_pedidos_programados() == null ? "N":f.getCk_pedidos_programados());
      if ((!(f.getFiliais().equals(""))) || (!(f.getFil_filial().equals("")))) {
        g.setParametro("P_FILIAL_ESPEC", "S");
      } else {
        g.setParametro("P_FILIAL_ESPEC", "N");
      }
      if ((!(f.getLinhas().equals(""))) || (!(f.getLin_cdgo().equals("")))) {
        g.setParametro("P_LINHA_ESPEC", "S");
      } else {
        g.setParametro("P_LINHA_ESPEC", "N");
      }
      g.setParametro("P_DATA_DIG_INI", f.getData_inicial());
      g.setParametro("P_DATA_DIG_FIM", f.getData_final());
      if (f.getFil_filial().equals("")) {
        g.setParametro("P_LISTA_FILIAIS", f.getFiliais().equals("") ? "":f.getFiliais().replace("x","'"));
      } else {
        g.setParametro("P_LISTA_FILIAIS", "'"+f.getFil_filial() + "'");
      }
      if (f.getLin_cdgo().equals("")) {
        g.setParametro("P_LISTA_MODELOS", f.getLinhas().equals("") ? "''":f.getLinhas().replace("x","'"));
      } else {
        g.setParametro("P_LISTA_MODELOS", "'"+f.getLin_cdgo() + "'");
      }
      //--------------------------------------------------------------------------
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      if (u.getUsuario().equalsIgnoreCase("JORGE")) {
        g.setParametro("P_MARCA_ESPECIFICA", "S");
      }
      //--------------------------------------------------------------------------
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
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.removeAttribute("filiais_selecionadas");
      session.removeAttribute("linhas_selecionadas");
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
      Sbr0377ActionForm f = (Sbr0377ActionForm) form;
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
