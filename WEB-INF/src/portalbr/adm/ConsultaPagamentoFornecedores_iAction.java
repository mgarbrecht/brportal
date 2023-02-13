package portalbr.adm;

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
 * Creation Date 12/03/2018 11:12:12
 * Last Modify Date 12/03/2018 12:15:20
 */

public class ConsultaPagamentoFornecedores_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPagamentoFornecedores_iActionForm f = (ConsultaPagamentoFornecedores_iActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPagamentoFornecedores_iActionForm f = (ConsultaPagamentoFornecedores_iActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    String mensagem = query.retorna(j, "SELECT valor FROM wbrio.parametros WHERE nome = 'comunicado_geral_consulta_fornecedores' AND par_sist_codigo = 'BRNET'");
    String mostrar = query.retorna(j, "SELECT valor FROM wbrio.parametros WHERE nome = 'mostra_comunicado_geral_consulta_fornecedores' AND par_sist_codigo = 'BRNET'");
    f.setComunicado(mensagem.replaceAll("<br />","\n"));
    f.setMostrar(mostrar);
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPagamentoFornecedores_iActionForm f = (ConsultaPagamentoFornecedores_iActionForm) form;
      update_action(j, mapping, form, request, response);
      tg_update_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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

  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ConsultaPagamentoFornecedores_iActionForm f = (ConsultaPagamentoFornecedores_iActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    query.execute("UPDATE wbrio.parametros SET valor = '"+f.getMostrar() + "' WHERE nome = 'mostra_comunicado_geral_consulta_fornecedores' AND par_sist_codigo = 'BRNET'");
    query.execute("UPDATE wbrio.parametros SET valor = trim('"+f.getComunicado().replaceAll("(\\r\\n|\\n)", "<br />") + "') WHERE nome = 'comunicado_geral_consulta_fornecedores' AND par_sist_codigo = 'BRNET'");
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Parametros", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
