package portalbr.acesso;

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
 * Creation Date 07/02/2006 09:03:44
 * Last Modify Date 29/07/2014 11:47:47
 */

public class DocumentosInterfacesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //--------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 07/02/2006
    // Data de Alteração :
    // Objetivo          : Faz a consulta na tabela documentos_interfaces usando os
    //                     campos doin_nome e doin_descricao como parâmetros.
    //                     Após a consulta, redireciona para o programa
    //                     /acesso/ListaDocumentosInterfacesForm.jsp para visualização
    //                     dos registros retornados.
    //---------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/acesso/ListaDocumentosInterfacesForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Documentos_interfaces", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DocumentosInterfacesActionForm f = (DocumentosInterfacesActionForm) form;
    portalbr.dbobj.table.Documentos_interfaces table = new portalbr.dbobj.table.Documentos_interfaces();
    String[][] select = null;
    String[] order = {"doin_nome"};
    Object[][] where = { {"Doin_id","=", com.egen.util.text.FormatNumber.toInteger(f.getDoin_id())}, {"upper(Doin_nome)","like", f.getDoin_nome().toUpperCase()}, {"upper(Doin_descricao)","like", f.getDoin_descricao().toUpperCase()} };
    Vector res_Documentos_interfaces = j.select(table, select, where, null, null, order);
    session.setAttribute("res_Documentos_interfaces",res_Documentos_interfaces);
    if (!(res_Documentos_interfaces != null && res_Documentos_interfaces.size() > 0)) {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }



  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DocumentosInterfacesActionForm f = (DocumentosInterfacesActionForm) form;
      session.removeAttribute("res_Documentos_interfaces");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Documentos_interfaces", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DocumentosInterfacesActionForm f = (DocumentosInterfacesActionForm) form;


      actionForward = new ActionForward("/acesso/DocumentosInterfaces_iForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Documentos_interfaces", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
