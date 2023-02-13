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
 * Last Modify Date 21/06/2022 15:18:13
 */

public class Usuarios_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("Usuarios_iActionForm", form);
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


  public ActionForward perform_incluir_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 17/01/2006
    // Objetivo          : Insere um novo registro na tabela usuarios.
    //-------------------------------------------------------------------------------------------
    // Data de Alteração : 12/07/2007
    // Descrição         : Incluí o código para permitir a cópia de permissões de
    //                     um usuário para outro
    //-------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      String enneId = null;
      acesso.Sessao sessao = new acesso.Sessao(session);
      util.consultas.Sequence sequence = new util.consultas.Sequence();
      j = new com.egen.util.jdbc.JdbcUtil();
      Usuarios_iActionForm f = (Usuarios_iActionForm) form;
      //------------------------------------------------------------------------------------------------
      acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
      if (f.getUsua_enne_id() != "") {
        acesso.EntidadeNegocioAPI enne = new acesso.EntidadeNegocioAPI(j.getConn());
        enne.select(Integer.parseInt(f.getUsua_enne_id()));
        usuario.setEntidadeNegocio((acesso.EntidadeNegocio) enne);
      } else {
        if (f.getChave() != "" || f.getTipo_entidade() != "") {
          if (f.getChave().equals("") || f.getTipo_entidade().equals("")) {
            throw new Exception("O tipo de entidade e a chave devem ser informados!");
          } else {
            util.consultas.Query query = new util.consultas.Query();
            enneId = query.retorna(j, "SELECT enne_id FROM wbrio.entidades_negocio WHERE enne_chave = '"+f.getChave() + "' AND enne_tien_id = " + f.getTipo_entidade());
            if (enneId.equals("")) {
              acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn());
              acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(j.getConn(), Integer.parseInt(f.getTipo_entidade()));
              entidade.setChave(f.getChave().trim());
              entidade.setTipoEntidadeNegocio(tipoentidade);
              entidade.insert();
              enneId = query.retorna(j, "SELECT enne_id FROM wbrio.entidades_negocio WHERE enne_chave = '"+f.getChave() + "' AND enne_tien_id = " + f.getTipo_entidade());
            }
            acesso.EntidadeNegocioAPI enne = new acesso.EntidadeNegocioAPI(j.getConn());
            enne.select(Integer.parseInt(enneId));
            usuario.setEntidadeNegocio((acesso.EntidadeNegocio) enne);
          }
        }
      }

      usuario.setNome(f.getUsua_nome().toUpperCase());
      usuario.setEmail(f.getUsua_email().toLowerCase());
      usuario.setUsuario(f.getUsua_usuario().toUpperCase());
      usuario.setSenha(f.getUsua_senha().getBytes());
      usuario.setExpiraSenha(f.getUsua_expira_senha());
      usuario.setUsuarioInclusao(sessao.getUsuario());
      if (f.getUsua_super().equals("S")) {
        usuario.setSuperUsuario(true);
      } else {
        usuario.setSuperUsuario(false);
      }
      if ((!(f.getDias_consulta_retroativa().equals("")))) {
        usuario.setDiasConsultaRetroativa(Integer.parseInt(f.getDias_consulta_retroativa()));
      } else {
        usuario.setDiasConsultaRetroativa(null);
      }
      usuario.setAcessos(1);
      if (f.getUsua_pai().equals("")) {
        usuario.insert();
      }
      // ---------------- SE COPIAR ACESSOS DE OUTRO USUÁRIO -----------------------
      if ((!(f.getUsua_pai().equals("")))) {
        //-------------------------- SELECIONA ENTIDADE E DIAS DO PAI ----------------------------
        portalbr.dbobj.table.Usuarios table = new portalbr.dbobj.table.Usuarios();
        String[][] select = null;
        Object[][] where = { {"Usua_usuario","like", f.getUsua_pai().toUpperCase()} };
        Vector res_Usuarios = j.select(table, select, where, null, null, null);
        if (res_Usuarios != null && res_Usuarios.size() > 0) {
          usuario.insert();
          portalbr.dbobj.table.Usuarios r = (portalbr.dbobj.table.Usuarios) res_Usuarios.elementAt(0);
          int enne_pai = 0;
          int dias_pai = 0;
          int usua_id_pai = 0;
          int novo_usuario_id = 0;
          enne_pai = r.getUsua_enne_id();
          dias_pai = r.getDias_consulta_retroativa() != null ? r.getDias_consulta_retroativa() : 0;
          usua_id_pai = r.getUsua_id();
          //----------------------- BUSCA ID DO NOVO USUARIO ----------------------------------------
          java.sql.PreparedStatement pstm;
          java.sql.ResultSet rset;
          pstm = j.getConn().prepareStatement("SELECT usua_id from wbrio.usuarios where usua_usuario = upper('"+f.getUsua_usuario() + "') ");
          rset = pstm.executeQuery();
          if (rset.next()) {
            novo_usuario_id = rset.getInt(1);
          }
          rset.close();
          pstm.close();
          //---------------- ATUALIZA NOVO USUARIO COM ENTIDADE E DIAS DO PAI -----------------------
          pstm = j.getConn().prepareStatement("UPDATE usuarios set usua_enne_id = ?, dias_consulta_retroativa = ? where usua_id = ? ");
          pstm.setInt(1, enne_pai);
          pstm.setInt(2, dias_pai);
          pstm.setInt(3, novo_usuario_id);
          pstm.execute();
          pstm.close();

          //-------------------- SELECIONA ACESSOS DO USUARIO PAI -----------------------------------
          pstm = j.getConn().prepareStatement(new StringBuilder(" SELECT acus_id ").append("      , acus_usua_id ").append("      , nvl(acus_doin_id,0) acus_doin_id ").append("      , acus_negar_acesso ").append("      , acus_dias_consulta_retroativa ").append("      , nvl(acus_codigo_classe,0) acus_codigo_classe ").append("   FROM wbrio.acessos_usuarios ").append("  WHERE acus_usua_id = ? ").toString());
          pstm.setInt(1, usua_id_pai);
          rset = pstm.executeQuery();





          while (rset.next()) {
            pstm = j.getConn().prepareStatement(" insert into wbrio.acessos_usuarios values (?, ?, ?, ?, ?, ?)");
            pstm.setInt(1, sequence.nextValue("acessos_usuarios", "acus_id"));
            pstm.setInt(2, novo_usuario_id);
            pstm.setString(3, (rset.getInt(3) == 0 ? null : rset.getString(3)));
            pstm.setString(4, rset.getString(4));
            pstm.setInt(5, rset.getInt(5));
            pstm.setString(6, (rset.getInt(6) == 0 ? null : rset.getString(6)));
            pstm.execute();
            pstm.close();
          }
          rset.close();
          pstm.close();

        } else {
          throw new Exception("Usuário pai inválido/inexistente!");
        }
      }
      // ----------------------------------------------------------------------------
      if (f.getGerar_autorizacao().equals("S")) {
        acesso.AcessoDocumentoInterfaceAPI adi = new acesso.AcessoDocumentoInterfaceAPI(j.getConn());
        adi.geraAutorizacoesUsuario(usuario.getId());
      }
      //------------------------------------------------------------------------------------------------
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
        j = null;
      }
    }

    form.reset(mapping, request);
    return actionForward;
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Usuarios_iActionForm f = (Usuarios_iActionForm) form;
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

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Usuarios_iActionForm f = (Usuarios_iActionForm) form;
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
