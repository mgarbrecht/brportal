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
 * Creation Date 27/04/2007 14:47:47
 * Last Modify Date 22/10/2015 14:33:24
 */

public class ConsultaRomaneiosEmbarqueEDI_nAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_romaneios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    ConsultaRomaneiosEmbarqueEDI_nActionForm f = (ConsultaRomaneiosEmbarqueEDI_nActionForm) form;
    portalbr.dbobj.view.Jw_consulta_romaneios table = new portalbr.dbobj.view.Jw_consulta_romaneios();
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT distinct n.nro_romaneio_embarque ");
    sb.append("       ,n.nfs_nmro ");
    sb.append("       ,n.nfs_serie ");
    sb.append("       ,n.nfs_dtemis ");
    sb.append("       ,n.nfs_vltot ");
    sb.append("       ,n.fil_filial ");
    sb.append("       ,n.cli_cdgo || ' - ' || cliente.cli_rzao cliente ");
    sb.append("       ,cliente.ecl_cdad cidade ");
    sb.append("       ,cliente.est_unifed uf ");
    sb.append("       ,NVL(n.nfs_qtdvol, 0) nfs_qtdvol ");
    sb.append("       ,(SELECT SUM(nfi_qtde) ");
    sb.append("           FROM nf_item i ");
    sb.append("          WHERE i.nfs_nmro = n.nfs_nmro ");
    sb.append("            AND i.nfs_serie = n.nfs_serie ");
    sb.append("            AND i.emp_empresa = n.emp_empresa ");
    sb.append("            AND i.fil_filial = n.fil_filial) nfs_total_pares ");
    sb.append("       ,NVL((SELECT NVL(cf.numero, 0) || '#' || NVL(cf.peso, 0) || '#' || ");
    sb.append("                   NVL(cf.valor_frete, 0) ");
    sb.append("              FROM conhecimentos_fretes          cf ");
    sb.append("                  ,nf_saida_conhecimentos_fretes s ");
    sb.append("             WHERE s.confrt_numero = cf.numero ");
    sb.append("               AND s.confrt_fen_for_codigo = cf.fen_for_codigo ");
    sb.append("               AND s.confrt_fen_seq = cf.fen_seq ");
    sb.append("               AND s.confrt_data_cad = cf.data_cad ");
    sb.append("               AND cf.peso IS NOT NULL ");
    sb.append("               AND s.nfs_nmro = n.nfs_nmro ");
    sb.append("               AND s.nfs_serie = n.nfs_serie ");
    sb.append("               AND s.nfs_fil_filial = n.fil_filial ");
    sb.append("               AND ROWNUM = 1), '-' || '#' || NVL(n.nfs_pesbru, 0) || '#' || ");
    sb.append("             NVL(n.nfs_frete_faturamento, 0)) conhecimentos ");
    sb.append("       ,replace(rowtocol('SELECT ped_nmro ");
    sb.append("           FROM notas_fiscais_saida_ped_venda v ");
    sb.append("          WHERE nfs_nmro = '||n.nfs_nmro||' ");
    sb.append("            AND fil_filial = '''||n.fil_filial||''' ");
    sb.append("            AND emp_empresa = '''||n.emp_empresa||''' ");
    sb.append("            AND nfs_serie = '''||n.nfs_serie||''''),',','<br>') ped_nmro ");
    sb.append("   FROM nf_saida n ");
    sb.append("       ,(SELECT a.cli_cdgo cli_cdgo_cliente ");
    sb.append("               ,a.cli_rzao ");
    sb.append("               ,c.est_unifed ");
    sb.append("               ,ecl_cdad ");
    sb.append("               ,b.esc_seqn ");
    sb.append("               ,b.cli_cdgo ");
    sb.append("           FROM cli a ");
    sb.append("               ,esc b ");
    sb.append("               ,ecl c ");
    sb.append("          WHERE b.esc_seqn = c.esc_seqn ");
    sb.append("            AND a.cli_cdgo = b.cli_cdgo ");
    sb.append("            AND b.cli_cdgo = c.cli_cdgo ");
    sb.append("            AND (c.ned_cdgo = 'UNI' OR c.ned_cdgo = 'ENT')) cliente ");
    sb.append("       ,municipios m ");
    sb.append("       ,notas_fiscais_saida_ped_venda v ");
    sb.append("  WHERE cliente.cli_cdgo_cliente = n.cli_cdgo ");
    sb.append("    AND cliente.esc_seqn = n.esc_seqn ");
    sb.append("    AND n.nro_romaneio_embarque = " + f.getNro_romaneio_embarque());
    sb.append("    AND cliente.ecl_cdad = m.descricao(+) ");
    sb.append("    AND cliente.est_unifed = m.est_unifed(+) ");
    sb.append("    AND v.nfs_nmro(+) = n.nfs_nmro ");
    sb.append("    AND v.nfs_serie(+) = n.nfs_serie ");
    sb.append("    AND v.fil_filial(+) = n.fil_filial ");
    sb.append("    AND v.emp_empresa(+) = n.emp_empresa ");
    /*  String[][] select = null;
          String[] order = null;
          String[] groupby = null;
          String[] having = null;
          Object[][] where = {
                                {"nro_romaneio_embarque","=",f.getNro_romaneio_embarque()}
                             };
          Vector res_Jw_consulta_romaneios = j.select(table, select, where, groupby, having, order);
        */
    Vector res_Jw_consulta_romaneios = j.select(table, sb.toString(), null);
    session.setAttribute("res_Jw_consulta_romaneios",res_Jw_consulta_romaneios);
    if (!(res_Jw_consulta_romaneios != null && res_Jw_consulta_romaneios.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_romaneios", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaRomaneiosEmbarqueEDI_nActionForm f = (ConsultaRomaneiosEmbarqueEDI_nActionForm) form;
      session.removeAttribute("res_Jw_consulta_romaneios");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_romaneios", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
