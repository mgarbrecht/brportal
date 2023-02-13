package portalbr.ind;

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
 * Creation Date 22/08/2014 10:26:00
 * Last Modify Date 03/10/2018 13:01:19
 */

public class ClientesTransportadoraAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ClientesTransportadoraActionForm f = (ClientesTransportadoraActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/ind/ClientesTransportadora_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_transportadora", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ClientesTransportadoraActionForm f = (ClientesTransportadoraActionForm) form;
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception("Query não disponível: javaview Jw_clientes_transportadora");
    }
    if (f.getCodigo_transportadora().equals("") && f.getCodigo_cliente().equals("")) {
      throw new Exception("Um dos parâmetros deve ser informado!");
    }
    Jw_clientes_transportadora table = new Jw_clientes_transportadora();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"consignatario","like", f.getConsignatarios()}, {"codigo_transportadora","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_transportadora())}, {"razao_transportadora","like", f.getRazao_transportadora()}, {"codigo_cliente","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_cliente())}, {"razao_social","like", f.getRazao_social()} };
    Vector res_Jw_clientes_transportadora = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_clientes_transportadora",res_Jw_clientes_transportadora);
    if (!(res_Jw_clientes_transportadora != null && res_Jw_clientes_transportadora.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ClientesTransportadoraActionForm f = (ClientesTransportadoraActionForm) form;
      session.removeAttribute("res_Jw_clientes_transportadora");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_transportadora", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
