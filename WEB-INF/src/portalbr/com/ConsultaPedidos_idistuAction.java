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
 * Creation Date 11/01/2016 15:08:16
 * Last Modify Date 22/01/2016 16:45:28
 */

public class ConsultaPedidos_idistuAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPedidos_idistuActionForm f = (ConsultaPedidos_idistuActionForm) form;
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
    ConsultaPedidos_idistuActionForm f = (ConsultaPedidos_idistuActionForm) form;
    Jw_consulta_pedidos_distribuicao table = new Jw_consulta_pedidos_distribuicao();
    session.removeAttribute("possui_distribuicao");
    String[][] select = null;
    Object[][] where = { {"ped_nmro","=", com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())} };
    Vector res_Jw_consulta_pedidos_distribuicao = j.select(table, select, where, null, null, null);
    session.setAttribute("res_Jw_consulta_pedidos_distribuicao",res_Jw_consulta_pedidos_distribuicao);
    if (res_Jw_consulta_pedidos_distribuicao != null && res_Jw_consulta_pedidos_distribuicao.size() > 0) {
      Jw_consulta_pedidos_distribuicao r = (Jw_consulta_pedidos_distribuicao) res_Jw_consulta_pedidos_distribuicao.elementAt(0);
      f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
      int quantidadeCaixasDistribuidas = 0;
      int indice = 0;
      portalbr.dbobj.view.Jw_consulta_pedidos_distribuicao t_jw_consulta_pedidos_distribuicao = new portalbr.dbobj.view.Jw_consulta_pedidos_distribuicao();
      while (indice < res_Jw_consulta_pedidos_distribuicao.size()) {
        t_jw_consulta_pedidos_distribuicao = (portalbr.dbobj.view.Jw_consulta_pedidos_distribuicao) res_Jw_consulta_pedidos_distribuicao.elementAt(indice);
        quantidadeCaixasDistribuidas += t_jw_consulta_pedidos_distribuicao.getQtde_caixas_distribuidas();
        indice++;
      }
      if (quantidadeCaixasDistribuidas > 0) {
        session.setAttribute("possui_distribuicao","s");
      }
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos_distribuicao", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      ConsultaPedidos_idistuActionForm f = (ConsultaPedidos_idistuActionForm) form;
      query.execute("DELETE ite_distribuicao_cliente WHERE ped_nmro = "+ f.getPed_nmro());
      int indice = 0;
      java.util.Vector res_Jw_consulta_pedidos_distribuicao = (java.util.Vector) session.getAttribute("res_Jw_consulta_pedidos_distribuicao");
      portalbr.dbobj.view.Jw_consulta_pedidos_distribuicao t_jw_consulta_pedidos_distribuicao = new portalbr.dbobj.view.Jw_consulta_pedidos_distribuicao();
      Ite_distribuicao_cliente table = new Ite_distribuicao_cliente();
      while (indice < res_Jw_consulta_pedidos_distribuicao.size()) {
        t_jw_consulta_pedidos_distribuicao = (portalbr.dbobj.view.Jw_consulta_pedidos_distribuicao) res_Jw_consulta_pedidos_distribuicao.elementAt(indice);
        Object[][] name_value = { {"ped_nmro", t_jw_consulta_pedidos_distribuicao.getPed_nmro()}, {"ite_seqn", t_jw_consulta_pedidos_distribuicao.getItem()}, {"cliente", f.getLoja().toUpperCase()}, {"qtd_caixas", t_jw_consulta_pedidos_distribuicao.getTotal_caixas()} };
        j.insert(table, name_value);
        indice++;
      }


      indice = 0;
      java.util.Vector res_Jw_consulta_pedidos_grade = (java.util.Vector) session.getAttribute("res_Jw_consulta_pedidos_grade");
      while (indice < res_Jw_consulta_pedidos_grade.size()) {
        portalbr.dbobj.view.Jw_consulta_pedidos_grade t_jw_consulta_pedidos_grade = (portalbr.dbobj.view.Jw_consulta_pedidos_grade) res_Jw_consulta_pedidos_grade.elementAt(indice);
        t_jw_consulta_pedidos_grade.setDistribuicao("s");
        indice ++;
      }

      tg_update_action(mapping, form, request, response);
      request.setAttribute("atualizou", "s");
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

}
