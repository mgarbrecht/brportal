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
 * Creation Date 09/08/2017 15:01:27
 * Last Modify Date 31/08/2017 14:47:08
 */

public class SolicitacaoUsuarioAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_criar_acesso_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    java.sql.PreparedStatement pstm = null;
    java.sql.ResultSet rset = null;
    try {
      session.removeAttribute("mensagem_erro");
      session.removeAttribute("mensagem_sucesso");
      SolicitacaoUsuarioActionForm f = (SolicitacaoUsuarioActionForm) form;
      if (f.getEmail().equals("") || f.getCnpj().equals("")) {
        session.setAttribute("mensagem_erro", "OS campos CNPJ e e-mail devem ser informados!");
        throw new Exception("");
      }


      String razaoSocial = null;
      String cliente = null;
      String contato = null;
      String telefone = null;
      String emailAtual = null;
      Integer codigoCliente = null;
      boolean cnpjInvalido = true;
      boolean usuarioPossuiCadastro = false;
      util.consultas.Query query = new util.consultas.Query();
      util.validate.Validacao validacao = new util.validate.Validacao();
      f.setCnpj(f.getCnpj().replaceAll("[^0-9]", ""));
      if (!validacao.validaCnpj(f.getCnpj())) {
        session.setAttribute("mensagem_erro", "CNPJ inválido!");
        throw new Exception("");
      }
      if (!validacao.validaEmail(f.getEmail())) {
        session.setAttribute("mensagem_erro", "Email inválido!");
        throw new Exception("");
      }
      j = new com.egen.util.jdbc.JdbcUtil();
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT /*+ all_rows */ ");
      sb.append(" DISTINCT c.cli_cdgo ");
      sb.append("        , c.cli_rzao ");
      sb.append("        , c.cli_nome ");
      sb.append("        , e.esc_cgc ");
      sb.append("        , e.esc_email ");
      sb.append("        , NVL((SELECT 'S' ");
      sb.append("                 FROM wbrio.tipos_entidade_negocio ti ");
      sb.append("                    , wbrio.entidades_negocio      ei ");
      sb.append("                    , wbrio.usuarios               ui ");
      sb.append("                WHERE ti.tien_id = ei.enne_tien_id ");
      sb.append("                  AND ei.enne_id = ui.usua_enne_id ");
      sb.append("                  AND ti.tien_id = 2194 ");
      sb.append("                  AND to_char(c.cli_cdgo) = ui.usua_usuario ");
      sb.append("                  AND ROWNUM = 1), 'N') existe ");
      sb.append("        , CASE WHEN f.ffs_nmro2 IS NULL THEN ");
      sb.append("             'Não cadastrado' ");
      sb.append("            ELSE ");
      sb.append("             DECODE(f.ffs_ddd2, NULL, NULL, ('(' || f.ffs_ddd2 || ') ' || ");
      sb.append("                     f.ffs_nmro2)) ");
      sb.append("          END telefone ");
      sb.append("        , case when p.pec_nome is null then c.cli_rzao else p.pec_nome end contato  ");
      sb.append("   FROM cli c ");
      sb.append("      , esc e ");
      sb.append("      , fax_fon2 f ");
      sb.append("      , (SELECT * FROM pec WHERE tps_cdgo = 1) p ");
      sb.append("  WHERE c.cli_cdgo = e.cli_cdgo ");
      sb.append("    AND p.cli_cdgo(+) = e.cli_cdgo ");
      sb.append("    AND p.esc_seqn(+) = e.esc_seqn ");
      sb.append("    AND f.cli_cdgo(+) = e.cli_cdgo ");
      sb.append("    AND f.esc_seqn(+) = e.esc_seqn ");
      sb.append("    AND c.cli_situ = 'A' ");
      sb.append("    AND e.esc_situacao = 'A' ");
      sb.append("    AND c.cli_cdgo <> 40000 ");
      sb.append("    AND c.cli_tipo_mercado = 'MI' ");
      sb.append("    AND e.esc_cgc = ?");
      sb.append("    AND rownum = 1 ");
      pstm = j.getConn().prepareStatement(sb.toString());
      pstm.setString(1, f.getCnpj());
      rset = pstm.executeQuery();
      while (rset.next()) {
        cnpjInvalido = false;
        if (rset.getString("existe").equalsIgnoreCase("S")) {
          usuarioPossuiCadastro = true;
        }
        emailAtual = rset.getString("esc_email");
        cliente = rset.getString("cli_cdgo") + "-"+rset.getString("cli_rzao");
        contato = rset.getString("contato");
        telefone = rset.getString("telefone");
        codigoCliente = rset.getInt("cli_cdgo");
        razaoSocial = rset.getString("cli_rzao");
      }
      if (cnpjInvalido) {
        session.setAttribute("mensagem_erro", "O CNPJ informado não foi encontrado!");
        throw new Exception("");
      }
      if (usuarioPossuiCadastro) {
        session.setAttribute("mensagem_erro", "Já existe um usuário criado para esse CNPJ! Utilize a opção \"Esqueci Minha Senha\" para recuperar sua senha.");
        throw new Exception("");
      }
      if (!f.getEmail().equalsIgnoreCase((emailAtual + ""))) {
        Prc_send_email_job r = new Prc_send_email_job();
        r.setP_from("no-reply@beirario.com.br");
        r.setP_to("comprarapida@beirario.com.br");
        r.setP_subject("Tentativa de cadastro de acesso ao Br Portal pelo cliente "+cliente + " com e-mail invalido.");
        sb = new StringBuilder();
        sb.append("Tentativa de cadastro de acesso ao Br Portal pelo cliente "+cliente + " com e-mail inválido. <br>");
        sb.append("Ele tentou uma confirmação de cadastro com o e-mail: "+f.getEmail() + ", mas o e-mail cadastrado para este cliente é o: "+emailAtual + ";<br>");
        sb.append("Entre em contato com o cliente ajudá-lo a fazer o cadastro.<br><br>");
        sb.append("Contato do cliente:<br>");
        sb.append("Cliente: "+cliente + "<br>");
        sb.append("Contato: "+contato + "<br>");
        sb.append("Telefone: "+telefone + "<br>");
        r.setP_message_body(sb.toString());
        r.setP_message_style("HTML");
        r = (Prc_send_email_job) j.execute(r);
        session.setAttribute("mensagem_erro", "O cadastro não pode ser concluído pois não houve a confirmação do e-mail informado!");
        throw new Exception("");
      } else {
        acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn());
        String enneId = query.retorna(j, "SELECT enne_id FROM wbrio.entidades_negocio WHERE enne_chave = '"+codigoCliente + "' AND enne_tien_id = 2194");
        if (enneId.equals("")) {
          acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn());
          acesso.TipoEntidadeNegocioAPI tipoentidade = new acesso.TipoEntidadeNegocioAPI(j.getConn(), 2194);
          entidade.setChave(codigoCliente + "");
          entidade.setTipoEntidadeNegocio(tipoentidade);
          entidade.insert();
          enneId = query.retorna(j, "SELECT enne_id FROM wbrio.entidades_negocio WHERE enne_chave = '"+codigoCliente + "' AND enne_tien_id = 2194");
        }
        String senha = util.rand.Palavra.geraPalavra();
        senha = senha.substring(0, 6);
        acesso.EntidadeNegocioAPI enne = new acesso.EntidadeNegocioAPI(j.getConn());
        enne.select(Integer.parseInt(enneId));
        usuario.setEntidadeNegocio((acesso.EntidadeNegocio) enne);
        usuario.setNome(razaoSocial);
        usuario.setEmail(emailAtual);
        usuario.setUsuario(codigoCliente + "");
        usuario.setSenha(senha.getBytes());
        usuario.setExpiraSenha("S");
        usuario.setUsuarioInclusao(codigoCliente + "");
        usuario.setSuperUsuario(false);
        usuario.setDiasConsultaRetroativa(null);
        usuario.setAcessos(1);
        usuario.insert();
        acesso.AcessoDocumentoInterfaceAPI adi = new acesso.AcessoDocumentoInterfaceAPI(j.getConn());
        adi.geraAutorizacoesUsuario(usuario.getId());
        Prc_send_email_job r = new Prc_send_email_job();
        r.setP_from("no-reply@beirario.com.br");
        r.setP_to(emailAtual);
        r.setP_subject("Calcados Beira Rio S/A - Confirmacao de cadastro no BR Portal");
        sb = new StringBuilder();
        sb.append("Olá "+razaoSocial + ", seu cadastro foi efetuado com sucesso em nosso BR Portal!<br>");
        sb.append("Seu código de cliente em nosso sistema é: "+codigoCliente + ".<br><br>");
        sb.append("Dados para acesso ao BR Portal:<br>");
        sb.append("Endereço de acesso ao BR Portal: http://brportal.beirario.com.br:8080/brportal<br>");
        sb.append("Usuário: "+codigoCliente + "<br>");
        sb.append("Senha: "+senha + "<br><br>");
        sb.append("A Calçados Beira Rio agradece o contato e deseja uma ótima experiência em nosso ambiente online.");
        r.setP_message_body(sb.toString());
        r.setP_message_style("HTML");
        r = (Prc_send_email_job) j.execute(r);
        session.setAttribute("mensagem_sucesso", "Operação realizada com sucesso! Um e-mail foi enviado a sua caixa de entrada com os dados de acesso ao BR Portal");
      }
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Usuarios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      try {
        if (rset != null) {
          rset.close();
        }
      } catch (Exception e) {
      }
      try {
        if (pstm != null) {
          pstm.close();
        }
      } catch (Exception e) {
      }
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
      SolicitacaoUsuarioActionForm f = (SolicitacaoUsuarioActionForm) form;
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
