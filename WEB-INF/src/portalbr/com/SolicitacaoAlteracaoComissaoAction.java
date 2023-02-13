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
 * Creation Date 09/01/2012 17:15:54
 * Last Modify Date 30/05/2018 16:42:00
 */

public class SolicitacaoAlteracaoComissaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoAlteracaoComissaoActionForm f = (SolicitacaoAlteracaoComissaoActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/SolicitacaoAlteracaoComissao_rForm.jsp",true);
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoAlteracaoComissaoActionForm f = (SolicitacaoAlteracaoComissaoActionForm) form;
    Solicita_prorrogacao table = new Solicita_prorrogacao();
    String[][] select = null;
    String[] order = {"decode(situacao,'P',1,'A',2,'R',3,'L',4,4)","data_solicitacao desc",};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"nfs_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getNfs_nmro())}, {"nfs_serie","like", f.getNfs_serie()}, {"emp_empresa","like", f.getEmp_empresa()}, {"fil_filial","like", f.getFil_filial()}, {"nro_dias_prorrogacao","=", com.egen.util.text.FormatNumber.toInteger(f.getNro_dias_prorrogacao())}, {"valor_calculado","=", com.egen.util.text.FormatNumber.toDouble(f.getValor_calculado())}, {"data_solicitacao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_solicitacao(), "dd/MM/yyyy")}, {"situacao","like", f.getSituacao()}, {"data_aprovacao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_aprovacao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_aprovacao","like", f.getUsuario_aprovacao()} };
    Vector res_Solicita_prorrogacao = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Solicita_prorrogacao",res_Solicita_prorrogacao);
    if (!(res_Solicita_prorrogacao != null && res_Solicita_prorrogacao.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrogacao", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoAlteracaoComissaoActionForm f = (SolicitacaoAlteracaoComissaoActionForm) form;
      session.removeAttribute("res_Solicita_prorrogacao");
      form.reset(mapping, request);
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

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoAlteracaoComissaoActionForm f = (SolicitacaoAlteracaoComissaoActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoAlteracaoComissao_iForm.jsp",true);
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
}
