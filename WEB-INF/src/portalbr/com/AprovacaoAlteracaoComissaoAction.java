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
 * Creation Date 09/01/2012 17:16:15
 * Last Modify Date 02/04/2013 13:51:51
 */

public class AprovacaoAlteracaoComissaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_aprovar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AprovacaoAlteracaoComissaoActionForm f = (AprovacaoAlteracaoComissaoActionForm) form;
      aprovar_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrogacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void aprovar_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    util.consultas.Query query = new util.consultas.Query();
    AprovacaoAlteracaoComissaoActionForm f = (AprovacaoAlteracaoComissaoActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    query.execute(j, "UPDATE brio.solicita_prorrogacao SET data_aprovacao = SYSDATE, usuario_aprovacao = '"+sessao.getUsuario() + "' , situacao = 'A' WHERE id_solicitacao = "+f.getId_solicitacao());
  }

  public ActionForward perform_recusar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AprovacaoAlteracaoComissaoActionForm f = (AprovacaoAlteracaoComissaoActionForm) form;
      try {
        recusar_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrogacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void recusar_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    util.consultas.Query query = new util.consultas.Query();
    AprovacaoAlteracaoComissaoActionForm f = (AprovacaoAlteracaoComissaoActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    query.execute(j, "UPDATE brio.solicita_prorrogacao SET situacao = 'R' WHERE id_solicitacao = "+f.getId_solicitacao());
  }
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AprovacaoAlteracaoComissaoActionForm f = (AprovacaoAlteracaoComissaoActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrogacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
