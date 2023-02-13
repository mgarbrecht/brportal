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
 * Last Modify Date 05/07/2019 18:42:04
 */

public class DirectAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      tg_select_action(mapping, form, request, response);
      actionForward = new ActionForward("/",true);
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
    DirectActionForm f = (DirectActionForm) form;
    session.removeAttribute("usuarioInexistente");
    boolean achouUsuario = false;
    util.consultas.Query query = new util.consultas.Query();
    portalbr.dbobj.table.Usuarios table = new portalbr.dbobj.table.Usuarios();
    String senhaAtual = query.retorna(j, "SELECT senha FROM loja.usuarios_rpi WHERE cod_usuario = '"+f.getUsua_usuario().toUpperCase() + "'");
    if (f.getUsua_senha().equalsIgnoreCase(senhaAtual)) {
      if ((f.getUsua_tipo() + "").equalsIgnoreCase("c")) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT usua_usuario ");
        sb.append("   FROM wbrio.usuarios          us ");
        sb.append("      , wbrio.entidades_negocio en ");
        sb.append("      , esc                     e ");
        sb.append("  WHERE us.usua_enne_id = en.enne_id ");
        sb.append("    AND us.situacao = 'A' ");
        sb.append("    AND en.enne_tien_id = 2194 ");
        sb.append("    AND en.enne_chave = e.cli_cdgo ");
        sb.append("    AND e.esc_cgc = ").append(f.getUsua_usuario());
        sb.append("    AND e.esc_situacao = 'A' ");
        sb.append("  UNION ");
        sb.append(" SELECT usua_usuario ");
        sb.append("   FROM wbrio.usuarios          us ");
        sb.append("      , wbrio.entidades_negocio en ");
        sb.append("  WHERE us.usua_enne_id = en.enne_id ");
        sb.append("    AND us.situacao = 'A' ");
        sb.append("    AND en.enne_tien_id = 2194 ");
        sb.append("    AND en.enne_chave = '"+f.getUsua_usuario() + "' ");
        f.setUsua_usuario(query.retorna(j, sb.toString()));
      }
      String[][] select = null;
      Object[][] where = {{"Usua_usuario","like", (f.getUsua_usuario().toUpperCase())}};
      Vector res_Usuarios = j.select(table, select, where, null, null, null);
      if (!f.getUsua_usuario().equals("")) {
        achouUsuario = true;
      }
      if (res_Usuarios != null && res_Usuarios.size() > 0 && achouUsuario) {
        portalbr.dbobj.table.Usuarios r = (portalbr.dbobj.table.Usuarios) res_Usuarios.elementAt(0);
        f.setUsua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
        acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
        usuario.atualizaUltimoAcesso(f.getUsua_usuario().toUpperCase());
        usuario.select(Integer.parseInt(f.getUsua_id()));
        session.setAttribute("User", (acesso.Usuario) usuario);
        session.setAttribute("mapping.getName()", form);
      } else {
        session.setAttribute("usuarioInexistente","S");
        throw new Exception("Usuário inexistente!");
      }
    }
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DirectActionForm f = (DirectActionForm) form;
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

  public ActionForward perform_select1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DirectActionForm f = (DirectActionForm) form;
      util.consultas.Query query = new util.consultas.Query();
      portalbr.dbobj.table.Usuarios table = new portalbr.dbobj.table.Usuarios();
      String[][] select = null;
      Object[][] where = {{"Usua_super","like", "S"}};
      Vector res_Usuarios = j.select(table, select, where, null, null, null);
      if (res_Usuarios != null && res_Usuarios.size() > 0) {
        portalbr.dbobj.table.Usuarios r = (portalbr.dbobj.table.Usuarios) res_Usuarios.elementAt(0);
        acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
        usuario.select(r.getUsua_id());
        session.setAttribute("User", (acesso.Usuario) usuario);
        session.setAttribute("mapping.getName()", form);
      } else {
        throw new Exception("Usuário inexistente!");
      }
      actionForward = new ActionForward("/",true);
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



}
