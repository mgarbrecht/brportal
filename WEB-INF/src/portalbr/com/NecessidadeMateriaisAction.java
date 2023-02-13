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
 * Creation Date 19/03/2015 08:13:35
 * Last Modify Date 18/03/2019 08:56:52
 */

public class NecessidadeMateriaisAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      NecessidadeMateriaisActionForm f = (NecessidadeMateriaisActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/NecessidadeMateriais_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_necessidade_materiais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    session.removeAttribute("res_Jw_necessidade_materiais_faturas");
    session.removeAttribute("res_Jw_necessidade_materiais");
    session.removeAttribute("res_Jw_necessidade_materiais_pp");
    NecessidadeMateriaisActionForm f = (NecessidadeMateriaisActionForm) form;
    Jw_necessidade_materiais table = new Jw_necessidade_materiais();
    Jw_necessidade_materiais_faturas tablef = new Jw_necessidade_materiais_faturas();
    Jw_necessidade_materiais_pp tablepp = new Jw_necessidade_materiais_pp();
    boolean informouFatura = false;
    boolean informouPeriodo = false;
    boolean informouPeriodoImportacao = false;
    String[][] select = null;
    String abreFilial = "N";
    String gruposMateriais = null;

    if (f.getDt_inicial_importacao() != "") {
      informouPeriodoImportacao = true;
    }
    if (f.getDt_final_importacao() != "") {
      informouPeriodoImportacao = true;
    }

    if (f.getFil_filial() != "") {
      abreFilial = "S";
    }
    if (f.getNumero_fatura() != "" && f.getAno_fatura() != "" && f.getEmp_empresa() != "") {
      informouFatura = true;
    }

    if (!informouFatura) {
      if (f.getDt_inicial() != "" && f.getDt_final() != "") {
        informouPeriodo = true;
      }
    }

    if (!informouFatura && !informouPeriodo) {
      throw new Exception("A fatura ou o período devem ser informados!");
    }

    if (session.getAttribute("codigos_grupos_selecionados") != null) {
      gruposMateriais = " AND fct_grupo_material(d.codigo) IN ("+(String) session.getAttribute("codigos_grupos_selecionados") + ") ";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT qry.ies_codigo ");
    sb.append("      , pck_item_estoque.get_nome(qry.ies_codigo) descricao ");
    sb.append("      , qry.cor_cdgo ");
    sb.append("      , pck_cor.get_nome(qry.cor_cdgo) cor_desc ");
    sb.append("      , qry.tai_codigo ");
    sb.append("      , qry.fil_filial ");
    sb.append("      , qry.ped_invoice ");
    sb.append("      , SUM(qry.consumo) consumo ");
    sb.append("      , qry.unm_codigo ");
    sb.append("      , qry.ncm ");
    sb.append("      , dio.oco_numero ");
    sb.append("      , dio.preco_unitario ");
    sb.append("      , dneo.nfe_numero ");
    sb.append("      , dneo.nfe_serie ");
    sb.append("      , dneo.edo_empresa ");
    sb.append("      , pck_fornecedor.get_nome(dneo.edo_empresa) fornecedor ");
    sb.append("  FROM (SELECT ped.ped_nmro ");
    sb.append("              ,ped.emp_empresa ");
    sb.append("              ,CASE ");
    sb.append("                  WHEN '"+abreFilial + "' = 'N' THEN ");
    sb.append("                  NULL ");
    sb.append("                 ELSE ");
    sb.append("                  fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) ");
    sb.append("               END fil_filial ");
    sb.append("              ,CASE ");
    sb.append("                  WHEN '"+f.getAbrir_fatura() + "' = 'N' THEN ");
    sb.append("                  NULL ");
    sb.append("                 ELSE ");
    sb.append("                  ped.ped_invoice ");
    sb.append("               END ped_invoice ");
    sb.append("              ,c.set_cdgo ");
    sb.append("              ,p.codigo cod_peca ");
    sb.append("              ,p.descricao desc_peca ");
    sb.append("              ,fct_grupo_material(DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro)) gpo_material ");
    sb.append("              ,i.lin_cdgo ");
    sb.append("              ,i.ref_cdgo ");
    sb.append("              ,NVL(DECODE(d.cor, 'S', cc.cor_mater), 0) cor_cdgo ");
    sb.append("              ,CASE ");
    sb.append("                 WHEN (NVL(d.tamanho, 'N') = 'S') THEN ");
    sb.append("                  fct_converte_tamanho(DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro), q.qtp_nume) ");
    sb.append("                 ELSE ");
    sb.append("                  '0' ");
    sb.append("               END AS tai_codigo ");
    sb.append("              ,p.cmp_cdgo ");
    sb.append("              ,DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro) ies_codigo ");
    sb.append("              ,'PE' origem ");
    sb.append("              ,SUM((i.ite_qtde / ");
    sb.append("                   (SELECT SUM(q1.qtp_pars) ");
    sb.append("                       FROM qtd_prg q1 ");
    sb.append("                      WHERE q1.ped_nmro = i.ped_nmro ");
    sb.append("                        AND q1.ite_seqn = i.ite_seqn) * q.qtp_pars) * ");
    sb.append("                   c.com_consum) AS consumo ");
    sb.append("              ,SUM(CASE ");
    sb.append("                     WHEN (p.cmp_cdgo = 49) THEN ");
    sb.append("                      (1.37 / p.conver * (.97 * (q.qtp_pars * c.com_consum))) / ");
    sb.append("                      DECODE(d.unm_codigo, 'M2', 1.37, 1) ");
    sb.append("                     ELSE ");
    sb.append("                      NULL ");
    sb.append("                   END) comprimento ");
    sb.append("              ,d.unm_codigo ");
    sb.append("              ,pck_item_estoque.get_classificacao_fiscal(DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro)) ncm ");
    sb.append("          FROM ped ");
    sb.append("              ,ite              i ");
    sb.append("              ,qtd_prg          q ");
    sb.append("              ,ficha_tec        f ");
    sb.append("              ,componente       c ");
    sb.append("              ,cor_compo        cc ");
    sb.append("              ,dom_item_estoque d ");
    sb.append("              ,pecas            p ");
    sb.append("         WHERE q.ped_nmro = i.ped_nmro ");
    sb.append("           AND q.ite_seqn = i.ite_seqn ");
    sb.append("           AND q.qtp_pars > 0 ");
    sb.append("           AND i.ped_nmro = ped.ped_nmro ");
    sb.append("           AND f.lin_cdgo = NVL(i.lin_cdgo, NULL) ");
    sb.append("           AND f.ref_cdgo = NVL(i.ref_cdgo, NULL) ");
    sb.append("           AND f.cab_cdgo = NVL(i.cab_cdgo, NULL) ");
    sb.append("           AND f.fit_versao = fct_ficha_versao(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, ped.emp_empresa, fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn)) ");
    sb.append("           AND f.emp_empresa = NVL(ped.emp_empresa, f.emp_empresa) ");
    sb.append("           AND c.lin_cdgo = f.lin_cdgo ");
    sb.append("           AND c.ref_cdgo = f.ref_cdgo ");
    sb.append("           AND c.cab_cdgo = f.cab_cdgo ");
    sb.append("           AND c.com_destin = 'I' ");
    sb.append("           AND c.fit_versao = f.fit_versao ");
    sb.append("           AND d.codigo = c.mat_nro ");
    sb.append("           AND cc.lin_cdgo(+) = c.lin_cdgo ");
    sb.append("           AND cc.ref_cdgo(+) = c.ref_cdgo ");
    sb.append("           AND cc.cab_cdgo(+) = c.cab_cdgo ");
    sb.append("           AND ((NVL(d.cor, 'N') = 'N' AND cc.cor_ref IS NULL) OR (cc.cor_ref = i.cor_cdgo)) ");
    sb.append("           AND cc.com_seq(+) = c.com_seq ");
    sb.append("           AND cc.com_nivel(+) = c.com_nivel ");
    sb.append("           AND cc.fit_versao(+) = c.fit_versao ");
    sb.append("           AND ((NVL(d.tamanho, 'N') = 'N') OR (EXISTS (SELECT NULL ");
    sb.append("                                                          FROM dom_tamanho_item_corresponde t ");
    sb.append("                                                         WHERE t.ies_codigo = DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro) ");
    sb.append("                                                           AND NVL(t.tai_codigo2, NULL) = q.qtp_nume))) ");
    sb.append("           AND p.codigo = c.cod_peca ");
    if (informouFatura) {
      sb.append("        AND ped.ped_invoice  = lpad('"+f.getNumero_fatura() + "',4,0)||'/'||'"+f.getAno_fatura() + "' ");
      sb.append("        AND nvl(ped.emp_empresa,NULL) = '"+f.getEmp_empresa() + "' ");
    }
    if (informouPeriodo) {
      sb.append("        AND ped.ped_dadg >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
      sb.append("        AND ped.ped_dadg < TO_date('"+f.getDt_final() + "','dd/mm/yyyy')+1 ");
    }
    sb.append("           AND NVL(ped.ped_tipo, NULL) = 'EX' ");
    sb.append("           AND NVL(ped.ped_stat, NULL) <> 'C' ");

    sb.append("           AND NVL(ped.ped_especie_pedido, NULL) <> 'R' ");
    sb.append("           AND pck_pedidos.get_origem_pedido(ped.ped_nmro) <> 'ESTRATEGICO' ");

    if (gruposMateriais != null) {
      sb.append(gruposMateriais);
    }
    if (abreFilial.equals("S")) {
      sb.append("         AND nvl(fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn),null) = '"+f.getFil_filial() + "' ");
    }
    sb.append("         GROUP BY ped.ped_nmro ");
    sb.append("                 ,ped.emp_empresa ");
    sb.append("                 ,c.set_cdgo ");
    sb.append("                 ,p.codigo ");
    sb.append("                 ,p.descricao ");
    sb.append("                 ,fct_grupo_material(DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro)) ");
    sb.append("                 ,i.lin_cdgo ");
    sb.append("                 ,i.ref_cdgo ");
    sb.append("                 ,DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro) ");
    sb.append("                 ,NVL(DECODE(d.cor, 'S', cc.cor_mater), 0) ");
    sb.append("                 ,CASE ");
    sb.append("                    WHEN (NVL(d.tamanho, 'N') = 'S') THEN ");
    sb.append("                     fct_converte_tamanho(DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro), q.qtp_nume) ");
    sb.append("                    ELSE ");
    sb.append("                     '0' ");
    sb.append("                  END ");
    sb.append("                 ,p.cmp_cdgo ");
    sb.append("                 ,CASE ");
    sb.append("                     WHEN '"+abreFilial + "' = 'N' THEN ");
    sb.append("                      NULL ");
    sb.append("                     ELSE ");
    sb.append("                      fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) ");
    sb.append("                   END ");
    sb.append("                  ,CASE ");
    sb.append("                     WHEN '"+f.getAbrir_fatura() + "' = 'N' THEN ");
    sb.append("                      NULL ");
    sb.append("                     ELSE ");
    sb.append("                      ped.ped_invoice ");
    sb.append("                   END ");
    sb.append("                 , d.unm_codigo ");
    sb.append("                 ,PCK_ITEM_ESTOQUE.GET_CLASSIFICACAO_FISCAL(DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro)) ");
    sb.append("        UNION ALL ");
    sb.append("        SELECT p.ped_nmro ");
    sb.append("              ,p.emp_empresa ");
    sb.append("              ,CASE ");
    sb.append("                  WHEN '"+abreFilial + "' = 'N' THEN ");
    sb.append("                  NULL ");
    sb.append("                 ELSE ");
    sb.append("                  fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) ");
    sb.append("               END fil_filial ");
    sb.append("              ,CASE ");
    sb.append("                  WHEN '"+f.getAbrir_fatura() + "' = 'N' THEN ");
    sb.append("                  NULL ");
    sb.append("                 ELSE ");
    sb.append("                  p.ped_invoice ");
    sb.append("               END ped_invoice ");
    sb.append("              ,'EXPED' set_cdgo ");
    sb.append("              ,105 cod_peca ");
    sb.append("              ,'CORRUGADO' desc_peca ");
    sb.append("              ,2 grupo_material ");
    sb.append("              ,i.lin_cdgo ");
    sb.append("              ,i.ref_cdgo ");
    sb.append("              ,0 AS cor_cdgo ");
    sb.append("              ,'0' tai_codigo ");
    sb.append("              ,46 AS cmp_cdgo ");
    sb.append("              ,d.codigo ies_codigo ");
    sb.append("              ,'PE' origem ");
    sb.append("              ,SUM(fct_calcula_volumes_ped(p.ped_nmro, i.ite_seqn)) consumo ");
    sb.append("              ,SUM(NULL) comprimento ");
    sb.append("              ,d.unm_codigo ");
    sb.append("              ,NULL ncm ");
    sb.append("          FROM ped              p ");
    sb.append("              ,ite              i ");
    sb.append("              ,dom_item_estoque d ");
    sb.append("         WHERE p.ped_nmro = i.ped_nmro ");
    sb.append("           AND d.codigo = fct_corrugado(i.lin_cdgo, i.ref_cdgo, p.ped_tipo_corrugado, i.codigo_corrugado) ");
    if (informouFatura) {
      sb.append("        AND p.ped_invoice  = lpad('"+f.getNumero_fatura() + "',4,0)||'/'||'"+f.getAno_fatura() + "' ");
      sb.append("        AND nvl(p.emp_empresa,NULL) = '"+f.getEmp_empresa() + "' ");
    }
    if (informouPeriodo) {
      sb.append("        AND p.ped_dadg >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
      sb.append("        AND p.ped_dadg < TO_date('"+f.getDt_final() + "','dd/mm/yyyy')+1 ");
    }
    sb.append("           AND NVL(p.ped_tipo, NULL) = 'EX' ");
    sb.append("           AND NVL(p.ped_stat, NULL) <> 'C' ");
    sb.append("           AND NVL(p.ped_especie_pedido, NULL) <> 'R' ");
    sb.append("           AND pck_pedidos.get_origem_pedido(p.ped_nmro) <> 'ESTRATEGICO' ");
    if (gruposMateriais != null) {
      sb.append(gruposMateriais);
    }
    if (abreFilial.equals("S")) {
      sb.append("        AND nvl(fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn),null) = '"+f.getFil_filial() + "' ");
    }
    sb.append("         GROUP BY p.ped_nmro ");
    sb.append("                 ,p.emp_empresa ");
    sb.append("                 ,i.lin_cdgo ");
    sb.append("                 ,i.ref_cdgo ");
    sb.append("                 ,d.codigo ");
    sb.append("                  ,CASE ");
    sb.append("                     WHEN '"+abreFilial + "' = 'N' THEN ");
    sb.append("                      NULL ");
    sb.append("                     ELSE ");
    sb.append("                      fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) ");
    sb.append("                   END ");
    sb.append("                  ,CASE ");
    sb.append("                     WHEN '"+f.getAbrir_fatura() + "' = 'N' THEN ");
    sb.append("                      NULL ");
    sb.append("                     ELSE ");
    sb.append("                      p.ped_invoice ");
    sb.append("                   END ");
    sb.append("                  ,d.unm_codigo) qry ");
    sb.append("      ,dom_ordem_compra            o ");
    sb.append("      ,dom_item_ordem_compra       dio ");
    sb.append("      ,dom_nota_entrada_ord_compra dneo ");
    sb.append("      ,rem_ped                     rp ");
    sb.append("      ,brio.ordem_compra_remessa   ocr ");
    if (f.getImportados().equals("S") || informouPeriodoImportacao) {
      sb.append("   ,rdo.dom_item_estoque_cst_imp d ");
    }
    sb.append(" WHERE o.numero = dio.oco_numero ");
    sb.append("   AND dio.oco_numero = dneo.oco_numero ");
    sb.append("   AND dio.sequencia = dneo.ioc_sequencia ");
    if (f.getImportados().equals("S") || informouPeriodoImportacao) {
      sb.append("    AND  d.ies_codigo = qry.ies_codigo ");
      sb.append("    AND d.cor_cdgo = qry.cor_cdgo ");
      sb.append("    AND d.tai_codigo = qry.tai_codigo ");
      if (informouPeriodoImportacao) {
        if (f.getDt_inicial_importacao() != "") {
          sb.append(" AND d.data_ultimo_entrada >= to_date('"+f.getDt_inicial_importacao() + "','dd/mm/yyyy') ");
        }
        if (f.getDt_final_importacao() != "") {
          sb.append(" AND d.data_ultimo_entrada < to_date('"+f.getDt_final_importacao() + "','dd/mm/yyyy')+1 ");
        }
      }
    }
    sb.append("   AND o.for_codigo = dneo.edo_empresa ");
    sb.append("   AND o.fen_seq = dneo.edo_filial ");
    sb.append("   AND dio.ies_codigo = qry.ies_codigo ");
    sb.append("   AND dio.cor_cdgo = qry.cor_cdgo ");
    sb.append("   AND dio.tai_codigo = qry.tai_codigo ");
    sb.append("   AND rp.ped_nmro = qry.ped_nmro ");
    sb.append("   AND rp.rem_nro = ocr.rem_nro ");
    sb.append("   AND ocr.oco_numero = dneo.oco_numero ");
    sb.append("   AND ocr.ioc_sequencia = dneo.ioc_sequencia ");
    sb.append("   AND dio.oco_numero(+) = ocr.oco_numero ");
    sb.append("   AND dio.sequencia(+) = ocr.ioc_sequencia ");
    sb.append(" GROUP BY qry.ies_codigo ");
    sb.append("         ,pck_item_estoque.get_nome(qry.ies_codigo) ");
    sb.append("         ,qry.cor_cdgo ");
    sb.append("         ,pck_cor.get_nome(qry.cor_cdgo) ");
    sb.append("         ,qry.tai_codigo ");
    sb.append("         ,qry.fil_filial ");
    sb.append("         ,qry.ped_invoice ");
    sb.append("         ,qry.unm_codigo ");
    sb.append("         ,qry.ncm ");
    sb.append("         ,dio.oco_numero ");
    sb.append("         ,dio.preco_unitario ");
    sb.append("         ,dneo.nfe_numero ");
    sb.append("         ,dneo.nfe_serie ");
    sb.append("         ,dneo.edo_empresa ");
    sb.append("         ,pck_fornecedor.get_nome(dneo.edo_empresa) ");
    sb.append(" ORDER BY fil_filial ");
    sb.append("        , ped_invoice ");
    sb.append("        , ies_codigo ");
    sb.append("        , descricao ");
    sb.append("        , cor_cdgo ");
    sb.append("        , cor_desc ");
    sb.append("        , tai_codigo ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }


    StringBuilder sbf = new StringBuilder();
    sbf.append(" SELECT LPAD(numero_fatura_proforma, 4, 0) || '/' || ano_fatura_proforma fatura ");
    sbf.append("       ,(SELECT SUM(quantidade_pares) ");
    sbf.append("          FROM itens_faturas_proformas i ");
    sbf.append("         WHERE i.ano_fatura_proforma = qr.ano_fatura_proforma ");
    sbf.append("           AND i.numero_fatura_proforma = qr.numero_fatura_proforma ");
    sbf.append("           AND i.empresa_fatura_proforma = qr.empresa_fatura_proforma) pares ");
    sbf.append("   FROM (SELECT DISTINCT ii.empresa_fatura_proforma ");
    sbf.append("                        ,ii.numero_fatura_proforma ");
    sbf.append("                        ,ii.ano_fatura_proforma ");
    sbf.append("                        ,ii.numero_item_fatura_proforma ");
    sbf.append("           FROM ite ii ");
    sbf.append("          WHERE ii.ped_nmro IN (SELECT DISTINCT ped_nmro ");
    sbf.append("                                  FROM (SELECT ped.ped_nmro ");
    sbf.append("                                              ,NVL(DECODE(d.cor, 'S', cc.cor_mater), 0) cor_cdgo ");
    sbf.append("                                              ,CASE ");
    sbf.append("                                                 WHEN (NVL(d.tamanho, 'N') = 'S') THEN ");
    sbf.append("                                                  fct_converte_tamanho(DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro), q.qtp_nume) ");
    sbf.append("                                                 ELSE ");
    sbf.append("                                                  '0' ");
    sbf.append("                                               END AS tai_codigo ");
    sbf.append("                                              ,DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro) ies_codigo ");
    sbf.append("                                          FROM ped ");
    sbf.append("                                              ,ite i ");
    sbf.append("                                              ,qtd_prg q ");
    sbf.append("                                              ,ficha_tec f ");
    sbf.append("                                              ,componente c ");
    sbf.append("                                              ,cor_compo cc ");
    sbf.append("                                              ,dom_item_estoque d ");
    sbf.append("                                              ,pecas p ");
    sbf.append("                                         WHERE q.ped_nmro = i.ped_nmro ");
    sbf.append("                                           AND q.ite_seqn = i.ite_seqn ");
    sbf.append("                                           AND q.qtp_pars > 0 ");
    sbf.append("                                           AND i.ped_nmro = ped.ped_nmro ");
    sbf.append("                                           AND f.lin_cdgo = NVL(i.lin_cdgo, NULL) ");
    sbf.append("                                           AND f.ref_cdgo = NVL(i.ref_cdgo, NULL) ");
    sbf.append("                                           AND f.cab_cdgo = NVL(i.cab_cdgo, NULL) ");
    sbf.append("                                           AND f.fit_versao = fct_ficha_versao(i.lin_cdgo, i.ref_cdgo, i.cab_cdgo, ped.emp_empresa, fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn)) ");
    sbf.append("                                           AND f.emp_empresa = NVL(ped.emp_empresa, f.emp_empresa) ");
    sbf.append("                                           AND c.lin_cdgo = f.lin_cdgo ");
    sbf.append("                                           AND c.ref_cdgo = f.ref_cdgo ");
    sbf.append("                                           AND c.cab_cdgo = f.cab_cdgo ");
    sbf.append("                                           AND c.com_destin = 'I' ");
    sbf.append("                                           AND c.fit_versao = f.fit_versao ");
    sbf.append("                                           AND d.codigo = c.mat_nro ");
    sbf.append("                                           AND cc.lin_cdgo(+) = c.lin_cdgo ");
    sbf.append("                                           AND cc.ref_cdgo(+) = c.ref_cdgo ");
    sbf.append("                                           AND cc.cab_cdgo(+) = c.cab_cdgo ");
    sbf.append("                                           AND ((NVL(d.cor, 'N') = 'N' AND cc.cor_ref IS NULL) OR (cc.cor_ref = i.cor_cdgo)) ");
    sbf.append("                                           AND cc.com_seq(+) = c.com_seq ");
    sbf.append("                                           AND cc.com_nivel(+) = c.com_nivel ");
    sbf.append("                                           AND cc.fit_versao(+) = c.fit_versao ");
    sbf.append("                                           AND ((NVL(d.tamanho, 'N') = 'N') OR (EXISTS (SELECT NULL ");
    sbf.append("                                                                                          FROM dom_tamanho_item_corresponde t ");
    sbf.append("                                                                                         WHERE t.ies_codigo = DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro) ");
    sbf.append("                                                                                           AND NVL(t.tai_codigo2, NULL) = q.qtp_nume))) ");
    sbf.append("                                           AND p.codigo = c.cod_peca ");
    if (informouFatura) {
      sbf.append("         AND ped.ped_invoice  = lpad('"+f.getNumero_fatura() + "',4,0)||'/'||'"+f.getAno_fatura() + "' ");
      sbf.append("         AND nvl(ped.emp_empresa,NULL) = '"+f.getEmp_empresa() + "' ");
    }
    if (informouPeriodo) {
      sbf.append("         AND ped.ped_dadg >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
      sbf.append("         AND ped.ped_dadg < TO_date('"+f.getDt_final() + "','dd/mm/yyyy')+1 ");
    }
    sbf.append("                                           AND NVL(ped.ped_tipo, NULL) = 'EX' ");
    sbf.append("                                           AND NVL(ped.ped_stat, NULL) <> 'C' ");


    sbf.append("  AND NVL(ped.ped_especie_pedido, NULL) <> 'R' ");
    sbf.append("  AND pck_pedidos.get_origem_pedido(ped.ped_nmro) <> 'ESTRATEGICO' ");
    if (gruposMateriais != null) {
      sbf.append(gruposMateriais);
    }
    if (abreFilial.equals("S")) {
      sbf.append("         AND nvl(fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn),null) = '"+f.getFil_filial() + "' ");
    }
    sbf.append("                                        UNION ");
    sbf.append("                                        SELECT p.ped_nmro ");
    sbf.append("                                              ,0 AS cor_cdgo ");
    sbf.append("                                              ,'0' tai_codigo ");
    sbf.append("                                              ,d.codigo ies_codigo ");
    sbf.append("                                          FROM ped p ");
    sbf.append("                                              ,ite i ");
    sbf.append("                                              ,dom_item_estoque d ");
    sbf.append("                                         WHERE p.ped_nmro = i.ped_nmro ");
    sbf.append("                                           AND d.codigo = fct_corrugado(i.lin_cdgo, i.ref_cdgo, p.ped_tipo_corrugado, i.codigo_corrugado) ");
    if (informouFatura) {
      sbf.append("         AND p.ped_invoice  = lpad('"+f.getNumero_fatura() + "',4,0)||'/'||'"+f.getAno_fatura() + "' ");
      sbf.append("         AND nvl(p.emp_empresa,NULL) = '"+f.getEmp_empresa() + "' ");
    }
    if (informouPeriodo) {
      sbf.append("         AND p.ped_dadg >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
      sbf.append("         AND p.ped_dadg < TO_date('"+f.getDt_final() + "','dd/mm/yyyy')+1 ");
    }
    sbf.append("                                           AND NVL(p.ped_tipo, NULL) = 'EX' ");
    sbf.append("                                           AND NVL(p.ped_stat, NULL) <> 'C' ");
    sbf.append("                                           AND NVL(p.ped_especie_pedido, NULL) <> 'R' ");
    if (gruposMateriais != null) {
      sbf.append(gruposMateriais);
    }
    if (abreFilial.equals("S")) {
      sbf.append("         AND nvl(fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn),null) = '"+f.getFil_filial() + "' ");
    }
    sbf.append("                                           AND pck_pedidos.get_origem_pedido(p.ped_nmro) <> 'ESTRATEGICO') qry ");
    if (f.getImportados().equals("S")) {
      sbf.append("                                   ,rdo.dom_item_estoque_cst_imp d ");
      sbf.append("                              WHERE d.ies_codigo = qry.ies_codigo ");
      sbf.append("                                AND d.cor_cdgo = qry.cor_cdgo ");
      sbf.append("                                AND d.tai_codigo = qry.tai_codigo ");
    }
    sbf.append(" )) qr ");
    sbf.append("  GROUP BY LPAD(numero_fatura_proforma, 4, 0) || '/' || ano_fatura_proforma ");
    sbf.append("          ,qr.ano_fatura_proforma ");
    sbf.append("          ,qr.numero_fatura_proforma ");
    sbf.append("          ,qr.empresa_fatura_proforma ");
    sbf.append("  ORDER BY 1 ");


    StringBuilder sbp = new StringBuilder();
    if ((f.getCb_considerar_pp() + "").equalsIgnoreCase("S")) {
      sbp.append("SELECT qry.ies_codigo Material, ");
      sbp.append("       pck_item_estoque.get_nome(qry.ies_codigo) descricao, ");
      sbp.append("       qry.cor_cdgo cor, ");
      sbp.append("       pck_cor.get_nome(qry.cor_cdgo) DESCRICAO_COR, ");
      sbp.append("       qry.tai_codigo tamanho, ");
      sbp.append("       SUM(qry.consumo) consumo, ");
      sbp.append("       qry.unm_codigo UNIDADE_DE_MEDIDA ");
      sbp.append("  FROM (SELECT ped.ped_nmro, ");
      sbp.append("               ped.emp_empresa, ");
      sbp.append("               CASE ");
      sbp.append("                 WHEN 'N' = 'N' THEN ");
      sbp.append("                  NULL ");
      sbp.append("                 ELSE ");
      sbp.append("                  fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) ");
      sbp.append("               END fil_filial, ");
      sbp.append("               CASE ");
      sbp.append("                 WHEN 'N' = 'N' THEN ");
      sbp.append("                  NULL ");
      sbp.append("                 ELSE ");
      sbp.append("                  ped.ped_invoice ");
      sbp.append("               END ped_invoice, ");
      sbp.append("               c.set_cdgo, ");
      sbp.append("               p.codigo cod_peca, ");
      sbp.append("               p.descricao desc_peca, ");
      sbp.append("               fct_grupo_material(DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro)) gpo_material, ");
      sbp.append("               i.lin_cdgo, ");
      sbp.append("               i.ref_cdgo, ");
      sbp.append("               NVL(DECODE(d.cor, 'S', cc.cor_mater), 0) cor_cdgo, ");
      sbp.append("               CASE ");
      sbp.append("                 WHEN (NVL(d.tamanho, 'N') = 'S') THEN ");
      sbp.append("                  fct_converte_tamanho(DECODE(d.cor, ");
      sbp.append("                                              'S', ");
      sbp.append("                                              cc.mat_nro, ");
      sbp.append("                                              c.mat_nro), ");
      sbp.append("                                       q.qtp_nume) ");
      sbp.append("                 ELSE ");
      sbp.append("                  '0' ");
      sbp.append("               END AS tai_codigo, ");
      sbp.append("               p.cmp_cdgo, ");
      sbp.append("               DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro) ies_codigo, ");
      sbp.append("               'PE' origem, ");
      sbp.append("               SUM((i.ite_qtde / ");
      sbp.append("                   (SELECT SUM(q1.qtp_pars) ");
      sbp.append("                       FROM qtd_prg q1 ");
      sbp.append("                      WHERE q1.ped_nmro = i.ped_nmro ");
      sbp.append("                        AND q1.ite_seqn = i.ite_seqn) * q.qtp_pars) * ");
      sbp.append("                   c.com_consum) AS consumo, ");
      sbp.append("               SUM(CASE ");
      sbp.append("                     WHEN (p.cmp_cdgo = 49) THEN ");
      sbp.append("                      (1.37 / p.conver * (.97 * (q.qtp_pars * c.com_consum))) / ");
      sbp.append("                      DECODE(d.unm_codigo, 'M2', 1.37, 1) ");
      sbp.append("                     ELSE ");
      sbp.append("                      NULL ");
      sbp.append("                   END) comprimento, ");
      sbp.append("               d.unm_codigo ");
      sbp.append("          FROM ped, ");
      sbp.append("               ite              i, ");
      sbp.append("               qtd_prg          q, ");
      sbp.append("               ficha_tec        f, ");
      sbp.append("               componente       c, ");
      sbp.append("               cor_compo        cc, ");
      sbp.append("               dom_item_estoque d, ");
      sbp.append("               pecas            p ");
      sbp.append("         WHERE q.ped_nmro = i.ped_nmro ");
      sbp.append("           AND q.ite_seqn = i.ite_seqn ");
      sbp.append("           AND q.qtp_pars > 0 ");
      sbp.append("           AND i.ped_nmro = ped.ped_nmro ");
      sbp.append("           AND f.lin_cdgo = NVL(i.lin_cdgo, NULL) ");
      sbp.append("           AND f.ref_cdgo = NVL(i.ref_cdgo, NULL) ");
      sbp.append("           AND f.cab_cdgo = NVL(i.cab_cdgo, NULL) ");
      sbp.append("           AND f.fit_versao = ");
      sbp.append("               fct_ficha_versao(i.lin_cdgo, ");
      sbp.append("                                i.ref_cdgo, ");
      sbp.append("                                i.cab_cdgo, ");
      sbp.append("                                ped.emp_empresa, ");
      sbp.append("                                fct_retorna_fil_producao(i.ped_nmro, ");
      sbp.append("                                                         i.ite_seqn)) ");
      sbp.append("           AND f.emp_empresa = NVL(ped.emp_empresa, f.emp_empresa) ");
      sbp.append("           AND c.lin_cdgo = f.lin_cdgo ");
      sbp.append("           AND c.ref_cdgo = f.ref_cdgo ");
      sbp.append("           AND c.cab_cdgo = f.cab_cdgo ");
      sbp.append("           AND c.com_destin = 'I' ");
      sbp.append("           AND c.fit_versao = f.fit_versao ");
      sbp.append("           AND d.codigo = c.mat_nro ");
      sbp.append("           AND cc.lin_cdgo(+) = c.lin_cdgo ");
      sbp.append("           AND cc.ref_cdgo(+) = c.ref_cdgo ");
      sbp.append("           AND cc.cab_cdgo(+) = c.cab_cdgo ");
      sbp.append("           AND ((NVL(d.cor, 'N') = 'N' AND cc.cor_ref IS NULL) OR ");
      sbp.append("               (cc.cor_ref = i.cor_cdgo)) ");
      sbp.append("           AND cc.com_seq(+) = c.com_seq ");
      sbp.append("           AND cc.com_nivel(+) = c.com_nivel ");
      sbp.append("           AND cc.fit_versao(+) = c.fit_versao ");
      sbp.append("           AND ((NVL(d.tamanho, 'N') = 'N') OR ");
      sbp.append("               (EXISTS ");
      sbp.append("                (SELECT NULL ");
      sbp.append("                    FROM dom_tamanho_item_corresponde t ");
      sbp.append("                   WHERE t.ies_codigo = ");
      sbp.append("                         DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro) ");
      sbp.append("                     AND NVL(t.tai_codigo2, NULL) = q.qtp_nume))) ");
      sbp.append("           AND p.codigo = c.cod_peca ");
      sbp.append("           AND ped.ped_invoice = LPAD('"+f.getNumero_fatura() + "', 4, 0) || '/' || '"+f.getAno_fatura() + "' ");
      sbp.append("           AND NVL(ped.emp_empresa, NULL) = '"+f.getEmp_empresa() + "' ");
      sbp.append("           AND NVL(ped.ped_tipo, NULL) = 'EX' ");
      sbp.append("           AND NVL(ped.ped_stat, NULL) <> 'C' ");
      sbp.append("         GROUP BY ped.ped_nmro, ");
      sbp.append("                  ped.emp_empresa, ");
      sbp.append("                  c.set_cdgo, ");
      sbp.append("                  p.codigo, ");
      sbp.append("                  p.descricao, ");
      sbp.append("                  fct_grupo_material(DECODE(d.cor, ");
      sbp.append("                                            'S', ");
      sbp.append("                                            cc.mat_nro, ");
      sbp.append("                                            c.mat_nro)), ");
      sbp.append("                  i.lin_cdgo, ");
      sbp.append("                  i.ref_cdgo, ");
      sbp.append("                  DECODE(d.cor, 'S', cc.mat_nro, c.mat_nro), ");
      sbp.append("                  NVL(DECODE(d.cor, 'S', cc.cor_mater), 0), ");
      sbp.append("                  CASE ");
      sbp.append("                    WHEN (NVL(d.tamanho, 'N') = 'S') THEN ");
      sbp.append("                     fct_converte_tamanho(DECODE(d.cor, ");
      sbp.append("                                                 'S', ");
      sbp.append("                                                 cc.mat_nro, ");
      sbp.append("                                                 c.mat_nro), ");
      sbp.append("                                          q.qtp_nume) ");
      sbp.append("                    ELSE ");
      sbp.append("                     '0' ");
      sbp.append("                  END, ");
      sbp.append("                  p.cmp_cdgo, ");
      sbp.append("                  CASE ");
      sbp.append("                    WHEN 'N' = 'N' THEN ");
      sbp.append("                     NULL ");
      sbp.append("                    ELSE ");
      sbp.append("                     fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) ");
      sbp.append("                  END, ");
      sbp.append("                  CASE ");
      sbp.append("                    WHEN 'N' = 'N' THEN ");
      sbp.append("                     NULL ");
      sbp.append("                    ELSE ");
      sbp.append("                     ped.ped_invoice ");
      sbp.append("                  END, ");
      sbp.append("                  d.unm_codigo ");
      sbp.append("        UNION ALL ");
      sbp.append("        SELECT p.ped_nmro, ");
      sbp.append("               p.emp_empresa, ");
      sbp.append("               CASE ");
      sbp.append("                 WHEN 'N' = 'N' THEN ");
      sbp.append("                  NULL ");
      sbp.append("                 ELSE ");
      sbp.append("                  fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) ");
      sbp.append("               END fil_filial, ");
      sbp.append("               CASE ");
      sbp.append("                 WHEN 'N' = 'N' THEN ");
      sbp.append("                  NULL ");
      sbp.append("                 ELSE ");
      sbp.append("                  p.ped_invoice ");
      sbp.append("               END ped_invoice, ");
      sbp.append("               'EXPED' set_cdgo, ");
      sbp.append("               105 cod_peca, ");
      sbp.append("               'CORRUGADO' desc_peca, ");
      sbp.append("               2 grupo_material, ");
      sbp.append("               i.lin_cdgo, ");
      sbp.append("               i.ref_cdgo, ");
      sbp.append("               0 AS cor_cdgo, ");
      sbp.append("               '0' tai_codigo, ");
      sbp.append("               46 AS cmp_cdgo, ");
      sbp.append("               d.codigo ies_codigo, ");
      sbp.append("               'PE' origem, ");
      sbp.append("               SUM(fct_calcula_volumes_ped(p.ped_nmro, i.ite_seqn)) consumo, ");
      sbp.append("               SUM(NULL) comprimento, ");
      sbp.append("               d.unm_codigo ");
      sbp.append("          FROM ped p, ite i, dom_item_estoque d ");
      sbp.append("         WHERE p.ped_nmro = i.ped_nmro ");
      sbp.append("           AND d.codigo = fct_corrugado(i.lin_cdgo, ");
      sbp.append("                                        i.ref_cdgo, ");
      sbp.append("                                        p.ped_tipo_corrugado, ");
      sbp.append("                                        i.codigo_corrugado) ");
      sbp.append("           AND p.ped_invoice = LPAD('"+f.getNumero_fatura() + "', 4, 0) || '/' || '"+f.getAno_fatura() + "' ");
      sbp.append("           AND NVL(p.emp_empresa, NULL) = '"+f.getEmp_empresa() + "' ");
      sbp.append("           AND NVL(p.ped_tipo, NULL) = 'EX' ");
      sbp.append("           AND NVL(p.ped_stat, NULL) <> 'C' ");
      sbp.append("         GROUP BY p.ped_nmro, ");
      sbp.append("                  p.emp_empresa, ");
      sbp.append("                  i.lin_cdgo, ");
      sbp.append("                  i.ref_cdgo, ");
      sbp.append("                  d.codigo, ");
      sbp.append("                  CASE ");
      sbp.append("                    WHEN 'N' = 'N' THEN ");
      sbp.append("                     NULL ");
      sbp.append("                    ELSE ");
      sbp.append("                     fct_retorna_fil_producao(i.ped_nmro, i.ite_seqn) ");
      sbp.append("                  END, ");
      sbp.append("                  CASE ");
      sbp.append("                    WHEN 'N' = 'N' THEN ");
      sbp.append("                     NULL ");
      sbp.append("                    ELSE ");
      sbp.append("                     p.ped_invoice ");
      sbp.append("                  END, ");
      sbp.append("                  d.unm_codigo) qry, ");
      sbp.append("       rdo.dom_item_estoque_cst_imp d ");
      sbp.append(" WHERE d.ies_codigo = qry.ies_codigo ");
      sbp.append("   AND d.cor_cdgo = qry.cor_cdgo ");
      sbp.append("   AND d.tai_codigo = qry.tai_codigo ");
      sbp.append(" GROUP BY qry.ies_codigo, ");
      sbp.append("          pck_item_estoque.get_nome(qry.ies_codigo), ");
      sbp.append("          qry.cor_cdgo, ");
      sbp.append("          pck_cor.get_nome(qry.cor_cdgo), ");
      sbp.append("          qry.tai_codigo, ");
      sbp.append("          qry.unm_codigo ");
      sbp.append(" ORDER BY qry.ies_codigo, ");
      sbp.append("          descricao, ");
      sbp.append("          qry.cor_cdgo, ");
      sbp.append("          'DESCRICAO COR', ");
      sbp.append("          qry.tai_codigo ");

    }


    Vector res_Jw_necessidade_materiais_faturas = null;
    Vector res_Jw_necessidade_materiais_pp = null;


    if (f.getAbrir_fatura().equalsIgnoreCase("N")) {
      if (!informouFatura) {
        res_Jw_necessidade_materiais_faturas = j.select(tablef, sbf.toString(), null);
        session.setAttribute("res_Jw_necessidade_materiais_faturas",res_Jw_necessidade_materiais_faturas);
      }
    }

    if ((f.getCb_considerar_pp() + "").equalsIgnoreCase("S")) {
      res_Jw_necessidade_materiais_pp = j.select(tablepp, sbp.toString(), null);
      session.setAttribute("res_Jw_necessidade_materiais_pp",res_Jw_necessidade_materiais_pp);

      if (!(res_Jw_necessidade_materiais_pp != null && res_Jw_necessidade_materiais_pp.size() > 0)) {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_necessidade_materiais_pp", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
    }


    if (!(f.getCb_considerar_pp() + "").equalsIgnoreCase("S")) {
      Vector res_Jw_necessidade_materiais = j.select(table, sb.toString(), null);
      session.setAttribute("res_Jw_necessidade_materiais",res_Jw_necessidade_materiais);
      if (!(res_Jw_necessidade_materiais != null && res_Jw_necessidade_materiais.size() > 0)) {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_necessidade_materiais", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      }
    }




    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      NecessidadeMateriaisActionForm f = (NecessidadeMateriaisActionForm) form;
      session.removeAttribute("res_Jw_necessidade_materiais");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      tg_resetfull_action(mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_necessidade_materiais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      NecessidadeMateriaisActionForm f = (NecessidadeMateriaisActionForm) form;
      session.removeAttribute("res_Jw_necessidade_materiais_faturas");
      session.removeAttribute("grupos_selecionados");
      session.removeAttribute("codigos_grupos_selecionados");
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
      NecessidadeMateriaisActionForm f = (NecessidadeMateriaisActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_necessidade_materiais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_resetgrupos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      NecessidadeMateriaisActionForm f = (NecessidadeMateriaisActionForm) form;
      session.removeAttribute("grupos_selecionados");
      session.removeAttribute("codigos_grupos_selecionados");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_necessidade_materiais", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
