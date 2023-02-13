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
 * Creation Date 30/09/2015 15:38:18
 * Last Modify Date 21/09/2021 13:59:32
 */

public class NecessidadeInsumosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      NecessidadeInsumosActionForm f = (NecessidadeInsumosActionForm) form;
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/NecessidadeInsumos_rGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    NecessidadeInsumosActionForm f = (NecessidadeInsumosActionForm) form;
    session.removeAttribute("necessidade_insumos_primeiro_nivel");
    session.removeAttribute("parametro_necessidade_insumos_fornecedor");
    session.removeAttribute("parametro_necessidade_insumos_grupo_material");
    session.removeAttribute("parametro_necessidade_insumos_material");
    session.removeAttribute("parametro_necessidade_insumos_cor");
    session.removeAttribute("parametro_necessidade_insumos_filial");
    session.removeAttribute("parametro_necessidade_insumos_data_inicial");
    session.removeAttribute("parametro_necessidade_insumos_data_final");

    if (f.getData_inicial().equals("__/__/____")) {
      f.setData_inicial("");
    }
    if (f.getData_final().equals("__/__/____")) {
      f.setData_final("");
    }
    if ((f.getData_inicial().equals("") || f.getData_final().equals("")) && f.getNumero().equals("")) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }
    Object[][] where = { {"numero","=", com.egen.util.text.FormatNumber.toInteger(f.getNumero())}, {"data_compra",">=", com.egen.util.text.FormatDate.parseDate(f.getData_inicial(), "dd/MM/yyyy")}, {"data_compra","<=", com.egen.util.text.FormatDate.parseDate(f.getData_final(), "dd/MM/yyyy")}, {"fil_filial","like", f.getFil_filial().toUpperCase()}, {"forn_codigo","=", com.egen.util.text.FormatNumber.toInteger(f.getForn_codigo())} };

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT d.numero ");
    sb.append("      , d.data_compra ");
    sb.append("      , d.emp_empresa ");
    sb.append("      , d.fil_filial ");
    sb.append("      , d.unn_codigo ");
    sb.append("      , NVL(d.for_codigo, NULL) forn_codigo ");
    sb.append("      , d.fen_seq ");
    sb.append("      , d.cpg_codigo ");
    sb.append("      , d.com_codigo ");
    sb.append("      , d.situacao ");
    sb.append("      , d.tra_cdgo ");
    sb.append("      , f.for_razsoc forn_razsoc ");
    sb.append("      , d.data_compra ");
    sb.append("   FROM dom_ordem_compra          d ");
    sb.append("      , fornecedor                f ");
    sb.append("      , fornecedor_parametros_edi fpe ");
    sb.append("  WHERE f.for_codigo = d.for_codigo ");
    sb.append("    AND fpe.for_codigo = f.for_codigo ");
    if (f.getNumero() != "") {
      sb.append(" AND d.numero = " + f.getNumero());
    }
    if (f.getForn_codigo() != "") {
      sb.append(" AND d.for_codigo = " + f.getForn_codigo());
    }
    if (f.getFil_filial() != "") {
      sb.append(" AND NVL(d.fil_filial, NULL) = '"+f.getFil_filial() + "' ");
    }
    if (f.getData_inicial() != "") {
      sb.append(" AND data_compra >= to_date('"+f.getData_inicial() + "', 'dd/mm/yyyy') ");
    }
    if (f.getData_final() != "") {
      sb.append(" AND data_compra <= to_date('"+f.getData_final() + "', 'dd/mm/yyyy') ");
    }
    if (f.getGpo_mater_cdgo() != "" || f.getCodigo_material() != "" || f.getCor_cdgo() != "") {
      sb.append("    AND NVL(d.situacao, NULL) <> 9 ");
      sb.append("    AND EXISTS (SELECT 1 ");
      sb.append("                  FROM dom_item_ordem_compra dioc ");
      sb.append("                     , componente_composicao cc ");
      sb.append("                 WHERE dioc.ies_codigo = cc.ies_codigo ");
      sb.append("                   AND dioc.cor_cdgo = cc.cor_cdgo ");
      if (f.getGpo_mater_cdgo() != "") {
        sb.append("                AND fct_grupo_material(dioc.ies_codigo) = ").append(f.getGpo_mater_cdgo());
      }
      if (f.getCodigo_material() != "") {
        sb.append("                AND cc.mat_nro = ").append(f.getCodigo_material());
      }
      if (f.getCor_cdgo() != "") {
        sb.append("                AND cc.cor_mater = ").append(f.getCor_cdgo());
      }
      sb.append("                   AND dioc.oco_numero = d.numero) ");
    }

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }
    session.setAttribute("necessidade_insumos_primeiro_nivel", f.getSomente_primeiro_nivel());
    if (f.getForn_codigo() != "") {
      session.setAttribute("parametro_necessidade_insumos_fornecedor",f.getForn_codigo());
    }
    if (f.getGpo_mater_cdgo() != "") {
      session.setAttribute("parametro_necessidade_insumos_grupo_material",f.getGpo_mater_cdgo());
    }
    if (f.getCodigo_material() != "") {
      session.setAttribute("parametro_necessidade_insumos_material",f.getCodigo_material());
    }
    if (f.getCor_cdgo() != "") {
      session.setAttribute("parametro_necessidade_insumos_cor",f.getCor_cdgo());
    }
    if (f.getFil_filial() != "") {
      session.setAttribute("parametro_necessidade_insumos_filial",f.getFil_filial());
    }
    if (f.getData_inicial() != "") {
      session.setAttribute("parametro_necessidade_insumos_data_inicial",f.getData_inicial());
    }
    if (f.getData_final() != "") {
      session.setAttribute("parametro_necessidade_insumos_data_final",f.getData_final());
    }
    session.setAttribute("where", sb.toString());
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      NecessidadeInsumosActionForm f = (NecessidadeInsumosActionForm) form;
      tg_resetfull_action(mapping, form, request, response);
      session.removeAttribute("res_Jw_dom_ordem_compra");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      NecessidadeInsumosActionForm f = (NecessidadeInsumosActionForm) form;
      session.removeAttribute("necessidade_insumos_primeiro_nivel");
      session.removeAttribute("parametro_necessidade_insumos_fornecedor");
      session.removeAttribute("parametro_necessidade_insumos_grupo_material");
      session.removeAttribute("parametro_necessidade_insumos_material");
      session.removeAttribute("parametro_necessidade_insumos_cor");
      session.removeAttribute("parametro_necessidade_insumos_filial");
      session.removeAttribute("parametro_necessidade_insumos_data_inicial");
      session.removeAttribute("parametro_necessidade_insumos_data_final");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

}
