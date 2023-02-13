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
 * Creation Date 17/01/2006 13:29:55
 * Last Modify Date 22/09/2015 09:35:11
 */

public class Usuarios_aAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    Usuarios_aActionForm f = (Usuarios_aActionForm) form;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      update_action(j, mapping, form, request, response);
      actionForward = new ActionForward(f.getChamador(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    String tien_id = "";
    HttpSession session = request.getSession(true);
    Usuarios_aActionForm f = (Usuarios_aActionForm) form;
    if (f.getUsua_senha() != "" && f.getConfirma_senha() != "") {
      if ((!(f.getUsua_senha().equals(f.getConfirma_senha())))) {
        throw new Exception("As senhas não conferem!");
      }
    }
    portalbr.dbobj.view.Jw_usuarios table = new portalbr.dbobj.view.Jw_usuarios();
    table.setUsua_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_id()));
    table.setUsua_usuario(f.getUsua_usuario().toUpperCase());
    table.setUsua_nome(f.getUsua_nome().toUpperCase());
    table.setUsua_email(f.getUsua_email().toLowerCase());
    table.setUsua_enne_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_enne_id()));
    table.setUsua_super(f.getUsua_super());
    table.setEnne_descricao(f.getEnne_descricao());
    table.setSituacao(f.getSituacao());
    table.setUsua_expira_senha(f.getUsua_expira_senha());
    //------------------------------------------------------------------------------------------------
    if (f.getUsua_enne_id() != "") {
      portalbr.dbobj.table.Entidades_negocio entidades = new portalbr.dbobj.table.Entidades_negocio();
      String[][] select = null;
      Object[][] where = { {"Enne_id","=", com.egen.util.text.FormatNumber.toInteger(f.getUsua_enne_id())} };
      Vector res_Entidades = j.select(entidades, select, where, null, null, null);
      if (res_Entidades != null && res_Entidades.size() > 0) {
        portalbr.dbobj.table.Entidades_negocio r_entidades = (portalbr.dbobj.table.Entidades_negocio) res_Entidades.elementAt(0);
        tien_id = r_entidades.getEnne_tien_id() + "";
        table.setEnne_descricao(r_entidades.getEnne_descricao());
      }

      portalbr.dbobj.table.Tipos_entidade_negocio tipos_entidades = new portalbr.dbobj.table.Tipos_entidade_negocio();
      String[][] select1 = null;
      Object[][] where1 = { {"Tien_id","=", tien_id} };
      Vector res_Tipos_Entidades = j.select(tipos_entidades, select1, where1, null, null, null);
      if (res_Tipos_Entidades != null && res_Tipos_Entidades.size() > 0) {
        portalbr.dbobj.table.Tipos_entidade_negocio r_tipos_entidades = (portalbr.dbobj.table.Tipos_entidade_negocio) res_Tipos_Entidades.elementAt(0);
        table.setTien_tipo(r_tipos_entidades.getTien_tipo() + "");
      }
    }
    //--------------------------------------------------------------------------------------------
    acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
    usuario.select(Integer.parseInt(f.getUsua_id()));
    if (f.getUsua_enne_id() != "") {
      acesso.EntidadeNegocioAPI enne = new acesso.EntidadeNegocioAPI(j.getConn());
      enne.select(Integer.parseInt(f.getUsua_enne_id()));
      usuario.setEntidadeNegocio((acesso.EntidadeNegocio) enne);
    } else {
      usuario.setEntidadeNegocio(null);
    }
    usuario.setNome(f.getUsua_nome().toUpperCase());
    usuario.setEmail(f.getUsua_email().toLowerCase());
    usuario.setUsuario(f.getUsua_usuario().toUpperCase());
    if (f.getUsua_senha() != "" && f.getConfirma_senha() != "") {
      usuario.setSenha(f.getUsua_senha().getBytes());
    }
    if (f.getForca_senha().equals("true")) {
      usuario.setAcessos(0);
    }
    if (f.getUsua_super().equals("S")) {
      usuario.setSuperUsuario(true);
    } else {
      usuario.setSuperUsuario(false);
    }
    usuario.setSituacao(f.getSituacao());
    usuario.setExpiraSenha(f.getUsua_expira_senha());
    if ((!(f.getDias_consulta_retroativa().equals("")))) {
      usuario.setDiasConsultaRetroativa(Integer.parseInt(f.getDias_consulta_retroativa()));
    } else {
      usuario.setDiasConsultaRetroativa(null);
    }
    acesso.Sessao sessao = new acesso.Sessao(session);
    usuario.setUsuarioAlteracao(sessao.getUsuario());
    usuario.update();
    //--------------------------------------------------------------------------------------------
    Vector res_Jw_usuarios = (Vector) session.getAttribute("res_Jw_usuarios");
    if (res_Jw_usuarios != null) {
      res_Jw_usuarios.setElementAt(table, Integer.parseInt(f.getPos()));
    }
    session.setAttribute(mapping.getName(), form);
  }




  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    Usuarios_aActionForm f = (Usuarios_aActionForm) form;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      delete_action(j, mapping, form, request, response);
      actionForward = new ActionForward(f.getChamador(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void delete_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    Usuarios_aActionForm f = (Usuarios_aActionForm) form;
    portalbr.dbobj.view.Jw_usuarios table = new portalbr.dbobj.view.Jw_usuarios();
    table.setUsua_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_id()));
    table.setUsua_usuario(f.getUsua_usuario());
    table.setUsua_nome(f.getUsua_nome());
    table.setUsua_enne_id(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getUsua_enne_id()));
    table.setUsua_super(f.getUsua_super());
    table.setEnne_descricao(f.getEnne_descricao());
    //-------------------------------------------------------------------------------------------------
    acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
    usuario.select(Integer.parseInt(f.getUsua_id()));
    usuario.delete();
    //-------------------------------------------------------------------------------------------------
    Vector res_Jw_usuarios = (Vector) session.getAttribute("res_Jw_usuarios");
    if (res_Jw_usuarios != null && res_Jw_usuarios.size() > 0) {
      res_Jw_usuarios.removeElementAt(Integer.parseInt(f.getPos()));
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Usuarios_aActionForm f = (Usuarios_aActionForm) form;
      actionForward = new ActionForward(f.getChamador(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
