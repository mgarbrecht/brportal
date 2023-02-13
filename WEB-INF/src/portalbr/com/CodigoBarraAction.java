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
 * Creation Date 06/03/2006 12:09:10
 * Last Modify Date 16/10/2017 13:00:29
 */

public class CodigoBarraAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //----------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 06/03/2006
    // Objetivo          : Executa uma consulta na view portalbr.dbobj.view.Jw_cod_barra,
    //                     redirecionando para a tela de relatório:
    //                     /com/CodigoBarra_rForm.jsp
    //----------------------------------------------------------------------------------------
    // Data de Alteração :
    // Descrição         :
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/CodigoBarra_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    CodigoBarraActionForm f = (CodigoBarraActionForm) form;
    boolean informouPedido = false;
    portalbr.dbobj.view.Jw_cod_barra table = new portalbr.dbobj.view.Jw_cod_barra();
    if ((!(f.getCodigo_marca() != "")) && (!(f.getLin_cdgo() != "")) && (!(f.getPedido() != "")) && (f.getAno_fatura_proforma().equals("") || f.getNumero_fatura_proforma().equals(""))) {
      throw new Exception("Um dos campos com <img src='../img/opcional.gif' border='0'/> deve ser informado!");
    }

    if (f.getPedido() != "") {
      informouPedido = true;
    }
    StringBuilder sbq = new StringBuilder();
    StringBuilder sbp = new StringBuilder();
    if (f.getAno_fatura_proforma() != "" && f.getNumero_fatura_proforma() != "") {
      sbq.append(" ,cabedal ");
      sbq.append(" ,itens_faturas_proformas i ");
      sbp.append(" AND i.empresa_fatura_proforma = '01' ");
      sbp.append(" AND i.ano_fatura_proforma = ").append(f.getAno_fatura_proforma());
      sbp.append(" AND i.numero_fatura_proforma = ").append(f.getNumero_fatura_proforma());
      sbp.append(" AND i.codigo_linha = ref_bar.lin_cdgo ");
      sbp.append(" AND i.codigo_referencia = ref_bar.ref_cdgo ");
      sbp.append(" AND i.codigo_cabedal = ref_bar.cab_cdgo ");
      sbp.append(" AND i.codigo_cor = ref_bar.cor_cdgo ");
    } else {
      sbq.append(" ,cabedal ");
    }

    if (f.getCodigo_marca() != "") {
      sbp.append(" and mp.codigo_marca = ").append(f.getCodigo_marca());
    }
    if (f.getLin_cdgo() != "") {
      sbp.append(" and ref_cor.lin_cdgo = ").append(f.getLin_cdgo());
    }
    if (f.getCod_refer() != "") {
      sbp.append(" and ref_cor.ref_cdgo = ").append(f.getCod_refer());
    }
    if (f.getCabedal() != "") {
      sbp.append(" and ref_cor.cab_cdgo = ").append(f.getCabedal());
    }
    if (f.getCor() != "") {
      sbp.append(" and ref_cor.cor_cdgo = ").append(f.getCor());
    }
    if (f.getStatus() != "") {
      sbp.append(" and ref_status = '").append(f.getStatus()).append("'");
    }

    StringBuilder sb = new StringBuilder();
    if (informouPedido) {
      sb.append(" SELECT DISTINCT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref ");
    } else {
      sb.append(" SELECT fct_mask_modelo(ref_bar.lin_cdgo, ref_bar.ref_cdgo) linha_ref ");
    }
    sb.append("       ,ref_bar.lin_cdgo cod_linha ");
    sb.append("       ,ref_bar.ref_cdgo cod_refer ");
    sb.append("       ,ref_bar.cab_cdgo ");
    sb.append("       ,ref_bar.cor_cdgo ");
    sb.append("       ,cabedal.cab_cdgo || ' - ' || cabedal.cab_desc cabedal ");
    sb.append("       ,cor.cor_cdgo || ' - ' || cor_desc cor ");
    sb.append("       ,rfb_numero grade ");
    sb.append("       ,fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) cod_barra ");
    sb.append("       ,ref_status status ");
    sb.append("       ,mp.codigo_marca ");
    sb.append("       ,mp.descricao_marca ");
    sb.append("       ,cor.cor_desc ");
    sb.append("       ,cabedal.cab_desc ");
    sb.append("   FROM ref_bar ");
    if (informouPedido) {
      sb.append("    ,ite i ");
    }
    sb.append(sbq.toString());
    sb.append("       ,cor ");
    sb.append("       ,ref_cor ");
    sb.append("       ,REF ");
    sb.append("       ,marcas_produtos mp ");
    sb.append("  WHERE ref_bar.cab_cdgo = cabedal.cab_cdgo ");
    sb.append("    AND ref_bar.cor_cdgo = cor.cor_cdgo ");
    if (informouPedido) {
      sb.append(" AND i.lin_cdgo = ref_cor.lin_cdgo ");
      sb.append(" AND i.ref_cdgo = ref_cor.ref_cdgo ");
      sb.append(" AND i.cab_cdgo = ref_cor.cab_cdgo ");
      sb.append(" AND i.cor_cdgo = ref_cor.cor_cdgo ");
      sb.append(" AND i.ped_nmro = ").append(f.getPedido());
    }
    sb.append("    AND ref_bar.lin_cdgo = ref_cor.lin_cdgo ");
    sb.append("    AND ref_bar.ref_cdgo = ref_cor.ref_cdgo ");
    sb.append("    AND ref_bar.cab_cdgo = ref_cor.cab_cdgo ");
    sb.append("    AND ref_bar.cor_cdgo = ref_cor.cor_cdgo ");
    sb.append("    AND ref_bar.lin_cdgo = ref.lin_cdgo ");
    sb.append("    AND ref_bar.ref_cdgo = ref.ref_cdgo ");
    sb.append("    AND ref.codigo_marca = mp.codigo_marca ");
    sb.append("    AND NVL(ref_bar.ativo, NULL) IS NULL ");
    sb.append("    AND var_logistica IS NULL ");
    sb.append(sbp.toString());




    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_cod_barra = j.select(table, sb.toString(), null);

    session.setAttribute("res_Jw_cod_barra",res_Jw_cod_barra);
    if (!(res_Jw_cod_barra != null && res_Jw_cod_barra.size() > 0)) {
      throw new Exception(java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarra.erro.nenhum.registro"));
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      CodigoBarraActionForm f = (CodigoBarraActionForm) form;
      session.removeAttribute("res_Jw_cod_barra");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_cod_barra", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
