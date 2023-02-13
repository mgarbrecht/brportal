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
 * Creation Date 07/02/2006 09:59:39
 * Last Modify Date 26/05/2015 14:52:43
 */

public class DocumentosInterfaces_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //--------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 07/02/2006
    // Data de Alteração :
    // Objetivo          : Atualiza um registro da tabela documentos_interfaces. Após
    //                     a atualização, retorna pra tela de lista de Documentos /
    //                     Interfaces : /acesso/ListaDocumentosInterfacesForm.jsp
    //---------------------------------------------------------------------------------

    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      update_action(j, mapping, form, request, response);
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DocumentosInterfaces_aActionForm f = (DocumentosInterfaces_aActionForm) form;
    portalbr.dbobj.table.Documentos_interfaces table = new portalbr.dbobj.table.Documentos_interfaces();
    table.setDoin_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getDoin_id()));
    table.setDoin_nome(f.getDoin_nome());
    table.setDoin_descricao(f.getDoin_descricao());
    //-----------------------------------------------------------------------------
    acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn());
    documento.select(Integer.parseInt(f.getDoin_id()));
    documento.setNome(f.getDoin_nome());
    documento.setDescricao(f.getDoin_descricao());
    documento.update();
    //-----------------------------------------------------------------------------
    Vector res_Documentos_interfaces = (Vector) session.getAttribute("res_Documentos_interfaces");
    if (res_Documentos_interfaces != null) {
      res_Documentos_interfaces.setElementAt(table, Integer.parseInt(f.getPos()));
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //--------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 07/02/2006
    // Data de Alteração :
    // Objetivo          : Deleta um registro da tabela documentos_interfaces. Após
    //                     a deleção, retorna pra tela de lista de Documentos /
    //                     Interfaces : /acesso/ListaDocumentosInterfacesForm.jsp
    //---------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      delete_action(j, mapping, form, request, response);
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DocumentosInterfaces_aActionForm f = (DocumentosInterfaces_aActionForm) form;
    //------------------------------------------------------------------------------------------
    acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn());
    documento.select(Integer.parseInt(f.getDoin_id()));
    documento.delete();
    //------------------------------------------------------------------------------------------
    Vector res_Documentos_interfaces = (Vector) session.getAttribute("res_Documentos_interfaces");
    if (res_Documentos_interfaces != null && res_Documentos_interfaces.size() > 0) {
      res_Documentos_interfaces.removeElementAt(Integer.parseInt(f.getPos()));
    } else {
      f.reset(mapping, request);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DocumentosInterfaces_aActionForm f = (DocumentosInterfaces_aActionForm) form;


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
      }
    }
    return actionForward;
  }
  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("DocumentosInterfaces_aActionForm", form);
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


}
