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
 * Last Modify Date 14/12/2017 11:33:13
 */

public class TrocaIdentidadeAction extends com.egen.util.struts.AbstractAction {

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
    TrocaIdentidadeActionForm f = (TrocaIdentidadeActionForm) form;
    portalbr.dbobj.table.Usuarios table = new portalbr.dbobj.table.Usuarios();
    acesso.Sessao sessao = new acesso.Sessao(session);
    String[][] select = null;
    Object[][] where = {{"Usua_usuario","like", f.getUsua_usuario().toUpperCase()}};
    Vector res_Usuarios = j.select(table, select, where, null, null, null);
    if (res_Usuarios != null && res_Usuarios.size() > 0) {
      portalbr.dbobj.table.Usuarios r = (portalbr.dbobj.table.Usuarios) res_Usuarios.elementAt(0);
      if (r.getUsua_super().equals("S")) {
        throw new Exception("Impossível trocar para super usuário");
      }
      f.setUsua_id((r.getUsua_id() != null) ? r.getUsua_id() + "":"");
      acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
      usuario.select(Integer.parseInt(f.getUsua_id()));
      if (!sessao.isSuperUsuario()) {
        //--- Verifica sem tem permissão --------------------------------------
        Acessos_troca_identidade tableTroca = new Acessos_troca_identidade();
        String[][] selectTroca = null;
        Object[][] whereTroca = { {"atid_usua_id","=", sessao.getId()}, {"atid_tien_id","=", usuario.getEntidadeNegocio().getTipoEntidadeNegocio().getId()} };
        Vector res_Acessos_troca_identidade = j.select(tableTroca , selectTroca, whereTroca, null, null, null);
        if (res_Acessos_troca_identidade != null && res_Acessos_troca_identidade.size() > 0) {
        } else {
          throw new Exception("O seu usuário não tem permissão para trocar para o tipo de usuário: " + usuario.getEntidadeNegocio().getTipoEntidadeNegocio().getTipo());
        }
        //---------------------------------------------------------------------
      }
      session.setAttribute("User", (acesso.Usuario) usuario);
      session.setAttribute("mapping.getName()", form);
    } else {
      throw new Exception("Usuário inexistente!");
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
      TrocaIdentidadeActionForm f = (TrocaIdentidadeActionForm) form;
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

}
