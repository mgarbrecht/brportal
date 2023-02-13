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
 * Creation Date 29/09/2011 12:44:24
 * Last Modify Date 19/03/2014 08:59:44
 */

public class FichaCliente_dAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      FichaCliente_dActionForm f = (FichaCliente_dActionForm) form;
      try {
        tg_select_action(mapping, form, request, response, j);
        tg_select_action_1(mapping, form, request, response);
        tg_maiores_vendas(mapping, form, request, response, j);
        tg_devolucoes(mapping, form, request, response, j);
        select_action(j, mapping, form, request, response);
      }
      finally {
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    FichaCliente_dActionForm f = (FichaCliente_dActionForm) form;
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, com.egen.util.jdbc.JdbcUtil j) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      FichaCliente_dActionForm f = (FichaCliente_dActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);
      boolean temRestricao = false;

      if ((sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) || (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL"))) {
        temRestricao = true;
      }


      session.removeAttribute("cli_cdgo");
      session.removeAttribute("esc_seqn");
      session.removeAttribute("gre_grupo");


      if (f.getCli_cdgo() != null && !f.getCli_cdgo().equals("")) {
        session.setAttribute("cli_cdgo", f.getCli_cdgo());
      }
      if (f.getEsc_seqn() != null && !f.getEsc_seqn().equals("")) {
        session.setAttribute("esc_seqn", f.getEsc_seqn());
      }
      if (f.getGre_grupo() != null && !f.getGre_grupo().equals("")) {
        session.setAttribute("gre_grupo", f.getGre_grupo());
      }

      Jw_representantes_clientes_ficha_cliente table = new Jw_representantes_clientes_ficha_cliente();
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT DISTINCT rv.codigo_regional ");
      sb.append("               , rv.nome_regional ");

      if (session.getAttribute("cli_cdgo") != null) {
        sb.append("               ,cr.codigo_cliente codigo_cliente ");
        sb.append("               ,c.cli_rzao cli_rzao ");
        sb.append("               ,c.cli_nome cli_nome ");
        sb.append("               ,cr.codigo_sequencial esc_seqn ");
      } else {
        sb.append("               , '' codigo_cliente ");
        sb.append("               , '' cli_rzao ");
        sb.append("               , '' cli_nome ");
        sb.append("               , '' esc_seqn ");
      }

      sb.append("               , cr.codigo_representante ");
      sb.append("               , r.rep_rzao ");
      sb.append("               , r.rep_nome ");


      if (session.getAttribute("cli_cdgo") != null) {
        //     sb.append("            , (SELECT to_char(MIN(ped.ped_dadg),'dd/mm/yyyy') data ");
        //     sb.append("                         FROM ped ped ");
        //     sb.append("                        WHERE NVL(ped.ped_stat, NULL) <> 'C' ");
        //     sb.append("                          AND ped.cli_cdgo = c.cli_cdgo ");
        //     sb.append("                          AND ped.esc_seqn = s.esc_seqn ) cliente_desde ");
        sb.append("           , to_char(c.cli_dtin,'dd/mm/yyyy') cliente_desde ");
      } else {
        sb.append("           ,(SELECT to_char(MIN(ped.ped_dadg),'dd/mm/yyyy') ");
        sb.append("                   FROM ped ped ");
        sb.append("                      , grupo_economico gre ");
        sb.append("                  WHERE gre.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
        sb.append("                    AND NVL(ped.ped_stat, NULL) <> 'C' ");
        sb.append("                    AND NVL(gre.status, NULL) = 'A' ");
        sb.append("                    AND gre.cli_cdgo = ped.cli_cdgo) cliente_desde ");

      }


      if (session.getAttribute("cli_cdgo") != null) {
        sb.append("            , (SELECT to_char(MAX(ped.ped_dadg),'dd/mm/yyyy') data ");
        sb.append("                         FROM ped ped ");
        sb.append("                        WHERE NVL(ped.ped_stat, NULL) <> 'C' ");
        sb.append("                          AND ped.cli_cdgo = c.cli_cdgo ");
        sb.append("                          AND ped.esc_seqn = s.esc_seqn ) ultima_compra ");
      } else {
        sb.append("           ,(SELECT to_char(MAX(ped.ped_dadg),'dd/mm/yyyy') ");
        sb.append("                   FROM ped ped ");
        sb.append("                      , grupo_economico gre ");
        sb.append("                  WHERE gre.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
        sb.append("                    AND NVL(ped.ped_stat, NULL) <> 'C' ");
        sb.append("                    AND NVL(gre.status, NULL) = 'A' ");
        sb.append("                    AND gre.cli_cdgo = ped.cli_cdgo) ultima_compra");
      }

      if (session.getAttribute("cli_cdgo") != null) {
        sb.append("           ,(SELECT nvl(esc_email,'-') FROM esc e WHERE e.cli_cdgo = c.cli_cdgo and rownum = 1) email_cliente ");
        sb.append("           ,(SELECT '('||ffs_ddd2||') ' || ffs_nmro2 fone FROM fax_fon2 WHERE cli_cdgo = c.cli_cdgo and rownum = 1) fone_cliente ");
        sb.append("      ,'' gre_grupo ");
        sb.append("      ,'' gre_descricao ");
      } else {
        sb.append("           ,'' email_cliente ");
        sb.append("           ,'' fone_cliente ");
        sb.append("      ,"+(String) session.getAttribute("gre_grupo") + " gre_grupo ");
        sb.append("      ,(SELECT pck_grupo_economico.get_nome("+(String) session.getAttribute("gre_grupo") + ") FROM dual) gre_descricao ");
      }


      sb.append("              , rowtocol('SELECT mp.descricao_marca FROM representante_marca rm,marcas_produtos mp WHERE mp.codigo_marca = rm.marca_produto and rm.situacao = ''A'' AND rm.codigo_representante = '''||r.rep_cdgo||''' order by mp.codigo_marca') marcas_representante");
      sb.append("   FROM cliente_representante cr ");
      sb.append("      , regionais_vendas rv ");
      sb.append("      , rep r ");
      sb.append("      , cli c ");
      sb.append("      , esc s ");
      sb.append("  WHERE cr.codigo_representante = r.rep_cdgo ");
      sb.append("    AND s.cli_cdgo = c.cli_cdgo ");
      sb.append("    AND cr.codigo_cliente = c.cli_cdgo ");
      sb.append("    AND rv.codigo_regional = r.codigo_regional ");
      sb.append("    AND r.rep_situ = 'A' ");
      sb.append("    AND cr.situacao = 'A' ");
      sb.append("    AND rv.codigo_regional <> 99 ");


      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        sb.append(" AND r.rep_cdgo = '"+sessao.getChave() + "' ");
      }

      if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
        sb.append(" AND r.codigo_regional = "+sessao.getChave());
      }

      if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
        sb.append(" AND r.codigo_regional = (SELECT codigo_regional FROM analistas_regionais WHERE codigo_gerente = "+sessao.getChave() + ")");
      }

      sb.append("    AND cr.codigo_sequencial = s.esc_seqn ");

      if (session.getAttribute("cli_cdgo") != null) {
        sb.append(" AND c.cli_cdgo = " + (String) session.getAttribute("cli_cdgo"));
        sb.append(" AND s.esc_seqn = " + (String) session.getAttribute("esc_seqn"));
      } else {
        sb.append(" AND EXISTS (SELECT 1 ");
        sb.append("               FROM grupo_economico gre ");
        sb.append("              WHERE gre.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
        sb.append("                AND NVL(gre.status, NULL) = 'A' ");
        sb.append("                AND gre.cli_cdgo = s.cli_cdgo ) ");
      }


      Vector res_Jw_representantes_clientes_ficha_cliente = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_representantes_clientes_ficha_cliente",res_Jw_representantes_clientes_ficha_cliente);
      if (!(res_Jw_representantes_clientes_ficha_cliente != null && res_Jw_representantes_clientes_ficha_cliente.size() > 0)) {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_representantes_clientes_ficha_cliente", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }

      //---- Contatos ----
      StringBuilder sbc = new StringBuilder();
      sbc.append(" SELECT p.pec_nome nome ");
      sbc.append("      , p.pec_email email ");
      sbc.append("      , t.tps_desc tipo ");
      sbc.append("      , p.pec_data_nascimento data_nascimento ");
      sbc.append("   FROM pec p ");
      sbc.append("      , tps t ");
      sbc.append("  WHERE p.tps_cdgo = t.tps_cdgo ");
      if (session.getAttribute("cli_cdgo") != null) {
        sbc.append(" AND p.cli_cdgo = " + (String) session.getAttribute("cli_cdgo"));
        sbc.append(" AND p.esc_seqn = " + (String) session.getAttribute("esc_seqn"));
      } else {
        sbc.append(" AND EXISTS (SELECT 1 ");
        sbc.append("               FROM grupo_economico gre ");
        sbc.append("              WHERE gre.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
        sbc.append("                AND NVL(gre.status, NULL) = 'A' ");
        sbc.append("                AND gre.cli_cdgo = p.cli_cdgo ) ");
      }

      Jw_ficha_cliente_contatos table_contatos = new Jw_ficha_cliente_contatos();
      Vector res_Jw_ficha_cliente_contatos = j.select(table_contatos , sbc.toString(), null);
      session.setAttribute("res_Jw_ficha_cliente_contatos",res_Jw_ficha_cliente_contatos);
      //------------------
      session.setAttribute(mapping.getName(), form);
    }
    catch (Exception e) {
      throw e;
    } finally {
    }
  }
  private void tg_select_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      FichaCliente_dActionForm f = (FichaCliente_dActionForm) form;
      util.consultas.com.FichaCliente ficha = null;
      if (session.getAttribute("cli_cdgo") != null) {
        ficha = new util.consultas.com.FichaCliente(request, "C", Integer.parseInt((String) session.getAttribute("cli_cdgo")));
      } else {
        ficha = new util.consultas.com.FichaCliente(request, "G", Integer.parseInt((String) session.getAttribute("gre_grupo")));
      }
      ficha.buscaInformacoesMarketing();
      session.setAttribute("valor_utilizado_marketing", com.egen.util.text.FormatNumber.format(ficha.getValorUtilizadoMarketing(), "##,##0.00"));
      session.setAttribute("valor_disponivel_marketing", com.egen.util.text.FormatNumber.format(ficha.getValorDisponivelMarketing(), "##,##0.00"));
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }
  private void tg_maiores_vendas(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, com.egen.util.jdbc.JdbcUtil j) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      FichaCliente_dActionForm f = (FichaCliente_dActionForm) form;
      acesso.Sessao sessao = new acesso.Sessao(session);

      // --- Restrição Maiores Vendas no País ---
      StringBuilder sbPais = new StringBuilder();
      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        sbPais.append(" AND EXISTS (SELECT 1 ");
        sbPais.append("               FROM representante_marca rm ");
        sbPais.append("              WHERE situacao = 'A' ");
        sbPais.append("                AND codigo_representante = '"+sessao.getChave() + "' ");
        sbPais.append("                AND rm.marca_produto = f.codigo_marca) ");
      }

      // --- Restrição Maiores Vendas no Cliente ---
      StringBuilder sbCliente = new StringBuilder();
      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        sbCliente.append(" AND EXISTS (SELECT 1 ");
        sbCliente.append("               FROM representante_marca rm ");
        sbCliente.append("              WHERE rm.situacao = 'A' ");
        sbCliente.append("                AND rm.codigo_representante = '"+sessao.getChave() + "' ");
        sbCliente.append("                AND rm.marca_produto = f.codigo_marca) ");
      }

      // --- Restrição Maiores Vendas na Regional ---
      StringBuilder sbRegional = new StringBuilder();
      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        sbRegional.append(" AND p.codigo_regional = r.codigo_regional ");
        sbRegional.append(" AND r.rep_cdgo = '"+sessao.getChave() + "' ");
        sbRegional.append(" AND f.codigo_marca IN (SELECT rm.marca_produto ");
        sbRegional.append("                          FROM representante_marca rm ");
        sbRegional.append("                         WHERE rm.situacao = 'A' ");
        sbRegional.append("                           AND rm.codigo_representante = '"+sessao.getChave() + "') ");
      } else if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
        sbRegional.append(" AND p.codigo_regional = " + sessao.getChave());
      } else {
        if (session.getAttribute("cli_cdgo") != null) {
          sbRegional.append("         AND p.codigo_regional IN (SELECT DISTINCT r.codigo_regional ");
          sbRegional.append("                                     FROM rep r ");
          sbRegional.append("                                        , cliente_representante cr ");
          sbRegional.append("                                    WHERE cr.codigo_representante = r.rep_cdgo ");
          sbRegional.append("                                      AND r.codigo_regional <> 99 ");
          sbRegional.append("                                      AND cr.codigo_cliente = " + (String) session.getAttribute("cli_cdgo"));
          sbRegional.append("                                      AND ROWNUM = 1) ");
        } else {
          sbRegional.append("         AND p.codigo_regional IN (SELECT DISTINCT r.codigo_regional ");
          sbRegional.append("                                     FROM rep r ");
          sbRegional.append("                                        , cliente_representante cr ");
          sbRegional.append("                                    WHERE cr.codigo_representante = r.rep_cdgo ");
          sbRegional.append("                                      AND r.codigo_regional <> 99 ");
          sbRegional.append("                                      AND cr.codigo_cliente in (SELECT cli_cdgo ");
          sbRegional.append("                                                                 FROM grupo_economico ge ");
          sbRegional.append("                                                                WHERE ge.status = 'A' ");
          sbRegional.append("                                                                  AND ge.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
          sbRegional.append("                                                                 ) ");
          sbRegional.append("                                     AND ROWNUM = 1) ");
        }
      }


      //--- Maiores Vendas Cliente/Grupo ---
      Jw_ficha_cliente_maiores_vendas tablec = new Jw_ficha_cliente_maiores_vendas();
      StringBuilder sbc = new StringBuilder();
      sbc.append(" SELECT ROWNUM ordem ");
      sbc.append("      , fct_mask_modelo(lin_cdgo,ref_cdgo) modelo ");
      sbc.append("      , pares");
      sbc.append("      , valor ");
      sbc.append("      , fct_retorna_fit_imagem(lin_cdgo, ref_cdgo) imagem ");
      sbc.append("      , lin_cdgo ");
      sbc.append("      , ref_cdgo ");
      sbc.append("   FROM (SELECT /*+use index (p RESUMO_PED) */ ");
      sbc.append("                f.lin_cdgo ");
      sbc.append("              , f.ref_cdgo ");
      sbc.append("              , SUM(p.pares) pares ");
      sbc.append("              , SUM(p.valor) valor ");
      sbc.append("           FROM resumo_ped p ");
      sbc.append("              , cli c ");
      sbc.append("              , rep r ");
      sbc.append("              , lin l ");
      sbc.append("              , REF f ");
      sbc.append("          WHERE p.data_dig >= TRUNC(SYSDATE, 'month') ");
      sbc.append("            AND p.data_dig < TRUNC(LAST_DAY(SYSDATE)) + 1 ");
      sbc.append("            AND c.cli_cdgo = p.cli_cdgo ");
      sbc.append("            AND r.rep_cdgo = p.rep_cdgo ");
      sbc.append("            AND p.lin_cdgo = f.lin_cdgo ");
      sbc.append("            AND p.ref_cdgo = f.ref_cdgo ");

      sbc.append(sbCliente.toString());

      sbc.append("            AND l.lin_cdgo = p.lin_cdgo ");
      sbc.append("            AND l.ind_aberto_fechado IS NOT NULL ");

      if (session.getAttribute("cli_cdgo") != null) {
        sbc.append("           and nvl(p.cli_cdgo,NULL) = " + (String) session.getAttribute("cli_cdgo"));
        sbc.append("           and nvl(p.esc_seqn,NULL) = " + (String) session.getAttribute("esc_seqn"));
      } else {
        sbc.append("          AND EXISTS (SELECT 1 ");
        sbc.append("                        FROM grupo_economico gre  ");
        sbc.append("                       WHERE gre.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
        sbc.append("                         AND NVL(gre.status, NULL) = 'A' ");
        sbc.append("                         AND gre.cli_cdgo = p.cli_cdgo ) ");
      }

      sbc.append("       GROUP BY f.lin_cdgo ");
      sbc.append("              , f.ref_cdgo ");
      sbc.append("       ORDER BY pares DESC ");
      sbc.append("              , valor DESC) p ");
      sbc.append("  WHERE ROWNUM <= 5 ");

      Vector res_Jw_ficha_cliente_maiores_vendas_cliente = j.select(tablec, sbc.toString(), null);
      session.setAttribute("res_Jw_ficha_cliente_maiores_vendas_cliente",res_Jw_ficha_cliente_maiores_vendas_cliente);





      //--- Maiores Vendas Regional ---
      Jw_ficha_cliente_maiores_vendas table = new Jw_ficha_cliente_maiores_vendas();
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT ROWNUM ordem ");
      sb.append("      , fct_mask_modelo(lin_cdgo,ref_cdgo) modelo ");
      sb.append("      , p.pares");
      sb.append("      , p.valor ");
      sb.append("      , fct_retorna_fit_imagem(lin_cdgo, ref_cdgo) imagem ");
      sb.append("      , lin_cdgo ");
      sb.append("      , ref_cdgo ");
      sb.append("   FROM (SELECT /*+use index (p RESUMO_PED) */ ");
      sb.append("                p.lin_cdgo ");
      sb.append("              , p.ref_cdgo ");
      sb.append("              , SUM(p.pares) pares ");
      sb.append("              , SUM(p.valor) valor ");
      sb.append("           FROM resumo_ped p ");
      sb.append("              , cli c ");
      sb.append("              , rep r ");
      sb.append("              , lin l ");
      sb.append("              , REF f ");
      sb.append("          WHERE p.data_dig >= TRUNC(SYSDATE, 'month') ");
      sb.append("            AND p.data_dig < TRUNC(LAST_DAY(SYSDATE)) + 1 ");
      sb.append("            AND c.cli_cdgo = p.cli_cdgo ");
      sb.append("            AND r.rep_cdgo = p.rep_cdgo ");
      sb.append("            AND p.lin_cdgo = f.lin_cdgo ");
      sb.append("            AND p.ref_cdgo = f.ref_cdgo ");
      sb.append("            AND l.lin_cdgo = p.lin_cdgo ");
      sb.append(sbRegional.toString());
      sb.append("            AND l.ind_aberto_fechado IS NOT NULL ");
      sb.append("       GROUP BY p.lin_cdgo ");
      sb.append("              , p.ref_cdgo ");
      sb.append("       ORDER BY pares DESC ");
      sb.append("              , valor DESC) p ");
      sb.append("  WHERE ROWNUM <= 5 ");

      Vector res_Jw_ficha_cliente_maiores_vendas_regional = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_ficha_cliente_maiores_vendas_regional",res_Jw_ficha_cliente_maiores_vendas_regional);

      //--- Maiores Vendas Pais ---
      Jw_ficha_cliente_maiores_vendas table2 = new Jw_ficha_cliente_maiores_vendas();
      StringBuilder sbp = new StringBuilder();
      sbp.append(" SELECT ROWNUM ordem ");
      sbp.append("      , fct_mask_modelo(lin_cdgo, ref_cdgo) modelo ");
      sbp.append("      , pares ");
      sbp.append("      , valor ");
      sbp.append("      , fct_retorna_fit_imagem(lin_cdgo, ref_cdgo) imagem ");
      sbp.append("      , codigo_marca ");
      sbp.append("      , pck_marcas_produtos.get_nome(codigo_marca) descricao_marca ");
      sbp.append("      , lin_cdgo ");
      sbp.append("      , ref_cdgo ");
      sbp.append("   FROM (SELECT codigo_marca ");
      sbp.append("              , p.pares ");
      sbp.append("              , p.valor ");
      sbp.append("              , lin_cdgo ");
      sbp.append("              , ref_cdgo ");
      sbp.append("           FROM (SELECT /*+use index (p RESUMO_PED) */ ");
      sbp.append("                        f.codigo_marca ");
      sbp.append("                      , p.lin_cdgo ");
      sbp.append("                      , p.ref_cdgo ");
      sbp.append("                      , SUM(p.pares) pares ");
      sbp.append("                      , SUM(p.valor) valor ");
      sbp.append("                   FROM resumo_ped p ");
      sbp.append("                      , cli c ");
      sbp.append("                      , rep r ");
      sbp.append("                      , lin l ");
      sbp.append("                      , REF f ");
      sbp.append("                  WHERE p.data_dig >= TRUNC(SYSDATE) - 15 ");
      sbp.append("                    AND p.data_dig <= TRUNC(SYSDATE) ");
      sbp.append("                    AND c.cli_cdgo = p.cli_cdgo ");
      sbp.append("                    AND NVL(f.codigo_marca, NULL) = 1 ");
      sbp.append(sbPais.toString());
      sbp.append("                    AND r.rep_cdgo = p.rep_cdgo ");
      sbp.append("                    AND p.lin_cdgo = f.lin_cdgo ");
      sbp.append("                    AND p.ref_cdgo = f.ref_cdgo ");
      sbp.append("                    AND l.lin_cdgo = p.lin_cdgo ");
      sbp.append("                    AND l.ind_aberto_fechado IS NOT NULL ");
      sbp.append("                  GROUP BY p.lin_cdgo ");
      sbp.append("                         , p.ref_cdgo ");
      sbp.append("                         , f.codigo_marca ");
      sbp.append("                  ORDER BY pares DESC ");
      sbp.append("                         , valor DESC) p ");
      sbp.append("          WHERE ROWNUM <= 10 ");
      sbp.append("         UNION ");
      sbp.append("         SELECT codigo_marca ");
      sbp.append("              , p.pares ");
      sbp.append("              , p.valor ");
      sbp.append("              , lin_cdgo ");
      sbp.append("              , ref_cdgo ");
      sbp.append("           FROM (SELECT /*+use index (p RESUMO_PED) */ ");
      sbp.append("                        f.codigo_marca ");
      sbp.append("                      , SUM(p.pares) pares ");
      sbp.append("                      , SUM(p.valor) valor ");
      sbp.append("                      , p.lin_cdgo ");
      sbp.append("                      , p.ref_cdgo ");
      sbp.append("                   FROM resumo_ped p ");
      sbp.append("                      , cli c ");
      sbp.append("                      , rep r ");
      sbp.append("                      , lin l ");
      sbp.append("                      , ref f ");
      sbp.append("                  WHERE p.data_dig >= TRUNC(SYSDATE) - 15 ");
      sbp.append("                    AND p.data_dig <= TRUNC(SYSDATE) ");
      sbp.append("                    AND c.cli_cdgo = p.cli_cdgo ");
      sbp.append("                    AND NVL(f.codigo_marca, NULL) = 3 ");
      sbp.append(sbPais.toString());
      sbp.append("                    AND r.rep_cdgo = p.rep_cdgo ");
      sbp.append("                    AND p.lin_cdgo = f.lin_cdgo ");
      sbp.append("                    AND p.ref_cdgo = f.ref_cdgo ");
      sbp.append("                    AND l.lin_cdgo = p.lin_cdgo ");
      sbp.append("                    AND l.ind_aberto_fechado IS NOT NULL ");
      sbp.append("                  GROUP BY p.lin_cdgo ");
      sbp.append("                         , p.ref_cdgo ");
      sbp.append("                         , f.codigo_marca ");
      sbp.append("                  ORDER BY pares DESC ");
      sbp.append("                         , valor DESC) p ");
      sbp.append("          WHERE ROWNUM <= 10 ");
      sbp.append("         UNION ");
      sbp.append("         SELECT codigo_marca ");
      sbp.append("              , p.pares ");
      sbp.append("              , p.valor ");
      sbp.append("              , lin_cdgo ");
      sbp.append("              , ref_cdgo ");
      sbp.append("           FROM (SELECT /*+use index (p RESUMO_PED) */ ");
      sbp.append("                        f.codigo_marca ");
      sbp.append("                      , SUM(p.pares) pares ");
      sbp.append("                      , SUM(p.valor) valor ");
      sbp.append("                      , p.lin_cdgo ");
      sbp.append("                      , p.ref_cdgo ");
      sbp.append("                   FROM resumo_ped p ");
      sbp.append("                      , cli c ");
      sbp.append("                      , rep r ");
      sbp.append("                      , lin l ");
      sbp.append("                      , ref f ");
      sbp.append("                  WHERE p.data_dig >= TRUNC(SYSDATE) - 15 ");
      sbp.append("                    AND p.data_dig <= TRUNC(SYSDATE) ");
      sbp.append("                    AND c.cli_cdgo = p.cli_cdgo ");
      sbp.append("                    AND NVL(f.codigo_marca, NULL) = 16 ");
      sbp.append(sbPais.toString());
      sbp.append("                    AND r.rep_cdgo = p.rep_cdgo ");
      sbp.append("                    AND p.lin_cdgo = f.lin_cdgo ");
      sbp.append("                    AND p.ref_cdgo = f.ref_cdgo ");
      sbp.append("                    AND l.lin_cdgo = p.lin_cdgo ");
      sbp.append("                    AND l.ind_aberto_fechado IS NOT NULL ");
      sbp.append("                  GROUP BY p.lin_cdgo ");
      sbp.append("                         , p.ref_cdgo ");
      sbp.append("                         , f.codigo_marca ");
      sbp.append("                  ORDER BY pares DESC ");
      sbp.append("                         , valor DESC) p ");
      sbp.append("          WHERE ROWNUM <= 10 ");
      sbp.append("         UNION ");
      sbp.append("         SELECT codigo_marca ");
      sbp.append("              , p.pares ");
      sbp.append("              , p.valor ");
      sbp.append("              , lin_cdgo ");
      sbp.append("              , ref_cdgo ");
      sbp.append("           FROM (SELECT /*+use index (p RESUMO_PED) */ ");
      sbp.append("                        f.codigo_marca ");
      sbp.append("                      , SUM(p.pares) pares ");
      sbp.append("                      , SUM(p.valor) valor ");
      sbp.append("                      , p.lin_cdgo ");
      sbp.append("                      , p.ref_cdgo ");
      sbp.append("                   FROM resumo_ped p ");
      sbp.append("                      , cli c ");
      sbp.append("                      , rep r ");
      sbp.append("                      , lin l ");
      sbp.append("                      , ref f ");
      sbp.append("                  WHERE p.data_dig >= TRUNC(SYSDATE) - 15 ");
      sbp.append("                    AND p.data_dig <= TRUNC(SYSDATE) ");
      sbp.append("                    AND c.cli_cdgo = p.cli_cdgo ");
      sbp.append("                    AND NVL(f.codigo_marca, NULL) = 9");
      sbp.append(sbPais.toString());
      sbp.append("                    AND r.rep_cdgo = p.rep_cdgo ");
      sbp.append("                    AND p.lin_cdgo = f.lin_cdgo ");
      sbp.append("                    AND p.ref_cdgo = f.ref_cdgo ");
      sbp.append("                    AND l.lin_cdgo = p.lin_cdgo ");
      sbp.append("                    AND l.ind_aberto_fechado IS NOT NULL ");
      sbp.append("                  GROUP BY p.lin_cdgo ");
      sbp.append("                         , p.ref_cdgo ");
      sbp.append("                         , f.codigo_marca ");
      sbp.append("                  ORDER BY pares DESC ");
      sbp.append("                         , valor DESC) p ");
      sbp.append("          WHERE ROWNUM <= 10 ");
      sbp.append("         UNION ");
      sbp.append("         SELECT codigo_marca ");
      sbp.append("              , p.pares ");
      sbp.append("              , p.valor ");
      sbp.append("              , p.lin_cdgo ");
      sbp.append("              , p.ref_cdgo ");
      sbp.append("           FROM (SELECT /*+use index (p RESUMO_PED) */ ");
      sbp.append("                        f.codigo_marca ");
      sbp.append("                      , SUM(p.pares) pares ");
      sbp.append("                      , SUM(p.valor) valor ");
      sbp.append("                      , p.lin_cdgo ");
      sbp.append("                      , p.ref_cdgo ");
      sbp.append("                   FROM resumo_ped p ");
      sbp.append("                      , cli c ");
      sbp.append("                      , rep r ");
      sbp.append("                      , lin l ");
      sbp.append("                      , ref f ");
      sbp.append("                  WHERE p.data_dig >= TRUNC(SYSDATE) - 15 ");
      sbp.append("                    AND p.data_dig <= TRUNC(SYSDATE) ");
      sbp.append("                    AND c.cli_cdgo = p.cli_cdgo ");
      sbp.append("                    AND NVL(f.codigo_marca, NULL) = 17 ");
      sbp.append(sbPais.toString());
      sbp.append("                    AND r.rep_cdgo = p.rep_cdgo ");
      sbp.append("                    AND p.lin_cdgo = f.lin_cdgo ");
      sbp.append("                    AND p.ref_cdgo = f.ref_cdgo ");
      sbp.append("                    AND l.lin_cdgo = p.lin_cdgo ");
      sbp.append("                    AND l.ind_aberto_fechado IS NOT NULL ");
      sbp.append("                  GROUP BY p.lin_cdgo ");
      sbp.append("                         , p.ref_cdgo ");
      sbp.append("                         , f.codigo_marca ");
      sbp.append("                  ORDER BY pares DESC ");
      sbp.append("                         , valor DESC) p ");
      sbp.append("          WHERE ROWNUM <= 10 ");
      sbp.append("         UNION ");
      sbp.append("         SELECT codigo_marca ");
      sbp.append("              , p.pares ");
      sbp.append("              , p.valor ");
      sbp.append("              , p.lin_cdgo ");
      sbp.append("              , p.ref_cdgo ");
      sbp.append("           FROM (SELECT /*+use index (p RESUMO_PED) */ ");
      sbp.append("                        f.codigo_marca ");
      sbp.append("                      , SUM(p.pares) pares ");
      sbp.append("                      , SUM(p.valor) valor ");
      sbp.append("                      , p.lin_cdgo ");
      sbp.append("                      , p.ref_cdgo ");
      sbp.append("                   FROM resumo_ped p ");
      sbp.append("                      , cli c ");
      sbp.append("                      , rep r ");
      sbp.append("                      , lin l ");
      sbp.append("                      , ref f ");
      sbp.append("                  WHERE p.data_dig >= TRUNC(SYSDATE) - 15 ");
      sbp.append("                    AND p.data_dig <= TRUNC(SYSDATE) ");
      sbp.append("                    AND c.cli_cdgo = p.cli_cdgo ");
      sbp.append("                    AND NVL(f.codigo_marca, NULL) = 18 ");
      sbp.append(sbPais.toString());
      sbp.append("                    AND r.rep_cdgo = p.rep_cdgo ");
      sbp.append("                    AND p.lin_cdgo = f.lin_cdgo ");
      sbp.append("                    AND p.ref_cdgo = f.ref_cdgo ");
      sbp.append("                    AND l.lin_cdgo = p.lin_cdgo ");
      sbp.append("                    AND l.ind_aberto_fechado IS NOT NULL ");
      sbp.append("                  GROUP BY p.lin_cdgo ");
      sbp.append("                         , p.ref_cdgo ");
      sbp.append("                         , f.codigo_marca ");
      sbp.append("                  ORDER BY pares DESC ");
      sbp.append("                         , valor DESC) p ");
      sbp.append("          WHERE ROWNUM <= 10) ");
      sbp.append("  ORDER BY codigo_marca ");
      sbp.append("         , pares DESC ");
      sbp.append("         , valor DESC ");

      Vector res_Jw_ficha_cliente_maiores_vendas_pais = j.select(table2, sbp.toString(), null);
      session.setAttribute("res_Jw_ficha_cliente_maiores_vendas_pais",res_Jw_ficha_cliente_maiores_vendas_pais);

      session.setAttribute(mapping.getName(), form);
    }
    catch (Exception e) {
      e.printStackTrace(System.out);
      throw e;
    } finally {
    }
  }
  private void tg_devolucoes(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, com.egen.util.jdbc.JdbcUtil j) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      FichaCliente_dActionForm f = (FichaCliente_dActionForm) form;
      Jw_ficha_cliente_devolucoes table = new Jw_ficha_cliente_devolucoes();
      acesso.Sessao sessao = new acesso.Sessao(session);
      boolean temRestricao = false;

      StringBuilder parametros = new StringBuilder();
      if ((sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) || (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL"))) {
        temRestricao = true;
      }
      if (temRestricao) {
        parametros.append("  AND EXISTS (SELECT 1 ");
        parametros.append("                FROM rep r ");
        parametros.append("                   , cliente_representante cr ");
        parametros.append("                   , analistas_regionais a ");
        parametros.append("               WHERE rep_situ = 'A' ");
        parametros.append("                 AND cr.situacao = 'A' ");
        parametros.append("                 AND a.codigo_regional = r.codigo_regional ");
        parametros.append("                 AND r.rep_cdgo = cr.codigo_representante ");
        if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
          parametros.append("              AND r.codigo_regional = " + sessao.getChave());
          parametros.append("              AND r.rep_cdgo = dm.rep_cdgo ");
        }
        if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
          parametros.append("              AND r.rep_cdgo = '"+sessao.getChave() + "' ");
          parametros.append("              AND r.rep_cdgo = dm.rep_cdgo ");
        }
        if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
          parametros.append("              AND a.codigo_gerente = '"+sessao.getChave() + "' ");
          parametros.append("              AND r.rep_cdgo = dm.rep_cdgo ");
        }
        parametros.append("                 AND cr.codigo_cliente = ns.cli_cdgo ");
        parametros.append("                 AND cr.codigo_sequencial = ns.esc_seqn) ");
      }

      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT ROWNUM ordem ");
      sb.append("       ,data_cad ");
      sb.append("       ,nfs_nmro ");
      sb.append("       ,pares ");
      sb.append("       ,valor ");
      sb.append("   FROM (SELECT dm.data_cad ");
      sb.append("               ,ns.nfs_nmro ");
      sb.append("               ,SUM(idv.total_pares) pares ");
      sb.append("               ,SUM(idv.valor_total) valor ");
      sb.append("           FROM devolucoes_mercadorias dm ");
      sb.append("               ,itens_devolucoes idv ");
      sb.append("               ,nf_item ni ");
      sb.append("               ,nf_saida ns ");
      sb.append("          WHERE dm.data_cad >= TRUNC(SYSDATE, 'mm') ");
      sb.append("            AND dm.data_cad <= TRUNC(LAST_DAY(SYSDATE)) ");
      sb.append("            AND ns.emp_empresa = ni.emp_empresa ");
      sb.append("            AND ns.fil_filial = ni.fil_filial ");
      sb.append("            AND ns.nfs_nmro = ni.nfs_nmro ");
      sb.append("            AND ns.nfs_serie = ni.nfs_serie ");
      sb.append("            AND ni.emp_empresa = dm.nfs_emp_empresa ");
      sb.append("            AND ni.fil_filial = dm.nfs_fil_filial ");
      sb.append(parametros.toString());


      if (session.getAttribute("cli_cdgo") != null) {
        sb.append("           and nvl(ns.cli_cdgo,NULL) = " + (String) session.getAttribute("cli_cdgo"));
        sb.append("           and nvl(ns.esc_seqn,NULL) = " + (String) session.getAttribute("esc_seqn"));
      } else {
        sb.append("          AND EXISTS (SELECT 1 ");
        sb.append("                        FROM grupo_economico gre  ");
        sb.append("                       WHERE gre.gre_grupo = " + (String) session.getAttribute("gre_grupo"));
        sb.append("                         AND NVL(gre.status, NULL) = 'A' ");
        sb.append("                         AND gre.cli_cdgo = ns.cli_cdgo ) ");
      }

      sb.append("            AND ni.nfs_nmro = dm.nfs_numero ");
      sb.append("            AND ni.nfs_serie = dm.nfs_serie ");
      sb.append("            AND ni.nfi_seqitem = idv.nfi_seqitem ");
      sb.append("            AND dm.codigo = idv.devmerc_codigo ");
      sb.append("            AND ((dm.motdev_codigo <> 85) AND (dm.motdev_codigo <> 54 AND dm.sitdev_codigo <> 2)) ");
      sb.append("            AND NOT EXISTS (SELECT * ");
      sb.append("                               FROM nf_refat_dev nrd ");
      sb.append("                              WHERE nrd.emp_empresa = dm.nfs_emp_empresa ");
      sb.append("                                AND nrd.fil_filial = dm.nfs_fil_filial ");
      sb.append("                                AND nrd.nfs_nmro = dm.nfs_numero ");
      sb.append("                                AND nrd.nfs_serie = dm.nfs_serie ");
      sb.append("                                AND CASE WHEN nrd.tipo_refaturamento = pck_nf_refat_dev.get_refaturamento AND nrd.cli_cdgo <> dm.cli_cdgo THEN 0 ELSE 1 END = 1 ");
      sb.append("                                AND nrd.estagio <> pck_nf_refat_dev.get_estagio_cancelado) ");
      sb.append("            AND NOT EXISTS (SELECT * ");
      sb.append("                   FROM ite ite ");
      sb.append("                       ,ped ped ");
      sb.append("                  WHERE ite.emp_empresa_refat = dm.nfs_emp_empresa ");
      sb.append("                    AND ite.fil_filial_refat = dm.nfs_fil_filial ");
      sb.append("                    AND ite.nfs_nmro_refat = dm.nfs_numero ");
      sb.append("                    AND ite.nfs_serie_refat = dm.nfs_serie ");
      sb.append("                    AND ite.ped_nmro = ped.ped_nmro ");
      sb.append("                    AND CASE WHEN ped.cli_cdgo <> dm.cli_cdgo THEN 0 ELSE 1 END = 1 ");
      sb.append("                    AND ped.ped_stat <> 'C' ) ");
      sb.append("          GROUP BY dm.data_cad ");
      sb.append("                  ,ns.nfs_nmro ");
      sb.append("          ORDER BY dm.data_cad DESC) ");
      //    sb.append("  WHERE ROWNUM <= 5 ");



      Vector res_Jw_ficha_cliente_devolucoes = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_ficha_cliente_devolucoes",res_Jw_ficha_cliente_devolucoes);
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      e.printStackTrace(System.out);
      throw e;
    } finally {
    }
  }
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FichaCliente_dActionForm f = (FichaCliente_dActionForm) form;
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

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      FichaCliente_dActionForm f = (FichaCliente_dActionForm) form;


      actionForward = new ActionForward("/com/FichaClienteForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_2", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
}
