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
 * Creation Date 12/12/2017 12:43:18
 * Last Modify Date 14/12/2017 11:42:52
 */

public class AcessosTrocaIdentidade_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcessosTrocaIdentidade_iActionForm f = (AcessosTrocaIdentidade_iActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
        tg_insert_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AcessosTrocaIdentidade_iActionForm f = (AcessosTrocaIdentidade_iActionForm) form;
    Acessos_troca_identidade table = new Acessos_troca_identidade();
    table.setAtid_usua_id(com.egen.util.text.FormatNumber.parseInt(f.getAtid_usua_id()));
    table.setAtid_tien_id(com.egen.util.text.FormatNumber.parseInt(f.getAtid_tien_id()));
    j.insert(table);
    Vector res_Acessos_troca_identidade = (Vector) session.getAttribute("res_Acessos_troca_identidade");
    if (res_Acessos_troca_identidade != null && table != null) {
      res_Acessos_troca_identidade.addElement(table);
      session.setAttribute("res_Acessos_troca_identidade", res_Acessos_troca_identidade);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_troca_identidade", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AcessosTrocaIdentidade_iActionForm f = (AcessosTrocaIdentidade_iActionForm) form;
      session.removeAttribute("res_Acessos_troca_identidade");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcessosTrocaIdentidade_iActionForm f = (AcessosTrocaIdentidade_iActionForm) form;


      actionForward = new ActionForward("/acesso/AcessosTrocaIdentidadeForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Acessos_troca_identidade", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
