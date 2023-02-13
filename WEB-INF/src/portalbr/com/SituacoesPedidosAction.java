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
 * Creation Date 24/08/2007 17:46:11
 * Last Modify Date 20/08/2013 08:08:34
 */

public class SituacoesPedidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SituacoesPedidosActionForm f = (SituacoesPedidosActionForm) form;
      try {
        tg_select_action(mapping, form, request, response);
        select_action(j, mapping, form, request, response);
        tg_select_action_1(mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/SituacoesPedidos_RelForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacoes_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    SituacoesPedidosActionForm f = (SituacoesPedidosActionForm) form;
    portalbr.dbobj.view.Jw_situacoes_pedidos table = new portalbr.dbobj.view.Jw_situacoes_pedidos();
    String[][] select = null;
    String[] order = {"dt_cad_situacao asc"};
    String[] groupby = null;
    String[] having = null;
    Object[][] where = {{"Ped_nmro","=", com.egen.util.text.FormatNumber.toLong(f.getPed_nmro())},};
    Vector res_Jw_situacoes_pedidos = j.select(table, select, where, groupby, having, order);
    session.setAttribute("res_Jw_situacoes_pedidos",res_Jw_situacoes_pedidos);
    if (!(res_Jw_situacoes_pedidos != null && res_Jw_situacoes_pedidos.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacoes_pedidos", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    com.egen.util.jdbc.JdbcUtil j = null;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      //----------------------------
      StringBuilder query = new StringBuilder();
      String tipo = "";
      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
        tipo = tipoent.getTipo() + "";
        if (tipo.equals("REGIONAL DE VENDA")) {
          query.append(" AND r.codigo_regional = ").append(ent.getChave());
        }
        if (tipo.equals("REPRESENTANTE COMERCIAL")) {
          query.append(" AND r.rep_cdgo = ").append(ent.getChave());
        }
        if (tipo.equals("ANALISTA REGIONAL")) {
          query.append(" AND r.rep_cdgo = ").append(ent.getChave());
        }
        if (tipo.equals("CLIENTE MERCADO EXTERNO")) {
          query.append(" AND p.cli_cdgo = ").append(ent.getChave());
        }
        if (tipo.equals("CLIENTE MERCADO INTERNO")) {
          query.append(" AND p.cli_cdgo = ").append(ent.getChave());
        }
      }
      //----------------------------
      SituacoesPedidosActionForm f = (SituacoesPedidosActionForm) form;
      StringBuilder queryc = new StringBuilder();
      queryc.append("SELECT p.ped_nmro, ");
      queryc.append("       p.cli_cdgo, ");
      queryc.append("       p.rep_cdgo, ");
      queryc.append("       r.codigo_regional ");
      queryc.append("  FROM ped p, ");
      queryc.append("       rep r ");
      queryc.append(" WHERE r.rep_cdgo = p.rep_cdgo ");
      queryc.append(query.toString());
      queryc.append("   AND p.ped_nmro = ").append(f.getPed_nmro());

      pstm = j.getConn().prepareStatement(queryc.toString());
      rset = pstm.executeQuery();
      boolean erro = false;
      if ((!(rset.next()))) {
        erro = true;
      }
      if (erro) {
        throw new Exception(java.util.ResourceBundle.getBundle("ComercialResources").getString("SituacoesPedidos.erro.pedido.inexistente"));
      }
      session.setAttribute(mapping.getName(), form);
    }
    catch (Exception e) {
      throw e;
    } finally {
      if (rset != null) {
        rset.close();
      }
      if (pstm != null) {
        pstm.close();
      }
      if (j != null) {
        j.close();
        j = null;
      }
    }
  }

  private void tg_select_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      java.util.Vector res_Jw_situacoes_pedidos = (java.util.Vector) session.getAttribute("res_Jw_situacoes_pedidos");
      if (res_Jw_situacoes_pedidos != null && res_Jw_situacoes_pedidos.size() == 0) {
        throw new Exception(java.util.ResourceBundle.getBundle("ComercialResources").getString("SituacoesPedidos.erro.nenhum.registro"));
      }
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SituacoesPedidosActionForm f = (SituacoesPedidosActionForm) form;
      session.removeAttribute("res_Jw_situacoes_pedidos");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_situacoes_pedidos", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
