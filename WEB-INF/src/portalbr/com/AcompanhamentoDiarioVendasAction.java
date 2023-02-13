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
 * Creation Date 07/05/2014 08:52:06
 * Last Modify Date 10/08/2022 12:15:32
 */

public class AcompanhamentoDiarioVendasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AcompanhamentoDiarioVendasActionForm f = (AcompanhamentoDiarioVendasActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/AcompanhamentoDiarioVendas_rForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acompanhamento_diario_vendas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    AcompanhamentoDiarioVendasActionForm f = (AcompanhamentoDiarioVendasActionForm) form;
    if (f.getData_inicial().equals("") || f.getData_final().equals("")) {
      throw new Exception("O período do ano atual deve ser informado!");
    }

    if (f.getData_anterior_inicial().equals("") || f.getData_anterior_final().equals("")) {
      throw new Exception("O período do ano anterior ser informado!");
    }

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      //     throw new Exception(sb.toString() + " *** Total Marcas *** " + sb3.toString() + " *** Total Regionais *** " + sb2.toString() + " *** Total Geral *** " + sbt.toString());
    }

    util.consultas.com.AcompanhamentoDiarioVendas acompanhamento = new util.consultas.com.AcompanhamentoDiarioVendas(request, f);
    acompanhamento.processar();
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AcompanhamentoDiarioVendasActionForm f = (AcompanhamentoDiarioVendasActionForm) form;
      session.removeAttribute("res_Jw_acompanhamento_diario_vendas");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_acompanhamento_diario_vendas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
