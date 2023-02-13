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
 * Creation Date 16/01/2012 16:11:55
 * Last Modify Date 02/04/2013 13:50:15
 */

public class AprovacaoAlteracaoComissao_pAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AprovacaoAlteracaoComissao_pActionForm f = (AprovacaoAlteracaoComissao_pActionForm) form;
      insert_action(j, mapping, form, request, response);
      tg_insert_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrog_lancamentos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    util.consultas.Query query = new util.consultas.Query();
    AprovacaoAlteracaoComissao_pActionForm f = (AprovacaoAlteracaoComissao_pActionForm) form;
    double valor = Double.parseDouble(query.retorna("SELECT valor_calculado FROM brio.solicita_prorrogacao WHERE id_solicitacao = "+f.getId_solicitacao()));
    double valor_parcial = Double.parseDouble(query.retorna("SELECT nvl(SUM(valor_lancamento),0) FROM brio.solicita_prorrog_lancamentos l WHERE l.id_solicitacao = "+f.getId_solicitacao()));
    double novo_valor = Double.parseDouble(f.getValor_lancamento());
    String seq = query.retorna(j, "SELECT nvl(MAX(id_lancamento),0)+1 FROM brio.solicita_prorrog_lancamentos WHERE id_solicitacao = "+f.getId_solicitacao());
    String motivo = null;
    if (f.getMotivo() != "") {
      motivo = "'"+f.getMotivo() + "'";
    } else {
      motivo = "null";
    }

    if (valor < (valor_parcial + novo_valor)) {
      throw new Exception("Valor parcial não pode ser maior que o valor solicitado!");
    }

    query.execute(j, "INSERT INTO brio.solicita_prorrog_lancamentos VALUES ("+f.getId_solicitacao() + ", "+seq + ", "+novo_valor + ", sysdate, '"+sessao.getUsuario() + "', "+motivo + " )");

    if (valor == (valor_parcial + novo_valor)) {
      query.execute(j, "UPDATE brio.solicita_prorrogacao SET data_aprovacao = SYSDATE, usuario_aprovacao = '"+sessao.getUsuario() + "' , situacao = 'A' WHERE id_solicitacao = "+f.getId_solicitacao());
      request.setAttribute("aprovado", "S");
      request.setAttribute("solicitacao", f.getId_solicitacao());
    }

    f.setValor_lancamento("");
    f.setMotivo("");
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrog_lancamentos", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      AprovacaoAlteracaoComissao_pActionForm f = (AprovacaoAlteracaoComissao_pActionForm) form;
      f.setMotivo("");
      f.setValor_lancamento("");
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrog_lancamentos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("AprovacaoAlteracaoComissao_pActionForm", form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrog_lancamentos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


}
