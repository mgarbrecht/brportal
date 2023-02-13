package portalbr.exp;

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
 * Creation Date 02/04/2012 10:12:41
 * Last Modify Date 13/10/2015 08:06:38
 */

public class TabelaPrecosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      TabelaPrecosActionForm f = (TabelaPrecosActionForm) form;
      util.consultas.exp.TabelaPrecos tabela = new util.consultas.exp.TabelaPrecos();
      String arquivo = null;
      //----------------------------------------------------------
      if (f.getAbrir_cabedal().equalsIgnoreCase("N")) {
        arquivo = tabela.geraExcel(f.getCodigo_livro(), f.getVersao(), f.getDt_inicial().equals("") ? null : f.getDt_inicial(), f.getDt_final().equals("") ? null : f.getDt_final(), f.getMarca().equals("") ? null : f.getMarca(), f.getTipo_linha().equals("") ? null : f.getTipo_linha(), f.getCliente(), f.getPais(), f.getMix(), (java.util.List < Object[][] >) session.getAttribute("listaProdutos"), request);
      } else {
        arquivo = tabela.geraExcelCabedal(f.getCodigo_livro(), f.getVersao(), f.getDt_inicial().equals("") ? null : f.getDt_inicial(), f.getDt_final().equals("") ? null : f.getDt_final(), f.getMarca().equals("") ? null : f.getMarca(), f.getTipo_linha().equals("") ? null : f.getTipo_linha(), f.getCliente(), f.getPais(), f.getMix(), (java.util.List < Object[][] >) session.getAttribute("listaProdutos"), request);
      }
      if (arquivo.equals("")) {
        throw new Exception("Nenhum registro encontrado!");
      }

      //----------------------------------------------------------
      request.setAttribute("abre_automaticamente","N");
      //----------------------------------------------------------
      request.setAttribute("arquivo", arquivo);
      //----------------------------------------------------------


      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tabela_preco_mercado_externo", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      TabelaPrecosActionForm f = (TabelaPrecosActionForm) form;
      session.removeAttribute("res_Tabela_preco_mercado_externo");
      session.removeAttribute("listaProdutos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tabela_preco_mercado_externo", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      TabelaPrecosActionForm f = (TabelaPrecosActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Tabela_preco_mercado_externo", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
