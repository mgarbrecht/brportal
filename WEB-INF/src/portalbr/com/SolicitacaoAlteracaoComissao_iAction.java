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
 * Creation Date 10/01/2012 10:26:37
 * Last Modify Date 03/04/2013 13:11:03
 */

public class SolicitacaoAlteracaoComissao_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoAlteracaoComissao_iActionForm f = (SolicitacaoAlteracaoComissao_iActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoAlteracaoComissao_iActionForm f = (SolicitacaoAlteracaoComissao_iActionForm) form;
    Solicita_prorrogacao table = new Solicita_prorrogacao();
    String[][] select = null;
    String[] order = null;
    String[] groupby = null;
    String[] having = null;
    Object[][] where = { {"id_solicitacao","=", com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"nfs_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getNfs_nmro())}, {"nfs_serie","like", f.getNfs_serie()}, {"emp_empresa","like", f.getEmp_empresa()}, {"fil_filial","like", f.getFil_filial()}, {"valor_calculado","=", com.egen.util.text.FormatNumber.toDouble(f.getValor_calculado())}, {"nro_dias_prorrogacao","=", com.egen.util.text.FormatNumber.toInteger(f.getNro_dias_prorrogacao())}, {"data_solicitacao","=", com.egen.util.text.FormatDate.parseTimestamp(f.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_solicitacao","like", f.getUsuario_solicitacao()}, {"situacao","like", f.getSituacao()}, {"comissao_nova","=", com.egen.util.text.FormatNumber.toDouble(f.getComissao_nova())}, {"valor_calculado","=", com.egen.util.text.FormatNumber.toDouble(f.getValor_calculado1())}, {"motivo","like", f.getMotivo()} };
    Vector res_Solicita_prorrogacao = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Solicita_prorrogacao",res_Solicita_prorrogacao);
    if (res_Solicita_prorrogacao != null && res_Solicita_prorrogacao.size() > 0) {
      Solicita_prorrogacao r = (Solicita_prorrogacao) res_Solicita_prorrogacao.elementAt(0);
      f.setId_solicitacao((r.getId_solicitacao() != null) ? r.getId_solicitacao() + "":"");
      f.setNfs_nmro((r.getNfs_nmro() != null) ? r.getNfs_nmro() + "":"");
      f.setNfs_serie((r.getNfs_serie() != null) ? r.getNfs_serie() + "":"");
      f.setEmp_empresa((r.getEmp_empresa() != null) ? r.getEmp_empresa() + "":"");
      f.setFil_filial((r.getFil_filial() != null) ? r.getFil_filial() + "":"");
      f.setValor_calculado((r.getValor_calculado() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_calculado(), "##,##0.00") : "");
      f.setNro_dias_prorrogacao((r.getNro_dias_prorrogacao() != null) ? r.getNro_dias_prorrogacao() + "":"");
      f.setData_solicitacao(com.egen.util.text.FormatDate.format(r.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss"));
      f.setUsuario_solicitacao((r.getUsuario_solicitacao() != null) ? r.getUsuario_solicitacao() + "":"");
      f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
      f.setComissao_nova((r.getComissao_nova() != null) ? com.egen.util.text.FormatNumber.format(r.getComissao_nova(), "##,##0.00") : "");
      f.setValor_calculado1((r.getValor_calculado() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_calculado(), "##,##0.00") : "");
      f.setMotivo((r.getMotivo() != null) ? r.getMotivo() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrogacao", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoAlteracaoComissao_iActionForm f = (SolicitacaoAlteracaoComissao_iActionForm) form;
      try {
        tg_insert_action_1(mapping, form, request, response);
        insert_action(j, mapping, form, request, response);
        tg_insert_action(mapping, form, request, response);
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
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    SolicitacaoAlteracaoComissao_iActionForm f = (SolicitacaoAlteracaoComissao_iActionForm) form;
    Solicita_prorrogacao table = new Solicita_prorrogacao();
    Object[][] name_value = { {"id_solicitacao",com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"nfs_nmro",com.egen.util.text.FormatNumber.toInteger(f.getNfs_nmro())}, {"nfs_serie",f.getNfs_serie()}, {"emp_empresa",f.getEmp_empresa()}, {"fil_filial",f.getFil_filial()}, {"valor_calculado",com.egen.util.text.FormatNumber.toDouble(f.getValor_calculado())}, {"nro_dias_prorrogacao",com.egen.util.text.FormatNumber.toInteger(f.getNro_dias_prorrogacao())}, {"data_solicitacao",com.egen.util.text.FormatDate.parseTimestamp(f.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss")}, {"usuario_solicitacao",f.getUsuario_solicitacao()}, {"situacao",f.getSituacao()}, {"comissao_nova",com.egen.util.text.FormatNumber.toDouble(f.getComissao_nova())}, {"valor_calculado",com.egen.util.text.FormatNumber.toDouble(f.getValor_calculado1())}, {"motivo",f.getMotivo()}, };
    j.insert(table, name_value);
    Vector res_Solicita_prorrogacao = (Vector) session.getAttribute("res_Solicita_prorrogacao");
    if (res_Solicita_prorrogacao != null && table != null) {
      res_Solicita_prorrogacao.addElement(table);
      session.setAttribute("res_Solicita_prorrogacao", res_Solicita_prorrogacao);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Solicita_prorrogacao", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }
  private void tg_insert_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      SolicitacaoAlteracaoComissao_iActionForm f = (SolicitacaoAlteracaoComissao_iActionForm) form;
      if (f.getTipo().equals("P")) {
        if (f.getNro_dias_prorrogacao().equals("")) {
          throw new Exception("Nro. Dias Prorrogação deve ser informado!");
        }
      } else {
        if (f.getComissao_nova().equals("") || f.getValor_calculado1().equals("")) {
          throw new Exception("Comissão Nova e Valor Abatimento devem ser informados!");
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoAlteracaoComissao_iActionForm f = (SolicitacaoAlteracaoComissao_iActionForm) form;
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

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoAlteracaoComissao_iActionForm f = (SolicitacaoAlteracaoComissao_iActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoAlteracaoComissaoForm.jsp",true);
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
  public ActionForward perform_blank_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoAlteracaoComissao_iActionForm f = (SolicitacaoAlteracaoComissao_iActionForm) form;
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
}
