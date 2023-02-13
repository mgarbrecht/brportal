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
 * Creation Date 01/10/2012 14:59:35
 * Last Modify Date 04/10/2012 13:08:43
 */

public class FichaCliente_icAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichaCliente_icActionForm f = (FichaCliente_icActionForm) form;
      try {
        insert_action(j, mapping, form, request, response);
        tg_insert_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Informacoes_cliente", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    acesso.Sessao sessao = new acesso.Sessao(session);
    Integer cli_cdgo = session.getAttribute("cli_cdgo") != null ? Integer.parseInt(((String) session.getAttribute("cli_cdgo"))) : null;
    Integer esc_seqn = session.getAttribute("esc_seqn") != null ? Integer.parseInt(((String) session.getAttribute("esc_seqn"))) : null;
    Integer gre_grupo = session.getAttribute("gre_grupo") != null ? Integer.parseInt(((String) session.getAttribute("gre_grupo"))) : null;


    util.consultas.Sequence sequence = new util.consultas.Sequence();
    FichaCliente_icActionForm f = (FichaCliente_icActionForm) form;
    Informacoes_cliente table = new Informacoes_cliente();
    Object[][] name_value = { {"sequencia", sequence.nextValue("informacoes_cliente","sequencia")}, {"data_informacao", new java.sql.Timestamp(new java.util.Date().getTime())}, {"usuario",sessao.getUsuario()}, {"cli_cdgo",cli_cdgo}, {"esc_seqn",esc_seqn}, {"gre_cdgo",gre_grupo}, {"informacoes",f.getInformacoes()} };
    j.insert(table, name_value);
    Vector res_Informacoes_cliente = (Vector) session.getAttribute("res_Informacoes_cliente");
    if (res_Informacoes_cliente != null && table != null) {
      res_Informacoes_cliente.addElement(table);
      session.setAttribute("res_Informacoes_cliente", res_Informacoes_cliente);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Informacoes_cliente", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    request.setAttribute("inseriu_ok","ok");
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FichaCliente_icActionForm f = (FichaCliente_icActionForm) form;
      session.removeAttribute("res_Informacoes_cliente");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Informacoes_cliente", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
