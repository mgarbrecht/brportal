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
 * Creation Date 08/01/2016 12:02:01
 * Last Modify Date 25/11/2016 11:07:07
 */

public class ConsultaPedidos_idistAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      util.consultas.Query query = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidos_idistActionForm f = (ConsultaPedidos_idistActionForm) form;
      java.util.Vector res_Ite_distribuicao_cliente = (java.util.Vector) session.getAttribute("res_Ite_distribuicao_cliente");
      int indice = 0;
      int quantidadeCaixasInformadas = 0;
      int totalCaixasItem = Integer.parseInt((String) session.getAttribute("quantidade_caixas_item"));
      while (indice < res_Ite_distribuicao_cliente.size()) {
        portalbr.dbobj.table.Ite_distribuicao_cliente t_ite_distribuicao_cliente = (portalbr.dbobj.table.Ite_distribuicao_cliente) res_Ite_distribuicao_cliente.elementAt(indice);
        quantidadeCaixasInformadas += t_ite_distribuicao_cliente.getQtd_caixas();
        indice ++;
      }
      if (quantidadeCaixasInformadas > totalCaixasItem) {
        throw new Exception("A quantidadade de caixas informadas é maior do que a quantidade de caixas do item!");
      }
      if (quantidadeCaixasInformadas < totalCaixasItem) {
        throw new Exception("A quantidadade de caixas informadas é menor do que a quantidade de caixas do item!");
      }
      query.execute("DELETE ite_distribuicao_cliente WHERE ped_nmro = "+(String) session.getAttribute("distribuicao_ped_nmro") + " AND ite_seqn = " + (String) session.getAttribute("distribuicao_item"));
      indice = 0;
      Ite_distribuicao_cliente table = new Ite_distribuicao_cliente();
      while (indice < res_Ite_distribuicao_cliente.size()) {
        portalbr.dbobj.table.Ite_distribuicao_cliente t_ite_distribuicao_cliente = (portalbr.dbobj.table.Ite_distribuicao_cliente) res_Ite_distribuicao_cliente.elementAt(indice);
        Object[][] name_value = { {"ped_nmro",com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"ite_seqn",com.egen.util.text.FormatNumber.toInteger(f.getItem())}, {"cliente",t_ite_distribuicao_cliente.getCliente()}, {"qtd_caixas", t_ite_distribuicao_cliente.getQtd_caixas()} };
        j.insert(table, name_value);
        indice ++;
        request.setAttribute("fechar", "S");
      }
      indice = 0;
      java.util.Vector res_Jw_consulta_pedidos_grade = (java.util.Vector) session.getAttribute("res_Jw_consulta_pedidos_grade");
      while (indice < res_Jw_consulta_pedidos_grade.size()) {
        portalbr.dbobj.view.Jw_consulta_pedidos_grade t_jw_consulta_pedidos_grade = (portalbr.dbobj.view.Jw_consulta_pedidos_grade) res_Jw_consulta_pedidos_grade.elementAt(indice);
        if (t_jw_consulta_pedidos_grade.getPed_nmro() == Double.parseDouble(f.getPed_nmro()) && (t_jw_consulta_pedidos_grade.getItem() + "").equals(f.getItem())) {
          t_jw_consulta_pedidos_grade.setDistribuicao("s");
        }
        indice ++;
      }
      tg_update_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_adicionar_item_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidos_idistActionForm f = (ConsultaPedidos_idistActionForm) form;
      java.util.Vector res_Ite_distribuicao_cliente = (java.util.Vector) session.getAttribute("res_Ite_distribuicao_cliente");
      int indice = 0;
      int quantidadeCaixasInformadas = 0;
      int totalCaixasItem = Integer.parseInt(f.getTotal_caixas());
      while (indice < res_Ite_distribuicao_cliente.size()) {
        portalbr.dbobj.table.Ite_distribuicao_cliente t_ite_distribuicao_cliente = (portalbr.dbobj.table.Ite_distribuicao_cliente) res_Ite_distribuicao_cliente.elementAt(indice);
        if (f.getLoja().equalsIgnoreCase(t_ite_distribuicao_cliente.getCliente())) {
          throw new Exception("A loja "+f.getLoja().toUpperCase() + " já foi informada!");
        }
        quantidadeCaixasInformadas += t_ite_distribuicao_cliente.getQtd_caixas();
        indice ++;
      }

      if ((quantidadeCaixasInformadas + Integer.parseInt(f.getCaixas())) > totalCaixasItem) {
        throw new Exception("A quantidadade de caixas informadas é maior do que a quantidade de caixas do item!");
      }

      Ite_distribuicao_cliente ite = new Ite_distribuicao_cliente();
      ite.setPed_nmro(Integer.parseInt((String) session.getAttribute("distribuicao_ped_nmro")));
      ite.setIte_seqn(Integer.parseInt((String) session.getAttribute("distribuicao_item")));
      ite.setCliente(f.getLoja().toUpperCase());
      ite.setQtd_caixas(Integer.parseInt(f.getCaixas()));
      res_Ite_distribuicao_cliente.add(ite);
      session.setAttribute("quantidade_caixas_distribuidas", (quantidadeCaixasInformadas + Integer.parseInt(f.getCaixas())) + "");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidos_idistActionForm f = (ConsultaPedidos_idistActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaPedidos_idistActionForm f = (ConsultaPedidos_idistActionForm) form;
    Jw_consulta_pedidos_distribuicao table = new Jw_consulta_pedidos_distribuicao();
    String[][] select = null;
    Object[][] where = { {"ped_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"item","=", com.egen.util.text.FormatNumber.toInteger(f.getItem())}, {"quantidade_pares","=", com.egen.util.text.FormatNumber.toInteger(f.getQuantidade_pares())}, {"grade","=", com.egen.util.text.FormatNumber.toInteger(f.getGrade())}, {"codigo_corrugado","=", com.egen.util.text.FormatNumber.toInteger(f.getCodigo_corrugado())}, {"qt_par_corrug","=", com.egen.util.text.FormatNumber.toInteger(f.getQt_par_corrug())}, {"total_caixas","=", com.egen.util.text.FormatNumber.toInteger(f.getTotal_caixas())}, {"descricao_corrugado","like", f.getDescricao_corrugado()}, };
    Vector res_Jw_consulta_pedidos_distribuicao = j.select(table, select, where, null, null, null);
    session.setAttribute("res_Jw_consulta_pedidos_distribuicao",res_Jw_consulta_pedidos_distribuicao);
    if (res_Jw_consulta_pedidos_distribuicao != null && res_Jw_consulta_pedidos_distribuicao.size() > 0) {
      Jw_consulta_pedidos_distribuicao r = (Jw_consulta_pedidos_distribuicao) res_Jw_consulta_pedidos_distribuicao.elementAt(0);
      f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
      f.setItem((r.getItem() != null) ? r.getItem() + "":"");
      f.setQuantidade_pares((r.getQuantidade_pares() != null) ? r.getQuantidade_pares() + "":"");
      f.setGrade((r.getGrade() != null) ? r.getGrade() + "":"");
      f.setCodigo_corrugado((r.getCodigo_corrugado() != null) ? r.getCodigo_corrugado() + "":"");
      f.setQt_par_corrug((r.getQt_par_corrug() != null) ? r.getQt_par_corrug() + "":"");
      f.setTotal_caixas((r.getTotal_caixas() != null) ? r.getTotal_caixas() + "":"");
      f.setQtde_caixas_distribuidas((r.getQtde_caixas_distribuidas() != null) ? r.getQtde_caixas_distribuidas() + "":"");
      f.setDescricao_corrugado((r.getDescricao_corrugado() != null) ? r.getDescricao_corrugado() + "":"");
      session.setAttribute("distribuicao_ped_nmro", r.getPed_nmro() + "");
      session.setAttribute("distribuicao_item", r.getItem() + "");
      session.setAttribute("quantidade_caixas_item", r.getTotal_caixas() + "");
      session.setAttribute("quantidade_caixas_distribuidas", r.getQtde_caixas_distribuidas() + "");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    Ite_distribuicao_cliente tablei = new Ite_distribuicao_cliente();
    String[][] selecti = null;
    Object[][] wherei = { {"ped_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"ite_seqn","=", com.egen.util.text.FormatNumber.toInteger(f.getItem())}, };
    Vector res_Ite_distribuicao_cliente = j.select(tablei, selecti, wherei, null, null, null);
    session.setAttribute("res_Ite_distribuicao_cliente",res_Ite_distribuicao_cliente);
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPedidos_idistActionForm f = (ConsultaPedidos_idistActionForm) form;
      session.removeAttribute("res_Jw_consulta_pedidos_distribuicao");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidos_idistActionForm f = (ConsultaPedidos_idistActionForm) form;
      java.util.Vector res_Ite_distribuicao_cliente = (java.util.Vector) session.getAttribute("res_Ite_distribuicao_cliente");
      res_Ite_distribuicao_cliente.removeElementAt(Integer.parseInt(f.getIndex()));


      int indice = 0;
      int quantidadeCaixasInformadas = 0;
      while (indice < res_Ite_distribuicao_cliente.size()) {
        portalbr.dbobj.table.Ite_distribuicao_cliente t_ite_distribuicao_cliente = (portalbr.dbobj.table.Ite_distribuicao_cliente) res_Ite_distribuicao_cliente.elementAt(indice);
        quantidadeCaixasInformadas += t_ite_distribuicao_cliente.getQtd_caixas();
        indice ++;
      }
      session.setAttribute("quantidade_caixas_distribuidas", quantidadeCaixasInformadas + "");


      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
