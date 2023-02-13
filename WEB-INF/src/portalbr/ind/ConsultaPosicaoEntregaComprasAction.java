package portalbr.ind;

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
 * Creation Date 23/04/2015 07:55:52
 * Last Modify Date 23/02/2016 11:23:36
 */

public class ConsultaPosicaoEntregaComprasAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPosicaoEntregaComprasActionForm f = (ConsultaPosicaoEntregaComprasActionForm) form;
      session.removeAttribute("res_Jw_consulta_posicao_entrega_compras");
      session.removeAttribute("grupos_selecionados");
      session.removeAttribute("codigos_grupos_selecionados");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_posicao_entrega_compras", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaPosicaoEntregaComprasActionForm f = (ConsultaPosicaoEntregaComprasActionForm) form;
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      actionForward = new ActionForward("/ind/ConsultaPosicaoEntregaCompras_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_posicao_entrega_compras", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    ConsultaPosicaoEntregaComprasActionForm f = (ConsultaPosicaoEntregaComprasActionForm) form;
    boolean informouPeriodo = false;
    Jw_consulta_posicao_entrega_compras table = new Jw_consulta_posicao_entrega_compras();
    StringBuilder parametros = new StringBuilder();
    if (f.getDt_entrega_inicial() != "" && f.getDt_entrega_final() != "") {
      parametros.append("         AND i.data_entrega >= to_date('"+f.getDt_entrega_inicial() + "','dd/mm/yyyy') ");
      parametros.append("         AND i.data_entrega < TO_date('"+f.getDt_entrega_final() + "','dd/mm/yyyy')+1 ");
      informouPeriodo = true;
    }
    if (f.getData_compra_inicial() != "" && f.getData_compra_final() != "") {
      parametros.append("         AND d.data_compra >= to_date('"+f.getData_compra_inicial() + "','dd/mm/yyyy') ");
      parametros.append("         AND d.data_compra < TO_date('"+f.getData_compra_final() + "','dd/mm/yyyy')+1 ");
      informouPeriodo = true;
    }
    if (f.getIes_codigo() != "") {
      parametros.append(" AND o.ies_codigo = " + f.getIes_codigo());
    }
    if (!informouPeriodo) {
      throw new Exception("Um período deve ser informado!");
    }
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT d.fil_filial ");
    sb.append("      , to_char(d.for_codigo) for_codigo ");
    sb.append("      , pck_fornecedor.get_nome(d.for_codigo) fornecedor ");
    sb.append("      , d.data_compra ");
    sb.append("      , to_char(o.ies_codigo) ies_codigo ");
    sb.append("      , pck_item_estoque.get_nome(o.ies_codigo) descricao_item ");
    sb.append("      , to_char(o.cor_cdgo) cor_cdgo ");
    sb.append("      , pck_cor.get_nome(o.cor_cdgo) cor_desc ");
    sb.append("      , i.data_entrega ");
    sb.append("      , i.quant_comprada ");
    sb.append("      , i.quant_recebida ");
    sb.append("      , o.oco_numero ");
    sb.append("      , i.quant_comprada - i.quant_recebida saldo ");
    sb.append("   FROM dom_data_entrega_item     i ");
    sb.append("      , dom_item_ordem_compra     o ");
    sb.append("      , dom_ordem_compra          d ");
    sb.append("      , dom_ordem_compra_mini_fab f ");
    sb.append("  WHERE d.numero = o.oco_numero ");
    sb.append("    AND o.oco_numero = i.oco_numero ");
    sb.append("    AND o.sequencia = i.ioc_sequencia ");
    sb.append("    AND d.numero = f.oco_numero ");
    if (session.getAttribute("codigos_grupos_selecionados") != null) {
      sb.append(" AND fct_grupo_material(o.ies_codigo) in ("+(String) session.getAttribute("codigos_grupos_selecionados") + ") ");
    } else {
      sb.append(" AND fct_grupo_material(o.ies_codigo) = 2 ");
    }
    sb.append("    AND i.quant_comprada - i.quant_recebida > 0 ");
    sb.append("    AND f.mfa_codigo IN (SELECT m.mfa_codigo ");
    sb.append("                           FROM wbrio.tipos_entidade_negocio t ");
    sb.append("                              , wbrio.entidades_negocio      en ");
    sb.append("                              , wbrio.usuarios               u ");
    sb.append("                              , dom_mini_fab_filial          m ");
    sb.append("                          WHERE t.tien_id = en.enne_tien_id ");
    sb.append("                            AND u.usua_enne_id = en.enne_id ");
    sb.append("                            AND t.tien_id = 8065 ");
    sb.append("                            AND u.usua_usuario = '"+usuario.getUsuario() + "' ");
    sb.append("                            AND en.enne_chave = m.for_codigo) ");
    sb.append("    AND i.quant_comprada <> i.quant_recebida ");
    sb.append(parametros.toString());
    sb.append("  ORDER BY i.data_entrega ");
    sb.append("         , d.for_codigo ");
    sb.append("         , d.data_compra ");

    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_consulta_posicao_entrega_compras = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_consulta_posicao_entrega_compras",res_Jw_consulta_posicao_entrega_compras);
    if (res_Jw_consulta_posicao_entrega_compras != null && res_Jw_consulta_posicao_entrega_compras.size() > 0) {
      Jw_consulta_posicao_entrega_compras r = (Jw_consulta_posicao_entrega_compras) res_Jw_consulta_posicao_entrega_compras.elementAt(0);
    } else {
      throw new Exception("Nenhum registro encontrado!");
    }
    session.setAttribute(mapping.getName(), form);
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaPosicaoEntregaComprasActionForm f = (ConsultaPosicaoEntregaComprasActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_posicao_entrega_compras", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ConsultaPosicaoEntregaComprasActionForm f = (ConsultaPosicaoEntregaComprasActionForm) form;
      session.removeAttribute("grupos_selecionados");
      session.removeAttribute("codigos_grupos_selecionados");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_posicao_entrega_compras", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
}
