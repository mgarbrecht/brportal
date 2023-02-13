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
 * Creation Date 03/03/2006 17:00:05
 * Last Modify Date 22/06/2015 12:47:19
 */

public class CodigoBarraDun14Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //------------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 03/03/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_cod_barra_dum14,
    //                     após a consulta, redireciona para a tela de relatório:
    //                     /com/CodigoBarraDun14_rForm.jsp
    //------------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //------------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward ("/com/CodigoBarraDun14_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra_dum14_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    CodigoBarraDun14ActionForm f = (CodigoBarraDun14ActionForm) form;
    portalbr.dbobj.view.Jw_cod_barra_dum14 table = new portalbr.dbobj.view.Jw_cod_barra_dum14();
    if (f.getCod_linha().equals("") && (f.getAno_fatura_proforma().equals("") || f.getNumero_fatura_proforma().equals(""))) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }
    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

    StringBuilder sbq = new StringBuilder();
    StringBuilder sbp = new StringBuilder();
    if (f.getAno_fatura_proforma() != "" && f.getNumero_fatura_proforma() != "") {
      sbq.append(" ,cabedal ");
      sbq.append(" ,itens_faturas_proformas i ");
      sbp.append(" AND i.empresa_fatura_proforma = '01' ");
      sbp.append(" AND i.ano_fatura_proforma = " + f.getAno_fatura_proforma());
      sbp.append(" AND i.numero_fatura_proforma = " + f.getNumero_fatura_proforma());
      sbp.append(" AND i.codigo_linha = ref_bar.lin_cdgo ");
      sbp.append(" AND i.codigo_referencia = ref_bar.ref_cdgo ");
      sbp.append(" AND i.codigo_cabedal = ref_bar.cab_cdgo ");
      sbp.append(" AND i.codigo_cor = ref_bar.cor_cdgo ");
    } else {
      sbq.append(" ,cabedal ");
    }

    if (f.getCod_linha() != "") {
      sbp.append(" and ref_cor.lin_cdgo = " + f.getCod_linha());
    }
    if (f.getCod_refer() != "") {
      sbp.append(" and ref_cor.ref_cdgo = " + f.getCod_refer());
    }
    if (f.getCabedal() != "") {
      sbp.append(" and ref_cor.cab_cdgo = " + f.getCabedal());
    }
    if (f.getCor() != "") {
      sbp.append(" and ref_cor.cor_cdgo = " + f.getCor());
    }
    if (f.getGde_cdgo() != "") {
      sbp.append(" and ref_bar.gde_cdgo  = " + f.getGde_cdgo());
    }
    if (f.getStatus() != "") {
      sbp.append(" and ref_status = '"+f.getStatus() + "'");
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref ");
    sb.append("       ,ref_bar.lin_cdgo cod_linha ");
    sb.append("       ,ref_bar.ref_cdgo cod_refer ");
    sb.append("       ,cabedal.cab_desc cabedal ");
    sb.append("       ,cor_desc cor ");
    sb.append("       ,ref_bar.gde_cdgo ");
    sb.append("       ,qtde_pares qtd_pares ");
    sb.append("       ,TO_CHAR(codigo_barra_dum14) cod_dum14 ");
    sb.append("       ,ref_status status ");
    sb.append("       ,ref_bar.cab_cdgo ");
    sb.append("       ,ref_bar.cor_cdgo ");
    sb.append("   FROM ref_bar ");
    sb.append(sbq.toString());
    sb.append("       ,cor ");
    sb.append("       ,ref_cor ");
    sb.append("       ,REF ");
    sb.append("  WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo ");
    sb.append("    AND ref_bar.cor_cdgo = cor.cor_cdgo ");
    sb.append("    AND ref_bar.lin_cdgo = ref_cor.lin_cdgo ");
    sb.append("    AND ref_bar.ref_cdgo = ref_cor.ref_cdgo ");
    sb.append("    AND ref_bar.cab_cdgo = ref_cor.cab_cdgo ");
    sb.append("    AND ref_bar.cor_cdgo = ref_cor.cor_cdgo ");
    sb.append("    AND ref_bar.lin_cdgo = ref.lin_cdgo ");
    sb.append("    AND ref_bar.ref_cdgo = ref.ref_cdgo ");
    sb.append("    AND NVL(ref_bar.ativo, NULL) IS NULL ");
    sb.append("    AND var_logistica IS NOT NULL ");
    sb.append("    AND ref_bar.rfb_numero = '0' ");
    sb.append(sbp.toString());



    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_cod_barra_dum14 = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_cod_barra_dum14",res_Jw_cod_barra_dum14);

    if (!(res_Jw_cod_barra_dum14 != null && res_Jw_cod_barra_dum14.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      throw new Exception(java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.erro.nenhum.registro"));

    }
    session.setAttribute("mapping.getName()", form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CodigoBarraDun14ActionForm f = (CodigoBarraDun14ActionForm) form;
      session.removeAttribute("res_Jw_cod_barra_dum14");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra_dum14_1", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
