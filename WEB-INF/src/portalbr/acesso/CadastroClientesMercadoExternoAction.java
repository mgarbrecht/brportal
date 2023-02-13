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
 * Creation Date 27/02/2014 09:44:56
 * Last Modify Date 28/11/2018 15:46:40
 */

public class CadastroClientesMercadoExternoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    java.sql.ResultSet rset1 = null;
    java.sql.PreparedStatement pstm1 = null;
    java.sql.ResultSet rset2 = null;
    java.sql.PreparedStatement pstm2 = null;
    int id_usuario = 0;
    try {
      acesso.Sessao sessao = new acesso.Sessao(session);
      util.consultas.Query query = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      CadastroClientesMercadoExternoActionForm f = (CadastroClientesMercadoExternoActionForm) form;
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT DISTINCT 'S' ");
      sb.append("   FROM cli c ");
      sb.append("  WHERE to_char(c.cli_cdgo) = '"+f.getCli_cdgo() + "' ");
      sb.append("    AND nvl(c.cli_situ,NULL) = 'A' ");
      sb.append("    AND c.cli_cdgo <> 40000 ");
      sb.append("    AND c.cli_tipo_mercado = 'EX' ");
      sb.append("    AND NOT EXISTS (SELECT 1 ");
      sb.append("           FROM wbrio.tipos_entidade_negocio t ");
      sb.append("               ,wbrio.entidades_negocio e ");
      sb.append("               ,wbrio.usuarios u ");
      sb.append("          WHERE t.tien_id = e.enne_tien_id ");
      sb.append("            AND e.enne_id = u.usua_enne_id ");
      sb.append("            AND t.tien_id = 2193 ");
      sb.append("            AND TO_CHAR(c.cli_cdgo) = u.usua_usuario) ");
      sb.append("    AND NOT EXISTS (SELECT 1 ");
      sb.append("                      FROM wbrio.analistas_regionais an ");
      sb.append("                     WHERE an.codigo_gerente = TO_CHAR(c.cli_cdgo)) ");

      String naoExiste = query.retorna(j, sb.toString());
      if (naoExiste.equalsIgnoreCase("S")) {
        StringBuilder sbe = new StringBuilder();
        sbe.append(" select e.enne_id ");
        sbe.append("   from wbrio.entidades_negocio e ");
        sbe.append("  where e.enne_tien_id = 2193 ");
        sbe.append("    and e.enne_chave = " + f.getCli_cdgo());
        String enneId = query.retorna(j, sbe.toString());
        if (enneId == null || enneId.equals("")) {
          acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn());
          acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(j.getConn(), Integer.parseInt("2193"));
          entidade.setChave(f.getCli_cdgo());
          entidade.setDescricao("");
          entidade.setTipoEntidadeNegocio(tipoentidade);
          entidade.insert();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" select e.enne_id ");
        sb2.append("      , c.cli_rzao cli_nome ");
        sb2.append("  from wbrio.entidades_negocio e ");
        sb2.append("     , cli c ");
        sb2.append(" where c.cli_cdgo = " + f.getCli_cdgo());
        sb2.append("   and e.enne_tien_id = 2193 ");
        sb2.append("   and to_char(c.cli_cdgo) = e.enne_chave ");
        pstm1 = j.getConn().prepareStatement(sb2.toString());
        rset1 = pstm1.executeQuery();
        if (rset1.next()) {
          String senha = f.getSenha();
          acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
          acesso.EntidadeNegocioAPI enne = new acesso.EntidadeNegocioAPI(j.getConn());
          enne.select(Integer.parseInt(rset1.getString(1)));
          usuario.setEntidadeNegocio((acesso.EntidadeNegocio) enne);
          usuario.setNome(rset1.getString(2).toUpperCase());
          usuario.setUsuario(f.getCli_cdgo());
          usuario.setSenha(f.getSenha().getBytes());
          usuario.setExpiraSenha("S");
          usuario.setSuperUsuario(false);
          usuario.setDiasConsultaRetroativa(0);
          usuario.setAcessos(1);
          usuario.setUsuarioInclusao(sessao.getUsuario());
          usuario.insert();
          pstm2 = j.getConn().prepareStatement(" select usua_id from wbrio.usuarios where usua_usuario = upper('"+f.getCli_cdgo() + "') ");
          rset2 = pstm2.executeQuery();
          if (rset2.next()) {
            id_usuario = rset2.getInt(1);
          }
          acesso.AcessoDocumentoInterfaceAPI adi = new acesso.AcessoDocumentoInterfaceAPI(j.getConn());
          adi.geraAutorizacoesUsuario(id_usuario);
          form.reset(mapping, request);
          //--------------------------
          String existeUsuarioRpi = query.retorna(j, "SELECT 'S' FROM loja.usuarios_rpi r WHERE r.cod_usuario = '"+usuario.getUsuario() + "' AND r.tipo_usuario = 10 AND ROWNUM = 1");
          if (!existeUsuarioRpi.equalsIgnoreCase("S")) {
            query.execute("INSERT INTO usuarios_rpi (cod_usuario ,nome ,tipo_usuario ,situacao ,senha ,email_novo ,dt_ultimo_acesso ,usuario_inclusao ,data_inclusao ,data_alteracao ,usuario_alteracao ,codigo_regional ,tipo_mercado ,liberar_catalogo) VALUES ('"+usuario.getUsuario() + "','"+usuario.getNome() + "', 10, 'A', md5('"+senha + "'), NULL, NULL,'WBRIO', sysdate, NULL, NULL, null, 'ME', 'N') ");
          }
          //--------------------------
          //--------Inserção na tabela de loja.usuarios_rpi o vendedor deste usuario com o mesmo cod_usuario porem com adição de um _V ao fim.

          String existeUsuarioRpi_V = query.retorna(j, "SELECT 'S' FROM loja.usuarios_rpi r WHERE r.cod_usuario = '"+usuario.getUsuario() + "_V' AND r.tipo_usuario = 10 AND ROWNUM = 1");
          if (!existeUsuarioRpi_V.equalsIgnoreCase("S")) {
            query.execute("INSERT INTO usuarios_rpi (cod_usuario ,nome ,tipo_usuario ,situacao ,senha ,email_novo ,dt_ultimo_acesso ,usuario_inclusao ,data_inclusao ,data_alteracao ,usuario_alteracao ,codigo_regional ,tipo_mercado ,liberar_catalogo, cli_cdgo_pai) VALUES ('"+usuario.getUsuario() + "_V','"+usuario.getNome() + "', 10, 'A', md5('"+senha + "'), NULL, NULL,'WBRIO', sysdate, NULL, NULL, null, 'ME', 'N', '"+usuario.getUsuario() + "') ");
          }

          //-------------------------
          session.setAttribute(mapping.getName(), form);
          tg_insert_action(mapping, form, request, response);
        }
      } else {
        form.reset(mapping, request);
        session.setAttribute(mapping.getName(), form);
        throw new Exception("Cliente inválido ou já cadastrado!");
      }
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      try {
        if (rset1 != null) {
          rset1.close();
        }
        if (pstm1 != null) {
          pstm1.close();
        }
        if (rset2 != null) {
          rset2.close();
        }
        if (pstm2 != null) {
          pstm2.close();
        }
      } catch (Exception sqe) {
      }
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CadastroClientesMercadoExternoActionForm f = (CadastroClientesMercadoExternoActionForm) form;
      session.removeAttribute("res_Cli");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      CadastroClientesMercadoExternoActionForm f = (CadastroClientesMercadoExternoActionForm) form;
      try {
        update_action(j, mapping, form, request, response);
        tg_update_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    CadastroClientesMercadoExternoActionForm f = (CadastroClientesMercadoExternoActionForm) form;
    acesso.Sessao sessao = new acesso.Sessao(session);
    util.consultas.Query query = new util.consultas.Query();
    StringBuilder sbu = new StringBuilder();
    sbu.append(" UPDATE usuarios_rpi ");
    sbu.append("    SET senha = md5('").append(f.getSenha()).append("') ");
    sbu.append("      , data_alteracao = sysdate ");
    sbu.append("      , usuario_alteracao = '").append(sessao.getUsuario()).append("' ");
    sbu.append("  WHERE tipo_usuario = 10 ");
    sbu.append("    AND cod_usuario = '").append(f.getCli_cdgo()).append("' ");

    StringBuilder sbr = new StringBuilder();
    sbr.append(" UPDATE wbrio.usuarios u ");
    sbr.append("    SET usua_dt_senha = sysdate ");
    sbr.append("      , usua_senha = md5('").append(f.getSenha()).append("') ");
    sbr.append("  WHERE u.usua_usuario = '").append(f.getCli_cdgo()).append("' ");
    sbr.append("    AND EXISTS (SELECT 1 ");
    sbr.append("                  FROM wbrio.entidades_negocio e ");
    sbr.append("                 WHERE u.usua_enne_id = e.enne_id ");
    sbr.append("                   AND e.enne_tien_id = 2193 ");
    sbr.append("                   AND u.usua_usuario = '").append(f.getCli_cdgo()).append("') ");

    query.execute(j, sbu.toString());
    query.execute(j, sbr.toString());

    session.setAttribute(mapping.getName(), form);
  }
  private void tg_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Cli", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

}
