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
 * Creation Date 11/05/2006 10:18:42
 * Last Modify Date 21/10/2016 12:30:48
 */

public class TrocaSenhaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-----------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 11/05/2006
    // Objetivo          : Altera a senha de um usuário
    //-----------------------------------------------------------------------------------------------
    // Data de Alteração : 19/06/2006
    // Descrição         : Após a alteração de senha, vai ser feito um novo select no usuário,
    //                     para colocar na sessão o novo objeto usuário com o incremento de acessos.
    //-----------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      TrocaSenhaActionForm f = (TrocaSenhaActionForm) form;
      j = new com.egen.util.jdbc.JdbcUtil();
      update_action(j, mapping, form, request, response);
      if (f.getFl().equals("1")) {
        tg_update_action(mapping, form, request, response);
      }
      actionForward = mapping.findForward("same");
      if ((!(f.getFl().equals("1")))) {
        actionForward = new ActionForward("/system/MainMenu.jsp", true);
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
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
    HttpSession session = request.getSession(true);
    util.consultas.Parametros parametros = new util.consultas.Parametros();
    TrocaSenhaActionForm f = (TrocaSenhaActionForm) form;
    if (f.getUsua_senha().toLowerCase().indexOf("vizzano") != -1 || f.getUsua_senha().toLowerCase().indexOf("beirario") != -1 || f.getUsua_senha().toLowerCase().indexOf("moleca") != -1 || f.getUsua_senha().toLowerCase().indexOf("molekinha") != -1 || f.getUsua_senha().toLowerCase().indexOf("modare") != -1) {
      throw new Exception("Palavras reservadas como: Vizzano, Beirario, Moleca, Molekinha e Modare não podem ser utilizadas!");
    }
    if (f.getForcasenha().equalsIgnoreCase("fraca") || f.getForcasenha().equalsIgnoreCase("muito fraca")) {
      throw new Exception("Senha " + f.getForcasenha().toLowerCase() + ". Tente deixar a sua senha maior. Adicione letras maiúsculas, minúsculas e caracteres especiais.");
    }
    if ((!(f.getUsua_senha().equals(f.getUsua_senha_confirma())))) {
      throw new Exception(java.util.ResourceBundle.getBundle("AcessoResources").getString("TrocaSenha.erro.senhas.diferentes"));
    }
    if (f.getUsua_senha().equalsIgnoreCase("beirario")) {
      throw new Exception(java.util.ResourceBundle.getBundle("AcessoResources").getString("TrocaSenha.erro.senha.beirario"));
    }
    //--------------------------------------------------------------------------------------------
    acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn(), Integer.parseInt(f.getUsua_id()));
    String pswd = f.getUsua_senha();
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    boolean existe = false;
    try {
      java.security.MessageDigest mdig = java.security.MessageDigest.getInstance("MD5");
      mdig.update(pswd.getBytes());
      pstm = j.getConn().prepareStatement("select ? from sys.dual");
      pstm.setBytes(1, mdig.digest());
      rset = pstm.executeQuery();
      if (rset.next()) {
        pswd = rset.getString(1);
      }
      if (rset != null) {
        rset.close();
      }
      if (pstm != null) {
        pstm.close();
      }
      pstm = j.getConn().prepareStatement("select usua_senha from wbrio.ultimas_senhas_usuarios where usua_id = ?");
      pstm.setInt(1, Integer.parseInt(f.getUsua_id()));
      rset = pstm.executeQuery();
      while (rset.next()) {
        if (java.security.MessageDigest.isEqual(rset.getBytes(1), pswd.getBytes())) {
          existe = true;
        }
      }
      if (rset != null) {
        rset.close();
      }
      if (pstm != null) {
        pstm.close();
      }
      if (existe) {
        throw new Exception("A nova senha deve ser diferente das últimas " + parametros.retornaParametro("quantidade_senhas_armazenadas") + " senhas.");
      }
    }
    finally {
      if (rset != null) {
        rset.close();
      }
      if (pstm != null) {
        pstm.close();
      }
    }
    //---------------------------------------------------------------------------------------------
    usuario.setSenha(f.getUsua_senha().getBytes());
    usuario.incrementAcessos();
    acesso.Sessao sessao = new acesso.Sessao(session);
    usuario.setUsuarioAlteracao(sessao.getUsuario());
    usuario.update();
    usuario.select(Integer.parseInt(f.getUsua_id()));
    session.setAttribute("User", usuario);
    session.setAttribute("senha_venceu", "N");
    //--------------------------------------------------------------------------------------------
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      TrocaSenhaActionForm f = (TrocaSenhaActionForm) form;
      session.removeAttribute("res_Jw_usuarios");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      session.setAttribute("TrocaSenhaActionForm", form);
      actionForward = mapping.findForward("same");
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
