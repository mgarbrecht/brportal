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
 * Creation Date 18/06/2010 14:46:45
 * Last Modify Date 21/06/2010 13:19:04
 */

public class LiberacaoPrecosPedAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_execute_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      LiberacaoPrecosPedActionForm f = (LiberacaoPrecosPedActionForm) form;
      try {
        execute_action(j, mapping, form, request, response);
        tg_execute_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_solicitacao_altera_precos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void execute_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    LiberacaoPrecosPedActionForm f = (LiberacaoPrecosPedActionForm) form;
    Prc_solicitacao_altera_precos r = new Prc_solicitacao_altera_precos();
    r.setP_nmro_solicitacao(f.getP_nmro_solicitacao());
    r.setP_libera(f.getP_libera());
    r = (Prc_solicitacao_altera_precos) j.execute(r);
    if (r != null) {
      f.setP_nmro_solicitacao((r.getP_nmro_solicitacao() != null) ? r.getP_nmro_solicitacao() + "":"");
      f.setP_libera((r.getP_libera() != null) ? r.getP_libera() + "":"");
    }
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_execute_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Prc_solicitacao_altera_precos", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
