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
 * Creation Date 09/02/2016 15:11:00
 * Last Modify Date 10/01/2018 13:35:45
 */

public class ControleClientesEspeciaisExportacaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ControleClientesEspeciaisExportacaoActionForm f = (ControleClientesEspeciaisExportacaoActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/ControleClientesEspeciaisExportacao_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
    String tipo = tipoent.getTipo() + "";
    ControleClientesEspeciaisExportacaoActionForm f = (ControleClientesEspeciaisExportacaoActionForm) form;

    if ((f.getNumero_fatura().equals("") || f.getAno_fatura().equals("") || f.getEmpresa_fatura().equals("")) && (f.getDt_entrada_fatura_ini().equals("") || f.getDt_entrada_fatura_fim().equals("")) && (f.getDt_previsao_fat_ini().equals("") || f.getDt_previsao_fat_fim().equals("")) && (f.getDt_faturamento_ini().equals("") || f.getDt_faturamento_fim().equals("")) && (f.getDt_previsao_emb_ini().equals("") || f.getDt_previsao_emb_fim().equals("")) && (f.getDt_embarque_ini().equals("") || f.getDt_embarque_fim().equals("")) && (f.getDt_entrada_deposito_ini().equals("") || f.getDt_entrada_deposito_fim().equals(""))) {
      throw new Exception("Informe ao menos um dos períodos ou o número, o ano e a empresa da fatura desejada.");
    }

    if (f.getDt_entrada_fatura_ini() != "" && f.getDt_entrada_fatura_fim() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_entrada_fatura_ini(), f.getDt_entrada_fatura_fim()) > 12) {
        throw new Exception("O período não pode ser superior a 12 meses.");
      }
    }
    if (f.getDt_previsao_fat_ini() != "" && f.getDt_previsao_fat_fim() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_previsao_fat_ini(), f.getDt_previsao_fat_fim()) > 12) {
        throw new Exception("O período não pode ser superior a 12 meses.");
      }
    }
    if (f.getDt_faturamento_ini() != "" && f.getDt_faturamento_fim() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_faturamento_ini(), f.getDt_faturamento_fim()) > 12) {
        throw new Exception("O período não pode ser superior a 12 meses.");
      }
    }
    if (f.getDt_previsao_emb_ini() != "" && f.getDt_previsao_emb_fim() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_previsao_emb_ini(), f.getDt_previsao_emb_fim()) > 12) {
        throw new Exception("O período não pode ser superior a 12 meses.");
      }
    }
    if (f.getDt_embarque_ini() != "" && f.getDt_embarque_fim() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_embarque_ini(), f.getDt_embarque_fim()) > 12) {
        throw new Exception("O período não pode ser superior a 12 meses.");
      }
    }
    if (f.getDt_entrada_deposito_ini() != "" && f.getDt_entrada_deposito_fim() != "") {
      com.beirario.brportal.util.DateUtil dateUtil = new com.beirario.brportal.util.DateUtil();
      if (dateUtil.diferencaMeses(f.getDt_entrada_deposito_ini(), f.getDt_entrada_deposito_fim()) > 12) {
        throw new Exception("O período não pode ser superior a 12 meses.");
      }
    }

    StringBuilder parametros = new StringBuilder();
    StringBuilder parametrosOut = new StringBuilder();
    StringBuilder sb = new StringBuilder();
    StringBuilder sbf = new StringBuilder();

    Jw_controle_clientes_especiais_exportacao table = new Jw_controle_clientes_especiais_exportacao();
    Jw_controle_clientes_especiais_exportacao_filiais table_filiais = new Jw_controle_clientes_especiais_exportacao_filiais();

    if (f.getNumero_fatura() != "") {
      parametros.append(" AND fp.numero_fatura_proforma = "+f.getNumero_fatura());
    }

    if (f.getAno_fatura() != "") {
      parametros.append(" AND fp.ano_fatura_proforma = "+f.getAno_fatura());
    }

    if (f.getEmpresa_fatura() != "") {
      parametros.append(" AND fp.empresa_fatura_proforma = '"+f.getEmpresa_fatura() + "'");
    }

    if (f.getCli_cdgo() != "") {
      parametros.append(" AND fp.codigo_cliente = "+f.getCli_cdgo());
    }

    if (f.getEsc_seqn() != "") {
      parametros.append(" AND fp.estabelecimento_cliente = "+f.getEsc_seqn());
    }

    if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
      parametros.append(" AND fp.codigo_representante = '"+ent.getChave() + "'");
    } else {
      if (f.getRep_cdgo() != "") {
        parametros.append(" AND fp.codigo_representante = '"+f.getRep_cdgo() + "'");
      }
    }

    if (tipo.equals("REGIONAL DE VENDA")) {
      parametros.append(" AND fp.codigo_regional = "+ent.getChave());
    } else {
      if (f.getCodigo_regional() != "") {
        parametros.append(" AND fp.codigo_regional = "+f.getCodigo_regional());
      }
    }

    if (f.getFil_filial() != "") {
      parametros.append(" AND fct_retorna_fil_producao(i.ped_nmro,i.ite_seqn) = '"+f.getFil_filial() + "'");
    }

    if (f.getTra_cdgo() != "") {
      parametros.append(" AND fp.codigo_transportadora = " + f.getTra_cdgo());
    }

    if (f.getLinha() != "") {
      parametros.append(" AND i.lin_cdgo = " + f.getLinha());
    }

    if (f.getCodigo_marca() != "") {
      parametros.append(" AND pck_referencia.get_marca(i.lin_cdgo, i.ref_cdgo) = "+f.getCodigo_marca());
    }

    if (f.getEspecie_fatura() != "") {
      parametros.append(" AND fp.especie_fatura = "+f.getEspecie_fatura());
    }

    if (f.getDt_entrada_fatura_ini() != "") {
      parametros.append(" AND fp.data_fatura >= to_date('"+f.getDt_entrada_fatura_ini() + "', 'dd/mm/yyyy') ");
    }

    if (f.getDt_entrada_fatura_fim() != "") {
      parametros.append(" AND fp.data_fatura < to_date('"+f.getDt_entrada_fatura_fim() + "', 'dd/mm/yyyy')+1 ");
    }

    if (f.getDt_previsao_fat_ini() != "") {
      parametros.append(" AND NVL(p.ped_emba, fp.data_entrega) >= to_date('"+f.getDt_previsao_fat_ini() + "', 'dd/mm/yyyy') ");
    }

    if (f.getDt_previsao_fat_fim() != "") {
      parametros.append(" AND NVL(p.ped_emba, fp.data_entrega) < to_date('"+f.getDt_previsao_fat_fim() + "', 'dd/mm/yyyy')+1 ");
    }

    if (f.getDt_faturamento_ini() != "") {
      parametros.append(" AND fp.data_entrega >= to_date('"+f.getDt_faturamento_ini() + "', 'dd/mm/yyyy') ");
    }

    if (f.getDt_faturamento_fim() != "") {
      parametros.append(" AND fp.data_entrega < to_date('"+f.getDt_faturamento_fim() + "', 'dd/mm/yyyy')+1 ");
    }

    if (f.getDt_previsao_emb_ini() != "") {
      parametros.append(" AND fp.data_prev_embarque >= to_date('"+f.getDt_previsao_emb_ini() + "', 'dd/mm/yyyy') ");
    }

    if (f.getDt_previsao_emb_fim() != "") {
      parametros.append(" AND fp.data_prev_embarque < to_date('"+f.getDt_previsao_emb_fim() + "', 'dd/mm/yyyy')+1 ");
    }

    if (f.getDt_embarque_ini() != "" || f.getDt_embarque_fim() != "") {
      parametros.append(" AND EXISTS (SELECT MAX(de.data_embarque) ");
      parametros.append("      FROM dados_embarques_faturas def ");
      parametros.append("         ,dados_embarques de ");
      parametros.append("     WHERE def.numero_conhecimento_embarque = de.numero_conhecimento_embarque ");
      parametros.append("       AND def.data_conhecimento = de.data_conhecimento ");
      parametros.append("       AND def.empresa_fatura_comercial = fp.empresa_fatura_proforma ");
      parametros.append("       AND def.ano_fatura_comercial = fp.ano_fatura_proforma ");
      parametros.append("       AND def.numero_fatura_comercial = fp.numero_fatura_proforma ");
      parametros.append("    HAVING ");

      if (f.getDt_embarque_ini() != "") {
        parametros.append(" MAX(de.data_embarque) >= to_date('"+f.getDt_embarque_ini() + "', 'dd/mm/yyyy') ");
      }

      if (f.getDt_embarque_ini() != "" && f.getDt_embarque_fim() != "") {
        parametros.append(" AND ");
      }

      if (f.getDt_embarque_fim() != "") {
        parametros.append(" MAX(de.data_embarque) < to_date('"+f.getDt_embarque_fim() + "', 'dd/mm/yyyy')+1 ");
      }

      parametros.append(") ");
    }

    if (f.getDt_entrada_deposito_ini() != "" || f.getDt_entrada_deposito_fim() != "") {
      parametros.append(" AND EXISTS(SELECT MAX(TRUNC(lcp.data_inclusao)) ");
      parametros.append("          FROM exp.log_cargovision_processados lcp ");
      parametros.append("         WHERE lcp.ano = fp.ano_fatura_proforma ");
      parametros.append("           AND lcp.fatura = fp.numero_fatura_proforma ");
      parametros.append("   HAVING ");

      if (f.getDt_entrada_deposito_ini() != "") {
        parametros.append(" MAX(TRUNC(lcp.data_inclusao)) >= to_date('"+f.getDt_entrada_deposito_ini() + "', 'dd/mm/yyyy') ");
      }

      if (f.getDt_entrada_deposito_ini() != "" && f.getDt_entrada_deposito_fim() != "") {
        parametros.append(" AND ");
      }

      if (f.getDt_entrada_deposito_fim() != "") {
        parametros.append(" MAX(TRUNC(lcp.data_inclusao)) < to_date('"+f.getDt_entrada_deposito_fim() + "', 'dd/mm/yyyy')+1 ");
      }

      parametros.append(") ");
    }

    if (f.getCb_somente_deposito() != null) {
      if (f.getCb_somente_deposito().equals("1")) {
        parametrosOut.append(" AND data_deposito IS NOT NULL ");
        parametrosOut.append(" AND data_embarque IS NULL ");
      }
    }


    if (f.getCb_somente_embarcadas() != null) {
      if (f.getCb_somente_embarcadas().equals("1")) {
        parametrosOut.append(" AND data_embarque IS NOT NULL ");
      }
    }


    if (f.getPed_stat() != "") {

      if (!f.getPed_stat().equals("T")) {
        parametros.append(" AND EXISTS (SELECT 1 ");
        parametros.append("        FROM ped pp ");
        parametros.append("            ,ite ii ");
        parametros.append("       WHERE pp.ped_nmro = ii.ped_nmro ");
        parametros.append("         AND pp.ped_nmro = p.ped_nmro ");
      }

      if (f.getPed_stat().equals("B")) {
        parametros.append(" AND pp.ped_stat IN ('P','B')) ");
      }
      if (f.getPed_stat().equals("A")) {
        parametros.append(" AND pp.ped_stat IN ('A') ");
        parametros.append(" AND ii.ite_situ < 4) ");
      }
      if (f.getPed_stat().equals("P")) {
        parametros.append(" AND pp.ped_stat IN ('A') ");
        parametros.append(" AND ii.ite_situ IN (4)) ");
      }
      if (f.getPed_stat().equals("E")) {
        parametros.append(" AND pp.ped_stat IN ('A') ");
        parametros.append(" AND ii.ite_situ IN (5)) ");
        parametros.append(" AND NOT EXISTS (SELECT 1 ");
        parametros.append("        FROM ped ppp ");
        parametros.append("            ,ite iii ");
        parametros.append("       WHERE ppp.ped_nmro = iii.ped_nmro ");
        parametros.append("         AND ppp.ped_nmro = p.ped_nmro ");
        parametros.append("         AND ppp.ped_stat IN ('A') ");
        parametros.append("         AND iii.ite_situ IN <> 5) ");
      }
      if (f.getPed_stat().equals("L")) {
        parametros.append(" AND pp.ped_stat IN ('L')) ");
      }
      if (f.getPed_stat().equals("F")) {
        parametros.append(" AND pp.ped_stat IN ('F')) ");
      }
      if (f.getPed_stat().equals("T")) {
        parametros.append(" AND NOT EXISTS (SELECT 1 ");
        parametros.append("        FROM ite itei ");
        parametros.append("       WHERE itei.ped_nmro = qry.ped_nmro ");
        parametros.append("         AND NOT EXISTS (SELECT 1 ");
        parametros.append("                FROM (SELECT ri.ped_nmro ");
        parametros.append("                            ,ri.ite_seqn ");
        parametros.append("                        FROM requisicoes_ite ri ");
        parametros.append("                            ,notas_fiscais_saida_requis nr ");
        parametros.append("                            ,nf_saida ns ");
        parametros.append("                            ,naturezas_operacoes nat ");
        parametros.append("                       WHERE ri.reqnf_numero = nr.reqnf_numero ");
        parametros.append("                         AND nr.nfs_nmro = ns.nfs_nmro ");
        parametros.append("                         AND nr.nfs_serie = ns.nfs_serie ");
        parametros.append("                         AND nr.emp_empresa = ns.emp_empresa ");
        parametros.append("                         AND nr.fil_filial = ns.fil_filial ");
        parametros.append("                         AND ns.natoper_codigo = nat.codigo ");
        parametros.append("         AND ri.ped_nmro = itei.ped_nmro ");
        parametros.append("         AND ri.ite_seqn = itei.ite_seqn  ");
        parametros.append("                         AND NVL(nat.tipo_destinatario, NULL) = 'T' ");
        parametros.append("                         AND NVL(ns.stat_codigo, NULL) = 4 ");
        parametros.append("                      UNION ");
        parametros.append("                      SELECT ite.ped_nmro ");
        parametros.append("                            ,ite.ite_seqn ");
        parametros.append("                        FROM ped ");
        parametros.append("                            ,ite ");
        parametros.append("                            ,compromete_pedido cp ");
        parametros.append("                            ,dom_local_estoque dl ");
        parametros.append("                       WHERE ped.ped_nmro = ite.ped_nmro ");
        parametros.append("                         AND ite.ped_nmro = cp.ped_nmro ");
        parametros.append("                         AND ite.ite_seqn = cp.ite_seqn ");
        parametros.append("                         AND cp.les_codigo = dl.codigo ");
        parametros.append("         AND ite.ped_nmro = itei.ped_nmro ");
        parametros.append("         AND ite.ite_seqn = itei.ite_seqn ");
        parametros.append("                         AND NVL(dl.fil_filial, NULL) = '17' ");
        parametros.append("                         AND NVL(ite.ite_situ, NULL) >= 5))) ");
      }

    }

    sb.append(" SELECT data_entrega_fatura ");
    sb.append("       ,numero_fatura_proforma ");
    sb.append("       ,ano_fatura_proforma ");
    sb.append("       ,TO_CHAR(data_fatura, 'dd/mm/yyyy') data_fatura ");
    sb.append("       ,TO_CHAR(data_prev_faturamento, 'dd/mm/yyyy') data_prev_faturamento ");
    sb.append("       ,TO_CHAR(data_prev_embarque, 'dd/mm/yyyy') data_prev_embarque ");
    sb.append("       ,TO_CHAR(data_deposito, 'dd/mm/yyyy') data_deposito ");
    sb.append("       ,TO_CHAR(data_embarque, 'dd/mm/yyyy') data_embarque ");
    sb.append("       ,dias_deposito ");
    sb.append("       ,codigo_cliente ");
    sb.append("       ,estabelecimento_cliente ");
    sb.append("       ,razao_cliente ");
    sb.append("       ,codigo_representante ");
    sb.append("       ,razao_representante ");
    sb.append("       ,codigo_transportadora ");
    sb.append("       ,razao_transportadora ");
    sb.append("       ,pais ");
    sb.append("       ,SUM(pares) pares ");
    sb.append("       ,SUM(valor) valor ");
    sb.append("       ,'' etiquetas ");
    sb.append("       ,'' dt_rec_etiqueta_filial ");
    sb.append("       ,codigo_regional ");
    sb.append("       ,nome_regional ");
    sb.append("       ,especie_fatura ");
    sb.append("       ,descricao_especie_fatura ");
    sb.append("       ,status_fatura ");
    sb.append("       ,descricao_status_fatura ");
    sb.append("       ,obs_fatura ");
    sb.append("       ,'' dt_inspecao ");
    sb.append("       ,'' data_embarque_cargovision ");
    sb.append("   FROM (SELECT fp.data_entrega data_entrega_fatura ");
    sb.append("               ,fp.numero_fatura_proforma ");
    sb.append("               ,fp.ano_fatura_proforma ");
    sb.append("               ,fp.data_fatura ");
    sb.append("               ,NVL(p.ped_emba, fp.data_entrega) data_prev_faturamento ");
    sb.append("               ,fp.data_prev_embarque ");
    sb.append("               ,TRUNC(lcp.data_inclusao) data_deposito ");
    sb.append("               ,(SELECT MAX(de.data_embarque) ");
    sb.append("                   FROM dados_embarques_faturas def ");
    sb.append("                       ,dados_embarques de ");
    sb.append("                  WHERE def.numero_conhecimento_embarque = de.numero_conhecimento_embarque ");
    sb.append("                    AND def.data_conhecimento = de.data_conhecimento ");
    sb.append("                    AND def.empresa_fatura_comercial = fp.empresa_fatura_proforma ");
    sb.append("                    AND def.ano_fatura_comercial = fp.ano_fatura_proforma ");
    sb.append("                    AND def.numero_fatura_comercial = fp.numero_fatura_proforma) data_embarque ");
    sb.append("               ,NVL((SELECT MAX(de.data_embarque) ");
    sb.append("                      FROM dados_embarques_faturas def ");
    sb.append("                          ,dados_embarques de ");
    sb.append("                     WHERE def.numero_conhecimento_embarque = de.numero_conhecimento_embarque ");
    sb.append("                       AND def.data_conhecimento = de.data_conhecimento ");
    sb.append("                       AND def.empresa_fatura_comercial = fp.empresa_fatura_proforma ");
    sb.append("                       AND def.ano_fatura_comercial = fp.ano_fatura_proforma ");
    sb.append("                       AND def.numero_fatura_comercial = fp.numero_fatura_proforma), TRUNC(SYSDATE)) - TRUNC(lcp.data_inclusao) dias_deposito ");
    sb.append("               ,fp.codigo_cliente ");
    sb.append("               ,fp.estabelecimento_cliente ");
    sb.append("               ,c.cli_rzao razao_cliente ");
    sb.append("               ,fp.codigo_representante ");
    sb.append("               ,r.rep_rzao razao_representante ");
    sb.append("               ,fp.codigo_transportadora ");
    sb.append("               ,t.tra_rzao razao_transportadora ");
    sb.append("               ,pck_pais.get_nome(pck_estados.get_pais(e.est_unifed)) pais ");
    sb.append("               ,ifp.quantidade_pares pares ");
    sb.append("               ,ifp.valor_total_item valor ");
    sb.append("               ,r.codigo_regional ");
    sb.append("               ,rv.nome_regional ");
    sb.append("               ,fp.especie_fatura ");
    sb.append("               ,(SELECT rv_meaning ");
    sb.append("                   FROM cg_ref_codes ");
    sb.append("                  WHERE rv_domain = 'ESPECIE_DM' ");
    sb.append("                    AND rv_low_value = fp.especie_fatura) descricao_especie_fatura ");
    sb.append("               ,fp.status_fatura ");
    sb.append("               ,(SELECT rv_meaning ");
    sb.append("                   FROM cg_ref_codes ");
    sb.append("                  WHERE rv_domain = 'STATUS_FATURA_DM' ");
    sb.append("                    AND rv_low_value = fp.status_fatura ");
    sb.append("                    AND ROWNUM = 1) descricao_status_fatura ");
    sb.append("               ,fp.obs_fatura ");
    sb.append("           FROM faturas_proformas fp ");
    sb.append("               ,itens_faturas_proformas ifp ");
    sb.append("               ,ite i ");
    sb.append("               ,ped p ");
    sb.append("               ,rep r ");
    sb.append("               ,tra t ");
    sb.append("               ,regionais_vendas rv ");
    sb.append("               ,cli c ");
    sb.append("               ,esc e ");
    sb.append("               ,exp.log_cargovision_processados lcp ");
    sb.append("          WHERE ifp.empresa_fatura_proforma = i.empresa_fatura_proforma ");
    sb.append("            AND ifp.ano_fatura_proforma = i.ano_fatura_proforma ");
    sb.append("            AND ifp.numero_fatura_proforma = i.numero_fatura_proforma ");
    sb.append("            AND ifp.numero_item = i.numero_item_fatura_proforma ");
    sb.append("            AND fp.empresa_fatura_proforma = ifp.empresa_fatura_proforma ");
    sb.append("            AND fp.ano_fatura_proforma = ifp.ano_fatura_proforma ");
    sb.append("            AND fp.numero_fatura_proforma = ifp.numero_fatura_proforma ");
    sb.append("            AND lcp.empresa_fatura_proforma(+) = fp.empresa_fatura_proforma ");
    sb.append("            AND lcp.ano(+) = fp.ano_fatura_proforma ");
    sb.append("            AND lcp.fatura(+) = fp.numero_fatura_proforma ");
    sb.append("            AND NVL(lcp.data_inclusao, TRUNC(SYSDATE)) = NVL((SELECT MAX(l.data_inclusao) ");
    sb.append("                                                               FROM exp.log_cargovision_processados l ");
    sb.append("                                                              WHERE l.empresa_fatura_proforma = fp.empresa_fatura_proforma ");
    sb.append("                                                                AND l.ano = fp.ano_fatura_proforma ");
    sb.append("                                                                AND l.fatura = fp.numero_fatura_proforma), TRUNC(SYSDATE)) ");
    sb.append("            AND fp.codigo_representante = r.rep_cdgo ");
    sb.append("            AND fp.codigo_transportadora = t.tra_cdgo ");
    sb.append("            AND rv.codigo_regional = r.codigo_regional ");
    sb.append("            AND c.cli_cdgo = fp.codigo_cliente ");
    sb.append("            AND e.cli_cdgo = fp.codigo_cliente ");
    sb.append("            AND e.esc_seqn = fp.estabelecimento_cliente ");
    sb.append("            AND p.ped_nmro = i.ped_nmro ");
    sb.append(parametros.toString());
    sb.append("            ) qry ");
    sb.append("     WHERE 1=1 ");
    sb.append(parametrosOut.toString());
    sb.append("  GROUP BY data_entrega_fatura ");
    sb.append("          ,numero_fatura_proforma ");
    sb.append("          ,ano_fatura_proforma ");
    sb.append("          ,data_fatura ");
    sb.append("          ,data_prev_faturamento ");
    sb.append("          ,data_prev_embarque ");
    sb.append("          ,data_deposito ");
    sb.append("          ,data_embarque ");
    sb.append("          ,dias_deposito ");
    sb.append("          ,codigo_cliente ");
    sb.append("          ,estabelecimento_cliente ");
    sb.append("          ,razao_cliente ");
    sb.append("          ,codigo_representante ");
    sb.append("          ,razao_representante ");
    sb.append("          ,codigo_transportadora ");
    sb.append("          ,razao_transportadora ");
    sb.append("          ,pais ");
    sb.append("          ,codigo_regional ");
    sb.append("          ,nome_regional ");
    sb.append("          ,especie_fatura ");
    sb.append("          ,descricao_especie_fatura ");
    sb.append("          ,status_fatura ");
    sb.append("          ,descricao_status_fatura ");
    sb.append("          ,obs_fatura ");

    sbf.append(" SELECT DISTINCT fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) filial ");
    sbf.append("   FROM faturas_proformas       fp ");
    sbf.append("      , itens_faturas_proformas ifp ");
    sbf.append("      , ite                     i ");
    sbf.append("      , ped                     p ");
    sbf.append("      , rep                     r ");
    sbf.append("      , cli                     c ");
    sbf.append("      , esc                     e ");
    sbf.append("  WHERE fp.empresa_fatura_proforma = i.empresa_fatura_proforma ");
    sbf.append("    AND fp.ano_fatura_proforma = i.ano_fatura_proforma ");
    sbf.append("    AND fp.numero_fatura_proforma = i.numero_fatura_proforma ");
    sbf.append("    AND fp.empresa_fatura_proforma = ifp.empresa_fatura_proforma ");
    sbf.append("    AND fp.ano_fatura_proforma = ifp.ano_fatura_proforma ");
    sbf.append("    AND fp.numero_fatura_proforma = ifp.numero_fatura_proforma ");
    sbf.append("    AND ifp.item_cancelado = 'N' ");
    sbf.append("    AND p.rep_cdgo = r.rep_cdgo ");
    sbf.append("    AND c.cli_cdgo = fp.codigo_cliente ");
    sbf.append("    AND e.cli_cdgo = fp.codigo_cliente ");
    sbf.append("    AND e.esc_seqn = fp.estabelecimento_cliente ");
    sbf.append("    AND p.ped_nmro = i.ped_nmro ");
    sbf.append("    AND i.numero_item_fatura_proforma = ifp.numero_item ");
    sbf.append(parametros.toString());
    sbf.append("  ORDER BY TO_NUMBER(DECODE(filial, 'MT', 1, 3, 3, 6, 6, 8, 8, 9, 9, 10, 10, 12, 12, 15, 15, 16, 16, 18, 18, 17, 17, 29, 29, 30, 30, 20, 20, 0)) ");
    //------------------------------------------
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }
    //------------------------------------------

    Vector res_Jw_controle_clientes_especiais_exportacao = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_controle_clientes_especiais_exportacao",res_Jw_controle_clientes_especiais_exportacao);
    if (res_Jw_controle_clientes_especiais_exportacao != null && res_Jw_controle_clientes_especiais_exportacao.size() > 0) {
      util.consultas.com.ControleClientesEspeciaisExportacao controle = new util.consultas.com.ControleClientesEspeciaisExportacao(j);
      Jw_controle_clientes_especiais_exportacao r = (Jw_controle_clientes_especiais_exportacao) res_Jw_controle_clientes_especiais_exportacao.elementAt(0);
      int i_bl_report_Jw_controle_clientes_especiais_exportacao = 0;
      while (i_bl_report_Jw_controle_clientes_especiais_exportacao < res_Jw_controle_clientes_especiais_exportacao.size()) {
        portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao t_jw_controle_clientes_especiais_exportacao = (portalbr.dbobj.view.Jw_controle_clientes_especiais_exportacao) res_Jw_controle_clientes_especiais_exportacao.elementAt(i_bl_report_Jw_controle_clientes_especiais_exportacao);
        controle.setEmpresaFatura("01");
        controle.setAnoFatura(t_jw_controle_clientes_especiais_exportacao.getAno_fatura_proforma() + "");
        controle.setNumeroFatura(t_jw_controle_clientes_especiais_exportacao.getNumero_fatura_proforma() + "");
        controle.buscarDadosFatura();
        t_jw_controle_clientes_especiais_exportacao.setEtiquetas(controle.getEtiquetas());
        t_jw_controle_clientes_especiais_exportacao.setDt_rec_etiqueta_filial(controle.getDtRecEtiquetaFilial());
        t_jw_controle_clientes_especiais_exportacao.setDt_entrega_etiqueta(controle.getDtEntregaEtiqueta());
        t_jw_controle_clientes_especiais_exportacao.setFiliais(controle.getListaFaturaFilialStatus());
        t_jw_controle_clientes_especiais_exportacao.setDt_inspecao(controle.getDtInspecao());
        t_jw_controle_clientes_especiais_exportacao.setData_embarque_cargovision(controle.getDataEmbarqueCargovision());
        i_bl_report_Jw_controle_clientes_especiais_exportacao++;
      }

    } else {
      throw new Exception("Nenhum registro encontrado!");
    }

    session.removeAttribute("cb_data_entrega_fatura");
    session.removeAttribute("cb_numero_fatura_proforma");
    session.removeAttribute("cb_especie_fatura");
    session.removeAttribute("cb_status_fatura");
    session.removeAttribute("cb_cliente");
    session.removeAttribute("cb_regional");
    session.removeAttribute("cb_representante");
    session.removeAttribute("cb_transportadora");
    session.removeAttribute("cb_pais");
    session.removeAttribute("cb_pares");
    session.removeAttribute("cb_valor");
    session.removeAttribute("cb_data_entrada_fatura");
    session.removeAttribute("cb_dt_prev_fat");
    session.removeAttribute("cb_dt_prev_emb");
    session.removeAttribute("cb_dt_entrada_deposito");
    session.removeAttribute("cb_data_embarque");
    session.removeAttribute("cb_dias_deposito");
    session.removeAttribute("cb_etiquetas");
    session.removeAttribute("cb_dt_entrega_etiqueta");
    session.removeAttribute("cb_dt_rec_etiqueta_fil");
    session.removeAttribute("cb_dt_inspecao");
    session.removeAttribute("cb_dt_emb_cargovision");
    session.removeAttribute("cb_obs_fatura");

    if ((f.getCb_data_entrega_fatura() + "").equals("1")) {
      session.setAttribute("cb_data_entrega_fatura", true);
    }
    if ((f.getCb_numero_fatura_proforma() + "").equals("1")) {
      session.setAttribute("cb_numero_fatura_proforma", true);
    }
    if ((f.getCb_especie_fatura() + "").equals("1")) {
      session.setAttribute("cb_especie_fatura", true);
    }
    if ((f.getCb_status_fatura() + "").equals("1")) {
      session.setAttribute("cb_status_fatura", true);
    }
    if ((f.getCb_cliente() + "").equals("1")) {
      session.setAttribute("cb_cliente", true);
    }
    if ((f.getCb_regional() + "").equals("1")) {
      session.setAttribute("cb_regional", true);
    }
    if ((f.getCb_representante() + "").equals("1")) {
      session.setAttribute("cb_representante", true);
    }
    if ((f.getCb_transportadora() + "").equals("1")) {
      session.setAttribute("cb_transportadora", true);
    }
    if ((f.getCb_pais() + "").equals("1")) {
      session.setAttribute("cb_pais", true);
    }
    if ((f.getCb_pares() + "").equals("1")) {
      session.setAttribute("cb_pares", true);
    }
    if ((f.getCb_valor() + "").equals("1")) {
      session.setAttribute("cb_valor", true);
    }
    if ((f.getCb_data_entrada_fatura() + "").equals("1")) {
      session.setAttribute("cb_data_entrada_fatura", true);
    }
    if ((f.getCb_dt_prev_fat() + "").equals("1")) {
      session.setAttribute("cb_dt_prev_fat", true);
    }
    if ((f.getCb_dt_prev_emb() + "").equals("1")) {
      session.setAttribute("cb_dt_prev_emb", true);
    }
    if ((f.getCb_dt_entrada_deposito() + "").equals("1")) {
      session.setAttribute("cb_dt_entrada_deposito", true);
    }
    if ((f.getCb_data_embarque() + "").equals("1")) {
      session.setAttribute("cb_data_embarque", true);
    }
    if ((f.getCb_dias_deposito() + "").equals("1")) {
      session.setAttribute("cb_dias_deposito", true);
    }
    if ((f.getCb_etiquetas() + "").equals("1")) {
      session.setAttribute("cb_etiquetas", true);
    }
    if ((f.getCb_dt_entrega_etiqueta() + "").equals("1")) {
      session.setAttribute("cb_dt_entrega_etiqueta", true);
    }
    if ((f.getCb_dt_rec_etiqueta_fil() + "").equals("1")) {
      session.setAttribute("cb_dt_rec_etiqueta_fil", true);
    }
    if ((f.getCb_dt_inspecao() + "").equals("1")) {
      session.setAttribute("cb_dt_inspecao", true);
    }
    if ((f.getCb_dt_emb_cargovision() + "").equals("1")) {
      session.setAttribute("cb_dt_emb_cargovision", true);
    }
    if ((f.getCb_obs_fatura() + "").equals("1")) {
      session.setAttribute("cb_obs_fatura", true);
    }


    Vector res_Jw_controle_clientes_especiais_exportacao_filiais = j.select(table_filiais, sbf.toString(), null);
    session.setAttribute("res_Jw_controle_clientes_especiais_exportacao_filiais",res_Jw_controle_clientes_especiais_exportacao_filiais);
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ControleClientesEspeciaisExportacaoActionForm f = (ControleClientesEspeciaisExportacaoActionForm) form;
      tg_resetfull_action(mapping, form, request, response);
      session.removeAttribute("res_Controle_clientes_especiais_vw");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      ControleClientesEspeciaisExportacaoActionForm f = (ControleClientesEspeciaisExportacaoActionForm) form;
      session.removeAttribute("listaSituacoes");
      session.removeAttribute("listaEspecies");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ControleClientesEspeciaisExportacaoActionForm f = (ControleClientesEspeciaisExportacaoActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Controle_clientes_especiais_vw", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
