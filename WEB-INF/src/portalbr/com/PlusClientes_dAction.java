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
 * Creation Date 27/04/2006 08:57:12
 * Last Modify Date 06/03/2018 10:40:41
 */

public class PlusClientes_dAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      actionForward = new ActionForward("/com/PlusClientesForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_analisar_credito_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      PlusClientes_dActionForm f = (PlusClientes_dActionForm) form;
      actionForward = new ActionForward("/adm/AnaliseCreditoForm.do?resetfull=&cli_cdgo="+f.getCli_cdgo(), true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
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
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
    PlusClientes_dActionForm f = (PlusClientes_dActionForm) form;
    portalbr.dbobj.view.Jw_plus_clientes table = new portalbr.dbobj.view.Jw_plus_clientes();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT DISTINCT ");
    query.append("        c.cli_cdgo ");
    query.append("      , e.esc_seqn ");
    query.append("      , c.cli_rzao ");
    query.append("      , c.cli_nome ");
    query.append("      , decode(C.cli_situ,'A','Ativo','I','Inativo') cli_situ ");
    query.append("      , decode(s.esc_situacao,'A','Ativo','I','Inativo','F','Fechado') esc_situacao ");
    query.append("      , c.cli_dtin ");
    query.append("      , se.seg_desc ");
    query.append("      , decode(c.cli_exige_pc,'S','Sim','N','Não','') cli_exige_pc ");
    query.append("      , decode(C.cli_agrupa_notas,'S','Sim','N','Não','') cli_agrupa_notas ");
    query.append("      , decode(C.cli_aceita_antecipacao,'S','Sim','N','Não','') cli_aceita_antecipacao ");
    query.append("      , brio.fct_formata_cnpj(s.esc_cgc) cgc ");
    query.append("      , s.esc_inse inscricao ");
    query.append("      , e.ecl_nome||', '|| e.ecl_nmro||' - '|| substr(e.ecl_cep,1,5)||'-'|| ");
    query.append("            substr(e.ecl_cep,6,3) ender ");
    query.append("      , e.ecl_bair||' - '||e.ecl_cdad||'/'||e.est_unifed bairro_cidade ");
    query.append("      , e.ecl_cdad||' - '||e.est_unifed cid_uf ");
    query.append("   FROM ecl                               e ");
    query.append("      , cli                               c ");
    query.append("      , esc                               s ");
    query.append("      , seg                               se ");
    query.append("  WHERE e.cli_cdgo                        = s.cli_cdgo ");
    query.append("    AND e.cli_cdgo                        = c.cli_cdgo ");
    query.append("    AND e.esc_seqn                        = s.esc_seqn ");
    query.append("    AND c.seg_cdgo                        = se.seg_cdgo ");
    query.append("    AND e.cli_cdgo                        = ").append(f.getCli_cdgo());
    query.append("    AND e.esc_seqn                        = ").append(f.getEsc_seqn());
    query.append("    AND (e.ned_cdgo = 'UNI' OR e.ned_cdgo = 'ENT') ");

    Vector res_Jw_plus_clientes = j.select(table, query.toString(), null);

    session.setAttribute("res_Jw_plus_clientes",res_Jw_plus_clientes);
    if (res_Jw_plus_clientes != null && res_Jw_plus_clientes.size() > 0) {
      portalbr.dbobj.view.Jw_plus_clientes r = (portalbr.dbobj.view.Jw_plus_clientes) res_Jw_plus_clientes.elementAt(0);
      f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
      f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
      f.setCodigo(r.getCli_cdgo() + " - "+r.getEsc_seqn());
      f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
      f.setCli_nome((r.getCli_nome() != null) ? r.getCli_nome() + "":"");
      f.setSeg_desc((r.getSeg_desc() != null) ? r.getSeg_desc() + "":"");
      f.setCgc((r.getCgc() != null) ? r.getCgc() + "":"");
      f.setInscricao((r.getInscricao() != null) ? r.getInscricao() + "":"");
      f.setEnder((r.getEnder() != null) ? r.getEnder() + "":"");
      f.setBairro_cidade((r.getBairro_cidade() != null) ? r.getBairro_cidade() + "":"");
      f.setCid_uf((r.getCid_uf() != null) ? r.getCid_uf() + "":"");
      f.setCli_dtin(com.egen.util.text.FormatDate.format(r.getCli_dtin(), "dd/MM/yyyy"));
      f.setCli_situ((r.getCli_situ() != null) ? r.getCli_situ() + "":"");
      f.setEsc_situacao((r.getEsc_situacao() != null) ? r.getEsc_situacao() + "":"");
      f.setCli_exige_pc((r.getCli_exige_pc() != null) ? r.getCli_exige_pc() + "":"");
      f.setCli_agrupa_notas((r.getCli_agrupa_notas() != null) ? r.getCli_agrupa_notas() + "":"");
      f.setCli_aceita_antecipacao((r.getCli_aceita_antecipacao() != null) ? r.getCli_aceita_antecipacao() + "":"");

    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    //----------------- CONTATO/FONE DO CLIENTE ---------------------
    portalbr.dbobj.view.Jw_clientes_contatos table_contatos = new portalbr.dbobj.view.Jw_clientes_contatos();
    StringBuilder queryc = new StringBuilder();
    queryc.append(" SELECT pec_nome  ");
    queryc.append("   FROM pec  ");
    queryc.append("  WHERE cli_cdgo = ").append(f.getCli_cdgo());
    queryc.append("    AND esc_seqn = ").append(f.getEsc_seqn());

    Vector res_Jw_clientes_contatos = j.select(table_contatos, queryc.toString(), null);

    session.setAttribute("res_Jw_clientes_contatos",res_Jw_clientes_contatos);


    portalbr.dbobj.view.Jw_clientes_fones table_fones = new portalbr.dbobj.view.Jw_clientes_fones();
    StringBuilder queryf = new StringBuilder();
    queryf.append(" SELECT to_char(ffs_ddd2, '0000')||'-'||ffs_nmro2 fone  ");
    queryf.append("   FROM fax_fon2 ");
    queryf.append("  WHERE cli_cdgo  = ").append(f.getCli_cdgo());
    queryf.append("    AND esc_seqn  = ").append(f.getEsc_seqn());
    queryf.append("    AND ned_cdgo  = 'UNI' ");

    Vector res_Jw_clientes_fones = j.select(table_fones, queryf.toString(), null);

    session.setAttribute("res_Jw_clientes_fones",res_Jw_clientes_fones);
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_consultar_pedidos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.setAttribute("consulta_pedidos_back_action", "/com/PlusClientes_dForm.jsp");
      PlusClientes_dActionForm f = (PlusClientes_dActionForm) form;
      actionForward = new ActionForward("/com/ConsultaPedidos_pForm.do?select_action=&cod="+f.getCli_cdgo() + "&seqn="+f.getEsc_seqn() + "&dt_entrega="+f.getDt_entrega() + "&situacao="+f.getSituacao() + "&codigo="+f.getCodigo() + "&razao_social="+f.getCli_rzao() + "&cid_uf="+f.getCid_uf() + "&cliente=n",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }

}
