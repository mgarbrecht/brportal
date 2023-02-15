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
 * Creation Date 10/04/2007 12:28:57
 * Last Modify Date 15/02/2023 11:32:30
 */

public class ConsultaRomaneiosEmbarqueEDIAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      ConsultaRomaneiosEmbarqueEDIActionForm f = (ConsultaRomaneiosEmbarqueEDIActionForm) form;
      select_action(j, mapping, form, request, response);
      tg_select_action(mapping, form, request, response);
      actionForward = new ActionForward("/com/ConsultaRomaneiosEmbarqueEDI_rForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_romaneios_embarque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaRomaneiosEmbarqueEDIActionForm f = (ConsultaRomaneiosEmbarqueEDIActionForm) form;
    portalbr.dbobj.view.Jw_romaneios_embarque table = new portalbr.dbobj.view.Jw_romaneios_embarque();

    if ((f.getData_emissao() == "") && (f.getRomaneio() == "") && (f.getTra_cdgo() == "") && (f.getFil_filial() == "") && (f.getNfs_nmro() == "")) {
      throw new Exception("Um dos par&#257;metros deve ser informado!");
    }

    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT DISTINCT ");
    sb.append("        re.emp_empresa ");
    sb.append("      , re.fil_filial ");
    sb.append("      , re.numero ");
    sb.append("      , re.data_emissao ");
    sb.append("      , re.data_finalizacao ");
    sb.append("      , re.tra_cdgo ");
    sb.append("      , t.tra_nome ");
    sb.append("      , re.fil_filial || ' - ' || f.fil_razsoc filial ");
    sb.append("      , DECODE(re.situacao, 'A', 'Aberto', 'F', 'Finalizado') situacao ");
    sb.append("      , ns.nfs_data_edi data_envio ");
    sb.append("      , re.usuario_inclusao ");
    sb.append("      , (select count(*) from nf_saida n where n.nro_romaneio_embarque = re.numero) qtde_notas ");
    sb.append("   FROM (SELECT nro_romaneio_embarque  ");
    sb.append("              , MAX(nfs_data_edi) nfs_data_edi  ");
    sb.append("           FROM nf_saida ns  ");

    if (f.getNfs_nmro() != "") {
      sb.append("          WHERE ns.nfs_nmro = " + f.getNfs_nmro());
    }

    sb.append("          GROUP BY nro_romaneio_embarque) ns  ");
    sb.append("      , romaneios_embarque re  ");
    sb.append("      , tra    t  ");
    sb.append("      , filial f  ");
    sb.append("  WHERE re.numero    = ns.nro_romaneio_embarque  ");
    sb.append("    AND re.tra_cdgo  = t.tra_cdgo  ");
    sb.append("    AND f.fil_filial = re.fil_filial  ");
    sb.append("    AND re.tra_cdgo  = t.tra_cdgo ");
    sb.append("    AND f.fil_filial = re.fil_filial ");

    if (f.getTra_cdgo() != "") {
      sb.append("    AND re.tra_cdgo  = " + f.getTra_cdgo());
    }

    if (f.getData_emissao() != "") {

      if (f.getData_emissao_final().equals("")) {
        f.setData_emissao_final(f.getData_emissao());
      }
      sb.append("    AND re.data_emissao between TO_DATE('" + f.getData_emissao() + "','DD/MM/RRRR')");
      sb.append("    AND TO_DATE('" + f.getData_emissao_final() + "','DD/MM/RRRR')");
    }

    if (f.getRomaneio() != "") {
      sb.append("    AND re.numero = " + f.getRomaneio());
    }

    if (f.getFil_filial() != "") {
      sb.append(" AND re.emp_empresa IN ('01','02') ");
      sb.append(" AND re.fil_filial = '"+f.getFil_filial() + "' ");
    }

    acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
    if (usuario.mostraQuery()) {
      throw new Exception(sb.toString());
    }

    Vector res_Jw_romaneios_embarque = j.select(table, sb.toString(), null);

    session.setAttribute("res_Jw_romaneios_embarque",res_Jw_romaneios_embarque);
    if (!(res_Jw_romaneios_embarque != null && res_Jw_romaneios_embarque.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_romaneios_embarque", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }
  private void tg_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      java.util.Vector res_Jw_romaneios_embarque = (java.util.Vector) session.getAttribute("res_Jw_romaneios_embarque");
      if (!(res_Jw_romaneios_embarque != null && res_Jw_romaneios_embarque.size() > 0)) {
        throw new Exception("Nenhum registro encontrado!");
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaRomaneiosEmbarqueEDIActionForm f = (ConsultaRomaneiosEmbarqueEDIActionForm) form;
      session.removeAttribute("res_Jw_romaneios_embarque");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_romaneios_embarque", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
