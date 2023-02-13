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
 * Creation Date 07/02/2006 09:16:58
 * Last Modify Date 27/08/2009 16:25:07
 */

public class ListaDocumentosInterfacesAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    //                     TechnoCorp - Tecnologia e Software
    //---------------------------------------------------------------------------------------
    // Data de Criação   : 07/02/2006
    // Data de Alteração :
    // Objetivo          : Redireciona para a tela de filtro de Documentos/Interfaces:
    //                     /acesso/DocumentosInterfacesForm.jsp
    //----------------------------------------------------------------------------------------

    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/acesso/DocumentosInterfacesForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_gerar_autorizacao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    //                     TechnoCorp - Tecnologia e Software
    //------------------------------------------------------------------------------------------
    // Data de Criação   : 07/02/2006
    // Data de Alteração :
    // Objetivo          : Gera autorização baseado nos Documentos/Interfaces presentes na lista
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ListaDocumentosInterfacesActionForm f = (ListaDocumentosInterfacesActionForm) form;
      //-----------------------------------------------------------------------------------------
      portalbr.dbobj.table.Documentos_interfaces t_documentos_interfaces = new portalbr.dbobj.table.Documentos_interfaces();
      java.util.Vector res_Documentos_interfaces = (java.util.Vector) session.getAttribute("res_Documentos_interfaces");
      if (res_Documentos_interfaces != null && res_Documentos_interfaces.size() > 0) {
        acesso.AcessoDocumentoInterfaceAPI documento = new acesso.AcessoDocumentoInterfaceAPI(j.getConn());
        int doin_id = 0;
        for (int x = 0; x < res_Documentos_interfaces.size(); x++) {
          t_documentos_interfaces = (portalbr.dbobj.table.Documentos_interfaces) res_Documentos_interfaces.elementAt(x);
          doin_id = t_documentos_interfaces.getDoin_id();
          documento.geraAutorizacoes(doin_id);
        }
      }
      //-----------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_gerar_autorizacao_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
