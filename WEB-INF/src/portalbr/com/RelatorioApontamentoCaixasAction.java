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
 * Creation Date 21/09/2022 11:08:46
 * Last Modify Date 26/09/2022 17:58:00
 */

public class RelatorioApontamentoCaixasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      RelatorioApontamentoCaixasActionForm f = (RelatorioApontamentoCaixasActionForm) form;
      if (f.getRem_nro().equals("") && f.getPed_nmro().equals("")) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif'> deve ser informado!");
      }
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/RelatorioApontamentoCaixas_rForm.jsp", false);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_apontamento_caixas_corrugadas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    RelatorioApontamentoCaixasActionForm f = (RelatorioApontamentoCaixasActionForm) form;
    Jw_apontamento_caixas_corrugadas table = new Jw_apontamento_caixas_corrugadas();
    Jw_apontamento_caixas_corrugadas_resumo table_resumo = new Jw_apontamento_caixas_corrugadas_resumo();
    StringBuilder sbParametros = new StringBuilder();
    if (f.getRem_nro() != "") {
      String remessas = f.getRem_nro().replaceAll("[^0-9]", " ").trim();
      remessas = remessas.replaceAll("\\s+", " ");
      remessas = remessas.replaceAll(" ", "\n");
      remessas = remessas.replaceAll("\\r\\n|\\r|\\n", ",");
      if (remessas.length() > 0 && (remessas.charAt(remessas.length() - 1) + "").equalsIgnoreCase(",")) {
        remessas = remessas.substring(0, remessas.lastIndexOf(","));
      }
      sbParametros.append(" AND rr.rem_nro IN (").append(remessas).append(") ");
    }

    if (f.getPed_nmro() != "") {
      String pedidos = f.getPed_nmro().replaceAll("[^0-9]", " ").trim();
      pedidos = pedidos.replaceAll("\\s+", " ");
      pedidos = pedidos.replaceAll(" ", "\n");
      pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");
      if (pedidos.length() > 0 && (pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
        pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
      }
      sbParametros.append(" AND p.ped_nmro IN (").append(pedidos).append(") ");
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT * ");
    sb.append("   FROM (SELECT DISTINCT p.emp_empresa ");
    sb.append("                       , fct_retorna_fil_producao(p.ped_nmro, i.ite_seqn) fil_filial ");
    sb.append("                       , i.codigo_marca ");
    sb.append("                       , mp.descricao_marca ");
    sb.append("                       , p.cli_cdgo ");
    sb.append("                       , c.cli_rzao cli_desc ");
    sb.append("                       , 'NÃO' apont ");
    sb.append("                       , NULL data_apont ");
    sb.append("                       , NULL usuario_apont ");
    sb.append("                       , NULL data_alteracao ");
    sb.append("                       , NULL usuario_alteracao ");
    sb.append("                       , p.ped_invoice ");
    sb.append("                       , pck_cliente.get_normativa(p.cli_cdgo, p.esc_seqn) normativa ");
    sb.append("                       , p.tra_cdgo ");
    sb.append("                       , rr.rem_nro ");
    sb.append("                       , rr.seq_rotulo ");
    sb.append("                       , rr.ped_nmro ");
    sb.append("                       , rr.ite_seqn ");
    sb.append("                       , i.lin_cdgo ");
    sb.append("                       , i.ref_cdgo ");
    sb.append("                       , i.cab_cdgo ");
    sb.append("                       , i.cor_cdgo ");
    sb.append("                       , rr.total_pares qtde ");
    sb.append("           FROM rotulos_remessa     rr ");
    sb.append("              , ped                 p ");
    sb.append("              , qtd_rotulos_remessa q ");
    sb.append("              , ite                 i ");
    sb.append("              , rep                 r ");
    sb.append("              , cli                 c ");
    sb.append("              , marcas_produtos     mp ");
    sb.append("          WHERE ('").append(f.getTipo()).append("' = 'T' OR '").append(f.getTipo()).append("' = 'N')");
    sb.append("            AND p.ped_nmro = rr.ped_nmro ");
    sb.append("            AND p.cli_cdgo = c.cli_cdgo ");
    sb.append("            AND i.codigo_marca = mp.codigo_marca ");
    sb.append("            AND (rr.tipo_geracao != 'E' OR EXISTS (SELECT NULL ");
    sb.append("                                                     FROM ped_inf_adicionais a ");
    sb.append("                                                    WHERE a.ped_nmro = p.ped_nmro ");
    sb.append("                                                      AND a.etiquetas IS NOT NULL)) ");
    sb.append("            AND q.ped_nmro = rr.ped_nmro ");
    sb.append("            AND q.ite_seqn = rr.ite_seqn ");
    sb.append("            AND q.rem_nro = rr.rem_nro ");
    sb.append("            AND q.rotulo = rr.rotulo ");
    sb.append("            AND i.ped_nmro = rr.ped_nmro ");
    sb.append("            AND i.ite_seqn = rr.ite_seqn ");
    sb.append("            AND r.rep_cdgo = p.rep_cdgo ");
    sb.append(sbParametros.toString());
    sb.append("            AND NOT EXISTS (SELECT * ");
    sb.append("                              FROM rotulos_remessa_apont a ");
    sb.append("                             WHERE a.ped_nmro = rr.ped_nmro ");
    sb.append("                               AND a.ite_seqn = rr.ite_seqn ");
    sb.append("                               AND a.rem_nro = rr.rem_nro ");
    sb.append("                               AND a.rotulo = rr.seq_rotulo ");
    sb.append("                               AND ROWNUM = 1) ");
    sb.append("         UNION ALL ");
    sb.append("         SELECT DISTINCT p.emp_empresa ");
    sb.append("                       , fct_retorna_fil_producao(p.ped_nmro, i.ite_seqn) fil_filial ");
    sb.append("                       , i.codigo_marca ");
    sb.append("                       , mp.descricao_marca ");
    sb.append("                       , p.cli_cdgo ");
    sb.append("                       , c.cli_rzao cli_desc ");
    sb.append("                       , 'SIM' apont ");
    sb.append("                       , a.data_apont_leitura data_apont ");
    sb.append("                       , a.usuario_inclusao usuario_apont ");
    sb.append("                       , a.dthr_alteracao data_alteracao ");
    sb.append("                       , a.usuario_alteracao usuario_alteracao ");
    sb.append("                       , p.ped_invoice ");
    sb.append("                       , pck_cliente.get_normativa(p.cli_cdgo, p.esc_seqn) normativa ");
    sb.append("                       , p.tra_cdgo ");
    sb.append("                       , rr.rem_nro ");
    sb.append("                       , rr.seq_rotulo ");
    sb.append("                       , rr.ped_nmro ");
    sb.append("                       , rr.ite_seqn ");
    sb.append("                       , i.lin_cdgo ");
    sb.append("                       , i.ref_cdgo ");
    sb.append("                       , i.cab_cdgo ");
    sb.append("                       , i.cor_cdgo ");
    sb.append("                       , rr.total_pares qtde ");
    sb.append("           FROM rotulos_remessa       rr ");
    sb.append("              , ped                   p ");
    sb.append("              , qtd_rotulos_remessa   q ");
    sb.append("              , ite                   i ");
    sb.append("              , rep                   r ");
    sb.append("              , cli                   c ");
    sb.append("              , marcas_produtos       mp ");
    sb.append("              , rotulos_remessa_apont a ");
    sb.append("          WHERE ('").append(f.getTipo()).append("' = 'T' OR '").append(f.getTipo()).append("' = 'A') ");
    sb.append("            AND p.ped_nmro = rr.ped_nmro ");
    sb.append("            AND p.cli_cdgo = c.cli_cdgo ");
    sb.append("            AND i.codigo_marca = mp.codigo_marca ");
    sb.append("            AND (rr.tipo_geracao != 'E' OR EXISTS (SELECT NULL ");
    sb.append("                                                     FROM ped_inf_adicionais a ");
    sb.append("                                                    WHERE a.ped_nmro = p.ped_nmro ");
    sb.append("                                                      AND a.etiquetas IS NOT NULL)) ");
    sb.append("            AND q.ped_nmro = rr.ped_nmro ");
    sb.append("            AND q.ite_seqn = rr.ite_seqn ");
    sb.append("            AND q.rem_nro = rr.rem_nro ");
    sb.append("            AND q.rotulo = rr.rotulo ");
    sb.append("            AND i.ped_nmro = rr.ped_nmro ");
    sb.append("            AND i.ite_seqn = rr.ite_seqn ");
    sb.append("            AND r.rep_cdgo = p.rep_cdgo ");
    sb.append("            AND a.ped_nmro = rr.ped_nmro ");
    sb.append("            AND a.ite_seqn = rr.ite_seqn ");
    sb.append("            AND a.rem_nro = rr.rem_nro ");
    sb.append("            AND a.rotulo = rr.seq_rotulo ");
    sb.append(sbParametros.toString());
    sb.append("         ) q ");
    if (f.getFornecedor() != "") {
      sb.append(" WHERE EXISTS (SELECT 1");
      sb.append("                 FROM atelier_rem_taloes_oc arto ");
      sb.append("                WHERE aroc_rem_nro = q.rem_nro ");
      sb.append("                  AND arto.for_codigo = "+f.getFornecedor() + ") ");
    }
    sb.append("  ORDER BY emp_empresa ");
    sb.append("         , fil_filial ");
    sb.append("         , codigo_marca ");
    sb.append("         , rem_nro ");
    sb.append("         , seq_rotulo ");
    sb.append("         , ped_nmro ");
    sb.append("         , ite_seqn ");

    StringBuilder sbResumo = new StringBuilder();
    sbResumo.append(" SELECT q.lin_cdgo ");
    sbResumo.append("      , COUNT(q.qtde) total_caixas ");
    sbResumo.append("      , COUNT(q.qtde) - SUM(caixa_apontada) caixas_pendentes ");
    sbResumo.append("   FROM (SELECT rr.rem_nro ");
    sbResumo.append("              , rr.seq_rotulo ");
    sbResumo.append("              , i.lin_cdgo ");
    sbResumo.append("              , rr.total_pares qtde ");
    sbResumo.append("              , COUNT(DISTINCT rra.rem_nro || rra.rotulo || rra.ped_nmro) caixa_apontada ");
    sbResumo.append("           FROM rotulos_remessa_apont rra ");
    sbResumo.append("              , rotulos_remessa       rr ");
    sbResumo.append("              , ped                   p ");
    sbResumo.append("              , ite                   i ");
    sbResumo.append("              , rep                   r ");
    sbResumo.append("          WHERE rra.rem_nro(+) = rr.rem_nro ");
    sbResumo.append("            AND rra.ped_nmro(+) = rr.ped_nmro ");
    sbResumo.append("            AND rra.ite_seqn(+) = rr.ite_seqn ");
    sbResumo.append("            AND rra.rotulo(+) = rr.seq_rotulo ");
    sbResumo.append("            AND p.ped_nmro = rr.ped_nmro ");
    sbResumo.append("            AND NVL(rr.tipo_geracao, NULL) <> 'E' ");
    sbResumo.append("            AND i.ped_nmro = rr.ped_nmro ");
    sbResumo.append("            AND i.ite_seqn = rr.ite_seqn ");
    sbResumo.append("            AND r.rep_cdgo = p.rep_cdgo ");
    sbResumo.append(sbParametros.toString());
    if (f.getFornecedor() != "") {
      sbResumo.append(" AND EXISTS (SELECT 1");
      sbResumo.append("                 FROM atelier_rem_taloes_oc arto ");
      sbResumo.append("                WHERE aroc_rem_nro = rr.rem_nro ");
      sbResumo.append("                  AND arto.for_codigo = "+f.getFornecedor() + ") ");
    }
    sbResumo.append("          GROUP BY rr.rem_nro ");
    sbResumo.append("                 , rr.seq_rotulo ");
    sbResumo.append("                 , i.lin_cdgo ");
    sbResumo.append("                 , rr.total_pares) q ");
    sbResumo.append("  GROUP BY q.lin_cdgo ");
    sbResumo.append("  ORDER BY lin_cdgo ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_apontamento_caixas_corrugadas = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_apontamento_caixas_corrugadas",res_Jw_apontamento_caixas_corrugadas);

    Vector res_Jw_apontamento_caixas_corrugadas_resumo = j.select(table_resumo, sbResumo.toString(), null);
    session.setAttribute("res_Jw_apontamento_caixas_corrugadas_resumo",res_Jw_apontamento_caixas_corrugadas_resumo);

    if (res_Jw_apontamento_caixas_corrugadas != null && res_Jw_apontamento_caixas_corrugadas.size() > 0) {
    } else {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      RelatorioApontamentoCaixasActionForm f = (RelatorioApontamentoCaixasActionForm) form;
      session.removeAttribute("res_Jw_apontamento_caixas_corrugadas");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_apontamento_caixas_corrugadas", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
