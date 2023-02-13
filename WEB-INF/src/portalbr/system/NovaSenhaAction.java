package portalbr.system;

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
 * Creation Date 27/01/2011 11:30:20
 * Last Modify Date 04/03/2015 08:24:40
 */

public class NovaSenhaAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      NovaSenhaActionForm f = (NovaSenhaActionForm) form;
      String usua_id = "";
      String quantidadeUsuarios = "";
      quantidadeUsuarios = query.retorna(j, "SELECT count(*) FROM usuarios WHERE usua_email = '"+f.getEmail() + "'");
      if (quantidadeUsuarios.equals("0")) {
        throw new Exception("Email não habilitado para o BR Portal, contate a Informática.");
      }
      if (quantidadeUsuarios.equals("1")) {
        usua_id = query.retorna(j, "SELECT DISTINCT usua_id FROM usuarios WHERE usua_email = '"+f.getEmail() + "'");
        String usuario_alteracao = query.retorna(j, "SELECT usua_usuario FROM usuarios where usua_email = '"+f.getEmail() + "'");
        if ((!(usua_id.equals("")))) {
          String novaSenha = util.rand.Palavra.geraNovaSenha();
          Prc_envia_email_troca_senha r = new Prc_envia_email_troca_senha();
          r.setP_usua_id(usua_id);
          r.setP_senha(novaSenha);
          r = (Prc_envia_email_troca_senha) j.execute(r);
          //---------------------------------------------------------------------------------------------------------------
          query.execute(j, "DELETE wbrio.ultimas_senhas_usuarios WHERE usua_id = " + usua_id);
          //---------------------------------------------------------------------------------------------------------------
          acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
          usuario.select(Integer.parseInt(usua_id));
          usuario.setSenha(novaSenha.getBytes());
          usuario.setUsuarioAlteracao(usuario_alteracao);
          usuario.setAcessos(0);
          acesso.Sessao sessao = new acesso.Sessao(session);
          usuario.update();
          //---------------------------------------------------------------------------------------------------------------
        } else {
          throw new Exception("Email não habilitado para o BR Portal, contate a Informática.");
        }
        tg_insert_action(mapping, form, request, response);
      } else {
        f.setMostrausuario("S");
        session.setAttribute("mensagem_nova_senha","Selecione o usuário");
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("login.email",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_confirmar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      NovaSenhaActionForm f = (NovaSenhaActionForm) form;
      String usua_id = f.getUsuario();
      if ((!(usua_id.equals("")))) {
        String novaSenha = util.rand.Palavra.geraNovaSenha();
        Prc_envia_email_troca_senha r = new Prc_envia_email_troca_senha();
        r.setP_usua_id(usua_id);
        r.setP_senha(novaSenha);
        r = (Prc_envia_email_troca_senha) j.execute(r);
        //---------------------------------------------------------------------------------------------------------------
        query.execute(j, "DELETE wbrio.ultimas_senhas_usuarios WHERE usua_id = " + usua_id);
        String usuario_alteracao = query.retorna(j, "SELECT usua_usuario FROM usuarios where usua_id = " + usua_id);
        //---------------------------------------------------------------------------------------------------------------
        acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
        usuario.select(Integer.parseInt(usua_id));
        usuario.setSenha(novaSenha.getBytes());
        usuario.setUsuarioAlteracao(usuario_alteracao);
        usuario.setAcessos(0);
        usuario.update();
        //---------------------------------------------------------------------------------------------------------------
      } else {
        throw new Exception("Email não habilitado para o BR Portal, contate a Informática.");
      }
      tg_insert_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      NovaSenhaActionForm f = (NovaSenhaActionForm) form;
      session.setAttribute("mensagem_nova_senha","Informe o seu email");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
