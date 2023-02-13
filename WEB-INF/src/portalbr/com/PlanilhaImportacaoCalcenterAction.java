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
 * Creation Date 11/12/2017 09:10:02
 * Last Modify Date 14/12/2017 14:11:12
 */

public class PlanilhaImportacaoCalcenterAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      PlanilhaImportacaoCalcenterActionForm f = (PlanilhaImportacaoCalcenterActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PlanilhaImportacaoCalcenterActionForm f = (PlanilhaImportacaoCalcenterActionForm) form;
    session.removeAttribute("arquivo");
    f.setPedidos(f.getPedidos().replace(" ", ""));
    String pedidos = f.getPedidos().replaceAll("[^0-9]", " ").trim();
    pedidos = pedidos.replaceAll("\\s+", " ");
    pedidos = pedidos.replaceAll(" ", "\n");
    pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");
    if ((pedidos.charAt(pedidos.length() - 1) + "").equalsIgnoreCase(",")) {
      pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
    }
    Jw_planilha_importacao_calcenter table = new Jw_planilha_importacao_calcenter();
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT NULL coluna1 ");
    sb.append("      , NULL coluna2 ");
    sb.append("      , NULL tt ");
    sb.append("      , NULL pedido_igual ");
    sb.append("      , NULL hierarquia ");
    sb.append("      , t.descricao_cabedal || ' ' || t.descricao_cor texto_material ");
    sb.append("      , 'BEIRA RI' || SUBSTR(pck_filial.get_cnpj(fct_retorna_fil_producao(ped.ped_nmro, 1)), -2, 2) nome ");
    sb.append("      , t.descricao_marca marca ");
    sb.append("      , t.linha || t.referencia referencia ");
    sb.append("      , NULL cor_base  ");
    sb.append("      , 'REDE' cluster_clima ");
    sb.append("      , CASE ");
    sb.append("          WHEN TRUNC(ped.ped_det) BETWEEN to_date('20/03/2017','dd/mm/yyyy') AND to_date('20/06/2017','dd/mm/yyyy') THEN ");
    sb.append("           'OUTONO' ");
    sb.append("          WHEN TRUNC(ped.ped_det) BETWEEN to_date('21/06/2017','dd/mm/yyyy') AND to_date('21/09/2017','dd/mm/yyyy') THEN ");
    sb.append("           'INVERNO' ");
    sb.append("          WHEN TRUNC(ped.ped_det) BETWEEN to_date('22/09/2017','dd/mm/yyyy') AND to_date('20/12/2017','dd/mm/yyyy') THEN ");
    sb.append("           'PRIMAVERA' ");
    sb.append("          WHEN TRUNC(ped.ped_det) BETWEEN to_date('21/12/2017','dd/mm/yyyy') AND to_date('19/03/2017','dd/mm/yyyy') THEN ");
    sb.append("           'VERAO' ");
    sb.append("        END epoca ");
    sb.append("      , 'CALCENTER' colecao ");
    sb.append("      , 'CORE' cvp ");
    sb.append("      , SUM(DISTINCT ROUND(ite.ite_prco, 2)) preco_compra ");
    sb.append("      , SUM(DISTINCT pck_cli0107.get_faixa_preco_de_cinco((ite.ite_prco - (ite.ite_prco * 6) / 100) * 2.3)) preco_venda ");
    sb.append("      , TO_CHAR(ped.ped_det, 'WW') semana ");
    sb.append("      , TO_CHAR(SYSDATE, 'RRRR') ano ");
    //sb.append("      , replace(fct_rows_to_row(CURSOR (SELECT DISTINCT qtp_nume ||'x'|| SUM(qtp_pars)||'#' pares ");
    //sb.append("                                          FROM qtd_prg qp ");
    //sb.append("                                         WHERE qp.ped_nmro = ped.ped_nmro ");
    //sb.append("                                         GROUP BY qtp_nume )),chr(10),'') numeracao ");
    sb.append("      , replace(rowtocol('SELECT DISTINCT qtp_nume ||''x''|| SUM(qtp_pars)||''#'' pares ");
    sb.append("                            FROM qtd_prg qp ");
    sb.append("                           WHERE qp.ped_nmro = '||ped.ped_nmro||' ");
    sb.append("                           GROUP BY qtp_nume '),',','') numeracao ");
    sb.append("      , SUM(CEIL(ite.ite_qtde / c.qt_par_corrug)) volumes ");
    sb.append("      , ecl.ecl_cdad local_entrega ");
    sb.append("      , 'PICKING TERCEIROS' forma_compra ");
    sb.append("      , 'CROSS DOCKING' cd_ou_ft ");
    sb.append("      , 'NA' promocional ");
    sb.append("        ,pck_cnd.get_nome(ped.cnd_cdgo) || ' (DT ENTRADA)' cond_pagamento ");
    sb.append("      , 'NACIONAL' importado ");
    sb.append("      , 'SIM' estoque_no_cd ");
    sb.append("      , 'S' armazenagem ");
    sb.append("      , CASE ");
    sb.append("          WHEN cpdt.bota_altura_canobota = 0 THEN ");
    sb.append("           'SEM CANO' ");
    sb.append("          WHEN cpdt.bota_altura_canobota BETWEEN 1 AND 2 THEN ");
    sb.append("           'BAIXO' ");
    sb.append("          WHEN cpdt.bota_altura_canobota BETWEEN 2.01 AND 5 THEN ");
    sb.append("           'MEDIO' ");
    sb.append("          ELSE ");
    sb.append("           'ALTO' ");
    sb.append("        END altura_do_cano ");
    sb.append("      , t.descricao_cor cor_fornecedor ");
    sb.append("      , NULL estampa  ");
    sb.append("      , NULL estilo_do_produto ");
    sb.append("      , DECODE(pck_composicao_produto.get_composicao_cab_predom(ite.lin_cdgo, ite.ref_cdgo, ite.cab_cdgo), 'TEXTIL', 'TECIDO', pck_composicao_produto.get_composicao_cab_predom(ite.lin_cdgo, ite.ref_cdgo, ite.cab_cdgo)) tipo_material ");
    sb.append("      , NULL cabedal  ");
    sb.append("      , 'CONST ' || pck_composicao_produto.get_tipo_salto(ite.lin_cdgo, ite.ref_cdgo) construcao_do_salto ");
    sb.append("      , NULL tema_colecao ");
    sb.append("      , CASE ");
    sb.append("          WHEN cpdt.altura_salto BETWEEN 0 AND 3 THEN ");
    sb.append("           'BAIXO (ATE 3CM)' ");
    sb.append("          WHEN cpdt.altura_salto BETWEEN 3.01 AND 8 THEN ");
    sb.append("           'MEDIO (3.01 A 8CM)' ");
    sb.append("          WHEN cpdt.altura_salto BETWEEN 8.01 AND 12 THEN ");
    sb.append("           'ALTO (8.01 A 12CM)' ");
    sb.append("          ELSE ");
    sb.append("           'PATA (> DE 12.01CM)' ");
    sb.append("        END altura_salto ");
    sb.append("      , '' altura_salto ");
    sb.append("      , NULL bico  ");
    sb.append("      , NULL enfeite  ");
    sb.append("      , 'SOLA ' || pck_composicao_produto.get_composicao_sola(ite.lin_cdgo, ite.ref_cdgo) material_sola ");
    sb.append("      , pck_composicao_produto.get_ncm(ite.lin_cdgo, ite.ref_cdgo, ite.cab_cdgo) ncm ");
    sb.append("      , 'PED ' || ped.ped_nmro obs ");
    sb.append("   FROM ped ");
    sb.append("      , ite ");
    sb.append("      , cat_produtos_table          t ");
    sb.append("      , corrugados                  c ");
    sb.append("      , ecl ");
    sb.append("      , cat_produtos_dados_tecnicos cpdt ");
    sb.append("  WHERE cpdt.lin_cdgo = ite.lin_cdgo ");
    sb.append("    AND cpdt.ref_cdgo = ite.ref_cdgo ");
    sb.append("    AND ped.cli_cdgo = ecl.cli_cdgo ");
    sb.append("    AND ped.esc_seqn = ecl.esc_seqn ");
    sb.append("    AND ecl.ned_cdgo IN ('ENT', 'UNI') ");
    sb.append("    AND ite.codigo_corrugado = c.codigo ");
    sb.append("    AND ped.ped_nmro = ite.ped_nmro ");
    sb.append("    AND t.linha = ite.lin_cdgo ");
    sb.append("    AND t.referencia = ite.ref_cdgo ");
    sb.append("    AND t.cabedal = ite.cab_cdgo ");
    sb.append("    AND t.cor = ite.cor_cdgo ");
    sb.append("    AND t.codigo_idioma = 3 ");
    sb.append("    AND ped.ped_nmro IN ("+pedidos + ") ");
    sb.append("  GROUP BY t.descricao_cabedal || ' ' || t.descricao_cor ");
    sb.append("         , t.descricao_marca ");
    sb.append("         , t.linha || t.referencia ");
    sb.append("         , TO_CHAR(ped.ped_det, 'WW') ");
    sb.append("         , TO_CHAR(SYSDATE, 'RRRR') ");
    sb.append("         , ecl.ecl_cdad ");
    sb.append("         , pck_cnd.get_nome(ped.cnd_cdgo) || ' (DT ENTRADA)' ");
    sb.append("         , CASE ");
    sb.append("             WHEN cpdt.bota_altura_canobota = 0 THEN ");
    sb.append("              'SEM CANO' ");
    sb.append("             WHEN cpdt.bota_altura_canobota BETWEEN 1 AND 2 THEN ");
    sb.append("              'BAIXO' ");
    sb.append("             WHEN cpdt.bota_altura_canobota BETWEEN 2.01 AND 5 THEN ");
    sb.append("              'MEDIO' ");
    sb.append("             ELSE ");
    sb.append("              'ALTO' ");
    sb.append("           END ");
    sb.append("         , t.descricao_cor ");
    sb.append("         , DECODE(pck_composicao_produto.get_composicao_cab_predom(ite.lin_cdgo, ite.ref_cdgo, ite.cab_cdgo), 'TEXTIL', 'TECIDO', pck_composicao_produto.get_composicao_cab_predom(ite.lin_cdgo, ite.ref_cdgo, ite.cab_cdgo)) ");
    sb.append("         , 'CONST ' || pck_composicao_produto.get_tipo_salto(ite.lin_cdgo, ite.ref_cdgo) ");
    sb.append("         , CASE ");
    sb.append("             WHEN cpdt.altura_salto BETWEEN 0 AND 3 THEN ");
    sb.append("              'BAIXO (ATE 3CM)' ");
    sb.append("             WHEN cpdt.altura_salto BETWEEN 3.01 AND 8 THEN ");
    sb.append("              'MEDIO (3.01 A 8CM)' ");
    sb.append("             WHEN cpdt.altura_salto BETWEEN 8.01 AND 12 THEN ");
    sb.append("              'ALTO (8.01 A 12CM)' ");
    sb.append("             ELSE ");
    sb.append("              'PATA (> DE 12.01CM)' ");
    sb.append("           END ");
    sb.append("         , 'SOLA ' || pck_composicao_produto.get_composicao_sola(ite.lin_cdgo, ite.ref_cdgo) ");
    sb.append("         , pck_composicao_produto.get_ncm(ite.lin_cdgo, ite.ref_cdgo, ite.cab_cdgo) ");
    sb.append("         , ped.ped_nmro ");
    sb.append("         , TRUNC(ped.ped_det) ");

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_planilha_importacao_calcenter = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_planilha_importacao_calcenter",res_Jw_planilha_importacao_calcenter);
    util.consultas.com.PlanilhaImportacaoCalcenter planilhaImportacaoCalcenter = new util.consultas.com.PlanilhaImportacaoCalcenter(res_Jw_planilha_importacao_calcenter, pedidos);
    String arquivo = planilhaImportacaoCalcenter.geraExcel();
    if (!arquivo.equalsIgnoreCase("")) {
      session.setAttribute("arquivo", arquivo);
    }

    if (res_Jw_planilha_importacao_calcenter != null && res_Jw_planilha_importacao_calcenter.size() > 0) {
      Jw_planilha_importacao_calcenter r = (Jw_planilha_importacao_calcenter) res_Jw_planilha_importacao_calcenter.elementAt(0);
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PlanilhaImportacaoCalcenterActionForm f = (PlanilhaImportacaoCalcenterActionForm) form;
      tg_resetfull_action(mapping, form, request, response);
      session.removeAttribute("res_Dual");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Dual", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      PlanilhaImportacaoCalcenterActionForm f = (PlanilhaImportacaoCalcenterActionForm) form;
      session.setAttribute(mapping.getName(), form);
      session.removeAttribute("arquivo");
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

}
