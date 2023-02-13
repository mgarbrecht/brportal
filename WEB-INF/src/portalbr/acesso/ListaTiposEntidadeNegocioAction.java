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
 * Creation Date 18/01/2006 09:21:21
 * Last Modify Date 25/02/2016 11:32:53
 */

public class ListaTiposEntidadeNegocioAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht
    //                     TechnoCorp - Tecnologia e Software
    //---------------------------------------------------------------------------------------
    // Data de Criação   : 18/01/2006
    // Data de Alteração :
    // Objetivo          : Redireciona para a tela de filtro de Tipos de Entidade de Negócio:
    //                     /acesso/TiposEntidadeNegocioForm.jsp
    //----------------------------------------------------------------------------------------

    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/acesso/TiposEntidadeNegocioForm.jsp",true);
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
