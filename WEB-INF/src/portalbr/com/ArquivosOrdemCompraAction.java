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
 * Creation Date 19/08/2015 15:21:08
 * Last Modify Date 18/07/2022 16:42:11
 */

public class ArquivosOrdemCompraAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ArquivosOrdemCompraActionForm f = (ArquivosOrdemCompraActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/com/ArquivosOrdemCompra_rGrid.do?select_action=",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ArquivosOrdemCompraActionForm f = (ArquivosOrdemCompraActionForm) form;
    Jw_arquivos_ordem_compra table = new Jw_arquivos_ordem_compra();
    boolean informouParametro = false;
    if (f.getDt_inicial().equals("__/__/____")) {
      f.setDt_inicial("");
    }
    if (f.getDt_final().equals("__/__/____")) {
      f.setDt_final("");
    }
    if (f.getDt_entrega_inicial().equals("__/__/____")) {
      f.setDt_entrega_inicial("");
    }
    if (f.getDt_entrega_final().equals("__/__/____")) {
      f.setDt_entrega_final("");
    }

    if (f.getOco_numero() != "") {
      informouParametro = true;
    }
    if (f.getRem_nro() != "") {
      informouParametro = true;
    }
    if (f.getDt_inicial() != "" && f.getDt_final() != "") {
      informouParametro = true;
    }
    if (f.getDt_entrega_inicial() != "" && f.getDt_entrega_final() != "") {
      informouParametro = true;
    }
    if (!informouParametro) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }
    String amostra = "";
    if (f.getCb_somente_amostra() != null && f.getCb_somente_amostra().equalsIgnoreCase("1")) {
      amostra = "S";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT forn_codigo ");
    sb.append("      , interface_arq_compra_id ");
    sb.append("      , oco_numero ");
    sb.append("      , fil_filial ");
    sb.append("      , data_emissao ");
    sb.append("      , cond_pagto ");
    sb.append("      , arquivo_edi ");
    sb.append("      , nvl(situacao,'C') situacao ");
    sb.append("      , descricao_situacao ");
    sb.append("      , data_entrega ");
    sb.append("      , forn_razsoc ");
    sb.append("      , rem_nro ");
    sb.append("      , visualizado ");
    sb.append("      , amostra ");
    sb.append("      , lin_cdgo ");
    sb.append("      , data_entrega_fornecedor ");
    sb.append("      , situacao_ordem_compra ");
    sb.append("   FROM (SELECT DISTINCT iac.for_codigo forn_codigo ");
    sb.append("                       , iao.interface_arq_compra_id ");
    sb.append("                       , iao.oco_numero ");
    sb.append("                       , iao.fil_filial ");
    sb.append("                       , iao.data_compra data_emissao ");
    sb.append("                       , iao.cond_pagto ");
    sb.append("                       , iac.nome_arquivo arquivo_edi ");
    sb.append("                                    ,(SELECT situacao ");
    sb.append("                                        FROM (SELECT situacao ");
    sb.append("                                                FROM edi.interface_arq_compra_oc_log i ");
    sb.append("                                               where i.interface_arq_compra_id = iao.interface_arq_compra_id ");
    sb.append("                                                 and i.oco_numero = iao.oco_numero ");
    sb.append("                                               ORDER BY DECODE(situacao, 'P', 1, 'C', 2, 'G', 3, 'V', 4) DESC) ");
    sb.append("                                       WHERE rownum = 1) situacao ");
    sb.append("                       , DECODE(iao.situacao, 'P', 'Publicado', 'C', 'Consultado', 'G', 'Gerado', 'B', 'Baixado', 'V', 'Visualizado', '') descricao_situacao ");
    sb.append("                       , MIN(iao.data_entrega) data_entrega ");
    sb.append("                       , pck_fornecedor.get_nome(iac.for_codigo) forn_razsoc ");
    sb.append("                       , iao.rem_nro ");
    sb.append("                       , CASE ");
    sb.append("                           WHEN NVL(iao.situacao, 'XXX') <> 'V' THEN ");
    sb.append("                            'N' ");
    sb.append("                           ELSE ");
    sb.append("                            'S' ");
    sb.append("                         END visualizado ");
    sb.append("                       , CASE WHEN((substr(r.lote, length(r.lote), 1) = 'A')or(pck_compras_amostra.get_eh_compra_amostra(iao.oco_numero) = 'S')) THEN 'S' ELSE 'N' END amostra ");
    sb.append("                       , r.lin_cdgo ");
    sb.append("                       , iao.data_entrega_fornecedor ");
    sb.append("                       , doc.situacao situacao_ordem_compra ");
    sb.append("           FROM interface_arq_compra_oc iao ");
    sb.append("              , interface_arq_compra    iac ");
    sb.append("              , dom_ordem_compra        doc ");
    sb.append("              , remessa                 r ");
    sb.append("          WHERE iac.interface_arq_compra_id = iao.interface_arq_compra_id ");
    sb.append("            AND NVL(iac.ativo, NULL) = 'S' ");
    sb.append("            AND NVL(iac.tipo, NULL) = 'O' ");
    sb.append("            AND doc.numero = iao.oco_numero ");
    if (f.getGpo_mater_cdgo() != "") {
      sb.append("         AND EXISTS (SELECT 1 ");
      sb.append("                       FROM dom_grupo_material dgm ");
      sb.append("                      WHERE dgm.gpo_mater_cdgo = " + f.getGpo_mater_cdgo());
      sb.append("                        AND dgm.gpo_mater_desc = trim(iao.desc_grupo_material)) ");
    }
    sb.append("            AND r.rem_nro(+) = iao.rem_nro ");
    sb.append("            AND NVL(doc.situacao, NULL) <> 9 ");
    sb.append("          GROUP BY iac.for_codigo ");
    sb.append("                 , iao.interface_arq_compra_id ");
    sb.append("                 , iao.oco_numero ");
    sb.append("                 , iao.fil_filial ");
    sb.append("                 , iao.data_compra ");
    sb.append("                 , iao.cond_pagto ");
    sb.append("                 , iac.nome_arquivo ");
    sb.append("                 , iao.situacao ");
    sb.append("                 , iao.rem_nro ");
    sb.append("                 , r.lote ");
    sb.append("                 , r.lin_cdgo ");
    sb.append("                 , iao.data_entrega_fornecedor ");
    sb.append("                 , doc.situacao ");
    sb.append("          ORDER BY data_entrega) ");
    sb.append(" WHERE 1=1 ");
    if (f.getDt_inicial() != "") {
      sb.append(" AND data_emissao >= to_date('"+f.getDt_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getDt_final() != "") {
      sb.append(" AND data_emissao <= to_date('"+f.getDt_final() + "','dd/mm/yyyy') ");
    }
    if (f.getDt_entrega_inicial() != "") {
      sb.append(" AND data_entrega>= to_date('"+f.getDt_entrega_inicial() + "','dd/mm/yyyy') ");
    }
    if (f.getDt_entrega_final() != "") {
      sb.append(" AND data_entrega<= to_date('"+f.getDt_entrega_final() + "','dd/mm/yyyy') ");
    }
    if (f.getForn_codigo() != "") {
      sb.append(" AND forn_codigo = " + f.getForn_codigo());
    }
    if (f.getFil_filial() != "") {
      sb.append(" AND nvl(fil_filial, null) = '"+f.getFil_filial() + "' ");
    }
    if (f.getLin_cdgo() != "") {
      sb.append(" AND lin_cdgo = " + f.getLin_cdgo());
    }

    if (f.getSituacao().equalsIgnoreCase("NV")) {
      sb.append(" AND nvl(situacao,'C') <> 'V' ");
    } else {
      if (f.getSituacao() != "") {
        sb.append(" AND nvl(situacao,'C') = '"+f.getSituacao() + "' ");
      }
    }

    if (f.getOco_numero() != "") {
      sb.append(" AND oco_numero = " + f.getOco_numero());
    }

    if (f.getCb_somente_amostra() != null && f.getCb_somente_amostra().equalsIgnoreCase("1")) {
      sb.append(" AND amostra = 'S' ");
    }

    if (f.getRem_nro() != "") {
      sb.append(" and rem_nro = " + f.getRem_nro());
    }


    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }
    session.setAttribute("where", sb.toString());
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ArquivosOrdemCompraActionForm f = (ArquivosOrdemCompraActionForm) form;
      session.removeAttribute("res_Jw_arquivos_ordem_compra");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_arquivos_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
