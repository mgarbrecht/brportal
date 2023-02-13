package portalbr.acesso;

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
 * Creation Date 28/08/2006 15:48:36
 * Last Modify Date 09/06/2021 11:40:21
 */

public class TrocaSenhaPadraoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      TrocaSenhaPadraoActionForm f = (TrocaSenhaPadraoActionForm) form;
      session.removeAttribute("res_Usuarios");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      tg_select_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    TrocaSenhaPadraoActionForm f = (TrocaSenhaPadraoActionForm) form;
    portalbr.dbobj.table.Usuarios table = new portalbr.dbobj.table.Usuarios();
    String[][] select = null;
    Object[][] where = {{"Usua_usuario","like", f.getUsua_usuario().toUpperCase()}};
    Vector res_Usuarios = j.select(table, select, where, null, null, null);
    if (res_Usuarios != null && res_Usuarios.size() > 0) {
      portalbr.dbobj.table.Usuarios r = (portalbr.dbobj.table.Usuarios) res_Usuarios.elementAt(0);
      if (r.getUsua_super().equals("S")) {
        throw new Exception("Impossível trocar senha de super usuário");
      }
      f.setUsua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
    } else {
      throw new Exception("Usuário inexistente!");
    }

    acesso.Sessao se = new acesso.Sessao(session);
    String codigo_regional = "";
    String tipo = se.getTipoEntidadeNegocio();
    if (tipo.equals("REGIONAL DE VENDA")) {
      StringBuilder sb = new StringBuilder();
      codigo_regional = se.getChave();
      sb.append(" SELECT DISTINCT 'S' ");
      sb.append("   FROM cliente_representante cr ");
      sb.append("      , rep r ");
      sb.append("  WHERE r.rep_cdgo = cr.codigo_representante ");
      sb.append("    AND cr.codigo_cliente = " + f.getUsua_usuario());
      sb.append("    AND cr.situacao = 'A' ");
      sb.append("    AND r.rep_situ = 'A' ");
      sb.append("    AND r.codigo_regional = " + codigo_regional);
      util.consultas.Query query = new util.consultas.Query();
      String retorno = query.retorna(sb.toString());
      if (!retorno.equalsIgnoreCase("S")) {
        throw new Exception("Cliente não pertence à regional!");
      }
    }
    //--------------------------------------------------------------------------------------------
    acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
    usuario.select(Integer.parseInt(f.getUsua_id()));
    usuario.setSenha("beirario".getBytes());
    usuario.setAcessos(0);
    acesso.Sessao sessao = new acesso.Sessao(session);
    usuario.setUsuarioAlteracao(sessao.getUsuario());
    usuario.update();
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
    //--------------------------------------------------------------------------------------------
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("msg.trocasenhapadrao",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      TrocaSenhaPadraoActionForm f = (TrocaSenhaPadraoActionForm) form;
      if (!f.getUsua_usuario().equals("")) {
        portalbr.dbobj.table.Usuarios table = new portalbr.dbobj.table.Usuarios();
        String[][] select = null;
        Object[][] where = {{"Usua_usuario","like", f.getUsua_usuario().toUpperCase()}};
        Vector res_Usuarios = j.select(table, select, where, null, null, null);
        if (res_Usuarios != null && res_Usuarios.size() > 0) {
          portalbr.dbobj.table.Usuarios r = (portalbr.dbobj.table.Usuarios) res_Usuarios.elementAt(0);
          if (r.getUsua_super().equals("S")) {
            throw new Exception("Impossível trocar email de super usuário");
          }
          f.setUsua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
        } else {
          throw new Exception("Usuário inexistente!");
        }
      }

      acesso.Sessao se = new acesso.Sessao(session);
      String codigo_regional = "";
      String tipo = se.getTipoEntidadeNegocio();
      if (tipo.equals("REGIONAL DE VENDA")) {
        StringBuilder sb = new StringBuilder();
        codigo_regional = se.getChave();
        sb.append(" SELECT DISTINCT 'S' ");
        sb.append("   FROM cliente_representante cr ");
        sb.append("      , rep r ");
        sb.append("  WHERE r.rep_cdgo = cr.codigo_representante ");
        sb.append("    AND cr.codigo_cliente = " + f.getUsua_usuario());
        sb.append("    AND cr.situacao = 'A' ");
        sb.append("    AND r.rep_situ = 'A' ");
        sb.append("    AND r.codigo_regional = " + codigo_regional);
        util.consultas.Query query = new util.consultas.Query();
        String retorno = query.retorna(sb.toString());
        if (!retorno.equalsIgnoreCase("S")) {
          throw new Exception("Cliente não pertence à regional!");
        }
      }

      //--------------------------------------------------------------------------------------------
      acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
      usuario.select(Integer.parseInt(f.getUsua_id()));
      usuario.setEmail(f.getUsua_email().toLowerCase());
      acesso.Sessao sessao = new acesso.Sessao(session);
      usuario.setUsuarioAlteracao(sessao.getUsuario());
      usuario.update();
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      //--------------------------------------------------------------------------------------------
      tg_update_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_desbloquear_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      TrocaSenhaPadraoActionForm f = (TrocaSenhaPadraoActionForm) form;
      acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
      usuario.select(Integer.parseInt(f.getUsua_id()));
      usuario.setSituacao("A");
      acesso.Sessao sessao = new acesso.Sessao(session);
      usuario.setUsuarioAlteracao(sessao.getUsuario());
      usuario.update();
      try {
        tg_desbloquear_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_desbloquear_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_bloquear_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      TrocaSenhaPadraoActionForm f = (TrocaSenhaPadraoActionForm) form;
      acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
      usuario.select(Integer.parseInt(f.getUsua_id()));
      usuario.setSituacao("I");
      acesso.Sessao sessao = new acesso.Sessao(session);
      usuario.setUsuarioAlteracao(sessao.getUsuario());
      usuario.update();
      try {
        tg_bloquear_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_bloquear_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
